/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.gx;
import java.util.concurrent.Future;

final class fv
implements Runnable {
    final /* synthetic */ gx a;
    final /* synthetic */ Future b;

    fv(gx gx2, Future future) {
        this.a = gx2;
        this.b = future;
    }

    @Override
    public void run() {
        if (!this.a.isCancelled()) return;
        this.b.cancel(true);
    }
}

