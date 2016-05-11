package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class RequestsImpl implements Requests {

    private static abstract class LoadRequestSummariesImpl extends BaseGamesApiMethodImpl<LoadRequestSummariesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.LoadRequestSummariesImpl.1 */
        class C09871 implements LoadRequestSummariesResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ LoadRequestSummariesImpl zzaHm;

            C09871(LoadRequestSummariesImpl loadRequestSummariesImpl, Status status) {
                this.zzaHm = loadRequestSummariesImpl;
                this.zzZR = status;
            }

            public Status getStatus() {
                return this.zzZR;
            }

            public void release() {
            }
        }

        public LoadRequestSummariesResult zzaz(Status status) {
            return new C09871(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaz(status);
        }
    }

    private static abstract class LoadRequestsImpl extends BaseGamesApiMethodImpl<LoadRequestsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.LoadRequestsImpl.1 */
        class C09881 implements LoadRequestsResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ LoadRequestsImpl zzaHn;

            C09881(LoadRequestsImpl loadRequestsImpl, Status status) {
                this.zzaHn = loadRequestsImpl;
                this.zzZR = status;
            }

            public GameRequestBuffer getRequests(int type) {
                return new GameRequestBuffer(DataHolder.zzbI(this.zzZR.getStatusCode()));
            }

            public Status getStatus() {
                return this.zzZR;
            }

            public void release() {
            }
        }

        private LoadRequestsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadRequestsResult zzaA(Status status) {
            return new C09881(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaA(status);
        }
    }

    private static abstract class SendRequestImpl extends BaseGamesApiMethodImpl<SendRequestResult> {

        /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.SendRequestImpl.1 */
        class C09891 implements SendRequestResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ SendRequestImpl zzaHo;

            C09891(SendRequestImpl sendRequestImpl, Status status) {
                this.zzaHo = sendRequestImpl;
                this.zzZR = status;
            }

            public Status getStatus() {
                return this.zzZR;
            }
        }

        public SendRequestResult zzaB(Status status) {
            return new C09891(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaB(status);
        }
    }

    private static abstract class UpdateRequestsImpl extends BaseGamesApiMethodImpl<UpdateRequestsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.UpdateRequestsImpl.1 */
        class C09901 implements UpdateRequestsResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ UpdateRequestsImpl zzaHp;

            C09901(UpdateRequestsImpl updateRequestsImpl, Status status) {
                this.zzaHp = updateRequestsImpl;
                this.zzZR = status;
            }

            public Set<String> getRequestIds() {
                return null;
            }

            public int getRequestOutcome(String requestId) {
                throw new IllegalArgumentException("Unknown request ID " + requestId);
            }

            public Status getStatus() {
                return this.zzZR;
            }

            public void release() {
            }
        }

        private UpdateRequestsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public UpdateRequestsResult zzaC(Status status) {
            return new C09901(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaC(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.1 */
    class C12171 extends UpdateRequestsImpl {
        final /* synthetic */ String[] zzaHe;
        final /* synthetic */ RequestsImpl zzaHf;

        C12171(RequestsImpl requestsImpl, GoogleApiClient x0, String[] strArr) {
            this.zzaHf = requestsImpl;
            this.zzaHe = strArr;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzaHe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.2 */
    class C12182 extends UpdateRequestsImpl {
        final /* synthetic */ String[] zzaHe;
        final /* synthetic */ RequestsImpl zzaHf;

        C12182(RequestsImpl requestsImpl, GoogleApiClient x0, String[] strArr) {
            this.zzaHf = requestsImpl;
            this.zzaHe = strArr;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzaHe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.3 */
    class C12193 extends LoadRequestsImpl {
        final /* synthetic */ int zzaGl;
        final /* synthetic */ RequestsImpl zzaHf;
        final /* synthetic */ int zzaHg;
        final /* synthetic */ int zzaHh;

        C12193(RequestsImpl requestsImpl, GoogleApiClient x0, int i, int i2, int i3) {
            this.zzaHf = requestsImpl;
            this.zzaHg = i;
            this.zzaHh = i2;
            this.zzaGl = i3;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaHg, this.zzaHh, this.zzaGl);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.4 */
    class C12204 extends SendRequestImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String[] zzaHi;
        final /* synthetic */ int zzaHj;
        final /* synthetic */ byte[] zzaHk;
        final /* synthetic */ int zzaHl;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaFQ, this.zzaHi, this.zzaHj, this.zzaHk, this.zzaHl);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.5 */
    class C12215 extends SendRequestImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String[] zzaHi;
        final /* synthetic */ int zzaHj;
        final /* synthetic */ byte[] zzaHk;
        final /* synthetic */ int zzaHl;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaFQ, this.zzaHi, this.zzaHj, this.zzaHk, this.zzaHl);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.6 */
    class C12226 extends UpdateRequestsImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String zzaHa;
        final /* synthetic */ String[] zzaHe;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaFQ, this.zzaHa, this.zzaHe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.7 */
    class C12237 extends LoadRequestsImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ int zzaGl;
        final /* synthetic */ String zzaHa;
        final /* synthetic */ int zzaHg;
        final /* synthetic */ int zzaHh;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaFQ, this.zzaHa, this.zzaHg, this.zzaHh, this.zzaGl);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.8 */
    class C12248 extends LoadRequestSummariesImpl {
        final /* synthetic */ String zzaHa;
        final /* synthetic */ int zzaHh;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzf(this, this.zzaHa, this.zzaHh);
        }
    }

    public PendingResult<UpdateRequestsResult> acceptRequest(GoogleApiClient apiClient, String requestId) {
        List arrayList = new ArrayList();
        arrayList.add(requestId);
        return acceptRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> acceptRequests(GoogleApiClient apiClient, List<String> requestIds) {
        return apiClient.zzb(new C12171(this, apiClient, requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()])));
    }

    public PendingResult<UpdateRequestsResult> dismissRequest(GoogleApiClient apiClient, String requestId) {
        List arrayList = new ArrayList();
        arrayList.add(requestId);
        return dismissRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> dismissRequests(GoogleApiClient apiClient, List<String> requestIds) {
        return apiClient.zzb(new C12182(this, apiClient, requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()])));
    }

    public ArrayList<GameRequest> getGameRequestsFromBundle(Bundle extras) {
        if (extras == null || !extras.containsKey(Requests.EXTRA_REQUESTS)) {
            return new ArrayList();
        }
        ArrayList arrayList = (ArrayList) extras.get(Requests.EXTRA_REQUESTS);
        ArrayList<GameRequest> arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add((GameRequest) arrayList.get(i));
        }
        return arrayList2;
    }

    public ArrayList<GameRequest> getGameRequestsFromInboxResponse(Intent response) {
        return response == null ? new ArrayList() : getGameRequestsFromBundle(response.getExtras());
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwM();
    }

    public int getMaxLifetimeDays(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwO();
    }

    public int getMaxPayloadSize(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwN();
    }

    public Intent getSendIntent(GoogleApiClient apiClient, int type, byte[] payload, int requestLifetimeDays, Bitmap icon, String description) {
        return Games.zzh(apiClient).zza(type, payload, requestLifetimeDays, icon, description);
    }

    public PendingResult<LoadRequestsResult> loadRequests(GoogleApiClient apiClient, int requestDirection, int types, int sortOrder) {
        return apiClient.zza(new C12193(this, apiClient, requestDirection, types, sortOrder));
    }

    public void registerRequestListener(GoogleApiClient apiClient, OnRequestReceivedListener listener) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzd(apiClient.zzr(listener));
        }
    }

    public void unregisterRequestListener(GoogleApiClient apiClient) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzwG();
        }
    }
}
