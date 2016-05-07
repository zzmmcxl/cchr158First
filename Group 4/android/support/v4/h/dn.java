/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.support.v4.h.do;
import android.support.v4.h.dt;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;

class dn {
    public static long a(View view) {
        return view.animate().getDuration();
    }

    public static void a(View view, float f2) {
        view.animate().alpha(f2);
    }

    public static void a(View view, long l2) {
        view.animate().setDuration(l2);
    }

    public static void a(View view, dt dt2) {
        if (dt2 != null) {
            view.animate().setListener((Animator.AnimatorListener)new do(dt2, view));
            return;
        }
        view.animate().setListener(null);
    }

    public static void a(View view, Interpolator interpolator) {
        view.animate().setInterpolator((TimeInterpolator)interpolator);
    }

    public static void b(View view) {
        view.animate().cancel();
    }

    public static void b(View view, float f2) {
        view.animate().translationX(f2);
    }

    public static void b(View view, long l2) {
        view.animate().setStartDelay(l2);
    }

    public static void c(View view) {
        view.animate().start();
    }

    public static void c(View view, float f2) {
        view.animate().translationY(f2);
    }
}

