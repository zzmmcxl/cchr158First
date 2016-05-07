/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class j
implements Parcelable.Creator {
    static void a(AdSizeParcel adSizeParcel, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, adSizeParcel.a);
        c.a(parcel, 2, adSizeParcel.b, false);
        c.a(parcel, 3, adSizeParcel.c);
        c.a(parcel, 4, adSizeParcel.d);
        c.a(parcel, 5, adSizeParcel.e);
        c.a(parcel, 6, adSizeParcel.f);
        c.a(parcel, 7, adSizeParcel.g);
        c.a(parcel, 8, adSizeParcel.h, n2, false);
        c.a(parcel, 9, adSizeParcel.i);
        c.a(parcel, 10, adSizeParcel.j);
        c.a(parcel, 11, adSizeParcel.k);
        c.a(parcel, n3);
    }

    public AdSizeParcel a(Parcel parcel) {
        AdSizeParcel[] arradSizeParcel = null;
        boolean bl2 = false;
        int n2 = a.b(parcel);
        boolean bl3 = false;
        boolean bl4 = false;
        int n3 = 0;
        int n4 = 0;
        boolean bl5 = false;
        int n5 = 0;
        int n6 = 0;
        String string = null;
        int n7 = 0;
        block13 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new AdSizeParcel(n7, string, n6, n5, bl5, n4, n3, arradSizeParcel, bl4, bl3, bl2);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n8 = a.a(parcel);
            switch (a.a(n8)) {
                default: {
                    a.b(parcel, n8);
                    continue block13;
                }
                case 1: {
                    n7 = a.e(parcel, n8);
                    continue block13;
                }
                case 2: {
                    string = a.l(parcel, n8);
                    continue block13;
                }
                case 3: {
                    n6 = a.e(parcel, n8);
                    continue block13;
                }
                case 4: {
                    n5 = a.e(parcel, n8);
                    continue block13;
                }
                case 5: {
                    bl5 = a.c(parcel, n8);
                    continue block13;
                }
                case 6: {
                    n4 = a.e(parcel, n8);
                    continue block13;
                }
                case 7: {
                    n3 = a.e(parcel, n8);
                    continue block13;
                }
                case 8: {
                    arradSizeParcel = (AdSizeParcel[])a.b(parcel, n8, AdSizeParcel.CREATOR);
                    continue block13;
                }
                case 9: {
                    bl4 = a.c(parcel, n8);
                    continue block13;
                }
                case 10: {
                    bl3 = a.c(parcel, n8);
                    continue block13;
                }
                case 11: 
            }
            bl2 = a.c(parcel, n8);
        } while (true);
    }

    public AdSizeParcel[] a(int n2) {
        return new AdSizeParcel[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

