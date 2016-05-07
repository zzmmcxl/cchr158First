/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.location.internal.ClientIdentity;

public class c
implements Parcelable.Creator {
    static void a(ClientIdentity clientIdentity, Parcel parcel, int n2) {
        int n3 = com.google.android.gms.common.internal.safeparcel.c.a(parcel);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 1, clientIdentity.a);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 1000, clientIdentity.a());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, clientIdentity.b, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, n3);
    }

    public ClientIdentity a(Parcel parcel) {
        int n2 = 0;
        int n3 = a.b(parcel);
        String string = null;
        int n4 = 0;
        block5 : do {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new ClientIdentity(n4, n2, string);
                throw new b("Overread allowed size end=" + n3, parcel);
            }
            int n5 = a.a(parcel);
            switch (a.a(n5)) {
                default: {
                    a.b(parcel, n5);
                    continue block5;
                }
                case 1: {
                    n2 = a.e(parcel, n5);
                    continue block5;
                }
                case 1000: {
                    n4 = a.e(parcel, n5);
                    continue block5;
                }
                case 2: 
            }
            string = a.l(parcel, n5);
        } while (true);
    }

    public ClientIdentity[] a(int n2) {
        return new ClientIdentity[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

