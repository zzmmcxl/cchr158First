package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Bucket implements SafeParcelable {
    public static final Creator<Bucket> CREATOR;
    public static final int TYPE_ACTIVITY_SEGMENT = 4;
    public static final int TYPE_ACTIVITY_TYPE = 3;
    public static final int TYPE_SESSION = 2;
    public static final int TYPE_TIME = 1;
    private final int mVersionCode;
    private final long zzRD;
    private final long zzavV;
    private final Session zzavX;
    private final int zzawf;
    private final List<DataSet> zzawg;
    private final int zzawh;
    private boolean zzawi;

    static {
        CREATOR = new zzc();
    }

    Bucket(int versionCode, long startTimeMillis, long endTimeMillis, Session session, int activityType, List<DataSet> dataSets, int bucketType, boolean serverHasMoreData) {
        this.zzawi = false;
        this.mVersionCode = versionCode;
        this.zzRD = startTimeMillis;
        this.zzavV = endTimeMillis;
        this.zzavX = session;
        this.zzawf = activityType;
        this.zzawg = dataSets;
        this.zzawh = bucketType;
        this.zzawi = serverHasMoreData;
    }

    public Bucket(RawBucket bucket, List<DataSource> uniqueDataSources) {
        this(TYPE_SESSION, bucket.zzRD, bucket.zzavV, bucket.zzavX, bucket.zzaxf, zza(bucket.zzawg, uniqueDataSources), bucket.zzawh, bucket.zzawi);
    }

    private static List<DataSet> zza(Collection<RawDataSet> collection, List<DataSource> list) {
        List<DataSet> arrayList = new ArrayList(collection.size());
        for (RawDataSet dataSet : collection) {
            arrayList.add(new DataSet(dataSet, list));
        }
        return arrayList;
    }

    private boolean zza(Bucket bucket) {
        return this.zzRD == bucket.zzRD && this.zzavV == bucket.zzavV && this.zzawf == bucket.zzawf && zzw.equal(this.zzawg, bucket.zzawg) && this.zzawh == bucket.zzawh && this.zzawi == bucket.zzawi;
    }

    public static String zzeM(int i) {
        switch (i) {
            case Barcode.ALL_FORMATS /*0*/:
                return FitnessActivities.UNKNOWN;
            case TYPE_TIME /*1*/:
                return "time";
            case TYPE_SESSION /*2*/:
                return "session";
            case TYPE_ACTIVITY_TYPE /*3*/:
                return "type";
            case TYPE_ACTIVITY_SEGMENT /*4*/:
                return "segment";
            default:
                return "bug";
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof Bucket) && zza((Bucket) o));
    }

    public String getActivity() {
        return FitnessActivities.getName(this.zzawf);
    }

    public int getBucketType() {
        return this.zzawh;
    }

    public DataSet getDataSet(DataType dataType) {
        for (DataSet dataSet : this.zzawg) {
            if (dataSet.getDataType().equals(dataType)) {
                return dataSet;
            }
        }
        return null;
    }

    public List<DataSet> getDataSets() {
        return this.zzawg;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzavV, TimeUnit.MILLISECONDS);
    }

    public Session getSession() {
        return this.zzavX;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzRD, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        Object[] objArr = new Object[TYPE_ACTIVITY_SEGMENT];
        objArr[0] = Long.valueOf(this.zzRD);
        objArr[TYPE_TIME] = Long.valueOf(this.zzavV);
        objArr[TYPE_SESSION] = Integer.valueOf(this.zzawf);
        objArr[TYPE_ACTIVITY_TYPE] = Integer.valueOf(this.zzawh);
        return zzw.hashCode(objArr);
    }

    public String toString() {
        return zzw.zzy(this).zzg("startTime", Long.valueOf(this.zzRD)).zzg("endTime", Long.valueOf(this.zzavV)).zzg("activity", Integer.valueOf(this.zzawf)).zzg("dataSets", this.zzawg).zzg("bucketType", zzeM(this.zzawh)).zzg("serverHasMoreData", Boolean.valueOf(this.zzawi)).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }

    public boolean zzb(Bucket bucket) {
        return this.zzRD == bucket.zzRD && this.zzavV == bucket.zzavV && this.zzawf == bucket.zzawf && this.zzawh == bucket.zzawh;
    }

    public long zzlO() {
        return this.zzRD;
    }

    public int zzub() {
        return this.zzawf;
    }

    public boolean zzuc() {
        if (this.zzawi) {
            return true;
        }
        for (DataSet zzuc : this.zzawg) {
            if (zzuc.zzuc()) {
                return true;
            }
        }
        return false;
    }

    public long zzud() {
        return this.zzavV;
    }
}
