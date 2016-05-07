/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.dw;
import android.support.v7.widget.er;
import android.support.v7.widget.fc;
import android.view.View;
import android.view.ViewGroup;

class db {
    int a;
    int b;
    boolean c;
    final /* synthetic */ LinearLayoutManager d;

    db(LinearLayoutManager linearLayoutManager) {
        this.d = linearLayoutManager;
    }

    static /* synthetic */ boolean a(db db2, View view, fc fc2) {
        return db2.a(view, fc2);
    }

    private boolean a(View view, fc fc2) {
        er er2 = (er)view.getLayoutParams();
        if (er2.c()) return false;
        if (er2.e() < 0) return false;
        if (er2.e() >= fc2.e()) return false;
        return true;
    }

    void a() {
        this.a = -1;
        this.b = Integer.MIN_VALUE;
        this.c = false;
    }

    public void a(View view) {
        int n2 = this.d.j.b();
        if (n2 >= 0) {
            this.b(view);
            return;
        }
        this.a = this.d.d(view);
        if (this.c) {
            int n3;
            int n4 = this.d.j.d() - n2 - this.d.j.b(view);
            this.b = this.d.j.d() - n4;
            if (n4 <= 0) return;
            int n5 = this.d.j.c(view);
            int n6 = this.b - n5;
            int n7 = n6 - ((n3 = this.d.j.c()) + Math.min(this.d.j.a(view) - n3, 0));
            if (n7 >= 0) return;
            this.b += Math.min(n4, - n7);
            return;
        }
        int n8 = this.d.j.a(view);
        int n9 = n8 - this.d.j.c();
        this.b = n8;
        if (n9 <= 0) return;
        int n10 = n8 + this.d.j.c(view);
        int n11 = this.d.j.d() - n2 - this.d.j.b(view);
        int n12 = this.d.j.d() - Math.min(0, n11) - n10;
        if (n12 >= 0) return;
        this.b -= Math.min(n9, - n12);
    }

    void b() {
        int n2 = this.c ? this.d.j.d() : this.d.j.c();
        this.b = n2;
    }

    public void b(View view) {
        this.b = this.c ? this.d.j.b(view) + this.d.j.b() : this.d.j.a(view);
        this.a = this.d.d(view);
    }

    public String toString() {
        return "AnchorInfo{mPosition=" + this.a + ", mCoordinate=" + this.b + ", mLayoutFromEnd=" + this.c + '}';
    }
}

