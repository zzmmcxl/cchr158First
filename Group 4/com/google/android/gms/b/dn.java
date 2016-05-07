/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.a.a;
import com.google.android.gms.a.b;
import com.google.android.gms.b.bh;
import com.google.android.gms.b.dm;
import com.google.android.gms.b.do;
import java.util.List;

public abstract class dn
extends Binder
implements dm {
    public static dm a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
        if (iInterface == null) return new do(iBinder);
        if (!(iInterface instanceof dm)) return new do(iBinder);
        return (dm)iInterface;
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
                parcel2.writeString("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                String string = this.a();
                parcel2.writeNoException();
                parcel2.writeString(string);
                return true;
            }
            case 3: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                List list = this.b();
                parcel2.writeNoException();
                parcel2.writeList(list);
                return true;
            }
            case 4: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                String string = this.c();
                parcel2.writeNoException();
                parcel2.writeString(string);
                return true;
            }
            case 5: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                bh bh2 = this.d();
                parcel2.writeNoException();
                IBinder iBinder = bh2 != null ? bh2.asBinder() : null;
                parcel2.writeStrongBinder(iBinder);
                return true;
            }
            case 6: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                String string = this.e();
                parcel2.writeNoException();
                parcel2.writeString(string);
                return true;
            }
            case 7: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                double d2 = this.f();
                parcel2.writeNoException();
                parcel2.writeDouble(d2);
                return true;
            }
            case 8: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                String string = this.g();
                parcel2.writeNoException();
                parcel2.writeString(string);
                return true;
            }
            case 9: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                String string = this.h();
                parcel2.writeNoException();
                parcel2.writeString(string);
                return true;
            }
            case 10: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                this.i();
                parcel2.writeNoException();
                return true;
            }
            case 11: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                this.a(b.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 12: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                this.b(b.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 13: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                boolean bl2 = this.j();
                parcel2.writeNoException();
                int n4 = 0;
                if (bl2) {
                    n4 = 1;
                }
                parcel2.writeInt(n4);
                return true;
            }
            case 14: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                boolean bl3 = this.k();
                parcel2.writeNoException();
                int n5 = 0;
                if (bl3) {
                    n5 = 1;
                }
                parcel2.writeInt(n5);
                return true;
            }
            case 15: 
        }
        parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
        Bundle bundle = this.l();
        parcel2.writeNoException();
        if (bundle != null) {
            parcel2.writeInt(1);
            bundle.writeToParcel(parcel2, 1);
            return true;
        }
        parcel2.writeInt(0);
        return true;
    }
}

