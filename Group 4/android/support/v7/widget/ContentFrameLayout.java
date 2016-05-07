/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v4.h.bo;
import android.support.v7.widget.cd;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;

public class ContentFrameLayout
extends FrameLayout {
    private TypedValue a;
    private TypedValue b;
    private TypedValue c;
    private TypedValue d;
    private TypedValue e;
    private TypedValue f;
    private final Rect g = new Rect();
    private cd h;

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
    }

    public void a(int n2, int n3, int n4, int n5) {
        this.g.set(n2, n3, n4, n5);
        if (!bo.A((View)this)) return;
        this.requestLayout();
    }

    public void a(Rect rect) {
        this.fitSystemWindows(rect);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.e != null) return this.e;
        this.e = new TypedValue();
        return this.e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f != null) return this.f;
        this.f = new TypedValue();
        return this.f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.c != null) return this.c;
        this.c = new TypedValue();
        return this.c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.d != null) return this.d;
        this.d = new TypedValue();
        return this.d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.a != null) return this.a;
        this.a = new TypedValue();
        return this.a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.b != null) return this.b;
        this.b = new TypedValue();
        return this.b;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.h == null) return;
        this.h.a();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.h == null) return;
        this.h.b();
    }

    /*
     * Unable to fully structure code
     */
    protected void onMeasure(int var1_1, int var2_2) {
        var3_3 = this.getContext().getResources().getDisplayMetrics();
        var4_4 = var3_3.widthPixels < var3_3.heightPixels;
        var5_5 = View.MeasureSpec.getMode((int)var1_1);
        var6_6 = View.MeasureSpec.getMode((int)var2_2);
        if (var5_5 != Integer.MIN_VALUE) ** GOTO lbl-1000
        var16_7 = var4_4 != false ? this.d : this.c;
        if (var16_7 == null || var16_7.type == 0) ** GOTO lbl-1000
        var17_8 = var16_7.type == 5 ? (int)var16_7.getDimension(var3_3) : (var16_7.type == 6 ? (int)var16_7.getFraction((float)var3_3.widthPixels, (float)var3_3.widthPixels) : 0);
        if (var17_8 > 0) {
            var1_1 = View.MeasureSpec.makeMeasureSpec((int)Math.min(var17_8 - (this.g.left + this.g.right), View.MeasureSpec.getSize((int)var1_1)), (int)1073741824);
            var7_9 = true;
        } else lbl-1000: // 3 sources:
        {
            var7_9 = false;
        }
        if (var6_6 == Integer.MIN_VALUE) {
            var14_10 = var4_4 != false ? this.e : this.f;
            if (var14_10 != null && var14_10.type != 0) {
                var15_11 = var14_10.type == 5 ? (int)var14_10.getDimension(var3_3) : (var14_10.type == 6 ? (int)var14_10.getFraction((float)var3_3.heightPixels, (float)var3_3.heightPixels) : 0);
                if (var15_11 > 0) {
                    var2_2 = View.MeasureSpec.makeMeasureSpec((int)Math.min(var15_11 - (this.g.top + this.g.bottom), View.MeasureSpec.getSize((int)var2_2)), (int)1073741824);
                }
            }
        }
        super.onMeasure(var1_1, var2_2);
        var8_12 = this.getMeasuredWidth();
        var9_13 = View.MeasureSpec.makeMeasureSpec((int)var8_12, (int)1073741824);
        if (!var7_9 && var5_5 == Integer.MIN_VALUE) {
            var12_14 = var4_4 != false ? this.b : this.a;
            if (var12_14 != null && var12_14.type != 0) {
                var13_15 = var12_14.type == 5 ? (int)var12_14.getDimension(var3_3) : (var12_14.type == 6 ? (int)var12_14.getFraction((float)var3_3.widthPixels, (float)var3_3.widthPixels) : 0);
                if (var13_15 > 0) {
                    var13_15 -= this.g.left + this.g.right;
                }
                if (var8_12 < var13_15) {
                    var10_16 = View.MeasureSpec.makeMeasureSpec((int)var13_15, (int)1073741824);
                    var11_17 = true;
                    if (var11_17 == false) return;
                    super.onMeasure(var10_16, var2_2);
                    return;
                }
            }
        }
        var10_16 = var9_13;
    }

    public void setAttachListener(cd cd2) {
        this.h = cd2;
    }
}

