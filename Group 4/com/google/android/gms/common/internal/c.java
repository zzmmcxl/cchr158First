/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ValidateAccountRequest;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
implements Parcelable.Creator {
    static void a(ValidateAccountRequest validateAccountRequest, Parcel parcel, int n2) {
        int n3 = com.google.android.gms.common.internal.safeparcel.c.a(parcel);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 1, validateAccountRequest.a);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, validateAccountRequest.a());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 3, validateAccountRequest.b, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 4, validateAccountRequest.b(), n2, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 5, validateAccountRequest.d(), false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 6, validateAccountRequest.c(), false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, n3);
    }

    public ValidateAccountRequest a(Parcel parcel) {
        int n2 = 0;
        String string = null;
        int n3 = a.b(parcel);
        Bundle bundle = null;
        Scope[] arrscope = null;
        IBinder iBinder = null;
        int n4 = 0;
        block8 : do {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new ValidateAccountRequest(n4, n2, iBinder, arrscope, bundle, string);
                throw new b("Overread allowed size end=" + n3, parcel);
            }
            int n5 = a.a(parcel);
            switch (a.a(n5)) {
                default: {
                    a.b(parcel, n5);
                    continue block8;
                }
                case 1: {
                    n4 = a.e(parcel, n5);
                    continue block8;
                }
                case 2: {
                    n2 = a.e(parcel, n5);
                    continue block8;
                }
                case 3: {
                    iBinder = a.m(parcel, n5);
                    continue block8;
                }
                case 4: {
                    arrscope = (Scope[])a.b(parcel, n5, Scope.CREATOR);
                    continue block8;
                }
                case 5: {
                    bundle = a.n(parcel, n5);
                    continue block8;
                }
                case 6: 
            }
            string = a.l(parcel, n5);
        } while (true);
    }

    public ValidateAccountRequest[] a(int n2) {
        return new ValidateAccountRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

