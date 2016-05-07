/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.h.bo;
import android.support.v4.h.q;
import android.support.v7.b.l;
import android.support.v7.widget.da;
import android.support.v7.widget.gk;
import android.support.v7.widget.gz;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class cz
extends ViewGroup {
    private boolean a = true;
    private int b = -1;
    private int c = 0;
    private int d;
    private int e = 8388659;
    private int f;
    private float g;
    private boolean h;
    private int[] i;
    private int[] j;
    private Drawable k;
    private int l;
    private int m;
    private int n;
    private int o;

    public cz(Context context) {
        this(context, null);
    }

    public cz(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public cz(Context context, AttributeSet attributeSet, int n2) {
        int n3;
        boolean bl2;
        super(context, attributeSet, n2);
        gk gk2 = gk.a(context, attributeSet, l.LinearLayoutCompat, n2, 0);
        int n4 = gk2.a(l.LinearLayoutCompat_android_orientation, -1);
        if (n4 >= 0) {
            this.setOrientation(n4);
        }
        if ((n3 = gk2.a(l.LinearLayoutCompat_android_gravity, -1)) >= 0) {
            this.setGravity(n3);
        }
        if (!(bl2 = gk2.a(l.LinearLayoutCompat_android_baselineAligned, true))) {
            this.setBaselineAligned(bl2);
        }
        this.g = gk2.a(l.LinearLayoutCompat_android_weightSum, -1.0f);
        this.b = gk2.a(l.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.h = gk2.a(l.LinearLayoutCompat_measureWithLargestChild, false);
        this.setDividerDrawable(gk2.a(l.LinearLayoutCompat_divider));
        this.n = gk2.a(l.LinearLayoutCompat_showDividers, 0);
        this.o = gk2.e(l.LinearLayoutCompat_dividerPadding, 0);
        gk2.a();
    }

    private void a(View view, int n2, int n3, int n4, int n5) {
        view.layout(n2, n3, n2 + n4, n3 + n5);
    }

    private void c(int n2, int n3) {
        int n4 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredWidth(), (int)1073741824);
        int n5 = 0;
        while (n5 < n2) {
            View view = this.b(n5);
            if (view.getVisibility() != 8) {
                da da2 = (da)view.getLayoutParams();
                if (da2.width == -1) {
                    int n6 = da2.height;
                    da2.height = view.getMeasuredHeight();
                    this.measureChildWithMargins(view, n4, 0, n3, 0);
                    da2.height = n6;
                }
            }
            ++n5;
        }
    }

    private void d(int n2, int n3) {
        int n4 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredHeight(), (int)1073741824);
        int n5 = 0;
        while (n5 < n2) {
            View view = this.b(n5);
            if (view.getVisibility() != 8) {
                da da2 = (da)view.getLayoutParams();
                if (da2.height == -1) {
                    int n6 = da2.width;
                    da2.width = view.getMeasuredWidth();
                    this.measureChildWithMargins(view, n3, 0, n4, 0);
                    da2.width = n6;
                }
            }
            ++n5;
        }
    }

    int a(View view) {
        return 0;
    }

    int a(View view, int n2) {
        return 0;
    }

    /*
     * Unable to fully structure code
     */
    void a(int var1_1, int var2_2) {
        block34 : {
            this.f = 0;
            var3_3 = 0;
            var4_4 = 0;
            var5_5 = 0;
            var6_6 = 0;
            var7_7 = true;
            var8_8 = 0.0f;
            var9_9 = this.getVirtualChildCount();
            var10_10 = View.MeasureSpec.getMode((int)var1_1);
            var11_11 = View.MeasureSpec.getMode((int)var2_2);
            var12_12 = false;
            var13_13 = false;
            var14_14 = this.b;
            var15_15 = this.h;
            var16_16 = Integer.MIN_VALUE;
            for (var17_17 = 0; var17_17 < var9_9; ++var17_17) {
                var60_38 = this.b(var17_17);
                if (var60_38 == null) {
                    this.f += this.d(var17_17);
                    var80_34 = var16_16;
                    var78_32 = var13_13;
                    var75_29 = var7_7;
                    var81_35 = var4_4;
                    var79_33 = var3_3;
                } else if (var60_38.getVisibility() == 8) {
                    var17_17 += this.a(var60_38, var17_17);
                    var80_34 = var16_16;
                    var78_32 = var13_13;
                    var75_29 = var7_7;
                    var81_35 = var4_4;
                    var79_33 = var3_3;
                } else {
                    if (this.c(var17_17)) {
                        this.f += this.m;
                    }
                    var61_39 = (da)var60_38.getLayoutParams();
                    var62_40 = var8_8 + var61_39.g;
                    if (var11_11 == 1073741824 && var61_39.height == 0 && var61_39.g > 0.0f) {
                        var83_37 = this.f;
                        this.f = Math.max(var83_37, var83_37 + var61_39.topMargin + var61_39.bottomMargin);
                        var13_13 = true;
                    } else {
                        var63_41 = Integer.MIN_VALUE;
                        if (var61_39.height == 0 && var61_39.g > 0.0f) {
                            var63_41 = 0;
                            var61_39.height = -2;
                        }
                        var64_18 = var63_41;
                        var65_19 = var62_40 == 0.0f ? this.f : 0;
                        this.a(var60_38, var17_17, var1_1, 0, var2_2, var65_19);
                        if (var64_18 != Integer.MIN_VALUE) {
                            var61_39.height = var64_18;
                        }
                        var66_20 = var60_38.getMeasuredHeight();
                        var67_21 = this.f;
                        this.f = Math.max(var67_21, var67_21 + var66_20 + var61_39.topMargin + var61_39.bottomMargin + this.b(var60_38));
                        if (var15_15) {
                            var16_16 = Math.max(var66_20, var16_16);
                        }
                    }
                    if (var14_14 >= 0 && var14_14 == var17_17 + 1) {
                        this.c = this.f;
                    }
                    if (var17_17 < var14_14 && var61_39.g > 0.0f) {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                    if (var10_10 != 1073741824 && var61_39.width == -1) {
                        var68_22 = true;
                        var69_23 = true;
                    } else {
                        var68_22 = var12_12;
                        var69_23 = false;
                    }
                    var70_24 = var61_39.leftMargin + var61_39.rightMargin;
                    var71_25 = var70_24 + var60_38.getMeasuredWidth();
                    var72_26 = Math.max(var3_3, var71_25);
                    var73_27 = bo.j(var60_38);
                    var74_28 = gz.a(var4_4, var73_27);
                    var75_29 = var7_7 != false && var61_39.width == -1;
                    if (var61_39.g > 0.0f) {
                        var82_36 = var69_23 != false ? var70_24 : var71_25;
                        var77_31 = Math.max(var6_6, var82_36);
                        var76_30 = var5_5;
                    } else {
                        if (!var69_23) {
                            var70_24 = var71_25;
                        }
                        var76_30 = Math.max(var5_5, var70_24);
                        var77_31 = var6_6;
                    }
                    var17_17 += this.a(var60_38, var17_17);
                    var78_32 = var13_13;
                    var6_6 = var77_31;
                    var5_5 = var76_30;
                    var79_33 = var72_26;
                    var80_34 = var16_16;
                    var81_35 = var74_28;
                    var12_12 = var68_22;
                    var8_8 = var62_40;
                }
                var16_16 = var80_34;
                var13_13 = var78_32;
                var7_7 = var75_29;
                var4_4 = var81_35;
                var3_3 = var79_33;
            }
            if (this.f > 0 && this.c(var9_9)) {
                this.f += this.m;
            }
            if (var15_15 && (var11_11 == Integer.MIN_VALUE || var11_11 == 0)) {
                this.f = 0;
                var55_42 = 0;
                while (var55_42 < var9_9) {
                    var56_43 = this.b(var55_42);
                    if (var56_43 == null) {
                        this.f += this.d(var55_42);
                        var59_46 = var55_42;
                    } else if (var56_43.getVisibility() == 8) {
                        var59_46 = var55_42 + this.a(var56_43, var55_42);
                    } else {
                        var57_44 = (da)var56_43.getLayoutParams();
                        var58_45 = this.f;
                        this.f = Math.max(var58_45, var58_45 + var16_16 + var57_44.topMargin + var57_44.bottomMargin + this.b(var56_43));
                        var59_46 = var55_42;
                    }
                    var55_42 = var59_46 + 1;
                }
            }
            this.f += this.getPaddingTop() + this.getPaddingBottom();
            var18_47 = bo.a(Math.max(this.f, this.getSuggestedMinimumHeight()), var2_2, 0);
            var19_48 = (16777215 & var18_47) - this.f;
            if (!var13_13 && (var19_48 == 0 || var8_8 <= 0.0f)) ** GOTO lbl124
            if (this.g > 0.0f) {
                var8_8 = this.g;
            }
            ** GOTO lbl127
lbl124: // 1 sources:
            var52_81 = Math.max(var5_5, var6_6);
            if (!var15_15 || var11_11 == 1073741824) ** GOTO lbl205
            ** GOTO lbl200
lbl127: // 1 sources:
            this.f = 0;
            var20_49 = 0;
            var21_50 = var8_8;
            var22_51 = var7_7;
            var23_52 = var5_5;
            var24_53 = var4_4;
            var25_54 = var3_3;
            var26_55 = var19_48;
            do {
                if (var20_49 >= var9_9) ** GOTO lbl165
                var29_56 = this.b(var20_49);
                if (var29_56.getVisibility() != 8) ** GOTO lbl144
                var42_69 = var23_52;
                var45_72 = var24_53;
                var43_70 = var25_54;
                var40_67 = var22_51;
                ** GOTO lbl190
lbl144: // 1 sources:
                var30_57 = (da)var29_56.getLayoutParams();
                var31_58 = var30_57.g;
                if (var31_58 <= 0.0f) ** GOTO lbl171
                var46_73 = (int)(var31_58 * (float)var26_55 / var21_50);
                var47_74 = var21_50 - var31_58;
                var48_75 = var26_55 - var46_73;
                var49_76 = cz.getChildMeasureSpec((int)var1_1, (int)(this.getPaddingLeft() + this.getPaddingRight() + var30_57.leftMargin + var30_57.rightMargin), (int)var30_57.width);
                if (var30_57.height != 0 || var11_11 != 1073741824) {
                    var50_77 = var46_73 + var29_56.getMeasuredHeight();
                    if (var50_77 < 0) {
                        var50_77 = 0;
                    }
                    var29_56.measure(var49_76, View.MeasureSpec.makeMeasureSpec((int)var50_77, (int)1073741824));
                } else {
                    if (var46_73 <= 0) {
                        var46_73 = 0;
                    }
                    var29_56.measure(var49_76, View.MeasureSpec.makeMeasureSpec((int)var46_73, (int)1073741824));
                }
                var51_78 = gz.a(var24_53, -256 & bo.j(var29_56));
                var33_60 = var48_75;
                var34_61 = var51_78;
                var32_59 = var47_74;
                ** GOTO lbl174
lbl165: // 1 sources:
                this.f += this.getPaddingTop() + this.getPaddingBottom();
                var7_7 = var22_51;
                var27_79 = var23_52;
                var4_4 = var24_53;
                var28_80 = var25_54;
                break;
lbl171: // 1 sources:
                var32_59 = var21_50;
                var33_60 = var26_55;
                var34_61 = var24_53;
lbl174: // 2 sources:
                var35_62 = var30_57.leftMargin + var30_57.rightMargin;
                var36_63 = var35_62 + var29_56.getMeasuredWidth();
                var37_64 = Math.max(var25_54, var36_63);
                var38_65 = var10_10 != 1073741824 && var30_57.width == -1;
                if (!var38_65) {
                    var35_62 = var36_63;
                }
                var39_66 = Math.max(var23_52, var35_62);
                var40_67 = var22_51 != false && var30_57.width == -1;
                var41_68 = this.f;
                this.f = Math.max(var41_68, var41_68 + var29_56.getMeasuredHeight() + var30_57.topMargin + var30_57.bottomMargin + this.b(var29_56));
                var42_69 = var39_66;
                var43_70 = var37_64;
                var44_71 = var32_59;
                var45_72 = var34_61;
                var26_55 = var33_60;
                var21_50 = var44_71;
lbl190: // 2 sources:
                ++var20_49;
                var23_52 = var42_69;
                var25_54 = var43_70;
                var22_51 = var40_67;
                var24_53 = var45_72;
            } while (true);
lbl196: // 2 sources:
            while (var7_7 || var10_10 == 1073741824) {
                var27_79 = var28_80;
                break block34;
            }
            ** GOTO lbl208
lbl200: // 3 sources:
            for (var53_82 = 0; var53_82 < var9_9; ++var53_82) {
                var54_83 = this.b(var53_82);
                if (var54_83 == null || var54_83.getVisibility() == 8 || ((da)var54_83.getLayoutParams()).g <= 0.0f) continue;
                var54_83.measure(View.MeasureSpec.makeMeasureSpec((int)var54_83.getMeasuredWidth(), (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)var16_16, (int)1073741824));
            }
lbl205: // 2 sources:
            var27_79 = var52_81;
            var28_80 = var3_3;
            ** GOTO lbl196
        }
        this.setMeasuredDimension(bo.a(Math.max(var27_79 + (this.getPaddingLeft() + this.getPaddingRight()), this.getSuggestedMinimumWidth()), var1_1, var4_4), var18_47);
        if (var12_12 == false) return;
        this.c(var9_9, var2_2);
    }

    void a(int n2, int n3, int n4, int n5) {
        int n6;
        int n7 = this.getPaddingLeft();
        int n8 = n4 - n2;
        int n9 = n8 - this.getPaddingRight();
        int n10 = n8 - n7 - this.getPaddingRight();
        int n11 = this.getVirtualChildCount();
        int n12 = 112 & this.e;
        int n13 = 8388615 & this.e;
        switch (n12) {
            default: {
                n6 = this.getPaddingTop();
                break;
            }
            case 80: {
                n6 = n5 + this.getPaddingTop() - n3 - this.f;
                break;
            }
            case 16: {
                n6 = this.getPaddingTop() + (n5 - n3 - this.f) / 2;
            }
        }
        int n14 = 0;
        int n15 = n6;
        while (n14 < n11) {
            int n16;
            View view = this.b(n14);
            if (view == null) {
                n15 += this.d(n14);
                n16 = n14;
            } else if (view.getVisibility() != 8) {
                int n17;
                int n18 = view.getMeasuredWidth();
                int n19 = view.getMeasuredHeight();
                da da2 = (da)view.getLayoutParams();
                int n20 = da2.h;
                if (n20 < 0) {
                    n20 = n13;
                }
                switch (7 & q.a(n20, bo.h((View)this))) {
                    default: {
                        n17 = n7 + da2.leftMargin;
                        break;
                    }
                    case 1: {
                        n17 = n7 + (n10 - n18) / 2 + da2.leftMargin - da2.rightMargin;
                        break;
                    }
                    case 5: {
                        n17 = n9 - n18 - da2.rightMargin;
                        break;
                    }
                }
                int n21 = this.c(n14) ? n15 + this.m : n15;
                int n22 = n21 + da2.topMargin;
                this.a(view, n17, n22 + this.a(view), n18, n19);
                n15 = n22 + (n19 + da2.bottomMargin + this.b(view));
                n16 = n14 + this.a(view, n14);
            } else {
                n16 = n14;
            }
            n14 = n16 + 1;
        }
    }

    void a(Canvas canvas) {
        int n2;
        int n3 = this.getVirtualChildCount();
        for (int i2 = 0; i2 < n3; ++i2) {
            View view = this.b(i2);
            if (view == null || view.getVisibility() == 8 || !this.c(i2)) continue;
            da da2 = (da)view.getLayoutParams();
            this.a(canvas, view.getTop() - da2.topMargin - this.m);
        }
        if (!this.c(n3)) return;
        View view = this.b(n3 - 1);
        if (view == null) {
            n2 = this.getHeight() - this.getPaddingBottom() - this.m;
        } else {
            da da3 = (da)view.getLayoutParams();
            n2 = view.getBottom() + da3.bottomMargin;
        }
        this.a(canvas, n2);
    }

    void a(Canvas canvas, int n2) {
        this.k.setBounds(this.getPaddingLeft() + this.o, n2, this.getWidth() - this.getPaddingRight() - this.o, n2 + this.m);
        this.k.draw(canvas);
    }

    void a(View view, int n2, int n3, int n4, int n5, int n6) {
        this.measureChildWithMargins(view, n3, n4, n5, n6);
    }

    int b(View view) {
        return 0;
    }

    public da b(AttributeSet attributeSet) {
        return new da(this.getContext(), attributeSet);
    }

    protected da b(ViewGroup.LayoutParams layoutParams) {
        return new da(layoutParams);
    }

    View b(int n2) {
        return this.getChildAt(n2);
    }

    /*
     * Unable to fully structure code
     */
    void b(int var1_1, int var2_2) {
        block47 : {
            this.f = 0;
            var3_3 = 0;
            var4_4 = 0;
            var5_5 = 0;
            var6_6 = 0;
            var7_7 = true;
            var8_8 = 0.0f;
            var9_9 = this.getVirtualChildCount();
            var10_10 = View.MeasureSpec.getMode((int)var1_1);
            var11_11 = View.MeasureSpec.getMode((int)var2_2);
            var12_12 = false;
            var13_13 = false;
            if (this.i == null || this.j == null) {
                this.i = new int[4];
                this.j = new int[4];
            }
            var14_14 = this.i;
            var15_15 = this.j;
            var14_14[3] = -1;
            var14_14[2] = -1;
            var14_14[1] = -1;
            var14_14[0] = -1;
            var15_15[3] = -1;
            var15_15[2] = -1;
            var15_15[1] = -1;
            var15_15[0] = -1;
            var16_16 = this.a;
            var17_17 = this.h;
            var18_18 = var10_10 == 1073741824;
            var19_19 = Integer.MIN_VALUE;
            for (var20_20 = 0; var20_20 < var9_9; ++var20_20) {
                var69_21 = this.b(var20_20);
                if (var69_21 == null) {
                    this.f += this.d(var20_20);
                    var89_41 = var19_19;
                    var87_39 = var13_13;
                    var84_36 = var7_7;
                    var90_42 = var4_4;
                    var88_40 = var3_3;
                } else if (var69_21.getVisibility() == 8) {
                    var20_20 += this.a(var69_21, var20_20);
                    var89_41 = var19_19;
                    var87_39 = var13_13;
                    var84_36 = var7_7;
                    var90_42 = var4_4;
                    var88_40 = var3_3;
                } else {
                    if (this.c(var20_20)) {
                        this.f += this.l;
                    }
                    var70_22 = (da)var69_21.getLayoutParams();
                    var71_23 = var8_8 + var70_22.g;
                    if (var10_10 == 1073741824 && var70_22.width == 0 && var70_22.g > 0.0f) {
                        if (var18_18) {
                            this.f += var70_22.leftMargin + var70_22.rightMargin;
                        } else {
                            var95_47 = this.f;
                            this.f = Math.max(var95_47, var95_47 + var70_22.leftMargin + var70_22.rightMargin);
                        }
                        if (var16_16) {
                            var96_48 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
                            var69_21.measure(var96_48, var96_48);
                        } else {
                            var13_13 = true;
                        }
                    } else {
                        var72_24 = Integer.MIN_VALUE;
                        if (var70_22.width == 0 && var70_22.g > 0.0f) {
                            var72_24 = 0;
                            var70_22.width = -2;
                        }
                        var73_25 = var72_24;
                        var74_26 = var71_23 == 0.0f ? this.f : 0;
                        this.a(var69_21, var20_20, var1_1, var74_26, var2_2, 0);
                        if (var73_25 != Integer.MIN_VALUE) {
                            var70_22.width = var73_25;
                        }
                        var75_27 = var69_21.getMeasuredWidth();
                        if (var18_18) {
                            this.f += var75_27 + var70_22.leftMargin + var70_22.rightMargin + this.b(var69_21);
                        } else {
                            var76_28 = this.f;
                            this.f = Math.max(var76_28, var76_28 + var75_27 + var70_22.leftMargin + var70_22.rightMargin + this.b(var69_21));
                        }
                        if (var17_17) {
                            var19_19 = Math.max(var75_27, var19_19);
                        }
                    }
                    if (var11_11 != 1073741824 && var70_22.height == -1) {
                        var77_29 = true;
                        var78_30 = true;
                    } else {
                        var77_29 = var12_12;
                        var78_30 = false;
                    }
                    var79_31 = var70_22.topMargin + var70_22.bottomMargin;
                    var80_32 = var79_31 + var69_21.getMeasuredHeight();
                    var81_33 = bo.j(var69_21);
                    var82_34 = gz.a(var4_4, var81_33);
                    if (var16_16 && (var92_44 = var69_21.getBaseline()) != -1) {
                        var93_45 = var70_22.h < 0 ? this.e : var70_22.h;
                        var94_46 = (-2 & (var93_45 & 112) >> 4) >> 1;
                        var14_14[var94_46] = Math.max(var14_14[var94_46], var92_44);
                        var15_15[var94_46] = Math.max(var15_15[var94_46], var80_32 - var92_44);
                    }
                    var83_35 = Math.max(var3_3, var80_32);
                    var84_36 = var7_7 != false && var70_22.height == -1;
                    if (var70_22.g > 0.0f) {
                        var91_43 = var78_30 != false ? var79_31 : var80_32;
                        var86_38 = Math.max(var6_6, var91_43);
                        var85_37 = var5_5;
                    } else {
                        if (!var78_30) {
                            var79_31 = var80_32;
                        }
                        var85_37 = Math.max(var5_5, var79_31);
                        var86_38 = var6_6;
                    }
                    var20_20 += this.a(var69_21, var20_20);
                    var87_39 = var13_13;
                    var6_6 = var86_38;
                    var5_5 = var85_37;
                    var88_40 = var83_35;
                    var89_41 = var19_19;
                    var90_42 = var82_34;
                    var12_12 = var77_29;
                    var8_8 = var71_23;
                }
                var19_19 = var89_41;
                var13_13 = var87_39;
                var7_7 = var84_36;
                var4_4 = var90_42;
                var3_3 = var88_40;
            }
            if (this.f > 0 && this.c(var9_9)) {
                this.f += this.l;
            }
            if (var14_14[1] != -1 || var14_14[0] != -1 || var14_14[2] != -1 || var14_14[3] != -1) {
                var21_49 = Math.max(var14_14[3], Math.max(var14_14[0], Math.max(var14_14[1], var14_14[2]))) + Math.max(var15_15[3], Math.max(var15_15[0], Math.max(var15_15[1], var15_15[2])));
                var22_50 = Math.max(var3_3, var21_49);
            } else {
                var22_50 = var3_3;
            }
            if (var17_17 && (var10_10 == Integer.MIN_VALUE || var10_10 == 0)) {
                this.f = 0;
                var64_51 = 0;
                while (var64_51 < var9_9) {
                    var65_52 = this.b(var64_51);
                    if (var65_52 == null) {
                        this.f += this.d(var64_51);
                        var68_55 = var64_51;
                    } else if (var65_52.getVisibility() == 8) {
                        var68_55 = var64_51 + this.a(var65_52, var64_51);
                    } else {
                        var66_53 = (da)var65_52.getLayoutParams();
                        if (var18_18) {
                            this.f += var19_19 + var66_53.leftMargin + var66_53.rightMargin + this.b(var65_52);
                            var68_55 = var64_51;
                        } else {
                            var67_54 = this.f;
                            this.f = Math.max(var67_54, var67_54 + var19_19 + var66_53.leftMargin + var66_53.rightMargin + this.b(var65_52));
                            var68_55 = var64_51;
                        }
                    }
                    var64_51 = var68_55 + 1;
                }
            }
            this.f += this.getPaddingLeft() + this.getPaddingRight();
            var23_56 = bo.a(Math.max(this.f, this.getSuggestedMinimumWidth()), var1_1, 0);
            var24_57 = (16777215 & var23_56) - this.f;
            if (!var13_13 && (var24_57 == 0 || var8_8 <= 0.0f)) ** GOTO lbl158
            if (this.g > 0.0f) {
                var8_8 = this.g;
            }
            ** GOTO lbl161
lbl158: // 1 sources:
            var61_94 = Math.max(var5_5, var6_6);
            if (!var17_17 || var10_10 == 1073741824) ** GOTO lbl263
            ** GOTO lbl258
lbl161: // 1 sources:
            var14_14[3] = -1;
            var14_14[2] = -1;
            var14_14[1] = -1;
            var14_14[0] = -1;
            var15_15[3] = -1;
            var15_15[2] = -1;
            var15_15[1] = -1;
            var15_15[0] = -1;
            this.f = 0;
            var25_58 = 0;
            var26_59 = var8_8;
            var27_60 = var7_7;
            var28_61 = var5_5;
            var29_62 = var4_4;
            var30_63 = var24_57;
            var31_64 = -1;
            do {
                if (var25_58 >= var9_9) ** GOTO lbl207
                var35_65 = this.b(var25_58);
                if (var35_65 == null) ** GOTO lbl242
                if (var35_65.getVisibility() != 8) ** GOTO lbl188
                var36_66 = var26_59;
                var37_67 = var30_63;
                var38_68 = var31_64;
                var39_69 = var28_61;
                var40_70 = var27_60;
                ** GOTO lbl247
lbl188: // 1 sources:
                var41_71 = (da)var35_65.getLayoutParams();
                var42_72 = var41_71.g;
                if (var42_72 <= 0.0f) ** GOTO lbl215
                var57_87 = (int)(var42_72 * (float)var30_63 / var26_59);
                var58_88 = var26_59 - var42_72;
                var43_73 = var30_63 - var57_87;
                var59_89 = cz.getChildMeasureSpec((int)var2_2, (int)(this.getPaddingTop() + this.getPaddingBottom() + var41_71.topMargin + var41_71.bottomMargin), (int)var41_71.height);
                if (var41_71.width != 0 || var10_10 != 1073741824) {
                    var60_90 = var57_87 + var35_65.getMeasuredWidth();
                    if (var60_90 < 0) {
                        var60_90 = 0;
                    }
                    var35_65.measure(View.MeasureSpec.makeMeasureSpec((int)var60_90, (int)1073741824), var59_89);
                } else {
                    if (var57_87 <= 0) {
                        var57_87 = 0;
                    }
                    var35_65.measure(View.MeasureSpec.makeMeasureSpec((int)var57_87, (int)1073741824), var59_89);
                }
                var44_74 = gz.a(var29_62, -16777216 & bo.j(var35_65));
                var45_75 = var58_88;
                ** GOTO lbl218
lbl207: // 1 sources:
                this.f += this.getPaddingLeft() + this.getPaddingRight();
                if (var14_14[1] != -1 || var14_14[0] != -1 || var14_14[2] != -1 || var14_14[3] != -1) {
                    var31_64 = Math.max(var31_64, Math.max(var14_14[3], Math.max(var14_14[0], Math.max(var14_14[1], var14_14[2]))) + Math.max(var15_15[3], Math.max(var15_15[0], Math.max(var15_15[1], var15_15[2]))));
                }
                var7_7 = var27_60;
                var32_91 = var28_61;
                var4_4 = var29_62;
                var33_92 = var31_64;
                break;
lbl215: // 1 sources:
                var43_73 = var30_63;
                var44_74 = var29_62;
                var45_75 = var26_59;
lbl218: // 2 sources:
                if (var18_18) {
                    this.f += var35_65.getMeasuredWidth() + var41_71.leftMargin + var41_71.rightMargin + this.b(var35_65);
                } else {
                    var46_76 = this.f;
                    this.f = Math.max(var46_76, var46_76 + var35_65.getMeasuredWidth() + var41_71.leftMargin + var41_71.rightMargin + this.b(var35_65));
                }
                var47_77 = var11_11 != 1073741824 && var41_71.height == -1;
                var48_78 = var41_71.topMargin + var41_71.bottomMargin;
                var49_79 = var48_78 + var35_65.getMeasuredHeight();
                var50_80 = Math.max(var31_64, var49_79);
                var51_81 = var47_77 != false ? var48_78 : var49_79;
                var52_82 = Math.max(var28_61, var51_81);
                var53_83 = var27_60 != false && var41_71.height == -1;
                if (var16_16 && (var54_84 = var35_65.getBaseline()) != -1) {
                    var55_85 = var41_71.h < 0 ? this.e : var41_71.h;
                    var56_86 = (-2 & (var55_85 & 112) >> 4) >> 1;
                    var14_14[var56_86] = Math.max(var14_14[var56_86], var54_84);
                    var15_15[var56_86] = Math.max(var15_15[var56_86], var49_79 - var54_84);
                }
                var36_66 = var45_75;
                var39_69 = var52_82;
                var40_70 = var53_83;
                var29_62 = var44_74;
                var37_67 = var43_73;
                var38_68 = var50_80;
                ** GOTO lbl247
lbl242: // 1 sources:
                var36_66 = var26_59;
                var37_67 = var30_63;
                var38_68 = var31_64;
                var39_69 = var28_61;
                var40_70 = var27_60;
lbl247: // 3 sources:
                ++var25_58;
                var28_61 = var39_69;
                var31_64 = var38_68;
                var27_60 = var40_70;
                var30_63 = var37_67;
                var26_59 = var36_66;
            } while (true);
lbl254: // 2 sources:
            while (var7_7 || var11_11 == 1073741824) {
                var32_91 = var33_92;
                break block47;
            }
            ** GOTO lbl266
lbl258: // 3 sources:
            for (var62_95 = 0; var62_95 < var9_9; ++var62_95) {
                var63_96 = this.b(var62_95);
                if (var63_96 == null || var63_96.getVisibility() == 8 || ((da)var63_96.getLayoutParams()).g <= 0.0f) continue;
                var63_96.measure(View.MeasureSpec.makeMeasureSpec((int)var19_19, (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)var63_96.getMeasuredHeight(), (int)1073741824));
            }
lbl263: // 2 sources:
            var32_91 = var61_94;
            var33_92 = var22_50;
            ** GOTO lbl254
        }
        var34_93 = Math.max(var32_91 + (this.getPaddingTop() + this.getPaddingBottom()), this.getSuggestedMinimumHeight());
        this.setMeasuredDimension(var23_56 | -16777216 & var4_4, bo.a(var34_93, var2_2, var4_4 << 16));
        if (var12_12 == false) return;
        this.d(var9_9, var1_1);
    }

    void b(int n2, int n3, int n4, int n5) {
        int n6;
        int n7;
        int n8;
        boolean bl2 = gz.a((View)this);
        int n9 = this.getPaddingTop();
        int n10 = n5 - n3;
        int n11 = n10 - this.getPaddingBottom();
        int n12 = n10 - n9 - this.getPaddingBottom();
        int n13 = this.getVirtualChildCount();
        int n14 = 8388615 & this.e;
        int n15 = 112 & this.e;
        boolean bl3 = this.a;
        int[] arrn = this.i;
        int[] arrn2 = this.j;
        switch (q.a(n14, bo.h((View)this))) {
            default: {
                n7 = this.getPaddingLeft();
                break;
            }
            case 5: {
                n7 = n4 + this.getPaddingLeft() - n2 - this.f;
                break;
            }
            case 1: {
                n7 = this.getPaddingLeft() + (n4 - n2 - this.f) / 2;
            }
        }
        if (bl2) {
            int n16 = n13 - 1;
            n8 = -1;
            n6 = n16;
        } else {
            n8 = 1;
            n6 = 0;
        }
        int n17 = 0;
        while (n17 < n13) {
            int n18;
            int n19 = n6 + n8 * n17;
            View view = this.b(n19);
            if (view == null) {
                n7 += this.d(n19);
                n18 = n17;
            } else if (view.getVisibility() != 8) {
                int n20;
                int n21 = view.getMeasuredWidth();
                int n22 = view.getMeasuredHeight();
                da da2 = (da)view.getLayoutParams();
                int n23 = bl3 && da2.height != -1 ? view.getBaseline() : -1;
                int n24 = da2.h;
                if (n24 < 0) {
                    n24 = n15;
                }
                switch (n24 & 112) {
                    default: {
                        n20 = n9;
                        break;
                    }
                    case 48: {
                        n20 = n9 + da2.topMargin;
                        if (n23 == -1) break;
                        n20 += arrn[1] - n23;
                        break;
                    }
                    case 16: {
                        n20 = n9 + (n12 - n22) / 2 + da2.topMargin - da2.bottomMargin;
                        break;
                    }
                    case 80: {
                        n20 = n11 - n22 - da2.bottomMargin;
                        if (n23 == -1) break;
                        int n25 = view.getMeasuredHeight() - n23;
                        n20 -= arrn2[2] - n25;
                        break;
                    }
                }
                int n26 = this.c(n19) ? n7 + this.l : n7;
                int n27 = n26 + da2.leftMargin;
                this.a(view, n27 + this.a(view), n20, n21, n22);
                n7 = n27 + (n21 + da2.rightMargin + this.b(view));
                n18 = n17 + this.a(view, n19);
            } else {
                n18 = n17;
            }
            n17 = n18 + 1;
        }
    }

    void b(Canvas canvas) {
        int n2;
        int n3 = this.getVirtualChildCount();
        boolean bl2 = gz.a((View)this);
        for (int i2 = 0; i2 < n3; ++i2) {
            View view = this.b(i2);
            if (view == null || view.getVisibility() == 8 || !this.c(i2)) continue;
            da da2 = (da)view.getLayoutParams();
            int n4 = bl2 ? view.getRight() + da2.rightMargin : view.getLeft() - da2.leftMargin - this.l;
            this.b(canvas, n4);
        }
        if (!this.c(n3)) return;
        View view = this.b(n3 - 1);
        if (view == null) {
            n2 = bl2 ? this.getPaddingLeft() : this.getWidth() - this.getPaddingRight() - this.l;
        } else {
            da da3 = (da)view.getLayoutParams();
            n2 = bl2 ? view.getLeft() - da3.leftMargin - this.l : view.getRight() + da3.rightMargin;
        }
        this.b(canvas, n2);
    }

    void b(Canvas canvas, int n2) {
        this.k.setBounds(n2, this.getPaddingTop() + this.o, n2 + this.l, this.getHeight() - this.getPaddingBottom() - this.o);
        this.k.draw(canvas);
    }

    protected boolean c(int n2) {
        if (n2 == 0) {
            if ((1 & this.n) == 0) return false;
            return true;
        }
        if (n2 == this.getChildCount()) {
            if ((4 & this.n) != 0) return true;
            return false;
        }
        if ((2 & this.n) == 0) return false;
        int n3 = n2 - 1;
        while (n3 >= 0) {
            if (this.getChildAt(n3).getVisibility() != 8) return true;
            --n3;
        }
        return false;
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof da;
    }

    int d(int n2) {
        return 0;
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return this.j();
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return this.b(attributeSet);
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return this.b(layoutParams);
    }

    /*
     * Unable to fully structure code
     */
    public int getBaseline() {
        var1_1 = -1;
        if (this.b < 0) {
            return super.getBaseline();
        }
        if (this.getChildCount() <= this.b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        var2_2 = this.getChildAt(this.b);
        var3_3 = var2_2.getBaseline();
        if (var3_3 == var1_1) {
            if (this.b == 0) return var1_1;
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        var4_4 = this.c;
        if (this.d != 1 || (var6_5 = 112 & this.e) == 48) ** GOTO lbl-1000
        switch (var6_5) {
            default: lbl-1000: // 2 sources:
            {
                var5_6 = var4_4;
                return var3_3 + (var5_6 + ((da)var2_2.getLayoutParams()).topMargin);
            }
            case 80: {
                var5_6 = this.getBottom() - this.getTop() - this.getPaddingBottom() - this.f;
                return var3_3 + (var5_6 + ((da)var2_2.getLayoutParams()).topMargin);
            }
            case 16: 
        }
        var5_6 = var4_4 + (this.getBottom() - this.getTop() - this.getPaddingTop() - this.getPaddingBottom() - this.f) / 2;
        return var3_3 + (var5_6 + ((da)var2_2.getLayoutParams()).topMargin);
    }

    public int getBaselineAlignedChildIndex() {
        return this.b;
    }

    public Drawable getDividerDrawable() {
        return this.k;
    }

    public int getDividerPadding() {
        return this.o;
    }

    public int getDividerWidth() {
        return this.l;
    }

    public int getOrientation() {
        return this.d;
    }

    public int getShowDividers() {
        return this.n;
    }

    int getVirtualChildCount() {
        return this.getChildCount();
    }

    public float getWeightSum() {
        return this.g;
    }

    protected da j() {
        if (this.d == 0) {
            return new da(-2, -2);
        }
        if (this.d != 1) return null;
        return new da(-1, -2);
    }

    protected void onDraw(Canvas canvas) {
        if (this.k == null) {
            return;
        }
        if (this.d == 1) {
            this.a(canvas);
            return;
        }
        this.b(canvas);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT < 14) return;
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)cz.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (Build.VERSION.SDK_INT < 14) return;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((CharSequence)cz.class.getName());
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        if (this.d == 1) {
            this.a(n2, n3, n4, n5);
            return;
        }
        this.b(n2, n3, n4, n5);
    }

    protected void onMeasure(int n2, int n3) {
        if (this.d == 1) {
            this.a(n2, n3);
            return;
        }
        this.b(n2, n3);
    }

    public void setBaselineAligned(boolean bl2) {
        this.a = bl2;
    }

    public void setBaselineAlignedChildIndex(int n2) {
        if (n2 < 0) throw new IllegalArgumentException("base aligned child index out of range (0, " + this.getChildCount() + ")");
        if (n2 >= this.getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + this.getChildCount() + ")");
        }
        this.b = n2;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.k) {
            return;
        }
        this.k = drawable;
        if (drawable != null) {
            this.l = drawable.getIntrinsicWidth();
            this.m = drawable.getIntrinsicHeight();
        } else {
            this.l = 0;
            this.m = 0;
        }
        boolean bl2 = false;
        if (drawable == null) {
            bl2 = true;
        }
        this.setWillNotDraw(bl2);
        this.requestLayout();
    }

    public void setDividerPadding(int n2) {
        this.o = n2;
    }

    public void setGravity(int n2) {
        if (this.e == n2) return;
        int n3 = (8388615 & n2) == 0 ? 8388611 | n2 : n2;
        if ((n3 & 112) == 0) {
            n3 |= 48;
        }
        this.e = n3;
        this.requestLayout();
    }

    public void setHorizontalGravity(int n2) {
        int n3 = n2 & 8388615;
        if ((8388615 & this.e) == n3) return;
        this.e = n3 | -8388616 & this.e;
        this.requestLayout();
    }

    public void setMeasureWithLargestChildEnabled(boolean bl2) {
        this.h = bl2;
    }

    public void setOrientation(int n2) {
        if (this.d == n2) return;
        this.d = n2;
        this.requestLayout();
    }

    public void setShowDividers(int n2) {
        if (n2 != this.n) {
            this.requestLayout();
        }
        this.n = n2;
    }

    public void setVerticalGravity(int n2) {
        int n3 = n2 & 112;
        if ((112 & this.e) == n3) return;
        this.e = n3 | -113 & this.e;
        this.requestLayout();
    }

    public void setWeightSum(float f2) {
        this.g = Math.max(0.0f, f2);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}

