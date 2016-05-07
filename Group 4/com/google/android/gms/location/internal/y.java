/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.location.internal.m;
import com.google.android.gms.location.p;

final class y
extends m {
    private d a;

    public y(d d2) {
        this.a = d2;
    }

    @Override
    public void a(int n2, PendingIntent pendingIntent) {
        Log.wtf((String)"LocationClientImpl", (String)"Unexpected call to onRemoveGeofencesByPendingIntentResult");
    }

    @Override
    public void a(int n2, String[] arrstring) {
        if (this.a == null) {
            Log.wtf((String)"LocationClientImpl", (String)"onAddGeofenceResult called multiple times");
            return;
        }
        Status status = p.b(p.a(n2));
        this.a.a(status);
        this.a = null;
    }

    @Override
    public void b(int n2, String[] arrstring) {
        Log.wtf((String)"LocationClientImpl", (String)"Unexpected call to onRemoveGeofencesByRequestIdsResult");
    }
}

