/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.b.ej;
import com.google.android.gms.b.el;

public abstract class ek
extends Binder
implements ej {
    public ek() {
        this.attachInterface((IInterface)this, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    public static ej a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        if (iInterface == null) return new el(iBinder);
        if (!(iInterface instanceof ej)) return new el(iBinder);
        return (ej)iInterface;
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
                parcel2.writeString("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                int n4 = parcel.readInt();
                Bundle bundle = null;
                if (n4 != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.a(bundle);
                parcel2.writeNoException();
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                this.f();
                parcel2.writeNoException();
                return true;
            }
            case 3: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                this.g();
                parcel2.writeNoException();
                return true;
            }
            case 4: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                this.h();
                parcel2.writeNoException();
                return true;
            }
            case 5: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                this.i();
                parcel2.writeNoException();
                return true;
            }
            case 6: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                int n5 = parcel.readInt();
                Bundle bundle = null;
                if (n5 != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.b(bundle);
                parcel2.writeNoException();
                if (bundle != null) {
                    parcel2.writeInt(1);
                    bundle.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            }
            case 7: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                this.j();
                parcel2.writeNoException();
                return true;
            }
            case 8: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                this.k();
                parcel2.writeNoException();
                return true;
            }
            case 9: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                this.l();
                parcel2.writeNoException();
                return true;
            }
            case 10: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                this.d();
                parcel2.writeNoException();
                return true;
            }
            case 11: 
        }
        parcel.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        boolean bl2 = this.e();
        parcel2.writeNoException();
        int n6 = bl2 ? 1 : 0;
        parcel2.writeInt(n6);
        return true;
    }
}

