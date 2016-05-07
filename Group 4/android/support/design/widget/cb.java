/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.design.widget.a;
import android.support.design.widget.by;
import android.support.design.widget.bz;
import android.support.design.widget.ca;
import android.support.design.widget.cc;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

class cb
extends by {
    private static final Handler a = new Handler(Looper.getMainLooper());
    private long b;
    private boolean c;
    private final int[] d = new int[2];
    private final float[] e = new float[2];
    private int f = 200;
    private Interpolator g;
    private bz h;
    private ca i;
    private float j;
    private final Runnable k;

    cb() {
        this.k = new cc(this);
    }

    static /* synthetic */ void a(cb cb2) {
        cb2.g();
    }

    private void g() {
        if (this.c) {
            float f2 = (float)(SystemClock.uptimeMillis() - this.b) / (float)this.f;
            if (this.g != null) {
                f2 = this.g.getInterpolation(f2);
            }
            this.j = f2;
            if (this.i != null) {
                this.i.a();
            }
            if (SystemClock.uptimeMillis() >= this.b + (long)this.f) {
                this.c = false;
                if (this.h != null) {
                    this.h.b();
                }
            }
        }
        if (!this.c) return;
        a.postDelayed(this.k, 10);
    }

    @Override
    public void a() {
        if (this.c) {
            return;
        }
        if (this.g == null) {
            this.g = new AccelerateDecelerateInterpolator();
        }
        this.b = SystemClock.uptimeMillis();
        this.c = true;
        if (this.h != null) {
            this.h.a();
        }
        a.postDelayed(this.k, 10);
    }

    @Override
    public void a(float f2, float f3) {
        this.e[0] = f2;
        this.e[1] = f3;
    }

    @Override
    public void a(int n2) {
        this.f = n2;
    }

    @Override
    public void a(int n2, int n3) {
        this.d[0] = n2;
        this.d[1] = n3;
    }

    @Override
    public void a(ca ca2) {
        this.i = ca2;
    }

    @Override
    public void a(Interpolator interpolator) {
        this.g = interpolator;
    }

    @Override
    public boolean b() {
        return this.c;
    }

    @Override
    public int c() {
        return a.a(this.d[0], this.d[1], this.f());
    }

    @Override
    public float d() {
        return a.a(this.e[0], this.e[1], this.f());
    }

    @Override
    public void e() {
        this.c = false;
        a.removeCallbacks(this.k);
        if (this.h == null) return;
        this.h.c();
    }

    public float f() {
        return this.j;
    }
}

