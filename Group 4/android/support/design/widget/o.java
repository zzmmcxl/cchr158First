/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.t;
import android.view.View;
import android.view.ViewGroup;
import java.util.Comparator;

class o
implements Comparator {
    final /* synthetic */ CoordinatorLayout a;

    o(CoordinatorLayout coordinatorLayout) {
        this.a = coordinatorLayout;
    }

    public int a(View view, View view2) {
        if (view == view2) {
            return 0;
        }
        if (((t)view.getLayoutParams()).a(this.a, view, view2)) {
            return 1;
        }
        if (!((t)view2.getLayoutParams()).a(this.a, view2, view)) return 0;
        return -1;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((View)object, (View)object2);
    }
}

