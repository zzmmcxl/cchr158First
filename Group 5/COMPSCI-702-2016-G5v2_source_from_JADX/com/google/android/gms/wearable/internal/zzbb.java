package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import java.util.ArrayList;
import java.util.List;

public final class zzbb implements NodeApi {

    /* renamed from: com.google.android.gms.wearable.internal.zzbb.3 */
    static class C09113 implements zza<NodeListener> {
        final /* synthetic */ IntentFilter[] zzbrP;

        C09113(IntentFilter[] intentFilterArr) {
            this.zzbrP = intentFilterArr;
        }

        public void zza(zzbp com_google_android_gms_wearable_internal_zzbp, com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, NodeListener nodeListener, zzq<NodeListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_NodeApi_NodeListener) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, nodeListener, (zzq) com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_NodeApi_NodeListener, this.zzbrP);
        }
    }

    public static class zza implements GetConnectedNodesResult {
        private final Status zzUX;
        private final List<Node> zzbsW;

        public zza(Status status, List<Node> list) {
            this.zzUX = status;
            this.zzbsW = list;
        }

        public List<Node> getNodes() {
            return this.zzbsW;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    public static class zzb implements GetLocalNodeResult {
        private final Status zzUX;
        private final Node zzbsX;

        public zzb(Status status, Node node) {
            this.zzUX = status;
            this.zzbsX = node;
        }

        public Node getNode() {
            return this.zzbsX;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzbb.1 */
    class C11101 extends zzi<GetLocalNodeResult> {
        final /* synthetic */ zzbb zzbsU;

        C11101(zzbb com_google_android_gms_wearable_internal_zzbb, GoogleApiClient googleApiClient) {
            this.zzbsU = com_google_android_gms_wearable_internal_zzbb;
            super(googleApiClient);
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zzs(this);
        }

        protected GetLocalNodeResult zzbA(Status status) {
            return new zzb(status, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzbA(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzbb.2 */
    class C11112 extends zzi<GetConnectedNodesResult> {
        final /* synthetic */ zzbb zzbsU;

        C11112(zzbb com_google_android_gms_wearable_internal_zzbb, GoogleApiClient googleApiClient) {
            this.zzbsU = com_google_android_gms_wearable_internal_zzbb;
            super(googleApiClient);
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zzt(this);
        }

        protected GetConnectedNodesResult zzbB(Status status) {
            return new zza(status, new ArrayList());
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzbB(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzbb.4 */
    class C11124 extends zzi<Status> {
        final /* synthetic */ zzbb zzbsU;
        final /* synthetic */ NodeListener zzbsV;

        C11124(zzbb com_google_android_gms_wearable_internal_zzbb, GoogleApiClient googleApiClient, NodeListener nodeListener) {
            this.zzbsU = com_google_android_gms_wearable_internal_zzbb;
            this.zzbsV = nodeListener;
            super(googleApiClient);
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) this, this.zzbsV);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    private static zza<NodeListener> zza(IntentFilter[] intentFilterArr) {
        return new C09113(intentFilterArr);
    }

    public PendingResult<Status> addListener(GoogleApiClient client, NodeListener listener) {
        return zzb.zza(client, zza(new IntentFilter[]{zzbn.zzgM("com.google.android.gms.wearable.NODE_CHANGED")}), listener);
    }

    public PendingResult<GetConnectedNodesResult> getConnectedNodes(GoogleApiClient client) {
        return client.zza(new C11112(this, client));
    }

    public PendingResult<GetLocalNodeResult> getLocalNode(GoogleApiClient client) {
        return client.zza(new C11101(this, client));
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, NodeListener listener) {
        return client.zza(new C11124(this, client, listener));
    }
}
