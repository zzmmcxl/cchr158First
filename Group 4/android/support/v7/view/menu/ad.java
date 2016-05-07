/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.b.c;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.m;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class ad
extends i
implements SubMenu {
    private i d;
    private m e;

    public ad(Context context, i i2, m m2) {
        super(context);
        this.d = i2;
        this.e = m2;
    }

    @Override
    public String a() {
        if (this.e == null) return null;
        int n2 = this.e.getItemId();
        if (n2 != 0) return super.a() + ":" + n2;
        return null;
    }

    @Override
    public void a(j j2) {
        this.d.a(j2);
    }

    @Override
    boolean a(i i2, MenuItem menuItem) {
        if (super.a(i2, menuItem)) return true;
        if (!this.d.a(i2, menuItem)) return false;
        return true;
    }

    @Override
    public boolean b() {
        return this.d.b();
    }

    @Override
    public boolean c() {
        return this.d.c();
    }

    @Override
    public boolean c(m m2) {
        return this.d.c(m2);
    }

    @Override
    public boolean d(m m2) {
        return this.d.d(m2);
    }

    public MenuItem getItem() {
        return this.e;
    }

    @Override
    public i p() {
        return this.d;
    }

    public Menu s() {
        return this.d;
    }

    public SubMenu setHeaderIcon(int n2) {
        super.a(c.a(this.e(), n2));
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.a(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(int n2) {
        super.a(this.e().getResources().getString(n2));
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.a(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.a(view);
        return this;
    }

    public SubMenu setIcon(int n2) {
        this.e.setIcon(n2);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.e.setIcon(drawable);
        return this;
    }

    @Override
    public void setQwertyMode(boolean bl2) {
        this.d.setQwertyMode(bl2);
    }
}

