package android.support.v4.text;

import java.util.Locale;
import android.os.Build$VERSION;

public final class ICUCompat
{
    private static final ICUCompatImpl IMPL;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 21) {
            IMPL = (ICUCompatImpl)new ICUCompatImplLollipop();
            return;
        }
        if (sdk_INT >= 14) {
            IMPL = (ICUCompatImpl)new ICUCompatImplIcs();
            return;
        }
        IMPL = (ICUCompatImpl)new ICUCompatImplBase();
    }
    
    private ICUCompat() {
        super();
    }
    
    public static String maximizeAndGetScript(final Locale locale) {
        return IMPL.maximizeAndGetScript(locale);
    }
}
