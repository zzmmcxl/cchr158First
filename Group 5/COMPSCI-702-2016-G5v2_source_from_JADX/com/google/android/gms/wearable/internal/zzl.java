package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;

public final class zzl implements ChannelApi {

    /* renamed from: com.google.android.gms.wearable.internal.zzl.2 */
    static class C09222 implements zza<ChannelListener> {
        final /* synthetic */ IntentFilter[] zzbrP;

        C09222(IntentFilter[] intentFilterArr) {
            this.zzbrP = intentFilterArr;
        }

        public void zza(zzbp com_google_android_gms_wearable_internal_zzbp, com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, ChannelListener channelListener, zzq<ChannelListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_ChannelApi_ChannelListener) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, channelListener, (zzq) com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_ChannelApi_ChannelListener, null, this.zzbrP);
        }
    }

    static final class zza implements OpenChannelResult {
        private final Status zzUX;
        private final Channel zzbrY;

        zza(Status status, Channel channel) {
            this.zzUX = (Status) zzx.zzz(status);
            this.zzbrY = channel;
        }

        public Channel getChannel() {
            return this.zzbrY;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzl.1 */
    class C11171 extends zzi<OpenChannelResult> {
        final /* synthetic */ String zzAP;
        final /* synthetic */ String zzbrW;
        final /* synthetic */ zzl zzbrX;

        C11171(zzl com_google_android_gms_wearable_internal_zzl, GoogleApiClient googleApiClient, String str, String str2) {
            this.zzbrX = com_google_android_gms_wearable_internal_zzl;
            this.zzbrW = str;
            this.zzAP = str2;
            super(googleApiClient);
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zze(this, this.zzbrW, this.zzAP);
        }

        public OpenChannelResult zzbs(Status status) {
            return new zza(status, null);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbs(status);
        }
    }

    static final class zzb extends zzi<Status> {
        private final String zzVo;
        private ChannelListener zzbrZ;

        zzb(GoogleApiClient googleApiClient, ChannelListener channelListener, String str) {
            super(googleApiClient);
            this.zzbrZ = (ChannelListener) zzx.zzz(channelListener);
            this.zzVo = str;
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) this, this.zzbrZ, this.zzVo);
            this.zzbrZ = null;
        }

        public Status zzb(Status status) {
            this.zzbrZ = null;
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    private static zza<ChannelListener> zza(IntentFilter[] intentFilterArr) {
        return new C09222(intentFilterArr);
    }

    public PendingResult<Status> addListener(GoogleApiClient client, ChannelListener listener) {
        zzx.zzb((Object) client, (Object) "client is null");
        zzx.zzb((Object) listener, (Object) "listener is null");
        return zzb.zza(client, zza(new IntentFilter[]{zzbn.zzgM(ChannelApi.ACTION_CHANNEL_EVENT)}), listener);
    }

    public PendingResult<OpenChannelResult> openChannel(GoogleApiClient client, String nodeId, String path) {
        zzx.zzb((Object) client, (Object) "client is null");
        zzx.zzb((Object) nodeId, (Object) "nodeId is null");
        zzx.zzb((Object) path, (Object) "path is null");
        return client.zza(new C11171(this, client, nodeId, path));
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, ChannelListener listener) {
        zzx.zzb((Object) client, (Object) "client is null");
        zzx.zzb((Object) listener, (Object) "listener is null");
        return client.zza(new zzb(client, listener, null));
    }
}
