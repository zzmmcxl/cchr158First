package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LandmarkParcel implements SafeParcelable {
    public static final zze CREATOR;
    public final int type;
    public final int versionCode;
    public final float f26x;
    public final float f27y;

    static {
        CREATOR = new zze();
    }

    public LandmarkParcel(int versionCode, float x, float y, int type) {
        this.versionCode = versionCode;
        this.f26x = x;
        this.f27y = y;
        this.type = type;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zze.zza(this, parcel, flags);
    }
}
