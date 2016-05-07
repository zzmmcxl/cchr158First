/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.database.DataSetObserver;
import android.support.v7.widget.df;
import android.support.v7.widget.dg;

class do
extends DataSetObserver {
    final /* synthetic */ df a;

    private do(df df2) {
        this.a = df2;
    }

    /* synthetic */ do(df df2, dg dg2) {
        this(df2);
    }

    public void onChanged() {
        if (!this.a.k()) return;
        this.a.c();
    }

    public void onInvalidated() {
        this.a.i();
    }
}

