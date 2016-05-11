package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AchievementsImpl implements Achievements {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadAchievementsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.LoadImpl.1 */
        class C09621 implements LoadAchievementsResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ LoadImpl zzaFT;

            C09621(LoadImpl loadImpl, Status status) {
                this.zzaFT = loadImpl;
                this.zzZR = status;
            }

            public AchievementBuffer getAchievements() {
                return new AchievementBuffer(DataHolder.zzbI(14));
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

        public LoadAchievementsResult zzZ(Status status) {
            return new C09621(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzZ(status);
        }
    }

    private static abstract class UpdateImpl extends BaseGamesApiMethodImpl<UpdateAchievementResult> {
        private final String zzyv;

        /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.UpdateImpl.1 */
        class C09631 implements UpdateAchievementResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ UpdateImpl zzaFU;

            C09631(UpdateImpl updateImpl, Status status) {
                this.zzaFU = updateImpl;
                this.zzZR = status;
            }

            public String getAchievementId() {
                return this.zzaFU.zzyv;
            }

            public Status getStatus() {
                return this.zzZR;
            }
        }

        public UpdateImpl(String id, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzyv = id;
        }

        public UpdateAchievementResult zzaa(Status status) {
            return new C09631(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaa(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.10 */
    class AnonymousClass10 extends LoadImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String zzacQ;

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzacQ, this.zzaFQ, this.zzaFO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.1 */
    class C11691 extends LoadImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ AchievementsImpl zzaFP;

        C11691(AchievementsImpl achievementsImpl, GoogleApiClient x0, boolean z) {
            this.zzaFP = achievementsImpl;
            this.zzaFO = z;
            super(null);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzaFO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.2 */
    class C11702 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl zzaFP;
        final /* synthetic */ String zzaFR;

        C11702(AchievementsImpl achievementsImpl, String x0, GoogleApiClient x1, String str) {
            this.zzaFP = achievementsImpl;
            this.zzaFR = str;
            super(x0, x1);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(null, this.zzaFR);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.3 */
    class C11713 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl zzaFP;
        final /* synthetic */ String zzaFR;

        C11713(AchievementsImpl achievementsImpl, String x0, GoogleApiClient x1, String str) {
            this.zzaFP = achievementsImpl;
            this.zzaFR = str;
            super(x0, x1);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaFR);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.4 */
    class C11724 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl zzaFP;
        final /* synthetic */ String zzaFR;

        C11724(AchievementsImpl achievementsImpl, String x0, GoogleApiClient x1, String str) {
            this.zzaFP = achievementsImpl;
            this.zzaFR = str;
            super(x0, x1);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(null, this.zzaFR);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.5 */
    class C11735 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl zzaFP;
        final /* synthetic */ String zzaFR;

        C11735(AchievementsImpl achievementsImpl, String x0, GoogleApiClient x1, String str) {
            this.zzaFP = achievementsImpl;
            this.zzaFR = str;
            super(x0, x1);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzaFR);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.6 */
    class C11746 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl zzaFP;
        final /* synthetic */ String zzaFR;
        final /* synthetic */ int zzaFS;

        C11746(AchievementsImpl achievementsImpl, String x0, GoogleApiClient x1, String str, int i) {
            this.zzaFP = achievementsImpl;
            this.zzaFR = str;
            this.zzaFS = i;
            super(x0, x1);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(null, this.zzaFR, this.zzaFS);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.7 */
    class C11757 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl zzaFP;
        final /* synthetic */ String zzaFR;
        final /* synthetic */ int zzaFS;

        C11757(AchievementsImpl achievementsImpl, String x0, GoogleApiClient x1, String str, int i) {
            this.zzaFP = achievementsImpl;
            this.zzaFR = str;
            this.zzaFS = i;
            super(x0, x1);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaFR, this.zzaFS);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.8 */
    class C11768 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl zzaFP;
        final /* synthetic */ String zzaFR;
        final /* synthetic */ int zzaFS;

        C11768(AchievementsImpl achievementsImpl, String x0, GoogleApiClient x1, String str, int i) {
            this.zzaFP = achievementsImpl;
            this.zzaFR = str;
            this.zzaFS = i;
            super(x0, x1);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(null, this.zzaFR, this.zzaFS);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.9 */
    class C11779 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl zzaFP;
        final /* synthetic */ String zzaFR;
        final /* synthetic */ int zzaFS;

        C11779(AchievementsImpl achievementsImpl, String x0, GoogleApiClient x1, String str, int i) {
            this.zzaFP = achievementsImpl;
            this.zzaFR = str;
            this.zzaFS = i;
            super(x0, x1);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzaFR, this.zzaFS);
        }
    }

    public Intent getAchievementsIntent(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwA();
    }

    public void increment(GoogleApiClient apiClient, String id, int numSteps) {
        apiClient.zzb(new C11746(this, id, apiClient, id, numSteps));
    }

    public PendingResult<UpdateAchievementResult> incrementImmediate(GoogleApiClient apiClient, String id, int numSteps) {
        return apiClient.zzb(new C11757(this, id, apiClient, id, numSteps));
    }

    public PendingResult<LoadAchievementsResult> load(GoogleApiClient apiClient, boolean forceReload) {
        return apiClient.zza(new C11691(this, apiClient, forceReload));
    }

    public void reveal(GoogleApiClient apiClient, String id) {
        apiClient.zzb(new C11702(this, id, apiClient, id));
    }

    public PendingResult<UpdateAchievementResult> revealImmediate(GoogleApiClient apiClient, String id) {
        return apiClient.zzb(new C11713(this, id, apiClient, id));
    }

    public void setSteps(GoogleApiClient apiClient, String id, int numSteps) {
        apiClient.zzb(new C11768(this, id, apiClient, id, numSteps));
    }

    public PendingResult<UpdateAchievementResult> setStepsImmediate(GoogleApiClient apiClient, String id, int numSteps) {
        return apiClient.zzb(new C11779(this, id, apiClient, id, numSteps));
    }

    public void unlock(GoogleApiClient apiClient, String id) {
        apiClient.zzb(new C11724(this, id, apiClient, id));
    }

    public PendingResult<UpdateAchievementResult> unlockImmediate(GoogleApiClient apiClient, String id) {
        return apiClient.zzb(new C11735(this, id, apiClient, id));
    }
}
