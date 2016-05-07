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

class cn
extends cr {
    final /* synthetic */ cp a;
    final /* synthetic */ dc b;
    final /* synthetic */ cg c;

    cn(cg cg2, cp cp2, dc dc2) {
        this.c = cg2;
        this.a = cp2;
        this.b = dc2;
        super(null);
    }

    @Override
    public void a(View view) {
        this.c.b(this.a.a, true);
    }

    @Override
    public void b(View view) {
        this.b.a((dt)null);
        bo.c(view, 1.0f);
        bo.a(view, 0.0f);
        bo.b(view, 0.0f);
        this.c.a(this.a.a, true);
        cg.h(this.c).remove(this.a.a);
        cg.e(this.c);
    }
}

