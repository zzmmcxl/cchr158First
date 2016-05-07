/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.location.places.internal.PlaceImpl;
import com.google.android.gms.location.places.internal.PlaceLocalization;
import com.google.android.gms.location.places.internal.b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;

public class a
implements Parcelable.Creator {
    static void a(PlaceImpl placeImpl, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, placeImpl.d(), false);
        c.a(parcel, 2, placeImpl.s(), false);
        c.a(parcel, 3, placeImpl.u(), n2, false);
        c.a(parcel, 4, placeImpl.c(), n2, false);
        c.a(parcel, 5, placeImpl.i());
        c.a(parcel, 6, placeImpl.j(), n2, false);
        c.a(parcel, 7, placeImpl.t(), false);
        c.a(parcel, 8, (Parcelable)placeImpl.k(), n2, false);
        c.a(parcel, 9, placeImpl.o());
        c.a(parcel, 10, placeImpl.p());
        c.a(parcel, 11, placeImpl.q());
        c.a(parcel, 12, placeImpl.r());
        c.a(parcel, 13, placeImpl.f(), false);
        c.a(parcel, 14, placeImpl.h(), false);
        c.a(parcel, 15, placeImpl.l(), false);
        c.b(parcel, 17, placeImpl.n(), false);
        c.a(parcel, 16, placeImpl.m(), false);
        c.a(parcel, 1000, placeImpl.a);
        c.a(parcel, 19, placeImpl.g(), false);
        c.a(parcel, 20, placeImpl.e(), false);
        c.a(parcel, n3);
    }

    public PlaceImpl a(Parcel parcel) {
        int n2 = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        int n3 = 0;
        String string = null;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        Bundle bundle = null;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        ArrayList arrayList3 = null;
        LatLng latLng = null;
        float f2 = 0.0f;
        LatLngBounds latLngBounds = null;
        String string6 = null;
        Uri uri = null;
        boolean bl2 = false;
        float f3 = 0.0f;
        int n4 = 0;
        long l2 = 0;
        PlaceLocalization placeLocalization = null;
        block22 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new PlaceImpl(n3, string, arrayList, arrayList2, bundle, string2, string3, string4, string5, arrayList3, latLng, f2, latLngBounds, string6, uri, bl2, f3, n4, l2, placeLocalization);
                throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + n2, parcel);
            }
            int n5 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(n5)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, n5);
                    continue block22;
                }
                case 1: {
                    string = com.google.android.gms.common.internal.safeparcel.a.l(parcel, n5);
                    continue block22;
                }
                case 2: {
                    bundle = com.google.android.gms.common.internal.safeparcel.a.n(parcel, n5);
                    continue block22;
                }
                case 3: {
                    placeLocalization = (PlaceLocalization)com.google.android.gms.common.internal.safeparcel.a.a(parcel, n5, PlaceLocalization.CREATOR);
                    continue block22;
                }
                case 4: {
                    latLng = (LatLng)com.google.android.gms.common.internal.safeparcel.a.a(parcel, n5, LatLng.CREATOR);
                    continue block22;
                }
                case 5: {
                    f2 = com.google.android.gms.common.internal.safeparcel.a.i(parcel, n5);
                    continue block22;
                }
                case 6: {
                    latLngBounds = (LatLngBounds)com.google.android.gms.common.internal.safeparcel.a.a(parcel, n5, LatLngBounds.CREATOR);
                    continue block22;
                }
                case 7: {
                    string6 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, n5);
                    continue block22;
                }
                case 8: {
                    uri = (Uri)com.google.android.gms.common.internal.safeparcel.a.a(parcel, n5, Uri.CREATOR);
                    continue block22;
                }
                case 9: {
                    bl2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, n5);
                    continue block22;
                }
                case 10: {
                    f3 = com.google.android.gms.common.internal.safeparcel.a.i(parcel, n5);
                    continue block22;
                }
                case 11: {
                    n4 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, n5);
                    continue block22;
                }
                case 12: {
                    l2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, n5);
                    continue block22;
                }
                case 13: {
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.a.q(parcel, n5);
                    continue block22;
                }
                case 14: {
                    string3 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, n5);
                    continue block22;
                }
                case 15: {
                    string4 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, n5);
                    continue block22;
                }
                case 17: {
                    arrayList3 = com.google.android.gms.common.internal.safeparcel.a.r(parcel, n5);
                    continue block22;
                }
                case 16: {
                    string5 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, n5);
                    continue block22;
                }
                case 1000: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, n5);
                    continue block22;
                }
                case 19: {
                    string2 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, n5);
                    continue block22;
                }
                case 20: 
            }
            arrayList = com.google.android.gms.common.internal.safeparcel.a.q(parcel, n5);
        } while (true);
    }

    public PlaceImpl[] a(int n2) {
        return new PlaceImpl[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

