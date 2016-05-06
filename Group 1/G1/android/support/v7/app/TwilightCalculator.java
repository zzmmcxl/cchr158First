package android.support.v7.app;

class TwilightCalculator
{
    private static final float ALTIDUTE_CORRECTION_CIVIL_TWILIGHT = -0.10471976f;
    private static final float C1 = 0.0334196f;
    private static final float C2 = 3.49066E-4f;
    private static final float C3 = 5.236E-6f;
    public static final int DAY = 0;
    private static final float DEGREES_TO_RADIANS = 0.017453292f;
    private static final float J0 = 9.0E-4f;
    public static final int NIGHT = 1;
    private static final float OBLIQUITY = 0.4092797f;
    private static final long UTC_2000 = 946728000000L;
    private static TwilightCalculator sInstance;
    public int state;
    public long sunrise;
    public long sunset;
    
    TwilightCalculator() {
        super();
    }
    
    static TwilightCalculator getInstance() {
        if (sInstance == null) {
            sInstance = new TwilightCalculator();
        }
        return sInstance;
    }
    
    public void calculateTwilight(final long n, final double n2, final double n3) {
        final float n4 = (n - 946728000000L) / 8.64E7f;
        final float n5 = 6.24006f + 0.01720197f * n4;
        final double n6 = 3.141592653589793 + (1.796593063 + (n5 + 0.03341960161924362 * Math.sin(n5) + 3.4906598739326E-4 * Math.sin(2.0f * n5) + 5.236000106378924E-6 * Math.sin(3.0f * n5)));
        final double n7 = -n3 / 360.0;
        final double n8 = n7 + (9.0E-4f + Math.round((double)(n4 - 9.0E-4f) - n7)) + 0.0053 * Math.sin(n5) + -0.0069 * Math.sin(2.0 * n6);
        final double asin = Math.asin(Math.sin(n6) * Math.sin(0.4092797040939331));
        final double n9 = n2 * 0.01745329238474369;
        final double n10 = (Math.sin(-0.10471975803375244) - Math.sin(n9) * Math.sin(asin)) / (Math.cos(n9) * Math.cos(asin));
        if (n10 >= 1.0) {
            state = 1;
            sunset = -1L;
            sunrise = -1L;
            return;
        }
        if (n10 <= -1.0) {
            state = 0;
            sunset = -1L;
            sunrise = -1L;
            return;
        }
        final float n11 = (float)(Math.acos(n10) / 6.283185307179586);
        sunset = 946728000000L + Math.round(8.64E7 * (n8 + n11));
        sunrise = 946728000000L + Math.round(8.64E7 * (n8 - n11));
        if (sunrise < n && sunset > n) {
            state = 0;
            return;
        }
        state = 1;
    }
}
