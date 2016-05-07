/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.bn;
import com.google.android.gms.measurement.internal.br;
import com.google.android.gms.measurement.internal.bx;

class bd
implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ bc b;

    bd(bc bc2, String string) {
        this.b = bc2;
        this.a = string;
    }

    @Override
    public void run() {
        bn bn2 = this.b.n.e();
        if (bn2.E() && !bn2.F()) {
            bn2.b.a(this.a);
            return;
        }
        this.b.a(6, "Persisted config not initialized . Not logging error/warn.");
    }
}

