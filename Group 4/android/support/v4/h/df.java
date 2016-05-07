/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.support.v4.h.dc;
import android.support.v4.h.dd;
import android.support.v4.h.de;
import android.view.View;
import java.lang.ref.WeakReference;

class df
implements Runnable {
    WeakReference a;
    dc b;
    final /* synthetic */ de c;

    private df(de de2, dc dc2, View view) {
        this.c = de2;
        this.a = new WeakReference<View>(view);
        this.b = dc2;
    }

    /* synthetic */ df(de de2, dc dc2, View view, dd dd2) {
        this(de2, dc2, view);
    }

    @Override
    public void run() {
        View view = (View)this.a.get();
        if (view == null) return;
        de.a(this.c, this.b, view);
    }
}

