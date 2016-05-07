/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.ek;
import android.support.v7.widget.el;
import android.support.v7.widget.em;
import android.support.v7.widget.fc;
import android.support.v7.widget.ff;
import java.util.ArrayList;
import java.util.List;

public abstract class ej {
    private el a = null;
    private ArrayList b = new ArrayList();
    private long c = 120;
    private long d = 120;
    private long e = 250;
    private long f = 250;

    static int d(ff ff2) {
        int n2 = 14 & ff.f(ff2);
        if (ff2.n()) {
            return 4;
        }
        if ((n2 & 4) != 0) return n2;
        int n3 = ff2.f();
        int n4 = ff2.e();
        if (n3 == -1) return n2;
        if (n4 == -1) return n2;
        if (n3 == n4) return n2;
        return n2 | 2048;
    }

    public em a(fc fc2, ff ff2) {
        return this.i().a(ff2);
    }

    public em a(fc fc2, ff ff2, int n2, List list) {
        return this.i().a(ff2);
    }

    public abstract void a();

    void a(el el2) {
        this.a = el2;
    }

    public abstract boolean a(ff var1, em var2, em var3);

    public abstract boolean a(ff var1, ff var2, em var3, em var4);

    public boolean a(ff ff2, List list) {
        return this.g(ff2);
    }

    public abstract boolean b();

    public abstract boolean b(ff var1, em var2, em var3);

    public abstract void c();

    public abstract void c(ff var1);

    public abstract boolean c(ff var1, em var2, em var3);

    public long d() {
        return this.e;
    }

    public long e() {
        return this.c;
    }

    public final void e(ff ff2) {
        this.f(ff2);
        if (this.a == null) return;
        this.a.a(ff2);
    }

    public long f() {
        return this.d;
    }

    public void f(ff ff2) {
    }

    public long g() {
        return this.f;
    }

    public boolean g(ff ff2) {
        return true;
    }

    public final void h() {
        int n2 = this.b.size();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                this.b.clear();
                return;
            }
            ((ek)this.b.get(n3)).a();
            ++n3;
        } while (true);
    }

    public em i() {
        return new em();
    }
}

