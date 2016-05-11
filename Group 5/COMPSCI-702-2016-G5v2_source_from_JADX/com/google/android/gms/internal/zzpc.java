package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DailyTotalRequest;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataInsertRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataUpdateRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataReadResult;

public class zzpc implements HistoryApi {

    private static class zza extends com.google.android.gms.internal.zzoh.zza {
        private int zzaAc;
        private DataReadResult zzaAd;
        private final zzb<DataReadResult> zzamC;

        private zza(zzb<DataReadResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_DataReadResult) {
            this.zzaAc = 0;
            this.zzaAd = null;
            this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_DataReadResult;
        }

        public void zza(DataReadResult dataReadResult) {
            synchronized (this) {
                if (Log.isLoggable("Fitness", 2)) {
                    Log.v("Fitness", "Received batch result " + this.zzaAc);
                }
                if (this.zzaAd == null) {
                    this.zzaAd = dataReadResult;
                } else {
                    this.zzaAd.zzb(dataReadResult);
                }
                this.zzaAc++;
                if (this.zzaAc == this.zzaAd.zzvj()) {
                    this.zzamC.zzs(this.zzaAd);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpc.4 */
    class C10854 extends zza<DataReadResult> {
        final /* synthetic */ zzpc zzazW;
        final /* synthetic */ DataReadRequest zzazZ;

        C10854(zzpc com_google_android_gms_internal_zzpc, GoogleApiClient googleApiClient, DataReadRequest dataReadRequest) {
            this.zzazW = com_google_android_gms_internal_zzpc;
            this.zzazZ = dataReadRequest;
            super(googleApiClient);
        }

        protected DataReadResult zzK(Status status) {
            return DataReadResult.zza(status, this.zzazZ);
        }

        protected void zza(zzob com_google_android_gms_internal_zzob) throws RemoteException {
            ((zzom) com_google_android_gms_internal_zzob.zzqJ()).zza(new DataReadRequest(this.zzazZ, new zza(null)));
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzK(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpc.5 */
    class C10865 extends zza<DailyTotalResult> {
        final /* synthetic */ DataType zzaAa;
        final /* synthetic */ zzpc zzazW;

        /* renamed from: com.google.android.gms.internal.zzpc.5.1 */
        class C10161 extends com.google.android.gms.internal.zzog.zza {
            final /* synthetic */ C10865 zzaAb;

            C10161(C10865 c10865) {
                this.zzaAb = c10865;
            }

            public void zza(DailyTotalResult dailyTotalResult) throws RemoteException {
                this.zzaAb.zza((Result) dailyTotalResult);
            }
        }

        C10865(zzpc com_google_android_gms_internal_zzpc, GoogleApiClient googleApiClient, DataType dataType) {
            this.zzazW = com_google_android_gms_internal_zzpc;
            this.zzaAa = dataType;
            super(googleApiClient);
        }

        protected DailyTotalResult zzL(Status status) {
            return DailyTotalResult.zza(status, this.zzaAa);
        }

        protected void zza(zzob com_google_android_gms_internal_zzob) throws RemoteException {
            ((zzom) com_google_android_gms_internal_zzob.zzqJ()).zza(new DailyTotalRequest(new C10161(this), this.zzaAa));
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzL(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpc.1 */
    class C12521 extends zzc {
        final /* synthetic */ DataSet zzazU;
        final /* synthetic */ boolean zzazV;
        final /* synthetic */ zzpc zzazW;

        C12521(zzpc com_google_android_gms_internal_zzpc, GoogleApiClient googleApiClient, DataSet dataSet, boolean z) {
            this.zzazW = com_google_android_gms_internal_zzpc;
            this.zzazU = dataSet;
            this.zzazV = z;
            super(googleApiClient);
        }

        protected void zza(zzob com_google_android_gms_internal_zzob) throws RemoteException {
            ((zzom) com_google_android_gms_internal_zzob.zzqJ()).zza(new DataInsertRequest(this.zzazU, new zzph(this), this.zzazV));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpc.2 */
    class C12532 extends zzc {
        final /* synthetic */ zzpc zzazW;
        final /* synthetic */ DataDeleteRequest zzazX;

        C12532(zzpc com_google_android_gms_internal_zzpc, GoogleApiClient googleApiClient, DataDeleteRequest dataDeleteRequest) {
            this.zzazW = com_google_android_gms_internal_zzpc;
            this.zzazX = dataDeleteRequest;
            super(googleApiClient);
        }

        protected void zza(zzob com_google_android_gms_internal_zzob) throws RemoteException {
            ((zzom) com_google_android_gms_internal_zzob.zzqJ()).zza(new DataDeleteRequest(this.zzazX, new zzph(this)));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpc.3 */
    class C12543 extends zzc {
        final /* synthetic */ zzpc zzazW;
        final /* synthetic */ DataUpdateRequest zzazY;

        C12543(zzpc com_google_android_gms_internal_zzpc, GoogleApiClient googleApiClient, DataUpdateRequest dataUpdateRequest) {
            this.zzazW = com_google_android_gms_internal_zzpc;
            this.zzazY = dataUpdateRequest;
            super(googleApiClient);
        }

        protected void zza(zzob com_google_android_gms_internal_zzob) throws RemoteException {
            ((zzom) com_google_android_gms_internal_zzob.zzqJ()).zza(new DataUpdateRequest(this.zzazY, new zzph(this)));
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, DataSet dataSet, boolean z) {
        zzx.zzb((Object) dataSet, (Object) "Must set the data set");
        zzx.zza(!dataSet.getDataPoints().isEmpty(), (Object) "Cannot use an empty data set");
        zzx.zzb(dataSet.getDataSource().zzum(), (Object) "Must set the app package name for the data source");
        return googleApiClient.zza(new C12521(this, googleApiClient, dataSet, z));
    }

    public PendingResult<Status> deleteData(GoogleApiClient client, DataDeleteRequest request) {
        return client.zza(new C12532(this, client, request));
    }

    public PendingResult<Status> insertData(GoogleApiClient client, DataSet dataSet) {
        return zza(client, dataSet, false);
    }

    public PendingResult<DailyTotalResult> readDailyTotal(GoogleApiClient client, DataType dataType) {
        return client.zza(new C10865(this, client, dataType));
    }

    public PendingResult<DataReadResult> readData(GoogleApiClient client, DataReadRequest request) {
        return client.zza(new C10854(this, client, request));
    }

    public PendingResult<Status> updateData(GoogleApiClient client, DataUpdateRequest request) {
        zzx.zzb(request.getDataSet(), (Object) "Must set the data set");
        zzx.zza(request.zzlO(), (Object) "Must set a non-zero value for startTimeMillis/startTime");
        zzx.zza(request.zzud(), (Object) "Must set a non-zero value for endTimeMillis/endTime");
        return client.zza(new C12543(this, client, request));
    }
}
