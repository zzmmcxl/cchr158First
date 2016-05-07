/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.credentials.internal.d;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class GeneratePasswordRequest
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new d();
    final int a;
    private final PasswordSpecification b;

    GeneratePasswordRequest(int n2, PasswordSpecification passwordSpecification) {
        this.a = n2;
        this.b = passwordSpecification;
    }

    public PasswordSpecification a() {
        return this.b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        d.a(this, parcel, n2);
    }
}

