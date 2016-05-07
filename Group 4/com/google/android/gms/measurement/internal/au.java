/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.measurement.internal.EventParams;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.at;

public class au
implements Parcelable.Creator {
    static void a(EventParcel eventParcel, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, eventParcel.a);
        c.a(parcel, 2, eventParcel.b, false);
        c.a(parcel, 3, eventParcel.c, n2, false);
        c.a(parcel, 4, eventParcel.d, false);
        c.a(parcel, 5, eventParcel.e);
        c.a(parcel, n3);
    }

    public EventParcel a(Parcel parcel) {
        String string = null;
        int n2 = a.b(parcel);
        int n3 = 0;
        long l2 = 0;
        EventParams eventParams = null;
        String string2 = null;
        block7 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new EventParcel(n3, string2, eventParams, string, l2);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block7;
                }
                case 1: {
                    n3 = a.e(parcel, n4);
                    continue block7;
                }
                case 2: {
                    string2 = a.l(parcel, n4);
                    continue block7;
                }
                case 3: {
                    eventParams = (EventParams)a.a(parcel, n4, EventParams.CREATOR);
                    continue block7;
                }
                case 4: {
                    string = a.l(parcel, n4);
                    continue block7;
                }
                case 5: 
            }
            l2 = a.g(parcel, n4);
        } while (true);
    }

    public EventParcel[] a(int n2) {
        return new EventParcel[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

