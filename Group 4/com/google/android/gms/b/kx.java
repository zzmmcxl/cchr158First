/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.a;
import com.google.android.gms.b.kv;

class kx
implements kv {
    private IBinder a;

    kx(IBinder iBinder) {
        this.a = iBinder;
    }

    public IBinder asBinder() {
        return this.a;
    }

    @Override
    public boolean getBooleanFlagValue(String string, boolean bl2, int n2) {
        boolean bl3 = true;
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
            parcel.writeString(string);
            boolean bl4 = bl2 ? bl3 : false;
            parcel.writeInt((int)bl4 ? 1 : 0);
            parcel.writeInt(n2);
            this.a.transact(2, parcel, parcel2, 0);
            parcel2.readException();
            int n3 = parcel2.readInt();
            if (n3 != 0) return bl3;
            bl3 = false;
            return bl3;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public int getIntFlagValue(String string, int n2, int n3) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
            parcel.writeString(string);
            parcel.writeInt(n2);
            parcel.writeInt(n3);
            this.a.transact(3, parcel, parcel2, 0);
            parcel2.readException();
            int n4 = parcel2.readInt();
            return n4;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public long getLongFlagValue(String string, long l2, int n2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
            parcel.writeString(string);
            parcel.writeLong(l2);
            parcel.writeInt(n2);
            this.a.transact(4, parcel, parcel2, 0);
            parcel2.readException();
            long l3 = parcel2.readLong();
            return l3;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public String getStringFlagValue(String string, String string2, int n2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
            parcel.writeString(string);
            parcel.writeString(string2);
            parcel.writeInt(n2);
            this.a.transact(5, parcel, parcel2, 0);
            parcel2.readException();
            String string3 = parcel2.readString();
            return string3;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void init(a a2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
            IBinder iBinder = a2 != null ? a2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            this.a.transact(1, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }
}

