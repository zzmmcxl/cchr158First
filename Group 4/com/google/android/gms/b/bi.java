/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.a.a;
import com.google.android.gms.b.bh;
import com.google.android.gms.b.bj;

public abstract class bi
extends Binder
implements bh {
    public static bh a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        if (iInterface == null) return new bj(iBinder);
        if (!(iInterface instanceof bh)) return new bj(iBinder);
        return (bh)iInterface;
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
                parcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                a a2 = this.a();
                parcel2.writeNoException();
                IBinder iBinder = a2 != null ? a2.asBinder() : null;
                parcel2.writeStrongBinder(iBinder);
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                Uri uri = this.b();
                parcel2.writeNoException();
                if (uri != null) {
                    parcel2.writeInt(1);
                    uri.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            }
            case 3: 
        }
        parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        double d2 = this.c();
        parcel2.writeNoException();
        parcel2.writeDouble(d2);
        return true;
    }
}

