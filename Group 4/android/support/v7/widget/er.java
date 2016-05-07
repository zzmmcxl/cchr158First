/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.ff;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class er
extends ViewGroup.MarginLayoutParams {
    ff a;
    final Rect b = new Rect();
    boolean c = true;
    boolean d = false;

    public er(int n2, int n3) {
        super(n2, n3);
    }

    public er(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public er(er er2) {
        super((ViewGroup.LayoutParams)er2);
    }

    public er(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public er(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public boolean c() {
        return this.a.q();
    }

    public boolean d() {
        return this.a.x();
    }

    public int e() {
        return this.a.d();
    }
}

