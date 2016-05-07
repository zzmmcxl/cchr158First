/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.content.Context;
import android.support.v7.widget.ay;
import android.util.AttributeSet;

class ct
extends ay {
    private int a;

    public ct(Context context) {
        this(context, null);
    }

    public ct(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ct(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.a = this.getVisibility();
    }

    final void a(int n2, boolean bl2) {
        super.setVisibility(n2);
        if (!bl2) return;
        this.a = n2;
    }

    final int getUserSetVisibility() {
        return this.a;
    }

    public void setVisibility(int n2) {
        this.a(n2, true);
    }
}

