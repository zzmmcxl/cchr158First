/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.a.a;
import com.google.android.gms.a.b;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.j;
import com.google.android.gms.ads.internal.client.u;
import com.google.android.gms.ads.internal.client.w;
import com.google.android.gms.b.cz;
import com.google.android.gms.b.da;

public abstract class v
extends Binder
implements u {
    public static u a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        if (iInterface == null) return new w(iBinder);
        if (!(iInterface instanceof u)) return new w(iBinder);
        return (u)iInterface;
    }

    public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) {
        switch (n2) {
            default: {
                return super.onTransact(n2, parcel, parcel2, n3);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                a a2 = b.a(parcel.readStrongBinder());
                int n4 = parcel.readInt();
                AdSizeParcel adSizeParcel = null;
                if (n4 != 0) {
                    adSizeParcel = AdSizeParcel.CREATOR.a(parcel);
                }
                IBinder iBinder = this.a(a2, adSizeParcel, parcel.readString(), da.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(iBinder);
                return true;
            }
            case 2: 
        }
        parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        a a3 = b.a(parcel.readStrongBinder());
        int n5 = parcel.readInt();
        AdSizeParcel adSizeParcel = null;
        if (n5 != 0) {
            adSizeParcel = AdSizeParcel.CREATOR.a(parcel);
        }
        IBinder iBinder = this.a(a3, adSizeParcel, parcel.readString(), da.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
        parcel2.writeNoException();
        parcel2.writeStrongBinder(iBinder);
        return true;
    }
}

