/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class e
implements Parcelable.Creator {
    static void a(SearchAdRequestParcel searchAdRequestParcel, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, searchAdRequestParcel.a);
        c.a(parcel, 2, searchAdRequestParcel.b);
        c.a(parcel, 3, searchAdRequestParcel.c);
        c.a(parcel, 4, searchAdRequestParcel.d);
        c.a(parcel, 5, searchAdRequestParcel.e);
        c.a(parcel, 6, searchAdRequestParcel.f);
        c.a(parcel, 7, searchAdRequestParcel.g);
        c.a(parcel, 8, searchAdRequestParcel.h);
        c.a(parcel, 9, searchAdRequestParcel.i);
        c.a(parcel, 10, searchAdRequestParcel.j, false);
        c.a(parcel, 11, searchAdRequestParcel.k);
        c.a(parcel, 12, searchAdRequestParcel.l, false);
        c.a(parcel, 13, searchAdRequestParcel.m);
        c.a(parcel, 14, searchAdRequestParcel.n);
        c.a(parcel, 15, searchAdRequestParcel.o, false);
        c.a(parcel, n3);
    }

    public SearchAdRequestParcel a(Parcel parcel) {
        int n2 = a.b(parcel);
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        String string = null;
        int n12 = 0;
        String string2 = null;
        int n13 = 0;
        int n14 = 0;
        String string3 = null;
        block17 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new SearchAdRequestParcel(n3, n4, n5, n6, n7, n8, n9, n10, n11, string, n12, string2, n13, n14, string3);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n15 = a.a(parcel);
            switch (a.a(n15)) {
                default: {
                    a.b(parcel, n15);
                    continue block17;
                }
                case 1: {
                    n3 = a.e(parcel, n15);
                    continue block17;
                }
                case 2: {
                    n4 = a.e(parcel, n15);
                    continue block17;
                }
                case 3: {
                    n5 = a.e(parcel, n15);
                    continue block17;
                }
                case 4: {
                    n6 = a.e(parcel, n15);
                    continue block17;
                }
                case 5: {
                    n7 = a.e(parcel, n15);
                    continue block17;
                }
                case 6: {
                    n8 = a.e(parcel, n15);
                    continue block17;
                }
                case 7: {
                    n9 = a.e(parcel, n15);
                    continue block17;
                }
                case 8: {
                    n10 = a.e(parcel, n15);
                    continue block17;
                }
                case 9: {
                    n11 = a.e(parcel, n15);
                    continue block17;
                }
                case 10: {
                    string = a.l(parcel, n15);
                    continue block17;
                }
                case 11: {
                    n12 = a.e(parcel, n15);
                    continue block17;
                }
                case 12: {
                    string2 = a.l(parcel, n15);
                    continue block17;
                }
                case 13: {
                    n13 = a.e(parcel, n15);
                    continue block17;
                }
                case 14: {
                    n14 = a.e(parcel, n15);
                    continue block17;
                }
                case 15: 
            }
            string3 = a.l(parcel, n15);
        } while (true);
    }

    public SearchAdRequestParcel[] a(int n2) {
        return new SearchAdRequestParcel[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

