package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class Subscription implements SafeParcelable {
    public static final Creator<Subscription> CREATOR;
    private final int mVersionCode;
    private final DataType zzavT;
    private final DataSource zzavU;
    private final long zzaxo;
    private final int zzaxp;

    public static class zza {
        private DataType zzavT;
        private DataSource zzavU;
        private long zzaxo;
        private int zzaxp;

        public zza() {
            this.zzaxo = -1;
            this.zzaxp = 2;
        }

        public zza zzb(DataSource dataSource) {
            this.zzavU = dataSource;
            return this;
        }

        public zza zzb(DataType dataType) {
            this.zzavT = dataType;
            return this;
        }

        public Subscription zzuz() {
            boolean z = false;
            boolean z2 = (this.zzavU == null && this.zzavT == null) ? false : true;
            zzx.zza(z2, (Object) "Must call setDataSource() or setDataType()");
            if (this.zzavT == null || this.zzavU == null || this.zzavT.equals(this.zzavU.getDataType())) {
                z = true;
            }
            zzx.zza(z, (Object) "Specified data type is incompatible with specified data source");
            return new Subscription();
        }
    }

    static {
        CREATOR = new zzs();
    }

    Subscription(int versionCode, DataSource dataSource, DataType dataType, long samplingIntervalMicros, int accuracyMode) {
        this.mVersionCode = versionCode;
        this.zzavU = dataSource;
        this.zzavT = dataType;
        this.zzaxo = samplingIntervalMicros;
        this.zzaxp = accuracyMode;
    }

    private Subscription(zza builder) {
        this.mVersionCode = 1;
        this.zzavT = builder.zzavT;
        this.zzavU = builder.zzavU;
        this.zzaxo = builder.zzaxo;
        this.zzaxp = builder.zzaxp;
    }

    private boolean zza(Subscription subscription) {
        return zzw.equal(this.zzavU, subscription.zzavU) && zzw.equal(this.zzavT, subscription.zzavT) && this.zzaxo == subscription.zzaxo && this.zzaxp == subscription.zzaxp;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof Subscription) && zza((Subscription) that));
    }

    public int getAccuracyMode() {
        return this.zzaxp;
    }

    public DataSource getDataSource() {
        return this.zzavU;
    }

    public DataType getDataType() {
        return this.zzavT;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzavU, this.zzavU, Long.valueOf(this.zzaxo), Integer.valueOf(this.zzaxp));
    }

    public String toDebugString() {
        String str = "Subscription{%s}";
        Object[] objArr = new Object[1];
        objArr[0] = this.zzavU == null ? this.zzavT.getName() : this.zzavU.toDebugString();
        return String.format(str, objArr);
    }

    public String toString() {
        return zzw.zzy(this).zzg("dataSource", this.zzavU).zzg("dataType", this.zzavT).zzg("samplingIntervalMicros", Long.valueOf(this.zzaxo)).zzg("accuracyMode", Integer.valueOf(this.zzaxp)).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzs.zza(this, dest, flags);
    }

    public long zzux() {
        return this.zzaxo;
    }

    public DataType zzuy() {
        return this.zzavT == null ? this.zzavU.getDataType() : this.zzavT;
    }
}
