/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.location.internal.FusedLocationProviderResult;

public class e
implements Parcelable.Creator {
    static void a(FusedLocationProviderResult fusedLocationProviderResult, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, fusedLocationProviderResult.a(), n2, false);
        c.a(parcel, 1000, fusedLocationProviderResult.b());
        c.a(parcel, n3);
    }

    public FusedLocationProviderResult a(Parcel parcel) {
        int n2 = a.b(parcel);
        int n3 = 0;
        Status status = null;
        block4 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new FusedLocationProviderResult(n3, status);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block4;
                }
                case 1: {
                    status = (Status)a.a(parcel, n4, Status.CREATOR);
                    continue block4;
                }
                case 1000: 
            }
            n3 = a.e(parcel, n4);
        } while (true);
    }

    public FusedLocationProviderResult[] a(int n2) {
        return new FusedLocationProviderResult[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

