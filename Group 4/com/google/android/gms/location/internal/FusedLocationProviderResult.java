/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.w;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.internal.e;

public final class FusedLocationProviderResult
implements w,
SafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public static final FusedLocationProviderResult a;
    private final int b;
    private final Status c;

    static {
        a = new FusedLocationProviderResult(Status.a);
        CREATOR = new e();
    }

    FusedLocationProviderResult(int n2, Status status) {
        this.b = n2;
        this.c = status;
    }

    public FusedLocationProviderResult(Status status) {
        this(1, status);
    }

    @Override
    public Status a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        e.a(this, parcel, n2);
    }
}

