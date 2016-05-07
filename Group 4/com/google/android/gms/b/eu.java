/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.b.eq;
import com.google.android.gms.b.er;
import com.google.android.gms.b.et;

public abstract class eu
extends Binder
implements et {
    public eu() {
        this.attachInterface((IInterface)this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
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
                parcel2.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
                return true;
            }
            case 1: 
        }
        parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
        this.a(er.a(parcel.readStrongBinder()));
        parcel2.writeNoException();
        return true;
    }
}

