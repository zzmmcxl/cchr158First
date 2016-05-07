/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.ax;
import com.google.android.gms.measurement.internal.ba;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.i;

class m
implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ EventParcel b;
    final /* synthetic */ i c;

    m(i i2, String string, EventParcel eventParcel) {
        this.c = i2;
        this.a = string;
        this.b = eventParcel;
    }

    @Override
    public void run() {
        ax ax2 = i.c(this.c);
        if (ax2 == null) {
            this.c.s().b().a("Discarding data. Failed to send event to service");
            return;
        }
        try {
            if (TextUtils.isEmpty((CharSequence)this.a)) {
                ax2.a(this.b, this.c.i().a(this.c.s().A()));
            } else {
                ax2.a(this.b, this.a, this.c.s().A());
            }
            i.d(this.c);
            return;
        }
        catch (RemoteException var2_2) {
            this.c.s().b().a("Failed to send event to AppMeasurementService", (Object)var2_2);
            return;
        }
    }
}

