/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.auth.api.signin.internal.m;
import com.google.android.gms.auth.api.signin.internal.o;
import com.google.android.gms.common.api.Status;

public abstract class n
extends Binder
implements m {
    public n() {
        this.attachInterface((IInterface)this, "com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    public static m a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
        if (iInterface == null) return new o(iBinder);
        if (!(iInterface instanceof m)) return new o(iBinder);
        return (m)iInterface;
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
                parcel2.writeString("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
                Status status = parcel.readInt() != 0 ? (Status)Status.CREATOR.createFromParcel(parcel) : null;
                SignInAccount signInAccount = parcel.readInt() != 0 ? (SignInAccount)SignInAccount.CREATOR.createFromParcel(parcel) : null;
                this.a(status, signInAccount);
                parcel2.writeNoException();
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
                Status status = parcel.readInt() != 0 ? (Status)Status.CREATOR.createFromParcel(parcel) : null;
                this.a(status);
                parcel2.writeNoException();
                return true;
            }
            case 3: {
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
                Status status = parcel.readInt() != 0 ? (Status)Status.CREATOR.createFromParcel(parcel) : null;
                this.a(status, parcel.readString(), parcel.readString(), parcel.readLong());
                parcel2.writeNoException();
                return true;
            }
            case 101: {
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
                GoogleSignInAccount googleSignInAccount = parcel.readInt() != 0 ? (GoogleSignInAccount)GoogleSignInAccount.CREATOR.createFromParcel(parcel) : null;
                Status status = parcel.readInt() != 0 ? (Status)Status.CREATOR.createFromParcel(parcel) : null;
                this.a(googleSignInAccount, status);
                parcel2.writeNoException();
                return true;
            }
            case 102: {
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
                Status status = parcel.readInt() != 0 ? (Status)Status.CREATOR.createFromParcel(parcel) : null;
                this.b(status);
                parcel2.writeNoException();
                return true;
            }
            case 103: 
        }
        parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
        Status status = parcel.readInt() != 0 ? (Status)Status.CREATOR.createFromParcel(parcel) : null;
        this.c(status);
        parcel2.writeNoException();
        return true;
    }
}

