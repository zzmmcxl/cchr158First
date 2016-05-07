/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.support.v7.a.ae;
import android.support.v7.a.af;
import android.support.v7.a.aq;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.y;
import android.view.Menu;
import android.view.Window;

final class ar
implements y {
    final /* synthetic */ ae a;

    private ar(ae ae2) {
        this.a = ae2;
    }

    /* synthetic */ ar(ae ae2, af af2) {
        this(ae2);
    }

    @Override
    public void a(i i2, boolean bl2) {
        aq aq2;
        i i3 = i2.p();
        boolean bl3 = i3 != i2;
        ae ae2 = this.a;
        if (bl3) {
            i2 = i3;
        }
        if ((aq2 = ae.a(ae2, (Menu)i2)) == null) return;
        if (bl3) {
            ae.a(this.a, aq2.a, aq2, i3);
            ae.a(this.a, aq2, true);
            return;
        }
        ae.a(this.a, aq2, bl2);
    }

    @Override
    public boolean a(i i2) {
        if (i2 != null) return true;
        if (!this.a.h) return true;
        Window.Callback callback = this.a.o();
        if (callback == null) return true;
        if (this.a.n()) return true;
        callback.onMenuOpened(108, (Menu)i2);
        return true;
    }
}

