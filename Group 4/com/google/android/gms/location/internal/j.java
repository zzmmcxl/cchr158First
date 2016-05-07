/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.internal.FusedLocationProviderResult;
import com.google.android.gms.location.internal.i;
import com.google.android.gms.location.internal.k;

public abstract class j
extends Binder
implements i {
    public static i a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
        if (iInterface == null) return new k(iBinder);
        if (!(iInterface instanceof i)) return new k(iBinder);
        return (i)iInterface;
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
                parcel2.writeString("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
                return true;
            }
            case 1: 
        }
        parcel.enforceInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
        FusedLocationProviderResult fusedLocationProviderResult = parcel.readInt() != 0 ? (FusedLocationProviderResult)FusedLocationProviderResult.CREATOR.createFromParcel(parcel) : null;
        this.a(fusedLocationProviderResult);
        return true;
    }
}

