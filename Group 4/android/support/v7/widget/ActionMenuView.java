/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.z;
import android.support.v7.widget.cz;
import android.support.v7.widget.da;
import android.support.v7.widget.gz;
import android.support.v7.widget.k;
import android.support.v7.widget.t;
import android.support.v7.widget.u;
import android.support.v7.widget.v;
import android.support.v7.widget.w;
import android.support.v7.widget.x;
import android.support.v7.widget.y;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView
extends cz
implements android.support.v7.view.menu.k,
z {
    private i a;
    private Context b;
    private int c;
    private boolean d;
    private k e;
    private android.support.v7.view.menu.y f;
    private j g;
    private boolean h;
    private int i;
    private int j;
    private int k;
    private y l;

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.j = (int)(56.0f * f2);
        this.k = (int)(f2 * 4.0f);
        this.b = context;
        this.c = 0;
    }

    static int a(View view, int n2, int n3, int n4, int n5) {
        int n6;
        w w2 = (w)view.getLayoutParams();
        int n7 = View.MeasureSpec.makeMeasureSpec((int)(View.MeasureSpec.getSize((int)n4) - n5), (int)View.MeasureSpec.getMode((int)n4));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView)view : null;
        boolean bl2 = actionMenuItemView != null && actionMenuItemView.b();
        if (!(n3 <= 0 || bl2 && n3 < 2)) {
            view.measure(View.MeasureSpec.makeMeasureSpec((int)(n2 * n3), (int)Integer.MIN_VALUE), n7);
            int n8 = view.getMeasuredWidth();
            n6 = n8 / n2;
            if (n8 % n2 != 0) {
                ++n6;
            }
            if (bl2 && n6 < 2) {
                n6 = 2;
            }
        } else {
            n6 = 0;
        }
        boolean bl3 = w2.a;
        boolean bl4 = false;
        if (!bl3) {
            bl4 = false;
            if (bl2) {
                bl4 = true;
            }
        }
        w2.d = bl4;
        w2.b = n6;
        view.measure(View.MeasureSpec.makeMeasureSpec((int)(n6 * n2), (int)1073741824), n7);
        return n6;
    }

    static /* synthetic */ y a(ActionMenuView actionMenuView) {
        return actionMenuView.l;
    }

    static /* synthetic */ j b(ActionMenuView actionMenuView) {
        return actionMenuView.g;
    }

    /*
     * Unable to fully structure code
     */
    private void c(int var1_1, int var2_2) {
        block33 : {
            var3_3 = View.MeasureSpec.getMode((int)var2_2);
            var4_4 = View.MeasureSpec.getSize((int)var1_1);
            var5_5 = View.MeasureSpec.getSize((int)var2_2);
            var6_6 = this.getPaddingLeft() + this.getPaddingRight();
            var7_7 = this.getPaddingTop() + this.getPaddingBottom();
            var8_8 = ActionMenuView.getChildMeasureSpec((int)var2_2, (int)var7_7, (int)-2);
            var9_9 = var4_4 - var6_6;
            var10_10 = var9_9 / this.j;
            var11_11 = var9_9 % this.j;
            if (var10_10 == 0) {
                this.setMeasuredDimension(var9_9, 0);
                return;
            }
            var12_12 = this.j + var11_11 / var10_10;
            var13_13 = 0;
            var14_14 = 0;
            var15_15 = 0;
            var16_16 = 0;
            var17_17 = false;
            var18_18 = 0;
            var20_19 = this.getChildCount();
            var21_20 = 0;
            do {
                if (var21_20 >= var20_19) break;
                var60_37 = this.getChildAt(var21_20);
                if (var60_37.getVisibility() == 8) {
                    var73_30 = var16_16;
                    var79_35 = var18_18;
                    var77_33 = var13_13;
                    var78_34 = var10_10;
                    var74_31 = var14_14;
                } else {
                    var61_38 = var60_37 instanceof ActionMenuItemView;
                    var62_39 = var16_16 + 1;
                    if (var61_38) {
                        var60_37.setPadding(this.k, 0, this.k, 0);
                    }
                    var63_40 = (w)var60_37.getLayoutParams();
                    var63_40.f = false;
                    var63_40.c = 0;
                    var63_40.b = 0;
                    var63_40.d = false;
                    var63_40.leftMargin = 0;
                    var63_40.rightMargin = 0;
                    var64_21 = var61_38 != false && ((ActionMenuItemView)var60_37).b() != false;
                    var63_40.e = var64_21;
                    var65_22 = var63_40.a != false ? 1 : var10_10;
                    var66_23 = ActionMenuView.a(var60_37, var12_12, var65_22, var8_8, var7_7);
                    var67_24 = Math.max(var14_14, var66_23);
                    var68_25 = var63_40.d != false ? var15_15 + 1 : var15_15;
                    var69_26 = var63_40.a != false ? true : var17_17;
                    var70_27 = var10_10 - var66_23;
                    var71_28 = var60_37.getMeasuredHeight();
                    var72_29 = Math.max(var13_13, var71_28);
                    if (var66_23 == 1) {
                        var81_36 = var18_18 | (long)(1 << var21_20);
                        var77_33 = var72_29;
                        var78_34 = var70_27;
                        var15_15 = var68_25;
                        var17_17 = var69_26;
                        var79_35 = var81_36;
                        var74_31 = var67_24;
                        var73_30 = var62_39;
                    } else {
                        var73_30 = var62_39;
                        var74_31 = var67_24;
                        var75_32 = var18_18;
                        var77_33 = var72_29;
                        var78_34 = var70_27;
                        var17_17 = var69_26;
                        var15_15 = var68_25;
                        var79_35 = var75_32;
                    }
                }
                ++var21_20;
                var14_14 = var74_31;
                var13_13 = var77_33;
                var10_10 = var78_34;
                var18_18 = var79_35;
                var16_16 = var73_30;
            } while (true);
            var22_41 = var17_17 != false && var16_16 == 2;
            var23_42 = false;
            var24_43 = var18_18;
            var26_44 = var10_10;
            do {
                block31 : {
                    block32 : {
                        if (var15_15 > 0 && var26_44 > 0) ** GOTO lbl86
                        var27_60 = var24_43;
                        ** GOTO lbl110
lbl86: // 1 sources:
                        var42_45 = Integer.MAX_VALUE;
                        var43_46 = 0;
                        var45_47 = 0;
                        var46_48 = 0;
                        do {
                            if (var46_48 >= var20_19) ** GOTO lbl107
                            var57_57 = (w)this.getChildAt(var46_48).getLayoutParams();
                            if (var57_57.d) ** GOTO lbl97
                            var58_58 = var45_47;
                            var59_59 = var42_45;
                            ** GOTO lbl131
lbl97: // 1 sources:
                            if (var57_57.b >= var42_45) ** GOTO lbl102
                            var59_59 = var57_57.b;
                            var43_46 = 1 << var46_48;
                            var58_58 = 1;
                            ** GOTO lbl131
lbl102: // 1 sources:
                            if (var57_57.b != var42_45) ** GOTO lbl129
                            var43_46 |= (long)(1 << var46_48);
                            var58_58 = var45_47 + 1;
                            var59_59 = var42_45;
                            ** GOTO lbl131
lbl107: // 1 sources:
                            var47_49 = var24_43 | var43_46;
                            if (var45_47 <= var26_44) ** GOTO lbl123
                            var27_60 = var47_49;
lbl110: // 2 sources:
                            var29_61 = var17_17 == false && var16_16 == 1;
                            if (var26_44 <= 0 || var27_60 == 0 || var26_44 >= (var34_62 = var16_16 - 1) && !var29_61 && var14_14 <= true) ** GOTO lbl127
                            var35_63 = Long.bitCount(var27_60);
                            if (var29_61) ** GOTO lbl-1000
                            if ((1 & var27_60) != 0 && !((w)this.getChildAt((int)0).getLayoutParams()).e) {
                                var35_63 -= 0.5f;
                            }
                            if ((var27_60 & (long)(1 << var20_19 - 1)) != 0 && !((w)this.getChildAt((int)(var20_19 - 1)).getLayoutParams()).e) {
                                var36_64 = var35_63 - 0.5f;
                            } else lbl-1000: // 2 sources:
                            {
                                var36_64 = var35_63;
                            }
                            var37_65 = var36_64 > 0.0f ? (int)((float)(var26_44 * var12_12) / var36_64) : 0;
                            var30_67 = var23_42;
                            break;
lbl123: // 1 sources:
                            var49_50 = var42_45 + 1;
                            var51_52 = var26_44;
                            var52_53 = var47_49;
                            break block31;
lbl127: // 1 sources:
                            var30_67 = var23_42;
                            break block32;
lbl129: // 1 sources:
                            var58_58 = var45_47;
                            var59_59 = var42_45;
lbl131: // 4 sources:
                            ++var46_48;
                            var42_45 = var59_59;
                            var45_47 = var58_58;
                        } while (true);
                        for (var38_66 = 0; var38_66 < var20_19; ++var38_66) {
                            if ((var27_60 & (long)(1 << var38_66)) == 0) {
                                var41_70 = var30_67;
                            } else {
                                var39_68 = this.getChildAt(var38_66);
                                var40_69 = (w)var39_68.getLayoutParams();
                                if (var39_68 instanceof ActionMenuItemView) {
                                    var40_69.c = var37_65;
                                    var40_69.f = true;
                                    if (var38_66 == 0 && !var40_69.e) {
                                        var40_69.leftMargin = (- var37_65) / 2;
                                    }
                                    var41_70 = true;
                                } else if (var40_69.a) {
                                    var40_69.c = var37_65;
                                    var40_69.f = true;
                                    var40_69.rightMargin = (- var37_65) / 2;
                                    var41_70 = true;
                                } else {
                                    if (var38_66 != 0) {
                                        var40_69.leftMargin = var37_65 / 2;
                                    }
                                    if (var38_66 != var20_19 - 1) {
                                        var40_69.rightMargin = var37_65 / 2;
                                    }
                                    var41_70 = var30_67;
                                }
                            }
                            var30_67 = var41_70;
                        }
                    }
                    if (var30_67) {
                        break;
                    }
                    break block33;
                }
                for (var50_51 = 0; var50_51 < var20_19; ++var50_51) {
                    var54_54 = this.getChildAt(var50_51);
                    var55_55 = (w)var54_54.getLayoutParams();
                    if ((var43_46 & (long)(1 << var50_51)) == 0) {
                        if (var55_55.b == var49_50) {
                            var52_53 |= (long)(1 << var50_51);
                            var56_56 = var51_52;
                        } else {
                            var56_56 = var51_52;
                        }
                    } else {
                        if (var22_41 && var55_55.e && var51_52 == 1) {
                            var54_54.setPadding(var12_12 + this.k, 0, this.k, 0);
                        }
                        var55_55.b = 1 + var55_55.b;
                        var55_55.f = true;
                        var56_56 = var51_52 - 1;
                    }
                    var51_52 = var56_56;
                }
                var24_43 = var52_53;
                var23_42 = true;
                var26_44 = var51_52;
            } while (true);
            for (var31_71 = 0; var31_71 < var20_19; ++var31_71) {
                var32_72 = this.getChildAt(var31_71);
                var33_73 = (w)var32_72.getLayoutParams();
                if (!var33_73.f) continue;
                var32_72.measure(View.MeasureSpec.makeMeasureSpec((int)(var12_12 * var33_73.b + var33_73.c), (int)1073741824), var8_8);
            }
        }
        if (var3_3 == 1073741824) {
            var13_13 = var5_5;
        }
        this.setMeasuredDimension(var9_9, var13_13);
    }

    public w a(AttributeSet attributeSet) {
        return new w(this.getContext(), attributeSet);
    }

    protected w a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) return this.b();
        w w2 = layoutParams instanceof w ? new w((w)layoutParams) : new w(layoutParams);
        if (w2.h > 0) return w2;
        w2.h = 16;
        return w2;
    }

    @Override
    public void a(i i2) {
        this.a = i2;
    }

    public void a(android.support.v7.view.menu.y y2, j j2) {
        this.f = y2;
        this.g = j2;
    }

    public boolean a() {
        return this.d;
    }

    protected boolean a(int n2) {
        if (n2 == 0) {
            return false;
        }
        View view = this.getChildAt(n2 - 1);
        View view2 = this.getChildAt(n2);
        int n3 = this.getChildCount();
        boolean bl2 = false;
        if (n2 < n3) {
            boolean bl3 = view instanceof u;
            bl2 = false;
            if (bl3) {
                bl2 = false | ((u)view).d();
            }
        }
        if (n2 <= 0) return bl2;
        if (!(view2 instanceof u)) return bl2;
        return bl2 | ((u)view2).c();
    }

    @Override
    public boolean a(m m2) {
        return this.a.a(m2, 0);
    }

    @Override
    public /* synthetic */ da b(AttributeSet attributeSet) {
        return this.a(attributeSet);
    }

    @Override
    protected /* synthetic */ da b(ViewGroup.LayoutParams layoutParams) {
        return this.a(layoutParams);
    }

    protected w b() {
        w w2 = new w(-2, -2);
        w2.h = 16;
        return w2;
    }

    public w c() {
        w w2 = this.b();
        w2.a = true;
        return w2;
    }

    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) return false;
        if (!(layoutParams instanceof w)) return false;
        return true;
    }

    public i d() {
        return this.a;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public boolean e() {
        if (this.e == null) return false;
        if (!this.e.d()) return false;
        return true;
    }

    public boolean f() {
        if (this.e == null) return false;
        if (!this.e.e()) return false;
        return true;
    }

    public boolean g() {
        if (this.e == null) return false;
        if (!this.e.h()) return false;
        return true;
    }

    @Override
    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return this.b();
    }

    @Override
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return this.a(attributeSet);
    }

    @Override
    protected /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return this.a(layoutParams);
    }

    public Menu getMenu() {
        if (this.a != null) return this.a;
        Context context = this.getContext();
        this.a = new i(context);
        this.a.a(new x(this, null));
        this.e = new k(context);
        this.e.c(true);
        k k2 = this.e;
        android.support.v7.view.menu.y y2 = this.f != null ? this.f : new v(this, null);
        k2.a(y2);
        this.a.a(this.e, this.b);
        this.e.a(this);
        return this.a;
    }

    public Drawable getOverflowIcon() {
        this.getMenu();
        return this.e.c();
    }

    public int getPopupTheme() {
        return this.c;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public boolean h() {
        if (this.e == null) return false;
        if (!this.e.i()) return false;
        return true;
    }

    public void i() {
        if (this.e == null) return;
        this.e.f();
    }

    @Override
    protected /* synthetic */ da j() {
        return this.b();
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        if (this.e == null) return;
        this.e.b(false);
        if (!this.e.h()) return;
        this.e.e();
        this.e.d();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i();
    }

    @Override
    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        if (!this.h) {
            super.onLayout(bl2, n2, n3, n4, n5);
            return;
        }
        int n6 = this.getChildCount();
        int n7 = (n5 - n3) / 2;
        int n8 = this.getDividerWidth();
        int n9 = 0;
        int n10 = 0;
        int n11 = n4 - n2 - this.getPaddingRight() - this.getPaddingLeft();
        boolean bl3 = false;
        boolean bl4 = gz.a((View)this);
        for (int i2 = 0; i2 < n6; ++i2) {
            int n12;
            boolean bl5;
            int n13;
            int n14;
            View view = this.getChildAt(i2);
            if (view.getVisibility() == 8) {
                bl5 = bl3;
                n12 = n10;
                n13 = n11;
                n14 = n9;
            } else {
                w w2 = (w)view.getLayoutParams();
                if (w2.a) {
                    int n15;
                    int n16;
                    int n17 = view.getMeasuredWidth();
                    if (this.a(i2)) {
                        n17 += n8;
                    }
                    int n18 = view.getMeasuredHeight();
                    if (bl4) {
                        n16 = this.getPaddingLeft() + w2.leftMargin;
                        n15 = n16 + n17;
                    } else {
                        n15 = this.getWidth() - this.getPaddingRight() - w2.rightMargin;
                        n16 = n15 - n17;
                    }
                    int n19 = n7 - n18 / 2;
                    view.layout(n16, n19, n15, n18 + n19);
                    n13 = n11 - n17;
                    bl5 = true;
                    n12 = n10;
                    n14 = n9;
                } else {
                    int n20 = view.getMeasuredWidth() + w2.leftMargin + w2.rightMargin;
                    int n21 = n9 + n20;
                    int n22 = n11 - n20;
                    if (this.a(i2)) {
                        n21 += n8;
                    }
                    int n23 = n10 + 1;
                    boolean bl6 = bl3;
                    n13 = n22;
                    n12 = n23;
                    n14 = n21;
                    bl5 = bl6;
                }
            }
            n9 = n14;
            n11 = n13;
            n10 = n12;
            bl3 = bl5;
        }
        if (n6 == 1 && !bl3) {
            View view = this.getChildAt(0);
            int n24 = view.getMeasuredWidth();
            int n25 = view.getMeasuredHeight();
            int n26 = (n4 - n2) / 2 - n24 / 2;
            int n27 = n7 - n25 / 2;
            view.layout(n26, n27, n24 + n26, n25 + n27);
            return;
        }
        int n28 = bl3 ? 0 : 1;
        int n29 = n10 - n28;
        int n30 = n29 > 0 ? n11 / n29 : 0;
        int n31 = Math.max(0, n30);
        if (bl4) {
            int n32 = this.getWidth() - this.getPaddingRight();
            int n33 = 0;
            while (n33 < n6) {
                int n34;
                View view = this.getChildAt(n33);
                w w3 = (w)view.getLayoutParams();
                if (view.getVisibility() != 8) {
                    if (w3.a) {
                        n34 = n32;
                    } else {
                        int n35 = n32 - w3.rightMargin;
                        int n36 = view.getMeasuredWidth();
                        int n37 = view.getMeasuredHeight();
                        int n38 = n7 - n37 / 2;
                        view.layout(n35 - n36, n38, n35, n37 + n38);
                        n34 = n35 - (n31 + (n36 + w3.leftMargin));
                    }
                } else {
                    n34 = n32;
                }
                ++n33;
                n32 = n34;
            }
            return;
        }
        int n39 = this.getPaddingLeft();
        int n40 = 0;
        while (n40 < n6) {
            int n41;
            View view = this.getChildAt(n40);
            w w4 = (w)view.getLayoutParams();
            if (view.getVisibility() != 8) {
                if (w4.a) {
                    n41 = n39;
                } else {
                    int n42 = n39 + w4.leftMargin;
                    int n43 = view.getMeasuredWidth();
                    int n44 = view.getMeasuredHeight();
                    int n45 = n7 - n44 / 2;
                    view.layout(n42, n45, n42 + n43, n44 + n45);
                    n41 = n42 + (n31 + (n43 + w4.rightMargin));
                }
            } else {
                n41 = n39;
            }
            ++n40;
            n39 = n41;
        }
    }

    @Override
    protected void onMeasure(int n2, int n3) {
        boolean bl2 = this.h;
        boolean bl3 = View.MeasureSpec.getMode((int)n2) == 1073741824;
        this.h = bl3;
        if (bl2 != this.h) {
            this.i = 0;
        }
        int n4 = View.MeasureSpec.getSize((int)n2);
        if (this.h && this.a != null && n4 != this.i) {
            this.i = n4;
            this.a.b(true);
        }
        int n5 = this.getChildCount();
        if (this.h && n5 > 0) {
            this.c(n2, n3);
            return;
        }
        int n6 = 0;
        do {
            if (n6 >= n5) {
                super.onMeasure(n2, n3);
                return;
            }
            w w2 = (w)this.getChildAt(n6).getLayoutParams();
            w2.rightMargin = 0;
            w2.leftMargin = 0;
            ++n6;
        } while (true);
    }

    public void setExpandedActionViewsExclusive(boolean bl2) {
        this.e.d(bl2);
    }

    public void setOnMenuItemClickListener(y y2) {
        this.l = y2;
    }

    public void setOverflowIcon(Drawable drawable) {
        this.getMenu();
        this.e.a(drawable);
    }

    public void setOverflowReserved(boolean bl2) {
        this.d = bl2;
    }

    public void setPopupTheme(int n2) {
        if (this.c == n2) return;
        this.c = n2;
        if (n2 == 0) {
            this.b = this.getContext();
            return;
        }
        this.b = new ContextThemeWrapper(this.getContext(), n2);
    }

    public void setPresenter(k k2) {
        this.e = k2;
        this.e.a(this);
    }
}

