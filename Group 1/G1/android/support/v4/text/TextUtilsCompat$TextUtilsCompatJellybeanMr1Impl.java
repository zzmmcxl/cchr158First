package android.support.v4.text;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Locale;

private static class TextUtilsCompatJellybeanMr1Impl extends TextUtilsCompatImpl
{
    private TextUtilsCompatJellybeanMr1Impl() {
        super();
    }
    
    TextUtilsCompatJellybeanMr1Impl(final TextUtilsCompat$1 object) {
        this();
    }
    
    @Override
    public int getLayoutDirectionFromLocale(@Nullable final Locale locale) {
        return TextUtilsCompatJellybeanMr1.getLayoutDirectionFromLocale(locale);
    }
    
    @NonNull
    @Override
    public String htmlEncode(@NonNull final String s) {
        return TextUtilsCompatJellybeanMr1.htmlEncode(s);
    }
}
