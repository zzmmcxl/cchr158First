/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.signin.internal.RecordConsentRequest;

public class j
implements Parcelable.Creator {
    static void a(RecordConsentRequest recordConsentRequest, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, recordConsentRequest.a);
        c.a(parcel, 2, (Parcelable)recordConsentRequest.a(), n2, false);
        c.a(parcel, 3, recordConsentRequest.b(), n2, false);
        c.a(parcel, 4, recordConsentRequest.c(), false);
        c.a(parcel, n3);
    }

    public RecordConsentRequest a(Parcel parcel) {
        String string = null;
        int n2 = a.b(parcel);
        int n3 = 0;
        Scope[] arrscope = null;
        Account account = null;
        do {
            Account account2;
            String string2;
            Scope[] arrscope2;
            int n4;
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new RecordConsentRequest(n3, account, arrscope, string);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n5 = a.a(parcel);
            switch (a.a(n5)) {
                default: {
                    a.b(parcel, n5);
                    string2 = string;
                    arrscope2 = arrscope;
                    account2 = account;
                    n4 = n3;
                    break;
                }
                case 1: {
                    int n6 = a.e(parcel, n5);
                    String string3 = string;
                    arrscope2 = arrscope;
                    account2 = account;
                    n4 = n6;
                    string2 = string3;
                    break;
                }
                case 2: {
                    Account account3 = (Account)a.a(parcel, n5, Account.CREATOR);
                    n4 = n3;
                    Scope[] arrscope3 = arrscope;
                    account2 = account3;
                    string2 = string;
                    arrscope2 = arrscope3;
                    break;
                }
                case 3: {
                    Scope[] arrscope4 = (Scope[])a.b(parcel, n5, Scope.CREATOR);
                    account2 = account;
                    n4 = n3;
                    String string4 = string;
                    arrscope2 = arrscope4;
                    string2 = string4;
                    break;
                }
                case 4: {
                    string2 = a.l(parcel, n5);
                    arrscope2 = arrscope;
                    account2 = account;
                    n4 = n3;
                }
            }
            n3 = n4;
            account = account2;
            arrscope = arrscope2;
            string = string2;
        } while (true);
    }

    public RecordConsentRequest[] a(int n2) {
        return new RecordConsentRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

