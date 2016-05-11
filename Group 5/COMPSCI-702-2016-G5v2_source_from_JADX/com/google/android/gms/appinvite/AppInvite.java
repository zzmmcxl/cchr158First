package com.google.android.gms.appinvite;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzkm;

public final class AppInvite {
    public static final Api<NoOptions> API;
    public static final AppInviteApi AppInviteApi;
    public static final zzc<zzkm> zzUI;
    private static final zza<zzkm, NoOptions> zzUJ;

    /* renamed from: com.google.android.gms.appinvite.AppInvite.1 */
    static class C07181 extends zza<zzkm, NoOptions> {
        C07181() {
        }

        public /* synthetic */ zzb zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzb(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzkm zzb(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzkm(context, looper, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf);
        }
    }

    static {
        zzUI = new zzc();
        zzUJ = new C07181();
        API = new Api("AppInvite.API", zzUJ, zzUI);
        AppInviteApi = new zzkl();
    }

    private AppInvite() {
    }
}
