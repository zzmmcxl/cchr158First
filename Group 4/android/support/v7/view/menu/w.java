/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view.menu;

import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.view.menu.aa;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.v;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

class w
extends BaseAdapter {
    final /* synthetic */ v a;
    private i b;
    private int c;

    public w(v v2, i i2) {
        this.a = v2;
        this.c = -1;
        this.b = i2;
        this.a();
    }

    static /* synthetic */ i a(w w2) {
        return w2.b;
    }

    public m a(int n2) {
        ArrayList arrayList = v.a(this.a) ? this.b.l() : this.b.i();
        if (this.c < 0) return (m)arrayList.get(n2);
        if (n2 < this.c) return (m)arrayList.get(n2);
        ++n2;
        return (m)arrayList.get(n2);
    }

    void a() {
        m m2 = v.c(this.a).r();
        if (m2 != null) {
            ArrayList arrayList = v.c(this.a).l();
            int n2 = arrayList.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                if ((m)arrayList.get(i2) != m2) continue;
                this.c = i2;
                return;
            }
        }
        this.c = -1;
    }

    public int getCount() {
        ArrayList arrayList = v.a(this.a) ? this.b.l() : this.b.i();
        if (this.c >= 0) return -1 + arrayList.size();
        return arrayList.size();
    }

    public /* synthetic */ Object getItem(int n2) {
        return this.a(n2);
    }

    public long getItemId(int n2) {
        return n2;
    }

    public View getView(int n2, View view, ViewGroup viewGroup) {
        View view2 = view == null ? v.b(this.a).inflate(v.a, viewGroup, false) : view;
        aa aa2 = (aa)view2;
        if (this.a.b) {
            ((ListMenuItemView)view2).setForceShowIcon(true);
        }
        aa2.a(this.a(n2), 0);
        return view2;
    }

    public void notifyDataSetChanged() {
        this.a();
        super.notifyDataSetChanged();
    }
}

