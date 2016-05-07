/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.support.v7.widget.er;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class cw
extends er {
    private int e = -1;
    private int f = 0;

    public cw(int n2, int n3) {
        super(n2, n3);
    }

    public cw(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public cw(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public cw(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    static /* synthetic */ int a(cw cw2) {
        return cw2.e;
    }

    static /* synthetic */ int a(cw cw2, int n2) {
        cw2.f = n2;
        return n2;
    }

    static /* synthetic */ int b(cw cw2) {
        return cw2.f;
    }

    static /* synthetic */ int b(cw cw2, int n2) {
        cw2.e = n2;
        return n2;
    }

    public int a() {
        return this.e;
    }

    public int b() {
        return this.f;
    }
}

