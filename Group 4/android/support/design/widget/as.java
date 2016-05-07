/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.at;
import android.support.design.widget.cl;
import android.support.design.widget.t;
import android.support.v4.h.bo;
import android.support.v4.h.q;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

abstract class as
extends cl {
    private final Rect a = new Rect();
    private final Rect b = new Rect();
    private int c = 0;
    private int d;

    public as() {
    }

    public as(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static int c(int n2) {
        if (n2 != 0) return n2;
        return 8388659;
    }

    float a(View view) {
        return 1.0f;
    }

    final int a() {
        return this.c;
    }

    abstract View a(List var1);

    @Override
    public boolean a(CoordinatorLayout coordinatorLayout, View view, int n2, int n3, int n4, int n5) {
        View view2;
        int n6 = view.getLayoutParams().height;
        if (n6 != -1) {
            if (n6 != -2) return false;
        }
        if ((view2 = this.a(coordinatorLayout.d(view))) == null) return false;
        if (bo.t(view2) && !bo.t(view)) {
            bo.a(view, true);
            if (bo.t(view)) {
                view.requestLayout();
                return true;
            }
        }
        if (!bo.A(view2)) return false;
        int n7 = View.MeasureSpec.getSize((int)n4);
        if (n7 == 0) {
            n7 = coordinatorLayout.getHeight();
        }
        int n8 = n7 - view2.getMeasuredHeight() + this.b(view2);
        int n9 = n6 == -1 ? 1073741824 : Integer.MIN_VALUE;
        coordinatorLayout.a(view, n2, n3, View.MeasureSpec.makeMeasureSpec((int)n8, (int)n9), n5);
        return true;
    }

    int b(View view) {
        return view.getMeasuredHeight();
    }

    public final void b(int n2) {
        this.d = n2;
    }

    @Override
    protected void b(CoordinatorLayout coordinatorLayout, View view, int n2) {
        View view2 = this.a(coordinatorLayout.d(view));
        if (view2 != null) {
            t t2 = (t)view.getLayoutParams();
            Rect rect = this.a;
            rect.set(coordinatorLayout.getPaddingLeft() + t2.leftMargin, view2.getBottom() + t2.topMargin, coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight() - t2.rightMargin, coordinatorLayout.getHeight() + view2.getBottom() - coordinatorLayout.getPaddingBottom() - t2.bottomMargin);
            Rect rect2 = this.b;
            q.a(as.c(t2.c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, n2);
            int n3 = this.c(view2);
            view.layout(rect2.left, rect2.top - n3, rect2.right, rect2.bottom - n3);
            this.c = rect2.top - view2.getBottom();
            return;
        }
        super.b(coordinatorLayout, view, n2);
        this.c = 0;
    }

    final int c(View view) {
        if (this.d != 0) return at.a(Math.round(this.a(view) * (float)this.d), 0, this.d);
        return 0;
    }
}

