/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.support.v4.h.bo;
import android.support.v4.h.dc;
import android.support.v4.h.dt;
import android.support.v7.a.ae;
import android.support.v7.a.ao;
import android.support.v7.a.v;
import android.support.v7.view.b;
import android.support.v7.view.c;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.PopupWindow;

class an
implements c {
    final /* synthetic */ ae a;
    private c b;

    public an(ae ae2, c c2) {
        this.a = ae2;
        this.b = c2;
    }

    @Override
    public void a(b b2) {
        this.b.a(b2);
        if (this.a.o != null) {
            this.a.b.getDecorView().removeCallbacks(this.a.p);
        }
        if (this.a.n != null) {
            ae.c(this.a);
            this.a.q = bo.q((View)this.a.n).a(0.0f);
            this.a.q.a(new ao(this));
        }
        if (this.a.e != null) {
            this.a.e.b(this.a.m);
        }
        this.a.m = null;
    }

    @Override
    public boolean a(b b2, Menu menu) {
        return this.b.a(b2, menu);
    }

    @Override
    public boolean a(b b2, MenuItem menuItem) {
        return this.b.a(b2, menuItem);
    }

    @Override
    public boolean b(b b2, Menu menu) {
        return this.b.b(b2, menu);
    }
}

