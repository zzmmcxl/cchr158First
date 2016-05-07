/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.b.kf;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.measurement.AppMeasurementReceiver;
import com.google.android.gms.measurement.AppMeasurementService;
import com.google.android.gms.measurement.internal.ag;
import com.google.android.gms.measurement.internal.ai;
import com.google.android.gms.measurement.internal.aj;
import com.google.android.gms.measurement.internal.ak;
import com.google.android.gms.measurement.internal.aq;
import com.google.android.gms.measurement.internal.ba;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.bn;
import com.google.android.gms.measurement.internal.bs;
import com.google.android.gms.measurement.internal.bt;
import com.google.android.gms.measurement.internal.bx;
import com.google.android.gms.measurement.internal.cl;
import com.google.android.gms.measurement.internal.d;
import com.google.android.gms.measurement.internal.i;
import com.google.android.gms.measurement.internal.u;

public class ad
extends cl {
    private boolean a;
    private final AlarmManager b;

    protected ad(bx bx2) {
        super(bx2);
        this.b = (AlarmManager)this.m().getSystemService("alarm");
    }

    private PendingIntent c() {
        Intent intent = new Intent(this.m(), (Class)AppMeasurementReceiver.class);
        intent.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast((Context)this.m(), (int)0, (Intent)intent, (int)0);
    }

    @Override
    protected void a() {
        this.b.cancel(this.c());
    }

    public void a(long l2) {
        this.G();
        boolean bl2 = l2 > 0;
        bf.b(bl2);
        bf.a(AppMeasurementReceiver.a(this.m()), (Object)"Receiver not registered/enabled");
        bf.a(AppMeasurementService.a(this.m()), (Object)"Service not registered/enabled");
        this.b();
        long l3 = l2 + this.l().b();
        this.a = true;
        this.b.setInexactRepeating(2, l3, Math.max(this.u().Z(), l2), this.c());
    }

    public void b() {
        this.G();
        this.a = false;
        this.b.cancel(this.c());
    }
}

