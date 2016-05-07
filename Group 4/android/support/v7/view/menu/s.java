/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view.menu;

import android.support.v7.view.menu.f;
import android.support.v7.view.menu.o;
import android.view.MenuItem;

class s
extends f
implements MenuItem.OnMenuItemClickListener {
    final /* synthetic */ o a;

    s(o o2, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.a = o2;
        super((Object)onMenuItemClickListener);
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        return ((MenuItem.OnMenuItemClickListener)this.b).onMenuItemClick(this.a.a(menuItem));
    }
}

