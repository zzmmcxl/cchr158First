/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.i;
import com.google.android.gms.ads.internal.client.j;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.a;
import com.google.android.gms.ads.internal.reward.mediation.client.b;
import com.google.android.gms.b.dc;
import com.google.android.gms.b.de;
import com.google.android.gms.b.df;
import com.google.android.gms.b.dg;
import com.google.android.gms.b.dm;
import com.google.android.gms.b.dp;
import java.util.ArrayList;
import java.util.List;

public abstract class dd
extends Binder
implements dc {
    public static dc a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        if (iInterface == null) return new de(iBinder);
        if (!(iInterface instanceof dc)) return new de(iBinder);
        return (dc)iInterface;
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
                parcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                com.google.android.gms.a.a a2 = com.google.android.gms.a.b.a(parcel.readStrongBinder());
                AdSizeParcel adSizeParcel = parcel.readInt() != 0 ? AdSizeParcel.CREATOR.a(parcel) : null;
                AdRequestParcel adRequestParcel = parcel.readInt() != 0 ? AdRequestParcel.CREATOR.a(parcel) : null;
                this.a(a2, adSizeParcel, adRequestParcel, parcel.readString(), dg.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                com.google.android.gms.a.a a3 = this.a();
                parcel2.writeNoException();
                IBinder iBinder = null;
                if (a3 != null) {
                    iBinder = a3.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            }
            case 3: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                com.google.android.gms.a.a a4 = com.google.android.gms.a.b.a(parcel.readStrongBinder());
                int n4 = parcel.readInt();
                AdRequestParcel adRequestParcel = null;
                if (n4 != 0) {
                    adRequestParcel = AdRequestParcel.CREATOR.a(parcel);
                }
                this.a(a4, adRequestParcel, parcel.readString(), dg.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 4: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                this.b();
                parcel2.writeNoException();
                return true;
            }
            case 5: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                this.c();
                parcel2.writeNoException();
                return true;
            }
            case 6: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                com.google.android.gms.a.a a5 = com.google.android.gms.a.b.a(parcel.readStrongBinder());
                AdSizeParcel adSizeParcel = parcel.readInt() != 0 ? AdSizeParcel.CREATOR.a(parcel) : null;
                AdRequestParcel adRequestParcel = parcel.readInt() != 0 ? AdRequestParcel.CREATOR.a(parcel) : null;
                this.a(a5, adSizeParcel, adRequestParcel, parcel.readString(), parcel.readString(), dg.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 7: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                com.google.android.gms.a.a a6 = com.google.android.gms.a.b.a(parcel.readStrongBinder());
                AdRequestParcel adRequestParcel = parcel.readInt() != 0 ? AdRequestParcel.CREATOR.a(parcel) : null;
                this.a(a6, adRequestParcel, parcel.readString(), parcel.readString(), dg.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 8: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                this.d();
                parcel2.writeNoException();
                return true;
            }
            case 9: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                this.e();
                parcel2.writeNoException();
                return true;
            }
            case 10: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                com.google.android.gms.a.a a7 = com.google.android.gms.a.b.a(parcel.readStrongBinder());
                AdRequestParcel adRequestParcel = parcel.readInt() != 0 ? AdRequestParcel.CREATOR.a(parcel) : null;
                this.a(a7, adRequestParcel, parcel.readString(), b.a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 11: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                int n5 = parcel.readInt();
                AdRequestParcel adRequestParcel = null;
                if (n5 != 0) {
                    adRequestParcel = AdRequestParcel.CREATOR.a(parcel);
                }
                this.a(adRequestParcel, parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 12: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                this.f();
                parcel2.writeNoException();
                return true;
            }
            case 13: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                boolean bl2 = this.g();
                parcel2.writeNoException();
                int n6 = bl2 ? 1 : 0;
                parcel2.writeInt(n6);
                return true;
            }
            case 14: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                com.google.android.gms.a.a a8 = com.google.android.gms.a.b.a(parcel.readStrongBinder());
                AdRequestParcel adRequestParcel = parcel.readInt() != 0 ? AdRequestParcel.CREATOR.a(parcel) : null;
                String string = parcel.readString();
                String string2 = parcel.readString();
                df df2 = dg.a(parcel.readStrongBinder());
                NativeAdOptionsParcel nativeAdOptionsParcel = parcel.readInt() != 0 ? NativeAdOptionsParcel.CREATOR.a(parcel) : null;
                this.a(a8, adRequestParcel, string, string2, df2, nativeAdOptionsParcel, (List)parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            }
            case 15: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                dm dm2 = this.h();
                parcel2.writeNoException();
                IBinder iBinder = null;
                if (dm2 != null) {
                    iBinder = dm2.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            }
            case 16: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                dp dp2 = this.i();
                parcel2.writeNoException();
                IBinder iBinder = null;
                if (dp2 != null) {
                    iBinder = dp2.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            }
            case 17: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                Bundle bundle = this.j();
                parcel2.writeNoException();
                if (bundle != null) {
                    parcel2.writeInt(1);
                    bundle.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            }
            case 18: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                Bundle bundle = this.k();
                parcel2.writeNoException();
                if (bundle != null) {
                    parcel2.writeInt(1);
                    bundle.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            }
            case 19: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
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
            case 20: 
        }
        parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        int n7 = parcel.readInt();
        AdRequestParcel adRequestParcel = null;
        if (n7 != 0) {
            adRequestParcel = AdRequestParcel.CREATOR.a(parcel);
        }
        this.a(adRequestParcel, parcel.readString(), parcel.readString());
        parcel2.writeNoException();
        return true;
    }
}

