/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.a;
import android.support.design.widget.aa;
import android.support.design.widget.bu;
import android.support.design.widget.bw;
import android.support.design.widget.cf;
import android.support.design.widget.cn;
import android.support.design.widget.q;
import android.support.design.widget.t;
import android.support.v4.h.bo;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.List;

public class FloatingActionButton$Behavior
extends q {
    private static final boolean a;
    private bu b;
    private float c;
    private Rect d;

    static {
        boolean bl2 = Build.VERSION.SDK_INT >= 11;
        a = bl2;
    }

    private float a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
        float f2 = 0.0f;
        List list = coordinatorLayout.d((View)floatingActionButton);
        int n2 = list.size();
        int n3 = 0;
        while (n3 < n2) {
            View view = (View)list.get(n3);
            float f3 = view instanceof Snackbar.SnackbarLayout && coordinatorLayout.a((View)floatingActionButton, view) ? Math.min(f2, bo.n(view) - (float)view.getHeight()) : f2;
            ++n3;
            f2 = f3;
        }
        return f2;
    }

    private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
        if (((t)floatingActionButton.getLayoutParams()).a() != appBarLayout.getId()) {
            return false;
        }
        if (floatingActionButton.getUserSetVisibility() != 0) {
            return false;
        }
        if (this.d == null) {
            this.d = new Rect();
        }
        Rect rect = this.d;
        cf.b(coordinatorLayout, (View)appBarLayout, rect);
        if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
            FloatingActionButton.a(floatingActionButton, null, false);
            return true;
        }
        FloatingActionButton.b(floatingActionButton, null, false);
        return true;
    }

    private void b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
        int n2;
        Rect rect = FloatingActionButton.a(floatingActionButton);
        if (rect == null) return;
        if (rect.centerX() <= 0) return;
        if (rect.centerY() <= 0) return;
        t t2 = (t)floatingActionButton.getLayoutParams();
        int n3 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - t2.rightMargin ? rect.right : (floatingActionButton.getLeft() <= t2.leftMargin ? - rect.left : 0);
        if (floatingActionButton.getBottom() >= coordinatorLayout.getBottom() - t2.bottomMargin) {
            n2 = rect.bottom;
        } else {
            int n4 = floatingActionButton.getTop();
            int n5 = t2.topMargin;
            n2 = 0;
            if (n4 <= n5) {
                n2 = - rect.top;
            }
        }
        floatingActionButton.offsetTopAndBottom(n2);
        floatingActionButton.offsetLeftAndRight(n3);
    }

    private void c(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
        float f2 = this.a(coordinatorLayout, floatingActionButton);
        if (this.c == f2) {
            return;
        }
        float f3 = bo.n((View)floatingActionButton);
        if (this.b != null && this.b.b()) {
            this.b.e();
        }
        if (floatingActionButton.isShown() && Math.abs(f3 - f2) > 0.667f * (float)floatingActionButton.getHeight()) {
            if (this.b == null) {
                this.b = cn.a();
                this.b.a(a.b);
                this.b.a(new aa(this, floatingActionButton));
            }
            this.b.a(f3, f2);
            this.b.a();
        } else {
            bo.b((View)floatingActionButton, f2);
        }
        this.c = f2;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int n2) {
        List list = coordinatorLayout.d((View)floatingActionButton);
        int n3 = list.size();
        int n4 = 0;
        do {
            View view;
            if (n4 >= n3 || (view = (View)list.get(n4)) instanceof AppBarLayout && this.a(coordinatorLayout, (AppBarLayout)view, floatingActionButton)) {
                coordinatorLayout.a((View)floatingActionButton, n2);
                this.b(coordinatorLayout, floatingActionButton);
                return true;
            }
            ++n4;
        } while (true);
    }

    public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
        if (!a) return false;
        if (!(view instanceof Snackbar.SnackbarLayout)) return false;
        return true;
    }

    public boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
        if (view instanceof Snackbar.SnackbarLayout) {
            this.c(coordinatorLayout, floatingActionButton, view);
            return false;
        }
        if (!(view instanceof AppBarLayout)) return false;
        this.a(coordinatorLayout, (AppBarLayout)view, floatingActionButton);
        return false;
    }

    @Override
    public /* synthetic */ boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return this.a(coordinatorLayout, (FloatingActionButton)view, view2);
    }

    @Override
    public /* synthetic */ boolean c(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return this.b(coordinatorLayout, (FloatingActionButton)view, view2);
    }
}

