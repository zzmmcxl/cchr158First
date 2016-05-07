/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.bj;
import android.support.v7.widget.bm;
import android.view.View;
import android.widget.AdapterView;

class bn
implements AdapterView.OnItemClickListener {
    final /* synthetic */ bj a;
    final /* synthetic */ bm b;

    bn(bm bm2, bj bj2) {
        this.b = bm2;
        this.a = bj2;
    }

    public void onItemClick(AdapterView adapterView, View view, int n2, long l2) {
        this.b.a.setSelection(n2);
        if (this.b.a.getOnItemClickListener() != null) {
            this.b.a.performItemClick(view, n2, bm.a(this.b).getItemId(n2));
        }
        this.b.i();
    }
}

