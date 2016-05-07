/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.support.v7.a.be;
import android.support.v7.a.bf;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.j;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

final class bi
implements j {
    final /* synthetic */ be a;

    private bi(be be2) {
        this.a = be2;
    }

    /* synthetic */ bi(be be2, bf bf2) {
        this(be2);
    }

    @Override
    public void a(i i2) {
        if (be.a(this.a) == null) return;
        if (be.c(this.a).i()) {
            be.a(this.a).onPanelClosed(108, (Menu)i2);
            return;
        }
        if (!be.a(this.a).onPreparePanel(0, null, (Menu)i2)) return;
        be.a(this.a).onMenuOpened(108, (Menu)i2);
    }

    @Override
    public boolean a(i i2, MenuItem menuItem) {
        return false;
    }
}

