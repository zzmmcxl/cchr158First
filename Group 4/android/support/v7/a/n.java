/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.content.DialogInterface;
import android.support.v7.a.e;
import android.support.v7.a.k;
import android.view.View;
import android.widget.AdapterView;

class n
implements AdapterView.OnItemClickListener {
    final /* synthetic */ e a;
    final /* synthetic */ k b;

    n(k k2, e e2) {
        this.b = k2;
        this.a = e2;
    }

    public void onItemClick(AdapterView adapterView, View view, int n2, long l2) {
        this.b.u.onClick((DialogInterface)e.g(this.a), n2);
        if (this.b.E) return;
        e.g(this.a).dismiss();
    }
}

