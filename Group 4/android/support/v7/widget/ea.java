/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ej;

class ea
implements Runnable {
    final /* synthetic */ RecyclerView a;

    ea(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    @Override
    public void run() {
        if (this.a.f != null) {
            this.a.f.a();
        }
        RecyclerView.b(this.a, false);
    }
}

