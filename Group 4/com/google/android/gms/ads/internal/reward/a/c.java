/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.reward.a;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.internal.reward.a.a;
import com.google.android.gms.b.cz;

class c
implements a {
    private IBinder a;

    c(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public IBinder a(com.google.android.gms.a.a a2, cz cz2, int n2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
            IBinder iBinder = a2 != null ? a2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            IBinder iBinder2 = null;
            if (cz2 != null) {
                iBinder2 = cz2.asBinder();
            }
            parcel.writeStrongBinder(iBinder2);
            parcel.writeInt(n2);
            this.a.transact(1, parcel, parcel2, 0);
            parcel2.readException();
            IBinder iBinder3 = parcel2.readStrongBinder();
            return iBinder3;
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

