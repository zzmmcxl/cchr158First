package com.google.android.gms.games.internal.api;

import android.annotation.SuppressLint;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class EventsImpl implements Events {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadEventsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.EventsImpl.LoadImpl.1 */
        class C09661 implements LoadEventsResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ LoadImpl zzaGe;

            C09661(LoadImpl loadImpl, Status status) {
                this.zzaGe = loadImpl;
                this.zzZR = status;
            }

            public EventBuffer getEvents() {
                return new EventBuffer(DataHolder.zzbI(14));
            }

            public Status getStatus() {
                return this.zzZR;
            }

            public void release() {
            }
        }

        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadEventsResult zzaf(Status status) {
            return new C09661(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaf(status);
        }
    }

    private static abstract class UpdateImpl extends BaseGamesApiMethodImpl<Result> {

        /* renamed from: com.google.android.gms.games.internal.api.EventsImpl.UpdateImpl.1 */
        class C07761 implements Result {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ UpdateImpl zzaGf;

            C07761(UpdateImpl updateImpl, Status status) {
                this.zzaGf = updateImpl;
                this.zzZR = status;
            }

            public Status getStatus() {
                return this.zzZR;
            }
        }

        private UpdateImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Result zzc(Status status) {
            return new C07761(this, status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.EventsImpl.1 */
    class C11811 extends LoadImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ String[] zzaGa;
        final /* synthetic */ EventsImpl zzaGb;

        C11811(EventsImpl eventsImpl, GoogleApiClient x0, boolean z, String[] strArr) {
            this.zzaGb = eventsImpl;
            this.zzaFO = z;
            this.zzaGa = strArr;
            super(null);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaFO, this.zzaGa);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.EventsImpl.2 */
    class C11822 extends LoadImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ EventsImpl zzaGb;

        C11822(EventsImpl eventsImpl, GoogleApiClient x0, boolean z) {
            this.zzaGb = eventsImpl;
            this.zzaFO = z;
            super(null);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, this.zzaFO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.EventsImpl.3 */
    class C11833 extends UpdateImpl {
        final /* synthetic */ EventsImpl zzaGb;
        final /* synthetic */ String zzaGc;
        final /* synthetic */ int zzaGd;

        C11833(EventsImpl eventsImpl, GoogleApiClient x0, String str, int i) {
            this.zzaGb = eventsImpl;
            this.zzaGc = str;
            this.zzaGd = i;
            super(null);
        }

        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzp(this.zzaGc, this.zzaGd);
        }
    }

    @SuppressLint({"MissingRemoteException"})
    public void increment(GoogleApiClient apiClient, String eventId, int incrementAmount) {
        GamesClientImpl zzc = Games.zzc(apiClient, false);
        if (zzc != null) {
            if (zzc.isConnected()) {
                zzc.zzp(eventId, incrementAmount);
            } else {
                apiClient.zzb(new C11833(this, apiClient, eventId, incrementAmount));
            }
        }
    }

    public PendingResult<LoadEventsResult> load(GoogleApiClient apiClient, boolean forceReload) {
        return apiClient.zza(new C11822(this, apiClient, forceReload));
    }

    public PendingResult<LoadEventsResult> loadByIds(GoogleApiClient apiClient, boolean forceReload, String... eventIds) {
        return apiClient.zza(new C11811(this, apiClient, forceReload, eventIds));
    }
}
