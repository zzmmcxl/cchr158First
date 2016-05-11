package com.google.android.gms.appdatasearch;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzki;
import com.google.android.gms.internal.zzkk;

public final class zza {
    public static final Api<NoOptions> zzTA;
    public static final zzk zzTB;
    public static final zzc<zzki> zzTy;
    private static final com.google.android.gms.common.api.Api.zza<zzki, NoOptions> zzTz;

    /* renamed from: com.google.android.gms.appdatasearch.zza.1 */
    static class C07171 extends com.google.android.gms.common.api.Api.zza<zzki, NoOptions> {
        C07171() {
        }

        public zzki zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzki(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static {
        zzTy = new zzc();
        zzTz = new C07171();
        zzTA = new Api("AppDataSearch.LIGHTWEIGHT_API", zzTz, zzTy);
        zzTB = new zzkk();
    }
}
