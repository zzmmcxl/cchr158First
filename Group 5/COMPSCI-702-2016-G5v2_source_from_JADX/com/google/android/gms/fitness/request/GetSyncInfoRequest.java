package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzox;
import com.google.android.gms.internal.zzox.zza;

public class GetSyncInfoRequest implements SafeParcelable {
    public static final Creator<GetSyncInfoRequest> CREATOR;
    private final int mVersionCode;
    private final zzox zzaBb;

    static {
        CREATOR = new zzp();
    }

    GetSyncInfoRequest(int versionCode, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzaBb = zza.zzbS(callback);
    }

    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        return this.zzaBb.asBinder();
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("GetSyncInfoRequest {%d, %s, %s}", new Object[]{Integer.valueOf(this.mVersionCode), this.zzaBb});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzp.zza(this, parcel, flags);
    }
}
