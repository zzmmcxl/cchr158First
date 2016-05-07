/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.a;
import com.google.android.gms.ads.internal.client.ab;

class ad
implements ab {
    private IBinder a;

    ad(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public IBinder a(a a2, int n2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
            IBinder iBinder = a2 != null ? a2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            this.a.transact(1, parcel, parcel2, 0);
            parcel2.readException();
            IBinder iBinder2 = parcel2.readStrongBinder();
            return iBinder2;
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

