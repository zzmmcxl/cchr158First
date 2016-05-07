/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v4.h.bo;
import android.support.v7.widget.df;
import android.support.v7.widget.dg;
import android.view.View;

class dr
implements Runnable {
    final /* synthetic */ df a;

    private dr(df df2) {
        this.a = df2;
    }

    /* synthetic */ dr(df df2, dg dg2) {
        this(df2);
    }

    @Override
    public void run() {
        if (df.a(this.a) == null) return;
        if (!bo.C((View)df.a(this.a))) return;
        if (df.a(this.a).getCount() <= df.a(this.a).getChildCount()) return;
        if (df.a(this.a).getChildCount() > this.a.b) return;
        df.b(this.a).setInputMethodMode(2);
        this.a.c();
    }
}

