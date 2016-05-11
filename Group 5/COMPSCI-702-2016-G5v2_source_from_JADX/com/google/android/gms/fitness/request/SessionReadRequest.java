package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzou;
import com.google.android.gms.internal.zzou.zza;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionReadRequest implements SafeParcelable {
    public static final Creator<SessionReadRequest> CREATOR;
    private final int mVersionCode;
    private final String zzLq;
    private final long zzRD;
    private final List<DataSource> zzaAF;
    private final boolean zzaAQ;
    private final String zzaBu;
    private boolean zzaBv;
    private final List<String> zzaBw;
    private final zzou zzaBx;
    private final long zzavV;
    private final List<DataType> zzawe;

    public static class Builder {
        private String zzLq;
        private long zzRD;
        private List<DataSource> zzaAF;
        private boolean zzaAQ;
        private String zzaBu;
        private boolean zzaBv;
        private List<String> zzaBw;
        private long zzavV;
        private List<DataType> zzawe;

        public Builder() {
            this.zzRD = 0;
            this.zzavV = 0;
            this.zzawe = new ArrayList();
            this.zzaAF = new ArrayList();
            this.zzaBv = false;
            this.zzaAQ = false;
            this.zzaBw = new ArrayList();
        }

        public SessionReadRequest build() {
            zzx.zzb(this.zzRD > 0, "Invalid start time: %s", Long.valueOf(this.zzRD));
            boolean z = this.zzavV > 0 && this.zzavV > this.zzRD;
            zzx.zzb(z, "Invalid end time: %s", Long.valueOf(this.zzavV));
            return new SessionReadRequest();
        }

        public Builder enableServerQueries() {
            this.zzaAQ = true;
            return this;
        }

        public Builder excludePackage(String appPackageName) {
            zzx.zzb((Object) appPackageName, (Object) "Attempting to use a null package name");
            if (!this.zzaBw.contains(appPackageName)) {
                this.zzaBw.add(appPackageName);
            }
            return this;
        }

        public Builder read(DataSource dataSource) {
            zzx.zzb((Object) dataSource, (Object) "Attempting to add a null data source");
            if (!this.zzaAF.contains(dataSource)) {
                this.zzaAF.add(dataSource);
            }
            return this;
        }

        public Builder read(DataType dataType) {
            zzx.zzb((Object) dataType, (Object) "Attempting to use a null data type");
            if (!this.zzawe.contains(dataType)) {
                this.zzawe.add(dataType);
            }
            return this;
        }

        public Builder readSessionsFromAllApps() {
            this.zzaBv = true;
            return this;
        }

        public Builder setSessionId(String sessionId) {
            this.zzLq = sessionId;
            return this;
        }

        public Builder setSessionName(String sessionName) {
            this.zzaBu = sessionName;
            return this;
        }

        public Builder setTimeInterval(long startTime, long endTime, TimeUnit timeUnit) {
            this.zzRD = timeUnit.toMillis(startTime);
            this.zzavV = timeUnit.toMillis(endTime);
            return this;
        }
    }

    static {
        CREATOR = new zzy();
    }

    SessionReadRequest(int versionCode, String sessionName, String sessionId, long startTimeMillis, long endTimeMillis, List<DataType> dataTypes, List<DataSource> dataSources, boolean getSessionsFromAllApps, boolean serverQueriesEnabled, List<String> excludedPackages, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzaBu = sessionName;
        this.zzLq = sessionId;
        this.zzRD = startTimeMillis;
        this.zzavV = endTimeMillis;
        this.zzawe = dataTypes;
        this.zzaAF = dataSources;
        this.zzaBv = getSessionsFromAllApps;
        this.zzaAQ = serverQueriesEnabled;
        this.zzaBw = excludedPackages;
        this.zzaBx = zza.zzbP(callback);
    }

    private SessionReadRequest(Builder builder) {
        this(builder.zzaBu, builder.zzLq, builder.zzRD, builder.zzavV, builder.zzawe, builder.zzaAF, builder.zzaBv, builder.zzaAQ, builder.zzaBw, null);
    }

    public SessionReadRequest(SessionReadRequest request, zzou callback) {
        this(request.zzaBu, request.zzLq, request.zzRD, request.zzavV, request.zzawe, request.zzaAF, request.zzaBv, request.zzaAQ, request.zzaBw, callback);
    }

    public SessionReadRequest(String sessionName, String sessionId, long startTimeMillis, long endTimeMillis, List<DataType> dataTypes, List<DataSource> dataSources, boolean getSessionsFromAllApps, boolean serverQueriesEnabled, List<String> excludedPackages, zzou callback) {
        this(5, sessionName, sessionId, startTimeMillis, endTimeMillis, dataTypes, dataSources, getSessionsFromAllApps, serverQueriesEnabled, excludedPackages, callback == null ? null : callback.asBinder());
    }

    private boolean zzb(SessionReadRequest sessionReadRequest) {
        return zzw.equal(this.zzaBu, sessionReadRequest.zzaBu) && this.zzLq.equals(sessionReadRequest.zzLq) && this.zzRD == sessionReadRequest.zzRD && this.zzavV == sessionReadRequest.zzavV && zzw.equal(this.zzawe, sessionReadRequest.zzawe) && zzw.equal(this.zzaAF, sessionReadRequest.zzaAF) && this.zzaBv == sessionReadRequest.zzaBv && this.zzaBw.equals(sessionReadRequest.zzaBw) && this.zzaAQ == sessionReadRequest.zzaAQ;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof SessionReadRequest) && zzb((SessionReadRequest) o));
    }

    public IBinder getCallbackBinder() {
        return this.zzaBx == null ? null : this.zzaBx.asBinder();
    }

    public List<DataSource> getDataSources() {
        return this.zzaAF;
    }

    public List<DataType> getDataTypes() {
        return this.zzawe;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzavV, TimeUnit.MILLISECONDS);
    }

    public List<String> getExcludedPackages() {
        return this.zzaBw;
    }

    public String getSessionId() {
        return this.zzLq;
    }

    public String getSessionName() {
        return this.zzaBu;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzRD, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaBu, this.zzLq, Long.valueOf(this.zzRD), Long.valueOf(this.zzavV));
    }

    public boolean includeSessionsFromAllApps() {
        return this.zzaBv;
    }

    public String toString() {
        return zzw.zzy(this).zzg("sessionName", this.zzaBu).zzg("sessionId", this.zzLq).zzg("startTimeMillis", Long.valueOf(this.zzRD)).zzg("endTimeMillis", Long.valueOf(this.zzavV)).zzg("dataTypes", this.zzawe).zzg("dataSources", this.zzaAF).zzg("sessionsFromAllApps", Boolean.valueOf(this.zzaBv)).zzg("excludedPackages", this.zzaBw).zzg("useServer", Boolean.valueOf(this.zzaAQ)).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzy.zza(this, dest, flags);
    }

    public long zzlO() {
        return this.zzRD;
    }

    public boolean zzuP() {
        return this.zzaAQ;
    }

    public long zzud() {
        return this.zzavV;
    }

    public boolean zzve() {
        return this.zzaBv;
    }
}
