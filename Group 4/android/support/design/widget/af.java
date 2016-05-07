/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.ad;
import android.support.design.widget.ao;
import android.support.design.widget.b;
import android.view.animation.Animation;

class af
extends b {
    final /* synthetic */ ao a;
    final /* synthetic */ ad b;

    af(ad ad2, ao ao2) {
        this.b = ad2;
        this.a = ao2;
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (this.a == null) return;
        this.a.a();
    }
}

