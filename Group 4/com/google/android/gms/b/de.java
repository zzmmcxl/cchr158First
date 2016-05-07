/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.a.b;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.a;
import com.google.android.gms.b.dc;
import com.google.android.gms.b.df;
import com.google.android.gms.b.dm;
import com.google.android.gms.b.dn;
import com.google.android.gms.b.dp;
import com.google.android.gms.b.dq;
import java.util.List;

class de
implements dc {
    private IBinder a;

    de(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public com.google.android.gms.a.a a() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.a.transact(2, parcel, parcel2, 0);
            parcel2.readException();
            com.google.android.gms.a.a a2 = b.a(parcel2.readStrongBinder());
            return a2;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(com.google.android.gms.a.a a2, AdRequestParcel adRequestParcel, String string, a a3, String string2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            IBinder iBinder = a2 != null ? a2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (adRequestParcel != null) {
                parcel.writeInt(1);
                adRequestParcel.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(string);
            IBinder iBinder2 = null;
            if (a3 != null) {
                iBinder2 = a3.asBinder();
            }
            parcel.writeStrongBinder(iBinder2);
            parcel.writeString(string2);
            this.a.transact(10, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(com.google.android.gms.a.a a2, AdRequestParcel adRequestParcel, String string, df df2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            IBinder iBinder = a2 != null ? a2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (adRequestParcel != null) {
                parcel.writeInt(1);
                adRequestParcel.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(string);
            IBinder iBinder2 = null;
            if (df2 != null) {
                iBinder2 = df2.asBinder();
            }
            parcel.writeStrongBinder(iBinder2);
            this.a.transact(3, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(com.google.android.gms.a.a a2, AdRequestParcel adRequestParcel, String string, String string2, df df2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            IBinder iBinder = a2 != null ? a2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (adRequestParcel != null) {
                parcel.writeInt(1);
                adRequestParcel.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(string);
            parcel.writeString(string2);
            IBinder iBinder2 = null;
            if (df2 != null) {
                iBinder2 = df2.asBinder();
            }
            parcel.writeStrongBinder(iBinder2);
            this.a.transact(7, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(com.google.android.gms.a.a a2, AdRequestParcel adRequestParcel, String string, String string2, df df2, NativeAdOptionsParcel nativeAdOptionsParcel, List list) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            IBinder iBinder = a2 != null ? a2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (adRequestParcel != null) {
                parcel.writeInt(1);
                adRequestParcel.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(string);
            parcel.writeString(string2);
            IBinder iBinder2 = null;
            if (df2 != null) {
                iBinder2 = df2.asBinder();
            }
            parcel.writeStrongBinder(iBinder2);
            if (nativeAdOptionsParcel != null) {
                parcel.writeInt(1);
                nativeAdOptionsParcel.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeStringList(list);
            this.a.transact(14, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(com.google.android.gms.a.a a2, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String string, df df2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            IBinder iBinder = a2 != null ? a2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (adSizeParcel != null) {
                parcel.writeInt(1);
                adSizeParcel.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            if (adRequestParcel != null) {
                parcel.writeInt(1);
                adRequestParcel.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(string);
            IBinder iBinder2 = null;
            if (df2 != null) {
                iBinder2 = df2.asBinder();
            }
            parcel.writeStrongBinder(iBinder2);
            this.a.transact(1, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(com.google.android.gms.a.a a2, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String string, String string2, df df2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            IBinder iBinder = a2 != null ? a2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (adSizeParcel != null) {
                parcel.writeInt(1);
                adSizeParcel.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            if (adRequestParcel != null) {
                parcel.writeInt(1);
                adRequestParcel.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(string);
            parcel.writeString(string2);
            IBinder iBinder2 = null;
            if (df2 != null) {
                iBinder2 = df2.asBinder();
            }
            parcel.writeStrongBinder(iBinder2);
            this.a.transact(6, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(AdRequestParcel adRequestParcel, String string) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            if (adRequestParcel != null) {
                parcel.writeInt(1);
                adRequestParcel.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(string);
            this.a.transact(11, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(AdRequestParcel adRequestParcel, String string, String string2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            if (adRequestParcel != null) {
                parcel.writeInt(1);
                adRequestParcel.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(string);
            parcel.writeString(string2);
            this.a.transact(20, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }

    @Override
    public void b() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.a.transact(4, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void c() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.a.transact(5, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void d() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.a.transact(8, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void e() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.a.transact(9, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void f() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.a.transact(12, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public boolean g() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.a.transact(13, parcel, parcel2, 0);
            parcel2.readException();
            int n2 = parcel2.readInt();
            boolean bl2 = false;
            if (n2 == 0) return bl2;
            bl2 = true;
            return bl2;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public dm h() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.a.transact(15, parcel, parcel2, 0);
            parcel2.readException();
            dm dm2 = dn.a(parcel2.readStrongBinder());
            return dm2;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public dp i() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.a.transact(16, parcel, parcel2, 0);
            parcel2.readException();
            dp dp2 = dq.a(parcel2.readStrongBinder());
            return dp2;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public Bundle j() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.a.transact(17, parcel, parcel2, 0);
            parcel2.readException();
            Bundle bundle = parcel2.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(parcel2) : null;
            return bundle;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public Bundle k() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.a.transact(18, parcel, parcel2, 0);
            parcel2.readException();
            Bundle bundle = parcel2.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(parcel2) : null;
            return bundle;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public Bundle l() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.a.transact(19, parcel, parcel2, 0);
            parcel2.readException();
            Bundle bundle = parcel2.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(parcel2) : null;
            return bundle;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }
}

