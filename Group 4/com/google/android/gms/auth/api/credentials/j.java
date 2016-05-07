/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;
import java.util.List;

public class j
implements Parcelable.Creator {
    static void a(PasswordSpecification passwordSpecification, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, passwordSpecification.d, false);
        c.a(parcel, 1000, passwordSpecification.c);
        c.b(parcel, 2, passwordSpecification.e, false);
        c.a(parcel, 3, passwordSpecification.f, false);
        c.a(parcel, 4, passwordSpecification.g);
        c.a(parcel, 5, passwordSpecification.h);
        c.a(parcel, n3);
    }

    public PasswordSpecification a(Parcel parcel) {
        ArrayList arrayList = null;
        int n2 = 0;
        int n3 = a.b(parcel);
        int n4 = 0;
        ArrayList arrayList2 = null;
        String string = null;
        int n5 = 0;
        block8 : do {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new PasswordSpecification(n5, string, arrayList2, arrayList, n4, n2);
                throw new b("Overread allowed size end=" + n3, parcel);
            }
            int n6 = a.a(parcel);
            switch (a.a(n6)) {
                default: {
                    a.b(parcel, n6);
                    continue block8;
                }
                case 1: {
                    string = a.l(parcel, n6);
                    continue block8;
                }
                case 1000: {
                    n5 = a.e(parcel, n6);
                    continue block8;
                }
                case 2: {
                    arrayList2 = a.r(parcel, n6);
                    continue block8;
                }
                case 3: {
                    arrayList = a.q(parcel, n6);
                    continue block8;
                }
                case 4: {
                    n4 = a.e(parcel, n6);
                    continue block8;
                }
                case 5: 
            }
            n2 = a.e(parcel, n6);
        } while (true);
    }

    public PasswordSpecification[] a(int n2) {
        return new PasswordSpecification[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

