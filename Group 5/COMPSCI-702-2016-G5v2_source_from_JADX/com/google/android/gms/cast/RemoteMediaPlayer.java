package com.google.android.gms.cast;

import android.annotation.SuppressLint;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzm;
import com.google.android.gms.cast.internal.zzn;
import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.GamesStatusCodes;
import java.io.IOException;
import java.util.Locale;
import org.json.JSONObject;

@SuppressLint({"MissingRemoteException"})
public class RemoteMediaPlayer implements MessageReceivedCallback {
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2101;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 2102;
    private final zzm zzabE;
    private final zza zzabF;
    private OnPreloadStatusUpdatedListener zzabG;
    private OnQueueStatusUpdatedListener zzabH;
    private OnMetadataUpdatedListener zzabI;
    private OnStatusUpdatedListener zzabJ;
    private final Object zzpV;

    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    public interface OnPreloadStatusUpdatedListener {
        void onPreloadStatusUpdated();
    }

    public interface OnQueueStatusUpdatedListener {
        void onQueueStatusUpdated();
    }

    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    public interface MediaChannelResult extends Result {
        JSONObject getCustomData();
    }

    private class zza implements zzn {
        final /* synthetic */ RemoteMediaPlayer zzabK;
        private GoogleApiClient zzaci;
        private long zzacj;

        private final class zza implements ResultCallback<Status> {
            private final long zzack;
            final /* synthetic */ zza zzacl;

            zza(zza com_google_android_gms_cast_RemoteMediaPlayer_zza, long j) {
                this.zzacl = com_google_android_gms_cast_RemoteMediaPlayer_zza;
                this.zzack = j;
            }

            public /* synthetic */ void onResult(Result result) {
                zzp((Status) result);
            }

            public void zzp(Status status) {
                if (!status.isSuccess()) {
                    this.zzacl.zzabK.zzabE.zzb(this.zzack, status.getStatusCode());
                }
            }
        }

        public zza(RemoteMediaPlayer remoteMediaPlayer) {
            this.zzabK = remoteMediaPlayer;
            this.zzacj = 0;
        }

        public void zza(String str, String str2, long j, String str3) throws IOException {
            if (this.zzaci == null) {
                throw new IOException("No GoogleApiClient available");
            }
            Cast.CastApi.sendMessage(this.zzaci, str, str2).setResultCallback(new zza(this, j));
        }

        public void zzc(GoogleApiClient googleApiClient) {
            this.zzaci = googleApiClient;
        }

        public long zznQ() {
            long j = this.zzacj + 1;
            this.zzacj = j;
            return j;
        }
    }

    private static final class zzc implements MediaChannelResult {
        private final Status zzUX;
        private final JSONObject zzaaU;

        zzc(Status status, JSONObject jSONObject) {
            this.zzUX = status;
            this.zzaaU = jSONObject;
        }

        public JSONObject getCustomData() {
            return this.zzaaU;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.1 */
    class C10451 extends zzm {
        final /* synthetic */ RemoteMediaPlayer zzabK;

        C10451(RemoteMediaPlayer remoteMediaPlayer, String str) {
            this.zzabK = remoteMediaPlayer;
            super(str);
        }

        protected void onMetadataUpdated() {
            this.zzabK.onMetadataUpdated();
        }

        protected void onPreloadStatusUpdated() {
            this.zzabK.onPreloadStatusUpdated();
        }

        protected void onQueueStatusUpdated() {
            this.zzabK.onQueueStatusUpdated();
        }

        protected void onStatusUpdated() {
            this.zzabK.onStatusUpdated();
        }
    }

    private static abstract class zzb extends com.google.android.gms.cast.internal.zzb<MediaChannelResult> {
        zzo zzacm;

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.zzb.1 */
        class C07361 implements zzo {
            final /* synthetic */ zzb zzacn;

            C07361(zzb com_google_android_gms_cast_RemoteMediaPlayer_zzb) {
                this.zzacn = com_google_android_gms_cast_RemoteMediaPlayer_zzb;
            }

            public void zza(long j, int i, Object obj) {
                this.zzacn.zza(new zzc(new Status(i), obj instanceof JSONObject ? (JSONObject) obj : null));
            }

            public void zzy(long j) {
                this.zzacn.zza(this.zzacn.zzq(new Status(RemoteMediaPlayer.STATUS_REPLACED)));
            }
        }

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.zzb.2 */
        class C09522 implements MediaChannelResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ zzb zzacn;

            C09522(zzb com_google_android_gms_cast_RemoteMediaPlayer_zzb, Status status) {
                this.zzacn = com_google_android_gms_cast_RemoteMediaPlayer_zzb;
                this.zzZR = status;
            }

            public JSONObject getCustomData() {
                return null;
            }

            public Status getStatus() {
                return this.zzZR;
            }
        }

        zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzacm = new C07361(this);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzq(status);
        }

