package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;

public final class zzaz implements MessageApi {

    public static class zzb implements SendMessageResult {
        private final Status zzUX;
        private final int zzaox;

        public zzb(Status status, int i) {
            this.zzUX = status;
            this.zzaox = i;
        }

        public int getRequestId() {
            return this.zzaox;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzaz.1 */
    class C11081 extends zzi<SendMessageResult> {
        final /* synthetic */ String zzbrW;
        final /* synthetic */ String zzbsO;
        final /* synthetic */ byte[] zzbsP;
        final /* synthetic */ zzaz zzbsQ;

        C11081(zzaz com_google_android_gms_wearable_internal_zzaz, GoogleApiClient googleApiClient, String str, String str2, byte[] bArr) {
            this.zzbsQ = com_google_android_gms_wearable_internal_zzaz;
            this.zzbrW = str;
            this.zzbsO = str2;
            this.zzbsP = bArr;
            super(googleApiClient);
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) this, this.zzbrW, this.zzbsO, this.zzbsP);
        }

        protected SendMessageResult zzbz(Status status) {
            return new zzb(status, -1);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzbz(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzaz.2 */
    class C11092 extends zzi<Status> {
        final /* synthetic */ zzaz zzbsQ;
        final /* synthetic */ MessageListener zzbsR;

        C11092(zzaz com_google_android_gms_wearable_internal_zzaz, GoogleApiClient googleApiClient, MessageListener messageListener) {
            this.zzbsQ = com_google_android_gms_wearable_internal_zzaz;
            this.zzbsR = messageListener;
            super(googleApiClient);
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) this, this.zzbsR);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    private static final class zza extends zzi<Status> {
        private zzq<MessageListener> zzbbi;
        private MessageListener zzbsS;
        private IntentFilter[] zzbsT;

        private zza(GoogleApiClient googleApiClient, MessageListener messageListener, zzq<MessageListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_MessageApi_MessageListener, IntentFilter[] intentFilterArr) {
            super(googleApiClient);
            this.zzbsS = (MessageListener) zzx.zzz(messageListener);
            this.zzbbi = (zzq) zzx.zzz(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_MessageApi_MessageListener);
            this.zzbsT = (IntentFilter[]) zzx.zzz(intentFilterArr);
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) this, this.zzbsS, this.zzbbi, this.zzbsT);
            this.zzbsS = null;
            this.zzbbi = null;
            this.zzbsT = null;
        }

        public Status zzb(Status status) {
            this.zzbsS = null;
            this.zzbbi = null;
            this.zzbsT = null;
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, MessageListener messageListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.zza(new zza(messageListener, googleApiClient.zzr(messageListener), intentFilterArr, null));
    }

    public PendingResult<Status> addListener(GoogleApiClient client, MessageListener listener) {
        return zza(client, listener, new IntentFilter[]{zzbn.zzgM(MessageApi.ACTION_MESSAGE_RECEIVED)});
    }

    public PendingResult<Status> addListener(GoogleApiClient client, MessageListener listener, Uri uri, int filterType) {
        zzx.zzb(uri != null, (Object) "uri must not be null");
        boolean z = filterType == 0 || filterType == 1;
        zzx.zzb(z, (Object) "invalid filter type");
        return zza(client, listener, new IntentFilter[]{zzbn.zza(MessageApi.ACTION_MESSAGE_RECEIVED, uri, filterType)});
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, MessageListener listener) {
        return client.zza(new C11092(this, client, listener));
    }

    public PendingResult<SendMessageResult> sendMessage(GoogleApiClient client, String nodeId, String action, byte[] data) {
        return client.zza(new C11081(this, client, nodeId, action, data));
    }
}
