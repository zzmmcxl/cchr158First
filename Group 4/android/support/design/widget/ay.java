/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.Snackbar;
import android.support.design.widget.bj;
import android.support.design.widget.bl;
import android.support.design.widget.br;
import android.view.View;

class ay
implements br {
    final /* synthetic */ Snackbar a;

    ay(Snackbar snackbar) {
        this.a = snackbar;
    }

    @Override
    public void a(int n2) {
        switch (n2) {
            default: {
                return;
            }
            case 1: 
            case 2: {
                bj.a().c(Snackbar.a(this.a));
                return;
            }
            case 0: 
        }
        bj.a().d(Snackbar.a(this.a));
    }

    @Override
    public void a(View view) {
        view.setVisibility(8);
        Snackbar.a(this.a, 0);
    }
}

