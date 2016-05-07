/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v4.h.du;
import android.support.v7.widget.gs;
import android.view.View;

class gu
extends du {
    final /* synthetic */ int a;
    final /* synthetic */ gs b;
    private boolean c;

    gu(gs gs2, int n2) {
        this.b = gs2;
        this.a = n2;
        this.c = false;
    }

    @Override
    public void a(View view) {
        gs.a(this.b).setVisibility(0);
    }

    @Override
    public void b(View view) {
        if (this.c) return;
        gs.a(this.b).setVisibility(this.a);
    }

    @Override
    public void c(View view) {
        this.c = true;
    }
}

