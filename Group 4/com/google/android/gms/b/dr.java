/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.a.a;
import com.google.android.gms.b.bh;
import com.google.android.gms.b.bi;
import com.google.android.gms.b.dp;
import java.util.ArrayList;
import java.util.List;

class dr
implements dp {
    private IBinder a;

    dr(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public String a() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            this.a.transact(2, parcel, parcel2, 0);
            parcel2.readException();
            String string = parcel2.readString();
            return string;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(a a2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            IBinder iBinder = a2 != null ? a2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            this.a.transact(9, parcel, parcel2, 0);
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
    public List b() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            this.a.transact(3, parcel, parcel2, 0);
            parcel2.readException();
            ArrayList arrayList = parcel2.readArrayList(this.getClass().getClassLoader());
            return arrayList;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void b(a a2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            IBinder iBinder = a2 != null ? a2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
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
    public String c() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            this.a.transact(4, parcel, parcel2, 0);
            parcel2.readException();
            String string = parcel2.readString();
            return string;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public bh d() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            this.a.transact(5, parcel, parcel2, 0);
            parcel2.readException();
            bh bh2 = bi.a(parcel2.readStrongBinder());
            return bh2;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public String e() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            this.a.transact(6, parcel, parcel2, 0);
            parcel2.readException();
            String string = parcel2.readString();
            return string;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public String f() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            this.a.transact(7, parcel, parcel2, 0);
            parcel2.readException();
            String string = parcel2.readString();
            return string;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void g() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
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
    public boolean h() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            this.a.transact(11, parcel, parcel2, 0);
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
    public boolean i() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            this.a.transact(12, parcel, parcel2, 0);
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
    public Bundle j() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            this.a.transact(13, parcel, parcel2, 0);
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

