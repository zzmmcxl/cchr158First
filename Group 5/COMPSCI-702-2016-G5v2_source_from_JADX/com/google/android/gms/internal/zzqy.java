package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.internal.zze;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

public final class zzqy implements Moments {

    private static abstract class zza extends com.google.android.gms.plus.Plus.zza<LoadMomentsResult> {

        /* renamed from: com.google.android.gms.internal.zzqy.zza.1 */
        class C10191 implements LoadMomentsResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ zza zzbeG;

            C10191(zza com_google_android_gms_internal_zzqy_zza, Status status) {
                this.zzbeG = com_google_android_gms_internal_zzqy_zza;
                this.zzZR = status;
            }

            public MomentBuffer getMomentBuffer() {
                return null;
            }

            public String getNextPageToken() {
                return null;
            }

            public Status getStatus() {
                return this.zzZR;
            }

            public String getUpdated() {
                return null;
            }

            public void release() {
            }
        }

        private zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadMomentsResult zzbf(Status status) {
            return new C10191(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbf(status);
        }
    }

    private static abstract class zzb extends com.google.android.gms.plus.Plus.zza<Status> {
        private zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    private static abstract class zzc extends com.google.android.gms.plus.Plus.zza<Status> {
        private zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqy.1 */
    class C12721 extends zza {
        final /* synthetic */ zzqy zzbez;

        C12721(zzqy com_google_android_gms_internal_zzqy, GoogleApiClient googleApiClient) {
            this.zzbez = com_google_android_gms_internal_zzqy;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            com_google_android_gms_plus_internal_zze.zzo(this);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqy.2 */
    class C12732 extends zza {
        final /* synthetic */ int zzaGt;
        final /* synthetic */ String zzbeA;
        final /* synthetic */ Uri zzbeB;
        final /* synthetic */ String zzbeC;
        final /* synthetic */ String zzbeD;
        final /* synthetic */ zzqy zzbez;

        C12732(zzqy com_google_android_gms_internal_zzqy, GoogleApiClient googleApiClient, int i, String str, Uri uri, String str2, String str3) {
            this.zzbez = com_google_android_gms_internal_zzqy;
            this.zzaGt = i;
            this.zzbeA = str;
            this.zzbeB = uri;
            this.zzbeC = str2;
            this.zzbeD = str3;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            com_google_android_gms_plus_internal_zze.zza(this, this.zzaGt, this.zzbeA, this.zzbeB, this.zzbeC, this.zzbeD);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqy.3 */
    class C12743 extends zzc {
        final /* synthetic */ Moment zzbeE;
        final /* synthetic */ zzqy zzbez;

        C12743(zzqy com_google_android_gms_internal_zzqy, GoogleApiClient googleApiClient, Moment moment) {
            this.zzbez = com_google_android_gms_internal_zzqy;
            this.zzbeE = moment;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            com_google_android_gms_plus_internal_zze.zza((com.google.android.gms.common.api.internal.zza.zzb) this, this.zzbeE);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqy.4 */
    class C12754 extends zzb {
        final /* synthetic */ String zzbeF;
        final /* synthetic */ zzqy zzbez;

        C12754(zzqy com_google_android_gms_internal_zzqy, GoogleApiClient googleApiClient, String str) {
            this.zzbez = com_google_android_gms_internal_zzqy;
            this.zzbeF = str;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            com_google_android_gms_plus_internal_zze.zzfG(this.zzbeF);
            zza(Status.zzagC);
        }
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<LoadMomentsResult> load(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new C12721(this, googleApiClient));
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<LoadMomentsResult> load(GoogleApiClient googleApiClient, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        return googleApiClient.zza(new C12732(this, googleApiClient, maxResults, pageToken, targetUrl, type, userId));
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<Status> remove(GoogleApiClient googleApiClient, String momentId) {
        return googleApiClient.zzb(new C12754(this, googleApiClient, momentId));
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<Status> write(GoogleApiClient googleApiClient, Moment moment) {
        return googleApiClient.zzb(new C12743(this, googleApiClient, moment));
    }
}
