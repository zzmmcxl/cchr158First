/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.internal.k;

public abstract class l
extends Binder
implements k {
    public l() {
        this.attachInterface((IInterface)this, "com.google.android.gms.auth.api.signin.internal.IRevocationService");
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
                parcel2.writeString("com.google.android.gms.auth.api.signin.internal.IRevocationService");
                return true;
            }
            case 1: 
        }
        parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.IRevocationService");
        this.a();
        return true;
    }
}

