/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.design.widget.aj;
import android.support.design.widget.ao;
import android.support.design.widget.ct;

class ak
extends AnimatorListenerAdapter {
    final /* synthetic */ boolean a;
    final /* synthetic */ ao b;
    final /* synthetic */ aj c;
    private boolean d;

    ak(aj aj2, boolean bl2, ao ao2) {
        this.c = aj2;
        this.a = bl2;
        this.b = ao2;
    }

    public void onAnimationCancel(Animator animator) {
        aj.a(this.c, false);
        this.d = true;
    }

    public void onAnimationEnd(Animator animator) {
        aj.a(this.c, false);
        if (this.d) return;
        this.c.k.a(8, this.a);
        if (this.b == null) return;
        this.b.b();
    }

    public void onAnimationStart(Animator animator) {
        aj.a(this.c, true);
        this.d = false;
        this.c.k.a(0, this.a);
    }
}

