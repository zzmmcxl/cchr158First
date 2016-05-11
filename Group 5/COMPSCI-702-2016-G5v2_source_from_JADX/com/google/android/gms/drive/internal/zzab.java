package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.DriveResource.MetadataResult;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class zzab implements DriveResource {
    protected final DriveId zzaoz;

    private static class zzc implements MetadataResult {
        private final Status zzUX;
        private final Metadata zzarA;

        public zzc(Status status, Metadata metadata) {
            this.zzUX = status;
            this.zzarA = metadata;
        }

        public Metadata getMetadata() {
            return this.zzarA;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static class zza extends zzd {
        private final com.google.android.gms.common.api.internal.zza.zzb<MetadataBufferResult> zzamC;

        public zza(com.google.android.gms.common.api.internal.zza.zzb<MetadataBufferResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult) {
            this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult;
        }

        public void onError(Status status) throws RemoteException {
            this.zzamC.zzs(new zzg(status, null, false));
        }

        public void zza(OnListParentsResponse onListParentsResponse) throws RemoteException {
            this.zzamC.zzs(new zzg(Status.zzagC, new MetadataBuffer(onListParentsResponse.zztv()), false));
        }
    }

    private static class zzb extends zzd {
        private final com.google.android.gms.common.api.internal.zza.zzb<MetadataResult> zzamC;

        public zzb(com.google.android.gms.common.api.internal.zza.zzb<MetadataResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_drive_DriveResource_MetadataResult) {
            this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_drive_DriveResource_MetadataResult;
        }

        public void onError(Status status) throws RemoteException {
            this.zzamC.zzs(new zzc(status, null));
        }

        public void zza(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.zzamC.zzs(new zzc(Status.zzagC, new zzp(onMetadataResponse.zztw())));
        }
    }

    private abstract class zzd extends zzt<MetadataResult> {
        final /* synthetic */ zzab zzary;

        private zzd(zzab com_google_android_gms_drive_internal_zzab, GoogleApiClient googleApiClient) {
            this.zzary = com_google_android_gms_drive_internal_zzab;
            super(googleApiClient);
        }

        public MetadataResult zzH(Status status) {
            return new zzc(status, null);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzH(status);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzab.1 */
    class C11441 extends zzd {
        final /* synthetic */ boolean zzarx;
        final /* synthetic */ zzab zzary;

        C11441(zzab com_google_android_gms_drive_internal_zzab, GoogleApiClient googleApiClient, boolean z) {
            this.zzary = com_google_android_gms_drive_internal_zzab;
            this.zzarx = z;
            super(googleApiClient, null);
        }

        protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
            com_google_android_gms_drive_internal_zzu.zzte().zza(new GetMetadataRequest(this.zzary.zzaoz, this.zzarx), new zzb(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzab.2 */
    class C11452 extends zzh {
        final /* synthetic */ zzab zzary;

        C11452(zzab com_google_android_gms_drive_internal_zzab, GoogleApiClient googleApiClient) {
            this.zzary = com_google_android_gms_drive_internal_zzab;
            super(googleApiClient);
        }

        protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
            com_google_android_gms_drive_internal_zzu.zzte().zza(new ListParentsRequest(this.zzary.zzaoz), new zza(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzab.3 */
    class C11463 extends com.google.android.gms.drive.internal.zzt.zza {
        final /* synthetic */ zzab zzary;
        final /* synthetic */ List zzarz;

        C11463(zzab com_google_android_gms_drive_internal_zzab, GoogleApiClient googleApiClient, List list) {
            this.zzary = com_google_android_gms_drive_internal_zzab;
            this.zzarz = list;
            super(googleApiClient);
        }

        protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
            com_google_android_gms_drive_internal_zzu.zzte().zza(new SetResourceParentsRequest(this.zzary.zzaoz, this.zzarz), new zzbu(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzab.4 */
    class C11474 extends zzd {
        final /* synthetic */ MetadataChangeSet zzarm;
        final /* synthetic */ zzab zzary;

        C11474(zzab com_google_android_gms_drive_internal_zzab, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet) {
            this.zzary = com_google_android_gms_drive_internal_zzab;
            this.zzarm = metadataChangeSet;
            super(googleApiClient, null);
        }

        protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
            this.zzarm.zzsL().setContext(com_google_android_gms_drive_internal_zzu.getContext());
            com_google_android_gms_drive_internal_zzu.zzte().zza(new UpdateMetadataRequest(this.zzary.zzaoz, this.zzarm.zzsL()), new zzb(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzab.5 */
    class C11485 extends com.google.android.gms.drive.internal.zzt.zza {
        final /* synthetic */ zzab zzary;

        C11485(zzab com_google_android_gms_drive_internal_zzab, GoogleApiClient googleApiClient) {
            this.zzary = com_google_android_gms_drive_internal_zzab;
            super(googleApiClient);
        }

        protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
            com_google_android_gms_drive_internal_zzu.zzte().zza(new DeleteResourceRequest(this.zzary.zzaoz), new zzbu(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzab.6 */
    class C11496 extends com.google.android.gms.drive.internal.zzt.zza {
        final /* synthetic */ zzab zzary;

        C11496(zzab com_google_android_gms_drive_internal_zzab, GoogleApiClient googleApiClient) {
            this.zzary = com_google_android_gms_drive_internal_zzab;
            super(googleApiClient);
        }

        protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
            com_google_android_gms_drive_internal_zzu.zzte().zza(new TrashResourceRequest(this.zzary.zzaoz), new zzbu(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzab.7 */
    class C11507 extends com.google.android.gms.drive.internal.zzt.zza {
        final /* synthetic */ zzab zzary;

        C11507(zzab com_google_android_gms_drive_internal_zzab, GoogleApiClient googleApiClient) {
            this.zzary = com_google_android_gms_drive_internal_zzab;
            super(googleApiClient);
        }

        protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
            com_google_android_gms_drive_internal_zzu.zzte().zza(new UntrashResourceRequest(this.zzary.zzaoz), new zzbu(this));
        }
    }

    public zzab(DriveId driveId) {
        this.zzaoz = driveId;
    }

    private PendingResult<MetadataResult> zza(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.zza(new C11441(this, googleApiClient, z));
    }

    public PendingResult<Status> addChangeListener(GoogleApiClient apiClient, ChangeListener listener) {
        return ((zzu) apiClient.zza(Drive.zzUI)).zza(apiClient, this.zzaoz, listener);
    }

    public PendingResult<Status> addChangeSubscription(GoogleApiClient apiClient) {
        return ((zzu) apiClient.zza(Drive.zzUI)).zza(apiClient, this.zzaoz);
    }

    public PendingResult<Status> delete(GoogleApiClient apiClient) {
        return apiClient.zzb(new C11485(this, apiClient));
    }

    public DriveId getDriveId() {
        return this.zzaoz;
    }

    public PendingResult<MetadataResult> getMetadata(GoogleApiClient apiClient) {
        return zza(apiClient, false);
    }

    public PendingResult<MetadataBufferResult> listParents(GoogleApiClient apiClient) {
        return apiClient.zza(new C11452(this, apiClient));
    }

    public PendingResult<Status> removeChangeListener(GoogleApiClient apiClient, ChangeListener listener) {
        return ((zzu) apiClient.zza(Drive.zzUI)).zzb(apiClient, this.zzaoz, listener);
    }

    public PendingResult<Status> removeChangeSubscription(GoogleApiClient apiClient) {
        return ((zzu) apiClient.zza(Drive.zzUI)).zzb(apiClient, this.zzaoz);
    }

    public PendingResult<Status> setParents(GoogleApiClient apiClient, Set<DriveId> parentIds) {
        if (parentIds != null) {
            return apiClient.zzb(new C11463(this, apiClient, new ArrayList(parentIds)));
        }
        throw new IllegalArgumentException("ParentIds must be provided.");
    }

    public PendingResult<Status> trash(GoogleApiClient apiClient) {
        return apiClient.zzb(new C11496(this, apiClient));
    }

    public PendingResult<Status> untrash(GoogleApiClient apiClient) {
        return apiClient.zzb(new C11507(this, apiClient));
    }

    public PendingResult<MetadataResult> updateMetadata(GoogleApiClient apiClient, MetadataChangeSet changeSet) {
        if (changeSet != null) {
            return apiClient.zzb(new C11474(this, apiClient, changeSet));
        }
        throw new IllegalArgumentException("ChangeSet must be provided.");
    }
}
