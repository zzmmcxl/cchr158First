/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.o;
import android.view.View;
import android.view.ViewGroup;

class s
implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ CoordinatorLayout a;

    private s(CoordinatorLayout coordinatorLayout) {
        this.a = coordinatorLayout;
    }

    /* synthetic */ s(CoordinatorLayout coordinatorLayout, o o2) {
        this(coordinatorLayout);
    }

    public void onChildViewAdded(View view, View view2) {
        if (CoordinatorLayout.a(this.a) == null) return;
        CoordinatorLayout.a(this.a).onChildViewAdded(view, view2);
    }

    public void onChildViewRemoved(View view, View view2) {
        this.a.b(view2);
        if (CoordinatorLayout.a(this.a) == null) return;
        CoordinatorLayout.a(this.a).onChildViewRemoved(view, view2);
    }
}

