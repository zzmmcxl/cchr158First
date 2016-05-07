/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.h.at;
import android.support.v4.h.bo;
import android.support.v4.widget.as;
import android.support.v4.widget.bk;
import android.support.v4.widget.bl;
import android.support.v4.widget.bm;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import java.util.Arrays;

public class bj {
    private static final Interpolator v = new bk();
    private int a;
    private int b;
    private int c = -1;
    private float[] d;
    private float[] e;
    private float[] f;
    private float[] g;
    private int[] h;
    private int[] i;
    private int[] j;
    private int k;
    private VelocityTracker l;
    private float m;
    private float n;
    private int o;
    private int p;
    private as q;
    private final bm r;
    private View s;
    private boolean t;
    private final ViewGroup u;
    private final Runnable w;

    private bj(Context context, ViewGroup viewGroup, bm bm2) {
        this.w = new bl(this);
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (bm2 == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.u = viewGroup;
        this.r = bm2;
        ViewConfiguration viewConfiguration = ViewConfiguration.get((Context)context);
        this.o = (int)(0.5f + 20.0f * context.getResources().getDisplayMetrics().density);
        this.b = viewConfiguration.getScaledTouchSlop();
        this.m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.q = as.a(context, v);
    }

    private float a(float f2) {
        return (float)Math.sin((float)(0.4712389167638204 * (double)(f2 - 0.5f)));
    }

    private float a(float f2, float f3, float f4) {
        float f5 = Math.abs(f2);
        if (f5 < f3) {
            return 0.0f;
        }
        if (f5 <= f4) return f2;
        if (f2 > 0.0f) return f4;
        return - f4;
    }

    private int a(int n2, int n3, int n4) {
        int n5;
        if (n2 == 0) {
            return 0;
        }
        int n6 = this.u.getWidth();
        int n7 = n6 / 2;
        float f2 = Math.min(1.0f, (float)Math.abs(n2) / (float)n6);
        float f3 = (float)n7 + (float)n7 * this.a(f2);
        int n8 = Math.abs(n3);
        if (n8 > 0) {
            n5 = 4 * Math.round(1000.0f * Math.abs(f3 / (float)n8));
            return Math.min(n5, 600);
        }
        n5 = (int)(256.0f * (1.0f + (float)Math.abs(n2) / (float)n4));
        return Math.min(n5, 600);
    }

    private int a(View view, int n2, int n3, int n4, int n5) {
        int n6 = this.b(n4, (int)this.n, (int)this.m);
        int n7 = this.b(n5, (int)this.n, (int)this.m);
        int n8 = Math.abs(n2);
        int n9 = Math.abs(n3);
        int n10 = Math.abs(n6);
        int n11 = Math.abs(n7);
        int n12 = n10 + n11;
        int n13 = n8 + n9;
        float f2 = n6 != 0 ? (float)n10 / (float)n12 : (float)n8 / (float)n13;
        float f3 = n7 != 0 ? (float)n11 / (float)n12 : (float)n9 / (float)n13;
        int n14 = this.a(n2, n6, this.r.b(view));
        int n15 = this.a(n3, n7, this.r.a(view));
        return (int)(f2 * (float)n14 + f3 * (float)n15);
    }

    public static bj a(ViewGroup viewGroup, float f2, bm bm2) {
        bj bj2 = bj.a(viewGroup, bm2);
        bj2.b = (int)((float)bj2.b * (1.0f / f2));
        return bj2;
    }

    public static bj a(ViewGroup viewGroup, bm bm2) {
        return new bj(viewGroup.getContext(), viewGroup, bm2);
    }

    private void a(float f2, float f3) {
        this.t = true;
        this.r.a(this.s, f2, f3);
        this.t = false;
        if (this.a != 1) return;
        this.a(0);
    }

    private void a(float f2, float f3, int n2) {
        this.c(n2);
        float[] arrf = this.d;
        this.f[n2] = f2;
        arrf[n2] = f2;
        float[] arrf2 = this.e;
        this.g[n2] = f3;
        arrf2[n2] = f3;
        this.h[n2] = this.d((int)f2, (int)f3);
        this.k |= 1 << n2;
    }

    private boolean a(float f2, float f3, int n2, int n3) {
        float f4 = Math.abs(f2);
        float f5 = Math.abs(f3);
        if ((n3 & this.h[n2]) != n3) return false;
        if ((n3 & this.p) == 0) return false;
        if ((n3 & this.j[n2]) == n3) return false;
        if ((n3 & this.i[n2]) == n3) return false;
        if (f4 <= (float)this.b && f5 <= (float)this.b) {
            return false;
        }
        if (f4 < f5 * 0.5f && this.r.b(n3)) {
            int[] arrn = this.j;
            arrn[n2] = n3 | arrn[n2];
            return false;
        }
        if ((n3 & this.i[n2]) != 0) return false;
        if (f4 <= (float)this.b) return false;
        return true;
    }

    private boolean a(int n2, int n3, int n4, int n5) {
        int n6 = this.s.getLeft();
        int n7 = this.s.getTop();
        int n8 = n2 - n6;
        int n9 = n3 - n7;
        if (n8 == 0 && n9 == 0) {
            this.q.h();
            this.a(0);
            return false;
        }
        int n10 = this.a(this.s, n8, n9, n4, n5);
        this.q.a(n6, n7, n8, n9, n10);
        this.a(2);
        return true;
    }

    private boolean a(View view, float f2, float f3) {
        boolean bl2 = true;
        if (view == null) {
            return false;
        }
        boolean bl3 = this.r.b(view) > 0 ? bl2 : false;
        if (this.r.a(view) <= 0) return false;
        boolean bl4 = bl2;
        if (bl3 && bl4) {
            if (f2 * f2 + f3 * f3 > (float)(this.b * this.b)) return bl2;
            return false;
        }
        if (bl3) {
            if (Math.abs(f2) > (float)this.b) return bl2;
            return false;
        }
        if (!bl4) return false;
        if (Math.abs(f3) > (float)this.b) return bl2;
        return false;
    }

    private int b(int n2, int n3, int n4) {
        int n5 = Math.abs(n2);
        if (n5 < n3) {
            return 0;
        }
        if (n5 <= n4) return n2;
        if (n2 > 0) return n4;
        return - n4;
    }

    private void b(float f2, float f3, int n2) {
        int n3 = 1;
        if (!this.a(f2, f3, n2, n3)) {
            n3 = 0;
        }
        if (this.a(f3, f2, n2, 4)) {
            n3 |= 4;
        }
        if (this.a(f2, f3, n2, 2)) {
            n3 |= 2;
        }
        if (this.a(f3, f2, n2, 8)) {
            n3 |= 8;
        }
        if (n3 == 0) return;
        int[] arrn = this.i;
        arrn[n2] = n3 | arrn[n2];
        this.r.b(n3, n2);
    }

    private void b(int n2) {
        if (this.d == null) {
            return;
        }
        this.d[n2] = 0.0f;
        this.e[n2] = 0.0f;
        this.f[n2] = 0.0f;
        this.g[n2] = 0.0f;
        this.h[n2] = 0;
        this.i[n2] = 0;
        this.j[n2] = 0;
        this.k &= -1 ^ 1 << n2;
    }

    private void b(int n2, int n3, int n4, int n5) {
        int n6;
        int n7;
        int n8 = this.s.getLeft();
        int n9 = this.s.getTop();
        if (n4 != 0) {
            n6 = this.r.b(this.s, n2, n4);
            bo.f(this.s, n6 - n8);
        } else {
            n6 = n2;
        }
        if (n5 != 0) {
            n7 = this.r.a(this.s, n3, n5);
            bo.e(this.s, n7 - n9);
        } else {
            n7 = n3;
        }
        if (n4 == 0) {
            if (n5 == 0) return;
        }
        int n10 = n6 - n8;
        int n11 = n7 - n9;
        this.r.a(this.s, n6, n7, n10, n11);
    }

    private void c() {
        if (this.d == null) {
            return;
        }
        Arrays.fill(this.d, 0.0f);
        Arrays.fill(this.e, 0.0f);
        Arrays.fill(this.f, 0.0f);
        Arrays.fill(this.g, 0.0f);
        Arrays.fill(this.h, 0);
        Arrays.fill(this.i, 0);
        Arrays.fill(this.j, 0);
        this.k = 0;
    }

    private void c(int n2) {
        if (this.d != null) {
            if (this.d.length > n2) return;
        }
        float[] arrf = new float[n2 + 1];
        float[] arrf2 = new float[n2 + 1];
        float[] arrf3 = new float[n2 + 1];
        float[] arrf4 = new float[n2 + 1];
        int[] arrn = new int[n2 + 1];
        int[] arrn2 = new int[n2 + 1];
        int[] arrn3 = new int[n2 + 1];
        if (this.d != null) {
            System.arraycopy(this.d, 0, arrf, 0, this.d.length);
            System.arraycopy(this.e, 0, arrf2, 0, this.e.length);
            System.arraycopy(this.f, 0, arrf3, 0, this.f.length);
            System.arraycopy(this.g, 0, arrf4, 0, this.g.length);
            System.arraycopy(this.h, 0, arrn, 0, this.h.length);
            System.arraycopy(this.i, 0, arrn2, 0, this.i.length);
            System.arraycopy(this.j, 0, arrn3, 0, this.j.length);
        }
        this.d = arrf;
        this.e = arrf2;
        this.f = arrf3;
        this.g = arrf4;
        this.h = arrn;
        this.i = arrn2;
        this.j = arrn3;
    }

    private void c(MotionEvent motionEvent) {
        int n2 = at.c(motionEvent);
        int n3 = 0;
        while (n3 < n2) {
            int n4 = at.b(motionEvent, n3);
            float f2 = at.c(motionEvent, n3);
            float f3 = at.d(motionEvent, n3);
            this.f[n4] = f2;
            this.g[n4] = f3;
            ++n3;
        }
    }

    private int d(int n2, int n3) {
        int n4 = this.u.getLeft() + this.o;
        int n5 = 0;
        if (n2 < n4) {
            n5 = 1;
        }
        if (n3 < this.u.getTop() + this.o) {
            n5 |= 4;
        }
        if (n2 > this.u.getRight() - this.o) {
            n5 |= 2;
        }
        if (n3 <= this.u.getBottom() - this.o) return n5;
        n5 |= 8;
        return n5;
    }

    private void d() {
        this.l.computeCurrentVelocity(1000, this.m);
        this.a(this.a(android.support.v4.h.bj.a(this.l, this.c), this.n, this.m), this.a(android.support.v4.h.bj.b(this.l, this.c), this.n, this.m));
    }

    public int a() {
        return this.b;
    }

    void a(int n2) {
        this.u.removeCallbacks(this.w);
        if (this.a == n2) return;
        this.a = n2;
        this.r.a(n2);
        if (this.a != 0) return;
        this.s = null;
    }

    public void a(View view, int n2) {
        if (view.getParent() != this.u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + (Object)this.u + ")");
        }
        this.s = view;
        this.c = n2;
        this.r.b(view, n2);
        this.a(1);
    }

