/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import com.google.android.gms.ads.internal.client.e;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;
import java.util.List;

public class i
implements Parcelable.Creator {
    static void a(AdRequestParcel adRequestParcel, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, adRequestParcel.a);
        c.a(parcel, 2, adRequestParcel.b);
        c.a(parcel, 3, adRequestParcel.c, false);
        c.a(parcel, 4, adRequestParcel.d);
        c.b(parcel, 5, adRequestParcel.e, false);
        c.a(parcel, 6, adRequestParcel.f);
        c.a(parcel, 7, adRequestParcel.g);
        c.a(parcel, 8, adRequestParcel.h);
        c.a(parcel, 9, adRequestParcel.i, false);
        c.a(parcel, 10, adRequestParcel.j, n2, false);
        c.a(parcel, 11, (Parcelable)adRequestParcel.k, n2, false);
        c.a(parcel, 12, adRequestParcel.l, false);
        c.a(parcel, 13, adRequestParcel.m, false);
        c.a(parcel, 14, adRequestParcel.n, false);
        c.b(parcel, 15, adRequestParcel.o, false);
        c.a(parcel, 17, adRequestParcel.q, false);
        c.a(parcel, 16, adRequestParcel.p, false);
        c.a(parcel, 18, adRequestParcel.r);
        c.a(parcel, n3);
    }

    public AdRequestParcel a(Parcel parcel) {
        int n2 = a.b(parcel);
        int n3 = 0;
        long l2 = 0;
        Bundle bundle = null;
        int n4 = 0;
        ArrayList arrayList = null;
        boolean bl2 = false;
        int n5 = 0;
        boolean bl3 = false;
        String string = null;
        SearchAdRequestParcel searchAdRequestParcel = null;
        Location location = null;
        String string2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        ArrayList arrayList2 = null;
        String string3 = null;
        String string4 = null;
        boolean bl4 = false;
        block20 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new AdRequestParcel(n3, l2, bundle, n4, arrayList, bl2, n5, bl3, string, searchAdRequestParcel, location, string2, bundle2, bundle3, arrayList2, string3, string4, bl4);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n6 = a.a(parcel);
            switch (a.a(n6)) {
                default: {
                    a.b(parcel, n6);
                    continue block20;
                }
                case 1: {
                    n3 = a.e(parcel, n6);
                    continue block20;
                }
                case 2: {
                    l2 = a.g(parcel, n6);
                    continue block20;
                }
                case 3: {
                    bundle = a.n(parcel, n6);
                    continue block20;
                }
                case 4: {
                    n4 = a.e(parcel, n6);
                    continue block20;
                }
                case 5: {
                    arrayList = a.r(parcel, n6);
                    continue block20;
                }
                case 6: {
                    bl2 = a.c(parcel, n6);
                    continue block20;
                }
                case 7: {
                    n5 = a.e(parcel, n6);
                    continue block20;
                }
                case 8: {
                    bl3 = a.c(parcel, n6);
                    continue block20;
                }
                case 9: {
                    string = a.l(parcel, n6);
                    continue block20;
                }
                case 10: {
                    searchAdRequestParcel = (SearchAdRequestParcel)a.a(parcel, n6, SearchAdRequestParcel.CREATOR);
                    continue block20;
                }
                case 11: {
                    location = (Location)a.a(parcel, n6, Location.CREATOR);
                    continue block20;
                }
                case 12: {
                    string2 = a.l(parcel, n6);
                    continue block20;
                }
                case 13: {
                    bundle2 = a.n(parcel, n6);
                    continue block20;
                }
                case 14: {
                    bundle3 = a.n(parcel, n6);
                    continue block20;
                }
                case 15: {
                    arrayList2 = a.r(parcel, n6);
                    continue block20;
                }
                case 17: {
                    string4 = a.l(parcel, n6);
                    continue block20;
                }
                case 16: {
                    string3 = a.l(parcel, n6);
                    continue block20;
                }
                case 18: 
            }
            bl4 = a.c(parcel, n6);
        } while (true);
    }

    public AdRequestParcel[] a(int n2) {
        return new AdRequestParcel[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

