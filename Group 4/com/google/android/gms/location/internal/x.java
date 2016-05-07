/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.q;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.internal.a;
import com.google.android.gms.location.internal.ac;
import com.google.android.gms.location.internal.l;
import com.google.android.gms.location.internal.o;
import com.google.android.gms.location.internal.u;
import com.google.android.gms.location.internal.y;

public class x
extends a {
    private final u e;

    public x(Context context, Looper looper, q q2, r r2, String string, t t2) {
        super(context, looper, q2, r2, string, t2);
        this.e = new u(context, this.d);
    }

    public void a(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, d d2) {
        this.q();
        bf.a(geofencingRequest, (Object)"geofencingRequest can't be null.");
        bf.a((Object)pendingIntent, (Object)"PendingIntent must be specified.");
        bf.a(d2, (Object)"ResultHolder not provided.");
        y y2 = new y(d2);
        ((o)this.r()).a(geofencingRequest, pendingIntent, y2);
    }

    @Override
    public void g() {
        u u2 = this.e;
        // MONITORENTER : u2
        boolean bl2 = this.h();
        if (bl2) {
            try {
                this.e.a();
                this.e.b();
            }
            catch (Exception var4_3) {
                Log.e((String)"LocationClientImpl", (String)"Client disconnected before listeners could be cleaned up", (Throwable)var4_3);
            }
        }
        super.g();
        // MONITOREXIT : u2
        return;
    }
}

