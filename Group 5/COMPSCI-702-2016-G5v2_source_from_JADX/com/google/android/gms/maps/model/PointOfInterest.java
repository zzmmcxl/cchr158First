package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class PointOfInterest implements SafeParcelable {
    public static final zzg CREATOR;
    private final int mVersionCode;
    public final String name;
    public final LatLng zzaTG;
    public final String zzaTH;

    static {
        CREATOR = new zzg();
    }

    PointOfInterest(int versionCode, LatLng latLng, String placeId, String name) {
        this.mVersionCode = versionCode;
        this.zzaTG = latLng;
        this.zzaTH = placeId;
        this.name = name;
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzg.zza(this, out, flags);
    }
}
