/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Context;
import com.google.android.gms.b.fx;

class fy
implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ fx b;

    fy(fx fx2, Context context) {
        this.b = fx2;
        this.a = context;
    }

    @Override
    public void run() {
        Object object = fx.a(this.b);
        // MONITORENTER : object
        fx.a(this.b, this.b.a(this.a));
        fx.a(this.b).notifyAll();
        // MONITOREXIT : object
        return;
    }
}

