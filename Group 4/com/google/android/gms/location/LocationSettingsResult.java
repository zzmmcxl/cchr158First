/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.w;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.LocationSettingsStates;
import com.google.android.gms.location.ab;

public final class LocationSettingsResult
implements w,
SafeParcelable {
    public static final Parcelable.Creator CREATOR = new ab();
    private final int a;
    private final Status b;
    private final LocationSettingsStates c;

    LocationSettingsResult(int n2, Status status, LocationSettingsStates locationSettingsStates) {
        this.a = n2;
        this.b = status;
        this.c = locationSettingsStates;
    }

    @Override
    public Status a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }

    public LocationSettingsStates c() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        ab.a(this, parcel, n2);
    }
}

