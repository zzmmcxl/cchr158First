/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.util.Log;
import java.util.Locale;

public class me {
    public static String a = "Volley";
    public static boolean b = Log.isLoggable((String)a, (int)2);

    public static /* varargs */ void a(String string, Object ... arrobject) {
        if (!b) return;
        Log.v((String)a, (String)me.d(string, arrobject));
    }

    public static /* varargs */ void a(Throwable throwable, String string, Object ... arrobject) {
        Log.e((String)a, (String)me.d(string, arrobject), (Throwable)throwable);
    }

    public static /* varargs */ void b(String string, Object ... arrobject) {
        Log.d((String)a, (String)me.d(string, arrobject));
    }

    public static /* varargs */ void c(String string, Object ... arrobject) {
        Log.e((String)a, (String)me.d(string, arrobject));
    }

    private static /* varargs */ String d(String string, Object ... arrobject) {
        String string2;
        block2 : {
            if (arrobject != null) {
                string = String.format(Locale.US, string, arrobject);
            }
            StackTraceElement[] arrstackTraceElement = new Throwable().fillInStackTrace().getStackTrace();
            for (int i2 = 2; i2 < arrstackTraceElement.length; ++i2) {
                if (arrstackTraceElement[i2].getClass().equals(me.class)) continue;
                String string3 = arrstackTraceElement[i2].getClassName();
                String string4 = string3.substring(1 + string3.lastIndexOf(46));
                String string5 = string4.substring(1 + string4.lastIndexOf(36));
                string2 = string5 + "." + arrstackTraceElement[i2].getMethodName();
                break block2;
            }
            string2 = "<unknown>";
        }
        Locale locale = Locale.US;
        Object[] arrobject2 = new Object[]{Thread.currentThread().getId(), string2, string};
        return String.format(locale, "[%d] %s: %s", arrobject2);
    }
}

