/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

class bl {
    private static bl d;
    public long a;
    public long b;
    public int c;

    bl() {
    }

    static bl a() {
        if (d != null) return d;
        d = new bl();
        return d;
    }

    public void a(long l2, double d2, double d3) {
        float f2 = (float)(l2 - 946728000000L) / 8.64E7f;
        float f3 = 6.24006f + 0.01720197f * f2;
        double d4 = 3.141592653589793 + (1.796593063 + ((double)f3 + 0.03341960161924362 * Math.sin(f3) + 3.4906598739326E-4 * Math.sin(2.0f * f3) + 5.236000106378924E-6 * Math.sin(3.0f * f3)));
        double d5 = (- d3) / 360.0;
        double d6 = d5 + (double)(9.0E-4f + (float)Math.round((double)(f2 - 9.0E-4f) - d5)) + 0.0053 * Math.sin(f3) + -0.0069 * Math.sin(2.0 * d4);
        double d7 = Math.asin(Math.sin(d4) * Math.sin(0.4092797040939331));
        double d8 = 0.01745329238474369 * d2;
        double d9 = (Math.sin(-0.10471975803375244) - Math.sin(d8) * Math.sin(d7)) / (Math.cos(d8) * Math.cos(d7));
        if (d9 >= 1.0) {
            this.c = 1;
            this.a = -1;
            this.b = -1;
            return;
        }
        if (d9 <= -1.0) {
            this.c = 0;
            this.a = -1;
            this.b = -1;
            return;
        }
        float f4 = (float)(Math.acos(d9) / 6.283185307179586);
        this.a = 946728000000L + Math.round(8.64E7 * (d6 + (double)f4));
        this.b = 946728000000L + Math.round(8.64E7 * (d6 - (double)f4));
        if (this.b < l2 && this.a > l2) {
            this.c = 0;
            return;
        }
        this.c = 1;
    }
}

