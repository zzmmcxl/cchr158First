/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.SwipeDismissBehavior;
import android.support.design.widget.bs;
import android.support.v4.h.bo;
import android.support.v4.widget.bm;
import android.view.View;
import android.view.ViewParent;

class bq
extends bm {
    final /* synthetic */ SwipeDismissBehavior a;
    private int b;

    bq(SwipeDismissBehavior swipeDismissBehavior) {
        this.a = swipeDismissBehavior;
    }

    private boolean a(View view, float f2) {
        if (f2 == 0.0f) {
            int n2 = view.getLeft() - this.b;
            int n3 = Math.round((float)view.getWidth() * SwipeDismissBehavior.d(this.a));
            if (Math.abs(n2) >= n3) return true;
            return false;
        }
        boolean bl2 = bo.h(view) == 1;
        if (SwipeDismissBehavior.c(this.a) == 2) {
            return true;
        }
        if (SwipeDismissBehavior.c(this.a) == 0) {
            if (bl2) {
                if (f2 < 0.0f) return true;
                return false;
            }
            if (f2 > 0.0f) return true;
            return false;
        }
        if (SwipeDismissBehavior.c(this.a) != 1) return false;
        if (bl2) {
            if (f2 > 0.0f) return true;
            return false;
        }
        if (f2 < 0.0f) return true;
        return false;
    }

    @Override
    public int a(View view, int n2, int n3) {
        return view.getTop();
    }

    @Override
    public void a(int n2) {
        if (SwipeDismissBehavior.a(this.a) == null) return;
        SwipeDismissBehavior.a(this.a).a(n2);
    }

    @Override
    public void a(View view, float f2, float f3) {
        int n2;
        boolean bl2;
        ViewParent viewParent = view.getParent();
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(false);
        }
        int n3 = view.getWidth();
        if (this.a(view, f2)) {
            int n4 = view.getLeft() < this.b ? this.b - n3 : n3 + this.b;
            n2 = n4;
            bl2 = true;
        } else {
            n2 = this.b;
            bl2 = false;
        }
        if (SwipeDismissBehavior.b(this.a).a(n2, view.getTop())) {
            bo.a(view, new bs(this.a, view, bl2));
            return;
        }
        if (SwipeDismissBehavior.a(this.a) == null) return;
        SwipeDismissBehavior.a(this.a).a(view);
    }

    @Override
    public void a(View view, int n2, int n3, int n4, int n5) {
        float f2 = (float)this.b + (float)view.getWidth() * SwipeDismissBehavior.e(this.a);
        float f3 = (float)this.b + (float)view.getWidth() * SwipeDismissBehavior.f(this.a);
        if ((float)n2 <= f2) {
            bo.c(view, 1.0f);
            return;
        }
        if ((float)n2 >= f3) {
            bo.c(view, 0.0f);
            return;
        }
        bo.c(view, SwipeDismissBehavior.b(0.0f, 1.0f - SwipeDismissBehavior.a(f2, f3, (float)n2), 1.0f));
    }

    @Override
    public boolean a(View view, int n2) {
        return this.a.a(view);
    }

    @Override
    public int b(View view) {
        return view.getWidth();
    }

    @Override
    public int b(View view, int n2, int n3) {
        int n4;
        int n5;
        boolean bl2 = bo.h(view) == 1;
        if (SwipeDismissBehavior.c(this.a) == 0) {
            if (bl2) {
                n5 = this.b - view.getWidth();
                n4 = this.b;
                return SwipeDismissBehavior.a(n5, n2, n4);
            }
            n5 = this.b;
            n4 = this.b + view.getWidth();
            return SwipeDismissBehavior.a(n5, n2, n4);
        }
        if (SwipeDismissBehavior.c(this.a) != 1) {
            n5 = this.b - view.getWidth();
            n4 = this.b + view.getWidth();
            return SwipeDismissBehavior.a(n5, n2, n4);
        }
        if (bl2) {
            n5 = this.b;
            n4 = this.b + view.getWidth();
            return SwipeDismissBehavior.a(n5, n2, n4);
        }
        n5 = this.b - view.getWidth();
        n4 = this.b;
        return SwipeDismissBehavior.a(n5, n2, n4);
    }

    @Override
    public void b(View view, int n2) {
        this.b = view.getLeft();
        ViewParent viewParent = view.getParent();
        if (viewParent == null) return;
        viewParent.requestDisallowInterceptTouchEvent(true);
    }
}

