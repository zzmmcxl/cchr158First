/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.b.ie;
import com.google.android.gms.b.ih;

class ij
implements ih {
    private IBinder a;

    ij(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public void a(Account account, int n2, ie ie2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService");
            if (account != null) {
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeInt(n2);
            IBinder iBinder = ie2 != null ? ie2.asBinder() : null;
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

    public IBinder asBinder() {
        return this.a;
    }
}

