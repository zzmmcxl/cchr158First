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

class cm
extends cr {
    final /* synthetic */ ff a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ dc d;
    final /* synthetic */ cg e;

    cm(cg cg2, ff ff2, int n2, int n3, dc dc2) {
        this.e = cg2;
        this.a = ff2;
        this.b = n2;
        this.c = n3;
        this.d = dc2;
        super(null);
    }

    @Override
    public void a(View view) {
        this.e.l(this.a);
    }

    @Override
    public void b(View view) {
        this.d.a((dt)null);
        this.e.i(this.a);
        cg.g(this.e).remove(this.a);
        cg.e(this.e);
    }

    @Override
    public void c(View view) {
        if (this.b != 0) {
            bo.a(view, 0.0f);
        }
        if (this.c == 0) return;
        bo.b(view, 0.0f);
    }
}

