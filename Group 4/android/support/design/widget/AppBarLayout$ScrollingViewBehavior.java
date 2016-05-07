/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.i;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout$Behavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.as;
import android.support.design.widget.q;
import android.support.design.widget.t;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class AppBarLayout$ScrollingViewBehavior
extends as {
    public AppBarLayout$ScrollingViewBehavior() {
    }

    public AppBarLayout$ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, i.ScrollingViewBehavior_Params);
        this.b(typedArray.getDimensionPixelSize(i.ScrollingViewBehavior_Params_behavior_overlapTop, 0));
        typedArray.recycle();
    }

    private static int a(AppBarLayout appBarLayout) {
        q q2 = ((t)appBarLayout.getLayoutParams()).b();
        if (!(q2 instanceof AppBarLayout$Behavior)) return 0;
        return ((AppBarLayout$Behavior)q2).a();
    }

    private void e(CoordinatorLayout coordinatorLayout, View view, View view2) {
        q q2 = ((t)view2.getLayoutParams()).b();
        if (!(q2 instanceof AppBarLayout$Behavior)) return;
        AppBarLayout$Behavior appBarLayout$Behavior = (AppBarLayout$Behavior)q2;
        appBarLayout$Behavior.a();
        view.offsetTopAndBottom(view2.getBottom() - view.getTop() + AppBarLayout$Behavior.a(appBarLayout$Behavior) + this.a() - this.c(view2));
    }

    @Override
    float a(View view) {
        if (!(view instanceof AppBarLayout)) return 0.0f;
        AppBarLayout appBarLayout = (AppBarLayout)view;
        int n2 = appBarLayout.getTotalScrollRange();
        int n3 = AppBarLayout.b(appBarLayout);
        int n4 = AppBarLayout$ScrollingViewBehavior.a(appBarLayout);
        if (n3 != 0 && n2 + n4 <= n3) {
            return 0.0f;
        }
        int n5 = n2 - n3;
        if (n5 == 0) return 0.0f;
        return 1.0f + (float)n4 / (float)n5;
    }

    @Override
    View a(List list) {
        int n2 = list.size();
        int n3 = 0;
        while (n3 < n2) {
            View view = (View)list.get(n3);
            if (view instanceof AppBarLayout) {
                return view;
            }
            ++n3;
        }
        return null;
    }

    @Override
    int b(View view) {
        if (!(view instanceof AppBarLayout)) return super.b(view);
        return ((AppBarLayout)view).getTotalScrollRange();
    }

    @Override
    public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof AppBarLayout;
    }

    @Override
    public boolean c(CoordinatorLayout coordinatorLayout, View view, View view2) {
        this.e(coordinatorLayout, view, view2);
        return false;
    }
}

