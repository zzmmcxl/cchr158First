/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.reward.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.internal.reward.a.a;
import com.google.android.gms.ads.internal.reward.a.c;
import com.google.android.gms.b.cz;
import com.google.android.gms.b.da;

public abstract class b
extends Binder
implements a {
    public static a a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
        if (iInterface == null) return new c(iBinder);
        if (!(iInterface instanceof a)) return new c(iBinder);
        return (a)iInterface;
    }

    public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) {
        switch (n2) {
            default: {
                return super.onTransact(n2, parcel, parcel2, n3);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
                return true;
            }
            case 1: 
        }
        parcel.enforceInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
        IBinder iBinder = this.a(com.google.android.gms.a.b.a(parcel.readStrongBinder()), da.a(parcel.readStrongBinder()), parcel.readInt());
        parcel2.writeNoException();
        parcel2.writeStrongBinder(iBinder);
        return true;
    }
}

