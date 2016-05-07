/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.proxy.ProxyGrpcRequest;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.b.is;
import com.google.android.gms.b.iv;

class ix
implements iv {
    private IBinder a;

    ix(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public void a(is is2, ProxyGrpcRequest proxyGrpcRequest) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.auth.api.internal.IAuthService");
            IBinder iBinder = is2 != null ? is2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (proxyGrpcRequest != null) {
                parcel.writeInt(1);
                proxyGrpcRequest.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(2, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(is is2, ProxyRequest proxyRequest) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.auth.api.internal.IAuthService");
            IBinder iBinder = is2 != null ? is2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (proxyRequest != null) {
                parcel.writeInt(1);
                proxyRequest.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(1, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }
}

