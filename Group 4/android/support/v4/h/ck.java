/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.support.v4.h.bg;
import android.support.v4.h.cl;
import android.support.v4.h.dw;
import android.support.v4.h.dx;
import android.view.View;
import android.view.WindowInsets;

class ck {
    public static dw a(View view, dw dw2) {
        if (!(dw2 instanceof dx)) return dw2;
        WindowInsets windowInsets = ((dx)dw2).f();
        WindowInsets windowInsets2 = view.onApplyWindowInsets(windowInsets);
        if (windowInsets2 == windowInsets) return dw2;
        return new dx(windowInsets2);
    }

    public static void a(View view) {
        view.requestApplyInsets();
    }

    public static void a(View view, float f2) {
        view.setElevation(f2);
    }

    static void a(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    static void a(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    public static void a(View view, bg bg2) {
        if (bg2 == null) {
            view.setOnApplyWindowInsetsListener(null);
            return;
        }
        view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener)new cl(bg2));
    }

    public static float b(View view) {
        return view.getElevation();
    }

    public static float c(View view) {
        return view.getTranslationZ();
    }

    static ColorStateList d(View view) {
        return view.getBackgroundTintList();
    }

    static PorterDuff.Mode e(View view) {
        return view.getBackgroundTintMode();
    }

    public static void f(View view) {
        view.stopNestedScroll();
    }

    public static float g(View view) {
        return view.getZ();
    }
}

