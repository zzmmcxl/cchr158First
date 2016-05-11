package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.api.internal.zzq.zzb;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.drive.DriveId;

public class zzw extends zzab implements DriveFile {

    private static class zza implements DownloadProgressListener {
        private final zzq<DownloadProgressListener> zzari;

        /* renamed from: com.google.android.gms.drive.internal.zzw.zza.1 */
        class C07631 implements zzb<DownloadProgressListener> {
            final /* synthetic */ long zzarj;
            final /* synthetic */ long zzark;
            final /* synthetic */ zza zzarl;

            C07631(zza com_google_android_gms_drive_internal_zzw_zza, long j, long j2) {
                this.zzarl = com_google_android_gms_drive_internal_zzw_zza;
                this.zzarj = j;
                this.zzark = j2;
            }

            public void zza(DownloadProgressListener downloadProgressListener) {
                downloadProgressListener.onProgress(this.zzarj, this.zzark);
            }

            public void zzpr() {
            }

            public /* synthetic */ void zzt(Object obj) {
                zza((DownloadProgressListener) obj);
            }
        }

        public zza(zzq<DownloadProgressListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_drive_DriveFile_DownloadProgressListener) {
            this.zzari = com_google_android_gms_common_api_internal_zzq_com_google_android_gms_drive_DriveFile_DownloadProgressListener;
        }

        public void onProgress(long bytesDownloaded, long bytesExpected) {
            this.zzari.zza(new C07631(this, bytesDownloaded, bytesExpected));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzw.1 */
    class C11631 extends zzc {
        final /* synthetic */ int zzaqE;
        final /* synthetic */ DownloadProgressListener zzarg;
        final /* synthetic */ zzw zzarh;

        C11631(zzw com_google_android_gms_drive_internal_zzw, GoogleApiClient googleApiClient, int i, DownloadProgressListener downloadProgressListener) {
            this.zzarh = com_google_android_gms_drive_internal_zzw;
            this.zzaqE = i;
            this.zzarg = downloadProgressListener;
            super(googleApiClient);
        }

        protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
            zza(com_google_android_gms_drive_internal_zzu.zzte().zza(new OpenContentsRequest(this.zzarh.getDriveId(), this.zzaqE, 0), new zzbl(this, this.zzarg)).zztj());
        }
    }

    public zzw(DriveId driveId) {
        super(driveId);
    }

    private static DownloadProgressListener zza(GoogleApiClient googleApiClient, DownloadProgressListener downloadProgressListener) {
        return downloadProgressListener == null ? null : new zza(googleApiClient.zzr(downloadProgressListener));
    }

    public PendingResult<DriveContentsResult> open(GoogleApiClient apiClient, int mode, DownloadProgressListener listener) {
        if (mode == DriveFile.MODE_READ_ONLY || mode == DriveFile.MODE_WRITE_ONLY || mode == DriveFile.MODE_READ_WRITE) {
            return apiClient.zza(new C11631(this, apiClient, mode, zza(apiClient, listener)));
        }
        throw new IllegalArgumentException("Invalid mode provided.");
    }
}
