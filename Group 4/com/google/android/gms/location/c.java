/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.location.DetectedActivity;

public class c
implements Parcelable.Creator {
    static void a(DetectedActivity detectedActivity, Parcel parcel, int n2) {
        int n3 = com.google.android.gms.common.internal.safeparcel.c.a(parcel);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 1, detectedActivity.c);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 1000, detectedActivity.c());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, detectedActivity.d);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, n3);
    }

    public DetectedActivity a(Parcel parcel) {
        int n2 = 0;
        int n3 = a.b(parcel);
        int n4 = 0;
        int n5 = 0;
        block5 : do {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new DetectedActivity(n5, n4, n2);
                throw new b("Overread allowed size end=" + n3, parcel);
            }
            int n6 = a.a(parcel);
            switch (a.a(n6)) {
                default: {
                    a.b(parcel, n6);
                    continue block5;
                }
                case 1: {
                    n4 = a.e(parcel, n6);
                    continue block5;
                }
                case 1000: {
                    n5 = a.e(parcel, n6);
                    continue block5;
                }
                case 2: 
            }
            n2 = a.e(parcel, n6);
        } while (true);
    }

    public DetectedActivity[] a(int n2) {
        return new DetectedActivity[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

