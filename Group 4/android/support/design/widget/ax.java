/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.Snackbar;
import android.view.animation.Animation;

class ax
implements Animation.AnimationListener {
    final /* synthetic */ int a;
    final /* synthetic */ Snackbar b;

    ax(Snackbar snackbar, int n2) {
        this.b = snackbar;
        this.a = n2;
    }

    public void onAnimationEnd(Animation animation) {
        Snackbar.b(this.b, this.a);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}

