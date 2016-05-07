/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.b.h;
import com.google.android.gms.b.j;

public abstract class i
extends Binder
implements h {
    public static h a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        if (iInterface == null) return new j(iBinder);
        if (!(iInterface instanceof h)) return new j(iBinder);
        return (h)iInterface;
    }

    public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) {
        switch (n2) {
            default: {
                return super.onTransact(n2, parcel, parcel2, n3);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                String string = this.a();
                parcel2.writeNoException();
                parcel2.writeString(string);
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean bl2 = parcel.readInt() != 0;
                boolean bl3 = this.a(bl2);
                parcel2.writeNoException();
                int n4 = 0;
                if (bl3) {
                    n4 = 1;
                }
                parcel2.writeInt(n4);
                return true;
            }
            case 3: {
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                String string = this.a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(string);
                return true;
            }
            case 4: 
        }
        parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        String string = parcel.readString();
        int n5 = parcel.readInt();
        boolean bl4 = false;
        if (n5 != 0) {
            bl4 = true;
        }
        this.a(string, bl4);
        parcel2.writeNoException();
        return true;
    }
}

