package com.google.android.gms.games.internal.api;

import android.content.Intent;
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
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange.Builder;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;

public final class SnapshotsImpl implements Snapshots {

    private static abstract class CommitImpl extends BaseGamesApiMethodImpl<CommitSnapshotResult> {

        /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.CommitImpl.1 */
        class C09911 implements CommitSnapshotResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ CommitImpl zzaHA;

            C09911(CommitImpl commitImpl, Status status) {
                this.zzaHA = commitImpl;
                this.zzZR = status;
            }

            public SnapshotMetadata getSnapshotMetadata() {
                return null;
            }

            public Status getStatus() {
                return this.zzZR;
            }
        }

        private CommitImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public CommitSnapshotResult zzaD(Status status) {
            return new C09911(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaD(status);
        }
    }

    private static abstract class DeleteImpl extends BaseGamesApiMethodImpl<DeleteSnapshotResult> {

        /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.DeleteImpl.1 */
        class C09921 implements DeleteSnapshotResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ DeleteImpl zzaHB;

            C09921(DeleteImpl deleteImpl, Status status) {
                this.zzaHB = deleteImpl;
                this.zzZR = status;
            }

            public String getSnapshotId() {
                return null;
            }

            public Status getStatus() {
                return this.zzZR;
            }
        }

        private DeleteImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public DeleteSnapshotResult zzaE(Status status) {
            return new C09921(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaE(status);
        }
    }

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadSnapshotsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.LoadImpl.1 */
        class C09931 implements LoadSnapshotsResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ LoadImpl zzaHC;

            C09931(LoadImpl loadImpl, Status status) {
                this.zzaHC = loadImpl;
                this.zzZR = status;
            }

