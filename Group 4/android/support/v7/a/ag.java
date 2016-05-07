/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.support.v4.h.bg;
import android.support.v4.h.bo;
import android.support.v4.h.dw;
import android.support.v7.a.ae;
import android.view.View;

class ag
implements bg {
    final /* synthetic */ ae a;

    ag(ae ae2) {
        this.a = ae2;
    }

    @Override
    public dw a(View view, dw dw2) {
        int n2;
        int n3 = dw2.b();
        if (n3 == (n2 = ae.c(this.a, n3))) return bo.a(view, dw2);
        dw2 = dw2.a(dw2.a(), n2, dw2.c(), dw2.d());
        return bo.a(view, dw2);
    }
}

