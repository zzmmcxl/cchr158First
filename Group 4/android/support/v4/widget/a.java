/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.h.at;
import android.support.v4.h.bo;
import android.support.v4.widget.b;
import android.support.v4.widget.c;
import android.support.v4.widget.d;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;

public abstract class a
implements View.OnTouchListener {
    private static final int r = ViewConfiguration.getTapTimeout();
    private final c a = new c();
    private final Interpolator b = new AccelerateInterpolator();
    private final View c;
    private Runnable d;
    private float[] e = new float[]{0.0f, 0.0f};
    private float[] f = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private int g;
    private int h;
    private float[] i = new float[]{0.0f, 0.0f};
    private float[] j = new float[]{0.0f, 0.0f};
    private float[] k = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;

    public a(View view) {
        this.c = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int n2 = (int)(0.5f + 1575.0f * displayMetrics.density);
        int n3 = (int)(0.5f + 315.0f * displayMetrics.density);
        this.a((float)n2, (float)n2);
        this.b(n3, n3);
        this.a(1);
        this.e(Float.MAX_VALUE, Float.MAX_VALUE);
        this.d(0.2f, 0.2f);
        this.c(1.0f, 1.0f);
        this.b(r);
        this.c(500);
        this.d(500);
    }

    static /* synthetic */ float a(float f2, float f3, float f4) {
        return a.b(f2, f3, f4);
    }

    private float a(float f2, float f3, float f4, float f5) {
        float f6;
        float f7 = a.b(f2 * f3, 0.0f, f4);
        float f8 = this.f(f5, f7);
        float f9 = this.f(f3 - f5, f7) - f8;
        if (f9 < 0.0f) {
            f6 = - this.b.getInterpolation(- f9);
            return a.b(f6, -1.0f, 1.0f);
        } else {
            float f10 = f9 FCMPL 0.0f;
            float f11 = 0.0f;
            if (f10 <= 0) return f11;
            f6 = this.b.getInterpolation(f9);
        }
        return a.b(f6, -1.0f, 1.0f);
    }

    private float a(int n2, float f2, float f3, float f4) {
        float f5 = this.a(this.e[n2], f3, this.f[n2], f2);
        if (f5 == 0.0f) {
            return 0.0f;
        }
        float f6 = this.i[n2];
        float f7 = this.j[n2];
        float f8 = this.k[n2];
        float f9 = f6 * f4;
        if (f5 <= 0.0f) return - a.b(f9 * (- f5), f7, f8);
        return a.b(f5 * f9, f7, f8);
    }

    static /* synthetic */ int a(int n2, int n3, int n4) {
        return a.b(n2, n3, n4);
    }

    private boolean a() {
        c c2 = this.a;
        int n2 = c2.f();
        int n3 = c2.e();
        if (n2 != 0) {
            if (this.f(n2)) return true;
        }
        if (n3 == 0) return false;
        if (!this.e(n3)) return false;
        return true;
    }

    static /* synthetic */ boolean a(a a2) {
        return a2.o;
    }

    static /* synthetic */ boolean a(a a2, boolean bl2) {
        a2.m = bl2;
        return bl2;
    }

    private static float b(float f2, float f3, float f4) {
        if (f2 > f4) {
            return f4;
        }
        if (f2 >= f3) return f2;
        return f3;
    }

    private static int b(int n2, int n3, int n4) {
        if (n2 > n4) {
            return n4;
        }
        if (n2 >= n3) return n2;
        return n3;
    }

    private void b() {
        if (this.d == null) {
            this.d = new d(this, null);
        }
        this.o = true;
        this.m = true;
        if (!this.l && this.h > 0) {
            bo.a(this.c, this.d, (long)this.h);
        } else {
            this.d.run();
        }
        this.l = true;
    }

    static /* synthetic */ boolean b(a a2) {
        return a2.m;
    }

    static /* synthetic */ boolean b(a a2, boolean bl2) {
        a2.o = bl2;
        return bl2;
    }

    static /* synthetic */ c c(a a2) {
        return a2.a;
    }

    private void c() {
        if (this.m) {
            this.o = false;
            return;
        }
        this.a.b();
    }

    static /* synthetic */ boolean c(a a2, boolean bl2) {
        a2.n = bl2;
        return bl2;
    }

    private void d() {
        long l2 = SystemClock.uptimeMillis();
        MotionEvent motionEvent = MotionEvent.obtain((long)l2, (long)l2, (int)3, (float)0.0f, (float)0.0f, (int)0);
        this.c.onTouchEvent(motionEvent);
        motionEvent.recycle();
    }

    static /* synthetic */ boolean d(a a2) {
        return a2.a();
    }

    static /* synthetic */ boolean e(a a2) {
        return a2.n;
    }

    private float f(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        switch (this.g) {
            default: {
                return 0.0f;
            }
            case 0: 
            case 1: {
                if (f2 >= f3) return 0.0f;
                if (f2 >= 0.0f) {
                    return 1.0f - f2 / f3;
                }
                if (!this.o) return 0.0f;
                if (this.g != 1) return 0.0f;
                return 1.0f;
            }
            case 2: 
        }
        if (f2 >= 0.0f) return 0.0f;
        return f2 / (- f3);
    }

    static /* synthetic */ void f(a a2) {
        a2.d();
    }

    static /* synthetic */ View g(a a2) {
        return a2.c;
    }

    public a a(float f2, float f3) {
        this.k[0] = f2 / 1000.0f;
        this.k[1] = f3 / 1000.0f;
        return this;
    }

    public a a(int n2) {
        this.g = n2;
        return this;
    }

    public a a(boolean bl2) {
        if (this.p && !bl2) {
            this.c();
        }
        this.p = bl2;
        return this;
    }

    public abstract void a(int var1, int var2);

    public a b(float f2, float f3) {
        this.j[0] = f2 / 1000.0f;
        this.j[1] = f3 / 1000.0f;
        return this;
    }

    public a b(int n2) {
        this.h = n2;
        return this;
    }

    public a c(float f2, float f3) {
        this.i[0] = f2 / 1000.0f;
        this.i[1] = f3 / 1000.0f;
        return this;
    }

    public a c(int n2) {
        this.a.a(n2);
        return this;
    }

    public a d(float f2, float f3) {
        this.e[0] = f2;
        this.e[1] = f3;
        return this;
    }

    public a d(int n2) {
        this.a.b(n2);
        return this;
    }

    public a e(float f2, float f3) {
        this.f[0] = f2;
        this.f[1] = f3;
        return this;
    }

    public abstract boolean e(int var1);

    public abstract boolean f(int var1);

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int n2 = 1;
        if (!this.p) {
            return false;
        }
        switch (at.a(motionEvent)) {
            case 0: {
                this.n = n2;
                this.l = false;
            }
            case 2: {
                float f2 = this.a(0, motionEvent.getX(), (float)view.getWidth(), (float)this.c.getWidth());
                float f3 = this.a(n2, motionEvent.getY(), (float)view.getHeight(), (float)this.c.getHeight());
                this.a.a(f2, f3);
                if (this.o || !this.a()) break;
                this.b();
                break;
            }
            case 1: 
            case 3: {
                this.c();
            }
        }
        if (!this.q) return (boolean)0;
        if (!this.o) return (boolean)0;
        return (boolean)n2;
    }
}

