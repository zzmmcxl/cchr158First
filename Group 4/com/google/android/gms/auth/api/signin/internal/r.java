/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.auth.api.signin.internal.m;
import com.google.android.gms.auth.api.signin.internal.p;

class r
implements p {
    private IBinder a;

    r(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public void a(m m2, GoogleSignInOptions googleSignInOptions) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
            IBinder iBinder = m2 != null ? m2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (googleSignInOptions != null) {
                parcel.writeInt(1);
                googleSignInOptions.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(101, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(m m2, SignInConfiguration signInConfiguration) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
            IBinder iBinder = m2 != null ? m2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (signInConfiguration != null) {
                parcel.writeInt(1);
                signInConfiguration.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(1, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(m m2, SignInConfiguration signInConfiguration, SignInAccount signInAccount, String string) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
            IBinder iBinder = m2 != null ? m2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (signInConfiguration != null) {
                parcel.writeInt(1);
                signInConfiguration.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            if (signInAccount != null) {
                parcel.writeInt(1);
                signInAccount.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(string);
            this.a.transact(3, parcel, parcel2, 0);
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
    public void b(m m2, GoogleSignInOptions googleSignInOptions) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
            IBinder iBinder = m2 != null ? m2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (googleSignInOptions != null) {
                parcel.writeInt(1);
                googleSignInOptions.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(102, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void b(m m2, SignInConfiguration signInConfiguration) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
            IBinder iBinder = m2 != null ? m2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (signInConfiguration != null) {
                parcel.writeInt(1);
                signInConfiguration.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(2, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void c(m m2, GoogleSignInOptions googleSignInOptions) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
            IBinder iBinder = m2 != null ? m2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (googleSignInOptions != null) {
                parcel.writeInt(1);
                googleSignInOptions.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(103, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }
}

