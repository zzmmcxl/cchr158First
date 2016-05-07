/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.ad;
import android.support.design.widget.ao;
import android.support.design.widget.b;
import android.support.design.widget.ct;
import android.view.animation.Animation;

class ae
extends b {
    final /* synthetic */ boolean a;
    final /* synthetic */ ao b;
    final /* synthetic */ ad c;

    ae(ad ad2, boolean bl2, ao ao2) {
        this.c = ad2;
        this.a = bl2;
        this.b = ao2;
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        ad.a(this.c, false);
        this.c.k.a(8, this.a);
        if (this.b == null) return;
        this.b.b();
    }

    @Override
    public void onAnimationStart(Animation animation) {
        ad.a(this.c, true);
    }
}

