/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.b.ev;
import com.google.android.gms.b.ex;

public abstract class ew
extends Binder
implements ev {
    public ew() {
        this.attachInterface((IInterface)this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
    }

    public static ev a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
        if (iInterface == null) return new ex(iBinder);
        if (!(iInterface instanceof ev)) return new ex(iBinder);
        return (ev)iInterface;
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
                parcel2.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
                this.a();
                parcel2.writeNoException();
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
                this.b();
                parcel2.writeNoException();
                return true;
            }
            case 3: 
        }
        parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
        int n4 = parcel.readInt();
        int n5 = parcel.readInt();
        Intent intent = parcel.readInt() != 0 ? (Intent)Intent.CREATOR.createFromParcel(parcel) : null;
        this.a(n4, n5, intent);
        parcel2.writeNoException();
        return true;
    }
}

