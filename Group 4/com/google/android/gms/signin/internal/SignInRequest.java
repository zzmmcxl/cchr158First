/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.signin.internal.m;

public class SignInRequest
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new m();
    final int a;
    final ResolveAccountRequest b;

    SignInRequest(int n2, ResolveAccountRequest resolveAccountRequest) {
        this.a = n2;
        this.b = resolveAccountRequest;
    }

    public SignInRequest(ResolveAccountRequest resolveAccountRequest) {
        this(1, resolveAccountRequest);
    }

    public ResolveAccountRequest a() {
        return this.b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        m.a(this, parcel, n2);
    }
}

