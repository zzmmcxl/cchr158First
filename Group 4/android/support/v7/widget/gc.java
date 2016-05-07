/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup;
import android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
import android.support.v7.widget.dw;
import android.support.v7.widget.fx;
import android.support.v7.widget.fz;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

class gc {
    int a;
    int b;
    int c;
    final int d;
    final /* synthetic */ StaggeredGridLayoutManager e;
    private ArrayList f;

    private gc(StaggeredGridLayoutManager staggeredGridLayoutManager, int n2) {
        this.e = staggeredGridLayoutManager;
        this.f = new ArrayList();
        this.a = Integer.MIN_VALUE;
        this.b = Integer.MIN_VALUE;
        this.c = 0;
        this.d = n2;
    }

    /* synthetic */ gc(StaggeredGridLayoutManager staggeredGridLayoutManager, int n2, fx fx2) {
        this(staggeredGridLayoutManager, n2);
    }

    static /* synthetic */ ArrayList a(gc gc2) {
        return gc2.f;
    }

    int a(int n2) {
        if (this.a != Integer.MIN_VALUE) {
            return this.a;
        }
        if (this.f.size() == 0) return n2;
        this.a();
        return this.a;
    }

    public View a(int n2, int n3) {
        View view = null;
        if (n3 == -1) {
            int n4 = this.f.size();
            int n5 = 0;
            while (n5 < n4) {
                View view2 = (View)this.f.get(n5);
                if (!view2.isFocusable()) return view;
                boolean bl2 = this.e.d(view2) > n2;
                if (bl2 != StaggeredGridLayoutManager.b(this.e)) return view;
                ++n5;
                view = view2;
            }
            return view;
        }
        int n6 = -1 + this.f.size();
        while (n6 >= 0) {
            View view3 = (View)this.f.get(n6);
            if (!view3.isFocusable()) return view;
            boolean bl3 = this.e.d(view3) > n2;
            if (StaggeredGridLayoutManager.b(this.e)) return view;
            boolean bl4 = true;
            if (bl3 != bl4) return view;
            --n6;
            view = view3;
        }
        return view;
    }

    void a() {
        View view = (View)this.f.get(0);
        fz fz2 = this.c(view);
        this.a = this.e.a.a(view);
        if (!fz2.f) return;
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = this.e.f.f(fz2.e());
        if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem == null) return;
        if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.b != -1) return;
        this.a -= staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.a(this.d);
    }

    void a(View view) {
        fz fz2 = this.c(view);
        fz2.e = this;
        this.f.add(0, view);
        this.a = Integer.MIN_VALUE;
        if (this.f.size() == 1) {
            this.b = Integer.MIN_VALUE;
        }
        if (!fz2.c()) {
            if (!fz2.d()) return;
        }
        this.c += this.e.a.c(view);
    }

    void a(boolean bl2, int n2) {
        int n3 = bl2 ? this.b(Integer.MIN_VALUE) : this.a(Integer.MIN_VALUE);
        this.e();
        if (n3 == Integer.MIN_VALUE) {
            return;
        }
        if (bl2) {
            if (n3 < this.e.a.d()) return;
        }
        if (!bl2) {
            if (n3 > this.e.a.c()) return;
        }
        if (n2 != Integer.MIN_VALUE) {
            n3 += n2;
        }
        this.b = n3;
        this.a = n3;
    }

    int b() {
        if (this.a != Integer.MIN_VALUE) {
            return this.a;
        }
        this.a();
        return this.a;
    }

    int b(int n2) {
        if (this.b != Integer.MIN_VALUE) {
            return this.b;
        }
        if (this.f.size() == 0) return n2;
        this.c();
        return this.b;
    }

    void b(View view) {
        fz fz2 = this.c(view);
        fz2.e = this;
        this.f.add(view);
        this.b = Integer.MIN_VALUE;
        if (this.f.size() == 1) {
            this.a = Integer.MIN_VALUE;
        }
        if (!fz2.c()) {
            if (!fz2.d()) return;
        }
        this.c += this.e.a.c(view);
    }

    fz c(View view) {
        return (fz)view.getLayoutParams();
    }

    void c() {
        View view = (View)this.f.get(-1 + this.f.size());
        fz fz2 = this.c(view);
        this.b = this.e.a.b(view);
        if (!fz2.f) return;
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = this.e.f.f(fz2.e());
        if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem == null) return;
        if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.b != 1) return;
        this.b += staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.a(this.d);
    }

    void c(int n2) {
        this.a = n2;
        this.b = n2;
    }

    int d() {
        if (this.b != Integer.MIN_VALUE) {
            return this.b;
        }
        this.c();
        return this.b;
    }

    void d(int n2) {
        if (this.a != Integer.MIN_VALUE) {
            this.a = n2 + this.a;
        }
        if (this.b == Integer.MIN_VALUE) return;
        this.b = n2 + this.b;
    }

    void e() {
        this.f.clear();
        this.f();
        this.c = 0;
    }

    void f() {
        this.a = Integer.MIN_VALUE;
        this.b = Integer.MIN_VALUE;
    }

    void g() {
        int n2 = this.f.size();
        View view = (View)this.f.remove(n2 - 1);
        fz fz2 = this.c(view);
        fz2.e = null;
        if (fz2.c() || fz2.d()) {
            this.c -= this.e.a.c(view);
        }
        if (n2 == 1) {
            this.a = Integer.MIN_VALUE;
        }
        this.b = Integer.MIN_VALUE;
    }

    void h() {
        View view = (View)this.f.remove(0);
        fz fz2 = this.c(view);
        fz2.e = null;
        if (this.f.size() == 0) {
            this.b = Integer.MIN_VALUE;
        }
        if (fz2.c() || fz2.d()) {
            this.c -= this.e.a.c(view);
        }
        this.a = Integer.MIN_VALUE;
    }

    public int i() {
        return this.c;
    }
}

