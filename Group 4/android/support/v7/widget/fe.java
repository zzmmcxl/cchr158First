/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.support.v4.e.i;
import android.support.v4.h.bo;
import android.support.v4.widget.as;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ef;
import android.support.v7.widget.ep;
import android.support.v7.widget.ew;
import android.support.v7.widget.fa;
import android.support.v7.widget.fc;
import android.view.View;
import android.view.animation.Interpolator;

class fe
implements Runnable {
    final /* synthetic */ RecyclerView a;
    private int b;
    private int c;
    private as d;
    private Interpolator e;
    private boolean f;
    private boolean g;

    public fe(RecyclerView recyclerView) {
        this.a = recyclerView;
        this.e = RecyclerView.q();
        this.f = false;
        this.g = false;
        this.d = as.a(recyclerView.getContext(), RecyclerView.q());
    }

    private float a(float f2) {
        return (float)Math.sin((float)(0.4712389167638204 * (double)(f2 - 0.5f)));
    }

    private int b(int n2, int n3, int n4, int n5) {
        int n6;
        int n7;
        int n8 = Math.abs(n2);
        boolean bl2 = n8 > (n7 = Math.abs(n3));
        int n9 = (int)Math.sqrt(n4 * n4 + n5 * n5);
        int n10 = (int)Math.sqrt(n2 * n2 + n3 * n3);
        int n11 = bl2 ? this.a.getWidth() : this.a.getHeight();
        int n12 = n11 / 2;
        float f2 = Math.min(1.0f, 1.0f * (float)n10 / (float)n11);
        float f3 = (float)n12 + (float)n12 * this.a(f2);
        if (n9 > 0) {
            n6 = 4 * Math.round(1000.0f * Math.abs(f3 / (float)n9));
            return Math.min(n6, 2000);
        }
        int n13 = bl2 ? n8 : n7;
        n6 = (int)(300.0f * (1.0f + (float)n13 / (float)n11));
        return Math.min(n6, 2000);
    }

    private void c() {
        this.g = false;
        this.f = true;
    }

    private void d() {
        this.f = false;
        if (!this.g) return;
        this.a();
    }

    void a() {
        if (this.f) {
            this.g = true;
            return;
        }
        this.a.removeCallbacks((Runnable)this);
        bo.a((View)this.a, this);
    }

    public void a(int n2, int n3) {
        RecyclerView.b(this.a, 2);
        this.c = 0;
        this.b = 0;
        this.d.a(0, 0, n2, n3, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        this.a();
    }

    public void a(int n2, int n3, int n4) {
        this.a(n2, n3, n4, RecyclerView.q());
    }

    public void a(int n2, int n3, int n4, int n5) {
        this.a(n2, n3, this.b(n2, n3, n4, n5));
    }

    public void a(int n2, int n3, int n4, Interpolator interpolator) {
        if (this.e != interpolator) {
            this.e = interpolator;
            this.d = as.a(this.a.getContext(), interpolator);
        }
        RecyclerView.b(this.a, 2);
        this.c = 0;
        this.b = 0;
        this.d.a(0, 0, n2, n3, n4);
        this.a();
    }

    public void b() {
        this.a.removeCallbacks((Runnable)this);
        this.d.h();
    }

    public void b(int n2, int n3) {
        this.a(n2, n3, 0, 0);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void run() {
        if (this.a.e == null) {
            this.b();
            return;
        }
        this.c();
        RecyclerView.c(this.a);
        var1_1 = this.d;
        var2_2 = this.a.e.r;
        if (!var1_1.g()) ** GOTO lbl91
        var3_3 = var1_1.b();
        var4_4 = var1_1.c();
        var5_5 = var3_3 - this.b;
        var6_6 = var4_4 - this.c;
        this.b = var3_3;
        this.c = var4_4;
        var7_7 = RecyclerView.f(this.a);
        var8_8 = 0;
        var9_9 = 0;
        var10_10 = 0;
        var11_11 = 0;
        if (var7_7 == null) ** GOTO lbl54
        this.a.b();
        RecyclerView.g(this.a);
        i.a("RV Scroll");
        var10_10 = 0;
        var11_11 = 0;
        if (var5_5 != 0) {
            var11_11 = this.a.e.a(var5_5, this.a.a, this.a.g);
            var10_10 = var5_5 - var11_11;
        }
        var8_8 = 0;
        var9_9 = 0;
        if (var6_6 != 0) {
            var9_9 = this.a.e.b(var6_6, this.a.a, this.a.g);
            var8_8 = var6_6 - var9_9;
        }
        i.a();
        RecyclerView.h(this.a);
        RecyclerView.i(this.a);
        this.a.a(false);
        if (var2_2 == null || var2_2.b() || !var2_2.c()) ** GOTO lbl54
        var21_12 = this.a.g.e();
        if (var21_12 == 0) {
            var2_2.a();
            var23_13 = var10_10;
            var13_14 = var9_9;
            var14_15 = var23_13;
        } else if (var2_2.d() >= var21_12) {
            var2_2.a(var21_12 - 1);
            fa.a(var2_2, var5_5 - var10_10, var6_6 - var8_8);
            var22_22 = var10_10;
            var13_14 = var9_9;
            var14_15 = var22_22;
        } else {
            fa.a(var2_2, var5_5 - var10_10, var6_6 - var8_8);
lbl54: // 3 sources:
            var12_23 = var10_10;
            var13_14 = var9_9;
            var14_15 = var12_23;
        }
        if (!RecyclerView.j(this.a).isEmpty()) {
            this.a.invalidate();
        }
        if (bo.a((View)this.a) != 2) {
            RecyclerView.a(this.a, var5_5, var6_6);
        }
        if (var14_15 != 0 || var8_8 != 0) {
            var15_16 = (int)var1_1.f();
            if (var14_15 != var3_3) {
                var20_17 = var14_15 < 0 ? - var15_16 : (var14_15 > 0 ? var15_16 : 0);
                var16_18 = var20_17;
            } else {
                var16_18 = 0;
            }
            if (var8_8 != var4_4) {
                if (var8_8 < 0) {
                    var15_16 = - var15_16;
                } else if (var8_8 <= 0) {
                    var15_16 = 0;
                }
            } else {
                var15_16 = 0;
            }
            if (bo.a((View)this.a) != 2) {
                this.a.c(var16_18, var15_16);
            }
            if (!(var16_18 == 0 && var14_15 != var3_3 && var1_1.d() != 0 || var15_16 == 0 && var8_8 != var4_4 && var1_1.e() != 0)) {
                var1_1.h();
            }
        }
        if (var11_11 != 0 || var13_14 != 0) {
            this.a.g(var11_11, var13_14);
        }
        if (!RecyclerView.k(this.a)) {
            this.a.invalidate();
        }
        var17_19 = var6_6 != 0 && this.a.e.e() != false && var13_14 == var6_6;
        var18_20 = var5_5 != 0 && this.a.e.d() != false && var11_11 == var5_5;
        var19_21 = var5_5 == 0 && (var6_6 == 0 || var18_20 != false) || var17_19 != false;
        if (var1_1.a() || !var19_21) {
            RecyclerView.b(this.a, 0);
        } else {
            this.a();
        }
lbl91: // 3 sources:
        if (var2_2 != null) {
            if (var2_2.b()) {
                fa.a(var2_2, 0, 0);
            }
            if (!this.g) {
                var2_2.a();
            }
        }
        this.d();
    }
}

