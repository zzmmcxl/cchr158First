package com.google.android.gms.panorama;

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
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.internal.zzqr;

public final class Panorama {
    public static final Api<NoOptions> API;
    public static final PanoramaApi PanoramaApi;
    public static final zzc<zzqr> zzUI;
    static final zza<zzqr, NoOptions> zzUJ;

    /* renamed from: com.google.android.gms.panorama.Panorama.1 */
    static class C08871 extends zza<zzqr, NoOptions> {
        C08871() {
        }

        public /* synthetic */ zzb zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzr(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzqr zzr(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzqr(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static {
        zzUI = new zzc();
        zzUJ = new C08871();
        API = new Api("Panorama.API", zzUJ, zzUI);
        PanoramaApi = new zzqq();
    }

    private Panorama() {
    }
}
