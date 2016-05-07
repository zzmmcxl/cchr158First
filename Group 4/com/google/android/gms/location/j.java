/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import com.google.android.gms.common.internal.bf;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.e;
import com.google.android.gms.location.i;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class j {
    private final List a = new ArrayList();
    private int b = 5;

    public static int b(int n2) {
        return n2 & 7;
    }

    public GeofencingRequest a() {
        boolean bl2 = !this.a.isEmpty();
        bf.b(bl2, "No geofence has been added to this request.");
        return new GeofencingRequest(this.a, this.b, null);
    }

    public j a(int n2) {
        this.b = j.b(n2);
        return this;
    }

    public j a(e e2) {
        bf.a(e2, (Object)"geofence can't be null.");
        bf.b(e2 instanceof ParcelableGeofence, "Geofence must be created using Geofence.Builder.");
        this.a.add((ParcelableGeofence)e2);
        return this;
    }

    public j a(List list) {
        if (list == null) return this;
        if (list.isEmpty()) {
            return this;
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            e e2 = (e)iterator.next();
            if (e2 == null) continue;
            this.a(e2);
        }
        return this;
    }
}

