/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.animation.Animator;
import android.support.v4.h.dq;
import android.support.v4.h.dt;
import android.view.View;
import android.view.ViewPropertyAnimator;

class dp {
    public static void a(View view, dt dt2) {
        if (dt2 != null) {
            view.animate().setListener((Animator.AnimatorListener)new dq(dt2, view));
            return;
        }
        view.animate().setListener(null);
    }
}

