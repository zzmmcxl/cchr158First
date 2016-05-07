/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import com.google.android.gms.measurement.internal.ax;
import com.google.android.gms.measurement.internal.ba;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.i;

class n
implements Runnable {
    final /* synthetic */ UserAttributeParcel a;
    final /* synthetic */ i b;

    n(i i2, UserAttributeParcel userAttributeParcel) {
        this.b = i2;
        this.a = userAttributeParcel;
    }

    @Override
    public void run() {
        ax ax2 = i.c(this.b);
        if (ax2 == null) {
            this.b.s().b().a("Discarding data. Failed to set user attribute");
            return;
        }
        try {
            ax2.a(this.a, this.b.i().a(this.b.s().A()));
            i.d(this.b);
            return;
        }
        catch (RemoteException var2_2) {
            this.b.s().b().a("Failed to send attribute to AppMeasurementService", (Object)var2_2);
            return;
        }
    }
}

