/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.animation.ValueAnimator;
import android.support.design.widget.ca;
import android.support.design.widget.cd;

class ce
implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ ca a;
    final /* synthetic */ cd b;

    ce(cd cd2, ca ca2) {
        this.b = cd2;
        this.a = ca2;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.a();
    }
}

