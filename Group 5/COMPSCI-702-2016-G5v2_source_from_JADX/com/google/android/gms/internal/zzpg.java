package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.SessionRegistrationRequest;
import com.google.android.gms.fitness.request.SessionStartRequest;
import com.google.android.gms.fitness.request.SessionStopRequest;
import com.google.android.gms.fitness.request.SessionUnregistrationRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import java.util.concurrent.TimeUnit;

public class zzpg implements SessionsApi {

    private static class zza extends com.google.android.gms.internal.zzou.zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<SessionReadResult> zzamC;

        private zza(com.google.android.gms.common.api.internal.zza.zzb<SessionReadResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_SessionReadResult) {
            this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_SessionReadResult;
        }

        public void zza(SessionReadResult sessionReadResult) throws RemoteException {
            this.zzamC.zzs(sessionReadResult);
        }
    }

    private static class zzb extends com.google.android.gms.internal.zzov.zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<SessionStopResult> zzamC;

        private zzb(com.google.android.gms.common.api.internal.zza.zzb<SessionStopResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_SessionStopResult) {
            this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_SessionStopResult;
        }

        public void zza(SessionStopResult sessionStopResult) {
            this.zzamC.zzs(sessionStopResult);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg.2 */
    class C10902 extends zza<SessionStopResult> {
        final /* synthetic */ String val$name;
        final /* synthetic */ zzpg zzaAs;
        final /* synthetic */ String zzaAt;

        C10902(zzpg com_google_android_gms_internal_zzpg, GoogleApiClient googleApiClient, String str, String str2) {
            this.zzaAs = com_google_android_gms_internal_zzpg;
            this.val$name = str;
            this.zzaAt = str2;
            super(googleApiClient);
        }

        protected SessionStopResult zzO(Status status) {
            return SessionStopResult.zzV(status);
        }

        protected void zza(zzof com_google_android_gms_internal_zzof) throws RemoteException {
            ((zzoq) com_google_android_gms_internal_zzof.zzqJ()).zza(new SessionStopRequest(this.val$name, this.zzaAt, new zzb(null)));
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzO(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg.4 */
    class C10914 extends zza<SessionReadResult> {
        final /* synthetic */ zzpg zzaAs;
        final /* synthetic */ SessionReadRequest zzaAv;

        C10914(zzpg com_google_android_gms_internal_zzpg, GoogleApiClient googleApiClient, SessionReadRequest sessionReadRequest) {
            this.zzaAs = com_google_android_gms_internal_zzpg;
            this.zzaAv = sessionReadRequest;
            super(googleApiClient);
        }

        protected SessionReadResult zzP(Status status) {
            return SessionReadResult.zzU(status);
        }

        protected void zza(zzof com_google_android_gms_internal_zzof) throws RemoteException {
            ((zzoq) com_google_android_gms_internal_zzof.zzqJ()).zza(new SessionReadRequest(this.zzaAv, new zza(null)));
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzP(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg.1 */
    class C12601 extends zzc {
        final /* synthetic */ Session zzaAr;
        final /* synthetic */ zzpg zzaAs;

        C12601(zzpg com_google_android_gms_internal_zzpg, GoogleApiClient googleApiClient, Session session) {
            this.zzaAs = com_google_android_gms_internal_zzpg;
            this.zzaAr = session;
            super(googleApiClient);
        }

        protected void zza(zzof com_google_android_gms_internal_zzof) throws RemoteException {
            ((zzoq) com_google_android_gms_internal_zzof.zzqJ()).zza(new SessionStartRequest(this.zzaAr, new zzph(this)));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg.3 */
    class C12613 extends zzc {
        final /* synthetic */ zzpg zzaAs;
        final /* synthetic */ SessionInsertRequest zzaAu;

        C12613(zzpg com_google_android_gms_internal_zzpg, GoogleApiClient googleApiClient, SessionInsertRequest sessionInsertRequest) {
            this.zzaAs = com_google_android_gms_internal_zzpg;
            this.zzaAu = sessionInsertRequest;
            super(googleApiClient);
        }

        protected void zza(zzof com_google_android_gms_internal_zzof) throws RemoteException {
            ((zzoq) com_google_android_gms_internal_zzof.zzqJ()).zza(new SessionInsertRequest(this.zzaAu, new zzph(this)));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg.5 */
    class C12625 extends zzc {
        final /* synthetic */ PendingIntent zzaAl;
        final /* synthetic */ zzpg zzaAs;
        final /* synthetic */ int zzaAw;

        C12625(zzpg com_google_android_gms_internal_zzpg, GoogleApiClient googleApiClient, PendingIntent pendingIntent, int i) {
            this.zzaAs = com_google_android_gms_internal_zzpg;
            this.zzaAl = pendingIntent;
            this.zzaAw = i;
            super(googleApiClient);
        }

        protected void zza(zzof com_google_android_gms_internal_zzof) throws RemoteException {
            ((zzoq) com_google_android_gms_internal_zzof.zzqJ()).zza(new SessionRegistrationRequest(this.zzaAl, new zzph(this), this.zzaAw));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg.6 */
    class C12636 extends zzc {
        final /* synthetic */ PendingIntent zzaAl;
        final /* synthetic */ zzpg zzaAs;

        C12636(zzpg com_google_android_gms_internal_zzpg, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
            this.zzaAs = com_google_android_gms_internal_zzpg;
            this.zzaAl = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzof com_google_android_gms_internal_zzof) throws RemoteException {
            ((zzoq) com_google_android_gms_internal_zzof.zzqJ()).zza(new SessionUnregistrationRequest(this.zzaAl, new zzph(this)));
        }
    }

    private PendingResult<SessionStopResult> zza(GoogleApiClient googleApiClient, String str, String str2) {
        return googleApiClient.zzb(new C10902(this, googleApiClient, str, str2));
    }

    public PendingResult<Status> insertSession(GoogleApiClient client, SessionInsertRequest request) {
        return client.zza(new C12613(this, client, request));
    }

    public PendingResult<SessionReadResult> readSession(GoogleApiClient client, SessionReadRequest request) {
        return client.zza(new C10914(this, client, request));
    }

    public PendingResult<Status> registerForSessions(GoogleApiClient client, PendingIntent intent) {
        return zza(client, intent, 0);
    }

    public PendingResult<Status> startSession(GoogleApiClient client, Session session) {
        zzx.zzb((Object) session, (Object) "Session cannot be null");
        zzx.zzb(session.getEndTime(TimeUnit.MILLISECONDS) == 0, (Object) "Cannot start a session which has already ended");
        return client.zzb(new C12601(this, client, session));
    }

    public PendingResult<SessionStopResult> stopSession(GoogleApiClient client, String identifier) {
        return zza(client, null, identifier);
    }

    public PendingResult<Status> unregisterForSessions(GoogleApiClient client, PendingIntent intent) {
        return client.zzb(new C12636(this, client, intent));
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, PendingIntent pendingIntent, int i) {
        return googleApiClient.zzb(new C12625(this, googleApiClient, pendingIntent, i));
    }
}
