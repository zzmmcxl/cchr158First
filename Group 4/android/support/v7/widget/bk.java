/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.bj;
import android.support.v7.widget.bm;
import android.support.v7.widget.df;
import android.support.v7.widget.dk;
import android.view.View;

class bk
extends dk {
    final /* synthetic */ bm a;
    final /* synthetic */ bj b;

    bk(bj bj2, View view, bm bm2) {
        this.b = bj2;
        this.a = bm2;
        super(view);
    }

    @Override
    public df a() {
        return this.a;
    }

    @Override
    public boolean b() {
        if (bj.a(this.b).k()) return true;
        bj.a(this.b).c();
        return true;
    }
}

