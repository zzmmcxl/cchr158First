/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.Snackbar$SnackbarLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.design.widget.bj;
import android.support.design.widget.bl;
import android.view.MotionEvent;
import android.view.View;

final class bf
extends SwipeDismissBehavior {
    final /* synthetic */ Snackbar a;

    bf(Snackbar snackbar) {
        this.a = snackbar;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, Snackbar$SnackbarLayout snackbar$SnackbarLayout, MotionEvent motionEvent) {
        if (!coordinatorLayout.a((View)snackbar$SnackbarLayout, (int)motionEvent.getX(), (int)motionEvent.getY())) return super.a(coordinatorLayout, (View)snackbar$SnackbarLayout, motionEvent);
        switch (motionEvent.getActionMasked()) {
            case 0: {
                bj.a().c(Snackbar.a(this.a));
            }
            default: {
                return super.a(coordinatorLayout, (View)snackbar$SnackbarLayout, motionEvent);
            }
            case 1: 
            case 3: 
        }
        bj.a().d(Snackbar.a(this.a));
        return super.a(coordinatorLayout, (View)snackbar$SnackbarLayout, motionEvent);
    }

    @Override
    public boolean a(View view) {
        return view instanceof Snackbar$SnackbarLayout;
    }
}

