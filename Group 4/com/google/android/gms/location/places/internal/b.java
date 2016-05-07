/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.location.places.internal.PlaceLocalization;
import java.util.ArrayList;
import java.util.List;

public class b
implements Parcelable.Creator {
    static void a(PlaceLocalization placeLocalization, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, placeLocalization.b, false);
        c.a(parcel, 1000, placeLocalization.a);
        c.a(parcel, 2, placeLocalization.c, false);
        c.a(parcel, 3, placeLocalization.d, false);
        c.a(parcel, 4, placeLocalization.e, false);
        c.b(parcel, 5, placeLocalization.f, false);
        c.a(parcel, n3);
    }

    public PlaceLocalization a(Parcel parcel) {
        ArrayList arrayList = null;
        int n2 = a.b(parcel);
        int n3 = 0;
        String string = null;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        block8 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new PlaceLocalization(n3, string4, string3, string2, string, arrayList);
                throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block8;
                }
                case 1: {
                    string4 = a.l(parcel, n4);
                    continue block8;
                }
                case 1000: {
                    n3 = a.e(parcel, n4);
                    continue block8;
                }
                case 2: {
                    string3 = a.l(parcel, n4);
                    continue block8;
                }
                case 3: {
                    string2 = a.l(parcel, n4);
                    continue block8;
                }
                case 4: {
                    string = a.l(parcel, n4);
                    continue block8;
                }
                case 5: 
            }
            arrayList = a.r(parcel, n4);
        } while (true);
    }

    public PlaceLocalization[] a(int n2) {
        return new PlaceLocalization[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

