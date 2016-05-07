/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.Snackbar;
import android.view.animation.Animation;

class bd
implements Animation.AnimationListener {
    final /* synthetic */ Snackbar a;

    bd(Snackbar snackbar) {
        this.a = snackbar;
    }

    public void onAnimationEnd(Animation animation) {
        Snackbar.e(this.a);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}

