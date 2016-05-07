/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.a;
import com.google.android.gms.b.bk;

class bm
implements bk {
    private IBinder a;

    bm(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public IBinder a(a a2, a a3, a a4, int n2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
            IBinder iBinder = a2 != null ? a2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            IBinder iBinder2 = a3 != null ? a3.asBinder() : null;
            parcel.writeStrongBinder(iBinder2);
            IBinder iBinder3 = null;
            if (a4 != null) {
                iBinder3 = a4.asBinder();
            }
            parcel.writeStrongBinder(iBinder3);
            parcel.writeInt(n2);
            this.a.transact(1, parcel, parcel2, 0);
            parcel2.readException();
            IBinder iBinder4 = parcel2.readStrongBinder();
            return iBinder4;
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

