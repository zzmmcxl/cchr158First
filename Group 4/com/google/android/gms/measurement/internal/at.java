/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.measurement.internal.EventParams;

public class at
implements Parcelable.Creator {
    static void a(EventParams eventParams, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, eventParams.a);
        c.a(parcel, 2, eventParams.b(), false);
        c.a(parcel, n3);
    }

    public EventParams a(Parcel parcel) {
        int n2 = a.b(parcel);
        int n3 = 0;
        Bundle bundle = null;
        block4 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new EventParams(n3, bundle);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block4;
                }
                case 1: {
                    n3 = a.e(parcel, n4);
                    continue block4;
                }
                case 2: 
            }
            bundle = a.n(parcel, n4);
        } while (true);
    }

    public EventParams[] a(int n2) {
        return new EventParams[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

