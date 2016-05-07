/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.os.Build;
import android.support.v4.h.cw;
import android.support.v4.h.cx;
import android.support.v4.h.cy;
import android.support.v4.h.cz;
import android.support.v4.h.da;
import android.view.View;
import android.view.ViewParent;

public final class cv {
    static final cx a;

    static {
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 21) {
            a = new cz();
            return;
        }
        if (n2 >= 19) {
            a = new cy();
            return;
        }
        if (n2 >= 14) {
            a = new cw();
            return;
        }
        a = new da();
    }

    public static void a(ViewParent viewParent, View view) {
        a.a(viewParent, view);
    }

    public static void a(ViewParent viewParent, View view, int n2, int n3, int n4, int n5) {
        a.a(viewParent, view, n2, n3, n4, n5);
    }

    public static void a(ViewParent viewParent, View view, int n2, int n3, int[] arrn) {
        a.a(viewParent, view, n2, n3, arrn);
    }

    public static boolean a(ViewParent viewParent, View view, float f2, float f3) {
        return a.a(viewParent, view, f2, f3);
    }

    public static boolean a(ViewParent viewParent, View view, float f2, float f3, boolean bl2) {
        return a.a(viewParent, view, f2, f3, bl2);
    }

    public static boolean a(ViewParent viewParent, View view, View view2, int n2) {
        return a.a(viewParent, view, view2, n2);
    }

    public static void b(ViewParent viewParent, View view, View view2, int n2) {
        a.b(viewParent, view, view2, n2);
    }
}

