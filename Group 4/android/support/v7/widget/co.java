/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v4.h.bo;
import android.support.v4.h.dc;
import android.support.v4.h.dt;
import android.support.v7.widget.cg;
import android.support.v7.widget.ch;
import android.support.v7.widget.cp;
import android.support.v7.widget.cr;
import android.support.v7.widget.ff;
import android.view.View;

class co
extends cr {
    final /* synthetic */ cp a;
    final /* synthetic */ dc b;
    final /* synthetic */ View c;
    final /* synthetic */ cg d;

    co(cg cg2, cp cp2, dc dc2, View view) {
        this.d = cg2;
        this.a = cp2;
        this.b = dc2;
        this.c = view;
        super(null);
    }

    @Override
    public void a(View view) {
        this.d.b(this.a.b, false);
    }

    @Override
    public void b(View view) {
        this.b.a((dt)null);
        bo.c(this.c, 1.0f);
        bo.a(this.c, 0.0f);
        bo.b(this.c, 0.0f);
        this.d.a(this.a.b, false);
        cg.h(this.d).remove(this.a.b);
        cg.e(this.d);
    }
}

