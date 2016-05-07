/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.cc;
import android.support.v7.widget.ff;
import android.view.View;
import android.view.ViewGroup;

class ed
implements cc {
    final /* synthetic */ RecyclerView a;

    ed(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    @Override
    public int a() {
        return this.a.getChildCount();
    }

    @Override
    public int a(View view) {
        return this.a.indexOfChild(view);
    }

    @Override
    public void a(int n2) {
        View view = this.a.getChildAt(n2);
        if (view != null) {
            RecyclerView.b(this.a, view);
        }
        this.a.removeViewAt(n2);
    }

    @Override
    public void a(View view, int n2) {
        this.a.addView(view, n2);
        RecyclerView.a(this.a, view);
    }

    @Override
    public void a(View view, int n2, ViewGroup.LayoutParams layoutParams) {
        ff ff2 = RecyclerView.c(view);
        if (ff2 != null) {
            if (!ff2.r() && !ff2.c()) {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + ff2);
            }
            ff2.m();
        }
        RecyclerView.a(this.a, view, n2, layoutParams);
    }

    @Override
    public ff b(View view) {
        return RecyclerView.c(view);
    }

    @Override
    public View b(int n2) {
        return this.a.getChildAt(n2);
    }

    @Override
    public void b() {
        int n2 = this.a();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                this.a.removeAllViews();
                return;
            }
            RecyclerView.b(this.a, this.b(n3));
            ++n3;
        } while (true);
    }

    @Override
    public void c(int n2) {
        ff ff2;
        View view = this.b(n2);
        if (view != null && (ff2 = RecyclerView.c(view)) != null) {
            if (ff2.r() && !ff2.c()) {
                throw new IllegalArgumentException("called detach on an already detached child " + ff2);
            }
            ff2.b(256);
        }
        RecyclerView.a(this.a, n2);
    }

    @Override
    public void c(View view) {
        ff ff2 = RecyclerView.c(view);
        if (ff2 == null) return;
        ff.a(ff2);
    }

    @Override
    public void d(View view) {
        ff ff2 = RecyclerView.c(view);
        if (ff2 == null) return;
        ff.b(ff2);
    }
}

