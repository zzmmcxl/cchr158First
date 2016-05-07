/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.StaggeredGridLayoutManager;

class fx
implements Runnable {
    final /* synthetic */ StaggeredGridLayoutManager a;

    fx(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.a = staggeredGridLayoutManager;
    }

    @Override
    public void run() {
        StaggeredGridLayoutManager.a(this.a);
    }
}

