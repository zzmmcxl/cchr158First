/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.design.widget.aj;
import android.support.design.widget.ao;
import android.support.design.widget.ct;

class al
extends AnimatorListenerAdapter {
    final /* synthetic */ boolean a;
    final /* synthetic */ ao b;
    final /* synthetic */ aj c;

    al(aj aj2, boolean bl2, ao ao2) {
        this.c = aj2;
        this.a = bl2;
        this.b = ao2;
    }

    public void onAnimationEnd(Animator animator) {
        if (this.b == null) return;
        this.b.a();
    }

    public void onAnimationStart(Animator animator) {
        this.c.k.a(0, this.a);
    }
}

