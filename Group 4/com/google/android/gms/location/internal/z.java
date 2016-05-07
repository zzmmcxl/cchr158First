/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.internal.ClientIdentity;
import com.google.android.gms.location.internal.LocationRequestInternal;
import com.google.android.gms.location.internal.c;
import com.google.android.gms.location.l;
import java.util.List;

public class z
implements Parcelable.Creator {
    static void a(LocationRequestInternal locationRequestInternal, Parcel parcel, int n2) {
        int n3 = com.google.android.gms.common.internal.safeparcel.c.a(parcel);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 1, locationRequestInternal.b, n2, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 1000, locationRequestInternal.a());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, locationRequestInternal.c);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 3, locationRequestInternal.d);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 4, locationRequestInternal.e);
        com.google.android.gms.common.internal.safeparcel.c.c(parcel, 5, locationRequestInternal.f, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 6, locationRequestInternal.g, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 7, locationRequestInternal.h);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, n3);
    }

    public LocationRequestInternal a(Parcel parcel) {
        String string = null;
        boolean bl2 = true;
        boolean bl3 = false;
        int n2 = a.b(parcel);
        List list = LocationRequestInternal.a;
        boolean bl4 = bl2;
        boolean bl5 = false;
        LocationRequest locationRequest = null;
        int n3 = 0;
        block10 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new LocationRequestInternal(n3, locationRequest, bl5, bl4, bl2, list, string, bl3);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block10;
                }
                case 1: {
                    locationRequest = (LocationRequest)a.a(parcel, n4, LocationRequest.CREATOR);
                    continue block10;
                }
                case 1000: {
                    n3 = a.e(parcel, n4);
                    continue block10;
                }
                case 2: {
                    bl5 = a.c(parcel, n4);
                    continue block10;
                }
                case 3: {
                    bl4 = a.c(parcel, n4);
                    continue block10;
                }
                case 4: {
                    bl2 = a.c(parcel, n4);
                    continue block10;
                }
                case 5: {
                    list = a.c(parcel, n4, ClientIdentity.CREATOR);
                    continue block10;
                }
                case 6: {
                    string = a.l(parcel, n4);
                    continue block10;
                }
                case 7: 
            }
            bl3 = a.c(parcel, n4);
        } while (true);
    }

    public LocationRequestInternal[] a(int n2) {
        return new LocationRequestInternal[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

