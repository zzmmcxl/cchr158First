/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class ad
implements Parcelable.Creator {
    static void a(Status status, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, status.f());
        c.a(parcel, 1000, status.d());
        c.a(parcel, 2, status.c(), false);
        c.a(parcel, 3, (Parcelable)status.b(), n2, false);
        c.a(parcel, n3);
    }

    public Status a(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int n2 = 0;
        int n3 = a.b(parcel);
        String string = null;
        int n4 = 0;
        block6 : do {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new Status(n4, n2, string, pendingIntent);
                throw new b("Overread allowed size end=" + n3, parcel);
            }
            int n5 = a.a(parcel);
            switch (a.a(n5)) {
                default: {
                    a.b(parcel, n5);
                    continue block6;
                }
                case 1: {
                    n2 = a.e(parcel, n5);
                    continue block6;
                }
                case 1000: {
                    n4 = a.e(parcel, n5);
                    continue block6;
                }
                case 2: {
                    string = a.l(parcel, n5);
                    continue block6;
                }
                case 3: 
            }
            pendingIntent = (PendingIntent)a.a(parcel, n5, PendingIntent.CREATOR);
        } while (true);
    }

    public Status[] a(int n2) {
        return new Status[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

