/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.os.IBinder;
import android.support.v7.widget.k;
import android.support.v7.widget.r;
import android.view.View;

class o
implements Runnable {
    final /* synthetic */ k a;
    private r b;

    public o(k k2, r r2) {
        this.a = k2;
        this.b = r2;
    }

    @Override
    public void run() {
        k.g(this.a).f();
        View view = (View)k.h(this.a);
        if (view != null && view.getWindowToken() != null && this.b.d()) {
            k.a(this.a, this.b);
        }
        k.a(this.a, null);
    }
}

