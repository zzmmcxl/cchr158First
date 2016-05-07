/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.credentials.internal.GeneratePasswordRequest;
import com.google.android.gms.auth.api.credentials.j;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class d
implements Parcelable.Creator {
    static void a(GeneratePasswordRequest generatePasswordRequest, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, generatePasswordRequest.a(), n2, false);
        c.a(parcel, 1000, generatePasswordRequest.a);
        c.a(parcel, n3);
    }

    public GeneratePasswordRequest a(Parcel parcel) {
        int n2 = a.b(parcel);
        int n3 = 0;
        PasswordSpecification passwordSpecification = null;
        block4 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new GeneratePasswordRequest(n3, passwordSpecification);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block4;
                }
                case 1: {
                    passwordSpecification = (PasswordSpecification)a.a(parcel, n4, PasswordSpecification.CREATOR);
                    continue block4;
                }
                case 1000: 
            }
            n3 = a.e(parcel, n4);
        } while (true);
    }

    public GeneratePasswordRequest[] a(int n2) {
        return new GeneratePasswordRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

