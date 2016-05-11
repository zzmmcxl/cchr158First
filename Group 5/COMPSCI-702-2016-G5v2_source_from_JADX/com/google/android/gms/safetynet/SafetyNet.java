package com.google.android.gms.safetynet;

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
import com.google.android.gms.internal.zzre;
import com.google.android.gms.internal.zzrf;
import com.google.android.gms.internal.zzrg;

public final class SafetyNet {
    public static final Api<NoOptions> API;
    public static final SafetyNetApi SafetyNetApi;
    public static final zzc<zzrf> zzUI;
    public static final zza<zzrf, NoOptions> zzUJ;
    public static final zzc zzbgw;

    /* renamed from: com.google.android.gms.safetynet.SafetyNet.1 */
    static class C08891 extends zza<zzrf, NoOptions> {
        C08891() {
        }

        public /* synthetic */ zzb zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzs(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzrf zzs(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzrf(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static {
        zzUI = new zzc();
        zzUJ = new C08891();
        API = new Api("SafetyNet.API", zzUJ, zzUI);
        SafetyNetApi = new zzre();
        zzbgw = new zzrg();
    }

    private SafetyNet() {
    }
}
