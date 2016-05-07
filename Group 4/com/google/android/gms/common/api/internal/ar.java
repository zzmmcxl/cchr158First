/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.aq;
import com.google.android.gms.common.api.internal.as;

public abstract class ar
extends Binder
implements aq {
    public static aq a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.api.internal.IStatusCallback");
        if (iInterface == null) return new as(iBinder);
        if (!(iInterface instanceof aq)) return new as(iBinder);
        return (aq)iInterface;
    }

    public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) {
        switch (n2) {
            default: {
                return super.onTransact(n2, parcel, parcel2, n3);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.common.api.internal.IStatusCallback");
                return true;
            }
            case 1: 
        }
        parcel.enforceInterface("com.google.android.gms.common.api.internal.IStatusCallback");
        Status status = parcel.readInt() != 0 ? (Status)Status.CREATOR.createFromParcel(parcel) : null;
        this.a(status);
        return true;
    }
}

