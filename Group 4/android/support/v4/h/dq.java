/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.h.dt;
import android.view.View;

final class dq
extends AnimatorListenerAdapter {
    final /* synthetic */ dt a;
    final /* synthetic */ View b;

    dq(dt dt2, View view) {
        this.a = dt2;
        this.b = view;
    }

    public void onAnimationCancel(Animator animator) {
        this.a.c(this.b);
    }

    public void onAnimationEnd(Animator animator) {
        this.a.b(this.b);
    }

    public void onAnimationStart(Animator animator) {
        this.a.a(this.b);
    }
}

