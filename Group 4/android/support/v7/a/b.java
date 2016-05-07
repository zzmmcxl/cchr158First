/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.b.l;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class b
extends ViewGroup.MarginLayoutParams {
    public int a = 0;

    public b(int n2, int n3) {
        super(n2, n3);
        this.a = 8388627;
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, l.ActionBarLayout);
        this.a = typedArray.getInt(l.ActionBarLayout_android_layout_gravity, 0);
        typedArray.recycle();
    }

    public b(b b2) {
        super((ViewGroup.MarginLayoutParams)b2);
        this.a = b2.a;
    }

    public b(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }
}

