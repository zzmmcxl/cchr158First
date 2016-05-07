/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view.menu;

import android.support.v7.view.menu.aa;
import android.support.v7.view.menu.g;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.m;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

class h
extends BaseAdapter {
    final /* synthetic */ g a;
    private int b;

    public h(g g2) {
        this.a = g2;
        this.b = -1;
        this.a();
    }

    public m a(int n2) {
        ArrayList arrayList = this.a.c.l();
        int n3 = n2 + g.a(this.a);
        if (this.b < 0) return (m)arrayList.get(n3);
        if (n3 < this.b) return (m)arrayList.get(n3);
        ++n3;
        return (m)arrayList.get(n3);
    }

    void a() {
        m m2 = this.a.c.r();
        if (m2 != null) {
            ArrayList arrayList = this.a.c.l();
            int n2 = arrayList.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                if ((m)arrayList.get(i2) != m2) continue;
                this.b = i2;
                return;
            }
        }
        this.b = -1;
    }

    public int getCount() {
        int n2 = this.a.c.l().size() - g.a(this.a);
        if (this.b >= 0) return n2 - 1;
        return n2;
    }

    public /* synthetic */ Object getItem(int n2) {
        return this.a(n2);
    }

    public long getItemId(int n2) {
        return n2;
    }

    public View getView(int n2, View view, ViewGroup viewGroup) {
        View view2 = view == null ? this.a.b.inflate(this.a.f, viewGroup, false) : view;
        ((aa)view2).a(this.a(n2), 0);
        return view2;
    }

    public void notifyDataSetChanged() {
        this.a();
        super.notifyDataSetChanged();
    }
}

