/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import com.google.android.gms.measurement.AppMeasurementService;
import com.google.android.gms.measurement.internal.i;
import com.google.android.gms.measurement.internal.p;

class t
implements Runnable {
    final /* synthetic */ p a;

    t(p p2) {
        this.a = p2;
    }

    @Override
    public void run() {
        i.a(this.a.a, new ComponentName(this.a.a.m(), (Class)AppMeasurementService.class));
    }
}

