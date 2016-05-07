/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class bh
implements Parcelable.Creator {
    static void a(ResolveAccountResponse resolveAccountResponse, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, resolveAccountResponse.a);
        c.a(parcel, 2, resolveAccountResponse.b, false);
        c.a(parcel, 3, resolveAccountResponse.b(), n2, false);
        c.a(parcel, 4, resolveAccountResponse.c());
        c.a(parcel, 5, resolveAccountResponse.d());
        c.a(parcel, n3);
    }

    public ResolveAccountResponse a(Parcel parcel) {
        ConnectionResult connectionResult = null;
        boolean bl2 = false;
        int n2 = a.b(parcel);
        boolean bl3 = false;
        IBinder iBinder = null;
        int n3 = 0;
        block7 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new ResolveAccountResponse(n3, iBinder, connectionResult, bl3, bl2);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block7;
                }
                case 1: {
                    n3 = a.e(parcel, n4);
                    continue block7;
                }
                case 2: {
                    iBinder = a.m(parcel, n4);
                    continue block7;
                }
                case 3: {
                    connectionResult = (ConnectionResult)a.a(parcel, n4, ConnectionResult.CREATOR);
                    continue block7;
                }
                case 4: {
                    bl3 = a.c(parcel, n4);
                    continue block7;
                }
                case 5: 
            }
            bl2 = a.c(parcel, n4);
        } while (true);
    }

    public ResolveAccountResponse[] a(int n2) {
        return new ResolveAccountResponse[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

