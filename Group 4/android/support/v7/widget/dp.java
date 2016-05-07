/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.df;
import android.support.v7.widget.dg;
import android.view.View;
import android.widget.AbsListView;

class dp
implements AbsListView.OnScrollListener {
    final /* synthetic */ df a;

    private dp(df df2) {
        this.a = df2;
    }

    /* synthetic */ dp(df df2, dg dg2) {
        this(df2);
    }

    public void onScroll(AbsListView absListView, int n2, int n3, int n4) {
    }

    public void onScrollStateChanged(AbsListView absListView, int n2) {
        if (n2 != 1) return;
        if (this.a.l()) return;
        if (df.b(this.a).getContentView() == null) return;
        df.d(this.a).removeCallbacks((Runnable)df.c(this.a));
        df.c(this.a).run();
    }
}

