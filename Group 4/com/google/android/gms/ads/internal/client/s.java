/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.r;

public abstract class s
extends Binder
implements r {
    public s() {
        this.attachInterface((IInterface)this, "com.google.android.gms.ads.internal.client.IAdListener");
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
                parcel2.writeString("com.google.android.gms.ads.internal.client.IAdListener");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdListener");
                this.a();
                parcel2.writeNoException();
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdListener");
                this.a(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            case 3: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdListener");
                this.b();
                parcel2.writeNoException();
                return true;
            }
            case 4: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdListener");
                this.c();
                parcel2.writeNoException();
                return true;
            }
            case 5: 
        }
        parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdListener");
        this.d();
        parcel2.writeNoException();
        return true;
    }
}