            public SnapshotMetadataBuffer getSnapshots() {
                return new SnapshotMetadataBuffer(DataHolder.zzbI(14));
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

        public LoadSnapshotsResult zzaF(Status status) {
            return new C09931(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaF(status);
        }
    }

    private static abstract class OpenImpl extends BaseGamesApiMethodImpl<OpenSnapshotResult> {

        /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.OpenImpl.1 */
        class C09941 implements OpenSnapshotResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ OpenImpl zzaHD;

            C09941(OpenImpl openImpl, Status status) {
                this.zzaHD = openImpl;
                this.zzZR = status;
            }

            public String getConflictId() {
                return null;
            }

            public Snapshot getConflictingSnapshot() {
                return null;
            }

            public SnapshotContents getResolutionSnapshotContents() {
                return null;
            }

            public Snapshot getSnapshot() {
                return null;
            }

            public Status getStatus() {
                return this.zzZR;
            }
        }

        private OpenImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public OpenSnapshotResult zzaG(Status status) {
            return new C09941(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaG(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.1 */
    class C12251 extends LoadImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ SnapshotsImpl zzaHq;

        C12251(SnapshotsImpl snapshotsImpl, GoogleApiClient x0, boolean z) {
            this.zzaHq = snapshotsImpl;
            this.zzaFO = z;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzf((zzb) this, this.zzaFO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.2 */
    class C12262 extends OpenImpl {
        final /* synthetic */ SnapshotsImpl zzaHq;
        final /* synthetic */ String zzaHr;
        final /* synthetic */ boolean zzaHs;
        final /* synthetic */ int zzaHt;

        C12262(SnapshotsImpl snapshotsImpl, GoogleApiClient x0, String str, boolean z, int i) {
            this.zzaHq = snapshotsImpl;
            this.zzaHr = str;
            this.zzaHs = z;
            this.zzaHt = i;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaHr, this.zzaHs, this.zzaHt);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.3 */
    class C12273 extends CommitImpl {
        final /* synthetic */ SnapshotsImpl zzaHq;
        final /* synthetic */ Snapshot zzaHu;
        final /* synthetic */ SnapshotMetadataChange zzaHv;

        C12273(SnapshotsImpl snapshotsImpl, GoogleApiClient x0, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
            this.zzaHq = snapshotsImpl;
            this.zzaHu = snapshot;
            this.zzaHv = snapshotMetadataChange;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaHu, this.zzaHv);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.4 */
    class C12284 extends DeleteImpl {
        final /* synthetic */ SnapshotsImpl zzaHq;
        final /* synthetic */ SnapshotMetadata zzaHw;

        C12284(SnapshotsImpl snapshotsImpl, GoogleApiClient x0, SnapshotMetadata snapshotMetadata) {
            this.zzaHq = snapshotsImpl;
            this.zzaHw = snapshotMetadata;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzi((zzb) this, this.zzaHw.getSnapshotId());
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.5 */
    class C12295 extends OpenImpl {
        final /* synthetic */ SnapshotsImpl zzaHq;
        final /* synthetic */ SnapshotMetadataChange zzaHv;
        final /* synthetic */ String zzaHx;
        final /* synthetic */ String zzaHy;
        final /* synthetic */ SnapshotContents zzaHz;

        C12295(SnapshotsImpl snapshotsImpl, GoogleApiClient x0, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
            this.zzaHq = snapshotsImpl;
            this.zzaHx = str;
            this.zzaHy = str2;
            this.zzaHv = snapshotMetadataChange;
            this.zzaHz = snapshotContents;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaHx, this.zzaHy, this.zzaHv, this.zzaHz);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.6 */
    class C12306 extends LoadImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String zzacQ;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzacQ, this.zzaFQ, this.zzaFO);
        }
    }

    public PendingResult<CommitSnapshotResult> commitAndClose(GoogleApiClient apiClient, Snapshot snapshot, SnapshotMetadataChange metadataChange) {
        return apiClient.zzb(new C12273(this, apiClient, snapshot, metadataChange));
    }

    public PendingResult<DeleteSnapshotResult> delete(GoogleApiClient apiClient, SnapshotMetadata metadata) {
        return apiClient.zzb(new C12284(this, apiClient, metadata));
    }

    public void discardAndClose(GoogleApiClient apiClient, Snapshot snapshot) {
        Games.zzh(apiClient).zza(snapshot);
    }

    public int getMaxCoverImageSize(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwQ();
    }

    public int getMaxDataSize(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwP();
    }

    public Intent getSelectSnapshotIntent(GoogleApiClient apiClient, String title, boolean allowAddButton, boolean allowDelete, int maxSnapshots) {
        return Games.zzh(apiClient).zza(title, allowAddButton, allowDelete, maxSnapshots);
    }

    public SnapshotMetadata getSnapshotFromBundle(Bundle extras) {
        return (extras == null || !extras.containsKey(Snapshots.EXTRA_SNAPSHOT_METADATA)) ? null : (SnapshotMetadata) extras.getParcelable(Snapshots.EXTRA_SNAPSHOT_METADATA);
    }

    public PendingResult<LoadSnapshotsResult> load(GoogleApiClient apiClient, boolean forceReload) {
        return apiClient.zza(new C12251(this, apiClient, forceReload));
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient apiClient, SnapshotMetadata metadata) {
        return open(apiClient, metadata.getUniqueName(), false);
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient apiClient, SnapshotMetadata metadata, int conflictPolicy) {
        return open(apiClient, metadata.getUniqueName(), false, conflictPolicy);
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient apiClient, String fileName, boolean createIfNotFound) {
        return open(apiClient, fileName, createIfNotFound, -1);
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient apiClient, String fileName, boolean createIfNotFound, int conflictPolicy) {
        return apiClient.zzb(new C12262(this, apiClient, fileName, createIfNotFound, conflictPolicy));
    }

    public PendingResult<OpenSnapshotResult> resolveConflict(GoogleApiClient apiClient, String conflictId, Snapshot snapshot) {
        SnapshotMetadata metadata = snapshot.getMetadata();
        SnapshotMetadataChange build = new Builder().fromMetadata(metadata).build();
        return resolveConflict(apiClient, conflictId, metadata.getSnapshotId(), build, snapshot.getSnapshotContents());
    }

    public PendingResult<OpenSnapshotResult> resolveConflict(GoogleApiClient apiClient, String conflictId, String snapshotId, SnapshotMetadataChange metadataChange, SnapshotContents snapshotContents) {
        return apiClient.zzb(new C12295(this, apiClient, conflictId, snapshotId, metadataChange, snapshotContents));
    }
}
