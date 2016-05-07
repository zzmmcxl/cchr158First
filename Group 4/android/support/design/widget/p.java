/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.o;
import android.support.v4.h.bg;
import android.support.v4.h.dw;
import android.view.View;

class p
implements bg {
    final /* synthetic */ CoordinatorLayout a;

    private p(CoordinatorLayout coordinatorLayout) {
        this.a = coordinatorLayout;
    }

    /* synthetic */ p(CoordinatorLayout coordinatorLayout, o o2) {
        this(coordinatorLayout);
    }

    @Override
    public dw a(View view, dw dw2) {
        return CoordinatorLayout.a(this.a, dw2);
    }
}

