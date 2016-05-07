/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.content.DialogInterface;
import android.support.v7.a.e;
import android.support.v7.a.k;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

class o
implements AdapterView.OnItemClickListener {
    final /* synthetic */ ListView a;
    final /* synthetic */ e b;
    final /* synthetic */ k c;

    o(k k2, ListView listView, e e2) {
        this.c = k2;
        this.a = listView;
        this.b = e2;
    }

    public void onItemClick(AdapterView adapterView, View view, int n2, long l2) {
        if (this.c.C != null) {
            this.c.C[n2] = this.a.isItemChecked(n2);
        }
        this.c.G.onClick((DialogInterface)e.g(this.b), n2, this.a.isItemChecked(n2));
    }
}

