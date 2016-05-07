/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.b.ie;
import com.google.android.gms.b.if;
import com.google.android.gms.b.ih;
import com.google.android.gms.b.ij;

public abstract class ii
extends Binder
implements ih {
    public static ih a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService");
        if (iInterface == null) return new ij(iBinder);
        if (!(iInterface instanceof ih)) return new ij(iBinder);
        return (ih)iInterface;
    }

    public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) {
        switch (n2) {
            default: {
                return super.onTransact(n2, parcel, parcel2, n3);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService");
                return true;
            }
            case 1: 
        }
        parcel.enforceInterface("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService");
        Account account = parcel.readInt() != 0 ? (Account)Account.CREATOR.createFromParcel(parcel) : null;
        this.a(account, parcel.readInt(), if.a(parcel.readStrongBinder()));
        parcel2.writeNoException();
        return true;
    }
}

