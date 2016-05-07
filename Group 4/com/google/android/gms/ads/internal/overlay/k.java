/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.e;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

public class k
implements Parcelable.Creator {
    static void a(AdOverlayInfoParcel adOverlayInfoParcel, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, adOverlayInfoParcel.a);
        c.a(parcel, 2, adOverlayInfoParcel.b, n2, false);
        c.a(parcel, 3, adOverlayInfoParcel.a(), false);
        c.a(parcel, 4, adOverlayInfoParcel.b(), false);
        c.a(parcel, 5, adOverlayInfoParcel.c(), false);
        c.a(parcel, 6, adOverlayInfoParcel.d(), false);
        c.a(parcel, 7, adOverlayInfoParcel.g, false);
        c.a(parcel, 8, adOverlayInfoParcel.h);
        c.a(parcel, 9, adOverlayInfoParcel.i, false);
        c.a(parcel, 10, adOverlayInfoParcel.f(), false);
        c.a(parcel, 11, adOverlayInfoParcel.k);
        c.a(parcel, 12, adOverlayInfoParcel.l);
        c.a(parcel, 13, adOverlayInfoParcel.m, false);
        c.a(parcel, 14, adOverlayInfoParcel.n, n2, false);
        c.a(parcel, 15, adOverlayInfoParcel.e(), false);
        c.a(parcel, 17, adOverlayInfoParcel.q, n2, false);
        c.a(parcel, 16, adOverlayInfoParcel.p, false);
        c.a(parcel, n3);
    }

    public AdOverlayInfoParcel a(Parcel parcel) {
        int n2 = a.b(parcel);
        int n3 = 0;
        AdLauncherIntentInfoParcel adLauncherIntentInfoParcel = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String string = null;
        boolean bl2 = false;
        String string2 = null;
        IBinder iBinder5 = null;
        int n4 = 0;
        int n5 = 0;
        String string3 = null;
        VersionInfoParcel versionInfoParcel = null;
        IBinder iBinder6 = null;
        String string4 = null;
        InterstitialAdParameterParcel interstitialAdParameterParcel = null;
        block19 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new AdOverlayInfoParcel(n3, adLauncherIntentInfoParcel, iBinder, iBinder2, iBinder3, iBinder4, string, bl2, string2, iBinder5, n4, n5, string3, versionInfoParcel, iBinder6, string4, interstitialAdParameterParcel);
                throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + n2, parcel);
            }
            int n6 = a.a(parcel);
            switch (a.a(n6)) {
                default: {
                    a.b(parcel, n6);
                    continue block19;
                }
                case 1: {
                    n3 = a.e(parcel, n6);
                    continue block19;
                }
                case 2: {
                    adLauncherIntentInfoParcel = (AdLauncherIntentInfoParcel)a.a(parcel, n6, AdLauncherIntentInfoParcel.CREATOR);
                    continue block19;
                }
                case 3: {
                    iBinder = a.m(parcel, n6);
                    continue block19;
                }
                case 4: {
                    iBinder2 = a.m(parcel, n6);
                    continue block19;
                }
                case 5: {
                    iBinder3 = a.m(parcel, n6);
                    continue block19;
                }
                case 6: {
                    iBinder4 = a.m(parcel, n6);
                    continue block19;
                }
                case 7: {
                    string = a.l(parcel, n6);
                    continue block19;
                }
                case 8: {
                    bl2 = a.c(parcel, n6);
                    continue block19;
                }
                case 9: {
                    string2 = a.l(parcel, n6);
                    continue block19;
                }
                case 10: {
                    iBinder5 = a.m(parcel, n6);
                    continue block19;
                }
                case 11: {
                    n4 = a.e(parcel, n6);
                    continue block19;
                }
                case 12: {
                    n5 = a.e(parcel, n6);
                    continue block19;
                }
                case 13: {
                    string3 = a.l(parcel, n6);
                    continue block19;
                }
                case 14: {
                    versionInfoParcel = (VersionInfoParcel)a.a(parcel, n6, VersionInfoParcel.CREATOR);
                    continue block19;
                }
                case 15: {
                    iBinder6 = a.m(parcel, n6);
                    continue block19;
                }
                case 17: {
                    interstitialAdParameterParcel = (InterstitialAdParameterParcel)a.a(parcel, n6, InterstitialAdParameterParcel.CREATOR);
                    continue block19;
                }
                case 16: 
            }
            string4 = a.l(parcel, n6);
        } while (true);
    }

    public AdOverlayInfoParcel[] a(int n2) {
        return new AdOverlayInfoParcel[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

