/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.l;
import java.util.ArrayList;
import java.util.List;

public class aa
implements Parcelable.Creator {
    static void a(LocationSettingsRequest locationSettingsRequest, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.c(parcel, 1, locationSettingsRequest.b(), false);
        c.a(parcel, 1000, locationSettingsRequest.a());
        c.a(parcel, 2, locationSettingsRequest.c());
        c.a(parcel, 3, locationSettingsRequest.d());
        c.a(parcel, n3);
    }

    public LocationSettingsRequest a(Parcel parcel) {
        boolean bl2 = false;
        int n2 = a.b(parcel);
        ArrayList arrayList = null;
        boolean bl3 = false;
        int n3 = 0;
        block6 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new LocationSettingsRequest(n3, arrayList, bl3, bl2);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block6;
                }
                case 1: {
                    arrayList = a.c(parcel, n4, LocationRequest.CREATOR);
                    continue block6;
                }
                case 1000: {
                    n3 = a.e(parcel, n4);
                    continue block6;
                }
                case 2: {
                    bl3 = a.c(parcel, n4);
                    continue block6;
                }
                case 3: 
            }
            bl2 = a.c(parcel, n4);
        } while (true);
    }

    public LocationSettingsRequest[] a(int n2) {
        return new LocationSettingsRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

