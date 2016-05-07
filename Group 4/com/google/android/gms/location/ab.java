/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStates;

public class ab
implements Parcelable.Creator {
    static void a(LocationSettingsResult locationSettingsResult, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, locationSettingsResult.a(), n2, false);
        c.a(parcel, 1000, locationSettingsResult.b());
        c.a(parcel, 2, locationSettingsResult.c(), n2, false);
        c.a(parcel, n3);
    }

    public LocationSettingsResult a(Parcel parcel) {
        LocationSettingsStates locationSettingsStates = null;
        int n2 = a.b(parcel);
        int n3 = 0;
        Status status = null;
        do {
            int n4;
            Status status2;
            LocationSettingsStates locationSettingsStates2;
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new LocationSettingsResult(n3, status, locationSettingsStates);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n5 = a.a(parcel);
            switch (a.a(n5)) {
                default: {
                    a.b(parcel, n5);
                    locationSettingsStates2 = locationSettingsStates;
                    status2 = status;
                    n4 = n3;
                    break;
                }
                case 1: {
                    Status status3 = (Status)a.a(parcel, n5, Status.CREATOR);
                    n4 = n3;
                    locationSettingsStates2 = locationSettingsStates;
                    status2 = status3;
                    break;
                }
                case 1000: {
                    int n6 = a.e(parcel, n5);
                    LocationSettingsStates locationSettingsStates3 = locationSettingsStates;
                    status2 = status;
                    n4 = n6;
                    locationSettingsStates2 = locationSettingsStates3;
                    break;
                }
                case 2: {
                    locationSettingsStates2 = (LocationSettingsStates)a.a(parcel, n5, LocationSettingsStates.CREATOR);
                    status2 = status;
                    n4 = n3;
                }
            }
            n3 = n4;
            status = status2;
            locationSettingsStates = locationSettingsStates2;
        } while (true);
    }

    public LocationSettingsResult[] a(int n2) {
        return new LocationSettingsResult[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

