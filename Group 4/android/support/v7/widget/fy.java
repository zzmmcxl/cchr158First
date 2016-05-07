/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.dw;
import android.support.v7.widget.fx;

class fy {
    int a;
    int b;
    boolean c;
    boolean d;
    final /* synthetic */ StaggeredGridLayoutManager e;

    private fy(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.e = staggeredGridLayoutManager;
    }

    /* synthetic */ fy(StaggeredGridLayoutManager staggeredGridLayoutManager, fx fx2) {
        this(staggeredGridLayoutManager);
    }

    void a() {
        this.a = -1;
        this.b = Integer.MIN_VALUE;
        this.c = false;
        this.d = false;
    }

    void a(int n2) {
        if (this.c) {
            this.b = this.e.a.d() - n2;
            return;
        }
        this.b = n2 + this.e.a.c();
    }

    void b() {
        int n2 = this.c ? this.e.a.d() : this.e.a.c();
        this.b = n2;
    }
}

