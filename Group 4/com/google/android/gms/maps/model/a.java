/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.b;

public class a
implements Parcelable.Creator {
    static void a(LatLngBounds latLngBounds, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, latLngBounds.a());
        c.a(parcel, 2, latLngBounds.a, n2, false);
        c.a(parcel, 3, latLngBounds.b, n2, false);
        c.a(parcel, n3);
    }

    public LatLngBounds a(Parcel parcel) {
        LatLng latLng = null;
        int n2 = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        int n3 = 0;
        LatLng latLng2 = null;
        do {
            int n4;
            LatLng latLng3;
            LatLng latLng4;
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new LatLngBounds(n3, latLng2, latLng);
                throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + n2, parcel);
            }
            int n5 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(n5)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, n5);
                    latLng3 = latLng;
                    latLng4 = latLng2;
                    n4 = n3;
                    break;
                }
                case 1: {
                    int n6 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, n5);
                    LatLng latLng5 = latLng;
                    latLng4 = latLng2;
                    n4 = n6;
                    latLng3 = latLng5;
                    break;
                }
                case 2: {
                    LatLng latLng6 = (LatLng)com.google.android.gms.common.internal.safeparcel.a.a(parcel, n5, LatLng.CREATOR);
                    n4 = n3;
                    latLng3 = latLng;
                    latLng4 = latLng6;
                    break;
                }
                case 3: {
                    latLng3 = (LatLng)com.google.android.gms.common.internal.safeparcel.a.a(parcel, n5, LatLng.CREATOR);
                    latLng4 = latLng2;
                    n4 = n3;
                }
            }
            n3 = n4;
            latLng2 = latLng4;
            latLng = latLng3;
        } while (true);
    }

    public LatLngBounds[] a(int n2) {
        return new LatLngBounds[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

