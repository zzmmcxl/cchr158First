/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.view.View;

class ch {
    public static void a(View view, int n2) {
        view.setImportantForAccessibility(n2);
    }

    public static void a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void a(View view, Runnable runnable, long l2) {
        view.postOnAnimationDelayed(runnable, l2);
    }

    public static boolean a(View view) {
        return view.hasTransientState();
    }

    public static void b(View view) {
        view.postInvalidateOnAnimation();
    }

    public static int c(View view) {
        return view.getImportantForAccessibility();
    }

    public static int d(View view) {
        return view.getMinimumWidth();
    }

    public static int e(View view) {
        return view.getMinimumHeight();
    }

    public static void f(View view) {
        view.requestFitSystemWindows();
    }

    public static boolean g(View view) {
        return view.getFitsSystemWindows();
    }

    public static boolean h(View view) {
        return view.hasOverlappingRendering();
    }
}

