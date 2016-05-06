package android.support.v4.text;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Build$VERSION;
import java.util.Locale;

public final class TextUtilsCompat
{
    private static String ARAB_SCRIPT_SUBTAG;
    private static String HEBR_SCRIPT_SUBTAG;
    private static final TextUtilsCompatImpl IMPL;
    public static final Locale ROOT;
    
    static {
        if (Build$VERSION.SDK_INT >= 17) {
            IMPL = (TextUtilsCompatImpl)new TextUtilsCompatJellybeanMr1Impl();
        }
        else {
            IMPL = new TextUtilsCompatImpl();
        }
        ROOT = new Locale("", "");
        ARAB_SCRIPT_SUBTAG = "Arab";
        HEBR_SCRIPT_SUBTAG = "Hebr";
    }
    
    private TextUtilsCompat() {
        super();
    }
    
    static /* synthetic */ String access$000() {
        return ARAB_SCRIPT_SUBTAG;
    }
    
    static /* synthetic */ String access$100() {
        return HEBR_SCRIPT_SUBTAG;
    }
    
    public static int getLayoutDirectionFromLocale(@Nullable final Locale locale) {
        return IMPL.getLayoutDirectionFromLocale(locale);
    }
    
    @NonNull
    public static String htmlEncode(@NonNull final String s) {
        return IMPL.htmlEncode(s);
    }
}
