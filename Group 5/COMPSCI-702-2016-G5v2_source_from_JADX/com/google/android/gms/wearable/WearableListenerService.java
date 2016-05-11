package com.google.android.gms.wearable;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.zze;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable;
import com.google.android.gms.wearable.internal.AncsNotificationParcelable;
import com.google.android.gms.wearable.internal.CapabilityInfoParcelable;
import com.google.android.gms.wearable.internal.ChannelEventParcelable;
import com.google.android.gms.wearable.internal.MessageEventParcelable;
import com.google.android.gms.wearable.internal.NodeParcelable;
import java.util.List;

public abstract class WearableListenerService extends Service implements CapabilityListener, ChannelListener, DataListener, MessageListener, NodeListener, com.google.android.gms.wearable.NodeApi.zza {
    public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
    private boolean zzQl;
    private String zzTJ;
    private IBinder zzakD;
    private Handler zzbro;
    private final Object zzbrp;

    private final class zza extends com.google.android.gms.wearable.internal.zzaw.zza {
        private volatile int zzakz;
        final /* synthetic */ WearableListenerService zzbrq;

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.zza.1 */
        class C05781 implements Runnable {
            final /* synthetic */ DataHolder zzbrr;
            final /* synthetic */ zza zzbrs;

            C05781(zza com_google_android_gms_wearable_WearableListenerService_zza, DataHolder dataHolder) {
                this.zzbrs = com_google_android_gms_wearable_WearableListenerService_zza;
                this.zzbrr = dataHolder;
            }

            public void run() {
                DataEventBuffer dataEventBuffer = new DataEventBuffer(this.zzbrr);
                try {
                    this.zzbrs.zzbrq.onDataChanged(dataEventBuffer);
                } finally {
                    dataEventBuffer.release();
                }
            }
        }

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.zza.2 */
        class C05792 implements Runnable {
            final /* synthetic */ zza zzbrs;
            final /* synthetic */ MessageEventParcelable zzbrt;

            C05792(zza com_google_android_gms_wearable_WearableListenerService_zza, MessageEventParcelable messageEventParcelable) {
                this.zzbrs = com_google_android_gms_wearable_WearableListenerService_zza;
                this.zzbrt = messageEventParcelable;
            }

            public void run() {
                this.zzbrs.zzbrq.onMessageReceived(this.zzbrt);
            }
        }

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.zza.3 */
        class C05803 implements Runnable {
            final /* synthetic */ zza zzbrs;
            final /* synthetic */ NodeParcelable zzbru;

            C05803(zza com_google_android_gms_wearable_WearableListenerService_zza, NodeParcelable nodeParcelable) {
                this.zzbrs = com_google_android_gms_wearable_WearableListenerService_zza;
                this.zzbru = nodeParcelable;
            }

            public void run() {
                this.zzbrs.zzbrq.onPeerConnected(this.zzbru);
            }
        }

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.zza.4 */
        class C05814 implements Runnable {
            final /* synthetic */ zza zzbrs;
            final /* synthetic */ NodeParcelable zzbru;

            C05814(zza com_google_android_gms_wearable_WearableListenerService_zza, NodeParcelable nodeParcelable) {
                this.zzbrs = com_google_android_gms_wearable_WearableListenerService_zza;
                this.zzbru = nodeParcelable;
            }

            public void run() {
                this.zzbrs.zzbrq.onPeerDisconnected(this.zzbru);
            }
        }

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.zza.5 */
        class C05825 implements Runnable {
            final /* synthetic */ zza zzbrs;
            final /* synthetic */ List zzbrv;

            C05825(zza com_google_android_gms_wearable_WearableListenerService_zza, List list) {
                this.zzbrs = com_google_android_gms_wearable_WearableListenerService_zza;
                this.zzbrv = list;
            }

            public void run() {
                this.zzbrs.zzbrq.onConnectedNodes(this.zzbrv);
            }
        }

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.zza.6 */
        class C05836 implements Runnable {
            final /* synthetic */ zza zzbrs;
            final /* synthetic */ CapabilityInfoParcelable zzbrw;

            C05836(zza com_google_android_gms_wearable_WearableListenerService_zza, CapabilityInfoParcelable capabilityInfoParcelable) {
                this.zzbrs = com_google_android_gms_wearable_WearableListenerService_zza;
                this.zzbrw = capabilityInfoParcelable;
            }

            public void run() {
                this.zzbrs.zzbrq.onCapabilityChanged(this.zzbrw);
            }
        }

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.zza.7 */
        class C05847 implements Runnable {
            final /* synthetic */ zza zzbrs;
            final /* synthetic */ AncsNotificationParcelable zzbrx;

            C05847(zza com_google_android_gms_wearable_WearableListenerService_zza, AncsNotificationParcelable ancsNotificationParcelable) {
                this.zzbrs = com_google_android_gms_wearable_WearableListenerService_zza;
                this.zzbrx = ancsNotificationParcelable;
            }

            public void run() {
                ((zzj) this.zzbrs.zzbrq).zza(this.zzbrx);
            }
        }

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.zza.8 */
        class C05858 implements Runnable {
            final /* synthetic */ zza zzbrs;
            final /* synthetic */ AmsEntityUpdateParcelable zzbry;

