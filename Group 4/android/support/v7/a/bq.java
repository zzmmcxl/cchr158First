/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.support.v4.h.bo;
import android.support.v4.h.du;
import android.support.v7.a.bp;
import android.view.View;

class bq
extends du {
    final /* synthetic */ bp a;

    bq(bp bp2) {
        this.a = bp2;
    }

    @Override
    public void b(View view) {
        if (bp.a(this.a) && bp.b(this.a) != null) {
            bo.b(bp.b(this.a), 0.0f);
            bo.b((View)bp.c(this.a), 0.0f);
        }
        bp.c(this.a).setVisibility(8);
        bp.c(this.a).setTransitioning(false);
        bp.a(this.a, null);
        this.a.i();
        if (bp.d(this.a) == null) return;
        bo.s((View)bp.d(this.a));
    }
}

