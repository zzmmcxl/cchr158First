/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.firstparty.shared.FACLConfig;
import com.google.android.gms.auth.firstparty.shared.FACLData;
import com.google.android.gms.auth.firstparty.shared.a;
import com.google.android.gms.common.internal.safeparcel.c;

public class b
implements Parcelable.Creator {
    static void a(FACLData fACLData, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, fACLData.a);
        c.a(parcel, 2, fACLData.b, n2, false);
        c.a(parcel, 3, fACLData.c, false);
        c.a(parcel, 4, fACLData.d);
        c.a(parcel, 5, fACLData.e, false);
        c.a(parcel, n3);
    }

    public FACLData a(Parcel parcel) {
        boolean bl2 = false;
        String string = null;
        int n2 = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        String string2 = null;
        FACLConfig fACLConfig = null;
        int n3 = 0;
        block7 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new FACLData(n3, fACLConfig, string2, bl2, string);
                throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(n4)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, n4);
                    continue block7;
                }
                case 1: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, n4);
                    continue block7;
                }
                case 2: {
                    fACLConfig = (FACLConfig)com.google.android.gms.common.internal.safeparcel.a.a(parcel, n4, FACLConfig.CREATOR);
                    continue block7;
                }
                case 3: {
                    string2 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, n4);
                    continue block7;
                }
                case 4: {
                    bl2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, n4);
                    continue block7;
                }
                case 5: 
            }
            string = com.google.android.gms.common.internal.safeparcel.a.l(parcel, n4);
        } while (true);
    }

    public FACLData[] a(int n2) {
        return new FACLData[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

