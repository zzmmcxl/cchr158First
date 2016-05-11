package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import java.util.List;

public final class TurnBasedMultiplayerImpl implements TurnBasedMultiplayer {

    private static abstract class CancelMatchImpl extends BaseGamesApiMethodImpl<CancelMatchResult> {
        private final String zzyv;

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.CancelMatchImpl.1 */
        class C09961 implements CancelMatchResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ CancelMatchImpl zzaHO;

            C09961(CancelMatchImpl cancelMatchImpl, Status status) {
                this.zzaHO = cancelMatchImpl;
                this.zzZR = status;
            }

            public String getMatchId() {
                return this.zzaHO.zzyv;
            }

            public Status getStatus() {
                return this.zzZR;
            }
        }

        public CancelMatchImpl(String id, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzyv = id;
        }

        public CancelMatchResult zzaI(Status status) {
            return new C09961(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaI(status);
        }
    }

    private static abstract class InitiateMatchImpl extends BaseGamesApiMethodImpl<InitiateMatchResult> {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.InitiateMatchImpl.1 */
        class C09971 implements InitiateMatchResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ InitiateMatchImpl zzaHP;

            C09971(InitiateMatchImpl initiateMatchImpl, Status status) {
                this.zzaHP = initiateMatchImpl;
                this.zzZR = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.zzZR;
            }
        }

        private InitiateMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public InitiateMatchResult zzaJ(Status status) {
            return new C09971(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaJ(status);
        }
    }

    private static abstract class LeaveMatchImpl extends BaseGamesApiMethodImpl<LeaveMatchResult> {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.LeaveMatchImpl.1 */
        class C09981 implements LeaveMatchResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ LeaveMatchImpl zzaHQ;

            C09981(LeaveMatchImpl leaveMatchImpl, Status status) {
                this.zzaHQ = leaveMatchImpl;
                this.zzZR = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.zzZR;
            }
        }

        private LeaveMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LeaveMatchResult zzaK(Status status) {
            return new C09981(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaK(status);
        }
    }

    private static abstract class LoadMatchImpl extends BaseGamesApiMethodImpl<LoadMatchResult> {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.LoadMatchImpl.1 */
        class C09991 implements LoadMatchResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ LoadMatchImpl zzaHR;

            C09991(LoadMatchImpl loadMatchImpl, Status status) {
                this.zzaHR = loadMatchImpl;
                this.zzZR = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.zzZR;
            }
        }

        private LoadMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadMatchResult zzaL(Status status) {
            return new C09991(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaL(status);
        }
    }

    private static abstract class LoadMatchesImpl extends BaseGamesApiMethodImpl<LoadMatchesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.LoadMatchesImpl.1 */
        class C10001 implements LoadMatchesResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ LoadMatchesImpl zzaHS;

            C10001(LoadMatchesImpl loadMatchesImpl, Status status) {
                this.zzaHS = loadMatchesImpl;
                this.zzZR = status;
            }

            public LoadMatchesResponse getMatches() {
                return new LoadMatchesResponse(new Bundle());
            }

            public Status getStatus() {
                return this.zzZR;
            }

