/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.database.DataSetObserver;
import android.support.v4.widget.m;
import android.support.v4.widget.n;

class p
extends DataSetObserver {
    final /* synthetic */ m a;

    private p(m m2) {
        this.a = m2;
    }

    /* synthetic */ p(m m2, n n2) {
        this(m2);
    }

    public void onChanged() {
        this.a.a = true;
        this.a.notifyDataSetChanged();
    }

    public void onInvalidated() {
        this.a.a = false;
        this.a.notifyDataSetInvalidated();
    }
}

