package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.ListSubscriptionsRequest;
import com.google.android.gms.fitness.request.SubscribeRequest;
import com.google.android.gms.fitness.request.UnsubscribeRequest;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

public class zzpe implements RecordingApi {

    private static class zza extends com.google.android.gms.internal.zzor.zza {
        private final zzb<ListSubscriptionsResult> zzamC;

        private zza(zzb<ListSubscriptionsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_ListSubscriptionsResult) {
            this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_ListSubscriptionsResult;
        }

        public void zza(ListSubscriptionsResult listSubscriptionsResult) {
            this.zzamC.zzs(listSubscriptionsResult);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpe.1 */
    class C10871 extends zza<ListSubscriptionsResult> {
        final /* synthetic */ zzpe zzaAe;

        C10871(zzpe com_google_android_gms_internal_zzpe, GoogleApiClient googleApiClient) {
            this.zzaAe = com_google_android_gms_internal_zzpe;
            super(googleApiClient);
        }

        protected ListSubscriptionsResult zzM(Status status) {
            return ListSubscriptionsResult.zzT(status);
        }

        protected void zza(zzod com_google_android_gms_internal_zzod) throws RemoteException {
            ((zzoo) com_google_android_gms_internal_zzod.zzqJ()).zza(new ListSubscriptionsRequest(null, new zza(null)));
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzM(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpe.2 */
    class C10882 extends zza<ListSubscriptionsResult> {
        final /* synthetic */ DataType zzaAa;
        final /* synthetic */ zzpe zzaAe;

        C10882(zzpe com_google_android_gms_internal_zzpe, GoogleApiClient googleApiClient, DataType dataType) {
            this.zzaAe = com_google_android_gms_internal_zzpe;
            this.zzaAa = dataType;
            super(googleApiClient);
        }

        protected ListSubscriptionsResult zzM(Status status) {
            return ListSubscriptionsResult.zzT(status);
        }

        protected void zza(zzod com_google_android_gms_internal_zzod) throws RemoteException {
            ((zzoo) com_google_android_gms_internal_zzod.zzqJ()).zza(new ListSubscriptionsRequest(this.zzaAa, new zza(null)));
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzM(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpe.3 */
    class C12553 extends zzc {
        final /* synthetic */ zzpe zzaAe;
        final /* synthetic */ Subscription zzaAf;

        C12553(zzpe com_google_android_gms_internal_zzpe, GoogleApiClient googleApiClient, Subscription subscription) {
            this.zzaAe = com_google_android_gms_internal_zzpe;
            this.zzaAf = subscription;
            super(googleApiClient);
        }

        protected void zza(zzod com_google_android_gms_internal_zzod) throws RemoteException {
            ((zzoo) com_google_android_gms_internal_zzod.zzqJ()).zza(new SubscribeRequest(this.zzaAf, false, new zzph(this)));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpe.4 */
    class C12564 extends zzc {
        final /* synthetic */ DataType zzaAa;
        final /* synthetic */ zzpe zzaAe;

        C12564(zzpe com_google_android_gms_internal_zzpe, GoogleApiClient googleApiClient, DataType dataType) {
            this.zzaAe = com_google_android_gms_internal_zzpe;
            this.zzaAa = dataType;
            super(googleApiClient);
        }

        protected void zza(zzod com_google_android_gms_internal_zzod) throws RemoteException {
            ((zzoo) com_google_android_gms_internal_zzod.zzqJ()).zza(new UnsubscribeRequest(this.zzaAa, null, new zzph(this)));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpe.5 */
    class C12575 extends zzc {
        final /* synthetic */ zzpe zzaAe;
        final /* synthetic */ DataSource zzaAg;

        C12575(zzpe com_google_android_gms_internal_zzpe, GoogleApiClient googleApiClient, DataSource dataSource) {
            this.zzaAe = com_google_android_gms_internal_zzpe;
            this.zzaAg = dataSource;
            super(googleApiClient);
        }

        protected void zza(zzod com_google_android_gms_internal_zzod) throws RemoteException {
            ((zzoo) com_google_android_gms_internal_zzod.zzqJ()).zza(new UnsubscribeRequest(null, this.zzaAg, new zzph(this)));
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, Subscription subscription) {
        return googleApiClient.zza(new C12553(this, googleApiClient, subscription));
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient client) {
        return client.zza(new C10871(this, client));
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient client, DataType dataType) {
        return client.zza(new C10882(this, client, dataType));
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, DataSource dataSource) {
        return zza(client, new com.google.android.gms.fitness.data.Subscription.zza().zzb(dataSource).zzuz());
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, DataType dataType) {
        return zza(client, new com.google.android.gms.fitness.data.Subscription.zza().zzb(dataType).zzuz());
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, DataSource dataSource) {
        return client.zzb(new C12575(this, client, dataSource));
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, DataType dataType) {
        return client.zzb(new C12564(this, client, dataType));
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, Subscription subscription) {
        return subscription.getDataType() == null ? unsubscribe(client, subscription.getDataSource()) : unsubscribe(client, subscription.getDataType());
    }
}
