/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.support.v7.a.be;
import android.support.v7.a.bf;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.y;
import android.view.Menu;

final class bj
implements y {
    final /* synthetic */ be a;

    private bj(be be2) {
        this.a = be2;
    }

    /* synthetic */ bj(be be2, bf bf2) {
        this(be2);
    }

    @Override
    public void a(i i2, boolean bl2) {
        if (be.a(this.a) == null) return;
        be.a(this.a).onPanelClosed(0, (Menu)i2);
    }

    @Override
    public boolean a(i i2) {
        if (i2 != null) return true;
        if (be.a(this.a) == null) return true;
        be.a(this.a).onMenuOpened(0, (Menu)i2);
        return true;
    }
}

