/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.support.v4.app.aj;
import android.support.v4.app.an;
import android.support.v4.app.x;
import android.view.View;
import android.view.animation.Animation;

class am
extends an {
    final /* synthetic */ x a;
    final /* synthetic */ aj b;

    am(aj aj2, View view, Animation animation, x x2) {
        this.b = aj2;
        this.a = x2;
        super(view, animation);
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        super.onAnimationEnd(animation);
        if (this.a.l == null) return;
        this.a.l = null;
        this.b.a(this.a, this.a.m, 0, 0, false);
    }
}

