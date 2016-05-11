package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;

public final class AclsImpl implements Acls {

    /* renamed from: com.google.android.gms.games.internal.api.AclsImpl.1 */
    static class C09641 implements LoadAclResult {
        final /* synthetic */ Status zzZR;

        C09641(Status status) {
            this.zzZR = status;
        }

        public Status getStatus() {
            return this.zzZR;
        }

        public void release() {
        }
    }

    private static abstract class LoadNotifyAclImpl extends BaseGamesApiMethodImpl<LoadAclResult> {
        public LoadAclResult zzad(Status status) {
            return AclsImpl.zzab(status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzad(status);
        }
    }

    private static abstract class UpdateNotifyAclImpl extends BaseGamesApiMethodImpl<Status> {
        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AclsImpl.2 */
    class C11782 extends LoadNotifyAclImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzj(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AclsImpl.3 */
    class C11793 extends UpdateNotifyAclImpl {
        final /* synthetic */ String zzaFV;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzn(this, this.zzaFV);
        }
    }

    private static LoadAclResult zzab(Status status) {
        return new C09641(status);
    }
}
