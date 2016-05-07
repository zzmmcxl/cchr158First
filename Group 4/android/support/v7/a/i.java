/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.support.v7.a.e;
import android.view.View;
import android.widget.AbsListView;

class i
implements AbsListView.OnScrollListener {
    final /* synthetic */ View a;
    final /* synthetic */ View b;
    final /* synthetic */ e c;

    i(e e2, View view, View view2) {
        this.c = e2;
        this.a = view;
        this.b = view2;
    }

    public void onScroll(AbsListView absListView, int n2, int n3, int n4) {
        e.a((View)absListView, this.a, this.b);
    }

    public void onScrollStateChanged(AbsListView absListView, int n2) {
    }
}

