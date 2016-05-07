/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.cc;

class ce
implements Runnable {
    final /* synthetic */ AppMetadata a;
    final /* synthetic */ EventParcel b;
    final /* synthetic */ cc c;

    ce(cc cc2, AppMetadata appMetadata, EventParcel eventParcel) {
        this.c = cc2;
        this.a = appMetadata;
        this.b = eventParcel;
    }

    @Override
    public void run() {
        this.c.a(this.a.h);
        cc.a(this.c).a(this.b, this.a);
    }
}

