package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.PublishOptions.Builder;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import java.util.List;

public class zzn implements Messages {
    public static final zzc<zzm> zzUI;
    public static final com.google.android.gms.common.api.Api.zza<zzm, MessagesOptions> zzUJ;

    /* renamed from: com.google.android.gms.nearby.messages.internal.zzn.1 */
    static class C08851 extends com.google.android.gms.common.api.Api.zza<zzm, MessagesOptions> {
        C08851() {
        }

        public int getPriority() {
            return Strategy.TTL_SECONDS_INFINITE;
        }

        public zzm zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, MessagesOptions messagesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzm(context, looper, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf, messagesOptions);
        }
    }

    static abstract class zza extends com.google.android.gms.common.api.internal.zza.zza<Status, zzm> {
        public zza(GoogleApiClient googleApiClient) {
            super(zzn.zzUI, googleApiClient);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.nearby.messages.internal.zzn.10 */
    class AnonymousClass10 extends zza {
        final /* synthetic */ zzq zzbcL;
        final /* synthetic */ StatusCallback zzbcM;
        final /* synthetic */ zzn zzbcN;

        AnonymousClass10(zzn com_google_android_gms_nearby_messages_internal_zzn, GoogleApiClient googleApiClient, zzq com_google_android_gms_common_api_internal_zzq, StatusCallback statusCallback) {
            this.zzbcN = com_google_android_gms_nearby_messages_internal_zzn;
            this.zzbcL = com_google_android_gms_common_api_internal_zzq;
            this.zzbcM = statusCallback;
            super(googleApiClient);
        }

        protected void zza(zzm com_google_android_gms_nearby_messages_internal_zzm) throws RemoteException {
            com_google_android_gms_nearby_messages_internal_zzm.zza((zzb) this, this.zzbcL, this.zzbcM);
        }
    }

    /* renamed from: com.google.android.gms.nearby.messages.internal.zzn.2 */
    class C10942 extends zza {
        final /* synthetic */ zzq zzbcL;
        final /* synthetic */ StatusCallback zzbcM;
        final /* synthetic */ zzn zzbcN;

        C10942(zzn com_google_android_gms_nearby_messages_internal_zzn, GoogleApiClient googleApiClient, zzq com_google_android_gms_common_api_internal_zzq, StatusCallback statusCallback) {
            this.zzbcN = com_google_android_gms_nearby_messages_internal_zzn;
            this.zzbcL = com_google_android_gms_common_api_internal_zzq;
            this.zzbcM = statusCallback;
            super(googleApiClient);
        }

        protected void zza(zzm com_google_android_gms_nearby_messages_internal_zzm) throws RemoteException {
            com_google_android_gms_nearby_messages_internal_zzm.zzb(this, this.zzbcL, this.zzbcM);
        }
    }

    /* renamed from: com.google.android.gms.nearby.messages.internal.zzn.3 */
    class C10953 extends zza {
        final /* synthetic */ zzn zzbcN;
        final /* synthetic */ Message zzbcO;
        final /* synthetic */ PublishOptions zzbcP;

        C10953(zzn com_google_android_gms_nearby_messages_internal_zzn, GoogleApiClient googleApiClient, Message message, PublishOptions publishOptions) {
            this.zzbcN = com_google_android_gms_nearby_messages_internal_zzn;
            this.zzbcO = message;
            this.zzbcP = publishOptions;
            super(googleApiClient);
        }

        protected void zza(zzm com_google_android_gms_nearby_messages_internal_zzm) throws RemoteException {
            com_google_android_gms_nearby_messages_internal_zzm.zza((zzb) this, MessageWrapper.zzb(this.zzbcO), this.zzbcP);
        }
    }

    /* renamed from: com.google.android.gms.nearby.messages.internal.zzn.4 */
    class C10964 extends zza {
        final /* synthetic */ zzn zzbcN;
        final /* synthetic */ Message zzbcO;

        C10964(zzn com_google_android_gms_nearby_messages_internal_zzn, GoogleApiClient googleApiClient, Message message) {
            this.zzbcN = com_google_android_gms_nearby_messages_internal_zzn;
            this.zzbcO = message;
            super(googleApiClient);
        }

        protected void zza(zzm com_google_android_gms_nearby_messages_internal_zzm) throws RemoteException {
            com_google_android_gms_nearby_messages_internal_zzm.zza((zzb) this, MessageWrapper.zzb(this.zzbcO));
        }
    }

    /* renamed from: com.google.android.gms.nearby.messages.internal.zzn.5 */
    class C10975 extends zza {
        final /* synthetic */ zzq zzbbv;
        final /* synthetic */ zzn zzbcN;
        final /* synthetic */ MessageListener zzbcQ;
        final /* synthetic */ SubscribeOptions zzbcR;

        C10975(zzn com_google_android_gms_nearby_messages_internal_zzn, GoogleApiClient googleApiClient, zzq com_google_android_gms_common_api_internal_zzq, MessageListener messageListener, SubscribeOptions subscribeOptions) {
            this.zzbcN = com_google_android_gms_nearby_messages_internal_zzn;
            this.zzbbv = com_google_android_gms_common_api_internal_zzq;
            this.zzbcQ = messageListener;
            this.zzbcR = subscribeOptions;
            super(googleApiClient);
        }

        protected void zza(zzm com_google_android_gms_nearby_messages_internal_zzm) throws RemoteException {
            com_google_android_gms_nearby_messages_internal_zzm.zza(this, this.zzbbv, this.zzbcQ, this.zzbcR, null);
        }
    }

    /* renamed from: com.google.android.gms.nearby.messages.internal.zzn.6 */
    class C10986 extends zza {
        final /* synthetic */ PendingIntent zzaAp;
        final /* synthetic */ zzn zzbcN;
        final /* synthetic */ SubscribeOptions zzbcR;

        C10986(zzn com_google_android_gms_nearby_messages_internal_zzn, GoogleApiClient googleApiClient, PendingIntent pendingIntent, SubscribeOptions subscribeOptions) {
            this.zzbcN = com_google_android_gms_nearby_messages_internal_zzn;
            this.zzaAp = pendingIntent;
            this.zzbcR = subscribeOptions;
            super(googleApiClient);
        }

        protected void zza(zzm com_google_android_gms_nearby_messages_internal_zzm) throws RemoteException {
            com_google_android_gms_nearby_messages_internal_zzm.zza((zzb) this, this.zzaAp, this.zzbcR);
        }
    }

    /* renamed from: com.google.android.gms.nearby.messages.internal.zzn.7 */
    class C10997 extends zza {
        final /* synthetic */ zzq zzbbv;
        final /* synthetic */ zzn zzbcN;
        final /* synthetic */ MessageListener zzbcQ;

        C10997(zzn com_google_android_gms_nearby_messages_internal_zzn, GoogleApiClient googleApiClient, zzq com_google_android_gms_common_api_internal_zzq, MessageListener messageListener) {
            this.zzbcN = com_google_android_gms_nearby_messages_internal_zzn;
            this.zzbbv = com_google_android_gms_common_api_internal_zzq;
            this.zzbcQ = messageListener;
            super(googleApiClient);
        }

        protected void zza(zzm com_google_android_gms_nearby_messages_internal_zzm) throws RemoteException {
            com_google_android_gms_nearby_messages_internal_zzm.zza((zzb) this, this.zzbbv, this.zzbcQ);
        }
    }

    /* renamed from: com.google.android.gms.nearby.messages.internal.zzn.8 */
    class C11008 extends zza {
        final /* synthetic */ PendingIntent zzaAp;
        final /* synthetic */ zzn zzbcN;

        C11008(zzn com_google_android_gms_nearby_messages_internal_zzn, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
            this.zzbcN = com_google_android_gms_nearby_messages_internal_zzn;
            this.zzaAp = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzm com_google_android_gms_nearby_messages_internal_zzm) throws RemoteException {
            com_google_android_gms_nearby_messages_internal_zzm.zza((zzb) this, this.zzaAp);
        }
    }

    /* renamed from: com.google.android.gms.nearby.messages.internal.zzn.9 */
    class C11019 extends zza {
        final /* synthetic */ zzn zzbcN;

        C11019(zzn com_google_android_gms_nearby_messages_internal_zzn, GoogleApiClient googleApiClient) {
            this.zzbcN = com_google_android_gms_nearby_messages_internal_zzn;
            super(googleApiClient);
        }

        protected void zza(zzm com_google_android_gms_nearby_messages_internal_zzm) throws RemoteException {
            com_google_android_gms_nearby_messages_internal_zzm.zzm(this);
        }
    }

    static {
        zzUI = new zzc();
        zzUJ = new C08851();
    }

    @Nullable
    private static Message zzA(Intent intent) {
        return (Message) zzj.zzc(intent, "com.google.android.gms.nearby.messages.MESSAGES");
    }

    @Nullable
    private static Message zzB(Intent intent) {
        return (Message) zzj.zzc(intent, "com.google.android.gms.nearby.messages.LOST_MESSAGE");
    }

    private static List<Message> zzC(Intent intent) {
        return zzj.zzd(intent, "com.google.android.gms.nearby.messages.UPDATED_MESSAGES");
    }

    public PendingResult<Status> getPermissionStatus(GoogleApiClient client) {
        return client.zzb(new C11019(this, client));
    }

    public void handleIntent(Intent intent, MessageListener messageListener) {
        Message zzA = zzA(intent);
        if (zzA != null) {
            messageListener.onFound(zzA);
        }
        zzA = zzB(intent);
        if (zzA != null) {
            messageListener.onLost(zzA);
        }
        for (Message zzA2 : zzC(intent)) {
            messageListener.zza(zzA2);
        }
    }

    public PendingResult<Status> publish(GoogleApiClient client, Message message) {
        return publish(client, message, PublishOptions.DEFAULT);
    }

    public PendingResult<Status> publish(GoogleApiClient client, Message message, PublishOptions options) {
        zzx.zzz(message);
        zzx.zzz(options);
        return client.zzb(new C10953(this, client, message, options));
    }

    @Deprecated
    public PendingResult<Status> publish(GoogleApiClient client, Message message, Strategy strategy) {
        return publish(client, message, new Builder().setStrategy(strategy).build());
    }

    public PendingResult<Status> registerStatusCallback(GoogleApiClient client, StatusCallback statusCallback) {
        zzx.zzz(statusCallback);
        return client.zzb(new AnonymousClass10(this, client, ((zzm) client.zza(zzUI)).zza(client, statusCallback), statusCallback));
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, PendingIntent pendingIntent) {
        return subscribe(client, pendingIntent, SubscribeOptions.DEFAULT);
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, PendingIntent pendingIntent, SubscribeOptions options) {
        zzx.zzz(pendingIntent);
        zzx.zzz(options);
        return client.zzb(new C10986(this, client, pendingIntent, options));
    }

    @Deprecated
    public PendingResult<Status> subscribe(GoogleApiClient client, MessageListener listener) {
        return subscribe(client, listener, SubscribeOptions.DEFAULT);
    }

    @Deprecated
    public PendingResult<Status> subscribe(GoogleApiClient client, MessageListener listener, Strategy strategy) {
        return subscribe(client, listener, new SubscribeOptions.Builder().setStrategy(strategy).build());
    }

    @Deprecated
    public PendingResult<Status> subscribe(GoogleApiClient client, MessageListener listener, Strategy strategy, MessageFilter filter) {
        return subscribe(client, listener, new SubscribeOptions.Builder().setStrategy(strategy).setFilter(filter).build());
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, MessageListener listener, SubscribeOptions options) {
        zzx.zzz(listener);
        zzx.zzz(options);
        return client.zzb(new C10975(this, client, ((zzm) client.zza(zzUI)).zza(client, listener), listener, options));
    }

    public PendingResult<Status> unpublish(GoogleApiClient client, Message message) {
        zzx.zzz(message);
        return client.zzb(new C10964(this, client, message));
    }

    public PendingResult<Status> unregisterStatusCallback(GoogleApiClient client, StatusCallback statusCallback) {
        return client.zzb(new C10942(this, client, ((zzm) client.zza(zzUI)).zza(client, statusCallback), statusCallback));
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, PendingIntent pendingIntent) {
        zzx.zzz(pendingIntent);
        return client.zzb(new C11008(this, client, pendingIntent));
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, MessageListener listener) {
        zzx.zzz(listener);
        return client.zzb(new C10997(this, client, ((zzm) client.zza(zzUI)).zza(client, listener), listener));
    }
}
