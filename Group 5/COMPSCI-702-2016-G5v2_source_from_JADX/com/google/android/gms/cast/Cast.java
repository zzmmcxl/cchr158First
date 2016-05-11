package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions.Builder;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzh;
import com.google.android.gms.cast.internal.zzk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.GamesStatusCodes;
import com.woop.tryreverseengineerthis.BuildConfig;
import java.io.IOException;

public final class Cast {
    public static final int ACTIVE_INPUT_STATE_NO = 0;
    public static final int ACTIVE_INPUT_STATE_UNKNOWN = -1;
    public static final int ACTIVE_INPUT_STATE_YES = 1;
    public static final Api<CastOptions> API;
    public static final CastApi CastApi;
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;
    public static final int STANDBY_STATE_NO = 0;
    public static final int STANDBY_STATE_UNKNOWN = -1;
    public static final int STANDBY_STATE_YES = 1;
    private static final com.google.android.gms.common.api.Api.zza<zze, CastOptions> zzUJ;

    public interface CastApi {

        public static final class zza implements CastApi {

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.zza.1 */
            class C11271 extends zzh {
                final /* synthetic */ String zzZG;
                final /* synthetic */ zza zzZH;
                final /* synthetic */ String zzzW;

                C11271(zza com_google_android_gms_cast_Cast_CastApi_zza, GoogleApiClient googleApiClient, String str, String str2) {
                    this.zzZH = com_google_android_gms_cast_Cast_CastApi_zza;
                    this.zzZG = str;
                    this.zzzW = str2;
                    super(googleApiClient);
                }

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                protected void zza(com.google.android.gms.cast.internal.zze r3) throws android.os.RemoteException {
                    /*
                    r2 = this;
                    r0 = r2.zzZG;	 Catch:{ IllegalArgumentException -> 0x000f, IllegalStateException -> 0x0008 }
                    r1 = r2.zzzW;	 Catch:{ IllegalArgumentException -> 0x000f, IllegalStateException -> 0x0008 }
                    r3.zza(r0, r1, r2);	 Catch:{ IllegalArgumentException -> 0x000f, IllegalStateException -> 0x0008 }
                L_0x0007:
                    return;
                L_0x0008:
                    r0 = move-exception;
                L_0x0009:
                    r0 = 2001; // 0x7d1 float:2.804E-42 double:9.886E-321;
                    r2.zzbj(r0);
                    goto L_0x0007;
                L_0x000f:
                    r0 = move-exception;
                    goto L_0x0009;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.Cast.CastApi.zza.1.zza(com.google.android.gms.cast.internal.zze):void");
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.zza.2 */
            class C11282 extends zza {
                final /* synthetic */ zza zzZH;
                final /* synthetic */ String zzZI;

                C11282(zza com_google_android_gms_cast_Cast_CastApi_zza, GoogleApiClient googleApiClient, String str) {
                    this.zzZH = com_google_android_gms_cast_Cast_CastApi_zza;
                    this.zzZI = str;
                    super(googleApiClient);
                }

                protected void zza(zze com_google_android_gms_cast_internal_zze) throws RemoteException {
                    try {
                        com_google_android_gms_cast_internal_zze.zza(this.zzZI, false, (zzb) this);
                    } catch (IllegalStateException e) {
                        zzbj(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.zza.3 */
            class C11293 extends zza {
                final /* synthetic */ zza zzZH;
                final /* synthetic */ String zzZI;
                final /* synthetic */ LaunchOptions zzZJ;

                C11293(zza com_google_android_gms_cast_Cast_CastApi_zza, GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions) {
                    this.zzZH = com_google_android_gms_cast_Cast_CastApi_zza;
                    this.zzZI = str;
                    this.zzZJ = launchOptions;
                    super(googleApiClient);
                }

                protected void zza(zze com_google_android_gms_cast_internal_zze) throws RemoteException {
                    try {
                        com_google_android_gms_cast_internal_zze.zza(this.zzZI, this.zzZJ, (zzb) this);
                    } catch (IllegalStateException e) {
                        zzbj(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.zza.4 */
            class C11304 extends zza {
                final /* synthetic */ String val$sessionId;
                final /* synthetic */ zza zzZH;
                final /* synthetic */ String zzZI;
                final /* synthetic */ JoinOptions zzZK;

                C11304(zza com_google_android_gms_cast_Cast_CastApi_zza, GoogleApiClient googleApiClient, String str, String str2, JoinOptions joinOptions) {
                    this.zzZH = com_google_android_gms_cast_Cast_CastApi_zza;
                    this.zzZI = str;
                    this.val$sessionId = str2;
                    this.zzZK = joinOptions;
                    super(googleApiClient);
                }

                protected void zza(zze com_google_android_gms_cast_internal_zze) throws RemoteException {
                    try {
                        com_google_android_gms_cast_internal_zze.zza(this.zzZI, this.val$sessionId, this.zzZK, (zzb) this);
                    } catch (IllegalStateException e) {
                        zzbj(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.zza.5 */
            class C11315 extends zzh {
                final /* synthetic */ zza zzZH;

                C11315(zza com_google_android_gms_cast_Cast_CastApi_zza, GoogleApiClient googleApiClient) {
                    this.zzZH = com_google_android_gms_cast_Cast_CastApi_zza;
                    super(googleApiClient);
                }

                protected void zza(zze com_google_android_gms_cast_internal_zze) throws RemoteException {
                    try {
                        com_google_android_gms_cast_internal_zze.zzb((zzb) this);
                    } catch (IllegalStateException e) {
                        zzbj(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.zza.6 */
            class C11326 extends zzh {
                final /* synthetic */ zza zzZH;

                C11326(zza com_google_android_gms_cast_Cast_CastApi_zza, GoogleApiClient googleApiClient) {
                    this.zzZH = com_google_android_gms_cast_Cast_CastApi_zza;
                    super(googleApiClient);
                }

                protected void zza(zze com_google_android_gms_cast_internal_zze) throws RemoteException {
                    try {
                        com_google_android_gms_cast_internal_zze.zza(BuildConfig.FLAVOR, (zzb) this);
                    } catch (IllegalStateException e) {
                        zzbj(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.zza.7 */
            class C11337 extends zzh {
                final /* synthetic */ String val$sessionId;
                final /* synthetic */ zza zzZH;

                C11337(zza com_google_android_gms_cast_Cast_CastApi_zza, GoogleApiClient googleApiClient, String str) {
                    this.zzZH = com_google_android_gms_cast_Cast_CastApi_zza;
                    this.val$sessionId = str;
                    super(googleApiClient);
                }

                protected void zza(zze com_google_android_gms_cast_internal_zze) throws RemoteException {
                    if (TextUtils.isEmpty(this.val$sessionId)) {
                        zze(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE, "IllegalArgument: sessionId cannot be null or empty");
                        return;
                    }
                    try {
                        com_google_android_gms_cast_internal_zze.zza(this.val$sessionId, (zzb) this);
                    } catch (IllegalStateException e) {
                        zzbj(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            public int getActiveInputState(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzUI)).zzol();
            }

            public ApplicationMetadata getApplicationMetadata(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzUI)).getApplicationMetadata();
            }

            public String getApplicationStatus(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzUI)).getApplicationStatus();
            }

            public int getStandbyState(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzUI)).zzom();
            }

            public double getVolume(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzUI)).zzok();
            }

            public boolean isMute(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzUI)).isMute();
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client) {
                return zza(client, null, null, null);
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, String applicationId) {
                return zza(client, applicationId, null, null);
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, String applicationId, String sessionId) {
                return zza(client, applicationId, sessionId, null);
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, String applicationId) {
                return client.zzb(new C11282(this, client, applicationId));
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, String applicationId, LaunchOptions options) {
                return client.zzb(new C11293(this, client, applicationId, options));
            }

            @Deprecated
            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, String applicationId, boolean relaunchIfRunning) {
                return launchApplication(client, applicationId, new Builder().setRelaunchIfRunning(relaunchIfRunning).build());
            }

            public PendingResult<Status> leaveApplication(GoogleApiClient client) {
                return client.zzb(new C11315(this, client));
            }

            public void removeMessageReceivedCallbacks(GoogleApiClient client, String namespace) throws IOException, IllegalArgumentException {
                try {
                    ((zze) client.zza(zzk.zzUI)).zzcg(namespace);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void requestStatus(GoogleApiClient client) throws IOException, IllegalStateException {
                try {
                    ((zze) client.zza(zzk.zzUI)).zzoj();
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> sendMessage(GoogleApiClient client, String namespace, String message) {
                return client.zzb(new C11271(this, client, namespace, message));
            }

            public void setMessageReceivedCallbacks(GoogleApiClient client, String namespace, MessageReceivedCallback callbacks) throws IOException, IllegalStateException {
                try {
                    ((zze) client.zza(zzk.zzUI)).zza(namespace, callbacks);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setMute(GoogleApiClient client, boolean mute) throws IOException, IllegalStateException {
                try {
                    ((zze) client.zza(zzk.zzUI)).zzX(mute);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setVolume(GoogleApiClient client, double volume) throws IOException, IllegalArgumentException, IllegalStateException {
                try {
                    ((zze) client.zza(zzk.zzUI)).zzf(volume);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client) {
                return client.zzb(new C11326(this, client));
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client, String sessionId) {
                return client.zzb(new C11337(this, client, sessionId));
            }

            public PendingResult<ApplicationConnectionResult> zza(GoogleApiClient googleApiClient, String str, String str2, JoinOptions joinOptions) {
                return googleApiClient.zzb(new C11304(this, googleApiClient, str, str2, joinOptions));
            }
        }

        int getActiveInputState(GoogleApiClient googleApiClient) throws IllegalStateException;

        ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException;

        String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException;

        int getStandbyState(GoogleApiClient googleApiClient) throws IllegalStateException;

        double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException;

        boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException;

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions);

        @Deprecated
        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z);

        PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient);

        void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException;

        void requestStatus(GoogleApiClient googleApiClient) throws IOException, IllegalStateException;

        PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2);

        void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException;

        void setMute(GoogleApiClient googleApiClient, boolean z) throws IOException, IllegalStateException;

        void setVolume(GoogleApiClient googleApiClient, double d) throws IOException, IllegalArgumentException, IllegalStateException;

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient);

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str);
    }

    public static class Listener {
        public void onActiveInputStateChanged(int activeInputState) {
        }

        public void onApplicationDisconnected(int statusCode) {
        }

        public void onApplicationMetadataChanged(ApplicationMetadata applicationMetadata) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onStandbyStateChanged(int standbyState) {
        }

        public void onVolumeChanged() {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice castDevice, String str, String str2);
    }

    /* renamed from: com.google.android.gms.cast.Cast.1 */
    static class C07291 extends com.google.android.gms.common.api.Api.zza<zze, CastOptions> {
        C07291() {
        }

        public zze zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, CastOptions castOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            zzx.zzb((Object) castOptions, (Object) "Setting the API options is required.");
            return new zze(context, looper, com_google_android_gms_common_internal_zzf, castOptions.zzZL, (long) castOptions.zzZN, castOptions.zzZM, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    public static final class CastOptions implements HasOptions {
        final CastDevice zzZL;
        final Listener zzZM;
        private final int zzZN;

        public static final class Builder {
            CastDevice zzZO;
            Listener zzZP;
            private int zzZQ;

            public Builder(CastDevice castDevice, Listener castListener) {
                zzx.zzb((Object) castDevice, (Object) "CastDevice parameter cannot be null");
                zzx.zzb((Object) castListener, (Object) "CastListener parameter cannot be null");
                this.zzZO = castDevice;
                this.zzZP = castListener;
                this.zzZQ = Cast.STANDBY_STATE_NO;
            }

            public CastOptions build() {
                return new CastOptions();
            }

            public Builder setVerboseLoggingEnabled(boolean enabled) {
                if (enabled) {
                    this.zzZQ |= Cast.STANDBY_STATE_YES;
                } else {
                    this.zzZQ &= -2;
                }
                return this;
            }
        }

        private CastOptions(Builder builder) {
            this.zzZL = builder.zzZO;
            this.zzZM = builder.zzZP;
            this.zzZN = builder.zzZQ;
        }

        @Deprecated
        public static Builder builder(CastDevice castDevice, Listener castListener) {
            return new Builder(castDevice, castListener);
        }
    }

    private static abstract class zza extends com.google.android.gms.cast.internal.zzb<ApplicationConnectionResult> {

        /* renamed from: com.google.android.gms.cast.Cast.zza.1 */
        class C09511 implements ApplicationConnectionResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ zza zzZS;

            C09511(zza com_google_android_gms_cast_Cast_zza, Status status) {
                this.zzZS = com_google_android_gms_cast_Cast_zza;
                this.zzZR = status;
            }

            public ApplicationMetadata getApplicationMetadata() {
                return null;
            }

            public String getApplicationStatus() {
                return null;
            }

            public String getSessionId() {
                return null;
            }

            public Status getStatus() {
                return this.zzZR;
            }

            public boolean getWasLaunched() {
                return false;
            }
        }

        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzo(status);
        }

        public ApplicationConnectionResult zzo(Status status) {
            return new C09511(this, status);
        }
    }

    static {
        zzUJ = new C07291();
        API = new Api("Cast.API", zzUJ, zzk.zzUI);
        CastApi = new zza();
    }

    private Cast() {
    }
}
