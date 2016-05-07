/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.ax;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.i;
import com.google.android.gms.measurement.internal.p;

class s
implements Runnable {
    final /* synthetic */ ax a;
    final /* synthetic */ p b;

    s(p p2, ax ax2) {
        this.b = p2;
        this.a = ax2;
    }

    @Override
    public void run() {
        p p2 = this.b;
        // MONITORENTER : p2
        p.a(this.b, false);
        if (!this.b.a.b()) {
            this.b.a.s().y().a("Connected to remote service");
            i.a(this.b.a, this.a);
        }
        // MONITOREXIT : p2
        return;
    }
}

