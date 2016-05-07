/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.measurement.internal.UserAttributeParcel;

public class ae
implements Parcelable.Creator {
    static void a(UserAttributeParcel userAttributeParcel, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, userAttributeParcel.a);
        c.a(parcel, 2, userAttributeParcel.b, false);
        c.a(parcel, 3, userAttributeParcel.c);
        c.a(parcel, 4, userAttributeParcel.d, false);
        c.a(parcel, 5, userAttributeParcel.e, false);
        c.a(parcel, 6, userAttributeParcel.f, false);
        c.a(parcel, 7, userAttributeParcel.g, false);
        c.a(parcel, n3);
    }

    public UserAttributeParcel a(Parcel parcel) {
        String string = null;
        int n2 = a.b(parcel);
        int n3 = 0;
        long l2 = 0;
        String string2 = null;
        Float f2 = null;
        Long l3 = null;
        String string3 = null;
        block9 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new UserAttributeParcel(n3, string3, l2, l3, f2, string2, string);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block9;
                }
                case 1: {
                    n3 = a.e(parcel, n4);
                    continue block9;
                }
                case 2: {
                    string3 = a.l(parcel, n4);
                    continue block9;
                }
                case 3: {
                    l2 = a.g(parcel, n4);
                    continue block9;
                }
                case 4: {
                    l3 = a.h(parcel, n4);
                    continue block9;
                }
                case 5: {
                    f2 = a.j(parcel, n4);
                    continue block9;
                }
                case 6: {
                    string2 = a.l(parcel, n4);
                    continue block9;
                }
                case 7: 
            }
            string = a.l(parcel, n4);
        } while (true);
    }

    public UserAttributeParcel[] a(int n2) {
        return new UserAttributeParcel[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

