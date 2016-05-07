/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.maps.model.LatLng;

public class b
implements Parcelable.Creator {
    static void a(LatLng latLng, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, latLng.a());
        c.a(parcel, 2, latLng.a);
        c.a(parcel, 3, latLng.b);
        c.a(parcel, n3);
    }

    public LatLng a(Parcel parcel) {
        double d2 = 0.0;
        int n2 = a.b(parcel);
        int n3 = 0;
        double d3 = d2;
        block5 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new LatLng(n3, d3, d2);
                throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block5;
                }
                case 1: {
                    n3 = a.e(parcel, n4);
                    continue block5;
                }
                case 2: {
                    d3 = a.k(parcel, n4);
                    continue block5;
                }
                case 3: 
            }
            d2 = a.k(parcel, n4);
        } while (true);
    }

    public LatLng[] a(int n2) {
        return new LatLng[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

