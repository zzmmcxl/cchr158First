/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.location.LocationSettingsStates;

public class ac
implements Parcelable.Creator {
    static void a(LocationSettingsStates locationSettingsStates, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, locationSettingsStates.b());
        c.a(parcel, 1000, locationSettingsStates.a());
        c.a(parcel, 2, locationSettingsStates.d());
        c.a(parcel, 3, locationSettingsStates.f());
        c.a(parcel, 4, locationSettingsStates.c());
        c.a(parcel, 5, locationSettingsStates.e());
        c.a(parcel, 6, locationSettingsStates.g());
        c.a(parcel, n3);
    }

    public LocationSettingsStates a(Parcel parcel) {
        boolean bl2 = false;
        int n2 = a.b(parcel);
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = false;
        boolean bl7 = false;
        int n3 = 0;
        block9 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new LocationSettingsStates(n3, bl7, bl6, bl5, bl4, bl3, bl2);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block9;
                }
                case 1: {
                    bl7 = a.c(parcel, n4);
                    continue block9;
                }
                case 1000: {
                    n3 = a.e(parcel, n4);
                    continue block9;
                }
                case 2: {
                    bl6 = a.c(parcel, n4);
                    continue block9;
                }
                case 3: {
                    bl5 = a.c(parcel, n4);
                    continue block9;
                }
                case 4: {
                    bl4 = a.c(parcel, n4);
                    continue block9;
                }
                case 5: {
                    bl3 = a.c(parcel, n4);
                    continue block9;
                }
                case 6: 
            }
            bl2 = a.c(parcel, n4);
        } while (true);
    }

    public LocationSettingsStates[] a(int n2) {
        return new LocationSettingsStates[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

