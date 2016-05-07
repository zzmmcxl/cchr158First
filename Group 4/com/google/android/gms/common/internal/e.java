/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class e
implements Parcelable.Creator {
    static void a(AuthAccountRequest authAccountRequest, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, authAccountRequest.a);
        c.a(parcel, 2, authAccountRequest.b, false);
        c.a(parcel, 3, authAccountRequest.c, n2, false);
        c.a(parcel, 4, authAccountRequest.d, false);
        c.a(parcel, 5, authAccountRequest.e, false);
        c.a(parcel, n3);
    }

    public AuthAccountRequest a(Parcel parcel) {
        Integer n2 = null;
        int n3 = a.b(parcel);
        int n4 = 0;
        Integer n5 = null;
        Scope[] arrscope = null;
        IBinder iBinder = null;
        block7 : do {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new AuthAccountRequest(n4, iBinder, arrscope, n5, n2);
                throw new b("Overread allowed size end=" + n3, parcel);
            }
            int n6 = a.a(parcel);
            switch (a.a(n6)) {
                default: {
                    a.b(parcel, n6);
                    continue block7;
                }
                case 1: {
                    n4 = a.e(parcel, n6);
                    continue block7;
                }
                case 2: {
                    iBinder = a.m(parcel, n6);
                    continue block7;
                }
                case 3: {
                    arrscope = (Scope[])a.b(parcel, n6, Scope.CREATOR);
                    continue block7;
                }
                case 4: {
                    n5 = a.f(parcel, n6);
                    continue block7;
                }
                case 5: 
            }
            n2 = a.f(parcel, n6);
        } while (true);
    }

    public AuthAccountRequest[] a(int n2) {
        return new AuthAccountRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

