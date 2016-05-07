/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.b.l;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class da
extends ViewGroup.MarginLayoutParams {
    public float g;
    public int h = -1;

    public da(int n2, int n3) {
        super(n2, n3);
        this.g = 0.0f;
    }

    public da(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, l.LinearLayoutCompat_Layout);
        this.g = typedArray.getFloat(l.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
        this.h = typedArray.getInt(l.LinearLayoutCompat_Layout_android_layout_gravity, -1);
        typedArray.recycle();
    }

    public da(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }
}

