/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.k;
import com.google.android.gms.location.t;
import com.google.android.gms.location.v;

public abstract class u
extends Binder
implements t {
    public static t a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        if (iInterface == null) return new v(iBinder);
        if (!(iInterface instanceof t)) return new v(iBinder);
        return (t)iInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) {
        switch (n2) {
            default: {
                return super.onTransact(n2, parcel, parcel2, n3);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.location.ILocationCallback");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.location.ILocationCallback");
                int n4 = parcel.readInt();
                LocationResult locationResult = null;
                if (n4 != 0) {
                    locationResult = (LocationResult)LocationResult.CREATOR.createFromParcel(parcel);
                }
                this.a(locationResult);
                return true;
            }
            case 2: 
        }
        parcel.enforceInterface("com.google.android.gms.location.ILocationCallback");
        int n5 = parcel.readInt();
        LocationAvailability locationAvailability = null;
        if (n5 != 0) {
            locationAvailability = LocationAvailability.CREATOR.a(parcel);
        }
        this.a(locationAvailability);
        return true;
    }
}

