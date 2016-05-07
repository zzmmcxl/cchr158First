/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.w;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.signin.internal.a;

public class AuthAccountResult
implements w,
SafeParcelable {
    public static final Parcelable.Creator CREATOR = new a();
    final int a;
    private int b;
    private Intent c;

    public AuthAccountResult() {
        this(0, null);
    }

    AuthAccountResult(int n2, int n3, Intent intent) {
        this.a = n2;
        this.b = n3;
        this.c = intent;
    }

    public AuthAccountResult(int n2, Intent intent) {
        this(2, n2, intent);
    }

    @Override
    public Status a() {
        if (this.b != 0) return Status.e;
        return Status.a;
    }

    public int b() {
        return this.b;
    }

    public Intent c() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        a.a(this, parcel, n2);
    }
}

