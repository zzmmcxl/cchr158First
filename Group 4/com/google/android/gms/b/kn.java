/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Build;

public final class kn {
    public static boolean a() {
        return kn.a(11);
    }

    private static boolean a(int n2) {
        if (Build.VERSION.SDK_INT < n2) return false;
        return true;
    }

    public static boolean b() {
        return kn.a(13);
    }

    public static boolean c() {
        return kn.a(14);
    }

    public static boolean d() {
        return kn.a(17);
    }

    public static boolean e() {
        return kn.a(18);
    }

    public static boolean f() {
        return kn.a(19);
    }

    public static boolean g() {
        return kn.a(20);
    }

    @Deprecated
    public static boolean h() {
        return kn.i();
    }

    public static boolean i() {
        return kn.a(21);
    }
}

