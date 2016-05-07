/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.location.LocationResult;
import java.util.List;

public class z
implements Parcelable.Creator {
    static void a(LocationResult locationResult, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.c(parcel, 1, locationResult.a(), false);
        c.a(parcel, 1000, locationResult.b());
        c.a(parcel, n3);
    }

    public LocationResult a(Parcel parcel) {
        int n2 = a.b(parcel);
        int n3 = 0;
        List list = LocationResult.a;
        block4 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new LocationResult(n3, list);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block4;
                }
                case 1: {
                    list = a.c(parcel, n4, Location.CREATOR);
                    continue block4;
                }
                case 1000: 
            }
            n3 = a.e(parcel, n4);
        } while (true);
    }

    public LocationResult[] a(int n2) {
        return new LocationResult[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

