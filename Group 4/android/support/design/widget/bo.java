/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.bn;
import android.view.animation.Animation;

class bo
implements Animation.AnimationListener {
    final /* synthetic */ bn a;

    bo(bn bn2) {
        this.a = bn2;
    }

    public void onAnimationEnd(Animation animation) {
        if (bn.a(this.a) != animation) return;
        bn.a(this.a, null);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}

