/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.location.internal.LocationRequestInternal;
import com.google.android.gms.location.internal.LocationRequestUpdateData;
import com.google.android.gms.location.internal.z;

public class aa
implements Parcelable.Creator {
    static void a(LocationRequestUpdateData locationRequestUpdateData, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, locationRequestUpdateData.a);
        c.a(parcel, 1000, locationRequestUpdateData.a());
        c.a(parcel, 2, locationRequestUpdateData.b, n2, false);
        c.a(parcel, 3, locationRequestUpdateData.b(), false);
        c.a(parcel, 4, (Parcelable)locationRequestUpdateData.d, n2, false);
        c.a(parcel, 5, locationRequestUpdateData.c(), false);
        c.a(parcel, 6, locationRequestUpdateData.d(), false);
        c.a(parcel, n3);
    }

    public LocationRequestUpdateData a(Parcel parcel) {
        IBinder iBinder = null;
        int n2 = a.b(parcel);
        int n3 = 0;
        int n4 = 1;
        IBinder iBinder2 = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder3 = null;
        LocationRequestInternal locationRequestInternal = null;
        block9 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new LocationRequestUpdateData(n3, n4, locationRequestInternal, iBinder3, pendingIntent, iBinder2, iBinder);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n5 = a.a(parcel);
            switch (a.a(n5)) {
                default: {
                    a.b(parcel, n5);
                    continue block9;
                }
                case 1: {
                    n4 = a.e(parcel, n5);
                    continue block9;
                }
                case 1000: {
                    n3 = a.e(parcel, n5);
                    continue block9;
                }
                case 2: {
                    locationRequestInternal = (LocationRequestInternal)a.a(parcel, n5, LocationRequestInternal.CREATOR);
                    continue block9;
                }
                case 3: {
                    iBinder3 = a.m(parcel, n5);
                    continue block9;
                }
                case 4: {
                    pendingIntent = (PendingIntent)a.a(parcel, n5, PendingIntent.CREATOR);
                    continue block9;
                }
                case 5: {
                    iBinder2 = a.m(parcel, n5);
                    continue block9;
                }
                case 6: 
            }
            iBinder = a.m(parcel, n5);
        } while (true);
    }

    public LocationRequestUpdateData[] a(int n2) {
        return new LocationRequestUpdateData[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

