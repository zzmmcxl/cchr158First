/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.design.i;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.q;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class t
extends ViewGroup.MarginLayoutParams {
    q a;
    boolean b = false;
    public int c = 0;
    public int d = 0;
    public int e = -1;
    int f = -1;
    View g;
    View h;
    final Rect i = new Rect();
    Object j;
    private boolean k;
    private boolean l;
    private boolean m;

    public t(int n2, int n3) {
        super(n2, n3);
    }

    t(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, i.CoordinatorLayout_LayoutParams);
        this.c = typedArray.getInteger(i.CoordinatorLayout_LayoutParams_android_layout_gravity, 0);
        this.f = typedArray.getResourceId(i.CoordinatorLayout_LayoutParams_layout_anchor, -1);
        this.d = typedArray.getInteger(i.CoordinatorLayout_LayoutParams_layout_anchorGravity, 0);
        this.e = typedArray.getInteger(i.CoordinatorLayout_LayoutParams_layout_keyline, -1);
        this.b = typedArray.hasValue(i.CoordinatorLayout_LayoutParams_layout_behavior);
        if (this.b) {
            this.a = CoordinatorLayout.a(context, attributeSet, typedArray.getString(i.CoordinatorLayout_LayoutParams_layout_behavior));
        }
        typedArray.recycle();
    }

    public t(t t2) {
        super((ViewGroup.MarginLayoutParams)t2);
    }

    public t(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public t(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    private void a(View view, CoordinatorLayout coordinatorLayout) {
        this.g = coordinatorLayout.findViewById(this.f);
        if (this.g == null) {
            if (!coordinatorLayout.isInEditMode()) throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f) + " to anchor view " + (Object)view);
            this.h = null;
            this.g = null;
            return;
        }
        if (this.g == coordinatorLayout) {
            if (!coordinatorLayout.isInEditMode()) throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
            this.h = null;
            this.g = null;
            return;
        }
        View view2 = this.g;
        for (ViewParent viewParent = this.g.getParent(); viewParent != coordinatorLayout && viewParent != null; viewParent = viewParent.getParent()) {
            if (viewParent == view) {
                if (!coordinatorLayout.isInEditMode()) throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                this.h = null;
                this.g = null;
                return;
            }
            if (!(viewParent instanceof View)) continue;
            view2 = (View)viewParent;
        }
        this.h = view2;
    }

    private boolean b(View view, CoordinatorLayout coordinatorLayout) {
        if (this.g.getId() != this.f) {
            return false;
        }
        View view2 = this.g;
        ViewParent viewParent = this.g.getParent();
        do {
            if (viewParent == coordinatorLayout) {
                this.h = view2;
                return true;
            }
            if (viewParent == null || viewParent == view) {
                this.h = null;
                this.g = null;
                return false;
            }
            if (viewParent instanceof View) {
                view2 = (View)viewParent;
            }
            viewParent = viewParent.getParent();
        } while (true);
    }

    public int a() {
        return this.f;
    }

    void a(Rect rect) {
        this.i.set(rect);
    }

    public void a(q q2) {
        if (this.a == q2) return;
        this.a = q2;
        this.j = null;
        this.b = true;
    }

    void a(boolean bl2) {
        this.l = bl2;
    }

    boolean a(CoordinatorLayout coordinatorLayout, View view) {
        boolean bl2;
        if (this.k) {
            return true;
        }
        boolean bl3 = this.k;
        boolean bl4 = this.a != null ? this.a.e(coordinatorLayout, view) : false;
        this.k = bl2 = bl4 | bl3;
        return bl2;
    }

    boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view2 == this.h) return true;
        if (this.a == null) return false;
        if (!this.a.b(coordinatorLayout, view, view2)) return false;
        return true;
    }

    public q b() {
        return this.a;
    }

    View b(CoordinatorLayout coordinatorLayout, View view) {
        if (this.f == -1) {
            this.h = null;
            this.g = null;
            return null;
        }
        if (this.g != null) {
            if (this.b(view, coordinatorLayout)) return this.g;
        }
        this.a(view, coordinatorLayout);
        return this.g;
    }

    void b(boolean bl2) {
        this.m = bl2;
    }

    Rect c() {
        return this.i;
    }

    boolean d() {
        if (this.g != null) return false;
        if (this.f == -1) return false;
        return true;
    }

    boolean e() {
        if (this.a != null) return this.k;
        this.k = false;
        return this.k;
    }

    void f() {
        this.k = false;
    }

    void g() {
        this.l = false;
    }

    boolean h() {
        return this.l;
    }

    boolean i() {
        return this.m;
    }

    void j() {
        this.m = false;
    }
}

