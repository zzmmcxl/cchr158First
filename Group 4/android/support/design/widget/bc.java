/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.Snackbar;
import android.support.v4.h.du;
import android.view.View;

class bc
extends du {
    final /* synthetic */ Snackbar a;

    bc(Snackbar snackbar) {
        this.a = snackbar;
    }

    @Override
    public void a(View view) {
        if (Snackbar.d(this.a).isEnabled()) return;
        Snackbar.c(this.a).a(70, 180);
    }

    @Override
    public void b(View view) {
        Snackbar.e(this.a);
    }
}

