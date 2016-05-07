/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.support.v4.h.dv;
import android.support.v7.a.bp;
import android.view.View;
import android.view.ViewParent;

class bs
implements dv {
    final /* synthetic */ bp a;

    bs(bp bp2) {
        this.a = bp2;
    }

    @Override
    public void a(View view) {
        ((View)bp.c(this.a).getParent()).invalidate();
    }
}

