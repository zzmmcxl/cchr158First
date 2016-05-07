/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.os.Looper;
import com.google.android.gms.measurement.internal.ao;
import com.google.android.gms.measurement.internal.bt;

class ap
implements Runnable {
    final /* synthetic */ ao a;

    ap(ao ao2) {
        this.a = ao2;
    }

    @Override
    public void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ao.a(this.a).h().a(this);
            return;
        }
        boolean bl2 = this.a.b();
        ao.a(this.a, 0);
        if (!bl2) return;
        if (!ao.b(this.a)) return;
        this.a.a();
    }
}

