/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.b.is;
import com.google.android.gms.b.iu;

public abstract class it
extends Binder
implements is {
    public static is a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthCallbacks");
        if (iInterface == null) return new iu(iBinder);
        if (!(iInterface instanceof is)) return new iu(iBinder);
        return (is)iInterface;
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
                parcel2.writeString("com.google.android.gms.auth.api.internal.IAuthCallbacks");
                return true;
            }
            case 1: 
        }
        parcel.enforceInterface("com.google.android.gms.auth.api.internal.IAuthCallbacks");
        ProxyResponse proxyResponse = parcel.readInt() != 0 ? (ProxyResponse)ProxyResponse.CREATOR.createFromParcel(parcel) : null;
        this.a(proxyResponse);
        parcel2.writeNoException();
        return true;
    }
}

