/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.bg;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ResolveAccountRequest
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new bg();
    final int a;
    private final Account b;
    private final int c;
    private final GoogleSignInAccount d;

    ResolveAccountRequest(int n2, Account account, int n3, GoogleSignInAccount googleSignInAccount) {
        this.a = n2;
        this.b = account;
        this.c = n3;
        this.d = googleSignInAccount;
    }

    public ResolveAccountRequest(Account account, int n2, GoogleSignInAccount googleSignInAccount) {
        this(2, account, n2, googleSignInAccount);
    }

    public Account a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    public GoogleSignInAccount c() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        bg.a(this, parcel, n2);
    }
}

