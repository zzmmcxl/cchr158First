/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.a;
import com.google.android.gms.b.ey;

class fa
implements ey {
    private IBinder a;

    fa(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public IBinder a(a a2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
            IBinder iBinder = a2 != null ? a2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
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
