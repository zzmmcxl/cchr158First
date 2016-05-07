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

public class l
implements Parcelable.Creator {
    static void a(LocationRequest locationRequest, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, locationRequest.a);
        c.a(parcel, 1000, locationRequest.a());
        c.a(parcel, 2, locationRequest.b);
        c.a(parcel, 3, locationRequest.c);
        c.a(parcel, 4, locationRequest.d);
        c.a(parcel, 5, locationRequest.e);
        c.a(parcel, 6, locationRequest.f);
        c.a(parcel, 7, locationRequest.g);
        c.a(parcel, 8, locationRequest.h);
        c.a(parcel, n3);
    }

    public LocationRequest a(Parcel parcel) {
        int n2 = a.b(parcel);
        int n3 = 0;
        int n4 = 102;
        long l2 = 3600000;
        long l3 = 600000;
        boolean bl2 = false;
        long l4 = Long.MAX_VALUE;
        int n5 = Integer.MAX_VALUE;
        float f2 = 0.0f;
        long l5 = 0;
        block11 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new LocationRequest(n3, n4, l2, l3, bl2, l4, n5, f2, l5);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n6 = a.a(parcel);
            switch (a.a(n6)) {
                default: {
                    a.b(parcel, n6);
                    continue block11;
                }
                case 1: {
                    n4 = a.e(parcel, n6);
                    continue block11;
                }
                case 1000: {
                    n3 = a.e(parcel, n6);
                    continue block11;
                }
                case 2: {
                    l2 = a.g(parcel, n6);
                    continue block11;
                }
                case 3: {
                    l3 = a.g(parcel, n6);
                    continue block11;
                }
                case 4: {
                    bl2 = a.c(parcel, n6);
                    continue block11;
                }
                case 5: {
                    l4 = a.g(parcel, n6);
                    continue block11;
                }
                case 6: {
                    n5 = a.e(parcel, n6);
                    continue block11;
                }
                case 7: {
                    f2 = a.i(parcel, n6);
                    continue block11;
                }
                case 8: 
            }
            l5 = a.g(parcel, n6);
        } while (true);
    }

    public LocationRequest[] a(int n2) {
        return new LocationRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

