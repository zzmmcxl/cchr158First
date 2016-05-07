/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.f;

import android.os.Build;
import android.support.v4.f.i;
import android.support.v4.f.j;
import android.support.v4.f.k;
import java.util.Locale;

public final class h {
    public static final Locale a;
    private static final j b;
    private static String c;
    private static String d;

    static {
        b = Build.VERSION.SDK_INT >= 17 ? new k(null) : new j(null);
        a = new Locale("", "");
        c = "Arab";
        d = "Hebr";
    }

    public static int a(Locale locale) {
        return b.a(locale);
    }

    static /* synthetic */ String a() {
        return c;
    }

    static /* synthetic */ String b() {
        return d;
    }
}

