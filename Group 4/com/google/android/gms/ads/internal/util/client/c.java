/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
implements Parcelable.Creator {
    static void a(VersionInfoParcel versionInfoParcel, Parcel parcel, int n2) {
        int n3 = com.google.android.gms.common.internal.safeparcel.c.a(parcel);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 1, versionInfoParcel.a);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, versionInfoParcel.b, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 3, versionInfoParcel.c);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 4, versionInfoParcel.d);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 5, versionInfoParcel.e);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, n3);
    }

    public VersionInfoParcel a(Parcel parcel) {
        boolean bl2 = false;
        int n2 = a.b(parcel);
        String string = null;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        block7 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new VersionInfoParcel(n5, string, n4, n3, bl2);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n6 = a.a(parcel);
            switch (a.a(n6)) {
                default: {
                    a.b(parcel, n6);
                    continue block7;
                }
                case 1: {
                    n5 = a.e(parcel, n6);
                    continue block7;
                }
                case 2: {
                    string = a.l(parcel, n6);
                    continue block7;
                }
                case 3: {
                    n4 = a.e(parcel, n6);
                    continue block7;
                }
                case 4: {
                    n3 = a.e(parcel, n6);
                    continue block7;
                }
                case 5: 
            }
            bl2 = a.c(parcel, n6);
        } while (true);
    }

    public VersionInfoParcel[] a(int n2) {
        return new VersionInfoParcel[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

