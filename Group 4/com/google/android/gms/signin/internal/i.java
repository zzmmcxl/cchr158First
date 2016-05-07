/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.az;
import com.google.android.gms.signin.internal.CheckServerAuthResult;
import com.google.android.gms.signin.internal.RecordConsentRequest;
import com.google.android.gms.signin.internal.SignInRequest;
import com.google.android.gms.signin.internal.d;
import com.google.android.gms.signin.internal.g;

class i
implements g {
    private IBinder a;

    i(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public void a(int n2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            parcel.writeInt(n2);
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
    public void a(int n2, Account account, d d2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            parcel.writeInt(n2);
            if (account != null) {
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = d2 != null ? d2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            this.a.transact(8, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(AuthAccountRequest authAccountRequest, d d2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (authAccountRequest != null) {
                parcel.writeInt(1);
                authAccountRequest.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = d2 != null ? d2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
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
    public void a(ResolveAccountRequest resolveAccountRequest, az az2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (resolveAccountRequest != null) {
                parcel.writeInt(1);
                resolveAccountRequest.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = az2 != null ? az2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            this.a.transact(5, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(ap ap2, int n2, boolean bl2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            IBinder iBinder = ap2 != null ? ap2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            int n3 = 0;
            if (bl2) {
                n3 = 1;
            }
            parcel.writeInt(n3);
            this.a.transact(9, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(CheckServerAuthResult checkServerAuthResult) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (checkServerAuthResult != null) {
                parcel.writeInt(1);
                checkServerAuthResult.writeToParcel(parcel, 0);
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
    public void a(RecordConsentRequest recordConsentRequest, d d2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (recordConsentRequest != null) {
                parcel.writeInt(1);
                recordConsentRequest.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = d2 != null ? d2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            this.a.transact(10, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(SignInRequest signInRequest, d d2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (signInRequest != null) {
                parcel.writeInt(1);
                signInRequest.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = d2 != null ? d2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            this.a.transact(12, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(d d2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            IBinder iBinder = d2 != null ? d2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            this.a.transact(11, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(boolean bl2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            int n2 = 0;
            if (bl2) {
                n2 = 1;
            }
            parcel.writeInt(n2);
            this.a.transact(4, parcel, parcel2, 0);
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
}

