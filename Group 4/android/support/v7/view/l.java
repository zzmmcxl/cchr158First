/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view;

import android.support.v4.h.dc;
import android.support.v4.h.dt;
import android.support.v4.h.du;
import android.support.v7.view.m;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class l {
    private final ArrayList a;
    private long b = -1;
    private Interpolator c;
    private dt d;
    private boolean e;
    private final du f;

    public l() {
        this.f = new m(this);
        this.a = new ArrayList();
    }

    static /* synthetic */ dt a(l l2) {
        return l2.d;
    }

    static /* synthetic */ void b(l l2) {
        l2.c();
    }

    static /* synthetic */ ArrayList c(l l2) {
        return l2.a;
    }

    private void c() {
        this.e = false;
    }

    public l a(long l2) {
        if (this.e) return this;
        this.b = l2;
        return this;
    }

    public l a(dc dc2) {
        if (this.e) return this;
        this.a.add(dc2);
        return this;
    }

    public l a(dc dc2, dc dc3) {
        this.a.add(dc2);
        dc3.b(dc2.a());
        this.a.add(dc3);
        return this;
    }

    public l a(dt dt2) {
        if (this.e) return this;
        this.d = dt2;
        return this;
    }

    public l a(Interpolator interpolator) {
        if (this.e) return this;
        this.c = interpolator;
        return this;
    }

    public void a() {
        if (this.e) {
            return;
        }
        Iterator iterator = this.a.iterator();
        do {
            if (!iterator.hasNext()) {
                this.e = true;
                return;
            }
            dc dc2 = (dc)iterator.next();
            if (this.b >= 0) {
                dc2.a(this.b);
            }
            if (this.c != null) {
                dc2.a(this.c);
            }
            if (this.d != null) {
                dc2.a(this.f);
            }
            dc2.c();
        } while (true);
    }

    public void b() {
        if (!this.e) {
            return;
        }
        Iterator iterator = this.a.iterator();
        do {
            if (!iterator.hasNext()) {
                this.e = false;
                return;
            }
            ((dc)iterator.next()).b();
        } while (true);
    }
}

