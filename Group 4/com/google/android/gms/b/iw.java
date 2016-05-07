/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.proxy.ProxyGrpcRequest;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.b.is;
import com.google.android.gms.b.it;
import com.google.android.gms.b.iv;
import com.google.android.gms.b.ix;

public abstract class iw
extends Binder
implements iv {
    public static iv a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        if (iInterface == null) return new ix(iBinder);
        if (!(iInterface instanceof iv)) return new ix(iBinder);
        return (iv)iInterface;
    }

    public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) {
        switch (n2) {
            default: {
                return super.onTransact(n2, parcel, parcel2, n3);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.auth.api.internal.IAuthService");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.auth.api.internal.IAuthService");
                is is2 = it.a(parcel.readStrongBinder());
                int n4 = parcel.readInt();
                ProxyRequest proxyRequest = null;
                if (n4 != 0) {
                    proxyRequest = (ProxyRequest)ProxyRequest.CREATOR.createFromParcel(parcel);
                }
                this.a(is2, proxyRequest);
                parcel2.writeNoException();
                return true;
            }
            case 2: 
        }
        parcel.enforceInterface("com.google.android.gms.auth.api.internal.IAuthService");
        is is3 = it.a(parcel.readStrongBinder());
        int n5 = parcel.readInt();
        ProxyGrpcRequest proxyGrpcRequest = null;
        if (n5 != 0) {
            proxyGrpcRequest = (ProxyGrpcRequest)ProxyGrpcRequest.CREATOR.createFromParcel(parcel);
        }
        this.a(is3, proxyGrpcRequest);
        parcel2.writeNoException();
        return true;
    }
}

