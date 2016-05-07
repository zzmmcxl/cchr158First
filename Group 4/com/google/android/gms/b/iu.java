/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.b.is;

class iu
implements is {
    private IBinder a;

    iu(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public void a(ProxyResponse proxyResponse) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.auth.api.internal.IAuthCallbacks");
            if (proxyResponse != null) {
                parcel.writeInt(1);
                proxyResponse.writeToParcel(parcel, 0);
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

