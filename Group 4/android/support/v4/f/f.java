/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.f;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

class f {
    private static Method a;

    static {
        try {
            a = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
            return;
        }
        catch (Exception var0) {
            throw new IllegalStateException(var0);
        }
    }

    public static String a(Locale locale) {
        try {
            Object[] arrobject = new Object[]{locale};
            return ((Locale)a.invoke(null, arrobject)).getScript();
        }
        catch (InvocationTargetException var4_3) {
            Log.w((String)"ICUCompatIcs", (Throwable)var4_3);
            return locale.getScript();
        }
        catch (IllegalAccessException var2_4) {
            Log.w((String)"ICUCompatIcs", (Throwable)var2_4);
            return locale.getScript();
        }
    }
}

