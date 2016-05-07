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

class cl
extends cr {
    final /* synthetic */ ff a;
    final /* synthetic */ dc b;
    final /* synthetic */ cg c;

    cl(cg cg2, ff ff2, dc dc2) {
        this.c = cg2;
        this.a = ff2;
        this.b = dc2;
        super(null);
    }

    @Override
    public void a(View view) {
        this.c.m(this.a);
    }

    @Override
    public void b(View view) {
        this.b.a((dt)null);
        this.c.j(this.a);
        cg.f(this.c).remove(this.a);
        cg.e(this.c);
    }

    @Override
    public void c(View view) {
        bo.c(view, 1.0f);
    }
}

