/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.a.d;
import android.support.v7.widget.fn;
import android.support.v7.widget.fo;
import android.support.v7.widget.fr;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

class fp
extends BaseAdapter {
    final /* synthetic */ fn a;

    private fp(fn fn2) {
        this.a = fn2;
    }

    /* synthetic */ fp(fn fn2, fo fo2) {
        this(fn2);
    }

    public int getCount() {
        return fn.a(this.a).getChildCount();
    }

    public Object getItem(int n2) {
        return ((fr)fn.a(this.a).getChildAt(n2)).b();
    }

    public long getItemId(int n2) {
        return n2;
    }

    public View getView(int n2, View view, ViewGroup viewGroup) {
        if (view == null) {
            return fn.a(this.a, (d)this.getItem(n2), true);
        }
        ((fr)view).a((d)this.getItem(n2));
        return view;
    }
}

