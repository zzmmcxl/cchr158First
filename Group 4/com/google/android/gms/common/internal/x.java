/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class x
implements Parcelable.Creator {
    static void a(GetServiceRequest getServiceRequest, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, getServiceRequest.a);
        c.a(parcel, 2, getServiceRequest.b);
        c.a(parcel, 3, getServiceRequest.c);
        c.a(parcel, 4, getServiceRequest.d, false);
        c.a(parcel, 5, getServiceRequest.e, false);
        c.a(parcel, 6, getServiceRequest.f, n2, false);
        c.a(parcel, 7, getServiceRequest.g, false);
        c.a(parcel, 8, (Parcelable)getServiceRequest.h, n2, false);
        c.a(parcel, n3);
    }

    public GetServiceRequest a(Parcel parcel) {
        int n2 = 0;
        Account account = null;
        int n3 = a.b(parcel);
        Bundle bundle = null;
        Scope[] arrscope = null;
        IBinder iBinder = null;
        String string = null;
        int n4 = 0;
        int n5 = 0;
        block10 : do {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new GetServiceRequest(n5, n4, n2, string, iBinder, arrscope, bundle, account);
                throw new b("Overread allowed size end=" + n3, parcel);
            }
            int n6 = a.a(parcel);
            switch (a.a(n6)) {
                default: {
                    a.b(parcel, n6);
                    continue block10;
                }
                case 1: {
                    n5 = a.e(parcel, n6);
                    continue block10;
                }
                case 2: {
                    n4 = a.e(parcel, n6);
                    continue block10;
                }
                case 3: {
                    n2 = a.e(parcel, n6);
                    continue block10;
                }
                case 4: {
                    string = a.l(parcel, n6);
                    continue block10;
                }
                case 5: {
                    iBinder = a.m(parcel, n6);
                    continue block10;
                }
                case 6: {
                    arrscope = (Scope[])a.b(parcel, n6, Scope.CREATOR);
                    continue block10;
                }
                case 7: {
                    bundle = a.n(parcel, n6);
                    continue block10;
                }
                case 8: 
            }
            account = (Account)a.a(parcel, n6, Account.CREATOR);
        } while (true);
    }

    public GetServiceRequest[] a(int n2) {
        return new GetServiceRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

