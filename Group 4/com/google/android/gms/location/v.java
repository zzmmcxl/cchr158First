/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.t;

class v
implements t {
    private IBinder a;

    v(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public void a(LocationAvailability locationAvailability) {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.ILocationCallback");
            if (locationAvailability != null) {
                parcel.writeInt(1);
                locationAvailability.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(2, parcel, null, 1);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    @Override
    public void a(LocationResult locationResult) {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.ILocationCallback");
            if (locationResult != null) {
                parcel.writeInt(1);
                locationResult.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(1, parcel, null, 1);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }
}

