/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.location.LocationAvailability;

public class k
implements Parcelable.Creator {
    static void a(LocationAvailability locationAvailability, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, locationAvailability.a);
        c.a(parcel, 1000, locationAvailability.b());
        c.a(parcel, 2, locationAvailability.b);
        c.a(parcel, 3, locationAvailability.c);
        c.a(parcel, 4, locationAvailability.d);
        c.a(parcel, n3);
    }

    public LocationAvailability a(Parcel parcel) {
        int n2 = 1;
        int n3 = a.b(parcel);
        int n4 = 0;
        int n5 = 1000;
        long l2 = 0;
        int n6 = n2;
        block7 : do {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new LocationAvailability(n4, n5, n6, n2, l2);
                throw new b("Overread allowed size end=" + n3, parcel);
            }
            int n7 = a.a(parcel);
            switch (a.a(n7)) {
                default: {
                    a.b(parcel, n7);
                    continue block7;
                }
                case 1: {
                    n6 = a.e(parcel, n7);
                    continue block7;
                }
                case 1000: {
                    n4 = a.e(parcel, n7);
                    continue block7;
                }
                case 2: {
                    n2 = a.e(parcel, n7);
                    continue block7;
                }
                case 3: {
                    l2 = a.g(parcel, n7);
                    continue block7;
                }
                case 4: 
            }
            n5 = a.e(parcel, n7);
        } while (true);
    }

    public LocationAvailability[] a(int n2) {
        return new LocationAvailability[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

