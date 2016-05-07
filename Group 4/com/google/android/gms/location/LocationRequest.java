/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.bc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.l;

public final class LocationRequest
implements SafeParcelable {
    public static final l CREATOR = new l();
    int a;
    long b;
    long c;
    boolean d;
    long e;
    int f;
    float g;
    long h;
    private final int i;

    public LocationRequest() {
        this.i = 1;
        this.a = 102;
        this.b = 3600000;
        this.c = 600000;
        this.d = false;
        this.e = Long.MAX_VALUE;
        this.f = Integer.MAX_VALUE;
        this.g = 0.0f;
        this.h = 0;
    }

    LocationRequest(int n2, int n3, long l2, long l3, boolean bl2, long l4, int n4, float f2, long l5) {
        this.i = n2;
        this.a = n3;
        this.b = l2;
        this.c = l3;
        this.d = bl2;
        this.e = l4;
        this.f = n4;
        this.g = f2;
        this.h = l5;
    }

    public static String a(int n2) {
        switch (n2) {
            default: {
                return "???";
            }
            case 100: {
                return "PRIORITY_HIGH_ACCURACY";
            }
            case 102: {
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            }
            case 104: {
                return "PRIORITY_LOW_POWER";
            }
            case 105: 
        }
        return "PRIORITY_NO_POWER";
    }

    int a() {
        return this.i;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest)object;
        if (this.a != locationRequest.a) return false;
        if (this.b != locationRequest.b) return false;
        if (this.c != locationRequest.c) return false;
        if (this.d != locationRequest.d) return false;
        if (this.e != locationRequest.e) return false;
        if (this.f != locationRequest.f) return false;
        if (this.g == locationRequest.g) return true;
        return false;
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{this.a, this.b, this.c, this.d, this.e, this.f, Float.valueOf(this.g)};
        return bc.a(arrobject);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request[").append(LocationRequest.a(this.a));
        if (this.a != 105) {
            stringBuilder.append(" requested=");
            stringBuilder.append(this.b).append("ms");
        }
        stringBuilder.append(" fastest=");
        stringBuilder.append(this.c).append("ms");
        if (this.h > this.b) {
            stringBuilder.append(" maxWait=");
            stringBuilder.append(this.h).append("ms");
        }
        if (this.e != Long.MAX_VALUE) {
            long l2 = this.e - SystemClock.elapsedRealtime();
            stringBuilder.append(" expireIn=");
            stringBuilder.append(l2).append("ms");
        }
        if (this.f != Integer.MAX_VALUE) {
            stringBuilder.append(" num=").append(this.f);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        l.a(this, parcel, n2);
    }
}

