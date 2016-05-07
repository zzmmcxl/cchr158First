/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.f;

import android.os.Build;
import android.support.v4.f.b;
import android.support.v4.f.c;
import android.support.v4.f.d;
import android.support.v4.f.e;
import java.util.Locale;

public final class a {
    private static final b a;

    static {
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 21) {
            a = new e();
            return;
        }
        if (n2 >= 14) {
            a = new d();
            return;
        }
        a = new c();
    }

    public static String a(Locale locale) {
        return a.a(locale);
    }
}

