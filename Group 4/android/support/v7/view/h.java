/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view;

import android.content.Context;
import android.support.v4.d.a.a;
import android.support.v4.g.q;
import android.support.v7.view.b;
import android.support.v7.view.c;
import android.support.v7.view.g;
import android.support.v7.view.menu.ab;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

public class h
implements c {
    final ActionMode.Callback a;
    final Context b;
    final ArrayList c;
    final q d;

    public h(Context context, ActionMode.Callback callback) {
        this.b = context;
        this.a = callback;
        this.c = new ArrayList();
        this.d = new q();
    }

    private Menu a(Menu menu) {
        Menu menu2 = (Menu)this.d.get((Object)menu);
        if (menu2 != null) return menu2;
        menu2 = ab.a(this.b, (a)menu);
        this.d.put((Object)menu, (Object)menu2);
        return menu2;
    }

    @Override
    public void a(b b2) {
        this.a.onDestroyActionMode(this.b(b2));
    }

    @Override
    public boolean a(b b2, Menu menu) {
        return this.a.onCreateActionMode(this.b(b2), this.a(menu));
    }

    @Override
    public boolean a(b b2, MenuItem menuItem) {
        return this.a.onActionItemClicked(this.b(b2), ab.a(this.b, (android.support.v4.d.a.b)menuItem));
    }

    public ActionMode b(b b2) {
        int n2 = this.c.size();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                g g2 = new g(this.b, b2);
                this.c.add(g2);
                return g2;
            }
            g g3 = (g)((Object)this.c.get(n3));
            if (g3 != null && g3.b == b2) {
                return g3;
            }
            ++n3;
        } while (true);
    }

    @Override
    public boolean b(b b2, Menu menu) {
        return this.a.onPrepareActionMode(this.b(b2), this.a(menu));
    }
}

