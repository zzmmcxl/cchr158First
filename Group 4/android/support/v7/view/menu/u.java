/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.p;
import android.support.v7.view.menu.t;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

class u
extends p
implements ActionProvider.VisibilityListener {
    android.support.v4.h.p c;
    final /* synthetic */ t d;

    public u(t t2, Context context, ActionProvider actionProvider) {
        this.d = t2;
        super(t2, context, actionProvider);
    }

    @Override
    public View a(MenuItem menuItem) {
        return this.a.onCreateActionView(menuItem);
    }

    @Override
    public void a(android.support.v4.h.p p2) {
        u2.c = p2;
        ActionProvider actionProvider = u2.a;
        if (p2 == null) {
            u u2 = null;
        }
        actionProvider.setVisibilityListener((ActionProvider.VisibilityListener)u2);
    }

    @Override
    public boolean b() {
        return this.a.overridesItemVisibility();
    }

    @Override
    public boolean c() {
        return this.a.isVisible();
    }

    public void onActionProviderVisibilityChanged(boolean bl2) {
        if (this.c == null) return;
        this.c.a(bl2);
    }
}

