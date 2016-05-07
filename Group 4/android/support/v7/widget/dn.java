/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.df;
import android.support.v7.widget.dg;

class dn
implements Runnable {
    final /* synthetic */ df a;

    private dn(df df2) {
        this.a = df2;
    }

    /* synthetic */ dn(df df2, dg dg2) {
        this(df2);
    }

    @Override
    public void run() {
        this.a.j();
    }
}

