/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewParent;

class ce {
    public static float a(View view) {
        return view.getAlpha();
    }

    public static int a(int n2, int n3) {
        return View.combineMeasuredStates((int)n2, (int)n3);
    }

    public static int a(int n2, int n3, int n4) {
        return View.resolveSizeAndState((int)n2, (int)n3, (int)n4);
    }

    static long a() {
        return ValueAnimator.getFrameDelay();
    }

    public static void a(View view, float f2) {
        view.setTranslationX(f2);
    }

    static void a(View view, int n2) {
        view.offsetTopAndBottom(n2);
        ViewParent viewParent = view.getParent();
        if (!(viewParent instanceof View)) return;
        ce.h((View)viewParent);
    }

    public static void a(View view, int n2, Paint paint) {
        view.setLayerType(n2, paint);
    }

    public static void a(View view, boolean bl2) {
        view.setSaveFromParentEnabled(bl2);
    }

    public static int b(View view) {
        return view.getLayerType();
    }

    public static void b(View view, float f2) {
        view.setTranslationY(f2);
    }

    static void b(View view, int n2) {
        view.offsetLeftAndRight(n2);
        ViewParent viewParent = view.getParent();
        if (!(viewParent instanceof View)) return;
        ce.h((View)viewParent);
    }

    public static void b(View view, boolean bl2) {
        view.setActivated(bl2);
    }

    public static int c(View view) {
        return view.getMeasuredWidthAndState();
    }

    public static void c(View view, float f2) {
        view.setAlpha(f2);
    }

    public static int d(View view) {
        return view.getMeasuredState();
    }

    public static float e(View view) {
        return view.getTranslationX();
    }

    public static float f(View view) {
        return view.getTranslationY();
    }

    public static void g(View view) {
        view.jumpDrawablesToCurrentState();
    }

    private static void h(View view) {
        float f2 = view.getTranslationY();
        view.setTranslationY(1.0f + f2);
        view.setTranslationY(f2);
    }
}

