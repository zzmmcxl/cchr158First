/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.df;
import android.support.v7.widget.dj;
import android.view.View;
import android.widget.AdapterView;

class di
implements AdapterView.OnItemSelectedListener {
    final /* synthetic */ df a;

    di(df df2) {
        this.a = df2;
    }

    public void onItemSelected(AdapterView adapterView, View view, int n2, long l2) {
        if (n2 == -1) return;
        dj dj2 = df.a(this.a);
        if (dj2 == null) return;
        dj.a(dj2, false);
    }

    public void onNothingSelected(AdapterView adapterView) {
    }
}

