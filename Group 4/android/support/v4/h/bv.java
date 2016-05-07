/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.support.v4.h.bt;
import android.support.v4.h.ch;
import android.view.View;

class bv
extends bt {
    bv() {
    }

    @Override
    public void a(View view, Runnable runnable) {
        ch.a(view, runnable);
    }

    @Override
    public void a(View view, Runnable runnable, long l2) {
        ch.a(view, runnable, l2);
    }

    @Override
    public void c(View view, int n2) {
        if (n2 == 4) {
            n2 = 2;
        }
        ch.a(view, n2);
    }

    @Override
    public boolean c(View view) {
        return ch.a(view);
    }

    @Override
    public void d(View view) {
        ch.b(view);
    }

    @Override
    public int e(View view) {
        return ch.c(view);
    }

    @Override
    public boolean m(View view) {
        return ch.h(view);
    }

    @Override
    public int p(View view) {
        return ch.d(view);
    }

    @Override
    public int q(View view) {
        return ch.e(view);
    }

    @Override
    public void t(View view) {
        ch.f(view);
    }

    @Override
    public boolean w(View view) {
        return ch.g(view);
    }
}

