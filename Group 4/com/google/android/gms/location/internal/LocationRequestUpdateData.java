/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.internal.LocationRequestInternal;
import com.google.android.gms.location.internal.aa;
import com.google.android.gms.location.internal.i;
import com.google.android.gms.location.internal.j;
import com.google.android.gms.location.t;
import com.google.android.gms.location.u;
import com.google.android.gms.location.w;
import com.google.android.gms.location.x;

public class LocationRequestUpdateData
implements SafeParcelable {
    public static final aa CREATOR = new aa();
    int a;
    LocationRequestInternal b;
    w c;
    PendingIntent d;
    t e;
    i f;
    private final int g;

    LocationRequestUpdateData(int n2, int n3, LocationRequestInternal locationRequestInternal, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        this.g = n2;
        this.a = n3;
        this.b = locationRequestInternal;
        w w2 = iBinder == null ? null : x.a(iBinder);
        this.c = w2;
        this.d = pendingIntent;
        t t2 = iBinder2 == null ? null : u.a(iBinder2);
        this.e = t2;
        i i2 = null;
        if (iBinder3 != null) {
            i2 = j.a(iBinder3);
        }
        this.f = i2;
    }

    public static LocationRequestUpdateData a(t t2, i i2) {
        IBinder iBinder;
        IBinder iBinder2 = t2.asBinder();
        if (i2 != null) {
            iBinder = i2.asBinder();
            return new LocationRequestUpdateData(1, 2, null, null, null, iBinder2, iBinder);
        }
        iBinder = null;
        return new LocationRequestUpdateData(1, 2, null, null, null, iBinder2, iBinder);
    }

    public static LocationRequestUpdateData a(w w2, i i2) {
        IBinder iBinder;
        IBinder iBinder2 = w2.asBinder();
        if (i2 != null) {
            iBinder = i2.asBinder();
            return new LocationRequestUpdateData(1, 2, null, iBinder2, null, null, iBinder);
        }
        iBinder = null;
        return new LocationRequestUpdateData(1, 2, null, iBinder2, null, null, iBinder);
    }

    int a() {
        return this.g;
    }

    IBinder b() {
        if (this.c != null) return this.c.asBinder();
        return null;
    }

    IBinder c() {
        if (this.e != null) return this.e.asBinder();
        return null;
    }

    IBinder d() {
        if (this.f != null) return this.f.asBinder();
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        aa.a(this, parcel, n2);
    }
}

