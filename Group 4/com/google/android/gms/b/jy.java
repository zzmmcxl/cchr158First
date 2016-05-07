/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.b.jx;
import com.google.android.gms.b.jz;

public abstract class jy
extends Binder
implements jx {
    public jy() {
        this.attachInterface((IInterface)this, "com.google.android.gms.common.internal.service.ICommonCallbacks");
    }

    public static jx a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonCallbacks");
        if (iInterface == null) return new jz(iBinder);
        if (!(iInterface instanceof jx)) return new jz(iBinder);
        return (jx)iInterface;
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
                parcel2.writeString("com.google.android.gms.common.internal.service.ICommonCallbacks");
                return true;
            }
            case 1: 
        }
        parcel.enforceInterface("com.google.android.gms.common.internal.service.ICommonCallbacks");
        this.a(parcel.readInt());
        parcel2.writeNoException();
        return true;
    }
}

