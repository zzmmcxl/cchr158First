/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.location.places.AutocompleteFilter;
import java.util.ArrayList;
import java.util.List;

public class b
implements Parcelable.Creator {
    static void a(AutocompleteFilter autocompleteFilter, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, autocompleteFilter.b);
        c.a(parcel, 1000, autocompleteFilter.a);
        c.a(parcel, 2, autocompleteFilter.c, false);
        c.a(parcel, n3);
    }

    public AutocompleteFilter a(Parcel parcel) {
        boolean bl2 = false;
        int n2 = a.b(parcel);
        ArrayList arrayList = null;
        int n3 = 0;
        block5 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new AutocompleteFilter(n3, bl2, arrayList);
                throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block5;
                }
                case 1: {
                    bl2 = a.c(parcel, n4);
                    continue block5;
                }
                case 1000: {
                    n3 = a.e(parcel, n4);
                    continue block5;
                }
                case 2: 
            }
            arrayList = a.q(parcel, n4);
        } while (true);
    }

    public AutocompleteFilter[] a(int n2) {
        return new AutocompleteFilter[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

