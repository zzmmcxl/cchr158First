/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.graphics.Rect;
import android.os.Build;
import android.support.v4.h.r;
import android.support.v4.h.s;
import android.support.v4.h.t;

public final class q {
    static final r a;

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            a = new t();
            return;
        }
        a = new s();
    }

    public static int a(int n2, int n3) {
        return a.a(n2, n3);
    }

    public static void a(int n2, int n3, int n4, Rect rect, Rect rect2, int n5) {
        a.a(n2, n3, n4, rect, rect2, n5);
    }
}

