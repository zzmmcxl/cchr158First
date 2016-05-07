/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.consent;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.consent.GetConsentIntentRequest;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

public class b
implements Parcelable.Creator {
    static void a(GetConsentIntentRequest getConsentIntentRequest, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, getConsentIntentRequest.a());
        c.a(parcel, 2, getConsentIntentRequest.b(), false);
        c.a(parcel, 3, getConsentIntentRequest.c());
        c.a(parcel, 4, getConsentIntentRequest.d(), false);
        c.a(parcel, 5, (Parcelable)getConsentIntentRequest.e(), n2, false);
        c.a(parcel, 6, getConsentIntentRequest.a, n2, false);
        c.a(parcel, 7, getConsentIntentRequest.f());
        c.a(parcel, 8, getConsentIntentRequest.g());
        c.a(parcel, 9, getConsentIntentRequest.h(), false);
        c.a(parcel, n3);
    }

    public GetConsentIntentRequest a(Parcel parcel) {
        int n2 = 0;
        String string = null;
        int n3 = a.b(parcel);
        boolean bl2 = false;
        ScopeDetail[] arrscopeDetail = null;
        Account account = null;
        String string2 = null;
        int n4 = 0;
        String string3 = null;
        int n5 = 0;
        block11 : do {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new GetConsentIntentRequest(n5, string3, n4, string2, account, arrscopeDetail, bl2, n2, string);
                throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + n3, parcel);
            }
            int n6 = a.a(parcel);
            switch (a.a(n6)) {
                default: {
                    a.b(parcel, n6);
                    continue block11;
                }
                case 1: {
                    n5 = a.e(parcel, n6);
                    continue block11;
                }
                case 2: {
                    string3 = a.l(parcel, n6);
                    continue block11;
                }
                case 3: {
                    n4 = a.e(parcel, n6);
                    continue block11;
                }
                case 4: {
                    string2 = a.l(parcel, n6);
                    continue block11;
                }
                case 5: {
                    account = (Account)a.a(parcel, n6, Account.CREATOR);
                    continue block11;
                }
                case 6: {
                    arrscopeDetail = (ScopeDetail[])a.b(parcel, n6, ScopeDetail.CREATOR);
                    continue block11;
                }
                case 7: {
                    bl2 = a.c(parcel, n6);
                    continue block11;
                }
                case 8: {
                    n2 = a.e(parcel, n6);
                    continue block11;
                }
                case 9: 
            }
            string = a.l(parcel, n6);
        } while (true);
    }

    public GetConsentIntentRequest[] a(int n2) {
        return new GetConsentIntentRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

