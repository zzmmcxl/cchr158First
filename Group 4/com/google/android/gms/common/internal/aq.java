/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.ar;

public abstract class aq
extends Binder
implements ap {
    public static ap a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
        if (iInterface == null) return new ar(iBinder);
        if (!(iInterface instanceof ap)) return new ar(iBinder);
        return (ap)iInterface;
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
                parcel2.writeString("com.google.android.gms.common.internal.IAccountAccessor");
                return true;
            }
            case 2: 
        }
        parcel.enforceInterface("com.google.android.gms.common.internal.IAccountAccessor");
        Account account = this.a();
        parcel2.writeNoException();
        if (account != null) {
            parcel2.writeInt(1);
            account.writeToParcel(parcel2, 1);
            return true;
        }
        parcel2.writeInt(0);
        return true;
    }
}

