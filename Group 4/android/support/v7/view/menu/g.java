/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view.menu;

import android.content.Context;
import android.os.IBinder;
import android.support.v7.view.menu.ExpandedMenuView;
import android.support.v7.view.menu.ad;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.l;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.x;
import android.support.v7.view.menu.y;
import android.support.v7.view.menu.z;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;

public class g
implements x,
AdapterView.OnItemClickListener {
    Context a;
    LayoutInflater b;
    i c;
    ExpandedMenuView d;
    int e;
    int f;
    h g;
    private int h;
    private y i;

    public g(int n2, int n3) {
        this.f = n2;
        this.e = n3;
    }

    public g(Context context, int n2) {
        this(n2, 0);
        this.a = context;
        this.b = LayoutInflater.from((Context)this.a);
    }

    static /* synthetic */ int a(g g2) {
        return g2.h;
    }

    public z a(ViewGroup viewGroup) {
        if (this.d != null) return this.d;
        this.d = (ExpandedMenuView)this.b.inflate(android.support.v7.b.i.abc_expanded_menu_layout, viewGroup, false);
        if (this.g == null) {
            this.g = new h(this);
        }
        this.d.setAdapter((ListAdapter)this.g);
        this.d.setOnItemClickListener((AdapterView.OnItemClickListener)this);
        return this.d;
    }

    public ListAdapter a() {
        if (this.g != null) return this.g;
        this.g = new h(this);
        return this.g;
    }

    @Override
    public void a(Context context, i i2) {
        if (this.e != 0) {
            this.a = new ContextThemeWrapper(context, this.e);
            this.b = LayoutInflater.from((Context)this.a);
        } else if (this.a != null) {
            this.a = context;
            if (this.b == null) {
                this.b = LayoutInflater.from((Context)this.a);
            }
        }
        this.c = i2;
        if (this.g == null) return;
        this.g.notifyDataSetChanged();
    }

    @Override
    public void a(i i2, boolean bl2) {
        if (this.i == null) return;
        this.i.a(i2, bl2);
    }

    public void a(y y2) {
        this.i = y2;
    }

    @Override
    public boolean a(ad ad2) {
        if (!ad2.hasVisibleItems()) {
            return false;
        }
        new l(ad2).a((IBinder)null);
        if (this.i == null) return true;
        this.i.a(ad2);
        return true;
    }

    @Override
    public boolean a(i i2, m m2) {
        return false;
    }

    @Override
    public void b(boolean bl2) {
        if (this.g == null) return;
        this.g.notifyDataSetChanged();
    }

    @Override
    public boolean b() {
        return false;
    }

    @Override
    public boolean b(i i2, m m2) {
        return false;
    }

    public void onItemClick(AdapterView adapterView, View view, int n2, long l2) {
        this.c.a(this.g.a(n2), this, 0);
    }
}

