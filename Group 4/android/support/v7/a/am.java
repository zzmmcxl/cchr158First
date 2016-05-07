/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.support.v7.a.ae;
import android.support.v7.a.af;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.y;
import android.view.Menu;
import android.view.Window;

final class am
implements y {
    final /* synthetic */ ae a;

    private am(ae ae2) {
        this.a = ae2;
    }

    /* synthetic */ am(ae ae2, af af2) {
        this(ae2);
    }

    @Override
    public void a(i i2, boolean bl2) {
        ae.a(this.a, i2);
    }

    @Override
    public boolean a(i i2) {
        Window.Callback callback = this.a.o();
        if (callback == null) return true;
        callback.onMenuOpened(108, (Menu)i2);
        return true;
    }
}

