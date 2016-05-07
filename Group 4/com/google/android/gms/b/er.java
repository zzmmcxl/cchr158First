/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.b.eq;
import com.google.android.gms.b.es;

public abstract class er
extends Binder
implements eq {
    public static eq a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
        if (iInterface == null) return new es(iBinder);
        if (!(iInterface instanceof eq)) return new es(iBinder);
        return (eq)iInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) {
        switch (n2) {
            default: {
                return super.onTransact(n2, parcel, parcel2, n3);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                String string = this.a();
                parcel2.writeNoException();
                parcel2.writeString(string);
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                this.a(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            case 3: 
        }
        parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
        this.b(parcel.readInt());
        parcel2.writeNoException();
        return true;
    }
}