    public boolean a(int n2, int n3) {
        if (this.t) return this.a(n2, n3, (int)android.support.v4.h.bj.a(this.l, this.c), (int)android.support.v4.h.bj.b(this.l, this.c));
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public boolean a(MotionEvent motionEvent) {
        int n2 = at.a(motionEvent);
        int n3 = at.b(motionEvent);
        if (n2 == 0) {
            this.b();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        switch (n2) {
            case 0: {
                int n4;
                float f2 = motionEvent.getX();
                float f3 = motionEvent.getY();
                int n5 = at.b(motionEvent, 0);
                this.a(f2, f3, n5);
                View view = this.c((int)f2, (int)f3);
                if (view == this.s && this.a == 2) {
                    this.b(view, n5);
                }
                if (((n4 = this.h[n5]) & this.p) == 0) break;
                this.r.a(n4 & this.p, n5);
                break;
            }
            case 5: {
                View view;
                int n6 = at.b(motionEvent, n3);
                float f4 = at.c(motionEvent, n3);
                float f5 = at.d(motionEvent, n3);
                this.a(f4, f5, n6);
                if (this.a == 0) {
                    int n7 = this.h[n6];
                    if ((n7 & this.p) == 0) break;
                    this.r.a(n7 & this.p, n6);
                    break;
                }
                if (this.a != 2 || (view = this.c((int)f4, (int)f5)) != this.s) break;
                this.b(view, n6);
                break;
            }
            case 2: {
                if (this.d == null || this.e == null) break;
                int n8 = at.c(motionEvent);
                for (int i2 = 0; i2 < n8; ++i2) {
                    int n9 = at.b(motionEvent, i2);
                    float f6 = at.c(motionEvent, i2);
                    float f7 = at.d(motionEvent, i2);
                    float f8 = f6 - this.d[n9];
                    float f9 = f7 - this.e[n9];
                    View view = this.c((int)f6, (int)f7);
                    boolean bl2 = view != null && this.a(view, f8, f9);
                    if (bl2) {
                        int n10 = view.getLeft();
                        int n11 = n10 + (int)f8;
                        int n12 = this.r.b(view, n11, (int)f8);
                        int n13 = view.getTop();
                        int n14 = n13 + (int)f9;
                        int n15 = this.r.a(view, n14, (int)f9);
                        int n16 = this.r.b(view);
                        int n17 = this.r.a(view);
                        if ((n16 == 0 || n16 > 0 && n12 == n10) && (n17 == 0 || n17 > 0 && n15 == n13)) break;
                    }
                    this.b(f8, f9, n9);
                    if (this.a == 1 || bl2 && this.b(view, n9)) break;
                }
                this.c(motionEvent);
                break;
            }
            case 6: {
                this.b(at.b(motionEvent, n3));
                break;
            }
            case 1: 
            case 3: {
                this.b();
            }
        }
        if (this.a != 1) return false;
        return true;
    }

    public boolean a(View view, int n2, int n3) {
        this.s = view;
        this.c = -1;
        boolean bl2 = this.a(n2, n3, 0, 0);
        if (bl2) return bl2;
        if (this.a != 0) return bl2;
        if (this.s == null) return bl2;
        this.s = null;
        return bl2;
    }

    public boolean a(boolean bl2) {
        if (this.a == 2) {
            boolean bl3;
            boolean bl4 = this.q.g();
            int n2 = this.q.b();
            int n3 = this.q.c();
            int n4 = n2 - this.s.getLeft();
            int n5 = n3 - this.s.getTop();
            if (n4 != 0) {
                bo.f(this.s, n4);
            }
            if (n5 != 0) {
                bo.e(this.s, n5);
            }
            if (n4 != 0 || n5 != 0) {
                this.r.a(this.s, n2, n3, n4, n5);
            }
            if (bl4 && n2 == this.q.d() && n3 == this.q.e()) {
                this.q.h();
                bl3 = false;
            } else {
                bl3 = bl4;
            }
            if (!bl3) {
                if (bl2) {
                    this.u.post(this.w);
                } else {
                    this.a(0);
                }
            }
        }
        if (this.a != 2) return false;
        return true;
    }

    public void b() {
        this.c = -1;
        this.c();
        if (this.l == null) return;
        this.l.recycle();
        this.l = null;
    }

    /*
     * Unable to fully structure code
     */
    public void b(MotionEvent var1_1) {
        block20 : {
            var2_2 = 0;
            var3_3 = at.a(var1_1);
            var4_4 = at.b(var1_1);
            if (var3_3 == 0) {
                this.b();
            }
            if (this.l == null) {
                this.l = VelocityTracker.obtain();
            }
            this.l.addMovement(var1_1);
            switch (var3_3) {
                default: {
                    return;
                }
                case 0: {
                    var29_5 = var1_1.getX();
                    var30_6 = var1_1.getY();
                    var31_7 = at.b(var1_1, 0);
                    var32_8 = this.c((int)var29_5, (int)var30_6);
                    this.a(var29_5, var30_6, var31_7);
                    this.b(var32_8, var31_7);
                    var34_9 = this.h[var31_7];
                    if ((var34_9 & this.p) == 0) return;
                    this.r.a(var34_9 & this.p, var31_7);
                    return;
                }
                case 5: {
                    var23_10 = at.b(var1_1, var4_4);
                    var24_11 = at.c(var1_1, var4_4);
                    var25_12 = at.d(var1_1, var4_4);
                    this.a(var24_11, var25_12, var23_10);
                    if (this.a == 0) {
                        this.b(this.c((int)var24_11, (int)var25_12), var23_10);
                        var28_13 = this.h[var23_10];
                        if ((var28_13 & this.p) == 0) return;
                        this.r.a(var28_13 & this.p, var23_10);
                        return;
                    }
                    if (this.b((int)var24_11, (int)var25_12) == false) return;
                    this.b(this.s, var23_10);
                    return;
                }
                case 2: {
                    if (this.a == 1) {
                        var18_14 = at.a(var1_1, this.c);
                        var19_15 = at.c(var1_1, var18_14);
                        var20_16 = at.d(var1_1, var18_14);
                        var21_17 = (int)(var19_15 - this.f[this.c]);
                        var22_18 = (int)(var20_16 - this.g[this.c]);
                        this.b(var21_17 + this.s.getLeft(), var22_18 + this.s.getTop(), var21_17, var22_18);
                        this.c(var1_1);
                        return;
                    }
                    var11_19 = at.c(var1_1);
                    do {
                        if (var2_2 >= var11_19) ** GOTO lbl-1000
                        var12_22 = at.b(var1_1, var2_2);
                        var13_23 = at.c(var1_1, var2_2);
                        var14_24 = at.d(var1_1, var2_2);
                        var15_25 = var13_23 - this.d[var12_22];
                        var16_20 = var14_24 - this.e[var12_22];
                        this.b(var15_25, var16_20, var12_22);
                        if (this.a == 1 || this.a(var17_21 = this.c((int)var13_23, (int)var14_24), var15_25, var16_20) && this.b(var17_21, var12_22)) lbl-1000: // 2 sources:
                        {
                            this.c(var1_1);
                            return;
                        }
                        ++var2_2;
                    } while (true);
                }
                case 6: {
                    var5_26 = at.b(var1_1, var4_4);
                    if (this.a == 1 && var5_26 == this.c) {
                        var6_27 = at.c(var1_1);
                        while (var2_2 < var6_27) {
                            var8_28 = at.b(var1_1, var2_2);
                            if (var8_28 != this.c && this.c((int)(var9_29 = at.c(var1_1, var2_2)), (int)(var10_30 = at.d(var1_1, var2_2))) == this.s && this.b(this.s, var8_28)) {
                                var7_31 = this.c;
                                break block20;
                            }
                            ++var2_2;
                        }
                        break;
                    }
                    ** GOTO lbl88
                }
                case 1: {
                    if (this.a == 1) {
                        this.d();
                    }
                    this.b();
                    return;
                }
                case 3: {
                    if (this.a == 1) {
                        this.a(0.0f, 0.0f);
                    }
                    this.b();
                    return;
                }
            }
            var7_31 = -1;
        }
        if (var7_31 == -1) {
            this.d();
        }
lbl88: // 4 sources:
        this.b(var5_26);
    }

    public boolean b(int n2, int n3) {
        return this.b(this.s, n2, n3);
    }

    boolean b(View view, int n2) {
        if (view == this.s && this.c == n2) {
            return true;
        }
        if (view == null) return false;
        if (!this.r.a(view, n2)) return false;
        this.c = n2;
        this.a(view, n2);
        return true;
    }

    public boolean b(View view, int n2, int n3) {
        if (view == null) {
            return false;
        }
        if (n2 < view.getLeft()) return false;
        if (n2 >= view.getRight()) return false;
        if (n3 < view.getTop()) return false;
        if (n3 >= view.getBottom()) return false;
        return true;
    }

    public View c(int n2, int n3) {
        int n4 = -1 + this.u.getChildCount();
        while (n4 >= 0) {
            View view = this.u.getChildAt(this.r.c(n4));
            if (n2 >= view.getLeft() && n2 < view.getRight() && n3 >= view.getTop() && n3 < view.getBottom()) {
                return view;
            }
            --n4;
        }
        return null;
    }
}

