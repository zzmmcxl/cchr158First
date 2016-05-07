/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.Snackbar;
import android.support.design.widget.bi;
import android.view.View;

class bb
implements bi {
    final /* synthetic */ Snackbar a;

    bb(Snackbar snackbar) {
        this.a = snackbar;
    }

    @Override
    public void a(View view, int n2, int n3, int n4, int n5) {
        Snackbar.b(this.a);
        Snackbar.c(this.a).setOnLayoutChangeListener(null);
    }
}

