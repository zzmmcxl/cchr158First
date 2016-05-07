/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.i;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;

public class g
extends LinearLayout.LayoutParams {
    int a = 1;
    Interpolator b;

    public g(int n2, int n3) {
        super(n2, n3);
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, i.AppBarLayout_LayoutParams);
        this.a = typedArray.getInt(i.AppBarLayout_LayoutParams_layout_scrollFlags, 0);
        if (typedArray.hasValue(i.AppBarLayout_LayoutParams_layout_scrollInterpolator)) {
            this.b = AnimationUtils.loadInterpolator((Context)context, (int)typedArray.getResourceId(i.AppBarLayout_LayoutParams_layout_scrollInterpolator, 0));
        }
        typedArray.recycle();
    }

    public g(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public g(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public g(LinearLayout.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public int a() {
        return this.a;
    }

    public Interpolator b() {
        return this.b;
    }
}

