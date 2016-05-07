/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.internal.r;
import com.google.android.gms.location.internal.t;

public abstract class s
extends Binder
implements r {
    public static r a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.ISettingsCallbacks");
        if (iInterface == null) return new t(iBinder);
        if (!(iInterface instanceof r)) return new t(iBinder);
        return (r)iInterface;
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
                parcel2.writeString("com.google.android.gms.location.internal.ISettingsCallbacks");
                return true;
            }
            case 1: 
        }
        parcel.enforceInterface("com.google.android.gms.location.internal.ISettingsCallbacks");
        LocationSettingsResult locationSettingsResult = parcel.readInt() != 0 ? (LocationSettingsResult)LocationSettingsResult.CREATOR.createFromParcel(parcel) : null;
        this.a(locationSettingsResult);
        return true;
    }
}

