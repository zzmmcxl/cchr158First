/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;

class dz
implements Runnable {
    final /* synthetic */ RecyclerView a;

    dz(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    @Override
    public void run() {
        if (!RecyclerView.a(this.a)) return;
        if (this.a.isLayoutRequested()) {
            return;
        }
        if (RecyclerView.b(this.a)) {
            RecyclerView.a(this.a, true);
            return;
        }
        RecyclerView.c(this.a);
    }
}

