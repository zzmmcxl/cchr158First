/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class t
implements Parcelable.Creator {
    static void a(IdpTokenType idpTokenType, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, idpTokenType.c);
        c.a(parcel, 2, idpTokenType.a(), false);
        c.a(parcel, n3);
    }

    public IdpTokenType a(Parcel parcel) {
        int n2 = a.b(parcel);
        int n3 = 0;
        String string = null;
        block4 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new IdpTokenType(n3, string);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block4;
                }
                case 1: {
                    n3 = a.e(parcel, n4);
                    continue block4;
                }
                case 2: 
            }
            string = a.l(parcel, n4);
        } while (true);
    }

    public IdpTokenType[] a(int n2) {
        return new IdpTokenType[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

