/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.ar;
import android.support.design.widget.at;
import android.support.design.widget.cl;
import android.support.v4.h.bj;
import android.support.v4.h.bo;
import android.support.v4.widget.as;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

abstract class aq
extends cl {
    private Runnable a;
    private as b;
    private boolean c;
    private int d = -1;
    private int e;
    private int f = -1;
    private VelocityTracker g;

    public aq() {
    }

    public aq(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    static /* synthetic */ as a(aq aq2) {
        return aq2.b;
    }

    private void c() {
        if (this.g != null) return;
        this.g = VelocityTracker.obtain();
    }

    int a() {
        return this.b();
    }

    int a(CoordinatorLayout coordinatorLayout, View view, int n2, int n3, int n4) {
        int n5 = this.b();
        int n6 = 0;
        if (n3 == 0) return n6;
        n6 = 0;
        if (n5 < n3) return n6;
        n6 = 0;
        if (n5 > n4) return n6;
        int n7 = at.a(n2, n3, n4);
        n6 = 0;
        if (n5 == n7) return n6;
        this.a(n7);
        return n5 - n7;
    }

    int a(View view) {
        return view.getHeight();
    }

    void a(CoordinatorLayout coordinatorLayout, View view) {
    }

    final boolean a(CoordinatorLayout coordinatorLayout, View view, int n2, int n3, float f2) {
        if (this.a != null) {
            view.removeCallbacks(this.a);
            this.a = null;
        }
        if (this.b == null) {
            this.b = as.a(view.getContext());
        }
        this.b.a(0, this.b(), 0, Math.round(f2), 0, 0, n2, n3);
        if (this.b.g()) {
            this.a = new ar(this, coordinatorLayout, view);
            bo.a(view, this.a);
            return true;
        }
        this.a(coordinatorLayout, view);
        return false;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public boolean a(CoordinatorLayout var1_1, View var2_2, MotionEvent var3_3) {
        if (this.f < 0) {
            this.f = ViewConfiguration.get((Context)var1_1.getContext()).getScaledTouchSlop();
        }
        if (var3_3.getAction() == 2 && this.c) {
            return true;
        }
        switch (android.support.v4.h.at.a(var3_3)) {
            case 0: {
                this.c = false;
                var7_4 = (int)var3_3.getX();
                var8_5 = (int)var3_3.getY();
                if (this.c(var2_2) && var1_1.a(var2_2, var7_4, var8_5)) {
                    this.e = var8_5;
                    this.d = android.support.v4.h.at.b(var3_3, 0);
                    this.c();
                    ** break;
                }
                ** GOTO lbl21
            }
            case 2: {
                var4_6 = this.d;
                if (var4_6 != -1 && (var5_7 = android.support.v4.h.at.a(var3_3, var4_6)) != -1 && Math.abs((var6_8 = (int)android.support.v4.h.at.d(var3_3, var5_7)) - this.e) > this.f) {
                    this.c = true;
                    this.e = var6_8;
                }
            }
lbl21: // 6 sources:
            default: {
                ** GOTO lbl29
            }
            case 1: 
            case 3: 
        }
        this.c = false;
        this.d = -1;
        if (this.g != null) {
            this.g.recycle();
            this.g = null;
        }
lbl29: // 4 sources:
        if (this.g == null) return this.c;
        this.g.addMovement(var3_3);
        return this.c;
    }

    int a_(CoordinatorLayout coordinatorLayout, View view, int n2) {
        return this.a(coordinatorLayout, view, n2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    final int b(CoordinatorLayout coordinatorLayout, View view, int n2, int n3, int n4) {
        return this.a(coordinatorLayout, view, this.a() - n2, n3, n4);
    }

    int b(View view) {
        return - view.getHeight();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public boolean b(CoordinatorLayout var1_1, View var2_2, MotionEvent var3_3) {
        if (this.f < 0) {
            this.f = ViewConfiguration.get((Context)var1_1.getContext()).getScaledTouchSlop();
        }
        switch (android.support.v4.h.at.a(var3_3)) {
            case 0: {
                var11_5 = (int)var3_3.getX();
                var12_6 = (int)var3_3.getY();
                var13_7 = var1_1.a(var2_2, var11_5, var12_6);
                var4_4 = false;
                if (var13_7 == false) return var4_4;
                var14_8 = this.c(var2_2);
                var4_4 = false;
                if (var14_8 == false) return var4_4;
                this.e = var12_6;
                this.d = android.support.v4.h.at.b(var3_3, 0);
                this.c();
                ** break;
            }
            case 2: {
                var7_9 = android.support.v4.h.at.a(var3_3, this.d);
                var4_4 = false;
                if (var7_9 == -1) return var4_4;
                var8_10 = (int)android.support.v4.h.at.d(var3_3, var7_9);
                var9_11 = this.e - var8_10;
                if (!this.c && Math.abs(var9_11) > this.f) {
                    this.c = true;
                    var9_11 = var9_11 > 0 ? (var9_11 -= this.f) : (var9_11 += this.f);
                }
                if (this.c) {
                    this.e = var8_10;
                    this.b(var1_1, var2_2, var9_11, this.b(var2_2), 0);
                }
            }
lbl29: // 5 sources:
            default: {
                ** GOTO lbl43
            }
            case 1: {
                if (this.g == null) break;
                this.g.addMovement(var3_3);
                this.g.computeCurrentVelocity(1000);
                var5_12 = bj.b(this.g, this.d);
                this.a(var1_1, var2_2, - this.a(var2_2), 0, var5_12);
            }
            case 3: 
        }
        this.c = false;
        this.d = -1;
        if (this.g != null) {
            this.g.recycle();
            this.g = null;
        }
lbl43: // 4 sources:
        if (this.g == null) return true;
        this.g.addMovement(var3_3);
        return true;
    }

    boolean c(View view) {
        return false;
    }
}

