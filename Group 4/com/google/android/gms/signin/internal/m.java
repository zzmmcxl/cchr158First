/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.signin.internal.SignInRequest;

public class m
implements Parcelable.Creator {
    static void a(SignInRequest signInRequest, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, signInRequest.a);
        c.a(parcel, 2, signInRequest.a(), n2, false);
        c.a(parcel, n3);
    }

    public SignInRequest a(Parcel parcel) {
        int n2 = a.b(parcel);
        int n3 = 0;
        ResolveAccountRequest resolveAccountRequest = null;
        block4 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new SignInRequest(n3, resolveAccountRequest);
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
            resolveAccountRequest = (ResolveAccountRequest)a.a(parcel, n4, ResolveAccountRequest.CREATOR);
        } while (true);
    }

    public SignInRequest[] a(int n2) {
        return new SignInRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

