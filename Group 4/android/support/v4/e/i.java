/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.e;

import android.os.Build;
import android.support.v4.e.j;

public final class i {
    public static void a() {
        if (Build.VERSION.SDK_INT < 18) return;
        j.a();
    }

    public static void a(String string) {
        if (Build.VERSION.SDK_INT < 18) return;
        j.a(string);
    }
}

