/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.location.e;
import com.google.android.gms.location.internal.ParcelableGeofence;

public final class f {
    private String a = null;
    private int b = 0;
    private long c = Long.MIN_VALUE;
    private short d = -1;
    private double e;
    private double f;
    private float g;
    private int h = 0;
    private int i = -1;

    public e a() {
        if (this.a == null) {
            throw new IllegalArgumentException("Request ID not set.");
        }
        if (this.b == 0) {
            throw new IllegalArgumentException("Transitions types not set.");
        }
        if ((4 & this.b) != 0 && this.i < 0) {
            throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
        }
        if (this.c == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Expiration not set.");
        }
        if (this.d == -1) {
            throw new IllegalArgumentException("Geofence region not set.");
        }
        if (this.h >= 0) return new ParcelableGeofence(this.a, this.b, 1, this.e, this.f, this.g, this.c, this.h, this.i);
        throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
    }

    public f a(double d2, double d3, float f2) {
        this.d = 1;
        this.e = d2;
        this.f = d3;
        this.g = f2;
        return this;
    }

    public f a(int n2) {
        this.b = n2;
        return this;
    }

    public f a(long l2) {
        if (l2 < 0) {
            this.c = -1;
            return this;
        }
        this.c = l2 + SystemClock.elapsedRealtime();
        return this;
    }

    public f a(String string) {
        this.a = string;
        return this;
    }
}

