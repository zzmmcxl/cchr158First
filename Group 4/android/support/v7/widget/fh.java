/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.h.a;
import android.support.v4.h.a.g;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ep;
import android.support.v7.widget.fg;
import android.view.View;

class fh
extends a {
    final /* synthetic */ fg b;

    fh(fg fg2) {
        this.b = fg2;
    }

    @Override
    public void a(View view, g g2) {
        super.a(view, g2);
        if (fg.a(this.b)) return;
        if (this.b.b.getLayoutManager() == null) return;
        this.b.b.getLayoutManager().a(view, g2);
    }

    @Override
    public boolean a(View view, int n2, Bundle bundle) {
        if (super.a(view, n2, bundle)) {
            return true;
        }
        if (fg.a(this.b)) return false;
        if (this.b.b.getLayoutManager() == null) return false;
        return this.b.b.getLayoutManager().a(view, n2, bundle);
    }
}

