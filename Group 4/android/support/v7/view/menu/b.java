/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view.menu;

import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.k;
import android.support.v7.view.menu.m;
import android.support.v7.widget.df;
import android.support.v7.widget.dk;
import android.view.View;

class b
extends dk {
    final /* synthetic */ ActionMenuItemView a;

    public b(ActionMenuItemView actionMenuItemView) {
        this.a = actionMenuItemView;
        super((View)actionMenuItemView);
    }

    @Override
    public df a() {
        if (ActionMenuItemView.a(this.a) == null) return null;
        return ActionMenuItemView.a(this.a).a();
    }

    @Override
    protected boolean b() {
        k k2 = ActionMenuItemView.b(this.a);
        boolean bl2 = false;
        if (k2 == null) return bl2;
        boolean bl3 = ActionMenuItemView.b(this.a).a(ActionMenuItemView.c(this.a));
        bl2 = false;
        if (!bl3) return bl2;
        df df2 = this.a();
        bl2 = false;
        if (df2 == null) return bl2;
        boolean bl4 = df2.k();
        bl2 = false;
        if (!bl4) return bl2;
        return true;
    }
}

