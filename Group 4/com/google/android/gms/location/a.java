/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.c;
import java.util.ArrayList;
import java.util.List;

public class a
implements Parcelable.Creator {
    static void a(ActivityRecognitionResult activityRecognitionResult, Parcel parcel, int n2) {
        int n3 = com.google.android.gms.common.internal.safeparcel.c.a(parcel);
        com.google.android.gms.common.internal.safeparcel.c.c(parcel, 1, activityRecognitionResult.a, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 1000, activityRecognitionResult.a());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, activityRecognitionResult.b);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 3, activityRecognitionResult.c);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 4, activityRecognitionResult.d);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 5, activityRecognitionResult.e, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, n3);
    }

    public ActivityRecognitionResult a(Parcel parcel) {
        long l2 = 0;
        Bundle bundle = null;
        int n2 = 0;
        int n3 = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        long l3 = l2;
        ArrayList arrayList = null;
        int n4 = 0;
        block8 : do {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new ActivityRecognitionResult(n4, arrayList, l3, l2, n2, bundle);
                throw new b("Overread allowed size end=" + n3, parcel);
            }
            int n5 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(n5)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, n5);
                    continue block8;
                }
                case 1: {
                    arrayList = com.google.android.gms.common.internal.safeparcel.a.c(parcel, n5, DetectedActivity.CREATOR);
                    continue block8;
                }
                case 1000: {
                    n4 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, n5);
                    continue block8;
                }
                case 2: {
                    l3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, n5);
                    continue block8;
                }
                case 3: {
                    l2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, n5);
                    continue block8;
                }
                case 4: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, n5);
                    continue block8;
                }
                case 5: 
            }
            bundle = com.google.android.gms.common.internal.safeparcel.a.n(parcel, n5);
        } while (true);
    }

    public ActivityRecognitionResult[] a(int n2) {
        return new ActivityRecognitionResult[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

