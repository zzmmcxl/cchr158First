package android.support.v4.os;

import android.os.Build$VERSION;

public final class TraceCompat
{
    private TraceCompat() {
        super();
    }
    
    public static void beginSection(final String s) {
        if (Build$VERSION.SDK_INT >= 18) {
            TraceJellybeanMR2.beginSection(s);
        }
    }
    
    public static void endSection() {
        if (Build$VERSION.SDK_INT >= 18) {
            TraceJellybeanMR2.endSection();
        }
    }
}