            C05858(zza com_google_android_gms_wearable_WearableListenerService_zza, AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
                this.zzbrs = com_google_android_gms_wearable_WearableListenerService_zza;
                this.zzbry = amsEntityUpdateParcelable;
            }

            public void run() {
                ((zzj) this.zzbrs.zzbrq).zza(this.zzbry);
            }
        }

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.zza.9 */
        class C05869 implements Runnable {
            final /* synthetic */ zza zzbrs;
            final /* synthetic */ ChannelEventParcelable zzbrz;

            C05869(zza com_google_android_gms_wearable_WearableListenerService_zza, ChannelEventParcelable channelEventParcelable) {
                this.zzbrs = com_google_android_gms_wearable_WearableListenerService_zza;
                this.zzbrz = channelEventParcelable;
            }

            public void run() {
                this.zzbrz.zza(this.zzbrs.zzbrq);
            }
        }

        private zza(WearableListenerService wearableListenerService) {
            this.zzbrq = wearableListenerService;
            this.zzakz = -1;
        }

        private void zzIx() throws SecurityException {
            int callingUid = Binder.getCallingUid();
            if (callingUid != this.zzakz) {
                if (zze.zzf(this.zzbrq, callingUid)) {
                    this.zzakz = callingUid;
                    return;
                }
                throw new SecurityException("Caller is not GooglePlayServices");
            }
        }

        private boolean zza(Runnable runnable, String str, Object obj) {
            return !(this.zzbrq instanceof zzj) ? false : zzb(runnable, str, obj);
        }

        private boolean zzb(Runnable runnable, String str, Object obj) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", String.format("%s: %s %s", new Object[]{str, this.zzbrq.zzTJ, obj}));
            }
            zzIx();
            synchronized (this.zzbrq.zzbrp) {
                if (this.zzbrq.zzQl) {
                    return false;
                }
                this.zzbrq.zzbro.post(runnable);
                return true;
            }
        }

        public void onConnectedNodes(List<NodeParcelable> connectedNodes) {
            zzb(new C05825(this, connectedNodes), "onConnectedNodes", connectedNodes);
        }

        public void zza(AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
            zza(new C05858(this, amsEntityUpdateParcelable), "onEntityUpdate", amsEntityUpdateParcelable);
        }

        public void zza(AncsNotificationParcelable ancsNotificationParcelable) {
            zza(new C05847(this, ancsNotificationParcelable), "onNotificationReceived", ancsNotificationParcelable);
        }

        public void zza(CapabilityInfoParcelable capabilityInfoParcelable) {
            zzb(new C05836(this, capabilityInfoParcelable), "onConnectedCapabilityChanged", capabilityInfoParcelable);
        }

        public void zza(ChannelEventParcelable channelEventParcelable) {
            zzb(new C05869(this, channelEventParcelable), "onChannelEvent", channelEventParcelable);
        }

        public void zza(MessageEventParcelable messageEventParcelable) {
            zzb(new C05792(this, messageEventParcelable), "onMessageReceived", messageEventParcelable);
        }

        public void zza(NodeParcelable nodeParcelable) {
            zzb(new C05803(this, nodeParcelable), "onPeerConnected", nodeParcelable);
        }

        public void zzag(DataHolder dataHolder) {
            try {
                if (!zzb(new C05781(this, dataHolder), "onDataItemChanged", dataHolder)) {
                }
            } finally {
                dataHolder.close();
            }
        }

        public void zzb(NodeParcelable nodeParcelable) {
            zzb(new C05814(this, nodeParcelable), "onPeerDisconnected", nodeParcelable);
        }
    }

    public WearableListenerService() {
        this.zzbrp = new Object();
    }

    public final IBinder onBind(Intent intent) {
        return BIND_LISTENER_INTENT_ACTION.equals(intent.getAction()) ? this.zzakD : null;
    }

    public void onCapabilityChanged(CapabilityInfo capabilityInfo) {
    }

    public void onChannelClosed(Channel channel, int closeReason, int appSpecificErrorCode) {
    }

    public void onChannelOpened(Channel channel) {
    }

    public void onConnectedNodes(List<Node> list) {
    }

    public void onCreate() {
        super.onCreate();
        if (Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", "onCreate: " + new ComponentName(getPackageName(), getClass().getName()).flattenToShortString());
        }
        this.zzTJ = getPackageName();
        HandlerThread handlerThread = new HandlerThread("WearableListenerService");
        handlerThread.start();
        this.zzbro = new Handler(handlerThread.getLooper());
        this.zzakD = new zza();
    }

    public void onDataChanged(DataEventBuffer dataEvents) {
    }

    public void onDestroy() {
        if (Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", "onDestroy: " + new ComponentName(getPackageName(), getClass().getName()).flattenToShortString());
        }
        synchronized (this.zzbrp) {
            this.zzQl = true;
            if (this.zzbro == null) {
                throw new IllegalStateException("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()?");
            }
            this.zzbro.getLooper().quit();
        }
        super.onDestroy();
    }

    public void onInputClosed(Channel channel, int closeReason, int appSpecificErrorCode) {
    }

    public void onMessageReceived(MessageEvent messageEvent) {
    }

    public void onOutputClosed(Channel channel, int closeReason, int appSpecificErrorCode) {
    }

    public void onPeerConnected(Node peer) {
    }

    public void onPeerDisconnected(Node peer) {
    }
}
