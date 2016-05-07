/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.consent.GetConsentIntentRequest;
import com.google.android.gms.b.im;
import com.google.android.gms.b.io;

public abstract class in
extends Binder
implements im {
    public static im a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.consent.internal.IConsentService");
        if (iInterface == null) return new io(iBinder);
        if (!(iInterface instanceof im)) return new io(iBinder);
        return (im)iInterface;
    }

    public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) {
        switch (n2) {
            default: {
                return super.onTransact(n2, parcel, parcel2, n3);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.auth.api.consent.internal.IConsentService");
                return true;
            }
            case 1: 
        }
        parcel.enforceInterface("com.google.android.gms.auth.api.consent.internal.IConsentService");
        GetConsentIntentRequest getConsentIntentRequest = parcel.readInt() != 0 ? (GetConsentIntentRequest)GetConsentIntentRequest.CREATOR.createFromParcel(parcel) : null;
        Intent intent = this.a(getConsentIntentRequest);
        parcel2.writeNoException();
        if (intent != null) {
            parcel2.writeInt(1);
            intent.writeToParcel(parcel2, 1);
            return true;
        }
        parcel2.writeInt(0);
        return true;
    }
}

