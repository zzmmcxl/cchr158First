/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v4.h.bo;
import android.support.v4.h.dc;
import android.support.v4.h.dt;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.view.View;

class h
implements Runnable {
    final /* synthetic */ ActionBarOverlayLayout a;

    h(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.a = actionBarOverlayLayout;
    }

    @Override
    public void run() {
        ActionBarOverlayLayout.a(this.a);
        ActionBarOverlayLayout.a(this.a, bo.q((View)ActionBarOverlayLayout.c(this.a)).c(- ActionBarOverlayLayout.c(this.a).getHeight()).a(ActionBarOverlayLayout.b(this.a)));
    }
}

