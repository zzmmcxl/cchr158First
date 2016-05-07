/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.IdToken;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class i
implements Parcelable.Creator {
    static void a(IdToken idToken, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, idToken.a(), false);
        c.a(parcel, 1000, idToken.a);
        c.a(parcel, 2, idToken.b(), false);
        c.a(parcel, n3);
    }

    public IdToken a(Parcel parcel) {
        String string = null;
        int n2 = a.b(parcel);
        int n3 = 0;
        String string2 = null;
        block5 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new IdToken(n3, string2, string);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block5;
                }
                case 1: {
                    string2 = a.l(parcel, n4);
                    continue block5;
                }
                case 1000: {
                    n3 = a.e(parcel, n4);
                    continue block5;
                }
                case 2: 
            }
            string = a.l(parcel, n4);
        } while (true);
    }

    public IdToken[] a(int n2) {
        return new IdToken[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

