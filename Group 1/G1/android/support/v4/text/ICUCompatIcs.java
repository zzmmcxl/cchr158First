package android.support.v4.text;

import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import android.util.Log;
import java.lang.reflect.Method;

class ICUCompatIcs
{
    private static final String TAG = "ICUCompatIcs";
    private static Method sAddLikelySubtagsMethod;
    private static Method sGetScriptMethod;
    
    static {
        try {
            final Class<?> forName = Class.forName("libcore.icu.ICU");
            if (forName != null) {
                sGetScriptMethod = forName.getMethod("getScript", String.class);
                sAddLikelySubtagsMethod = forName.getMethod("addLikelySubtags", String.class);
            }
        }
        catch (Exception ex) {
            sGetScriptMethod = null;
            sAddLikelySubtagsMethod = null;
            Log.w("ICUCompatIcs", (Throwable)ex);
        }
    }
    
    ICUCompatIcs() {
        super();
    }
    
    private static String addLikelySubtags(final Locale locale) {
        final String string = locale.toString();
        try {
            if (sAddLikelySubtagsMethod != null) {
                return (String)sAddLikelySubtagsMethod.invoke(null, string);
            }
            goto Label_0048;
        }
        catch (IllegalAccessException ex) {
            Log.w("ICUCompatIcs", (Throwable)ex);
        }
        catch (InvocationTargetException ex2) {
            Log.w("ICUCompatIcs", (Throwable)ex2);
            goto Label_0048;
        }
    }
    
    private static String getScript(final String s) {
        try {
            if (sGetScriptMethod != null) {
                return (String)sGetScriptMethod.invoke(null, s);
            }
            goto Label_0041;
        }
        catch (IllegalAccessException ex) {
            Log.w("ICUCompatIcs", (Throwable)ex);
        }
        catch (InvocationTargetException ex2) {
            Log.w("ICUCompatIcs", (Throwable)ex2);
            goto Label_0041;
        }
    }
    
    public static String maximizeAndGetScript(final Locale locale) {
        final String addLikelySubtags = addLikelySubtags(locale);
        if (addLikelySubtags != null) {
            return getScript(addLikelySubtags);
        }
        return null;
    }
}
