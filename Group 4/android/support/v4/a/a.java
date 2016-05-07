/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.a;

import android.os.Build;
import android.support.v4.a.b;
import android.support.v4.a.c;
import android.support.v4.a.d;
import android.view.View;

public final class a {
    private static final b a;

    static {
        if (Build.VERSION.SDK_INT >= 12) {
            a = new d();
            return;
        }
        a = new c();
    }

    public static void a(View view) {
        a.a(view);
    }
}

