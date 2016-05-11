package com.google.android.gms.auth.api.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzr;
import com.google.android.gms.common.internal.zzx;
import java.util.HashSet;

public class zzc implements GoogleSignInApi {

    private abstract class zza<R extends Result> extends com.google.android.gms.common.api.internal.zza.zza<R, zzd> {
        final /* synthetic */ zzc zzXs;

        public zza(zzc com_google_android_gms_auth_api_signin_internal_zzc, GoogleApiClient googleApiClient) {
            this.zzXs = com_google_android_gms_auth_api_signin_internal_zzc;
            super(Auth.zzVx, googleApiClient);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.signin.internal.zzc.1 */
    class C10691 extends zza<GoogleSignInResult> {
        final /* synthetic */ GoogleSignInOptions zzXr;
        final /* synthetic */ zzc zzXs;

        /* renamed from: com.google.android.gms.auth.api.signin.internal.zzc.1.1 */
        class C10421 extends zza {
            final /* synthetic */ zzq zzXt;
            final /* synthetic */ C10691 zzXu;

            C10421(C10691 c10691, zzq com_google_android_gms_auth_api_signin_internal_zzq) {
                this.zzXu = c10691;
                this.zzXt = com_google_android_gms_auth_api_signin_internal_zzq;
            }

            public void zza(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException {
                if (googleSignInAccount != null) {
                    this.zzXt.zzb(googleSignInAccount, this.zzXu.zzXr);
                }
                this.zzXu.zza(new GoogleSignInResult(googleSignInAccount, status));
            }
        }

        C10691(zzc com_google_android_gms_auth_api_signin_internal_zzc, GoogleApiClient googleApiClient, GoogleSignInOptions googleSignInOptions) {
            this.zzXs = com_google_android_gms_auth_api_signin_internal_zzc;
            this.zzXr = googleSignInOptions;
            super(com_google_android_gms_auth_api_signin_internal_zzc, googleApiClient);
        }

        protected void zza(zzd com_google_android_gms_auth_api_signin_internal_zzd) throws RemoteException {
            ((zzh) com_google_android_gms_auth_api_signin_internal_zzd.zzqJ()).zza(new C10421(this, zzq.zzaf(com_google_android_gms_auth_api_signin_internal_zzd.getContext())), this.zzXr);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzn(status);
        }

        protected GoogleSignInResult zzn(Status status) {
            return new GoogleSignInResult(null, status);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.signin.internal.zzc.2 */
    class C10702 extends zza<Status> {
        final /* synthetic */ zzc zzXs;

        /* renamed from: com.google.android.gms.auth.api.signin.internal.zzc.2.1 */
        class C10431 extends zza {
            final /* synthetic */ C10702 zzXv;

            C10431(C10702 c10702) {
                this.zzXv = c10702;
            }

            public void zzl(Status status) throws RemoteException {
                this.zzXv.zza((Result) status);
            }
        }

        C10702(zzc com_google_android_gms_auth_api_signin_internal_zzc, GoogleApiClient googleApiClient) {
            this.zzXs = com_google_android_gms_auth_api_signin_internal_zzc;
            super(com_google_android_gms_auth_api_signin_internal_zzc, googleApiClient);
        }

        protected void zza(zzd com_google_android_gms_auth_api_signin_internal_zzd) throws RemoteException {
            ((zzh) com_google_android_gms_auth_api_signin_internal_zzd.zzqJ()).zzb(new C10431(this), com_google_android_gms_auth_api_signin_internal_zzd.zznd());
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.signin.internal.zzc.3 */
    class C10713 extends zza<Status> {
        final /* synthetic */ zzc zzXs;

        /* renamed from: com.google.android.gms.auth.api.signin.internal.zzc.3.1 */
        class C10441 extends zza {
            final /* synthetic */ C10713 zzXw;

            C10441(C10713 c10713) {
                this.zzXw = c10713;
            }

            public void zzm(Status status) throws RemoteException {
                this.zzXw.zza((Result) status);
            }
        }

        C10713(zzc com_google_android_gms_auth_api_signin_internal_zzc, GoogleApiClient googleApiClient) {
            this.zzXs = com_google_android_gms_auth_api_signin_internal_zzc;
            super(com_google_android_gms_auth_api_signin_internal_zzc, googleApiClient);
        }

        protected void zza(zzd com_google_android_gms_auth_api_signin_internal_zzd) throws RemoteException {
            ((zzh) com_google_android_gms_auth_api_signin_internal_zzd.zzqJ()).zzc(new C10441(this), com_google_android_gms_auth_api_signin_internal_zzd.zznd());
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    private OptionalPendingResult<GoogleSignInResult> zza(GoogleApiClient googleApiClient, GoogleSignInOptions googleSignInOptions) {
        Log.d("GoogleSignInApiImpl", "trySilentSignIn");
        return new zzr(googleApiClient.zza(new C10691(this, googleApiClient, googleSignInOptions)));
    }

    private boolean zza(Account account, Account account2) {
        return account == null ? account2 == null : account.equals(account2);
    }

    private GoogleSignInOptions zzb(GoogleApiClient googleApiClient) {
        return ((zzd) googleApiClient.zza(Auth.zzVx)).zznd();
    }

    public Intent getSignInIntent(GoogleApiClient client) {
        zzx.zzz(client);
        return ((zzd) client.zza(Auth.zzVx)).zznc();
    }

    public GoogleSignInResult getSignInResultFromIntent(Intent data) {
        if (data == null || (!data.hasExtra("googleSignInStatus") && !data.hasExtra("googleSignInAccount"))) {
            return null;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) data.getParcelableExtra("googleSignInAccount");
        Status status = (Status) data.getParcelableExtra("googleSignInStatus");
        if (googleSignInAccount != null) {
            status = Status.zzagC;
        }
        return new GoogleSignInResult(googleSignInAccount, status);
    }

    public PendingResult<Status> revokeAccess(GoogleApiClient client) {
        zzq.zzaf(client.getContext()).zznr();
        for (GoogleApiClient zzoW : GoogleApiClient.zzoV()) {
            zzoW.zzoW();
        }
        return client.zzb(new C10713(this, client));
    }

    public PendingResult<Status> signOut(GoogleApiClient client) {
        zzq.zzaf(client.getContext()).zznr();
        for (GoogleApiClient zzoW : GoogleApiClient.zzoV()) {
            zzoW.zzoW();
        }
        return client.zzb(new C10702(this, client));
    }

    public OptionalPendingResult<GoogleSignInResult> silentSignIn(GoogleApiClient client) {
        GoogleSignInOptions zzb = zzb(client);
        Result zza = zza(client.getContext(), zzb);
        return zza != null ? PendingResults.zzb(zza, client) : zza(client, zzb);
    }

    public GoogleSignInResult zza(Context context, GoogleSignInOptions googleSignInOptions) {
        Log.d("GoogleSignInApiImpl", "getSavedSignInResultIfEligible");
        zzx.zzz(googleSignInOptions);
        zzq zzaf = zzq.zzaf(context);
        GoogleSignInOptions zznp = zzaf.zznp();
        if (zznp == null || !zza(zznp.getAccount(), googleSignInOptions.getAccount()) || googleSignInOptions.zzmP()) {
            return null;
        }
        if ((googleSignInOptions.zzmO() && (!zznp.zzmO() || !googleSignInOptions.zzmR().equals(zznp.zzmR()))) || !new HashSet(zznp.zzmN()).containsAll(new HashSet(googleSignInOptions.zzmN()))) {
            return null;
        }
        GoogleSignInAccount zzno = zzaf.zzno();
        return (zzno == null || zzno.zzb()) ? null : new GoogleSignInResult(zzno, Status.zzagC);
    }
}
