/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.aq;
import android.support.v4.h.bo;
import android.view.View;

class ar
implements Runnable {
    final /* synthetic */ aq a;
    private final CoordinatorLayout b;
    private final View c;

    ar(aq aq2, CoordinatorLayout coordinatorLayout, View view) {
        this.a = aq2;
        this.b = coordinatorLayout;
        this.c = view;
    }

    @Override
    public void run() {
        if (this.c == null) return;
        if (aq.a(this.a) == null) return;
        if (aq.a(this.a).g()) {
            this.a.a_(this.b, this.c, aq.a(this.a).c());
            bo.a(this.c, this);
            return;
        }
        this.a.a(this.b, this.c);
    }
}

