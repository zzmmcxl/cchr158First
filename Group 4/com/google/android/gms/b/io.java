/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.consent.GetConsentIntentRequest;
import com.google.android.gms.b.im;

class io
implements im {
    private IBinder a;

    io(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public Intent a(GetConsentIntentRequest getConsentIntentRequest) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.auth.api.consent.internal.IConsentService");
            if (getConsentIntentRequest != null) {
                parcel.writeInt(1);
                getConsentIntentRequest.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(1, parcel, parcel2, 0);
            parcel2.readException();
            Intent intent = parcel2.readInt() != 0 ? (Intent)Intent.CREATOR.createFromParcel(parcel2) : null;
            return intent;
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

