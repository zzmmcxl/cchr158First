package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.zzk;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRegistrationRequest;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.SensorUnregistrationRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;

public class zzpf implements SensorsApi {

    private interface zza {
        void zzuI();
    }

    /* renamed from: com.google.android.gms.internal.zzpf.3 */
    class C08573 implements zza {
        final /* synthetic */ zzpf zzaAi;
        final /* synthetic */ OnDataPointListener zzaAm;

        C08573(zzpf com_google_android_gms_internal_zzpf, OnDataPointListener onDataPointListener) {
            this.zzaAi = com_google_android_gms_internal_zzpf;
            this.zzaAm = onDataPointListener;
        }

        public void zzuI() {
            com.google.android.gms.fitness.data.zzl.zza.zzuu().zzc(this.zzaAm);
        }
    }

    private static class zzb extends com.google.android.gms.internal.zzoi.zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<DataSourcesResult> zzamC;

        private zzb(com.google.android.gms.common.api.internal.zza.zzb<DataSourcesResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_DataSourcesResult) {
            this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_DataSourcesResult;
        }

        public void zza(DataSourcesResult dataSourcesResult) {
            this.zzamC.zzs(dataSourcesResult);
        }
    }

    private static class zzc extends com.google.android.gms.internal.zzow.zza {
        private final zza zzaAq;
        private final com.google.android.gms.common.api.internal.zza.zzb<Status> zzamC;

        private zzc(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, zza com_google_android_gms_internal_zzpf_zza) {
            this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status;
            this.zzaAq = com_google_android_gms_internal_zzpf_zza;
        }

        public void zzp(Status status) {
            if (this.zzaAq != null && status.isSuccess()) {
                this.zzaAq.zzuI();
            }
            this.zzamC.zzs(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpf.1 */
    class C10891 extends zza<DataSourcesResult> {
        final /* synthetic */ DataSourcesRequest zzaAh;
        final /* synthetic */ zzpf zzaAi;

        C10891(zzpf com_google_android_gms_internal_zzpf, GoogleApiClient googleApiClient, DataSourcesRequest dataSourcesRequest) {
            this.zzaAi = com_google_android_gms_internal_zzpf;
            this.zzaAh = dataSourcesRequest;
            super(googleApiClient);
        }

        protected DataSourcesResult zzN(Status status) {
            return DataSourcesResult.zzR(status);
        }

        protected void zza(zzoe com_google_android_gms_internal_zzoe) throws RemoteException {
            ((zzop) com_google_android_gms_internal_zzoe.zzqJ()).zza(new DataSourcesRequest(this.zzaAh, new zzb(null)));
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzN(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpf.2 */
    class C12582 extends zzc {
        final /* synthetic */ zzpf zzaAi;
        final /* synthetic */ SensorRequest zzaAj;
        final /* synthetic */ zzk zzaAk;
        final /* synthetic */ PendingIntent zzaAl;

        C12582(zzpf com_google_android_gms_internal_zzpf, GoogleApiClient googleApiClient, SensorRequest sensorRequest, zzk com_google_android_gms_fitness_data_zzk, PendingIntent pendingIntent) {
            this.zzaAi = com_google_android_gms_internal_zzpf;
            this.zzaAj = sensorRequest;
            this.zzaAk = com_google_android_gms_fitness_data_zzk;
            this.zzaAl = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzoe com_google_android_gms_internal_zzoe) throws RemoteException {
            ((zzop) com_google_android_gms_internal_zzoe.zzqJ()).zza(new SensorRegistrationRequest(this.zzaAj, this.zzaAk, this.zzaAl, new zzph(this)));
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpf.4 */
    class C12594 extends zzc {
        final /* synthetic */ zzpf zzaAi;
        final /* synthetic */ zza zzaAn;
        final /* synthetic */ zzk zzaAo;
        final /* synthetic */ PendingIntent zzaAp;

        C12594(zzpf com_google_android_gms_internal_zzpf, GoogleApiClient googleApiClient, zza com_google_android_gms_internal_zzpf_zza, zzk com_google_android_gms_fitness_data_zzk, PendingIntent pendingIntent) {
            this.zzaAi = com_google_android_gms_internal_zzpf;
            this.zzaAn = com_google_android_gms_internal_zzpf_zza;
            this.zzaAo = com_google_android_gms_fitness_data_zzk;
            this.zzaAp = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzoe com_google_android_gms_internal_zzoe) throws RemoteException {
            ((zzop) com_google_android_gms_internal_zzoe.zzqJ()).zza(new SensorUnregistrationRequest(this.zzaAo, this.zzaAp, new zzc(this.zzaAn, null)));
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, zzk com_google_android_gms_fitness_data_zzk, PendingIntent pendingIntent, zza com_google_android_gms_internal_zzpf_zza) {
        return googleApiClient.zzb(new C12594(this, googleApiClient, com_google_android_gms_internal_zzpf_zza, com_google_android_gms_fitness_data_zzk, pendingIntent));
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, SensorRequest sensorRequest, zzk com_google_android_gms_fitness_data_zzk, PendingIntent pendingIntent) {
        return googleApiClient.zza(new C12582(this, googleApiClient, sensorRequest, com_google_android_gms_fitness_data_zzk, pendingIntent));
    }

    public PendingResult<Status> add(GoogleApiClient client, SensorRequest request, PendingIntent intent) {
        return zza(client, request, null, intent);
    }

    public PendingResult<Status> add(GoogleApiClient client, SensorRequest request, OnDataPointListener listener) {
        return zza(client, request, com.google.android.gms.fitness.data.zzl.zza.zzuu().zza(listener), null);
    }

    public PendingResult<DataSourcesResult> findDataSources(GoogleApiClient client, DataSourcesRequest request) {
        return client.zza(new C10891(this, client, request));
    }

    public PendingResult<Status> remove(GoogleApiClient client, PendingIntent pendingIntent) {
        return zza(client, null, pendingIntent, null);
    }

    public PendingResult<Status> remove(GoogleApiClient client, OnDataPointListener listener) {
        zzk zzb = com.google.android.gms.fitness.data.zzl.zza.zzuu().zzb(listener);
        return zzb == null ? PendingResults.zza(Status.zzagC, client) : zza(client, zzb, null, new C08573(this, listener));
    }
}
