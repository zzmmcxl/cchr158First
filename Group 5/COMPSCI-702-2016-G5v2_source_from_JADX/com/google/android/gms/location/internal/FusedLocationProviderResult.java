package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class FusedLocationProviderResult implements Result, SafeParcelable {
    public static final Creator<FusedLocationProviderResult> CREATOR;
    public static final FusedLocationProviderResult zzaOC;
    private final int mVersionCode;
    private final Status zzUX;

    static {
        zzaOC = new FusedLocationProviderResult(Status.zzagC);
        CREATOR = new zze();
    }

    FusedLocationProviderResult(int version, Status status) {
        this.mVersionCode = version;
        this.zzUX = status;
    }

    public FusedLocationProviderResult(Status status) {
        this(1, status);
    }

    public int describeContents() {
        return 0;
    }

    public Status getStatus() {
        return this.zzUX;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }
}
