/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.a.a;
import com.google.android.gms.a.b;
import com.google.android.gms.b.ey;
import com.google.android.gms.b.fa;

public abstract class ez
extends Binder
implements ey {
    public static ey a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
        if (iInterface == null) return new fa(iBinder);
        if (!(iInterface instanceof ey)) return new fa(iBinder);
        return (ey)iInterface;
    }

    public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) {
        switch (n2) {
            default: {
                return super.onTransact(n2, parcel, parcel2, n3);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
                return true;
            }
            case 1: 
        }
        parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
        IBinder iBinder = this.a(b.a(parcel.readStrongBinder()));
        parcel2.writeNoException();
        parcel2.writeStrongBinder(iBinder);
        return true;
    }
}

