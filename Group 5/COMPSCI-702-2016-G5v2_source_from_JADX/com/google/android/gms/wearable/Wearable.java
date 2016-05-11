package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.wearable.internal.zzaz;
import com.google.android.gms.wearable.internal.zzbb;
import com.google.android.gms.wearable.internal.zzbm;
import com.google.android.gms.wearable.internal.zzbp;
import com.google.android.gms.wearable.internal.zzbr;
import com.google.android.gms.wearable.internal.zze;
import com.google.android.gms.wearable.internal.zzg;
import com.google.android.gms.wearable.internal.zzj;
import com.google.android.gms.wearable.internal.zzl;
import com.google.android.gms.wearable.internal.zzw;
import com.google.android.gms.wearable.internal.zzx;

public class Wearable {
    public static final Api<WearableOptions> API;
    public static final CapabilityApi CapabilityApi;
    public static final ChannelApi ChannelApi;
    public static final DataApi DataApi;
    public static final MessageApi MessageApi;
    public static final NodeApi NodeApi;
    public static final zzc<zzbp> zzUI;
    private static final zza<zzbp, WearableOptions> zzUJ;
    public static final zzc zzbrj;
    public static final zza zzbrk;
    public static final zzf zzbrl;
    public static final zzi zzbrm;
    public static final zzk zzbrn;

    /* renamed from: com.google.android.gms.wearable.Wearable.1 */
    static class C09091 extends zza<zzbp, WearableOptions> {
        C09091() {
        }

        public zzbp zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, WearableOptions wearableOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (wearableOptions == null) {
                WearableOptions wearableOptions2 = new WearableOptions(null);
            }
            return new zzbp(context, looper, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf);
        }
    }

    public static final class WearableOptions implements Optional {

        public static class Builder {
            public WearableOptions build() {
                return new WearableOptions();
            }
        }

        private WearableOptions(Builder builder) {
        }
    }

    static {
        DataApi = new zzx();
        CapabilityApi = new zzj();
        MessageApi = new zzaz();
        NodeApi = new zzbb();
        ChannelApi = new zzl();
        zzbrj = new zzg();
        zzbrk = new zze();
        zzbrl = new zzw();
        zzbrm = new zzbm();
        zzbrn = new zzbr();
        zzUI = new zzc();
        zzUJ = new C09091();
        API = new Api("Wearable.API", zzUJ, zzUI);
    }

    private Wearable() {
    }
}
