/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.at;
import com.google.android.gms.common.internal.av;

public abstract class au
extends Binder
implements at {
    public au() {
        this.attachInterface((IInterface)this, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    public static at a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
        if (iInterface == null) return new av(iBinder);
        if (!(iInterface instanceof at)) return new av(iBinder);
        return (at)iInterface;
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
                parcel2.writeString("com.google.android.gms.common.internal.IGmsCallbacks");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
                int n4 = parcel.readInt();
                IBinder iBinder = parcel.readStrongBinder();
                int n5 = parcel.readInt();
                Bundle bundle = null;
                if (n5 != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.a(n4, iBinder, bundle);
                parcel2.writeNoException();
                return true;
            }
            case 2: 
        }
        parcel.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
        int n6 = parcel.readInt();
        int n7 = parcel.readInt();
        Bundle bundle = null;
        if (n7 != 0) {
            bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
        }
        this.a(n6, bundle);
        parcel2.writeNoException();
        return true;
    }
}

