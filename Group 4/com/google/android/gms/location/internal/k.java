/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.location.internal.FusedLocationProviderResult;
import com.google.android.gms.location.internal.i;

class k
implements i {
    private IBinder a;

    k(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public void a(FusedLocationProviderResult fusedLocationProviderResult) {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            if (fusedLocationProviderResult != null) {
                parcel.writeInt(1);
                fusedLocationProviderResult.writeToParcel(parcel, 0);
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

