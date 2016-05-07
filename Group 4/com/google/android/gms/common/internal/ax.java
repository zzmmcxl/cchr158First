/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.ValidateAccountRequest;
import com.google.android.gms.common.internal.at;
import com.google.android.gms.common.internal.au;
import com.google.android.gms.common.internal.aw;
import com.google.android.gms.common.internal.ay;

public abstract class ax
extends Binder
implements aw {
    public static aw a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        if (iInterface == null) return new ay(iBinder);
        if (!(iInterface instanceof aw)) return new ay(iBinder);
        return (aw)iInterface;
    }

    public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) {
        switch (n2) {
            default: {
                return super.onTransact(n2, parcel, parcel2, n3);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.common.internal.IGmsServiceBroker");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                at at2 = au.a(parcel.readStrongBinder());
                int n4 = parcel.readInt();
                String string = parcel.readString();
                String string2 = parcel.readString();
                String[] arrstring = parcel.createStringArray();
                String string3 = parcel.readString();
                Bundle bundle = parcel.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(parcel) : null;
                this.a(at2, n4, string, string2, arrstring, string3, bundle);
                parcel2.writeNoException();
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                at at3 = au.a(parcel.readStrongBinder());
                int n5 = parcel.readInt();
                String string = parcel.readString();
                int n6 = parcel.readInt();
                Bundle bundle = null;
                if (n6 != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.a(at3, n5, string, bundle);
                parcel2.writeNoException();
                return true;
            }
            case 3: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                this.a(au.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 4: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                this.a(au.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            case 5: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                at at4 = au.a(parcel.readStrongBinder());
                int n7 = parcel.readInt();
                String string = parcel.readString();
                int n8 = parcel.readInt();
                Bundle bundle = null;
                if (n8 != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.b(at4, n7, string, bundle);
                parcel2.writeNoException();
                return true;
            }
            case 6: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                at at5 = au.a(parcel.readStrongBinder());
                int n9 = parcel.readInt();
                String string = parcel.readString();
                int n10 = parcel.readInt();
                Bundle bundle = null;
                if (n10 != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.c(at5, n9, string, bundle);
                parcel2.writeNoException();
                return true;
            }
            case 7: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                at at6 = au.a(parcel.readStrongBinder());
                int n11 = parcel.readInt();
                String string = parcel.readString();
                int n12 = parcel.readInt();
                Bundle bundle = null;
                if (n12 != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.d(at6, n11, string, bundle);
                parcel2.writeNoException();
                return true;
            }
            case 8: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                at at7 = au.a(parcel.readStrongBinder());
                int n13 = parcel.readInt();
                String string = parcel.readString();
                int n14 = parcel.readInt();
                Bundle bundle = null;
                if (n14 != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.e(at7, n13, string, bundle);
                parcel2.writeNoException();
                return true;
            }
            case 9: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                at at8 = au.a(parcel.readStrongBinder());
                int n15 = parcel.readInt();
                String string = parcel.readString();
                String string4 = parcel.readString();
                String[] arrstring = parcel.createStringArray();
                String string5 = parcel.readString();
                IBinder iBinder = parcel.readStrongBinder();
                String string6 = parcel.readString();
                Bundle bundle = parcel.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(parcel) : null;
                this.a(at8, n15, string, string4, arrstring, string5, iBinder, string6, bundle);
                parcel2.writeNoException();
                return true;
            }
            case 10: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                this.a(au.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray());
                parcel2.writeNoException();
                return true;
            }
            case 11: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                at at9 = au.a(parcel.readStrongBinder());
                int n16 = parcel.readInt();
                String string = parcel.readString();
                int n17 = parcel.readInt();
                Bundle bundle = null;
                if (n17 != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.f(at9, n16, string, bundle);
                parcel2.writeNoException();
                return true;
            }
            case 12: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                at at10 = au.a(parcel.readStrongBinder());
                int n18 = parcel.readInt();
                String string = parcel.readString();
                int n19 = parcel.readInt();
                Bundle bundle = null;
                if (n19 != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.g(at10, n18, string, bundle);
                parcel2.writeNoException();
                return true;
            }
            case 13: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                at at11 = au.a(parcel.readStrongBinder());
                int n20 = parcel.readInt();
                String string = parcel.readString();
                int n21 = parcel.readInt();
                Bundle bundle = null;
                if (n21 != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.h(at11, n20, string, bundle);
                parcel2.writeNoException();
                return true;
            }
            case 14: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                at at12 = au.a(parcel.readStrongBinder());
                int n22 = parcel.readInt();
                String string = parcel.readString();
                int n23 = parcel.readInt();
                Bundle bundle = null;
                if (n23 != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.i(at12, n22, string, bundle);
                parcel2.writeNoException();
                return true;
            }
            case 15: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                at at13 = au.a(parcel.readStrongBinder());
                int n24 = parcel.readInt();
                String string = parcel.readString();
                int n25 = parcel.readInt();
                Bundle bundle = null;
                if (n25 != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.j(at13, n24, string, bundle);
                parcel2.writeNoException();
                return true;
            }
            case 16: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                at at14 = au.a(parcel.readStrongBinder());
                int n26 = parcel.readInt();
                String string = parcel.readString();
                int n27 = parcel.readInt();
                Bundle bundle = null;
                if (n27 != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.k(at14, n26, string, bundle);
                parcel2.writeNoException();
                return true;
            }
            case 17: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                at at15 = au.a(parcel.readStrongBinder());
                int n28 = parcel.readInt();
                String string = parcel.readString();
                int n29 = parcel.readInt();
                Bundle bundle = null;
                if (n29 != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.l(at15, n28, string, bundle);
                parcel2.writeNoException();
                return true;
            }
            case 18: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                at at16 = au.a(parcel.readStrongBinder());
                int n30 = parcel.readInt();
                String string = parcel.readString();
                int n31 = parcel.readInt();
                Bundle bundle = null;
                if (n31 != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.m(at16, n30, string, bundle);
                parcel2.writeNoException();
                return true;
            }
            case 19: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                at at17 = au.a(parcel.readStrongBinder());
                int n32 = parcel.readInt();
                String string = parcel.readString();
                IBinder iBinder = parcel.readStrongBinder();
                Bundle bundle = parcel.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(parcel) : null;
                this.a(at17, n32, string, iBinder, bundle);
                parcel2.writeNoException();
                return true;
            }
            case 20: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                at at18 = au.a(parcel.readStrongBinder());
                int n33 = parcel.readInt();
                String string = parcel.readString();
                String[] arrstring = parcel.createStringArray();
                String string7 = parcel.readString();
                Bundle bundle = parcel.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(parcel) : null;
                this.a(at18, n33, string, arrstring, string7, bundle);
                parcel2.writeNoException();
                return true;
            }
            case 21: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                this.b(au.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 22: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                this.c(au.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 23: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                at at19 = au.a(parcel.readStrongBinder());
                int n34 = parcel.readInt();
                String string = parcel.readString();
                int n35 = parcel.readInt();
                Bundle bundle = null;
                if (n35 != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.n(at19, n34, string, bundle);
                parcel2.writeNoException();
                return true;
            }
            case 24: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                this.d(au.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 25: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                at at20 = au.a(parcel.readStrongBinder());
                int n36 = parcel.readInt();
                String string = parcel.readString();
                int n37 = parcel.readInt();
                Bundle bundle = null;
                if (n37 != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.o(at20, n36, string, bundle);
                parcel2.writeNoException();
                return true;
            }
            case 26: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                this.e(au.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 27: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                at at21 = au.a(parcel.readStrongBinder());
                int n38 = parcel.readInt();
                String string = parcel.readString();
                int n39 = parcel.readInt();
                Bundle bundle = null;
                if (n39 != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.p(at21, n38, string, bundle);
                parcel2.writeNoException();
                return true;
            }
            case 28: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                this.a();
                parcel2.writeNoException();
                return true;
            }
            case 30: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                at at22 = au.a(parcel.readStrongBinder());
                int n40 = parcel.readInt();
                String string = parcel.readString();
                String string8 = parcel.readString();
                String[] arrstring = parcel.createStringArray();
                Bundle bundle = parcel.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(parcel) : null;
                this.a(at22, n40, string, string8, arrstring, bundle);
                parcel2.writeNoException();
                return true;
            }
            case 31: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                this.f(au.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 32: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                this.g(au.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 33: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                this.a(au.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArray());
                parcel2.writeNoException();
                return true;
            }
            case 34: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                this.a(au.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 35: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                this.h(au.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 36: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                this.i(au.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 37: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                at at23 = au.a(parcel.readStrongBinder());
                int n41 = parcel.readInt();
                String string = parcel.readString();
                int n42 = parcel.readInt();
                Bundle bundle = null;
                if (n42 != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.q(at23, n41, string, bundle);
                parcel2.writeNoException();
                return true;
            }
            case 38: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                at at24 = au.a(parcel.readStrongBinder());
                int n43 = parcel.readInt();
                String string = parcel.readString();
                int n44 = parcel.readInt();
                Bundle bundle = null;
                if (n44 != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.r(at24, n43, string, bundle);
                parcel2.writeNoException();
                return true;
            }
            case 40: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                this.j(au.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 41: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                at at25 = au.a(parcel.readStrongBinder());
                int n45 = parcel.readInt();
                String string = parcel.readString();
                int n46 = parcel.readInt();
                Bundle bundle = null;
                if (n46 != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.s(at25, n45, string, bundle);
                parcel2.writeNoException();
                return true;
            }
            case 42: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                this.k(au.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 43: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                at at26 = au.a(parcel.readStrongBinder());
                int n47 = parcel.readInt();
                String string = parcel.readString();
                int n48 = parcel.readInt();
                Bundle bundle = null;
                if (n48 != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.t(at26, n47, string, bundle);
                parcel2.writeNoException();
                return true;
            }
            case 44: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                this.l(au.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 45: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                this.m(au.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 46: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                at at27 = au.a(parcel.readStrongBinder());
                int n49 = parcel.readInt();
                GetServiceRequest getServiceRequest = null;
                if (n49 != 0) {
                    getServiceRequest = (GetServiceRequest)GetServiceRequest.CREATOR.createFromParcel(parcel);
                }
                this.a(at27, getServiceRequest);
                parcel2.writeNoException();
                return true;
            }
            case 47: 
        }
        parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        at at28 = au.a(parcel.readStrongBinder());
        int n50 = parcel.readInt();
        ValidateAccountRequest validateAccountRequest = null;
        if (n50 != 0) {
            validateAccountRequest = (ValidateAccountRequest)ValidateAccountRequest.CREATOR.createFromParcel(parcel);
        }
        this.a(at28, validateAccountRequest);
        parcel2.writeNoException();
        return true;
    }
}

