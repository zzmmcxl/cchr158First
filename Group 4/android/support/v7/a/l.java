/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.content.Context;
import android.support.v7.a.k;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

class l
extends ArrayAdapter {
    final /* synthetic */ ListView a;
    final /* synthetic */ k b;

    l(k k2, Context context, int n2, int n3, CharSequence[] arrcharSequence, ListView listView) {
        this.b = k2;
        this.a = listView;
        super(context, n2, n3, (Object[])arrcharSequence);
    }

    public View getView(int n2, View view, ViewGroup viewGroup) {
        View view2 = super.getView(n2, view, viewGroup);
        if (this.b.C == null) return view2;
        if (!this.b.C[n2]) return view2;
        this.a.setItemChecked(n2, true);
        return view2;
    }
}

