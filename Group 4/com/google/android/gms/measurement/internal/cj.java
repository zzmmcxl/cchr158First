/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.cc;

class cj
implements Runnable {
    final /* synthetic */ AppMetadata a;
    final /* synthetic */ cc b;

    cj(cc cc2, AppMetadata appMetadata) {
        this.b = cc2;
        this.a = appMetadata;
    }

    @Override
    public void run() {
        this.b.a(this.a.h);
        cc.a(this.b).b(this.a);
    }
}

