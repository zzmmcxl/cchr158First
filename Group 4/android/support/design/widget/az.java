/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.Snackbar;
import android.support.design.widget.ba;
import android.support.design.widget.bh;
import android.view.View;

class az
implements bh {
    final /* synthetic */ Snackbar a;

    az(Snackbar snackbar) {
        this.a = snackbar;
    }

    @Override
    public void a(View view) {
    }

    @Override
    public void b(View view) {
        if (!this.a.a()) return;
        Snackbar.c().post((Runnable)new ba(this));
    }
}

