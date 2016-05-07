/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.b.cz;
import com.google.android.gms.b.db;
import com.google.android.gms.b.dc;

public abstract class da
extends Binder
implements cz {
    public static cz a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        if (iInterface == null) return new db(iBinder);
        if (!(iInterface instanceof cz)) return new db(iBinder);
        return (cz)iInterface;
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
                parcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                dc dc2 = this.a(parcel.readString());
                parcel2.writeNoException();
                IBinder iBinder = dc2 != null ? dc2.asBinder() : null;
                parcel2.writeStrongBinder(iBinder);
                return true;
            }
            case 2: 
        }
        parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        boolean bl2 = this.b(parcel.readString());
        parcel2.writeNoException();
        int n4 = bl2 ? 1 : 0;
        parcel2.writeInt(n4);
        return true;
    }
}

