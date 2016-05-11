package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ConnectionConfiguration;

@Deprecated
public class GetConfigResponse implements SafeParcelable {
    public static final Creator<GetConfigResponse> CREATOR;
    public final int statusCode;
    public final int versionCode;
    public final ConnectionConfiguration zzbsG;

    static {
        CREATOR = new zzao();
    }

    GetConfigResponse(int versionCode, int statusCode, ConnectionConfiguration config) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.zzbsG = config;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzao.zza(this, dest, flags);
    }
}
