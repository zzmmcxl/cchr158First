/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.support.v7.a.e;
import android.view.View;

class j
implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ View b;
    final /* synthetic */ e c;

    j(e e2, View view, View view2) {
        this.c = e2;
        this.a = view;
        this.b = view2;
    }

    @Override
    public void run() {
        e.a((View)e.j(this.c), this.a, this.b);
    }
}
