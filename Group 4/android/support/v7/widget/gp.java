/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.support.v7.a.b;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class gp
extends b {
    int b = 0;

    public gp(int n2, int n3) {
        super(n2, n3);
        this.a = 8388627;
    }

    public gp(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public gp(b b2) {
        super(b2);
    }

    public gp(gp gp2) {
        super(gp2);
        this.b = gp2.b;
    }

    public gp(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public gp(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super((ViewGroup.LayoutParams)marginLayoutParams);
        this.a(marginLayoutParams);
    }

    void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        this.leftMargin = marginLayoutParams.leftMargin;
        this.topMargin = marginLayoutParams.topMargin;
        this.rightMargin = marginLayoutParams.rightMargin;
        this.bottomMargin = marginLayoutParams.bottomMargin;
    }
}

