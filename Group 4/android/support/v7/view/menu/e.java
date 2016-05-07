/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.d.a.b;
import android.support.v4.d.a.c;
import android.support.v4.g.a;
import android.support.v7.view.menu.ab;
import android.support.v7.view.menu.f;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class e
extends f {
    final Context a;
    private Map c;
    private Map d;

    e(Context context, Object object) {
        super(object);
        this.a = context;
    }

    final MenuItem a(MenuItem menuItem) {
        MenuItem menuItem2;
        if (!(menuItem instanceof b)) return menuItem;
        b b2 = (b)menuItem;
        if (this.c == null) {
            this.c = new a();
        }
        if ((menuItem2 = (MenuItem)this.c.get((Object)menuItem)) != null) return menuItem2;
        menuItem2 = ab.a(this.a, b2);
        this.c.put(b2, menuItem2);
        return menuItem2;
    }

    final SubMenu a(SubMenu subMenu) {
        SubMenu subMenu2;
        if (!(subMenu instanceof c)) return subMenu;
        c c2 = (c)subMenu;
        if (this.d == null) {
            this.d = new a();
        }
        if ((subMenu2 = (SubMenu)this.d.get(c2)) != null) return subMenu2;
        subMenu2 = ab.a(this.a, c2);
        this.d.put(c2, subMenu2);
        return subMenu2;
    }

    final void a() {
        if (this.c != null) {
            this.c.clear();
        }
        if (this.d == null) return;
        this.d.clear();
    }

    final void a(int n2) {
        if (this.c == null) {
            return;
        }
        Iterator iterator = this.c.keySet().iterator();
        while (iterator.hasNext()) {
            if (n2 != ((MenuItem)iterator.next()).getGroupId()) continue;
            iterator.remove();
        }
    }

    final void b(int n2) {
        if (this.c == null) {
            return;
        }
        Iterator iterator = this.c.keySet().iterator();
        do {
            if (!iterator.hasNext()) return;
        } while (n2 != ((MenuItem)iterator.next()).getItemId());
        iterator.remove();
    }
}

