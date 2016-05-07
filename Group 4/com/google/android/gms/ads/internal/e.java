/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class e
implements Parcelable.Creator {
    static void a(InterstitialAdParameterParcel interstitialAdParameterParcel, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, interstitialAdParameterParcel.a);
        c.a(parcel, 2, interstitialAdParameterParcel.b);
        c.a(parcel, 3, interstitialAdParameterParcel.c);
        c.a(parcel, 4, interstitialAdParameterParcel.d, false);
        c.a(parcel, 5, interstitialAdParameterParcel.e);
        c.a(parcel, 6, interstitialAdParameterParcel.f);
        c.a(parcel, n3);
    }

    public InterstitialAdParameterParcel a(Parcel parcel) {
        boolean bl2 = false;
        int n2 = a.b(parcel);
        String string = null;
        float f2 = 0.0f;
        boolean bl3 = false;
        boolean bl4 = false;
        int n3 = 0;
        block8 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new InterstitialAdParameterParcel(n3, bl4, bl3, string, bl2, f2);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block8;
                }
                case 1: {
                    n3 = a.e(parcel, n4);
                    continue block8;
                }
                case 2: {
                    bl4 = a.c(parcel, n4);
                    continue block8;
                }
                case 3: {
                    bl3 = a.c(parcel, n4);
                    continue block8;
                }
                case 4: {
                    string = a.l(parcel, n4);
                    continue block8;
                }
                case 5: {
                    bl2 = a.c(parcel, n4);
                    continue block8;
                }
                case 6: 
            }
            f2 = a.i(parcel, n4);
        } while (true);
    }

    public InterstitialAdParameterParcel[] a(int n2) {
        return new InterstitialAdParameterParcel[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

