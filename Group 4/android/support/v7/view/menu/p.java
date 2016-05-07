/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.h.n;
import android.support.v7.view.menu.o;
import android.view.ActionProvider;
import android.view.SubMenu;
import android.view.View;

class p
extends n {
    final ActionProvider a;
    final /* synthetic */ o b;

    public p(o o2, Context context, ActionProvider actionProvider) {
        this.b = o2;
        super(context);
        this.a = actionProvider;
    }

    @Override
    public View a() {
        return this.a.onCreateActionView();
    }

    @Override
    public void a(SubMenu subMenu) {
        this.a.onPrepareSubMenu(this.b.a(subMenu));
    }

    @Override
    public boolean d() {
        return this.a.onPerformDefaultAction();
    }

    @Override
    public boolean e() {
        return this.a.hasSubMenu();
    }
}

