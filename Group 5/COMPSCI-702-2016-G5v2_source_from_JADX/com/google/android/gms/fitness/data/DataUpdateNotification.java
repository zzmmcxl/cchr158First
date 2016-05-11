package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzw;
import java.util.concurrent.TimeUnit;

public class DataUpdateNotification implements SafeParcelable {
    public static final String ACTION = "com.google.android.gms.fitness.DATA_UPDATE_NOTIFICATION";
    public static final Creator<DataUpdateNotification> CREATOR;
    public static final String EXTRA_DATA_UPDATE_NOTIFICATION = "vnd.google.fitness.data_udpate_notification";
    public static final int OPERATION_DELETE = 2;
    public static final int OPERATION_INSERT = 1;
    public static final int OPERATION_UPDATE = 3;
    final int mVersionCode;
    private final DataType zzavT;
    private final DataSource zzavU;
    private final long zzawF;
    private final long zzawG;
    private final int zzawH;

    static {
        CREATOR = new zzh();
    }

    DataUpdateNotification(int versionCode, long updateStartTimeNanos, long updateEndTimeNanos, int operationType, DataSource dataSource, DataType dataType) {
        this.mVersionCode = versionCode;
        this.zzawF = updateStartTimeNanos;
        this.zzawG = updateEndTimeNanos;
        this.zzawH = operationType;
        this.zzavU = dataSource;
        this.zzavT = dataType;
    }

    public static DataUpdateNotification getDataUpdateNotification(Intent intent) {
        return (DataUpdateNotification) zzc.zza(intent, EXTRA_DATA_UPDATE_NOTIFICATION, CREATOR);
    }

    private boolean zza(DataUpdateNotification dataUpdateNotification) {
        return this.zzawF == dataUpdateNotification.zzawF && this.zzawG == dataUpdateNotification.zzawG && this.zzawH == dataUpdateNotification.zzawH && zzw.equal(this.zzavU, dataUpdateNotification.zzavU) && zzw.equal(this.zzavT, dataUpdateNotification.zzavT);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataUpdateNotification) && zza((DataUpdateNotification) o));
    }

    public DataSource getDataSource() {
        return this.zzavU;
    }

    public DataType getDataType() {
        return this.zzavT;
    }

    public int getOperationType() {
        return this.zzawH;
    }

    public long getUpdateEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzawG, TimeUnit.NANOSECONDS);
    }

    public long getUpdateStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzawF, TimeUnit.NANOSECONDS);
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzawF), Long.valueOf(this.zzawG), Integer.valueOf(this.zzawH), this.zzavU, this.zzavT);
    }

    public String toString() {
        return zzw.zzy(this).zzg("updateStartTimeNanos", Long.valueOf(this.zzawF)).zzg("updateEndTimeNanos", Long.valueOf(this.zzawG)).zzg("operationType", Integer.valueOf(this.zzawH)).zzg("dataSource", this.zzavU).zzg("dataType", this.zzavT).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }

    public long zzup() {
        return this.zzawF;
    }

    public long zzuq() {
        return this.zzawG;
    }
}
