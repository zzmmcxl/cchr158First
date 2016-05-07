/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.b.ev;

class ex
implements ev {
    private IBinder a;

    ex(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public void a() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
            this.a.transact(1, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(int n2, int n3, Intent intent) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
            parcel.writeInt(n2);
            parcel.writeInt(n3);
            if (intent != null) {
                parcel.writeInt(1);
                intent.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(3, parcel, parcel2, 0);
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

    @Override
    public void b() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
            this.a.transact(2, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }
}

