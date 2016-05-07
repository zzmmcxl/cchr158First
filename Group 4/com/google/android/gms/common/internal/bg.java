/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class bg
implements Parcelable.Creator {
    static void a(ResolveAccountRequest resolveAccountRequest, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, resolveAccountRequest.a);
        c.a(parcel, 2, (Parcelable)resolveAccountRequest.a(), n2, false);
        c.a(parcel, 3, resolveAccountRequest.b());
        c.a(parcel, 4, resolveAccountRequest.c(), n2, false);
        c.a(parcel, n3);
    }

    public ResolveAccountRequest a(Parcel parcel) {
        GoogleSignInAccount googleSignInAccount = null;
        int n2 = 0;
        int n3 = a.b(parcel);
        Account account = null;
        int n4 = 0;
        do {
            GoogleSignInAccount googleSignInAccount2;
            int n5;
            Account account2;
            int n6;
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new ResolveAccountRequest(n4, account, n2, googleSignInAccount);
                throw new b("Overread allowed size end=" + n3, parcel);
            }
            int n7 = a.a(parcel);
            switch (a.a(n7)) {
                default: {
                    a.b(parcel, n7);
                    googleSignInAccount2 = googleSignInAccount;
                    n5 = n2;
                    account2 = account;
                    n6 = n4;
                    break;
                }
                case 1: {
                    int n8 = a.e(parcel, n7);
                    GoogleSignInAccount googleSignInAccount3 = googleSignInAccount;
                    n5 = n2;
                    account2 = account;
                    n6 = n8;
                    googleSignInAccount2 = googleSignInAccount3;
                    break;
                }
                case 2: {
                    Account account3 = (Account)a.a(parcel, n7, Account.CREATOR);
                    n6 = n4;
                    int n9 = n2;
                    account2 = account3;
                    googleSignInAccount2 = googleSignInAccount;
                    n5 = n9;
                    break;
                }
                case 3: {
                    int n10 = a.e(parcel, n7);
                    account2 = account;
                    n6 = n4;
                    GoogleSignInAccount googleSignInAccount4 = googleSignInAccount;
                    n5 = n10;
                    googleSignInAccount2 = googleSignInAccount4;
                    break;
                }
                case 4: {
                    googleSignInAccount2 = (GoogleSignInAccount)a.a(parcel, n7, GoogleSignInAccount.CREATOR);
                    n5 = n2;
                    account2 = account;
                    n6 = n4;
                }
            }
            n4 = n6;
            account = account2;
            n2 = n5;
            googleSignInAccount = googleSignInAccount2;
        } while (true);
    }

    public ResolveAccountRequest[] a(int n2) {
        return new ResolveAccountRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

