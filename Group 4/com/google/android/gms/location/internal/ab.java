/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.location.internal.ParcelableGeofence;

public class ab
implements Parcelable.Creator {
    static void a(ParcelableGeofence parcelableGeofence, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, parcelableGeofence.a(), false);
        c.a(parcel, 1000, parcelableGeofence.b());
        c.a(parcel, 2, parcelableGeofence.g());
        c.a(parcel, 3, parcelableGeofence.c());
        c.a(parcel, 4, parcelableGeofence.d());
        c.a(parcel, 5, parcelableGeofence.e());
        c.a(parcel, 6, parcelableGeofence.f());
        c.a(parcel, 7, parcelableGeofence.h());
        c.a(parcel, 8, parcelableGeofence.i());
        c.a(parcel, 9, parcelableGeofence.j());
        c.a(parcel, n3);
    }

    public ParcelableGeofence a(Parcel parcel) {
        int n2 = a.b(parcel);
        int n3 = 0;
        String string = null;
        int n4 = 0;
        short s2 = 0;
        double d2 = 0.0;
        double d3 = 0.0;
        float f2 = 0.0f;
        long l2 = 0;
        int n5 = 0;
        int n6 = -1;
        block12 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new ParcelableGeofence(n3, string, n4, s2, d2, d3, f2, l2, n5, n6);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n7 = a.a(parcel);
            switch (a.a(n7)) {
                default: {
                    a.b(parcel, n7);
                    continue block12;
                }
                case 1: {
                    string = a.l(parcel, n7);
                    continue block12;
                }
                case 1000: {
                    n3 = a.e(parcel, n7);
                    continue block12;
                }
                case 2: {
                    l2 = a.g(parcel, n7);
                    continue block12;
                }
                case 3: {
                    s2 = a.d(parcel, n7);
                    continue block12;
                }
                case 4: {
                    d2 = a.k(parcel, n7);
                    continue block12;
                }
                case 5: {
                    d3 = a.k(parcel, n7);
                    continue block12;
                }
                case 6: {
                    f2 = a.i(parcel, n7);
                    continue block12;
                }
                case 7: {
                    n4 = a.e(parcel, n7);
                    continue block12;
                }
                case 8: {
                    n5 = a.e(parcel, n7);
                    continue block12;
                }
                case 9: 
            }
            n6 = a.e(parcel, n7);
        } while (true);
    }

    public ParcelableGeofence[] a(int n2) {
        return new ParcelableGeofence[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

