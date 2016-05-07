/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.credentials.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.internal.e;
import com.google.android.gms.auth.api.credentials.internal.g;
import com.google.android.gms.common.api.Status;

public abstract class f
extends Binder
implements e {
    public static e a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
        if (iInterface == null) return new g(iBinder);
        if (!(iInterface instanceof e)) return new g(iBinder);
        return (e)iInterface;
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
                parcel2.writeString("com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
                Status status = parcel.readInt() != 0 ? (Status)Status.CREATOR.createFromParcel(parcel) : null;
                Credential credential = parcel.readInt() != 0 ? (Credential)Credential.CREATOR.createFromParcel(parcel) : null;
                this.a(status, credential);
                parcel2.writeNoException();
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
                Status status = parcel.readInt() != 0 ? (Status)Status.CREATOR.createFromParcel(parcel) : null;
                this.a(status);
                parcel2.writeNoException();
                return true;
            }
            case 3: 
        }
        parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
        Status status = parcel.readInt() != 0 ? (Status)Status.CREATOR.createFromParcel(parcel) : null;
        this.a(status, parcel.readString());
        parcel2.writeNoException();
        return true;
    }
}

