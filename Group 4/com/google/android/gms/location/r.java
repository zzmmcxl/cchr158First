/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.internal.ParcelableGeofence;
import com.google.android.gms.location.internal.ab;
import java.util.ArrayList;
import java.util.List;

public class r
implements Parcelable.Creator {
    static void a(GeofencingRequest geofencingRequest, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.c(parcel, 1, geofencingRequest.b(), false);
        c.a(parcel, 1000, geofencingRequest.a());
        c.a(parcel, 2, geofencingRequest.c());
        c.a(parcel, n3);
    }

    public GeofencingRequest a(Parcel parcel) {
        int n2 = 0;
        int n3 = a.b(parcel);
        ArrayList arrayList = null;
        int n4 = 0;
        block5 : do {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new GeofencingRequest(n4, arrayList, n2);
                throw new b("Overread allowed size end=" + n3, parcel);
            }
            int n5 = a.a(parcel);
            switch (a.a(n5)) {
                default: {
                    a.b(parcel, n5);
                    continue block5;
                }
                case 1: {
                    arrayList = a.c(parcel, n5, ParcelableGeofence.CREATOR);
                    continue block5;
                }
                case 1000: {
                    n4 = a.e(parcel, n5);
                    continue block5;
                }
                case 2: 
            }
            n2 = a.e(parcel, n5);
        } while (true);
    }

    public GeofencingRequest[] a(int n2) {
        return new GeofencingRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

