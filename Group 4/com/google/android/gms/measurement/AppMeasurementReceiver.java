/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.b.md;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.measurement.AppMeasurementService;
import com.google.android.gms.measurement.internal.ag;
import com.google.android.gms.measurement.internal.aj;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.bx;

public final class AppMeasurementReceiver
extends BroadcastReceiver {
    static final Object a = new Object();
    static md b;
    static Boolean c;

    public static boolean a(Context context) {
        bf.a((Object)context);
        if (c != null) {
            return c;
        }
        boolean bl2 = ag.a(context, AppMeasurementReceiver.class, false);
        c = bl2;
        return bl2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onReceive(Context context, Intent intent) {
        bx bx2 = bx.a(context);
        bc bc2 = bx2.f();
        String string = intent.getAction();
        if (bx2.d().N()) {
            bc2.z().a("Device AppMeasurementReceiver got", string);
        } else {
            bc2.z().a("Local AppMeasurementReceiver got", string);
        }
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) return;
        boolean bl2 = AppMeasurementService.a(context);
        Intent intent2 = new Intent(context, (Class)AppMeasurementService.class);
        intent2.setAction("com.google.android.gms.measurement.UPLOAD");
        Object object = a;
        // MONITORENTER : object
        context.startService(intent2);
        if (!bl2) {
            // MONITOREXIT : object
            return;
        }
        try {
            if (b == null) {
                b = new md(context, 1, "AppMeasurement WakeLock");
                b.a(false);
            }
            b.a(1000);
            // MONITOREXIT : object
            return;
        }
        catch (SecurityException var12_9) {
            bc2.c().a("AppMeasurementService at risk of not starting. For more reliable app measurements, add the WAKE_LOCK permission to your manifest.");
            return;
        }
    }
}

