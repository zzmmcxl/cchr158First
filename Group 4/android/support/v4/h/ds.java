/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.animation.ValueAnimator;
import android.support.v4.h.dv;
import android.view.View;

final class ds
implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ dv a;
    final /* synthetic */ View b;

    ds(dv dv2, View view) {
        this.a = dv2;
        this.b = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.a(this.b);
    }
}

