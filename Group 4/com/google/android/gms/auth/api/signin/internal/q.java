/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.auth.api.signin.internal.m;
import com.google.android.gms.auth.api.signin.internal.n;
import com.google.android.gms.auth.api.signin.internal.p;
import com.google.android.gms.auth.api.signin.internal.r;

public abstract class q
extends Binder
implements p {
    public static p a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        if (iInterface == null) return new r(iBinder);
        if (!(iInterface instanceof p)) return new r(iBinder);
        return (p)iInterface;
    }

    public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) {
        switch (n2) {
            default: {
                return super.onTransact(n2, parcel, parcel2, n3);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.auth.api.signin.internal.ISignInService");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                m m2 = n.a(parcel.readStrongBinder());
                SignInConfiguration signInConfiguration = parcel.readInt() != 0 ? (SignInConfiguration)SignInConfiguration.CREATOR.createFromParcel(parcel) : null;
                this.a(m2, signInConfiguration);
                parcel2.writeNoException();
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                m m3 = n.a(parcel.readStrongBinder());
                SignInConfiguration signInConfiguration = parcel.readInt() != 0 ? (SignInConfiguration)SignInConfiguration.CREATOR.createFromParcel(parcel) : null;
                this.b(m3, signInConfiguration);
                parcel2.writeNoException();
                return true;
            }
            case 3: {
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                m m4 = n.a(parcel.readStrongBinder());
                SignInConfiguration signInConfiguration = parcel.readInt() != 0 ? (SignInConfiguration)SignInConfiguration.CREATOR.createFromParcel(parcel) : null;
                SignInAccount signInAccount = parcel.readInt() != 0 ? (SignInAccount)SignInAccount.CREATOR.createFromParcel(parcel) : null;
                this.a(m4, signInConfiguration, signInAccount, parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 101: {
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                m m5 = n.a(parcel.readStrongBinder());
                GoogleSignInOptions googleSignInOptions = parcel.readInt() != 0 ? (GoogleSignInOptions)GoogleSignInOptions.CREATOR.createFromParcel(parcel) : null;
                this.a(m5, googleSignInOptions);
                parcel2.writeNoException();
                return true;
            }
            case 102: {
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                m m6 = n.a(parcel.readStrongBinder());
                GoogleSignInOptions googleSignInOptions = parcel.readInt() != 0 ? (GoogleSignInOptions)GoogleSignInOptions.CREATOR.createFromParcel(parcel) : null;
                this.b(m6, googleSignInOptions);
                parcel2.writeNoException();
                return true;
            }
            case 103: 
        }
        parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        m m7 = n.a(parcel.readStrongBinder());
        GoogleSignInOptions googleSignInOptions = parcel.readInt() != 0 ? (GoogleSignInOptions)GoogleSignInOptions.CREATOR.createFromParcel(parcel) : null;
        this.c(m7, googleSignInOptions);
        parcel2.writeNoException();
        return true;
    }
}

