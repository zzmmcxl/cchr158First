/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.view.b;
import android.support.v7.widget.ActionBarContextView;
import android.view.View;

class e
implements View.OnClickListener {
    final /* synthetic */ b a;
    final /* synthetic */ ActionBarContextView b;

    e(ActionBarContextView actionBarContextView, b b2) {
        this.b = actionBarContextView;
        this.a = b2;
    }

    public void onClick(View view) {
        this.a.c();
    }
}

