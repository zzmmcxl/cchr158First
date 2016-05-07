/*
 * Decompiled with CFR 0_115.
 */
package xyz;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import xyz.lpsdt5r;
import xyz.m2m5pcv0;

class h
implements View.OnClickListener {
    final /* synthetic */ lpsdt5r a;

    h(lpsdt5r lpsdt5r2) {
        this.a = lpsdt5r2;
    }

    public void onClick(View view) {
        this.a.startActivity(new Intent((Context)this.a, (Class)m2m5pcv0.class));
    }
}

