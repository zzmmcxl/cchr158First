/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.internal.AuthAccountResult;
import com.google.android.gms.signin.internal.SignInResponse;
import com.google.android.gms.signin.internal.d;

class f
implements d {
    private IBinder a;

    f(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public void a(ConnectionResult connectionResult, AuthAccountResult authAccountResult) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (connectionResult != null) {
                parcel.writeInt(1);
                connectionResult.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            if (authAccountResult != null) {
                parcel.writeInt(1);
                authAccountResult.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(3, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(Status status) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (status != null) {
                parcel.writeInt(1);
                status.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(4, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(Status status, GoogleSignInAccount googleSignInAccount) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (status != null) {
                parcel.writeInt(1);
                status.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            if (googleSignInAccount != null) {
                parcel.writeInt(1);
                googleSignInAccount.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(7, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(SignInResponse signInResponse) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (signInResponse != null) {
                parcel.writeInt(1);
                signInResponse.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(8, parcel, parcel2, 0);
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

    @Override
    public void b(Status status) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (status != null) {
                parcel.writeInt(1);
                status.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(6, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }
}

