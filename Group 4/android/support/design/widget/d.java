/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout$Behavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.bu;
import android.support.design.widget.bw;
import android.view.View;

class d
implements bw {
    final /* synthetic */ CoordinatorLayout a;
    final /* synthetic */ AppBarLayout b;
    final /* synthetic */ AppBarLayout$Behavior c;

    d(AppBarLayout$Behavior appBarLayout$Behavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.c = appBarLayout$Behavior;
        this.a = coordinatorLayout;
        this.b = appBarLayout;
    }

    @Override
    public void a(bu bu2) {
        this.c.a_(this.a, (View)this.b, bu2.c());
    }
}

