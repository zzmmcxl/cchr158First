/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.f;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

class g {
    private static Method a;
    private static Method b;

    static {
        try {
            Class class_ = Class.forName("libcore.icu.ICU");
            if (class_ == null) return;
            a = class_.getMethod("getScript", String.class);
            b = class_.getMethod("addLikelySubtags", String.class);
            return;
        }
        catch (Exception var0_1) {
            a = null;
            b = null;
            Log.w((String)"ICUCompatIcs", (Throwable)var0_1);
            return;
        }
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    private static String a(String string) {
        try {
            if (a == null) return null;
            Object[] arrobject = new Object[]{string};
            return (String)a.invoke(null, arrobject);
        }
        catch (IllegalAccessException var3_3) {
            Log.w((String)"ICUCompatIcs", (Throwable)var3_3);
        }
        return null;
        catch (InvocationTargetException invocationTargetException) {
            Log.w((String)"ICUCompatIcs", (Throwable)invocationTargetException);
            return null;
        }
    }

    public static String a(Locale locale) {
        String string = g.b(locale);
        if (string == null) return null;
        return g.a(string);
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    private static String b(Locale locale) {
        String string = locale.toString();
        try {
            if (b == null) return string;
            Object[] arrobject = new Object[]{string};
            return (String)b.invoke(null, arrobject);
        }
        catch (IllegalAccessException var4_4) {
            Log.w((String)"ICUCompatIcs", (Throwable)var4_4);
        }
        return string;
        catch (InvocationTargetException invocationTargetException) {
            Log.w((String)"ICUCompatIcs", (Throwable)invocationTargetException);
            return string;
        }
    }
}

