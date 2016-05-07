/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.dw;
import android.support.v7.widget.ep;
import android.support.v7.widget.er;
import android.view.View;
import android.view.ViewGroup;

final class dx
extends dw {
    dx(ep ep2) {
        super(ep2, null);
    }

    @Override
    public int a(View view) {
        er er2 = (er)view.getLayoutParams();
        return this.a.h(view) - er2.leftMargin;
    }

    @Override
    public void a(int n2) {
        this.a.i(n2);
    }

    @Override
    public int b(View view) {
        er er2 = (er)view.getLayoutParams();
        return this.a.j(view) + er2.rightMargin;
    }

    @Override
    public int c() {
        return this.a.x();
    }

    @Override
    public int c(View view) {
        er er2 = (er)view.getLayoutParams();
        return this.a.f(view) + er2.leftMargin + er2.rightMargin;
    }

    @Override
    public int d() {
        return this.a.v() - this.a.z();
    }

    @Override
    public int d(View view) {
        er er2 = (er)view.getLayoutParams();
        return this.a.g(view) + er2.topMargin + er2.bottomMargin;
    }

    @Override
    public int e() {
        return this.a.v();
    }

    @Override
    public int f() {
        return this.a.v() - this.a.x() - this.a.z();
    }

    @Override
    public int g() {
        return this.a.z();
    }

    @Override
    public int h() {
        return this.a.t();
    }

    @Override
    public int i() {
        return this.a.u();
    }
}

