/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.Snackbar;
import android.support.v4.h.du;
import android.view.View;

class be
extends du {
    boolean a;
    final /* synthetic */ int b;
    final /* synthetic */ Snackbar c;

    be(Snackbar snackbar, int n2) {
        this.c = snackbar;
        this.b = n2;
        this.a = false;
    }

    @Override
    public void a(View view) {
        if (Snackbar.d(this.c).isEnabled()) return;
        Snackbar.c(this.c).b(0, 180);
    }

    @Override
    public void b(View view) {
        Snackbar.b(this.c, this.b);
    }
}

