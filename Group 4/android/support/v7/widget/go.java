/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.support.v7.view.d;
import android.support.v7.view.menu.ad;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.x;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.gl;
import android.support.v7.widget.gp;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

class go
implements x {
    i a;
    m b;
    final /* synthetic */ Toolbar c;

    private go(Toolbar toolbar) {
        this.c = toolbar;
    }

    /* synthetic */ go(Toolbar toolbar, gl gl2) {
        this(toolbar);
    }

    @Override
    public void a(Context context, i i2) {
        if (this.a != null && this.b != null) {
            this.a.d(this.b);
        }
        this.a = i2;
    }

    @Override
    public void a(i i2, boolean bl2) {
    }

    @Override
    public boolean a(ad ad2) {
        return false;
    }

    @Override
    public boolean a(i i2, m m2) {
        Toolbar.b(this.c);
        if (Toolbar.c(this.c).getParent() != this.c) {
            this.c.addView((View)Toolbar.c(this.c));
        }
        this.c.a = m2.getActionView();
        this.b = m2;
        if (this.c.a.getParent() != this.c) {
            gp gp2 = this.c.i();
            gp2.a = 8388611 | 112 & Toolbar.d(this.c);
            gp2.b = 2;
            this.c.a.setLayoutParams((ViewGroup.LayoutParams)gp2);
            this.c.addView(this.c.a);
        }
        this.c.j();
        this.c.requestLayout();
        m2.e(true);
        if (!(this.c.a instanceof d)) return true;
        ((d)this.c.a).a();
        return true;
    }

    @Override
    public void b(boolean bl2) {
        if (this.b == null) return;
        i i2 = this.a;
        boolean bl3 = false;
        if (i2 != null) {
            int n2 = this.a.size();
            int n3 = 0;
            do {
                bl3 = false;
                if (n3 >= n2) break;
                if (this.a.getItem(n3) == this.b) {
                    return;
                }
                ++n3;
            } while (true);
        }
        this.b(this.a, this.b);
    }

    @Override
    public boolean b() {
        return false;
    }

    @Override
    public boolean b(i i2, m m2) {
        if (this.c.a instanceof d) {
            ((d)this.c.a).b();
        }
        this.c.removeView(this.c.a);
        this.c.removeView((View)Toolbar.c(this.c));
        this.c.a = null;
        this.c.k();
        this.b = null;
        this.c.requestLayout();
        m2.e(false);
        return true;
    }
}