        public MediaChannelResult zzq(Status status) {
            return new C09522(this, status);
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.10 */
    class AnonymousClass10 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzabK;
        final /* synthetic */ GoogleApiClient zzabL;
        final /* synthetic */ JSONObject zzabS;

        AnonymousClass10(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, JSONObject jSONObject) {
            this.zzabK = remoteMediaPlayer;
            this.zzabL = googleApiClient2;
            this.zzabS = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzabK.zzpV) {
                this.zzabK.zzabF.zzc(this.zzabL);
                try {
                    this.zzabK.zzabE.zza(this.zzacm, (int) RemoteMediaPlayer.STATUS_SUCCEEDED, -1, null, -1, null, this.zzabS);
                    this.zzabK.zzabF.zzc(null);
                } catch (IOException e) {
                    zza(zzq(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzabK.zzabF.zzc(null);
                } catch (Throwable th) {
                    this.zzabK.zzabF.zzc(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.11 */
    class AnonymousClass11 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzabK;
        final /* synthetic */ GoogleApiClient zzabL;
        final /* synthetic */ JSONObject zzabS;

        AnonymousClass11(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, JSONObject jSONObject) {
            this.zzabK = remoteMediaPlayer;
            this.zzabL = googleApiClient2;
            this.zzabS = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzabK.zzpV) {
                this.zzabK.zzabF.zzc(this.zzabL);
                try {
                    this.zzabK.zzabE.zza(this.zzacm, (int) RemoteMediaPlayer.STATUS_SUCCEEDED, -1, null, (int) RemoteMediaPlayer.RESUME_STATE_PLAY, null, this.zzabS);
                    this.zzabK.zzabF.zzc(null);
                } catch (IOException e) {
                    zza(zzq(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzabK.zzabF.zzc(null);
                } catch (Throwable th) {
                    this.zzabK.zzabF.zzc(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.12 */
    class AnonymousClass12 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzabK;
        final /* synthetic */ GoogleApiClient zzabL;
        final /* synthetic */ long zzabR;
        final /* synthetic */ JSONObject zzabS;
        final /* synthetic */ MediaInfo zzabZ;
        final /* synthetic */ boolean zzaca;
        final /* synthetic */ long[] zzacb;

        AnonymousClass12(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, MediaInfo mediaInfo, boolean z, long j, long[] jArr, JSONObject jSONObject) {
            this.zzabK = remoteMediaPlayer;
            this.zzabL = googleApiClient2;
            this.zzabZ = mediaInfo;
            this.zzaca = z;
            this.zzabR = j;
            this.zzacb = jArr;
            this.zzabS = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzabK.zzpV) {
                this.zzabK.zzabF.zzc(this.zzabL);
                try {
                    this.zzabK.zzabE.zza(this.zzacm, this.zzabZ, this.zzaca, this.zzabR, this.zzacb, this.zzabS);
                    this.zzabK.zzabF.zzc(null);
                } catch (IOException e) {
                    zza(zzq(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzabK.zzabF.zzc(null);
                } catch (Throwable th) {
                    this.zzabK.zzabF.zzc(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.13 */
    class AnonymousClass13 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzabK;
        final /* synthetic */ GoogleApiClient zzabL;
        final /* synthetic */ int zzabQ;
        final /* synthetic */ JSONObject zzabS;

        AnonymousClass13(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, int i, JSONObject jSONObject) {
            this.zzabK = remoteMediaPlayer;
            this.zzabL = googleApiClient2;
            this.zzabQ = i;
            this.zzabS = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzabK.zzpV) {
                this.zzabK.zzabF.zzc(this.zzabL);
                try {
                    this.zzabK.zzabE.zza(this.zzacm, (int) RemoteMediaPlayer.STATUS_SUCCEEDED, -1, null, (int) RemoteMediaPlayer.STATUS_SUCCEEDED, Integer.valueOf(this.zzabQ), this.zzabS);
                    this.zzabK.zzabF.zzc(null);
                } catch (IOException e) {
                    zza(zzq(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzabK.zzabF.zzc(null);
                } catch (Throwable th) {
                    this.zzabK.zzabF.zzc(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.14 */
    class AnonymousClass14 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzabK;
        final /* synthetic */ GoogleApiClient zzabL;
        final /* synthetic */ JSONObject zzabS;
        final /* synthetic */ int zzacc;

        AnonymousClass14(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, int i, GoogleApiClient googleApiClient2, JSONObject jSONObject) {
            this.zzabK = remoteMediaPlayer;
            this.zzacc = i;
            this.zzabL = googleApiClient2;
            this.zzabS = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzabK.zzpV) {
                if (this.zzabK.zzbf(this.zzacc) == -1) {
                    zza(zzq(new Status(RemoteMediaPlayer.STATUS_SUCCEEDED)));
                    return;
                }
                this.zzabK.zzabF.zzc(this.zzabL);
                try {
                    zzm zzg = this.zzabK.zzabE;
                    zzo com_google_android_gms_cast_internal_zzo = this.zzacm;
                    int[] iArr = new int[RemoteMediaPlayer.RESUME_STATE_PLAY];
                    iArr[RemoteMediaPlayer.STATUS_SUCCEEDED] = this.zzacc;
                    zzg.zza(com_google_android_gms_cast_internal_zzo, iArr, this.zzabS);
                } catch (IOException e) {
                    zza(zzq(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                } finally {
                    this.zzabK.zzabF.zzc(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.15 */
    class AnonymousClass15 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzabK;
        final /* synthetic */ GoogleApiClient zzabL;
        final /* synthetic */ long zzabR;
        final /* synthetic */ JSONObject zzabS;
        final /* synthetic */ int zzacc;

        AnonymousClass15(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, int i, GoogleApiClient googleApiClient2, long j, JSONObject jSONObject) {
            this.zzabK = remoteMediaPlayer;
            this.zzacc = i;
            this.zzabL = googleApiClient2;
            this.zzabR = j;
            this.zzabS = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzabK.zzpV) {
                if (this.zzabK.zzbf(this.zzacc) == -1) {
                    zza(zzq(new Status(RemoteMediaPlayer.STATUS_SUCCEEDED)));
                    return;
                }
                this.zzabK.zzabF.zzc(this.zzabL);
                try {
                    this.zzabK.zzabE.zza(this.zzacm, this.zzacc, this.zzabR, null, (int) RemoteMediaPlayer.STATUS_SUCCEEDED, null, this.zzabS);
                } catch (IOException e) {
                    zza(zzq(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                } finally {
                    this.zzabK.zzabF.zzc(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.16 */
    class AnonymousClass16 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzabK;
        final /* synthetic */ GoogleApiClient zzabL;
        final /* synthetic */ JSONObject zzabS;
        final /* synthetic */ int zzacc;
        final /* synthetic */ int zzacd;

        AnonymousClass16(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, int i, int i2, GoogleApiClient googleApiClient2, JSONObject jSONObject) {
            this.zzabK = remoteMediaPlayer;
            this.zzacc = i;
            this.zzacd = i2;
            this.zzabL = googleApiClient2;
            this.zzabS = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            int i = RemoteMediaPlayer.STATUS_SUCCEEDED;
            synchronized (this.zzabK.zzpV) {
                int zza = this.zzabK.zzbf(this.zzacc);
                if (zza == -1) {
                    zza(zzq(new Status(RemoteMediaPlayer.STATUS_SUCCEEDED)));
                } else if (this.zzacd < 0) {
                    Object[] objArr = new Object[RemoteMediaPlayer.RESUME_STATE_PLAY];
                    objArr[RemoteMediaPlayer.STATUS_SUCCEEDED] = Integer.valueOf(this.zzacd);
                    zza(zzq(new Status(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE, String.format(Locale.ROOT, "Invalid request: Invalid newIndex %d.", objArr))));
                } else if (zza == this.zzacd) {
                    zza(zzq(new Status(RemoteMediaPlayer.STATUS_SUCCEEDED)));
                } else {
                    MediaQueueItem queueItem = this.zzabK.getMediaStatus().getQueueItem(this.zzacd > zza ? this.zzacd + RemoteMediaPlayer.RESUME_STATE_PLAY : this.zzacd);
                    if (queueItem != null) {
                        i = queueItem.getItemId();
                    }
                    this.zzabK.zzabF.zzc(this.zzabL);
                    try {
                        zzm zzg = this.zzabK.zzabE;
                        zzo com_google_android_gms_cast_internal_zzo = this.zzacm;
                        int[] iArr = new int[RemoteMediaPlayer.RESUME_STATE_PLAY];
                        iArr[RemoteMediaPlayer.STATUS_SUCCEEDED] = this.zzacc;
                        zzg.zza(com_google_android_gms_cast_internal_zzo, iArr, i, this.zzabS);
                    } catch (IOException e) {
                        zza(zzq(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.zzabK.zzabF.zzc(null);
                    }
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.17 */
    class AnonymousClass17 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzabK;
        final /* synthetic */ GoogleApiClient zzabL;
        final /* synthetic */ JSONObject zzabS;

        AnonymousClass17(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, JSONObject jSONObject) {
            this.zzabK = remoteMediaPlayer;
            this.zzabL = googleApiClient2;
            this.zzabS = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzabK.zzpV) {
                this.zzabK.zzabF.zzc(this.zzabL);
                try {
                    this.zzabK.zzabE.zza(this.zzacm, this.zzabS);
                    this.zzabK.zzabF.zzc(null);
                } catch (IOException e) {
                    zza(zzq(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzabK.zzabF.zzc(null);
                } catch (Throwable th) {
                    this.zzabK.zzabF.zzc(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.18 */
    class AnonymousClass18 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzabK;
        final /* synthetic */ GoogleApiClient zzabL;
        final /* synthetic */ JSONObject zzabS;

        AnonymousClass18(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, JSONObject jSONObject) {
            this.zzabK = remoteMediaPlayer;
            this.zzabL = googleApiClient2;
            this.zzabS = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzabK.zzpV) {
                this.zzabK.zzabF.zzc(this.zzabL);
                try {
                    this.zzabK.zzabE.zzb(this.zzacm, this.zzabS);
                    this.zzabK.zzabF.zzc(null);
                } catch (IOException e) {
                    zza(zzq(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzabK.zzabF.zzc(null);
                } catch (Throwable th) {
                    this.zzabK.zzabF.zzc(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.19 */
    class AnonymousClass19 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzabK;
        final /* synthetic */ GoogleApiClient zzabL;
        final /* synthetic */ JSONObject zzabS;

        AnonymousClass19(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, JSONObject jSONObject) {
            this.zzabK = remoteMediaPlayer;
            this.zzabL = googleApiClient2;
            this.zzabS = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzabK.zzpV) {
                this.zzabK.zzabF.zzc(this.zzabL);
                try {
                    this.zzabK.zzabE.zzc(this.zzacm, this.zzabS);
                    this.zzabK.zzabF.zzc(null);
                } catch (IOException e) {
                    zza(zzq(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzabK.zzabF.zzc(null);
                } catch (Throwable th) {
                    this.zzabK.zzabF.zzc(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.20 */
    class AnonymousClass20 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzabK;
        final /* synthetic */ GoogleApiClient zzabL;
        final /* synthetic */ JSONObject zzabS;
        final /* synthetic */ long zzace;
        final /* synthetic */ int zzacf;

        AnonymousClass20(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, long j, int i, JSONObject jSONObject) {
            this.zzabK = remoteMediaPlayer;
            this.zzabL = googleApiClient2;
            this.zzace = j;
            this.zzacf = i;
            this.zzabS = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzabK.zzpV) {
                this.zzabK.zzabF.zzc(this.zzabL);
                try {
                    this.zzabK.zzabE.zza(this.zzacm, this.zzace, this.zzacf, this.zzabS);
                    this.zzabK.zzabF.zzc(null);
                } catch (IOException e) {
                    zza(zzq(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzabK.zzabF.zzc(null);
                } catch (Throwable th) {
                    this.zzabK.zzabF.zzc(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.21 */
    class AnonymousClass21 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzabK;
        final /* synthetic */ GoogleApiClient zzabL;
        final /* synthetic */ JSONObject zzabS;
        final /* synthetic */ double zzacg;

        AnonymousClass21(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, double d, JSONObject jSONObject) {
            this.zzabK = remoteMediaPlayer;
            this.zzabL = googleApiClient2;
            this.zzacg = d;
            this.zzabS = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzabK.zzpV) {
                this.zzabK.zzabF.zzc(this.zzabL);
                try {
                    this.zzabK.zzabE.zza(this.zzacm, this.zzacg, this.zzabS);
                    this.zzabK.zzabF.zzc(null);
                } catch (IllegalStateException e) {
                    try {
                        zza(zzq(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.zzabK.zzabF.zzc(null);
                    }
                } catch (IllegalArgumentException e2) {
                    zza(zzq(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                } catch (IOException e3) {
                    zza(zzq(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.22 */
    class AnonymousClass22 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzabK;
        final /* synthetic */ GoogleApiClient zzabL;
        final /* synthetic */ JSONObject zzabS;
        final /* synthetic */ boolean zzach;

        AnonymousClass22(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, boolean z, JSONObject jSONObject) {
            this.zzabK = remoteMediaPlayer;
            this.zzabL = googleApiClient2;
            this.zzach = z;
            this.zzabS = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzabK.zzpV) {
                this.zzabK.zzabF.zzc(this.zzabL);
                try {
                    this.zzabK.zzabE.zza(this.zzacm, this.zzach, this.zzabS);
                    this.zzabK.zzabF.zzc(null);
                } catch (IllegalStateException e) {
                    try {
                        zza(zzq(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.zzabK.zzabF.zzc(null);
                    }
                } catch (IOException e2) {
                    zza(zzq(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.23 */
    class AnonymousClass23 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzabK;
        final /* synthetic */ GoogleApiClient zzabL;

        AnonymousClass23(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2) {
            this.zzabK = remoteMediaPlayer;
            this.zzabL = googleApiClient2;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzabK.zzpV) {
                this.zzabK.zzabF.zzc(this.zzabL);
                try {
                    this.zzabK.zzabE.zza(this.zzacm);
                    this.zzabK.zzabF.zzc(null);
                } catch (IOException e) {
                    zza(zzq(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzabK.zzabF.zzc(null);
                } catch (Throwable th) {
                    this.zzabK.zzabF.zzc(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.2 */
    class C11342 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzabK;
        final /* synthetic */ GoogleApiClient zzabL;
        final /* synthetic */ long[] zzabM;

        C11342(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, long[] jArr) {
            this.zzabK = remoteMediaPlayer;
            this.zzabL = googleApiClient2;
            this.zzabM = jArr;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzabK.zzpV) {
                this.zzabK.zzabF.zzc(this.zzabL);
                try {
                    this.zzabK.zzabE.zza(this.zzacm, this.zzabM);
                    this.zzabK.zzabF.zzc(null);
                } catch (IOException e) {
                    zza(zzq(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzabK.zzabF.zzc(null);
                } catch (Throwable th) {
                    this.zzabK.zzabF.zzc(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.3 */
    class C11353 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzabK;
        final /* synthetic */ GoogleApiClient zzabL;
        final /* synthetic */ TextTrackStyle zzabN;

        C11353(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, TextTrackStyle textTrackStyle) {
            this.zzabK = remoteMediaPlayer;
            this.zzabL = googleApiClient2;
            this.zzabN = textTrackStyle;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzabK.zzpV) {
                this.zzabK.zzabF.zzc(this.zzabL);
                try {
                    this.zzabK.zzabE.zza(this.zzacm, this.zzabN);
                    this.zzabK.zzabF.zzc(null);
                } catch (IOException e) {
                    zza(zzq(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzabK.zzabF.zzc(null);
                } catch (Throwable th) {
                    this.zzabK.zzabF.zzc(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.4 */
    class C11364 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzabK;
        final /* synthetic */ GoogleApiClient zzabL;
        final /* synthetic */ MediaQueueItem[] zzabO;
        final /* synthetic */ int zzabP;
        final /* synthetic */ int zzabQ;
        final /* synthetic */ long zzabR;
        final /* synthetic */ JSONObject zzabS;

        C11364(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, MediaQueueItem[] mediaQueueItemArr, int i, int i2, long j, JSONObject jSONObject) {
            this.zzabK = remoteMediaPlayer;
            this.zzabL = googleApiClient2;
            this.zzabO = mediaQueueItemArr;
            this.zzabP = i;
            this.zzabQ = i2;
            this.zzabR = j;
            this.zzabS = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzabK.zzpV) {
                this.zzabK.zzabF.zzc(this.zzabL);
                try {
                    this.zzabK.zzabE.zza(this.zzacm, this.zzabO, this.zzabP, this.zzabQ, this.zzabR, this.zzabS);
                    this.zzabK.zzabF.zzc(null);
                } catch (IOException e) {
                    zza(zzq(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzabK.zzabF.zzc(null);
                } catch (Throwable th) {
                    this.zzabK.zzabF.zzc(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.5 */
    class C11375 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzabK;
        final /* synthetic */ GoogleApiClient zzabL;
        final /* synthetic */ JSONObject zzabS;
        final /* synthetic */ MediaQueueItem[] zzabT;
        final /* synthetic */ int zzabU;

        C11375(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, MediaQueueItem[] mediaQueueItemArr, int i, JSONObject jSONObject) {
            this.zzabK = remoteMediaPlayer;
            this.zzabL = googleApiClient2;
            this.zzabT = mediaQueueItemArr;
            this.zzabU = i;
            this.zzabS = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzabK.zzpV) {
                this.zzabK.zzabF.zzc(this.zzabL);
                try {
                    this.zzabK.zzabE.zza(this.zzacm, this.zzabT, this.zzabU, (int) RemoteMediaPlayer.STATUS_SUCCEEDED, -1, -1, this.zzabS);
                    this.zzabK.zzabF.zzc(null);
                } catch (IOException e) {
                    zza(zzq(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzabK.zzabF.zzc(null);
                } catch (Throwable th) {
                    this.zzabK.zzabF.zzc(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.6 */
    class C11386 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzabK;
        final /* synthetic */ GoogleApiClient zzabL;
        final /* synthetic */ long zzabR;
        final /* synthetic */ JSONObject zzabS;
        final /* synthetic */ int zzabU;
        final /* synthetic */ MediaQueueItem zzabV;

        C11386(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, MediaQueueItem mediaQueueItem, int i, long j, JSONObject jSONObject) {
            this.zzabK = remoteMediaPlayer;
            this.zzabL = googleApiClient2;
            this.zzabV = mediaQueueItem;
            this.zzabU = i;
            this.zzabR = j;
            this.zzabS = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzabK.zzpV) {
                this.zzabK.zzabF.zzc(this.zzabL);
                try {
                    zzm zzg = this.zzabK.zzabE;
                    zzo com_google_android_gms_cast_internal_zzo = this.zzacm;
                    MediaQueueItem[] mediaQueueItemArr = new MediaQueueItem[RemoteMediaPlayer.RESUME_STATE_PLAY];
                    mediaQueueItemArr[RemoteMediaPlayer.STATUS_SUCCEEDED] = this.zzabV;
                    zzg.zza(com_google_android_gms_cast_internal_zzo, mediaQueueItemArr, this.zzabU, (int) RemoteMediaPlayer.STATUS_SUCCEEDED, (int) RemoteMediaPlayer.STATUS_SUCCEEDED, this.zzabR, this.zzabS);
                    this.zzabK.zzabF.zzc(null);
                } catch (IOException e) {
                    zza(zzq(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzabK.zzabF.zzc(null);
                } catch (Throwable th) {
                    this.zzabK.zzabF.zzc(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.7 */
    class C11397 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzabK;
        final /* synthetic */ GoogleApiClient zzabL;
        final /* synthetic */ JSONObject zzabS;
        final /* synthetic */ MediaQueueItem[] zzabW;

        C11397(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, MediaQueueItem[] mediaQueueItemArr, JSONObject jSONObject) {
            this.zzabK = remoteMediaPlayer;
            this.zzabL = googleApiClient2;
            this.zzabW = mediaQueueItemArr;
            this.zzabS = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzabK.zzpV) {
                this.zzabK.zzabF.zzc(this.zzabL);
                try {
                    this.zzabK.zzabE.zza(this.zzacm, (int) RemoteMediaPlayer.STATUS_SUCCEEDED, -1, this.zzabW, (int) RemoteMediaPlayer.STATUS_SUCCEEDED, null, this.zzabS);
                    this.zzabK.zzabF.zzc(null);
                } catch (IOException e) {
                    zza(zzq(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzabK.zzabF.zzc(null);
                } catch (Throwable th) {
                    this.zzabK.zzabF.zzc(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.8 */
    class C11408 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzabK;
        final /* synthetic */ GoogleApiClient zzabL;
        final /* synthetic */ JSONObject zzabS;
        final /* synthetic */ int[] zzabX;

        C11408(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, int[] iArr, JSONObject jSONObject) {
            this.zzabK = remoteMediaPlayer;
            this.zzabL = googleApiClient2;
            this.zzabX = iArr;
            this.zzabS = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzabK.zzpV) {
                this.zzabK.zzabF.zzc(this.zzabL);
                try {
                    this.zzabK.zzabE.zza(this.zzacm, this.zzabX, this.zzabS);
                    this.zzabK.zzabF.zzc(null);
                } catch (IOException e) {
                    zza(zzq(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzabK.zzabF.zzc(null);
                } catch (Throwable th) {
                    this.zzabK.zzabF.zzc(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.9 */
    class C11419 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzabK;
        final /* synthetic */ GoogleApiClient zzabL;
        final /* synthetic */ JSONObject zzabS;
        final /* synthetic */ int zzabU;
        final /* synthetic */ int[] zzabY;

        C11419(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, int[] iArr, int i, JSONObject jSONObject) {
            this.zzabK = remoteMediaPlayer;
            this.zzabL = googleApiClient2;
            this.zzabY = iArr;
            this.zzabU = i;
            this.zzabS = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzabK.zzpV) {
                this.zzabK.zzabF.zzc(this.zzabL);
                try {
                    this.zzabK.zzabE.zza(this.zzacm, this.zzabY, this.zzabU, this.zzabS);
                    this.zzabK.zzabF.zzc(null);
                } catch (IOException e) {
                    zza(zzq(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzabK.zzabF.zzc(null);
                } catch (Throwable th) {
                    this.zzabK.zzabF.zzc(null);
                }
            }
        }
    }

    public RemoteMediaPlayer() {
        this.zzpV = new Object();
        this.zzabF = new zza(this);
        this.zzabE = new C10451(this, null);
        this.zzabE.zza(this.zzabF);
    }

    private void onMetadataUpdated() {
        if (this.zzabI != null) {
            this.zzabI.onMetadataUpdated();
        }
    }

    private void onPreloadStatusUpdated() {
        if (this.zzabG != null) {
            this.zzabG.onPreloadStatusUpdated();
        }
    }

    private void onQueueStatusUpdated() {
        if (this.zzabH != null) {
            this.zzabH.onQueueStatusUpdated();
        }
    }

    private void onStatusUpdated() {
        if (this.zzabJ != null) {
            this.zzabJ.onStatusUpdated();
        }
    }

    private int zzbf(int i) {
        MediaStatus mediaStatus = getMediaStatus();
        for (int i2 = STATUS_SUCCEEDED; i2 < mediaStatus.getQueueItemCount(); i2 += RESUME_STATE_PLAY) {
            if (mediaStatus.getQueueItem(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public long getApproximateStreamPosition() {
        long approximateStreamPosition;
        synchronized (this.zzpV) {
            approximateStreamPosition = this.zzabE.getApproximateStreamPosition();
        }
        return approximateStreamPosition;
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo;
        synchronized (this.zzpV) {
            mediaInfo = this.zzabE.getMediaInfo();
        }
        return mediaInfo;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus mediaStatus;
        synchronized (this.zzpV) {
            mediaStatus = this.zzabE.getMediaStatus();
        }
        return mediaStatus;
    }

    public String getNamespace() {
        return this.zzabE.getNamespace();
    }

    public long getStreamDuration() {
        long streamDuration;
        synchronized (this.zzpV) {
            streamDuration = this.zzabE.getStreamDuration();
        }
        return streamDuration;
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo) {
        return load(apiClient, mediaInfo, true, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay) {
        return load(apiClient, mediaInfo, autoplay, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, JSONObject customData) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null, customData);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, long[] activeTrackIds, JSONObject customData) {
        return apiClient.zzb(new AnonymousClass12(this, apiClient, apiClient, mediaInfo, autoplay, playPosition, activeTrackIds, customData));
    }

    public void onMessageReceived(CastDevice castDevice, String namespace, String message) {
        this.zzabE.zzcf(message);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient apiClient) {
        return pause(apiClient, null);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient apiClient, JSONObject customData) {
        return apiClient.zzb(new AnonymousClass17(this, apiClient, apiClient, customData));
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient apiClient) {
        return play(apiClient, null);
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient apiClient, JSONObject customData) {
        return apiClient.zzb(new AnonymousClass19(this, apiClient, apiClient, customData));
    }

    public PendingResult<MediaChannelResult> queueAppendItem(GoogleApiClient apiClient, MediaQueueItem item, JSONObject customData) throws IllegalArgumentException {
        MediaQueueItem[] mediaQueueItemArr = new MediaQueueItem[RESUME_STATE_PLAY];
        mediaQueueItemArr[STATUS_SUCCEEDED] = item;
        return queueInsertItems(apiClient, mediaQueueItemArr, STATUS_SUCCEEDED, customData);
    }

    public PendingResult<MediaChannelResult> queueInsertAndPlayItem(GoogleApiClient apiClient, MediaQueueItem item, int insertBeforeItemId, long playPosition, JSONObject customData) {
        return apiClient.zzb(new C11386(this, apiClient, apiClient, item, insertBeforeItemId, playPosition, customData));
    }

    public PendingResult<MediaChannelResult> queueInsertAndPlayItem(GoogleApiClient apiClient, MediaQueueItem item, int insertBeforeItemId, JSONObject customData) {
        return queueInsertAndPlayItem(apiClient, item, insertBeforeItemId, -1, customData);
    }

    public PendingResult<MediaChannelResult> queueInsertItems(GoogleApiClient apiClient, MediaQueueItem[] itemsToInsert, int insertBeforeItemId, JSONObject customData) throws IllegalArgumentException {
        return apiClient.zzb(new C11375(this, apiClient, apiClient, itemsToInsert, insertBeforeItemId, customData));
    }

    public PendingResult<MediaChannelResult> queueJumpToItem(GoogleApiClient apiClient, int itemId, long playPosition, JSONObject customData) {
        return apiClient.zzb(new AnonymousClass15(this, apiClient, itemId, apiClient, playPosition, customData));
    }

    public PendingResult<MediaChannelResult> queueJumpToItem(GoogleApiClient apiClient, int itemId, JSONObject customData) {
        return queueJumpToItem(apiClient, itemId, -1, customData);
    }

    public PendingResult<MediaChannelResult> queueLoad(GoogleApiClient apiClient, MediaQueueItem[] items, int startIndex, int repeatMode, long playPosition, JSONObject customData) throws IllegalArgumentException {
        return apiClient.zzb(new C11364(this, apiClient, apiClient, items, startIndex, repeatMode, playPosition, customData));
    }

    public PendingResult<MediaChannelResult> queueLoad(GoogleApiClient apiClient, MediaQueueItem[] items, int startIndex, int repeatMode, JSONObject customData) throws IllegalArgumentException {
        return queueLoad(apiClient, items, startIndex, repeatMode, -1, customData);
    }

    public PendingResult<MediaChannelResult> queueMoveItemToNewIndex(GoogleApiClient apiClient, int itemId, int newIndex, JSONObject customData) {
        return apiClient.zzb(new AnonymousClass16(this, apiClient, itemId, newIndex, apiClient, customData));
    }

    public PendingResult<MediaChannelResult> queueNext(GoogleApiClient apiClient, JSONObject customData) {
        return apiClient.zzb(new AnonymousClass11(this, apiClient, apiClient, customData));
    }

    public PendingResult<MediaChannelResult> queuePrev(GoogleApiClient apiClient, JSONObject customData) {
        return apiClient.zzb(new AnonymousClass10(this, apiClient, apiClient, customData));
    }

    public PendingResult<MediaChannelResult> queueRemoveItem(GoogleApiClient apiClient, int itemId, JSONObject customData) {
        return apiClient.zzb(new AnonymousClass14(this, apiClient, itemId, apiClient, customData));
    }

    public PendingResult<MediaChannelResult> queueRemoveItems(GoogleApiClient apiClient, int[] itemIdsToRemove, JSONObject customData) throws IllegalArgumentException {
        return apiClient.zzb(new C11408(this, apiClient, apiClient, itemIdsToRemove, customData));
    }

    public PendingResult<MediaChannelResult> queueReorderItems(GoogleApiClient apiClient, int[] itemIdsToReorder, int insertBeforeItemId, JSONObject customData) throws IllegalArgumentException {
        return apiClient.zzb(new C11419(this, apiClient, apiClient, itemIdsToReorder, insertBeforeItemId, customData));
    }

    public PendingResult<MediaChannelResult> queueSetRepeatMode(GoogleApiClient apiClient, int repeatMode, JSONObject customData) {
        return apiClient.zzb(new AnonymousClass13(this, apiClient, apiClient, repeatMode, customData));
    }

    public PendingResult<MediaChannelResult> queueUpdateItems(GoogleApiClient apiClient, MediaQueueItem[] itemsToUpdate, JSONObject customData) {
        return apiClient.zzb(new C11397(this, apiClient, apiClient, itemsToUpdate, customData));
    }

    public PendingResult<MediaChannelResult> requestStatus(GoogleApiClient apiClient) {
        return apiClient.zzb(new AnonymousClass23(this, apiClient, apiClient));
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position) {
        return seek(apiClient, position, STATUS_SUCCEEDED, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState) {
        return seek(apiClient, position, resumeState, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState, JSONObject customData) {
        return apiClient.zzb(new AnonymousClass20(this, apiClient, apiClient, position, resumeState, customData));
    }

    public PendingResult<MediaChannelResult> setActiveMediaTracks(GoogleApiClient apiClient, long[] trackIds) {
        if (trackIds != null) {
            return apiClient.zzb(new C11342(this, apiClient, apiClient, trackIds));
        }
        throw new IllegalArgumentException("trackIds cannot be null");
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener listener) {
        this.zzabI = listener;
    }

    public void setOnPreloadStatusUpdatedListener(OnPreloadStatusUpdatedListener listener) {
        this.zzabG = listener;
    }

    public void setOnQueueStatusUpdatedListener(OnQueueStatusUpdatedListener listener) {
        this.zzabH = listener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener listener) {
        this.zzabJ = listener;
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState) {
        return setStreamMute(apiClient, muteState, null);
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState, JSONObject customData) {
        return apiClient.zzb(new AnonymousClass22(this, apiClient, apiClient, muteState, customData));
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume) throws IllegalArgumentException {
        return setStreamVolume(apiClient, volume, null);
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume, JSONObject customData) throws IllegalArgumentException {
        if (!Double.isInfinite(volume) && !Double.isNaN(volume)) {
            return apiClient.zzb(new AnonymousClass21(this, apiClient, apiClient, volume, customData));
        }
        throw new IllegalArgumentException("Volume cannot be " + volume);
    }

    public PendingResult<MediaChannelResult> setTextTrackStyle(GoogleApiClient apiClient, TextTrackStyle trackStyle) {
        if (trackStyle != null) {
            return apiClient.zzb(new C11353(this, apiClient, apiClient, trackStyle));
        }
        throw new IllegalArgumentException("trackStyle cannot be null");
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient apiClient) {
        return stop(apiClient, null);
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient apiClient, JSONObject customData) {
        return apiClient.zzb(new AnonymousClass18(this, apiClient, apiClient, customData));
    }
}
