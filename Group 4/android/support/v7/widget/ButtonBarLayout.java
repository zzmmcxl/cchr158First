/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.h.bo;
import android.support.v7.b.g;
import android.support.v7.b.l;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class ButtonBarLayout
extends LinearLayout {
    private boolean a;
    private int b = -1;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, l.ButtonBarLayout);
        this.a = typedArray.getBoolean(l.ButtonBarLayout_allowStacking, false);
        typedArray.recycle();
    }

    private boolean a() {
        if (this.getOrientation() != 1) return false;
        return true;
    }

    private void setStacked(boolean bl2) {
        int n2 = bl2 ? 1 : 0;
        this.setOrientation(n2);
        int n3 = bl2 ? 5 : 80;
        this.setGravity(n3);
        View view = this.findViewById(g.spacer);
        if (view != null) {
            int n4 = bl2 ? 8 : 4;
            view.setVisibility(n4);
        }
        int n5 = -2 + this.getChildCount();
        while (n5 >= 0) {
            this.bringChildToFront(this.getChildAt(n5));
            --n5;
        }
    }

    /*
     * Unable to fully structure code
     */
    protected void onMeasure(int var1_1, int var2_2) {
        var3_3 = View.MeasureSpec.getSize((int)var1_1);
        if (this.a) {
            if (var3_3 > this.b && this.a()) {
                this.setStacked(false);
            }
            this.b = var3_3;
        }
        if (!this.a() && View.MeasureSpec.getMode((int)var1_1) == 1073741824) {
            var4_4 = View.MeasureSpec.makeMeasureSpec((int)var3_3, (int)Integer.MIN_VALUE);
            var5_5 = true;
        } else {
            var4_4 = var1_1;
            var5_5 = false;
        }
        super.onMeasure(var4_4, var2_2);
        if (!this.a || this.a()) ** GOTO lbl31
        if (Build.VERSION.SDK_INT < 11) ** GOTO lbl20
        var11_6 = -16777216 & bo.i((View)this);
        var10_7 = false;
        if (var11_6 != 16777216) ** GOTO lbl31
        var10_7 = true;
        ** GOTO lbl28
lbl20: // 1 sources:
        var6_8 = this.getChildCount();
        var8_10 = 0;
        for (var7_9 = 0; var7_9 < var6_8; var8_10 += this.getChildAt((int)var7_9).getMeasuredWidth(), ++var7_9) {
        }
        var9_11 = var8_10 + this.getPaddingLeft() + this.getPaddingRight();
        var10_7 = false;
        if (var9_11 > var3_3) {
            var10_7 = true;
lbl28: // 2 sources:
            if (var10_7) {
                this.setStacked(true);
                var5_5 = true;
            }
        }
lbl31: // 7 sources:
        if (var5_5 == false) return;
        super.onMeasure(var1_1, var2_2);
    }

    public void setAllowStacking(boolean bl2) {
        if (this.a == bl2) return;
        this.a = bl2;
        if (!this.a && this.getOrientation() == 1) {
            this.setStacked(false);
        }
        this.requestLayout();
    }
}

