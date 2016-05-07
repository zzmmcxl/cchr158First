/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.signin.internal.j;

public class RecordConsentRequest
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new j();
    final int a;
    private final Account b;
    private final Scope[] c;
    private final String d;

    RecordConsentRequest(int n2, Account account, Scope[] arrscope, String string) {
        this.a = n2;
        this.b = account;
        this.c = arrscope;
        this.d = string;
    }

    public Account a() {
        return this.b;
    }

    public Scope[] b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        j.a(this, parcel, n2);
    }
}

