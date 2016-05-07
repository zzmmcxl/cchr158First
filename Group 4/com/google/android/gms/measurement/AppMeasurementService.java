/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.b.md;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.measurement.AppMeasurementReceiver;
import com.google.android.gms.measurement.c;
import com.google.android.gms.measurement.internal.ag;
import com.google.android.gms.measurement.internal.aj;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.bt;
import com.google.android.gms.measurement.internal.bx;
import com.google.android.gms.measurement.internal.cc;

public final class AppMeasurementService
extends Service {
    private static Boolean b;
    private final Handler a = new Handler();

    static /* synthetic */ Handler a(AppMeasurementService appMeasurementService) {
        return appMeasurementService.a;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private void a() {
        md md2;
        try {
            Object object = AppMeasurementReceiver.a;
            // MONITORENTER : object
            md2 = AppMeasurementReceiver.b;
        }
        catch (SecurityException var1_3) {
            return;
        }
        if (md2 != null && md2.b()) {
            md2.a();
        }
        // MONITOREXIT : object
    }

    public static boolean a(Context context) {
        bf.a((Object)context);
        if (b != null) {
            return b;
        }
        boolean bl2 = ag.a(context, AppMeasurementService.class);
        b = bl2;
        return bl2;
    }

    private bc b() {
        return bx.a((Context)this).f();
    }

    public IBinder onBind(Intent intent) {
        if (intent == null) {
            this.b().b().a("onBind called with null intent");
            return null;
        }
        String string = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(string)) {
            return new cc(bx.a((Context)this));
        }
        this.b().c().a("onBind received unknown action", string);
        return null;
    }

    public void onCreate() {
        super.onCreate();
        bx bx2 = bx.a((Context)this);
        bc bc2 = bx2.f();
        if (bx2.d().N()) {
            bc2.z().a("Device AppMeasurementService is starting up");
            return;
        }
        bc2.z().a("Local AppMeasurementService is starting up");
    }

    public void onDestroy() {
        bx bx2 = bx.a((Context)this);
        bc bc2 = bx2.f();
        if (bx2.d().N()) {
            bc2.z().a("Device AppMeasurementService is shutting down");
        } else {
            bc2.z().a("Local AppMeasurementService is shutting down");
        }
        super.onDestroy();
    }

    public void onRebind(Intent intent) {
        if (intent == null) {
            this.b().b().a("onRebind called with null intent");
            return;
        }
        String string = intent.getAction();
        this.b().z().a("onRebind called. action", string);
    }

    public int onStartCommand(Intent intent, int n2, int n3) {
        this.a();
        bx bx2 = bx.a((Context)this);
        bc bc2 = bx2.f();
        String string = intent.getAction();
        if (bx2.d().N()) {
            bc2.z().a("Device AppMeasurementService called. startId, action", n3, string);
        } else {
            bc2.z().a("Local AppMeasurementService called. startId, action", n3, string);
        }
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) return 2;
        bx2.h().a(new c(this, bx2, n3, bc2));
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        if (intent == null) {
            this.b().b().a("onUnbind called with null intent");
            return true;
        }
        String string = intent.getAction();
        this.b().z().a("onUnbind called for intent. action", string);
        return true;
    }
}

