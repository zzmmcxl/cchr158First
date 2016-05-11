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
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityApi.AddLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.RemoveLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.Map;
import java.util.Set;

public class zzj implements CapabilityApi {

    /* renamed from: com.google.android.gms.wearable.internal.zzj.5 */
    static class C09215 implements zza<CapabilityListener> {
        final /* synthetic */ IntentFilter[] zzbrP;

        C09215(IntentFilter[] intentFilterArr) {
            this.zzbrP = intentFilterArr;
        }

        public void zza(zzbp com_google_android_gms_wearable_internal_zzbp, com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, CapabilityListener capabilityListener, zzq<CapabilityListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_CapabilityApi_CapabilityListener) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, capabilityListener, (zzq) com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_CapabilityApi_CapabilityListener, this.zzbrP);
        }
    }

    private static class zzb implements CapabilityListener {
        final CapabilityListener zzbrQ;
        final String zzbrR;

        zzb(CapabilityListener capabilityListener, String str) {
            this.zzbrQ = capabilityListener;
            this.zzbrR = str;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            zzb com_google_android_gms_wearable_internal_zzj_zzb = (zzb) o;
            return this.zzbrQ.equals(com_google_android_gms_wearable_internal_zzj_zzb.zzbrQ) ? this.zzbrR.equals(com_google_android_gms_wearable_internal_zzj_zzb.zzbrR) : false;
        }

        public int hashCode() {
            return (this.zzbrQ.hashCode() * 31) + this.zzbrR.hashCode();
        }

        public void onCapabilityChanged(CapabilityInfo capabilityInfo) {
            this.zzbrQ.onCapabilityChanged(capabilityInfo);
        }
    }

    public static class zzc implements CapabilityInfo {
        private final String mName;
        private final Set<Node> zzbrS;

        public zzc(CapabilityInfo capabilityInfo) {
            this(capabilityInfo.getName(), capabilityInfo.getNodes());
        }

        public zzc(String str, Set<Node> set) {
            this.mName = str;
            this.zzbrS = set;
        }

        public String getName() {
            return this.mName;
        }

        public Set<Node> getNodes() {
            return this.zzbrS;
        }
    }

    public static class zza implements AddLocalCapabilityResult, RemoveLocalCapabilityResult {
        private final Status zzUX;

        public zza(Status status) {
            this.zzUX = status;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    public static class zzd implements GetAllCapabilitiesResult {
        private final Status zzUX;
        private final Map<String, CapabilityInfo> zzbrT;

        public zzd(Status status, Map<String, CapabilityInfo> map) {
            this.zzUX = status;
            this.zzbrT = map;
        }

        public Map<String, CapabilityInfo> getAllCapabilities() {
            return this.zzbrT;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    public static class zze implements GetCapabilityResult {
        private final Status zzUX;
        private final CapabilityInfo zzbrU;

        public zze(Status status, CapabilityInfo capabilityInfo) {
            this.zzUX = status;
            this.zzbrU = capabilityInfo;
        }

        public CapabilityInfo getCapability() {
            return this.zzbrU;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzj.1 */
    class C11131 extends zzi<GetCapabilityResult> {
        final /* synthetic */ String zzbrM;
        final /* synthetic */ int zzbrN;
        final /* synthetic */ zzj zzbrO;

        C11131(zzj com_google_android_gms_wearable_internal_zzj, GoogleApiClient googleApiClient, String str, int i) {
            this.zzbrO = com_google_android_gms_wearable_internal_zzj;
            this.zzbrM = str;
            this.zzbrN = i;
            super(googleApiClient);
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zzg(this, this.zzbrM, this.zzbrN);
        }

        protected GetCapabilityResult zzbo(Status status) {
            return new zze(status, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzbo(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzj.2 */
    class C11142 extends zzi<GetAllCapabilitiesResult> {
        final /* synthetic */ int zzbrN;
        final /* synthetic */ zzj zzbrO;

        C11142(zzj com_google_android_gms_wearable_internal_zzj, GoogleApiClient googleApiClient, int i) {
            this.zzbrO = com_google_android_gms_wearable_internal_zzj;
            this.zzbrN = i;
            super(googleApiClient);
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zzb(this, this.zzbrN);
        }

        protected GetAllCapabilitiesResult zzbp(Status status) {
            return new zzd(status, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzbp(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzj.3 */
    class C11153 extends zzi<AddLocalCapabilityResult> {
        final /* synthetic */ String zzbrM;
        final /* synthetic */ zzj zzbrO;

        C11153(zzj com_google_android_gms_wearable_internal_zzj, GoogleApiClient googleApiClient, String str) {
            this.zzbrO = com_google_android_gms_wearable_internal_zzj;
            this.zzbrM = str;
            super(googleApiClient);
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zzr(this, this.zzbrM);
        }

        protected AddLocalCapabilityResult zzbq(Status status) {
            return new zza(status);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzbq(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzj.4 */
    class C11164 extends zzi<RemoveLocalCapabilityResult> {
        final /* synthetic */ String zzbrM;
        final /* synthetic */ zzj zzbrO;

        C11164(zzj com_google_android_gms_wearable_internal_zzj, GoogleApiClient googleApiClient, String str) {
            this.zzbrO = com_google_android_gms_wearable_internal_zzj;
            this.zzbrM = str;
            super(googleApiClient);
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zzs(this, this.zzbrM);
        }

        protected RemoveLocalCapabilityResult zzbr(Status status) {
            return new zza(status);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzbr(status);
        }
    }

    private static final class zzf extends zzi<Status> {
        private CapabilityListener zzbrQ;

        private zzf(GoogleApiClient googleApiClient, CapabilityListener capabilityListener) {
            super(googleApiClient);
            this.zzbrQ = capabilityListener;
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) this, this.zzbrQ);
            this.zzbrQ = null;
        }

        public Status zzb(Status status) {
            this.zzbrQ = null;
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, CapabilityListener capabilityListener, IntentFilter[] intentFilterArr) {
        return zzb.zza(googleApiClient, zza(intentFilterArr), capabilityListener);
    }

    private static zza<CapabilityListener> zza(IntentFilter[] intentFilterArr) {
        return new C09215(intentFilterArr);
    }

    public PendingResult<Status> addCapabilityListener(GoogleApiClient client, CapabilityListener listener, String capability) {
        zzx.zzb(capability != null, (Object) "capability must not be null");
        CapabilityListener com_google_android_gms_wearable_internal_zzj_zzb = new zzb(listener, capability);
        IntentFilter zzgM = zzbn.zzgM(CapabilityApi.ACTION_CAPABILITY_CHANGED);
        if (!capability.startsWith("/")) {
            capability = "/" + capability;
        }
        zzgM.addDataPath(capability, 0);
        return zza(client, com_google_android_gms_wearable_internal_zzj_zzb, new IntentFilter[]{zzgM});
    }

    public PendingResult<Status> addListener(GoogleApiClient client, CapabilityListener listener, Uri uri, int filterType) {
        zzx.zzb(uri != null, (Object) "uri must not be null");
        boolean z = filterType == 0 || filterType == 1;
        zzx.zzb(z, (Object) "invalid filter type");
        return zza(client, listener, new IntentFilter[]{zzbn.zza(CapabilityApi.ACTION_CAPABILITY_CHANGED, uri, filterType)});
    }

    public PendingResult<AddLocalCapabilityResult> addLocalCapability(GoogleApiClient client, String capability) {
        return client.zza(new C11153(this, client, capability));
    }

    public PendingResult<GetAllCapabilitiesResult> getAllCapabilities(GoogleApiClient client, int nodeFilter) {
        boolean z = true;
        if (!(nodeFilter == 0 || nodeFilter == 1)) {
            z = false;
        }
        zzx.zzac(z);
        return client.zza(new C11142(this, client, nodeFilter));
    }

    public PendingResult<GetCapabilityResult> getCapability(GoogleApiClient client, String capability, int nodeFilter) {
        boolean z = true;
        if (!(nodeFilter == 0 || nodeFilter == 1)) {
            z = false;
        }
        zzx.zzac(z);
        return client.zza(new C11131(this, client, capability, nodeFilter));
    }

    public PendingResult<Status> removeCapabilityListener(GoogleApiClient client, CapabilityListener listener, String capability) {
        return client.zza(new zzf(new zzb(listener, capability), null));
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, CapabilityListener listener) {
        return client.zza(new zzf(listener, null));
    }

    public PendingResult<RemoveLocalCapabilityResult> removeLocalCapability(GoogleApiClient client, String capability) {
        return client.zza(new C11164(this, client, capability));
    }
}
