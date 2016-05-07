/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.view.menu.i;
import android.support.v7.view.menu.j;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.t;
import android.view.MenuItem;

class x
implements j {
    final /* synthetic */ ActionMenuView a;

    private x(ActionMenuView actionMenuView) {
        this.a = actionMenuView;
    }

    /* synthetic */ x(ActionMenuView actionMenuView, t t2) {
        this(actionMenuView);
    }

    @Override
    public void a(i i2) {
        if (ActionMenuView.b(this.a) == null) return;
        ActionMenuView.b(this.a).a(i2);
    }

    @Override
    public boolean a(i i2, MenuItem menuItem) {
        if (ActionMenuView.a(this.a) == null) return false;
        if (!ActionMenuView.a(this.a).a(menuItem)) return false;
        return true;
    }
}

