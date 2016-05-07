/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.h.a;
import android.support.v4.h.a.g;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ep;
import android.support.v7.widget.fh;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class fg
extends a {
    final RecyclerView b;
    final a c;

    public fg(RecyclerView recyclerView) {
        this.c = new fh(this);
        this.b = recyclerView;
    }

    static /* synthetic */ boolean a(fg fg2) {
        return fg2.c();
    }

    private boolean c() {
        return this.b.p();
    }

    @Override
    public void a(View view, g g2) {
        super.a(view, g2);
        g2.a(RecyclerView.class.getName());
        if (this.c()) return;
        if (this.b.getLayoutManager() == null) return;
        this.b.getLayoutManager().a(g2);
    }

    @Override
    public boolean a(View view, int n2, Bundle bundle) {
        if (super.a(view, n2, bundle)) {
            return true;
        }
        if (this.c()) return false;
        if (this.b.getLayoutManager() == null) return false;
        return this.b.getLayoutManager().a(n2, bundle);
    }

    a b() {
        return this.c;
    }

    @Override
    public void d(View view, AccessibilityEvent accessibilityEvent) {
        super.d(view, accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)RecyclerView.class.getName());
        if (!(view instanceof RecyclerView)) return;
        if (this.c()) return;
        RecyclerView recyclerView = (RecyclerView)view;
        if (recyclerView.getLayoutManager() == null) return;
        recyclerView.getLayoutManager().a(accessibilityEvent);
    }
}

