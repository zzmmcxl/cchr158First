/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.a;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.u;
import com.google.android.gms.b.cz;

class w
implements u {
    private IBinder a;

    w(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public IBinder a(a a2, AdSizeParcel adSizeParcel, String string, cz cz2, int n2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            IBinder iBinder = a2 != null ? a2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (adSizeParcel != null) {
                parcel.writeInt(1);
                adSizeParcel.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(string);
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

    @Override
    public IBinder a(a a2, AdSizeParcel adSizeParcel, String string, cz cz2, int n2, int n3) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            IBinder iBinder = a2 != null ? a2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (adSizeParcel != null) {
                parcel.writeInt(1);
                adSizeParcel.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(string);
            IBinder iBinder2 = null;
            if (cz2 != null) {
                iBinder2 = cz2.asBinder();
            }
            parcel.writeStrongBinder(iBinder2);
            parcel.writeInt(n2);
            parcel.writeInt(n3);
            this.a.transact(2, parcel, parcel2, 0);
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

