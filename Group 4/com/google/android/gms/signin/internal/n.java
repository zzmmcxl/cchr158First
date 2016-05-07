/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.signin.internal.SignInResponse;

public class n
implements Parcelable.Creator {
    static void a(SignInResponse signInResponse, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, signInResponse.a);
        c.a(parcel, 2, signInResponse.a(), n2, false);
        c.a(parcel, 3, signInResponse.b(), n2, false);
        c.a(parcel, n3);
    }

    public SignInResponse a(Parcel parcel) {
        ResolveAccountResponse resolveAccountResponse = null;
        int n2 = a.b(parcel);
        int n3 = 0;
        ConnectionResult connectionResult = null;
        do {
            ConnectionResult connectionResult2;
            ResolveAccountResponse resolveAccountResponse2;
            int n4;
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new SignInResponse(n3, connectionResult, resolveAccountResponse);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n5 = a.a(parcel);
            switch (a.a(n5)) {
                default: {
                    a.b(parcel, n5);
                    resolveAccountResponse2 = resolveAccountResponse;
                    connectionResult2 = connectionResult;
                    n4 = n3;
                    break;
                }
                case 1: {
                    int n6 = a.e(parcel, n5);
                    ResolveAccountResponse resolveAccountResponse3 = resolveAccountResponse;
                    connectionResult2 = connectionResult;
                    n4 = n6;
                    resolveAccountResponse2 = resolveAccountResponse3;
                    break;
                }
                case 2: {
                    ConnectionResult connectionResult3 = (ConnectionResult)a.a(parcel, n5, ConnectionResult.CREATOR);
                    n4 = n3;
                    resolveAccountResponse2 = resolveAccountResponse;
                    connectionResult2 = connectionResult3;
                    break;
                }
                case 3: {
                    resolveAccountResponse2 = (ResolveAccountResponse)a.a(parcel, n5, ResolveAccountResponse.CREATOR);
                    connectionResult2 = connectionResult;
                    n4 = n3;
                }
            }
            n3 = n4;
            connectionResult = connectionResult2;
            resolveAccountResponse = resolveAccountResponse2;
        } while (true);
    }

    public SignInResponse[] a(int n2) {
        return new SignInResponse[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

