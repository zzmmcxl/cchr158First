/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.os.Build;
import android.support.v4.h.de;
import android.support.v4.h.dg;
import android.support.v4.h.di;
import android.support.v4.h.dj;
import android.support.v4.h.dk;
import android.support.v4.h.dl;
import android.support.v4.h.dm;
import android.support.v4.h.dt;
import android.support.v4.h.dv;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class dc {
    static final dm a;
    private WeakReference b;
    private Runnable c = null;
    private Runnable d = null;
    private int e = -1;

    static {
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 21) {
            a = new dl();
            return;
        }
        if (n2 >= 19) {
            a = new dk();
            return;
        }
        if (n2 >= 18) {
            a = new di();
            return;
        }
        if (n2 >= 16) {
            a = new dj();
            return;
        }
        if (n2 >= 14) {
            a = new dg();
            return;
        }
        a = new de();
    }

    dc(View view) {
        this.b = new WeakReference<View>(view);
    }

    static /* synthetic */ int a(dc dc2, int n2) {
        dc2.e = n2;
        return n2;
    }

    static /* synthetic */ Runnable a(dc dc2) {
        return dc2.c;
    }

    static /* synthetic */ Runnable a(dc dc2, Runnable runnable) {
        dc2.d = runnable;
        return runnable;
    }

    static /* synthetic */ Runnable b(dc dc2) {
        return dc2.d;
    }

    static /* synthetic */ Runnable b(dc dc2, Runnable runnable) {
        dc2.c = runnable;
        return runnable;
    }

    static /* synthetic */ int c(dc dc2) {
        return dc2.e;
    }

    public long a() {
        View view = (View)this.b.get();
        if (view == null) return 0;
        return a.a(this, view);
    }

    public dc a(float f2) {
        View view = (View)this.b.get();
        if (view == null) return this;
        a.a(this, view, f2);
        return this;
    }

    public dc a(long l2) {
        View view = (View)this.b.get();
        if (view == null) return this;
        a.a(this, view, l2);
        return this;
    }

    public dc a(dt dt2) {
        View view = (View)this.b.get();
        if (view == null) return this;
        a.a(this, view, dt2);
        return this;
    }

    public dc a(dv dv2) {
        View view = (View)this.b.get();
        if (view == null) return this;
        a.a(this, view, dv2);
        return this;
    }

    public dc a(Interpolator interpolator) {
        View view = (View)this.b.get();
        if (view == null) return this;
        a.a(this, view, interpolator);
        return this;
    }

    public dc b(float f2) {
        View view = (View)this.b.get();
        if (view == null) return this;
        a.b(this, view, f2);
        return this;
    }

    public dc b(long l2) {
        View view = (View)this.b.get();
        if (view == null) return this;
        a.b(this, view, l2);
        return this;
    }

    public void b() {
        View view = (View)this.b.get();
        if (view == null) return;
        a.b(this, view);
    }

    public dc c(float f2) {
        View view = (View)this.b.get();
        if (view == null) return this;
        a.c(this, view, f2);
        return this;
    }

    public void c() {
        View view = (View)this.b.get();
        if (view == null) return;
        a.c(this, view);
    }
}

