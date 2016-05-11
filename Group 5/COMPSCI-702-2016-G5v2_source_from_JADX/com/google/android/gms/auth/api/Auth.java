package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.credentials.internal.zzf;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzd;
import com.google.android.gms.auth.api.signin.internal.zzn;
import com.google.android.gms.auth.api.signin.internal.zzo;
import com.google.android.gms.auth.api.signin.zzg;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzkq;
import com.google.android.gms.internal.zzkr;
import com.google.android.gms.internal.zzks;
import com.google.android.gms.internal.zzkv;
import com.google.android.gms.internal.zzkw;
import com.google.android.gms.internal.zzkz;
import com.google.android.gms.internal.zzld;
import java.util.Collections;
import java.util.List;

public final class Auth {
    public static final Api<AuthCredentialsOptions> CREDENTIALS_API;
    public static final CredentialsApi CredentialsApi;
    public static final Api<GoogleSignInOptions> GOOGLE_SIGN_IN_API;
    public static final GoogleSignInApi GoogleSignInApi;
    public static final Api<zza> PROXY_API;
    public static final ProxyApi ProxyApi;
    private static final com.google.android.gms.common.api.Api.zza<zzf, AuthCredentialsOptions> zzVA;
    private static final com.google.android.gms.common.api.Api.zza<zzks, NoOptions> zzVB;
    private static final com.google.android.gms.common.api.Api.zza<zzkw, NoOptions> zzVC;
    private static final com.google.android.gms.common.api.Api.zza<zzo, zzg> zzVD;
    private static final com.google.android.gms.common.api.Api.zza<zzd, GoogleSignInOptions> zzVE;
    public static final Api<zzg> zzVF;
    public static final Api<NoOptions> zzVG;
    public static final Api<NoOptions> zzVH;
    public static final zzkq zzVI;
    public static final com.google.android.gms.auth.api.signin.zzf zzVJ;
    public static final com.google.android.gms.auth.api.consent.zza zzVK;
    public static final zzc<zzkz> zzVt;
    public static final zzc<zzf> zzVu;
    public static final zzc<zzks> zzVv;
    public static final zzc<zzo> zzVw;
    public static final zzc<zzd> zzVx;
    public static final zzc<zzkw> zzVy;
    private static final com.google.android.gms.common.api.Api.zza<zzkz, zza> zzVz;

    /* renamed from: com.google.android.gms.auth.api.Auth.1 */
    static class C07191 extends com.google.android.gms.common.api.Api.zza<zzkz, zza> {
        C07191() {
        }

        public zzkz zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, zza com_google_android_gms_auth_api_Auth_zza, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzkz(context, looper, com_google_android_gms_common_internal_zzf, com_google_android_gms_auth_api_Auth_zza, connectionCallbacks, onConnectionFailedListener);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.Auth.2 */
    static class C07202 extends com.google.android.gms.common.api.Api.zza<zzf, AuthCredentialsOptions> {
        C07202() {
        }

        public zzf zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, AuthCredentialsOptions authCredentialsOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzf(context, looper, com_google_android_gms_common_internal_zzf, authCredentialsOptions, connectionCallbacks, onConnectionFailedListener);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.Auth.3 */
    static class C07213 extends com.google.android.gms.common.api.Api.zza<zzks, NoOptions> {
        C07213() {
        }

        public /* synthetic */ zzb zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzc(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzks zzc(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzks(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.Auth.4 */
    static class C07224 extends com.google.android.gms.common.api.Api.zza<zzkw, NoOptions> {
        C07224() {
        }

        public /* synthetic */ zzb zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzd(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzkw zzd(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzkw(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.Auth.5 */
    static class C07235 extends com.google.android.gms.common.api.Api.zza<zzo, zzg> {
        C07235() {
        }

        public zzo zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, zzg com_google_android_gms_auth_api_signin_zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzo(context, looper, com_google_android_gms_common_internal_zzf, com_google_android_gms_auth_api_signin_zzg, connectionCallbacks, onConnectionFailedListener);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.Auth.6 */
    static class C07246 extends com.google.android.gms.common.api.Api.zza<zzd, GoogleSignInOptions> {
        C07246() {
        }

        public zzd zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, @Nullable GoogleSignInOptions googleSignInOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzd(context, looper, com_google_android_gms_common_internal_zzf, googleSignInOptions, connectionCallbacks, onConnectionFailedListener);
        }

        public List<Scope> zza(@Nullable GoogleSignInOptions googleSignInOptions) {
            return googleSignInOptions == null ? Collections.emptyList() : googleSignInOptions.zzmN();
        }

        public /* synthetic */ List zzo(@Nullable Object obj) {
            return zza((GoogleSignInOptions) obj);
        }
    }

    public static final class AuthCredentialsOptions implements Optional {
        private final String zzVL;
        private final PasswordSpecification zzVM;

        public static class Builder {
            @NonNull
            private PasswordSpecification zzVM;

            public Builder() {
                this.zzVM = PasswordSpecification.zzWl;
            }
        }

        public Bundle zzml() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", this.zzVL);
            bundle.putParcelable("password_specification", this.zzVM);
            return bundle;
        }

        public PasswordSpecification zzmr() {
            return this.zzVM;
        }
    }

    public static final class zza implements Optional {
        private final Bundle zzVN;

        public Bundle zzms() {
            return new Bundle(this.zzVN);
        }
    }

    static {
        zzVt = new zzc();
        zzVu = new zzc();
        zzVv = new zzc();
        zzVw = new zzc();
        zzVx = new zzc();
        zzVy = new zzc();
        zzVz = new C07191();
        zzVA = new C07202();
        zzVB = new C07213();
        zzVC = new C07224();
        zzVD = new C07235();
        zzVE = new C07246();
        PROXY_API = new Api("Auth.PROXY_API", zzVz, zzVt);
        CREDENTIALS_API = new Api("Auth.CREDENTIALS_API", zzVA, zzVu);
        zzVF = new Api("Auth.SIGN_IN_API", zzVD, zzVw);
        GOOGLE_SIGN_IN_API = new Api("Auth.GOOGLE_SIGN_IN_API", zzVE, zzVx);
        zzVG = new Api("Auth.ACCOUNT_STATUS_API", zzVB, zzVv);
        zzVH = new Api("Auth.CONSENT_API", zzVC, zzVy);
        ProxyApi = new zzld();
        CredentialsApi = new com.google.android.gms.auth.api.credentials.internal.zzd();
        zzVI = new zzkr();
        zzVJ = new zzn();
        GoogleSignInApi = new com.google.android.gms.auth.api.signin.internal.zzc();
        zzVK = new zzkv();
    }

    private Auth() {
    }
}
