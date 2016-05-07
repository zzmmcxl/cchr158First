/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.content.Context;
import android.os.Parcelable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.h.dw;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.MotionEvent;
import android.view.View;

public abstract class q {
    public q() {
    }

    public q(Context context, AttributeSet attributeSet) {
    }

    public dw a(CoordinatorLayout coordinatorLayout, View view, dw dw2) {
        return dw2;
    }

    public void a(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
    }

    public void a(CoordinatorLayout coordinatorLayout, View view, View view2) {
    }

    public void a(CoordinatorLayout coordinatorLayout, View view, View view2, int n2, int n3, int n4, int n5) {
    }

    public void a(CoordinatorLayout coordinatorLayout, View view, View view2, int n2, int n3, int[] arrn) {
    }

    public boolean a(CoordinatorLayout coordinatorLayout, View view, int n2) {
        return false;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, View view, int n2, int n3, int n4, int n5) {
        return false;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return false;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2, float f2, float f3) {
        return false;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2, float f2, float f3, boolean bl2) {
        return false;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int n2) {
        return false;
    }

    public Parcelable b(CoordinatorLayout coordinatorLayout, View view) {
        return View.BaseSavedState.EMPTY_STATE;
    }

    public void b(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int n2) {
    }

    public boolean b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return false;
    }

    public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return false;
    }

    public int c(CoordinatorLayout coordinatorLayout, View view) {
        return -16777216;
    }

    public boolean c(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return false;
    }

    public float d(CoordinatorLayout coordinatorLayout, View view) {
        return 0.0f;
    }

    public void d(CoordinatorLayout coordinatorLayout, View view, View view2) {
    }

    public boolean e(CoordinatorLayout coordinatorLayout, View view) {
        if (this.d(coordinatorLayout, view) <= 0.0f) return false;
        return true;
    }
}

