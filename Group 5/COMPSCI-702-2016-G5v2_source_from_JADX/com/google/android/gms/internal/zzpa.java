package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.ClaimBleDeviceRequest;
import com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.StopBleScanRequest;
import com.google.android.gms.fitness.request.UnclaimBleDeviceRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;

public class zzpa implements BleApi {

    private static class zza extends com.google.android.gms.internal.zzpj.zza {
        private final zzb<BleDevicesResult> zzamC;

        private zza(zzb<BleDevicesResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_BleDevicesResult) {
            this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_BleDevicesResult;
        }

        public void zza(BleDevicesResult bleDevicesResult) {
            this.zzamC.zzs(bleDevicesResult);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpa.6 */
    class C10826 extends zza<BleDevicesResult> {
        final /* synthetic */ zzpa zzazN;

        C10826(zzpa com_google_android_gms_internal_zzpa, GoogleApiClient googleApiClient) {
            this.zzazN = com_google_android_gms_internal_zzpa;
            super(googleApiClient);
        }

        protected BleDevicesResult zzI(Status status) {
            return BleDevicesResult.zzQ(status);
        }

        protected void zza(zznz com_google_android_gms_internal_zznz) throws RemoteException {
            ((zzok) com_google_android_gms_internal_zznz.zzqJ()).zza(new ListClaimedBleDevicesRequest(new zza(null)));
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzI(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpa.1 */
    class C12461 extends zzc {
        final /* synthetic */ StartBleScanRequest zzazM;
        final /* synthetic */ zzpa zzazN;

        C12461(zzpa com_google_android_gms_internal_zzpa, GoogleApiClient googleApiClient, StartBleScanRequest startBleScanRequest) {
            this.zzazN = com_google_android_gms_internal_zzpa;
            this.zzazM = startBleScanRequest;
            super(googleApiClient);
        }

        protected void zza(zznz com_google_android_gms_internal_zznz) throws RemoteException {
            ((zzok) com_google_android_gms_internal_zznz.zzqJ()).zza(new StartBleScanRequest(this.zzazM, new zzph(this)));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpa.2 */
    class C12472 extends zzc {
        final /* synthetic */ zzpa zzazN;
        final /* synthetic */ BleScanCallback zzazO;

        C12472(zzpa com_google_android_gms_internal_zzpa, GoogleApiClient googleApiClient, BleScanCallback bleScanCallback) {
            this.zzazN = com_google_android_gms_internal_zzpa;
            this.zzazO = bleScanCallback;
            super(googleApiClient);
        }

        protected void zza(zznz com_google_android_gms_internal_zznz) throws RemoteException {
            ((zzok) com_google_android_gms_internal_zznz.zzqJ()).zza(new StopBleScanRequest(this.zzazO, new zzph(this)));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpa.3 */
    class C12483 extends zzc {
        final /* synthetic */ zzpa zzazN;
        final /* synthetic */ String zzazP;

        C12483(zzpa com_google_android_gms_internal_zzpa, GoogleApiClient googleApiClient, String str) {
            this.zzazN = com_google_android_gms_internal_zzpa;
            this.zzazP = str;
            super(googleApiClient);
        }

        protected void zza(zznz com_google_android_gms_internal_zznz) throws RemoteException {
            ((zzok) com_google_android_gms_internal_zznz.zzqJ()).zza(new ClaimBleDeviceRequest(this.zzazP, null, new zzph(this)));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpa.4 */
    class C12494 extends zzc {
        final /* synthetic */ zzpa zzazN;
        final /* synthetic */ BleDevice zzazQ;

        C12494(zzpa com_google_android_gms_internal_zzpa, GoogleApiClient googleApiClient, BleDevice bleDevice) {
            this.zzazN = com_google_android_gms_internal_zzpa;
            this.zzazQ = bleDevice;
            super(googleApiClient);
        }

        protected void zza(zznz com_google_android_gms_internal_zznz) throws RemoteException {
            ((zzok) com_google_android_gms_internal_zznz.zzqJ()).zza(new ClaimBleDeviceRequest(this.zzazQ.getAddress(), this.zzazQ, new zzph(this)));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpa.5 */
    class C12505 extends zzc {
        final /* synthetic */ zzpa zzazN;
        final /* synthetic */ String zzazP;

        C12505(zzpa com_google_android_gms_internal_zzpa, GoogleApiClient googleApiClient, String str) {
            this.zzazN = com_google_android_gms_internal_zzpa;
            this.zzazP = str;
            super(googleApiClient);
        }

        protected void zza(zznz com_google_android_gms_internal_zznz) throws RemoteException {
            ((zzok) com_google_android_gms_internal_zznz.zzqJ()).zza(new UnclaimBleDeviceRequest(this.zzazP, new zzph(this)));
        }
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, BleDevice bleDevice) {
        return client.zzb(new C12494(this, client, bleDevice));
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, String deviceAddress) {
        return client.zzb(new C12483(this, client, deviceAddress));
    }

    public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient client) {
        return client.zza(new C10826(this, client));
    }

    public PendingResult<Status> startBleScan(GoogleApiClient client, StartBleScanRequest request) {
        return client.zza(new C12461(this, client, request));
    }

    public PendingResult<Status> stopBleScan(GoogleApiClient client, BleScanCallback requestCallback) {
        return client.zza(new C12472(this, client, requestCallback));
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, BleDevice bleDevice) {
        return unclaimBleDevice(client, bleDevice.getAddress());
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, String deviceAddress) {
        return client.zzb(new C12505(this, client, deviceAddress));
    }
}
