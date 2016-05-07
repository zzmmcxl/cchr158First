/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.b.h;

class j
implements h {
    private IBinder a;

    j(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public String a() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.a.transact(1, parcel, parcel2, 0);
            parcel2.readException();
            String string = parcel2.readString();
            return string;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public String a(String string) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            parcel.writeString(string);
            this.a.transact(3, parcel, parcel2, 0);
            parcel2.readException();
            String string2 = parcel2.readString();
            return string2;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(String string, boolean bl2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            parcel.writeString(string);
            int n2 = 0;
            if (bl2) {
                n2 = 1;
            }
            parcel.writeInt(n2);
            this.a.transact(4, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public boolean a(boolean bl2) {
        boolean bl3 = true;
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            boolean bl4 = bl2 ? bl3 : false;
            parcel.writeInt((int)bl4 ? 1 : 0);
            this.a.transact(2, parcel, parcel2, 0);
            parcel2.readException();
            int n2 = parcel2.readInt();
            if (n2 != 0) return bl3;
            bl3 = false;
            return bl3;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }
}

