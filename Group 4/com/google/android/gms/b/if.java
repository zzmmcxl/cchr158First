/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.b.ie;
import com.google.android.gms.b.ig;
import com.google.android.gms.common.api.Status;

public abstract class if
extends Binder
implements ie {
    public static ie a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusCallbacks");
        if (iInterface == null) return new ig(iBinder);
        if (!(iInterface instanceof ie)) return new ig(iBinder);
        return (ie)iInterface;
    }

    public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) {
        switch (n2) {
            default: {
                return super.onTransact(n2, parcel, parcel2, n3);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusCallbacks");
                return true;
            }
            case 2: 
        }
        parcel.enforceInterface("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusCallbacks");
        Status status = parcel.readInt() != 0 ? (Status)Status.CREATOR.createFromParcel(parcel) : null;
        this.a(status);
        parcel2.writeNoException();
        return true;
    }
}

