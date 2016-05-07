/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.signin.internal.AuthAccountResult;

public class a
implements Parcelable.Creator {
    static void a(AuthAccountResult authAccountResult, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, authAccountResult.a);
        c.a(parcel, 2, authAccountResult.b());
        c.a(parcel, 3, (Parcelable)authAccountResult.c(), n2, false);
        c.a(parcel, n3);
    }

    public AuthAccountResult a(Parcel parcel) {
        int n2 = 0;
        int n3 = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        Intent intent = null;
        int n4 = 0;
        block5 : do {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new AuthAccountResult(n4, n2, intent);
                throw new b("Overread allowed size end=" + n3, parcel);
            }
            int n5 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(n5)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, n5);
                    continue block5;
                }
                case 1: {
                    n4 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, n5);
                    continue block5;
                }
                case 2: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, n5);
                    continue block5;
                }
                case 3: 
            }
            intent = (Intent)com.google.android.gms.common.internal.safeparcel.a.a(parcel, n5, Intent.CREATOR);
        } while (true);
    }

    public AuthAccountResult[] a(int n2) {
        return new AuthAccountResult[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

