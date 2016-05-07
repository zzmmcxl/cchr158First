/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.n;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.internal.f;
import com.google.android.gms.location.internal.h;
import com.google.android.gms.location.internal.x;

class g
extends h {
    final /* synthetic */ GeofencingRequest a;
    final /* synthetic */ PendingIntent b;
    final /* synthetic */ f d;

    g(f f2, n n2, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        this.d = f2;
        this.a = geofencingRequest;
        this.b = pendingIntent;
        super(n2);
    }

    protected void a(x x2) {
        x2.a(this.a, this.b, this);
    }
}

