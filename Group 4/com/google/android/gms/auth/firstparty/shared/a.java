/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.firstparty.shared.FACLConfig;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class a
implements Parcelable.Creator {
    static void a(FACLConfig fACLConfig, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, fACLConfig.a);
        c.a(parcel, 2, fACLConfig.b);
        c.a(parcel, 3, fACLConfig.c, false);
        c.a(parcel, 4, fACLConfig.d);
        c.a(parcel, 5, fACLConfig.e);
        c.a(parcel, 6, fACLConfig.f);
        c.a(parcel, 7, fACLConfig.g);
        c.a(parcel, n3);
    }

    public FACLConfig a(Parcel parcel) {
        boolean bl2 = false;
        int n2 = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        String string = null;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = false;
        int n3 = 0;
        block9 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new FACLConfig(n3, bl6, string, bl5, bl4, bl3, bl2);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(n4)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, n4);
                    continue block9;
                }
                case 1: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, n4);
                    continue block9;
                }
                case 2: {
                    bl6 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, n4);
                    continue block9;
                }
                case 3: {
                    string = com.google.android.gms.common.internal.safeparcel.a.l(parcel, n4);
                    continue block9;
                }
                case 4: {
                    bl5 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, n4);
                    continue block9;
                }
                case 5: {
                    bl4 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, n4);
                    continue block9;
                }
                case 6: {
                    bl3 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, n4);
                    continue block9;
                }
                case 7: 
            }
            bl2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, n4);
        } while (true);
    }

    public FACLConfig[] a(int n2) {
        return new FACLConfig[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

