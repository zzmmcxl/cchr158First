/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.cm;
import android.support.design.widget.q;
import android.util.AttributeSet;
import android.view.View;

class cl
extends q {
    private cm a;
    private int b = 0;
    private int c = 0;

    public cl() {
    }

    public cl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean a(int n2) {
        if (this.a != null) {
            return this.a.a(n2);
        }
        this.b = n2;
        return false;
    }

    @Override
    public boolean a(CoordinatorLayout coordinatorLayout, View view, int n2) {
        this.b(coordinatorLayout, view, n2);
        if (this.a == null) {
            this.a = new cm(view);
        }
        this.a.a();
        if (this.b != 0) {
            this.a.a(this.b);
            this.b = 0;
        }
        if (this.c == 0) return true;
        this.a.b(this.c);
        this.c = 0;
        return true;
    }

    public int b() {
        if (this.a == null) return 0;
        return this.a.b();
    }

    protected void b(CoordinatorLayout coordinatorLayout, View view, int n2) {
        coordinatorLayout.a(view, n2);
    }
}

