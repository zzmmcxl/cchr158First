/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout;
import android.view.ViewTreeObserver;

class u
implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ CoordinatorLayout a;

    u(CoordinatorLayout coordinatorLayout) {
        this.a = coordinatorLayout;
    }

    public boolean onPreDraw() {
        this.a.a(false);
        return true;
    }
}

