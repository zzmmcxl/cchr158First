/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.a;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.a.b;
import android.view.View;
import android.view.ViewPropertyAnimator;

class d
implements b {
    private TimeInterpolator a;

    d() {
    }

    @Override
    public void a(View view) {
        if (this.a == null) {
            this.a = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.a);
    }
}

