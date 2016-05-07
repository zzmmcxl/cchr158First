/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.bj;
import android.support.v7.widget.bm;
import android.view.View;
import android.view.ViewTreeObserver;

class bo
implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ bm a;

    bo(bm bm2) {
        this.a = bm2;
    }

    public void onGlobalLayout() {
        if (!bm.a(this.a, (View)this.a.a)) {
            this.a.i();
            return;
        }
        this.a.b();
        bm.b(this.a);
    }
}

