/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.consent;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.consent.b;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetConsentIntentRequest
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new b();
    final ScopeDetail[] a;
    private final int b;
    private final String c;
    private final int d;
    private final String e;
    private final Account f;
    private final boolean g;
    private final int h;
    private final String i;

    GetConsentIntentRequest(int n2, String string, int n3, String string2, Account account, ScopeDetail[] arrscopeDetail, boolean bl2, int n4, String string3) {
        this.b = n2;
        this.c = string;
        this.d = n3;
        this.e = string2;
        this.f = (Account)bf.a((Object)account);
        this.a = arrscopeDetail;
        this.g = bl2;
        this.h = n4;
        this.i = string3;
    }

    public int a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public Account e() {
        return this.f;
    }

    public boolean f() {
        return this.g;
    }

    public int g() {
        return this.h;
    }

    public String h() {
        return this.i;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        b.a(this, parcel, n2);
    }
}

