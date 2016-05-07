/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.a.b;
import com.google.android.gms.a.d;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.client.a;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.k;
import com.google.android.gms.ads.internal.overlay.l;
import com.google.android.gms.ads.internal.overlay.t;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.bq;
import com.google.android.gms.b.cf;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.hb;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@fi
public final class AdOverlayInfoParcel
implements SafeParcelable {
    public static final k CREATOR = new k();
    public final int a;
    public final AdLauncherIntentInfoParcel b;
    public final a c;
    public final l d;
    public final hb e;
    public final bq f;
    public final String g;
    public final boolean h;
    public final String i;
    public final t j;
    public final int k;
    public final int l;
    public final String m;
    public final VersionInfoParcel n;
    public final cf o;
    public final String p;
    public final InterstitialAdParameterParcel q;

    AdOverlayInfoParcel(int n2, AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String string, boolean bl2, String string2, IBinder iBinder5, int n3, int n4, String string3, VersionInfoParcel versionInfoParcel, IBinder iBinder6, String string4, InterstitialAdParameterParcel interstitialAdParameterParcel) {
        this.a = n2;
        this.b = adLauncherIntentInfoParcel;
        this.c = (a)d.a(b.a(iBinder));
        this.d = (l)d.a(b.a(iBinder2));
        this.e = (hb)d.a(b.a(iBinder3));
        this.f = (bq)d.a(b.a(iBinder4));
        this.g = string;
        this.h = bl2;
        this.i = string2;
        this.j = (t)d.a(b.a(iBinder5));
        this.k = n3;
        this.l = n4;
        this.m = string3;
        this.n = versionInfoParcel;
        this.o = (cf)d.a(b.a(iBinder6));
        this.p = string4;
        this.q = interstitialAdParameterParcel;
    }

    public AdOverlayInfoParcel(a a2, l l2, t t2, hb hb2, boolean bl2, int n2, VersionInfoParcel versionInfoParcel) {
        this.a = 4;
        this.b = null;
        this.c = a2;
        this.d = l2;
        this.e = hb2;
        this.f = null;
        this.g = null;
        this.h = bl2;
        this.i = null;
        this.j = t2;
        this.k = n2;
        this.l = 2;
        this.m = null;
        this.n = versionInfoParcel;
        this.o = null;
        this.p = null;
        this.q = null;
    }

    public AdOverlayInfoParcel(a a2, l l2, bq bq2, t t2, hb hb2, boolean bl2, int n2, String string, VersionInfoParcel versionInfoParcel, cf cf2) {
        this.a = 4;
        this.b = null;
        this.c = a2;
        this.d = l2;
        this.e = hb2;
        this.f = bq2;
        this.g = null;
        this.h = bl2;
        this.i = null;
        this.j = t2;
        this.k = n2;
        this.l = 3;
        this.m = string;
        this.n = versionInfoParcel;
        this.o = cf2;
        this.p = null;
        this.q = null;
    }

    public AdOverlayInfoParcel(a a2, l l2, bq bq2, t t2, hb hb2, boolean bl2, int n2, String string, String string2, VersionInfoParcel versionInfoParcel, cf cf2) {
        this.a = 4;
        this.b = null;
        this.c = a2;
        this.d = l2;
        this.e = hb2;
        this.f = bq2;
        this.g = string2;
        this.h = bl2;
        this.i = string;
        this.j = t2;
        this.k = n2;
        this.l = 3;
        this.m = null;
        this.n = versionInfoParcel;
        this.o = cf2;
        this.p = null;
        this.q = null;
    }

    public AdOverlayInfoParcel(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, a a2, l l2, t t2, VersionInfoParcel versionInfoParcel) {
        this.a = 4;
        this.b = adLauncherIntentInfoParcel;
        this.c = a2;
        this.d = l2;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = null;
        this.j = t2;
        this.k = -1;
        this.l = 4;
        this.m = null;
        this.n = versionInfoParcel;
        this.o = null;
        this.p = null;
        this.q = null;
    }

    public static AdOverlayInfoParcel a(Intent intent) {
        try {
            Bundle bundle = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundle.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel)bundle.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        }
        catch (Exception var1_3) {
            return null;
        }
    }

    public static void a(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", (Parcelable)adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    IBinder a() {
        return d.a(this.c).asBinder();
    }

    IBinder b() {
        return d.a(this.d).asBinder();
    }

    IBinder c() {
        return d.a(this.e).asBinder();
    }

    IBinder d() {
        return d.a(this.f).asBinder();
    }

    public int describeContents() {
        return 0;
    }

    IBinder e() {
        return d.a(this.o).asBinder();
    }

    IBinder f() {
        return d.a(this.j).asBinder();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        k.a(this, parcel, n2);
    }
}

