/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.aq;
import com.google.android.gms.common.internal.az;
import com.google.android.gms.common.internal.ba;
import com.google.android.gms.signin.internal.CheckServerAuthResult;
import com.google.android.gms.signin.internal.RecordConsentRequest;
import com.google.android.gms.signin.internal.SignInRequest;
import com.google.android.gms.signin.internal.d;
import com.google.android.gms.signin.internal.e;
import com.google.android.gms.signin.internal.g;
import com.google.android.gms.signin.internal.i;

public abstract class h
extends Binder
implements g {
    public static g a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (iInterface == null) return new i(iBinder);
        if (!(iInterface instanceof g)) return new i(iBinder);
        return (g)iInterface;
    }

    public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) {
        switch (n2) {
            default: {
                return super.onTransact(n2, parcel, parcel2, n3);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.signin.internal.ISignInService");
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                int n4 = parcel.readInt();
                AuthAccountRequest authAccountRequest = null;
                if (n4 != 0) {
                    authAccountRequest = (AuthAccountRequest)AuthAccountRequest.CREATOR.createFromParcel(parcel);
                }
                this.a(authAccountRequest, e.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 3: {
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                int n5 = parcel.readInt();
                CheckServerAuthResult checkServerAuthResult = null;
                if (n5 != 0) {
                    checkServerAuthResult = (CheckServerAuthResult)CheckServerAuthResult.CREATOR.createFromParcel(parcel);
                }
                this.a(checkServerAuthResult);
                parcel2.writeNoException();
                return true;
            }
            case 4: {
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                boolean bl2 = parcel.readInt() != 0;
                this.a(bl2);
                parcel2.writeNoException();
                return true;
            }
            case 5: {
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                int n6 = parcel.readInt();
                ResolveAccountRequest resolveAccountRequest = null;
                if (n6 != 0) {
                    resolveAccountRequest = (ResolveAccountRequest)ResolveAccountRequest.CREATOR.createFromParcel(parcel);
                }
                this.a(resolveAccountRequest, ba.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 7: {
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                this.a(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            case 8: {
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                int n7 = parcel.readInt();
                int n8 = parcel.readInt();
                Account account = null;
                if (n8 != 0) {
                    account = (Account)Account.CREATOR.createFromParcel(parcel);
                }
                this.a(n7, account, e.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 9: {
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                ap ap2 = aq.a(parcel.readStrongBinder());
                int n9 = parcel.readInt();
                int n10 = parcel.readInt();
                boolean bl3 = false;
                if (n10 != 0) {
                    bl3 = true;
                }
                this.a(ap2, n9, bl3);
                parcel2.writeNoException();
                return true;
            }
            case 10: {
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                int n11 = parcel.readInt();
                RecordConsentRequest recordConsentRequest = null;
                if (n11 != 0) {
                    recordConsentRequest = (RecordConsentRequest)RecordConsentRequest.CREATOR.createFromParcel(parcel);
                }
                this.a(recordConsentRequest, e.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 11: {
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                this.a(e.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 12: 
        }
        parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
        int n12 = parcel.readInt();
        SignInRequest signInRequest = null;
        if (n12 != 0) {
            signInRequest = (SignInRequest)SignInRequest.CREATOR.createFromParcel(parcel);
        }
        this.a(signInRequest, e.a(parcel.readStrongBinder()));
        parcel2.writeNoException();
        return true;
    }
}

