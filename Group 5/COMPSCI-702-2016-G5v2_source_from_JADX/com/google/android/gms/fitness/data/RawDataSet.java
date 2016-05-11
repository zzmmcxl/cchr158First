package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

@KeepName
public final class RawDataSet implements SafeParcelable {
    public static final Creator<RawDataSet> CREATOR;
    final int mVersionCode;
    public final boolean zzawi;
    public final int zzaxg;
    public final int zzaxi;
    public final List<RawDataPoint> zzaxj;

    static {
        CREATOR = new zzp();
    }

    public RawDataSet(int versionCode, int dataSourceIndex, int dataTypeIndex, List<RawDataPoint> rawDataPoints, boolean serverHasMoreData) {
        this.mVersionCode = versionCode;
        this.zzaxg = dataSourceIndex;
        this.zzaxi = dataTypeIndex;
        this.zzaxj = rawDataPoints;
        this.zzawi = serverHasMoreData;
    }

    public RawDataSet(DataSet dataSet, List<DataSource> uniqueDataSources, List<DataType> uniqueDataTypes) {
        this.mVersionCode = 3;
        this.zzaxj = dataSet.zzv(uniqueDataSources);
        this.zzawi = dataSet.zzuc();
        this.zzaxg = zzt.zza(dataSet.getDataSource(), uniqueDataSources);
        this.zzaxi = zzt.zza(dataSet.getDataType(), uniqueDataTypes);
    }

    private boolean zza(RawDataSet rawDataSet) {
        return this.zzaxg == rawDataSet.zzaxg && this.zzawi == rawDataSet.zzawi && zzw.equal(this.zzaxj, rawDataSet.zzaxj);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof RawDataSet) && zza((RawDataSet) o));
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzaxg));
    }

    public String toString() {
        return String.format("RawDataSet{%s@[%s]}", new Object[]{Integer.valueOf(this.zzaxg), this.zzaxj});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzp.zza(this, parcel, flags);
    }
}
