/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.credentials.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.internal.DeleteRequest;
import com.google.android.gms.auth.api.credentials.internal.GeneratePasswordRequest;
import com.google.android.gms.auth.api.credentials.internal.SaveRequest;
import com.google.android.gms.auth.api.credentials.internal.e;
import com.google.android.gms.auth.api.credentials.internal.h;

class j
implements h {
    private IBinder a;

    j(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public void a(e e2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            IBinder iBinder = e2 != null ? e2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
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
    public void a(e e2, CredentialRequest credentialRequest) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            IBinder iBinder = e2 != null ? e2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (credentialRequest != null) {
                parcel.writeInt(1);
                credentialRequest.writeToParcel(parcel, 0);
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
    public void a(e e2, DeleteRequest deleteRequest) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            IBinder iBinder = e2 != null ? e2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (deleteRequest != null) {
                parcel.writeInt(1);
                deleteRequest.writeToParcel(parcel, 0);
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
    public void a(e e2, GeneratePasswordRequest generatePasswordRequest) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            IBinder iBinder = e2 != null ? e2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (generatePasswordRequest != null) {
                parcel.writeInt(1);
                generatePasswordRequest.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
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
    public void a(e e2, SaveRequest saveRequest) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            IBinder iBinder = e2 != null ? e2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (saveRequest != null) {
                parcel.writeInt(1);
                saveRequest.writeToParcel(parcel, 0);
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

    public IBinder asBinder() {
        return this.a;
    }
}

