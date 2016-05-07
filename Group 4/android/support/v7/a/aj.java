/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.support.v4.h.bo;
import android.support.v4.h.dc;
import android.support.v4.h.dt;
import android.support.v7.a.ae;
import android.support.v7.a.ak;
import android.support.v7.widget.ActionBarContextView;
import android.view.View;
import android.widget.PopupWindow;

class aj
implements Runnable {
    final /* synthetic */ ae a;

    aj(ae ae2) {
        this.a = ae2;
    }

    @Override
    public void run() {
        this.a.o.showAtLocation((View)this.a.n, 55, 0, 0);
        ae.c(this.a);
        bo.c((View)this.a.n, 0.0f);
        this.a.q = bo.q((View)this.a.n).a(1.0f);
        this.a.q.a(new ak(this));
    }
}

