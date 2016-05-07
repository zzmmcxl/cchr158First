/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

class ax {
    public static Object a(Context context, Interpolator interpolator) {
        if (interpolator == null) return new OverScroller(context);
        return new OverScroller(context, interpolator);
    }

    public static void a(Object object, int n2, int n3, int n4, int n5) {
        ((OverScroller)object).startScroll(n2, n3, n4, n5);
    }

    public static void a(Object object, int n2, int n3, int n4, int n5, int n6) {
        ((OverScroller)object).startScroll(n2, n3, n4, n5, n6);
    }

    public static void a(Object object, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        ((OverScroller)object).fling(n2, n3, n4, n5, n6, n7, n8, n9);
    }

    public static void a(Object object, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11) {
        ((OverScroller)object).fling(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11);
    }

    public static boolean a(Object object) {
        return ((OverScroller)object).isFinished();
    }

    public static boolean a(Object object, int n2, int n3, int n4, int n5, int n6, int n7) {
        return ((OverScroller)object).springBack(n2, n3, n4, n5, n6, n7);
    }

    public static int b(Object object) {
        return ((OverScroller)object).getCurrX();
    }

    public static int c(Object object) {
        return ((OverScroller)object).getCurrY();
    }

    public static boolean d(Object object) {
        return ((OverScroller)object).computeScrollOffset();
    }

    public static void e(Object object) {
        ((OverScroller)object).abortAnimation();
    }

    public static int f(Object object) {
        return ((OverScroller)object).getFinalX();
    }

    public static int g(Object object) {
        return ((OverScroller)object).getFinalY();
    }
}