            public void release() {
            }
        }

        private LoadMatchesImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadMatchesResult zzaM(Status status) {
            return new C10001(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaM(status);
        }
    }

    private static abstract class UpdateMatchImpl extends BaseGamesApiMethodImpl<UpdateMatchResult> {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.UpdateMatchImpl.1 */
        class C10011 implements UpdateMatchResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ UpdateMatchImpl zzaHT;

            C10011(UpdateMatchImpl updateMatchImpl, Status status) {
                this.zzaHT = updateMatchImpl;
                this.zzZR = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.zzZR;
            }
        }

        private UpdateMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public UpdateMatchResult zzaN(Status status) {
            return new C10011(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaN(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.10 */
    class AnonymousClass10 extends LoadMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl zzaHH;
        final /* synthetic */ String zzaHI;

        AnonymousClass10(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient x0, String str) {
            this.zzaHH = turnBasedMultiplayerImpl;
            this.zzaHI = str;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzg((zzb) this, this.zzaHI);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.11 */
    class AnonymousClass11 extends InitiateMatchImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String zzaHI;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzaFQ, this.zzaHI);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.12 */
    class AnonymousClass12 extends InitiateMatchImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String zzaHI;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, this.zzaFQ, this.zzaHI);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.13 */
    class AnonymousClass13 extends LoadMatchesImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ int zzaHJ;
        final /* synthetic */ int[] zzaHK;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaFQ, this.zzaHJ, this.zzaHK);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.1 */
    class C12321 extends InitiateMatchImpl {
        final /* synthetic */ TurnBasedMatchConfig zzaHG;
        final /* synthetic */ TurnBasedMultiplayerImpl zzaHH;

        C12321(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient x0, TurnBasedMatchConfig turnBasedMatchConfig) {
            this.zzaHH = turnBasedMultiplayerImpl;
            this.zzaHG = turnBasedMatchConfig;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaHG);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.2 */
    class C12332 extends InitiateMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl zzaHH;
        final /* synthetic */ String zzaHI;

        C12332(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient x0, String str) {
            this.zzaHH = turnBasedMultiplayerImpl;
            this.zzaHI = str;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzaHI);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.3 */
    class C12343 extends InitiateMatchImpl {
        final /* synthetic */ String zzaGn;
        final /* synthetic */ TurnBasedMultiplayerImpl zzaHH;

        C12343(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient x0, String str) {
            this.zzaHH = turnBasedMultiplayerImpl;
            this.zzaGn = str;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, this.zzaGn);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.4 */
    class C12354 extends UpdateMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl zzaHH;
        final /* synthetic */ String zzaHI;
        final /* synthetic */ byte[] zzaHL;
        final /* synthetic */ String zzaHM;
        final /* synthetic */ ParticipantResult[] zzaHN;

        C12354(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient x0, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) {
            this.zzaHH = turnBasedMultiplayerImpl;
            this.zzaHI = str;
            this.zzaHL = bArr;
            this.zzaHM = str2;
            this.zzaHN = participantResultArr;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaHI, this.zzaHL, this.zzaHM, this.zzaHN);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.5 */
    class C12365 extends UpdateMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl zzaHH;
        final /* synthetic */ String zzaHI;
        final /* synthetic */ byte[] zzaHL;
        final /* synthetic */ ParticipantResult[] zzaHN;

        C12365(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient x0, String str, byte[] bArr, ParticipantResult[] participantResultArr) {
            this.zzaHH = turnBasedMultiplayerImpl;
            this.zzaHI = str;
            this.zzaHL = bArr;
            this.zzaHN = participantResultArr;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaHI, this.zzaHL, this.zzaHN);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.6 */
    class C12376 extends LeaveMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl zzaHH;
        final /* synthetic */ String zzaHI;

        C12376(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient x0, String str) {
            this.zzaHH = turnBasedMultiplayerImpl;
            this.zzaHI = str;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zze((zzb) this, this.zzaHI);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.7 */
    class C12387 extends LeaveMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl zzaHH;
        final /* synthetic */ String zzaHI;
        final /* synthetic */ String zzaHM;

        C12387(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient x0, String str, String str2) {
            this.zzaHH = turnBasedMultiplayerImpl;
            this.zzaHI = str;
            this.zzaHM = str2;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaHI, this.zzaHM);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.8 */
    class C12398 extends CancelMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl zzaHH;
        final /* synthetic */ String zzaHI;

        C12398(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, String x0, GoogleApiClient x1, String str) {
            this.zzaHH = turnBasedMultiplayerImpl;
            this.zzaHI = str;
            super(x0, x1);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzf((zzb) this, this.zzaHI);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.9 */
    class C12409 extends LoadMatchesImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl zzaHH;
        final /* synthetic */ int zzaHJ;
        final /* synthetic */ int[] zzaHK;

        C12409(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient x0, int i, int[] iArr) {
            this.zzaHH = turnBasedMultiplayerImpl;
            this.zzaHJ = i;
            this.zzaHK = iArr;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaHJ, this.zzaHK);
        }
    }

    public PendingResult<InitiateMatchResult> acceptInvitation(GoogleApiClient apiClient, String invitationId) {
        return apiClient.zzb(new C12343(this, apiClient, invitationId));
    }

    public PendingResult<CancelMatchResult> cancelMatch(GoogleApiClient apiClient, String matchId) {
        return apiClient.zzb(new C12398(this, matchId, apiClient, matchId));
    }

    public PendingResult<InitiateMatchResult> createMatch(GoogleApiClient apiClient, TurnBasedMatchConfig config) {
        return apiClient.zzb(new C12321(this, apiClient, config));
    }

    public void declineInvitation(GoogleApiClient apiClient, String invitationId) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzr(invitationId, 1);
        }
    }

    public void dismissInvitation(GoogleApiClient apiClient, String invitationId) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzq(invitationId, 1);
        }
    }

    public void dismissMatch(GoogleApiClient apiClient, String matchId) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzdH(matchId);
        }
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId) {
        return finishMatch(apiClient, matchId, null, (ParticipantResult[]) null);
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId, byte[] matchData, List<ParticipantResult> results) {
        return finishMatch(apiClient, matchId, matchData, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId, byte[] matchData, ParticipantResult... results) {
        return apiClient.zzb(new C12365(this, apiClient, matchId, matchData, results));
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwB();
    }

    public int getMaxMatchDataSize(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwL();
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers) {
        return Games.zzh(apiClient).zzb(minPlayers, maxPlayers, true);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers, boolean allowAutomatch) {
        return Games.zzh(apiClient).zzb(minPlayers, maxPlayers, allowAutomatch);
    }

    public PendingResult<LeaveMatchResult> leaveMatch(GoogleApiClient apiClient, String matchId) {
        return apiClient.zzb(new C12376(this, apiClient, matchId));
    }

    public PendingResult<LeaveMatchResult> leaveMatchDuringTurn(GoogleApiClient apiClient, String matchId, String pendingParticipantId) {
        return apiClient.zzb(new C12387(this, apiClient, matchId, pendingParticipantId));
    }

    public PendingResult<LoadMatchResult> loadMatch(GoogleApiClient apiClient, String matchId) {
        return apiClient.zza(new AnonymousClass10(this, apiClient, matchId));
    }

    public PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient apiClient, int invitationSortOrder, int[] matchTurnStatuses) {
        return apiClient.zza(new C12409(this, apiClient, invitationSortOrder, matchTurnStatuses));
    }

    public PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient apiClient, int[] matchTurnStatuses) {
        return loadMatchesByStatus(apiClient, 0, matchTurnStatuses);
    }

    public void registerMatchUpdateListener(GoogleApiClient apiClient, OnTurnBasedMatchUpdateReceivedListener listener) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzb(apiClient.zzr(listener));
        }
    }

    public PendingResult<InitiateMatchResult> rematch(GoogleApiClient apiClient, String matchId) {
        return apiClient.zzb(new C12332(this, apiClient, matchId));
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, (ParticipantResult[]) null);
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId, List<ParticipantResult> results) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId, ParticipantResult... results) {
        return apiClient.zzb(new C12354(this, apiClient, matchId, matchData, pendingParticipantId, results));
    }

    public void unregisterMatchUpdateListener(GoogleApiClient apiClient) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzwE();
        }
    }
}
