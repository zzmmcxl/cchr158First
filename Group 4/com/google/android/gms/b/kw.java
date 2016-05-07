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
import com.google.android.gms.b.kv;
import com.google.android.gms.b.kx;

public abstract class kw
extends Binder
implements kv {
    public kw() {
        this.attachInterface((IInterface)this, "com.google.android.gms.flags.IFlagProvider");
    }

    public static kv asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.flags.IFlagProvider");
        if (iInterface == null) return new kx(iBinder);
        if (!(iInterface instanceof kv)) return new kx(iBinder);
        return (kv)iInterface;
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
                parcel2.writeString("com.google.android.gms.flags.IFlagProvider");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                this.init(b.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                String string = parcel.readString();
                boolean bl2 = parcel.readInt() != 0;
                boolean bl3 = this.getBooleanFlagValue(string, bl2, parcel.readInt());
                parcel2.writeNoException();
                int n4 = 0;
                if (bl3) {
                    n4 = 1;
                }
                parcel2.writeInt(n4);
                return true;
            }
            case 3: {
                parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                int n5 = this.getIntFlagValue(parcel.readString(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(n5);
                return true;
            }
            case 4: {
                parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                long l2 = this.getLongFlagValue(parcel.readString(), parcel.readLong(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeLong(l2);
                return true;
            }
            case 5: 
        }
        parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
        String string = this.getStringFlagValue(parcel.readString(), parcel.readString(), parcel.readInt());
        parcel2.writeNoException();
        parcel2.writeString(string);
        return true;
    }
}

