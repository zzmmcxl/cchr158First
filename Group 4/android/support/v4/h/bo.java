/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.v4.h.a;
import android.support.v4.h.bg;
import android.support.v4.h.bp;
import android.support.v4.h.bq;
import android.support.v4.h.br;
import android.support.v4.h.bs;
import android.support.v4.h.bt;
import android.support.v4.h.bu;
import android.support.v4.h.bv;
import android.support.v4.h.bw;
import android.support.v4.h.by;
import android.support.v4.h.bz;
import android.support.v4.h.ca;
import android.support.v4.h.cb;
import android.support.v4.h.dc;
import android.support.v4.h.dw;
import android.view.View;

public final class bo {
    static final cb a;

    static {
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 23) {
            a = new ca();
            return;
        }
        if (n2 >= 21) {
            a = new bz();
            return;
        }
        if (n2 >= 19) {
            a = new by();
            return;
        }
        if (n2 >= 17) {
            a = new bw();
            return;
        }
        if (n2 >= 16) {
            a = new bv();
            return;
        }
        if (n2 >= 15) {
            a = new bt();
            return;
        }
        if (n2 >= 14) {
            a = new bu();
            return;
        }
        if (n2 >= 11) {
            a = new bs();
            return;
        }
        if (n2 >= 9) {
            a = new br();
            return;
        }
        if (n2 >= 7) {
            a = new bq();
            return;
        }
        a = new bp();
    }

    public static boolean A(View view) {
        return a.C(view);
    }

    public static float B(View view) {
        return a.D(view);
    }

    public static boolean C(View view) {
        return a.E(view);
    }

    public static boolean D(View view) {
        return a.F(view);
    }

    public static int a(int n2, int n3) {
        return a.a(n2, n3);
    }

    public static int a(int n2, int n3, int n4) {
        return a.a(n2, n3, n4);
    }

    public static int a(View view) {
        return a.a(view);
    }

    public static dw a(View view, dw dw2) {
        return a.a(view, dw2);
    }

    public static void a(View view, float f2) {
        a.a(view, f2);
    }

    public static void a(View view, int n2, int n3) {
        a.a(view, n2, n3);
    }

    public static void a(View view, int n2, int n3, int n4, int n5) {
        a.a(view, n2, n3, n4, n5);
    }

    public static void a(View view, int n2, Paint paint) {
        a.a(view, n2, paint);
    }

    public static void a(View view, ColorStateList colorStateList) {
        a.a(view, colorStateList);
    }

    public static void a(View view, PorterDuff.Mode mode) {
        a.a(view, mode);
    }

    public static void a(View view, a a2) {
        a.a(view, a2);
    }

    public static void a(View view, bg bg2) {
        a.a(view, bg2);
    }

    public static void a(View view, Runnable runnable) {
        a.a(view, runnable);
    }

    public static void a(View view, Runnable runnable, long l2) {
        a.a(view, runnable, l2);
    }

    public static void a(View view, boolean bl2) {
        a.a(view, bl2);
    }

    public static boolean a(View view, int n2) {
        return a.a(view, n2);
    }

    public static void b(View view, float f2) {
        a.b(view, f2);
    }

    public static void b(View view, boolean bl2) {
        a.b(view, bl2);
    }

    public static boolean b(View view) {
        return a.b(view);
    }

    public static boolean b(View view, int n2) {
        return a.b(view, n2);
    }

    public static void c(View view, float f2) {
        a.c(view, f2);
    }

    public static void c(View view, int n2) {
        a.c(view, n2);
    }

    public static void c(View view, boolean bl2) {
        a.c(view, bl2);
    }

    public static boolean c(View view) {
        return a.c(view);
    }

    public static void d(View view) {
        a.d(view);
    }

    public static void d(View view, float f2) {
        a.d(view, f2);
    }

    public static void d(View view, int n2) {
        a.d(view, n2);
    }

    public static int e(View view) {
        return a.e(view);
    }

    public static void e(View view, int n2) {
        a.f(view, n2);
    }

    public static float f(View view) {
        return a.f(view);
    }

    public static void f(View view, int n2) {
        a.e(view, n2);
    }

    public static int g(View view) {
        return a.g(view);
    }

    public static int h(View view) {
        return a.h(view);
    }

    public static int i(View view) {
        return a.i(view);
    }

    public static int j(View view) {
        return a.j(view);
    }

    public static int k(View view) {
        return a.k(view);
    }

    public static int l(View view) {
        return a.l(view);
    }

    public static float m(View view) {
        return a.n(view);
    }

    public static float n(View view) {
        return a.o(view);
    }

    public static int o(View view) {
        return a.p(view);
    }

    public static int p(View view) {
        return a.q(view);
    }

    public static dc q(View view) {
        return a.r(view);
    }

    public static int r(View view) {
        return a.s(view);
    }

    public static void s(View view) {
        a.t(view);
    }

    public static boolean t(View view) {
        return a.w(view);
    }

    public static void u(View view) {
        a.x(view);
    }

    public static boolean v(View view) {
        return a.m(view);
    }

    public static boolean w(View view) {
        return a.y(view);
    }

    public static ColorStateList x(View view) {
        return a.z(view);
    }

    public static PorterDuff.Mode y(View view) {
        return a.A(view);
    }

    public static void z(View view) {
        a.B(view);
    }
}

