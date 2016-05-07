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
import com.google.android.gms.common.internal.a;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.aq;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.common.j;
import java.util.Collection;

public class GetServiceRequest
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new x();
    final int a;
    final int b;
    int c;
    String d;
    IBinder e;
    Scope[] f;
    Bundle g;
    Account h;

    public GetServiceRequest(int n2) {
        this.a = 2;
        this.c = j.b;
        this.b = n2;
    }

    GetServiceRequest(int n2, int n3, int n4, String string, IBinder iBinder, Scope[] arrscope, Bundle bundle, Account account) {
        this.a = n2;
        this.b = n3;
        this.c = n4;
        this.d = string;
        if (n2 < 2) {
            this.h = this.a(iBinder);
        } else {
            this.e = iBinder;
            this.h = account;
        }
        this.f = arrscope;
        this.g = bundle;
    }

    private Account a(IBinder iBinder) {
        Account account = null;
        if (iBinder == null) return account;
        return a.a(aq.a(iBinder));
    }

    public GetServiceRequest a(Account account) {
        this.h = account;
        return this;
    }

    public GetServiceRequest a(Bundle bundle) {
        this.g = bundle;
        return this;
    }

    public GetServiceRequest a(ap ap2) {
        if (ap2 == null) return this;
        this.e = ap2.asBinder();
        return this;
    }

    public GetServiceRequest a(String string) {
        this.d = string;
        return this;
    }

    public GetServiceRequest a(Collection collection) {
        this.f = collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        x.a(this, parcel, n2);
    }
}

