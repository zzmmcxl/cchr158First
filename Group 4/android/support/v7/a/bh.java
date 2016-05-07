/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.support.v7.a.be;
import android.support.v7.a.bf;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.y;
import android.view.Menu;

final class bh
implements y {
    final /* synthetic */ be a;
    private boolean b;

    private bh(be be2) {
        this.a = be2;
    }

    /* synthetic */ bh(be be2, bf bf2) {
        this(be2);
    }

    @Override
    public void a(i i2, boolean bl2) {
        if (this.b) {
            return;
        }
        this.b = true;
        be.c(this.a).n();
        if (be.a(this.a) != null) {
            be.a(this.a).onPanelClosed(108, (Menu)i2);
        }
        this.b = false;
    }

    @Override
    public boolean a(i i2) {
        if (be.a(this.a) == null) return false;
        be.a(this.a).onMenuOpened(108, (Menu)i2);
        return true;
    }
}

