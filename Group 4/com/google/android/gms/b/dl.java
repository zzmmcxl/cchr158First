/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.b.dj;

class dl
implements dj {
    private IBinder a;

    dl(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public int a() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
            this.a.transact(1, parcel, parcel2, 0);
            parcel2.readException();
            int n2 = parcel2.readInt();
            return n2;
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

