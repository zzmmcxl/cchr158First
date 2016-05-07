/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.az;
import com.google.android.gms.common.internal.bb;

public abstract class ba
extends Binder
implements az {
    public static az a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IResolveAccountCallbacks");
        if (iInterface == null) return new bb(iBinder);
        if (!(iInterface instanceof az)) return new bb(iBinder);
        return (az)iInterface;
    }

    public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) {
        switch (n2) {
            default: {
                return super.onTransact(n2, parcel, parcel2, n3);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.common.internal.IResolveAccountCallbacks");
                return true;
            }
            case 2: 
        }
        parcel.enforceInterface("com.google.android.gms.common.internal.IResolveAccountCallbacks");
        ResolveAccountResponse resolveAccountResponse = parcel.readInt() != 0 ? (ResolveAccountResponse)ResolveAccountResponse.CREATOR.createFromParcel(parcel) : null;
        this.a(resolveAccountResponse);
        parcel2.writeNoException();
        return true;
    }
}

