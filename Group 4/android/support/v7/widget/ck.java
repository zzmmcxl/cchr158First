/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v4.h.bo;
import android.support.v4.h.dc;
import android.support.v4.h.dt;
import android.support.v7.widget.cg;
import android.support.v7.widget.ch;
import android.support.v7.widget.cr;
import android.support.v7.widget.ff;
import android.view.View;

class ck
extends cr {
    final /* synthetic */ ff a;
    final /* synthetic */ dc b;
    final /* synthetic */ cg c;

    ck(cg cg2, ff ff2, dc dc2) {
        this.c = cg2;
        this.a = ff2;
        this.b = dc2;
        super(null);
    }

    @Override
    public void a(View view) {
        this.c.k(this.a);
    }

    @Override
    public void b(View view) {
        this.b.a((dt)null);
        bo.c(view, 1.0f);
        this.c.h(this.a);
        cg.d(this.c).remove(this.a);
        cg.e(this.c);
    }
}

