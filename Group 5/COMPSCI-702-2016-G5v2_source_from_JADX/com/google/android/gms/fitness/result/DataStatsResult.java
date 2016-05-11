package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class DataStatsResult implements Result, SafeParcelable {
    public static final Creator<DataStatsResult> CREATOR;
    private final int mVersionCode;
    private final Status zzUX;
    private final List<DataSourceStatsResult> zzaBL;

    static {
        CREATOR = new zzf();
    }

    DataStatsResult(int versionCode, Status status, List<DataSourceStatsResult> dataSourceStats) {
        this.mVersionCode = versionCode;
        this.zzUX = status;
        this.zzaBL = dataSourceStats;
    }

    public int describeContents() {
        return 0;
    }

    public Status getStatus() {
        return this.zzUX;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }

    List<DataSourceStatsResult> zzvn() {
        return this.zzaBL;
    }
}
