/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.content.Context;
import android.os.Build;
import android.support.v4.app.j;
import android.support.v4.app.k;
import android.support.v4.app.l;

public final class i {
    private static final l a;

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            a = new k(null);
            return;
        }
        a = new l(null);
    }

    public static int a(Context context, String string, String string2) {
        return a.a(context, string, string2);
    }

    public static String a(String string) {
        return a.a(string);
    }
}

