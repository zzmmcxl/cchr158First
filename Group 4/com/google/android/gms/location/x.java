/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.w;
import com.google.android.gms.location.y;

public abstract class x
extends Binder
implements w {
    public static w a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
        if (iInterface == null) return new y(iBinder);
        if (!(iInterface instanceof w)) return new y(iBinder);
        return (w)iInterface;
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
                parcel2.writeString("com.google.android.gms.location.ILocationListener");
                return true;
            }
            case 1: 
        }
        parcel.enforceInterface("com.google.android.gms.location.ILocationListener");
        Location location = parcel.readInt() != 0 ? (Location)Location.CREATOR.createFromParcel(parcel) : null;
        this.a(location);
        return true;
    }
}

