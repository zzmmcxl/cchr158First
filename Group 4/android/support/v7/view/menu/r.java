/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view.menu;

import android.support.v4.h.aq;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.o;
import android.view.MenuItem;

class r
extends f
implements aq {
    final /* synthetic */ o a;

    r(o o2, MenuItem.OnActionExpandListener onActionExpandListener) {
        this.a = o2;
        super((Object)onActionExpandListener);
    }

    @Override
    public boolean a(MenuItem menuItem) {
        return ((MenuItem.OnActionExpandListener)this.b).onMenuItemActionExpand(this.a.a(menuItem));
    }

    @Override
    public boolean b(MenuItem menuItem) {
        return ((MenuItem.OnActionExpandListener)this.b).onMenuItemActionCollapse(this.a.a(menuItem));
    }
}

