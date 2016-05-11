package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.api.internal.zzq.zzb;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.internal.zzaw.zza;
import com.google.android.gms.wearable.zzc;
import java.util.List;

final class zzbq<T> extends zza {
    private zzq<MessageListener> zzbbb;
    private final IntentFilter[] zzbsT;
    private zzq<com.google.android.gms.wearable.zza.zza> zzbtp;
    private zzq<zzc.zza> zzbtq;
    private zzq<DataListener> zzbtr;
    private zzq<NodeListener> zzbts;
    private zzq<NodeApi.zza> zzbtt;
    private zzq<ChannelListener> zzbtu;
    private zzq<CapabilityListener> zzbtv;
    private final String zzbtw;

    /* renamed from: com.google.android.gms.wearable.internal.zzbq.1 */
    static class C09121 implements zzb<zzc.zza> {
        final /* synthetic */ AncsNotificationParcelable zzbrx;

        C09121(AncsNotificationParcelable ancsNotificationParcelable) {
            this.zzbrx = ancsNotificationParcelable;
        }

        public void zza(zzc.zza com_google_android_gms_wearable_zzc_zza) {
            com_google_android_gms_wearable_zzc_zza.zza(this.zzbrx);
        }

        public void zzpr() {
        }

        public /* synthetic */ void zzt(Object obj) {
            zza((zzc.zza) obj);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzbq.2 */
    static class C09132 implements zzb<com.google.android.gms.wearable.zza.zza> {
        final /* synthetic */ AmsEntityUpdateParcelable zzbry;

        C09132(AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
            this.zzbry = amsEntityUpdateParcelable;
        }

        public void zza(com.google.android.gms.wearable.zza.zza com_google_android_gms_wearable_zza_zza) {
            com_google_android_gms_wearable_zza_zza.zza(this.zzbry);
        }

        public void zzpr() {
        }

        public /* synthetic */ void zzt(Object obj) {
            zza((com.google.android.gms.wearable.zza.zza) obj);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzbq.3 */
    static class C09143 implements zzb<DataListener> {
        final /* synthetic */ DataHolder zzbrr;

        C09143(DataHolder dataHolder) {
            this.zzbrr = dataHolder;
        }

        public void zza(DataListener dataListener) {
            try {
                dataListener.onDataChanged(new DataEventBuffer(this.zzbrr));
            } finally {
                this.zzbrr.close();
            }
        }

        public void zzpr() {
            this.zzbrr.close();
        }

        public /* synthetic */ void zzt(Object obj) {
            zza((DataListener) obj);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzbq.4 */
    static class C09154 implements zzb<MessageListener> {
        final /* synthetic */ MessageEventParcelable zzbrt;

        C09154(MessageEventParcelable messageEventParcelable) {
            this.zzbrt = messageEventParcelable;
        }

        public void zza(MessageListener messageListener) {
            messageListener.onMessageReceived(this.zzbrt);
        }

        public void zzpr() {
        }

        public /* synthetic */ void zzt(Object obj) {
            zza((MessageListener) obj);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzbq.5 */
    static class C09165 implements zzb<NodeListener> {
        final /* synthetic */ NodeParcelable zzbru;

        C09165(NodeParcelable nodeParcelable) {
            this.zzbru = nodeParcelable;
        }

        public void zza(NodeListener nodeListener) {
            nodeListener.onPeerConnected(this.zzbru);
        }

        public void zzpr() {
        }

        public /* synthetic */ void zzt(Object obj) {
            zza((NodeListener) obj);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzbq.6 */
    static class C09176 implements zzb<NodeListener> {
        final /* synthetic */ NodeParcelable zzbru;

        C09176(NodeParcelable nodeParcelable) {
            this.zzbru = nodeParcelable;
        }

        public void zza(NodeListener nodeListener) {
            nodeListener.onPeerDisconnected(this.zzbru);
        }

        public void zzpr() {
        }

        public /* synthetic */ void zzt(Object obj) {
            zza((NodeListener) obj);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzbq.7 */
    static class C09187 implements zzb<NodeApi.zza> {
        final /* synthetic */ List zzbrv;

        C09187(List list) {
            this.zzbrv = list;
        }

        public void zza(NodeApi.zza com_google_android_gms_wearable_NodeApi_zza) {
            com_google_android_gms_wearable_NodeApi_zza.onConnectedNodes(this.zzbrv);
        }

        public void zzpr() {
        }

        public /* synthetic */ void zzt(Object obj) {
            zza((NodeApi.zza) obj);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzbq.8 */
    static class C09198 implements zzb<ChannelListener> {
        final /* synthetic */ ChannelEventParcelable zzbrz;

        C09198(ChannelEventParcelable channelEventParcelable) {
            this.zzbrz = channelEventParcelable;
        }

        public void zzb(ChannelListener channelListener) {
            this.zzbrz.zza(channelListener);
        }

        public void zzpr() {
        }

        public /* synthetic */ void zzt(Object obj) {
            zzb((ChannelListener) obj);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzbq.9 */
    static class C09209 implements zzb<CapabilityListener> {
        final /* synthetic */ CapabilityInfoParcelable zzbtx;

        C09209(CapabilityInfoParcelable capabilityInfoParcelable) {
            this.zzbtx = capabilityInfoParcelable;
        }

        public void zza(CapabilityListener capabilityListener) {
            capabilityListener.onCapabilityChanged(this.zzbtx);
        }

        public void zzpr() {
        }

        public /* synthetic */ void zzt(Object obj) {
            zza((CapabilityListener) obj);
        }
    }

    private zzbq(IntentFilter[] intentFilterArr, String str) {
        this.zzbsT = (IntentFilter[]) zzx.zzz(intentFilterArr);
        this.zzbtw = str;
    }

    private static zzb<NodeApi.zza> zzI(List<NodeParcelable> list) {
        return new C09187(list);
    }

    public static zzbq<ChannelListener> zza(zzq<ChannelListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_ChannelApi_ChannelListener, String str, IntentFilter[] intentFilterArr) {
        zzbq<ChannelListener> com_google_android_gms_wearable_internal_zzbq = new zzbq(intentFilterArr, (String) zzx.zzz(str));
        com_google_android_gms_wearable_internal_zzbq.zzbtu = (zzq) zzx.zzz(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_ChannelApi_ChannelListener);
        return com_google_android_gms_wearable_internal_zzbq;
    }

    public static zzbq<DataListener> zza(zzq<DataListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_DataApi_DataListener, IntentFilter[] intentFilterArr) {
        zzbq<DataListener> com_google_android_gms_wearable_internal_zzbq = new zzbq(intentFilterArr, null);
        com_google_android_gms_wearable_internal_zzbq.zzbtr = (zzq) zzx.zzz(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_DataApi_DataListener);
        return com_google_android_gms_wearable_internal_zzbq;
    }

    private static zzb<DataListener> zzai(DataHolder dataHolder) {
        return new C09143(dataHolder);
    }

    private static zzb<com.google.android.gms.wearable.zza.zza> zzb(AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
        return new C09132(amsEntityUpdateParcelable);
    }

    private static zzb<zzc.zza> zzb(AncsNotificationParcelable ancsNotificationParcelable) {
        return new C09121(ancsNotificationParcelable);
    }

    private static zzb<CapabilityListener> zzb(CapabilityInfoParcelable capabilityInfoParcelable) {
        return new C09209(capabilityInfoParcelable);
    }

    private static zzb<ChannelListener> zzb(ChannelEventParcelable channelEventParcelable) {
        return new C09198(channelEventParcelable);
    }

    private static zzb<MessageListener> zzb(MessageEventParcelable messageEventParcelable) {
        return new C09154(messageEventParcelable);
    }

    public static zzbq<MessageListener> zzb(zzq<MessageListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_MessageApi_MessageListener, IntentFilter[] intentFilterArr) {
        zzbq<MessageListener> com_google_android_gms_wearable_internal_zzbq = new zzbq(intentFilterArr, null);
        com_google_android_gms_wearable_internal_zzbq.zzbbb = (zzq) zzx.zzz(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_MessageApi_MessageListener);
        return com_google_android_gms_wearable_internal_zzbq;
    }

    private static zzb<NodeListener> zzc(NodeParcelable nodeParcelable) {
        return new C09165(nodeParcelable);
    }

    public static zzbq<NodeListener> zzc(zzq<NodeListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_NodeApi_NodeListener, IntentFilter[] intentFilterArr) {
        zzbq<NodeListener> com_google_android_gms_wearable_internal_zzbq = new zzbq(intentFilterArr, null);
        com_google_android_gms_wearable_internal_zzbq.zzbts = (zzq) zzx.zzz(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_NodeApi_NodeListener);
        return com_google_android_gms_wearable_internal_zzbq;
    }

    private static zzb<NodeListener> zzd(NodeParcelable nodeParcelable) {
        return new C09176(nodeParcelable);
    }

    public static zzbq<ChannelListener> zzd(zzq<ChannelListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_ChannelApi_ChannelListener, IntentFilter[] intentFilterArr) {
        zzbq<ChannelListener> com_google_android_gms_wearable_internal_zzbq = new zzbq(intentFilterArr, null);
        com_google_android_gms_wearable_internal_zzbq.zzbtu = (zzq) zzx.zzz(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_ChannelApi_ChannelListener);
        return com_google_android_gms_wearable_internal_zzbq;
    }

    public static zzbq<CapabilityListener> zze(zzq<CapabilityListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_CapabilityApi_CapabilityListener, IntentFilter[] intentFilterArr) {
        zzbq<CapabilityListener> com_google_android_gms_wearable_internal_zzbq = new zzbq(intentFilterArr, null);
        com_google_android_gms_wearable_internal_zzbq.zzbtv = (zzq) zzx.zzz(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_CapabilityApi_CapabilityListener);
        return com_google_android_gms_wearable_internal_zzbq;
    }

    private static void zzh(zzq<?> com_google_android_gms_common_api_internal_zzq_) {
        if (com_google_android_gms_common_api_internal_zzq_ != null) {
            com_google_android_gms_common_api_internal_zzq_.clear();
        }
    }

    public void clear() {
        zzh(this.zzbtp);
        this.zzbtp = null;
        zzh(this.zzbtq);
        this.zzbtq = null;
        zzh(this.zzbtr);
        this.zzbtr = null;
        zzh(this.zzbbb);
        this.zzbbb = null;
        zzh(this.zzbts);
        this.zzbts = null;
        zzh(this.zzbtt);
        this.zzbtt = null;
        zzh(this.zzbtu);
        this.zzbtu = null;
        zzh(this.zzbtv);
        this.zzbtv = null;
    }

    public void onConnectedNodes(List<NodeParcelable> connectedNodes) {
        if (this.zzbtt != null) {
            this.zzbtt.zza(zzI(connectedNodes));
        }
    }

    public IntentFilter[] zzIO() {
        return this.zzbsT;
    }

    public String zzIP() {
        return this.zzbtw;
    }

    public void zza(AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
        if (this.zzbtp != null) {
            this.zzbtp.zza(zzb(amsEntityUpdateParcelable));
        }
    }

    public void zza(AncsNotificationParcelable ancsNotificationParcelable) {
        if (this.zzbtq != null) {
            this.zzbtq.zza(zzb(ancsNotificationParcelable));
        }
    }

    public void zza(CapabilityInfoParcelable capabilityInfoParcelable) {
        if (this.zzbtv != null) {
            this.zzbtv.zza(zzb(capabilityInfoParcelable));
        }
    }

    public void zza(ChannelEventParcelable channelEventParcelable) {
        if (this.zzbtu != null) {
            this.zzbtu.zza(zzb(channelEventParcelable));
        }
    }

    public void zza(MessageEventParcelable messageEventParcelable) {
        if (this.zzbbb != null) {
            this.zzbbb.zza(zzb(messageEventParcelable));
        }
    }

    public void zza(NodeParcelable nodeParcelable) {
        if (this.zzbts != null) {
            this.zzbts.zza(zzc(nodeParcelable));
        }
    }

    public void zzag(DataHolder dataHolder) {
        if (this.zzbtr != null) {
            this.zzbtr.zza(zzai(dataHolder));
        } else {
            dataHolder.close();
        }
    }

    public void zzb(NodeParcelable nodeParcelable) {
        if (this.zzbts != null) {
            this.zzbts.zza(zzd(nodeParcelable));
        }
    }
}
