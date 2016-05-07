/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.support.v4.h.bo;
import android.support.v4.h.dc;
import android.support.v4.h.dt;
import android.support.v4.h.du;
import android.support.v7.a.ae;
import android.support.v7.a.an;
import android.support.v7.widget.ActionBarContextView;
import android.view.View;
import android.view.ViewParent;
import android.widget.PopupWindow;

class ao
extends du {
    final /* synthetic */ an a;

    ao(an an2) {
        this.a = an2;
    }

    @Override
    public void b(View view) {
        this.a.a.n.setVisibility(8);
        if (this.a.a.o != null) {
            this.a.a.o.dismiss();
        } else if (this.a.a.n.getParent() instanceof View) {
            bo.s((View)this.a.a.n.getParent());
        }
        this.a.a.n.removeAllViews();
        this.a.a.q.a((dt)null);
        this.a.a.q = null;
    }
}

