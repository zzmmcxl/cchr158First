/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.support.v4.h.be;
import android.support.v4.h.cx;
import android.view.View;
import android.view.ViewParent;

class da
implements cx {
    da() {
    }

    @Override
    public void a(ViewParent viewParent, View view) {
        if (!(viewParent instanceof be)) return;
        ((be)viewParent).onStopNestedScroll(view);
    }

    @Override
    public void a(ViewParent viewParent, View view, int n2, int n3, int n4, int n5) {
        if (!(viewParent instanceof be)) return;
        ((be)viewParent).onNestedScroll(view, n2, n3, n4, n5);
    }

    @Override
    public void a(ViewParent viewParent, View view, int n2, int n3, int[] arrn) {
        if (!(viewParent instanceof be)) return;
        ((be)viewParent).onNestedPreScroll(view, n2, n3, arrn);
    }

    @Override
    public boolean a(ViewParent viewParent, View view, float f2, float f3) {
        if (!(viewParent instanceof be)) return false;
        return ((be)viewParent).onNestedPreFling(view, f2, f3);
    }

    @Override
    public boolean a(ViewParent viewParent, View view, float f2, float f3, boolean bl2) {
        if (!(viewParent instanceof be)) return false;
        return ((be)viewParent).onNestedFling(view, f2, f3, bl2);
    }

    @Override
    public boolean a(ViewParent viewParent, View view, View view2, int n2) {
        if (!(viewParent instanceof be)) return false;
        return ((be)viewParent).onStartNestedScroll(view, view2, n2);
    }

    @Override
    public void b(ViewParent viewParent, View view, View view2, int n2) {
        if (!(viewParent instanceof be)) return;
        ((be)viewParent).onNestedScrollAccepted(view, view2, n2);
    }
}

