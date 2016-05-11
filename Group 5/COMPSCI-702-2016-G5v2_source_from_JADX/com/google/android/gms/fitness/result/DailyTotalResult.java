package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource.Builder;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.games.Games;

public class DailyTotalResult implements Result, SafeParcelable {
    public static final Creator<DailyTotalResult> CREATOR;
    private final int mVersionCode;
    private final Status zzUX;
    private final DataSet zzaxn;

    static {
        CREATOR = new zzb();
    }

    DailyTotalResult(int versionCode, Status status, DataSet dataSet) {
        this.mVersionCode = versionCode;
        this.zzUX = status;
        this.zzaxn = dataSet;
    }

    public DailyTotalResult(DataSet dataSet, Status status) {
        this.mVersionCode = 1;
        this.zzUX = status;
        this.zzaxn = dataSet;
    }

    public static DailyTotalResult zza(Status status, DataType dataType) {
        return new DailyTotalResult(DataSet.create(new Builder().setDataType(dataType).setType(1).build()), status);
    }

    private boolean zzb(DailyTotalResult dailyTotalResult) {
        return this.zzUX.equals(dailyTotalResult.zzUX) && zzw.equal(this.zzaxn, dailyTotalResult.zzaxn);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DailyTotalResult) && zzb((DailyTotalResult) that));
    }

    public Status getStatus() {
        return this.zzUX;
    }

    @Nullable
    public DataSet getTotal() {
        return this.zzaxn;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzUX, this.zzaxn);
    }

    public String toString() {
        return zzw.zzy(this).zzg(Games.EXTRA_STATUS, this.zzUX).zzg("dataPoint", this.zzaxn).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }
}
