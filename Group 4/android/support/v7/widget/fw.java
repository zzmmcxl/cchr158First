/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.ej;
import android.support.v7.widget.em;
import android.support.v7.widget.ff;
import android.view.View;

public abstract class fw
extends ej {
    boolean a = true;

    public final void a(ff ff2, boolean bl2) {
        this.d(ff2, bl2);
        this.e(ff2);
    }

    public abstract boolean a(ff var1);

    public abstract boolean a(ff var1, int var2, int var3, int var4, int var5);

    @Override
    public boolean a(ff ff2, em em2, em em3) {
        int n2 = em2.a;
        int n3 = em2.b;
        View view = ff2.a;
        int n4 = em3 == null ? view.getLeft() : em3.a;
        int n5 = em3 == null ? view.getTop() : em3.b;
        if (ff2.q()) return this.a(ff2);
        if (n2 == n4) {
            if (n3 == n5) return this.a(ff2);
        }
        view.layout(n4, n5, n4 + view.getWidth(), n5 + view.getHeight());
        return this.a(ff2, n2, n3, n4, n5);
    }

    public abstract boolean a(ff var1, ff var2, int var3, int var4, int var5, int var6);

    @Override
    public boolean a(ff ff2, ff ff3, em em2, em em3) {
        int n2;
        int n3;
        int n4 = em2.a;
        int n5 = em2.b;
        if (ff3.c()) {
            n2 = em2.a;
            n3 = em2.b;
            return this.a(ff2, ff3, n4, n5, n2, n3);
        }
        n2 = em3.a;
        n3 = em3.b;
        return this.a(ff2, ff3, n4, n5, n2, n3);
    }

    public final void b(ff ff2, boolean bl2) {
        this.c(ff2, bl2);
    }

    public abstract boolean b(ff var1);

    @Override
    public boolean b(ff ff2, em em2, em em3) {
        if (em2 == null) return this.b(ff2);
        if (em2.a != em3.a) return this.a(ff2, em2.a, em2.b, em3.a, em3.b);
        if (em2.b == em3.b) return this.b(ff2);
        return this.a(ff2, em2.a, em2.b, em3.a, em3.b);
    }

    public void c(ff ff2, boolean bl2) {
    }

    @Override
    public boolean c(ff ff2, em em2, em em3) {
        if (em2.a != em3.a) return this.a(ff2, em2.a, em2.b, em3.a, em3.b);
        if (em2.b != em3.b) {
            return this.a(ff2, em2.a, em2.b, em3.a, em3.b);
        }
        this.i(ff2);
        return false;
    }

    public void d(ff ff2, boolean bl2) {
    }

    @Override
    public boolean g(ff ff2) {
        if (!this.a) return true;
        if (!ff2.n()) return false;
        return true;
    }

    public final void h(ff ff2) {
        this.o(ff2);
        this.e(ff2);
    }

    public final void i(ff ff2) {
        this.s(ff2);
        this.e(ff2);
    }

    public final void j(ff ff2) {
        this.q(ff2);
        this.e(ff2);
    }

    public final void k(ff ff2) {
        this.n(ff2);
    }

    public final void l(ff ff2) {
        this.r(ff2);
    }

    public final void m(ff ff2) {
        this.p(ff2);
    }

    public void n(ff ff2) {
    }

    public void o(ff ff2) {
    }

    public void p(ff ff2) {
    }

    public void q(ff ff2) {
    }

    public void r(ff ff2) {
    }

    public void s(ff ff2) {
    }
}

