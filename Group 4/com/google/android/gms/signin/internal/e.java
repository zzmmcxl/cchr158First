/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.internal.AuthAccountResult;
import com.google.android.gms.signin.internal.SignInResponse;
import com.google.android.gms.signin.internal.d;
import com.google.android.gms.signin.internal.f;

public abstract class e
extends Binder
implements d {
    public e() {
        this.attachInterface((IInterface)this, "com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    public static d a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
        if (iInterface == null) return new f(iBinder);
        if (!(iInterface instanceof d)) return new f(iBinder);
        return (d)iInterface;
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
                parcel2.writeString("com.google.android.gms.signin.internal.ISignInCallbacks");
                return true;
            }
            case 3: {
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                ConnectionResult connectionResult = parcel.readInt() != 0 ? (ConnectionResult)ConnectionResult.CREATOR.createFromParcel(parcel) : null;
                AuthAccountResult authAccountResult = parcel.readInt() != 0 ? (AuthAccountResult)AuthAccountResult.CREATOR.createFromParcel(parcel) : null;
                this.a(connectionResult, authAccountResult);
                parcel2.writeNoException();
                return true;
            }
            case 4: {
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                Status status = parcel.readInt() != 0 ? (Status)Status.CREATOR.createFromParcel(parcel) : null;
                this.a(status);
                parcel2.writeNoException();
                return true;
            }
            case 6: {
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                Status status = parcel.readInt() != 0 ? (Status)Status.CREATOR.createFromParcel(parcel) : null;
                this.b(status);
                parcel2.writeNoException();
                return true;
            }
            case 7: {
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                Status status = parcel.readInt() != 0 ? (Status)Status.CREATOR.createFromParcel(parcel) : null;
                GoogleSignInAccount googleSignInAccount = parcel.readInt() != 0 ? (GoogleSignInAccount)GoogleSignInAccount.CREATOR.createFromParcel(parcel) : null;
                this.a(status, googleSignInAccount);
                parcel2.writeNoException();
                return true;
            }
            case 8: 
        }
        parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
        SignInResponse signInResponse = parcel.readInt() != 0 ? (SignInResponse)SignInResponse.CREATOR.createFromParcel(parcel) : null;
        this.a(signInResponse);
        parcel2.writeNoException();
        return true;
    }
}

