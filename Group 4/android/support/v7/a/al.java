/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.support.v4.h.bo;
import android.support.v4.h.dc;
import android.support.v4.h.dt;
import android.support.v4.h.du;
import android.support.v7.a.ae;
import android.support.v7.widget.ActionBarContextView;
import android.view.View;
import android.view.ViewParent;

class al
extends du {
    final /* synthetic */ ae a;

    al(ae ae2) {
        this.a = ae2;
    }

    @Override
    public void a(View view) {
        this.a.n.setVisibility(0);
        this.a.n.sendAccessibilityEvent(32);
        if (this.a.n.getParent() == null) return;
        bo.s((View)this.a.n.getParent());
    }

    @Override
    public void b(View view) {
        bo.c((View)this.a.n, 1.0f);
        this.a.q.a((dt)null);
        this.a.q = null;
    }
}

