/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.dw;
import android.support.v7.widget.dx;
import android.support.v7.widget.ep;
import android.support.v7.widget.er;
import android.view.View;
import android.view.ViewGroup;

final class dy
extends dw {
    dy(ep ep2) {
        super(ep2, null);
    }

    @Override
    public int a(View view) {
        er er2 = (er)view.getLayoutParams();
        return this.a.i(view) - er2.topMargin;
    }

    @Override
    public void a(int n2) {
        this.a.j(n2);
    }

    @Override
    public int b(View view) {
        er er2 = (er)view.getLayoutParams();
        return this.a.k(view) + er2.bottomMargin;
    }

    @Override
    public int c() {
        return this.a.y();
    }

    @Override
    public int c(View view) {
        er er2 = (er)view.getLayoutParams();
        return this.a.g(view) + er2.topMargin + er2.bottomMargin;
    }

    @Override
    public int d() {
        return this.a.w() - this.a.A();
    }

    @Override
    public int d(View view) {
        er er2 = (er)view.getLayoutParams();
        return this.a.f(view) + er2.leftMargin + er2.rightMargin;
    }

    @Override
    public int e() {
        return this.a.w();
    }

    @Override
    public int f() {
        return this.a.w() - this.a.y() - this.a.A();
    }

    @Override
    public int g() {
        return this.a.A();
    }

    @Override
    public int h() {
        return this.a.u();
    }

    @Override
    public int i() {
        return this.a.t();
    }
}

