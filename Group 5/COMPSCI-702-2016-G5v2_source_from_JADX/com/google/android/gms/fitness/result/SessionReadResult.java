package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.SessionDataSet;
import com.google.android.gms.games.Games;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SessionReadResult implements Result, SafeParcelable {
    public static final Creator<SessionReadResult> CREATOR;
    private final int mVersionCode;
    private final Status zzUX;
    private final List<Session> zzaAG;
    private final List<SessionDataSet> zzaBO;

    static {
        CREATOR = new zzj();
    }

    SessionReadResult(int versionCode, List<Session> sessions, List<SessionDataSet> sessionDataSets, Status status) {
        this.mVersionCode = versionCode;
        this.zzaAG = sessions;
        this.zzaBO = Collections.unmodifiableList(sessionDataSets);
        this.zzUX = status;
    }

    public SessionReadResult(List<Session> sessions, List<SessionDataSet> sessionDataSets, Status status) {
        this.mVersionCode = 3;
        this.zzaAG = sessions;
        this.zzaBO = Collections.unmodifiableList(sessionDataSets);
        this.zzUX = status;
    }

    public static SessionReadResult zzU(Status status) {
        return new SessionReadResult(new ArrayList(), new ArrayList(), status);
    }

    private boolean zzb(SessionReadResult sessionReadResult) {
        return this.zzUX.equals(sessionReadResult.zzUX) && zzw.equal(this.zzaAG, sessionReadResult.zzaAG) && zzw.equal(this.zzaBO, sessionReadResult.zzaBO);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof SessionReadResult) && zzb((SessionReadResult) that));
    }

    public List<DataSet> getDataSet(Session session) {
        zzx.zzb(this.zzaAG.contains(session), "Attempting to read data for session %s which was not returned", session);
        List<DataSet> arrayList = new ArrayList();
        for (SessionDataSet sessionDataSet : this.zzaBO) {
            if (zzw.equal(session, sessionDataSet.getSession())) {
                arrayList.add(sessionDataSet.getDataSet());
            }
        }
        return arrayList;
    }

    public List<DataSet> getDataSet(Session session, DataType dataType) {
        zzx.zzb(this.zzaAG.contains(session), "Attempting to read data for session %s which was not returned", session);
        List<DataSet> arrayList = new ArrayList();
        for (SessionDataSet sessionDataSet : this.zzaBO) {
            if (zzw.equal(session, sessionDataSet.getSession()) && dataType.equals(sessionDataSet.getDataSet().getDataType())) {
                arrayList.add(sessionDataSet.getDataSet());
            }
        }
        return arrayList;
    }

    public List<Session> getSessions() {
        return this.zzaAG;
    }

    public Status getStatus() {
        return this.zzUX;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzUX, this.zzaAG, this.zzaBO);
    }

    public String toString() {
        return zzw.zzy(this).zzg(Games.EXTRA_STATUS, this.zzUX).zzg("sessions", this.zzaAG).zzg("sessionDataSets", this.zzaBO).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }

    public List<SessionDataSet> zzvp() {
        return this.zzaBO;
    }
}
