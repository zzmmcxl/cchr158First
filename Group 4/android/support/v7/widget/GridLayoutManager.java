/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.h.a.g;
import android.support.v4.h.a.r;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearLayoutManager$SavedState;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.cv;
import android.support.v7.widget.cw;
import android.support.v7.widget.cx;
import android.support.v7.widget.db;
import android.support.v7.widget.dc;
import android.support.v7.widget.dd;
import android.support.v7.widget.dw;
import android.support.v7.widget.eq;
import android.support.v7.widget.er;
import android.support.v7.widget.ew;
import android.support.v7.widget.fc;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;
import java.util.List;

public class GridLayoutManager
extends LinearLayoutManager {
    boolean a = false;
    int b = -1;
    int[] c;
    View[] d;
    final SparseIntArray e = new SparseIntArray();
    final SparseIntArray f = new SparseIntArray();
    cx g = new cv();
    final Rect h = new Rect();

    public GridLayoutManager(Context context, int n2) {
        super(context);
        this.a(n2);
    }

    public GridLayoutManager(Context context, int n2, int n3, boolean bl2) {
        super(context, n3, bl2);
        this.a(n2);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int n2, int n3) {
        super(context, attributeSet, n2, n3);
        this.a(GridLayoutManager.a((Context)context, (AttributeSet)attributeSet, (int)n2, (int)n3).b);
    }

    private void H() {
        this.e.clear();
        this.f.clear();
    }

    private void I() {
        int n2 = this.s();
        int n3 = 0;
        while (n3 < n2) {
            cw cw2 = (cw)this.h(n3).getLayoutParams();
            int n4 = cw2.e();
            this.e.put(n4, cw2.b());
            this.f.put(n4, cw2.a());
            ++n3;
        }
    }

    private void J() {
        int n2 = this.f() == 1 ? this.v() - this.z() - this.x() : this.w() - this.A() - this.y();
        this.l(n2);
    }

    private void K() {
        if (this.d != null) {
            if (this.d.length == this.b) return;
        }
        this.d = new View[this.b];
    }

    private int a(ew ew2, fc fc2, int n2) {
        if (!fc2.a()) {
            return this.g.c(n2, this.b);
        }
        int n3 = ew2.b(n2);
        if (n3 != -1) return this.g.c(n3, this.b);
        Log.w((String)"GridLayoutManager", (String)("Cannot find span size for pre layout position. " + n2));
        return 0;
    }

    private void a(float f2, int n2) {
        this.l(Math.max(Math.round(f2 * (float)this.b), n2));
    }

    private void a(ew ew2, fc fc2, int n2, int n3, boolean bl2) {
        int n4;
        int n5;
        int n6;
        int n7;
        if (bl2) {
            n6 = 1;
            n4 = 0;
        } else {
            n4 = n2 - 1;
            n6 = -1;
            n2 = -1;
        }
        if (this.i == 1 && this.g()) {
            n5 = -1 + this.b;
            n7 = -1;
        } else {
            n7 = 1;
            n5 = 0;
        }
        int n8 = n5;
        int n9 = n4;
        while (n9 != n2) {
            View view = this.d[n9];
            cw cw2 = (cw)view.getLayoutParams();
            cw.a(cw2, this.c(ew2, fc2, this.d(view)));
            if (n7 == -1 && cw.b(cw2) > 1) {
                cw.b(cw2, n8 - (-1 + cw.b(cw2)));
            } else {
                cw.b(cw2, n8);
            }
            n8 += n7 * cw.b(cw2);
            n9 += n6;
        }
    }

    private void a(View view, int n2, int n3, boolean bl2, boolean bl3) {
        this.a(view, this.h);
        er er2 = (er)view.getLayoutParams();
        if (bl2 || this.i == 1) {
            n2 = this.b(n2, er2.leftMargin + this.h.left, er2.rightMargin + this.h.right);
        }
        if (bl2 || this.i == 0) {
            n3 = this.b(n3, er2.topMargin + this.h.top, er2.bottomMargin + this.h.bottom);
        }
        boolean bl4 = bl3 ? this.a(view, n2, n3, er2) : this.b(view, n2, n3, er2);
        if (!bl4) return;
        view.measure(n2, n3);
    }

    static int[] a(int[] arrn, int n2, int n3) {
        int n4 = 0;
        if (arrn == null || arrn.length != n2 + 1 || arrn[-1 + arrn.length] != n3) {
            arrn = new int[n2 + 1];
        }
        arrn[0] = 0;
        int n5 = n3 / n2;
        int n6 = n3 % n2;
        int n7 = 1;
        int n8 = 0;
        while (n7 <= n2) {
            int n9;
            if ((n4 += n6) > 0 && n2 - n4 < n6) {
                n9 = n5 + 1;
                n4 -= n2;
            } else {
                n9 = n5;
            }
            arrn[n7] = n8 += n9;
            ++n7;
        }
        return arrn;
    }

    private int b(int n2, int n3, int n4) {
        if (n3 == 0 && n4 == 0) {
            return n2;
        }
        int n5 = View.MeasureSpec.getMode((int)n2);
        if (n5 == Integer.MIN_VALUE) return View.MeasureSpec.makeMeasureSpec((int)(View.MeasureSpec.getSize((int)n2) - n3 - n4), (int)n5);
        if (n5 != 1073741824) return n2;
        return View.MeasureSpec.makeMeasureSpec((int)(View.MeasureSpec.getSize((int)n2) - n3 - n4), (int)n5);
    }

    private int b(ew ew2, fc fc2, int n2) {
        if (!fc2.a()) {
            return this.g.b(n2, this.b);
        }
        int n3 = this.f.get(n2, -1);
        if (n3 != -1) return n3;
        int n4 = ew2.b(n2);
        if (n4 != -1) return this.g.b(n4, this.b);
        Log.w((String)"GridLayoutManager", (String)("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + n2));
        return 0;
    }

    private void b(ew ew2, fc fc2, db db2, int n2) {
        int n3;
        int n4;
        int n5 = 1;
        if (n2 != n5) {
            n5 = 0;
        }
        int n6 = this.b(ew2, fc2, db2.a);
        if (n5 != 0) {
            while (n6 > 0) {
                if (db2.a <= 0) return;
                db2.a = -1 + db2.a;
                n6 = this.b(ew2, fc2, db2.a);
            }
            return;
        }
        int n7 = -1 + fc2.e();
        int n8 = n6;
        for (n4 = db2.a; n4 < n7 && (n3 = this.b(ew2, fc2, n4 + 1)) > n8; ++n4) {
            n8 = n3;
        }
        db2.a = n4;
    }

    private int c(ew ew2, fc fc2, int n2) {
        if (!fc2.a()) {
            return this.g.a(n2);
        }
        int n3 = this.e.get(n2, -1);
        if (n3 != -1) return n3;
        int n4 = ew2.b(n2);
        if (n4 != -1) return this.g.a(n4);
        Log.w((String)"GridLayoutManager", (String)("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + n2));
        return 1;
    }

    private void l(int n2) {
        this.c = GridLayoutManager.a(this.c, this.b, n2);
    }

    @Override
    public int a(int n2, ew ew2, fc fc2) {
        this.J();
        this.K();
        return super.a(n2, ew2, fc2);
    }

    @Override
    public int a(ew ew2, fc fc2) {
        if (this.i == 0) {
            return this.b;
        }
        if (fc2.e() >= 1) return 1 + this.a(ew2, fc2, -1 + fc2.e());
        return 0;
    }

    @Override
    public er a() {
        if (this.i != 0) return new cw(-1, -2);
        return new cw(-2, -1);
    }

    @Override
    public er a(Context context, AttributeSet attributeSet) {
        return new cw(context, attributeSet);
    }

    @Override
    public er a(ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) return new cw(layoutParams);
        return new cw((ViewGroup.MarginLayoutParams)layoutParams);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    View a(ew var1_1, fc var2_2, int var3_3, int var4_4, int var5_5) {
        var6_6 = null;
        this.h();
        var7_7 = this.j.c();
        var8_8 = this.j.d();
        var9_9 = var4_4 > var3_3 ? 1 : -1;
        var10_10 = null;
        while (var3_3 != var4_4) {
            var11_11 = this.h(var3_3);
            var12_12 = this.d(var11_11);
            if (var12_12 < 0 || var12_12 >= var5_5) ** GOTO lbl-1000
            if (this.b(var1_1, var2_2, var12_12) == 0) ** GOTO lbl15
            var13_13 = var6_6;
            var11_11 = var10_10;
            ** GOTO lbl27
lbl15: // 1 sources:
            if (!((er)var11_11.getLayoutParams()).c()) ** GOTO lbl19
            if (var10_10 != null) ** GOTO lbl-1000
            var13_13 = var6_6;
            ** GOTO lbl27
lbl19: // 1 sources:
            if (this.j.a(var11_11) < var8_8) {
                if (this.j.b(var11_11) >= var7_7) return var11_11;
            }
            if (var6_6 == null) {
                var13_13 = var11_11;
                var11_11 = var10_10;
            } else lbl-1000: // 3 sources:
            {
                var13_13 = var6_6;
                var11_11 = var10_10;
            }
lbl27: // 4 sources:
            var3_3 += var9_9;
            var6_6 = var13_13;
            var10_10 = var11_11;
        }
        if (var6_6 != null) return var6_6;
        var6_6 = var10_10;
        return var6_6;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public View a(View var1_1, int var2_2, ew var3_3, fc var4_4) {
        var5_5 = this.e(var1_1);
        if (var5_5 == null) {
            return null;
        }
        var6_7 = (cw)var5_5.getLayoutParams();
        var7_8 = cw.a(var6_7);
        var8_9 = cw.a(var6_7) + cw.b(var6_7);
        if (super.a(var1_1, var2_2, var3_3, var4_4) == null) {
            return null;
        }
        var9_10 = this.e(var2_2) == 1;
        var10_11 = var9_10 != this.k;
        if (var10_11) {
            var14_12 = -1 + this.s();
            var12_13 = -1;
            var13_14 = -1;
        } else {
            var11_15 = this.s();
            var12_13 = 1;
            var13_14 = var11_15;
            var14_12 = 0;
        }
        var15_16 = this.i == 1 && this.g() != false;
        var16_17 = null;
        var17_18 = -1;
        var18_19 = 0;
        var19_20 = var14_12;
        while (var19_20 != var13_14) {
            var20_6 = this.h(var19_20);
            if (var20_6 == var5_5) {
                return var16_17;
            }
            if (var20_6.isFocusable()) ** GOTO lbl34
            var28_28 = var18_19;
            var29_29 = var17_18;
            var30_30 = var16_17;
            ** GOTO lbl61
lbl34: // 1 sources:
            var21_21 = (cw)var20_6.getLayoutParams();
            var22_22 = cw.a(var21_21);
            var23_23 = cw.a(var21_21) + cw.b(var21_21);
            if (var22_22 == var7_8) {
                if (var23_23 == var8_9) return var20_6;
            }
            if (var16_17 != null) ** GOTO lbl42
            var26_26 = true;
            ** GOTO lbl53
lbl42: // 1 sources:
            var24_24 = Math.max(var22_22, var7_8);
            var25_25 = Math.min(var23_23, var8_9) - var24_24;
            if (var25_25 <= var18_19) ** GOTO lbl47
            var26_26 = true;
            ** GOTO lbl53
lbl47: // 1 sources:
            var26_26 = false;
            if (var25_25 != var18_19) ** GOTO lbl-1000
            var27_27 = var22_22 > var17_18;
            var26_26 = false;
            if (var15_16 != var27_27) ** GOTO lbl-1000
            var26_26 = true;
lbl53: // 3 sources:
            if (var26_26) {
                var29_29 = cw.a(var21_21);
                var28_28 = Math.min(var23_23, var8_9) - Math.max(var22_22, var7_8);
                var30_30 = var20_6;
            } else lbl-1000: // 3 sources:
            {
                var28_28 = var18_19;
                var29_29 = var17_18;
                var30_30 = var16_17;
            }
lbl61: // 3 sources:
            var19_20 += var12_13;
            var16_17 = var30_30;
            var17_18 = var29_29;
            var18_19 = var28_28;
        }
        return var16_17;
    }

    public void a(int n2) {
        if (n2 == this.b) {
            return;
        }
        this.a = true;
        if (n2 < 1) {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + n2);
        }
        this.b = n2;
        this.g.a();
    }

    @Override
    public void a(Rect rect, int n2, int n3) {
        int n4;
        int n5;
        if (this.c == null) {
            super.a(rect, n2, n3);
        }
        int n6 = this.x() + this.z();
        int n7 = this.y() + this.A();
        if (this.i == 1) {
            n5 = GridLayoutManager.a(n3, n7 + rect.height(), this.D());
            n4 = GridLayoutManager.a(n2, n6 + this.c[-1 + this.c.length], this.C());
        } else {
            n4 = GridLayoutManager.a(n2, n6 + rect.width(), this.C());
            n5 = GridLayoutManager.a(n3, n7 + this.c[-1 + this.c.length], this.D());
        }
        this.d(n4, n5);
    }

    @Override
    public void a(RecyclerView recyclerView) {
        this.g.a();
    }

    @Override
    public void a(RecyclerView recyclerView, int n2, int n3) {
        this.g.a();
    }

    @Override
    public void a(RecyclerView recyclerView, int n2, int n3, int n4) {
        this.g.a();
    }

    @Override
    public void a(RecyclerView recyclerView, int n2, int n3, Object object) {
        this.g.a();
    }

    @Override
    void a(ew ew2, fc fc2, db db2, int n2) {
        super.a(ew2, fc2, db2, n2);
        this.J();
        if (fc2.e() > 0 && !fc2.a()) {
            this.b(ew2, fc2, db2, n2);
        }
        this.K();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    void a(ew var1_1, fc var2_2, dd var3_3, dc var4_4) {
        var5_5 = this.j.i();
        var6_6 = var5_5 != 1073741824;
        var7_7 = this.s() > 0 ? this.c[this.b] : 0;
        if (var6_6) {
            this.J();
        }
        var8_8 = var3_3.e == 1;
        var9_9 = this.b;
        var10_10 = 0;
        var11_11 = 0;
        if (!var8_8) {
            var9_9 = this.b(var1_1, var2_2, var3_3.d) + this.c(var1_1, var2_2, var3_3.d);
        }
        while (var10_10 < this.b && var3_3.a(var2_2) && var9_9 > 0) {
            var61_12 = var3_3.d;
            var62_13 = this.c(var1_1, var2_2, var61_12);
            if (var62_13 > this.b) {
                throw new IllegalArgumentException("Item at position " + var61_12 + " requires " + var62_13 + " spans but GridLayoutManager has only " + this.b + " spans.");
            }
            if ((var9_9 -= var62_13) < 0 || (var63_14 = var3_3.a(var1_1)) == null) break;
            var11_11 += var62_13;
            this.d[var10_10] = var63_14;
            ++var10_10;
        }
        if (var10_10 == 0) {
            var4_4.b = true;
            return;
        }
        this.a(var1_1, var2_2, var10_10, var11_11, var8_8);
        var12_15 = 0;
        var13_16 = 0.0f;
        var14_17 = 0;
        do {
            if (var12_15 >= var10_10) ** GOTO lbl56
            var50_18 = this.d[var12_15];
            if (var3_3.k == null) {
                if (var8_8) {
                    this.b(var50_18);
                } else {
                    this.b(var50_18, 0);
                }
            } else if (var8_8) {
                this.a(var50_18);
            } else {
                this.a(var50_18, 0);
            }
            var51_19 = (cw)var50_18.getLayoutParams();
            var52_20 = this.c[cw.a(var51_19) + cw.b(var51_19)] - this.c[cw.a(var51_19)];
            var53_21 = this.i == 0 ? var51_19.height : var51_19.width;
            var54_22 = GridLayoutManager.a(var52_20, var5_5, 0, var53_21, false);
            var55_23 = this.j.f();
            var56_24 = this.j.h();
            var57_25 = this.i == 1 ? var51_19.height : var51_19.width;
            var58_26 = GridLayoutManager.a(var55_23, var56_24, 0, var57_25, true);
            if (this.i == 1) {
                this.a(var50_18, var54_22, var58_26, false, false);
            } else {
                this.a(var50_18, var58_26, var54_22, false, false);
            }
            if ((var59_27 = this.j.c(var50_18)) <= var14_17) ** GOTO lbl59
            ** GOTO lbl60
lbl56: // 1 sources:
            if (var6_6) {
                break;
            }
            ** GOTO lbl86
lbl59: // 1 sources:
            var59_27 = var14_17;
lbl60: // 2 sources:
            if ((var60_28 = 1.0f * (float)this.j.d(var50_18) / (float)cw.b(var51_19)) <= var13_16) {
                var60_28 = var13_16;
            }
            ++var12_15;
            var13_16 = var60_28;
            var14_17 = var59_27;
        } while (true);
        this.a(var13_16, var7_7);
        var14_17 = 0;
        var39_29 = 0;
        do {
            if (var39_29 >= var10_10) ** GOTO lbl86
            var40_30 = this.d[var39_29];
            var41_31 = (cw)var40_30.getLayoutParams();
            var42_32 = this.c[cw.a(var41_31) + cw.b(var41_31)] - this.c[cw.a(var41_31)];
            var43_33 = this.i == 0 ? var41_31.height : var41_31.width;
            var44_34 = GridLayoutManager.a(var42_32, 1073741824, 0, var43_33, false);
            var45_35 = this.j.f();
            var46_36 = this.j.h();
            var47_37 = this.i == 1 ? var41_31.height : var41_31.width;
            var48_38 = GridLayoutManager.a(var45_35, var46_36, 0, var47_37, true);
            if (this.i == 1) {
                this.a(var40_30, var44_34, var48_38, false, true);
            } else {
                this.a(var40_30, var48_38, var44_34, false, true);
            }
            if ((var49_39 = this.j.c(var40_30)) <= var14_17) ** GOTO lbl88
            ** GOTO lbl89
lbl86: // 2 sources:
            var15_40 = View.MeasureSpec.makeMeasureSpec((int)var14_17, (int)1073741824);
            break;
lbl88: // 1 sources:
            var49_39 = var14_17;
lbl89: // 2 sources:
            ++var39_29;
            var14_17 = var49_39;
        } while (true);
        for (var16_41 = 0; var16_41 < var10_10; ++var16_41) {
            var34_42 = this.d[var16_41];
            if (this.j.c(var34_42) == var14_17) continue;
            var35_43 = (cw)var34_42.getLayoutParams();
            var36_44 = this.c[cw.a(var35_43) + cw.b(var35_43)] - this.c[cw.a(var35_43)];
            var37_45 = this.i == 0 ? var35_43.height : var35_43.width;
            var38_46 = GridLayoutManager.a(var36_44, 1073741824, 0, var37_45, false);
            if (this.i == 1) {
                this.a(var34_42, var38_46, var15_40, true, true);
                continue;
            }
            this.a(var34_42, var15_40, var38_46, true, true);
        }
        var4_4.a = var14_17;
        if (this.i == 1) {
            if (var3_3.f == -1) {
                var19_47 = var3_3.b;
                var20_48 = var19_47 - var14_17;
                var18_49 = 0;
                var17_50 = 0;
            } else {
                var20_48 = var3_3.b;
                var19_47 = var20_48 + var14_17;
                var18_49 = 0;
                var17_50 = 0;
            }
        } else if (var3_3.f == -1) {
            var33_51 = var3_3.b;
            var17_50 = var33_51 - var14_17;
            var18_49 = var33_51;
            var19_47 = 0;
            var20_48 = 0;
        } else {
            var17_50 = var3_3.b;
            var18_49 = var14_17 + var17_50;
            var19_47 = 0;
            var20_48 = 0;
        }
        var21_52 = 0;
        var22_53 = var17_50;
        var23_54 = var18_49;
        var24_55 = var20_48;
        var25_56 = var19_47;
        do {
            if (var21_52 >= var10_10) {
                Arrays.fill(this.d, null);
                return;
            }
            var26_57 = this.d[var21_52];
            var27_58 = (cw)var26_57.getLayoutParams();
            if (this.i == 1) {
                if (this.g()) {
                    var31_62 = this.x() + this.c[cw.a(var27_58) + cw.b(var27_58)];
                    var32_63 = var31_62 - this.j.d(var26_57);
                    var28_59 = var31_62;
                    var29_60 = var32_63;
                } else {
                    var30_61 = this.x() + this.c[cw.a(var27_58)];
                    var28_59 = var30_61 + this.j.d(var26_57);
                    var29_60 = var30_61;
                }
            } else {
                var24_55 = this.y() + this.c[cw.a(var27_58)];
                var25_56 = var24_55 + this.j.d(var26_57);
                var28_59 = var23_54;
                var29_60 = var22_53;
            }
            this.a(var26_57, var29_60 + var27_58.leftMargin, var24_55 + var27_58.topMargin, var28_59 - var27_58.rightMargin, var25_56 - var27_58.bottomMargin);
            if (var27_58.c() || var27_58.d()) {
                var4_4.c = true;
            }
            var4_4.d |= var26_57.isFocusable();
            ++var21_52;
            var23_54 = var28_59;
            var22_53 = var29_60;
        } while (true);
    }

    @Override
    public void a(ew ew2, fc fc2, View view, g g2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof cw)) {
            super.a(view, g2);
            return;
        }
        cw cw2 = (cw)layoutParams;
        int n2 = this.a(ew2, fc2, cw2.e());
        if (this.i == 0) {
            int n3 = cw2.a();
            int n4 = cw2.b();
            boolean bl2 = this.b > 1 && cw2.b() == this.b;
            g2.b(r.a(n3, n4, n2, 1, bl2, false));
            return;
        }
        int n5 = cw2.a();
        int n6 = cw2.b();
        boolean bl3 = this.b > 1 && cw2.b() == this.b;
        g2.b(r.a(n2, 1, n5, n6, bl3, false));
    }

    @Override
    public void a(boolean bl2) {
        if (bl2) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.a(false);
    }

    @Override
    public boolean a(er er2) {
        return er2 instanceof cw;
    }

    @Override
    public int b(int n2, ew ew2, fc fc2) {
        this.J();
        this.K();
        return super.b(n2, ew2, fc2);
    }

    @Override
    public int b(ew ew2, fc fc2) {
        if (this.i == 1) {
            return this.b;
        }
        if (fc2.e() >= 1) return 1 + this.a(ew2, fc2, -1 + fc2.e());
        return 0;
    }

    @Override
    public void b(RecyclerView recyclerView, int n2, int n3) {
        this.g.a();
    }

    @Override
    public boolean b() {
        if (this.n != null) return false;
        if (this.a) return false;
        return true;
    }

    @Override
    public void c(ew ew2, fc fc2) {
        if (fc2.a()) {
            this.I();
        }
        super.c(ew2, fc2);
        this.H();
        if (fc2.a()) return;
        this.a = false;
    }
}

