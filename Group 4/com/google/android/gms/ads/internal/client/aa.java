/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.z;

public abstract class aa
extends Binder
implements z {
    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) {
        switch (n2) {
            default: {
                return super.onTransact(n2, parcel, parcel2, n3);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                return true;
            }
            case 1: 
        }
        parcel.enforceInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
        long l2 = this.a();
        parcel2.writeNoException();
        parcel2.writeLong(l2);
        return true;
    }
}

