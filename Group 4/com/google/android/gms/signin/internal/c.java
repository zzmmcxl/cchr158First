/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.signin.internal.CheckServerAuthResult;
import java.util.ArrayList;
import java.util.List;

public class c
implements Parcelable.Creator {
    static void a(CheckServerAuthResult checkServerAuthResult, Parcel parcel, int n2) {
        int n3 = com.google.android.gms.common.internal.safeparcel.c.a(parcel);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 1, checkServerAuthResult.a);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, checkServerAuthResult.b);
        com.google.android.gms.common.internal.safeparcel.c.c(parcel, 3, checkServerAuthResult.c, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, n3);
    }

    public CheckServerAuthResult a(Parcel parcel) {
        boolean bl2 = false;
        int n2 = a.b(parcel);
        ArrayList arrayList = null;
        int n3 = 0;
        block5 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new CheckServerAuthResult(n3, bl2, arrayList);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block5;
                }
                case 1: {
                    n3 = a.e(parcel, n4);
                    continue block5;
                }
                case 2: {
                    bl2 = a.c(parcel, n4);
                    continue block5;
                }
                case 3: 
            }
            arrayList = a.c(parcel, n4, Scope.CREATOR);
        } while (true);
    }

    public CheckServerAuthResult[] a(int n2) {
        return new CheckServerAuthResult[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

