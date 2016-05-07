/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ej;
import android.support.v7.widget.em;
import android.support.v7.widget.ep;
import android.support.v7.widget.ew;
import android.support.v7.widget.ff;
import android.support.v7.widget.gx;
import android.view.View;

class ec
implements gx {
    final /* synthetic */ RecyclerView a;

    ec(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    @Override
    public void a(ff ff2) {
        this.a.e.a(ff2.a, this.a.a);
    }

    @Override
    public void a(ff ff2, em em2, em em3) {
        this.a.a.d(ff2);
        RecyclerView.a(this.a, ff2, em2, em3);
    }

    @Override
    public void b(ff ff2, em em2, em em3) {
        RecyclerView.b(this.a, ff2, em2, em3);
    }

    @Override
    public void c(ff ff2, em em2, em em3) {
        ff2.a(false);
        if (RecyclerView.d(this.a)) {
            if (!this.a.f.a(ff2, ff2, em2, em3)) return;
            RecyclerView.e(this.a);
            return;
        }
        if (!this.a.f.c(ff2, em2, em3)) return;
        RecyclerView.e(this.a);
    }
}

