/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

public class b
implements Parcelable.Creator {
    static void a(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, adLauncherIntentInfoParcel.a);
        c.a(parcel, 2, adLauncherIntentInfoParcel.b, false);
        c.a(parcel, 3, adLauncherIntentInfoParcel.c, false);
        c.a(parcel, 4, adLauncherIntentInfoParcel.d, false);
        c.a(parcel, 5, adLauncherIntentInfoParcel.e, false);
        c.a(parcel, 6, adLauncherIntentInfoParcel.f, false);
        c.a(parcel, 7, adLauncherIntentInfoParcel.g, false);
        c.a(parcel, 8, adLauncherIntentInfoParcel.h, false);
        c.a(parcel, 9, (Parcelable)adLauncherIntentInfoParcel.i, n2, false);
        c.a(parcel, n3);
    }

    public AdLauncherIntentInfoParcel a(Parcel parcel) {
        Intent intent = null;
        int n2 = a.b(parcel);
        int n3 = 0;
        String string = null;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        String string6 = null;
        String string7 = null;
        block11 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new AdLauncherIntentInfoParcel(n3, string7, string6, string5, string4, string3, string2, string, intent);
                throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block11;
                }
                case 1: {
                    n3 = a.e(parcel, n4);
                    continue block11;
                }
                case 2: {
                    string7 = a.l(parcel, n4);
                    continue block11;
                }
                case 3: {
                    string6 = a.l(parcel, n4);
                    continue block11;
                }
                case 4: {
                    string5 = a.l(parcel, n4);
                    continue block11;
                }
                case 5: {
                    string4 = a.l(parcel, n4);
                    continue block11;
                }
                case 6: {
                    string3 = a.l(parcel, n4);
                    continue block11;
                }
                case 7: {
                    string2 = a.l(parcel, n4);
                    continue block11;
                }
                case 8: {
                    string = a.l(parcel, n4);
                    continue block11;
                }
                case 9: 
            }
            intent = (Intent)a.a(parcel, n4, Intent.CREATOR);
        } while (true);
    }

    public AdLauncherIntentInfoParcel[] a(int n2) {
        return new AdLauncherIntentInfoParcel[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

