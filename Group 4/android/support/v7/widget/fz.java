/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.support.v7.widget.er;
import android.support.v7.widget.gc;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class fz
extends er {
    gc e;
    boolean f;

    public fz(int n2, int n3) {
        super(n2, n3);
    }

    public fz(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public fz(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public fz(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public boolean a() {
        return this.f;
    }

    public final int b() {
        if (this.e != null) return this.e.d;
        return -1;
    }
}

