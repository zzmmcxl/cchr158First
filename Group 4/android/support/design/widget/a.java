/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.v4.h.b.b;
import android.support.v4.h.b.c;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

class a {
    static final Interpolator a = new LinearInterpolator();
    static final Interpolator b = new b();
    static final Interpolator c = new android.support.v4.h.b.a();
    static final Interpolator d = new c();
    static final Interpolator e = new DecelerateInterpolator();

    static float a(float f2, float f3, float f4) {
        return f2 + f4 * (f3 - f2);
    }

    static int a(int n2, int n3, float f2) {
        return n2 + Math.round(f2 * (float)(n3 - n2));
    }
}

