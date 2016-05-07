/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.credentials.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.internal.DeleteRequest;
import com.google.android.gms.auth.api.credentials.internal.GeneratePasswordRequest;
import com.google.android.gms.auth.api.credentials.internal.SaveRequest;
import com.google.android.gms.auth.api.credentials.internal.e;
import com.google.android.gms.auth.api.credentials.internal.f;
import com.google.android.gms.auth.api.credentials.internal.h;
import com.google.android.gms.auth.api.credentials.internal.j;

public abstract class i
extends Binder
implements h {
    public static h a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        if (iInterface == null) return new j(iBinder);
        if (!(iInterface instanceof h)) return new j(iBinder);
        return (h)iInterface;
    }

    public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) {
        switch (n2) {
            default: {
                return super.onTransact(n2, parcel, parcel2, n3);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                e e2 = f.a(parcel.readStrongBinder());
                int n4 = parcel.readInt();
                CredentialRequest credentialRequest = null;
                if (n4 != 0) {
                    credentialRequest = (CredentialRequest)CredentialRequest.CREATOR.createFromParcel(parcel);
                }
                this.a(e2, credentialRequest);
                parcel2.writeNoException();
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                e e3 = f.a(parcel.readStrongBinder());
                int n5 = parcel.readInt();
                SaveRequest saveRequest = null;
                if (n5 != 0) {
                    saveRequest = (SaveRequest)SaveRequest.CREATOR.createFromParcel(parcel);
                }
                this.a(e3, saveRequest);
                parcel2.writeNoException();
                return true;
            }
            case 3: {
                parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                e e4 = f.a(parcel.readStrongBinder());
                int n6 = parcel.readInt();
                DeleteRequest deleteRequest = null;
                if (n6 != 0) {
                    deleteRequest = (DeleteRequest)DeleteRequest.CREATOR.createFromParcel(parcel);
                }
                this.a(e4, deleteRequest);
                parcel2.writeNoException();
                return true;
            }
            case 4: {
                parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                this.a(f.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 5: 
        }
        parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        e e5 = f.a(parcel.readStrongBinder());
        int n7 = parcel.readInt();
        GeneratePasswordRequest generatePasswordRequest = null;
        if (n7 != 0) {
            generatePasswordRequest = (GeneratePasswordRequest)GeneratePasswordRequest.CREATOR.createFromParcel(parcel);
        }
        this.a(e5, generatePasswordRequest);
        parcel2.writeNoException();
        return true;
    }
}

