/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.support.v4.widget.a;
import android.view.animation.AnimationUtils;

class c {
    private int a;
    private int b;
    private float c;
    private float d;
    private long e = Long.MIN_VALUE;
    private long f = 0;
    private int g = 0;
    private int h = 0;
    private long i = -1;
    private float j;
    private int k;

    private float a(float f2) {
        return f2 * (-4.0f * f2) + 4.0f * f2;
    }

    private float a(long l2) {
        if (l2 < this.e) {
            return 0.0f;
        }
        if (this.i < 0) return 0.5f * a.a((float)(l2 - this.e) / (float)this.a, 0.0f, 1.0f);
        if (l2 < this.i) {
            return 0.5f * a.a((float)(l2 - this.e) / (float)this.a, 0.0f, 1.0f);
        }
        long l3 = l2 - this.i;
        return 1.0f - this.j + this.j * a.a((float)l3 / (float)this.k, 0.0f, 1.0f);
    }

    public void a() {
        this.e = AnimationUtils.currentAnimationTimeMillis();
        this.i = -1;
        this.f = this.e;
        this.j = 0.5f;
        this.g = 0;
        this.h = 0;
    }

    public void a(float f2, float f3) {
        this.c = f2;
        this.d = f3;
    }

    public void a(int n2) {
        this.a = n2;
    }

    public void b() {
        long l2 = AnimationUtils.currentAnimationTimeMillis();
        this.k = a.a((int)(l2 - this.e), 0, this.b);
        this.j = this.a(l2);
        this.i = l2;
    }

    public void b(int n2) {
        this.b = n2;
    }

    public boolean c() {
        if (this.i <= 0) return false;
        if (AnimationUtils.currentAnimationTimeMillis() <= this.i + (long)this.k) return false;
        return true;
    }

    public void d() {
        if (this.f == 0) {
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }
        long l2 = AnimationUtils.currentAnimationTimeMillis();
        float f2 = this.a(this.a(l2));
        long l3 = l2 - this.f;
        this.f = l2;
        this.g = (int)(f2 * (float)l3 * this.c);
        this.h = (int)(f2 * (float)l3 * this.d);
    }

    public int e() {
        return (int)(this.c / Math.abs(this.c));
    }

    public int f() {
        return (int)(this.d / Math.abs(this.d));
    }

    public int g() {
        return this.g;
    }

    public int h() {
        return this.h;
    }
}

