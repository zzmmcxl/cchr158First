/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ap;

class ar
implements ap {
    private IBinder a;

    ar(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public Account a() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IAccountAccessor");
            this.a.transact(2, parcel, parcel2, 0);
            parcel2.readException();
            Account account = parcel2.readInt() != 0 ? (Account)Account.CREATOR.createFromParcel(parcel2) : null;
            return account;
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

