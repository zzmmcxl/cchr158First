package android.support.v7.app;

private static class TwilightState
{
    boolean isNight;
    long nextUpdate;
    long todaySunrise;
    long todaySunset;
    long tomorrowSunrise;
    long yesterdaySunset;
    
    private TwilightState() {
        super();
    }
    
    TwilightState(final TwilightManager$1 object) {
        this();
    }
}
