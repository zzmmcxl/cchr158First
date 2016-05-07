/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.d.a.a;
import android.support.v4.d.a.c;
import android.support.v7.view.menu.ac;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

class ae
extends ac
implements SubMenu {
    ae(Context context, c c2) {
        super(context, c2);
    }

    public c b() {
        return (c)this.b;
    }

    public void clearHeader() {
        this.b().clearHeader();
    }

    public MenuItem getItem() {
        return this.a(this.b().getItem());
    }

    public SubMenu setHeaderIcon(int n2) {
        this.b().setHeaderIcon(n2);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        this.b().setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(int n2) {
        this.b().setHeaderTitle(n2);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.b().setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        this.b().setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int n2) {
        this.b().setIcon(n2);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.b().setIcon(drawable);
        return this;
    }
}

