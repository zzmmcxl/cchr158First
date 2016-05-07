/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.dz;
import android.support.v7.widget.el;
import android.support.v7.widget.ff;
import android.view.View;

class en
implements el {
    final /* synthetic */ RecyclerView a;

    private en(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    /* synthetic */ en(RecyclerView recyclerView, dz dz2) {
        this(recyclerView);
    }

    @Override
    public void a(ff ff2) {
        ff2.a(true);
        if (ff2.g != null && ff2.h == null) {
            ff2.g = null;
        }
        ff2.h = null;
        if (ff.e(ff2)) return;
        if (RecyclerView.c(this.a, ff2.a)) return;
        if (!ff2.r()) return;
        this.a.removeDetachedView(ff2.a, false);
    }
}

