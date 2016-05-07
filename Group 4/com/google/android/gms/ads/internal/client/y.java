/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.x;

public abstract class y
extends Binder
implements x {
    public y() {
        this.attachInterface((IInterface)this, "com.google.android.gms.ads.internal.client.IAppEventListener");
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
                parcel2.writeString("com.google.android.gms.ads.internal.client.IAppEventListener");
                return true;
            }
            case 1: 
        }
        parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
        this.a(parcel.readString(), parcel.readString());
        parcel2.writeNoException();
        return true;
    }
}

