/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.view.menu.ad;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.y;
import android.support.v7.widget.k;
import android.support.v7.widget.l;
import android.view.MenuItem;

class s
implements y {
    final /* synthetic */ k a;

    private s(k k2) {
        this.a = k2;
    }

    /* synthetic */ s(k k2, l l2) {
        this(k2);
    }

    @Override
    public void a(i i2, boolean bl2) {
        y y2;
        if (i2 instanceof ad) {
            ((ad)i2).p().a(false);
        }
        if ((y2 = this.a.a()) == null) return;
        y2.a(i2, bl2);
    }

    @Override
    public boolean a(i i2) {
        if (i2 == null) {
            return false;
        }
        this.a.h = ((ad)i2).getItem().getItemId();
        y y2 = this.a.a();
        if (y2 == null) return false;
        return y2.a(i2);
    }
}

