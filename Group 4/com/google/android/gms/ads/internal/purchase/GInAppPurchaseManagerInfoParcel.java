/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.a.b;
import com.google.android.gms.a.d;
import com.google.android.gms.ads.internal.purchase.a;
import com.google.android.gms.ads.internal.purchase.h;
import com.google.android.gms.ads.internal.purchase.i;
import com.google.android.gms.b.eq;
import com.google.android.gms.b.fi;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@fi
public final class GInAppPurchaseManagerInfoParcel
implements SafeParcelable {
    public static final a CREATOR = new a();
    public final int a;
    public final i b;
    public final eq c;
    public final Context d;
    public final h e;

    GInAppPurchaseManagerInfoParcel(int n2, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4) {
        this.a = n2;
        this.b = (i)d.a(b.a(iBinder));
        this.c = (eq)d.a(b.a(iBinder2));
        this.d = (Context)d.a(b.a(iBinder3));
        this.e = (h)d.a(b.a(iBinder4));
    }

    public static GInAppPurchaseManagerInfoParcel a(Intent intent) {
        try {
            Bundle bundle = intent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            bundle.setClassLoader(GInAppPurchaseManagerInfoParcel.class.getClassLoader());
            return (GInAppPurchaseManagerInfoParcel)bundle.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
        }
        catch (Exception var1_3) {
            return null;
        }
    }

    IBinder a() {
        return d.a(this.e).asBinder();
    }

    IBinder b() {
        return d.a(this.b).asBinder();
    }

    IBinder c() {
        return d.a(this.c).asBinder();
    }

    IBinder d() {
        return d.a((Object)this.d).asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        a.a(this, parcel, n2);
    }
}

