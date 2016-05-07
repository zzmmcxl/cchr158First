/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.api.n;
import com.google.android.gms.common.api.t;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.g;

public class f
implements g {
    @Override
    public t a(n n2, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        return n2.a(new com.google.android.gms.location.internal.g(this, n2, geofencingRequest, pendingIntent));
    }
}

