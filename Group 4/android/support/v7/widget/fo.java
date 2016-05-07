/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.fn;
import android.view.View;

class fo
implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ fn b;

    fo(fn fn2, View view) {
        this.b = fn2;
        this.a = view;
    }

    @Override
    public void run() {
        int n2 = this.a.getLeft() - (this.b.getWidth() - this.a.getWidth()) / 2;
        this.b.smoothScrollTo(n2, 0);
        this.b.a = null;
    }
}

