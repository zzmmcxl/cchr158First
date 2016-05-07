/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.a.a;
import com.google.android.gms.a.b;
import com.google.android.gms.b.bh;

class bj
implements bh {
    private IBinder a;

    bj(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public a a() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            this.a.transact(1, parcel, parcel2, 0);
            parcel2.readException();
            a a2 = b.a(parcel2.readStrongBinder());
            return a2;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }

    @Override
    public Uri b() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            this.a.transact(2, parcel, parcel2, 0);
            parcel2.readException();
            Uri uri = parcel2.readInt() != 0 ? (Uri)Uri.CREATOR.createFromParcel(parcel2) : null;
            return uri;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public double c() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            this.a.transact(3, parcel, parcel2, 0);
            parcel2.readException();
            double d2 = parcel2.readDouble();
            return d2;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }
}

