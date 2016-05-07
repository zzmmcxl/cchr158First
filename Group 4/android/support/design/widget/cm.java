/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.os.Build;
import android.support.v4.h.bo;
import android.view.View;
import android.view.ViewParent;

class cm {
    private final View a;
    private int b;
    private int c;
    private int d;
    private int e;

    public cm(View view) {
        this.a = view;
    }

    private static void a(View view) {
        float f2 = bo.n(view);
        bo.b(view, 1.0f + f2);
        bo.b(view, f2);
    }

    private void c() {
        bo.e(this.a, this.d - (this.a.getTop() - this.b));
        bo.f(this.a, this.e - (this.a.getLeft() - this.c));
        if (Build.VERSION.SDK_INT >= 23) return;
        cm.a(this.a);
        ViewParent viewParent = this.a.getParent();
        if (!(viewParent instanceof View)) return;
        cm.a((View)viewParent);
    }

    public void a() {
        this.b = this.a.getTop();
        this.c = this.a.getLeft();
        this.c();
    }

    public boolean a(int n2) {
        if (this.d == n2) return false;
        this.d = n2;
        this.c();
        return true;
    }

    public int b() {
        return this.d;
    }

    public boolean b(int n2) {
        if (this.e == n2) return false;
        this.e = n2;
        this.c();
        return true;
    }
}

