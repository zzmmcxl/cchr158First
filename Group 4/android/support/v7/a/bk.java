/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.support.v7.a.be;
import android.support.v7.view.n;
import android.view.Menu;
import android.view.View;
import android.view.Window;

class bk
extends n {
    final /* synthetic */ be a;

    public bk(be be2, Window.Callback callback) {
        this.a = be2;
        super(callback);
    }

    @Override
    public View onCreatePanelView(int n2) {
        switch (n2) {
            default: {
                return super.onCreatePanelView(n2);
            }
            case 0: 
        }
        Menu menu = be.c(this.a).r();
        if (!this.onPreparePanel(n2, null, menu)) return super.onCreatePanelView(n2);
        if (!this.onMenuOpened(n2, menu)) return super.onCreatePanelView(n2);
        return be.a(this.a, menu);
    }

    @Override
    public boolean onPreparePanel(int n2, View view, Menu menu) {
        boolean bl2 = super.onPreparePanel(n2, view, menu);
        if (!bl2) return bl2;
        if (be.b(this.a)) return bl2;
        be.c(this.a).m();
        be.a(this.a, true);
        return bl2;
    }
}

