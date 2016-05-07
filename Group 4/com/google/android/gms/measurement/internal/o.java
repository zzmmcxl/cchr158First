/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.ax;
import com.google.android.gms.measurement.internal.ba;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.i;

class o
implements Runnable {
    final /* synthetic */ i a;

    o(i i2) {
        this.a = i2;
    }

    @Override
    public void run() {
        ax ax2 = i.c(this.a);
        if (ax2 == null) {
            this.a.s().b().a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            ax2.a(this.a.i().a(this.a.s().A()));
            i.d(this.a);
            return;
        }
        catch (RemoteException var2_2) {
            this.a.s().b().a("Failed to send app launch to AppMeasurementService", (Object)var2_2);
            return;
        }
    }
}

