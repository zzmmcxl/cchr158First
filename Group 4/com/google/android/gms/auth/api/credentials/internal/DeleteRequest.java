/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.internal.c;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class DeleteRequest
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new c();
    final int a;
    private final Credential b;

    DeleteRequest(int n2, Credential credential) {
        this.a = n2;
        this.b = credential;
    }

    public Credential a() {
        return this.b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        c.a(this, parcel, n2);
    }
}

