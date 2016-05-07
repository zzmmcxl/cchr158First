/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement;

import com.google.android.gms.measurement.AppMeasurementService;
import com.google.android.gms.measurement.c;
import com.google.android.gms.measurement.internal.aj;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.bx;

class d
implements Runnable {
    final /* synthetic */ c a;

    d(c c2) {
        this.a = c2;
    }

    @Override
    public void run() {
        if (!this.a.d.stopSelfResult(this.a.b)) return;
        if (this.a.a.d().N()) {
            this.a.c.z().a("Device AppMeasurementService processed last upload request");
            return;
        }
        this.a.c.z().a("Local AppMeasurementService processed last upload request");
    }
}

