/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement;

import com.google.android.gms.measurement.AppMeasurementService;
import com.google.android.gms.measurement.d;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.bx;

class c
implements Runnable {
    final /* synthetic */ bx a;
    final /* synthetic */ int b;
    final /* synthetic */ bc c;
    final /* synthetic */ AppMeasurementService d;

    c(AppMeasurementService appMeasurementService, bx bx2, int n2, bc bc2) {
        this.d = appMeasurementService;
        this.a = bx2;
        this.b = n2;
        this.c = bc2;
    }

    @Override
    public void run() {
        this.a.B();
        AppMeasurementService.a(this.d).post((Runnable)new d(this));
    }
}

