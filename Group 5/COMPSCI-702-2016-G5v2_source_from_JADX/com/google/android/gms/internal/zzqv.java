package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.zze;

public final class zzqv implements Account {

    private static abstract class zza extends com.google.android.gms.plus.Plus.zza<Status> {
        private zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqv.1 */
    class C12711 extends zza {
        final /* synthetic */ zzqv zzbey;

        C12711(zzqv com_google_android_gms_internal_zzqv, GoogleApiClient googleApiClient) {
            this.zzbey = com_google_android_gms_internal_zzqv;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            com_google_android_gms_plus_internal_zze.zzq(this);
        }
    }

    public void clearDefaultAccount(GoogleApiClient googleApiClient) {
        zze zzf = Plus.zzf(googleApiClient, false);
        if (zzf != null) {
            zzf.zzEY();
        }
    }

    public String getAccountName(GoogleApiClient googleApiClient) {
        return Plus.zzf(googleApiClient, true).getAccountName();
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<Status> revokeAccessAndDisconnect(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new C12711(this, googleApiClient));
    }
}
