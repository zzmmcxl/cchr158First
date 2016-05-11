package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.IOException;
import java.io.InputStream;

public final class zzx implements DataApi {

    /* renamed from: com.google.android.gms.wearable.internal.zzx.8 */
    static class C09258 implements zza<DataListener> {
        final /* synthetic */ IntentFilter[] zzbrP;

        C09258(IntentFilter[] intentFilterArr) {
            this.zzbrP = intentFilterArr;
        }

        public void zza(zzbp com_google_android_gms_wearable_internal_zzbp, com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, DataListener dataListener, zzq<DataListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_DataApi_DataListener) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, dataListener, (zzq) com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_DataApi_DataListener, this.zzbrP);
        }
    }

    public static class zza implements DataItemResult {
        private final Status zzUX;
        private final DataItem zzbsv;

        public zza(Status status, DataItem dataItem) {
            this.zzUX = status;
            this.zzbsv = dataItem;
        }

        public DataItem getDataItem() {
            return this.zzbsv;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    public static class zzb implements DeleteDataItemsResult {
        private final Status zzUX;
        private final int zzbsw;

        public zzb(Status status, int i) {
            this.zzUX = status;
            this.zzbsw = i;
        }

        public int getNumDeleted() {
            return this.zzbsw;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    public static class zzc implements GetFdForAssetResult {
        private volatile boolean mClosed;
        private final Status zzUX;
        private volatile InputStream zzbsh;
        private volatile ParcelFileDescriptor zzbsx;

        public zzc(Status status, ParcelFileDescriptor parcelFileDescriptor) {
            this.mClosed = false;
            this.zzUX = status;
            this.zzbsx = parcelFileDescriptor;
        }

        public ParcelFileDescriptor getFd() {
            if (!this.mClosed) {
                return this.zzbsx;
            }
            throw new IllegalStateException("Cannot access the file descriptor after release().");
        }

        public InputStream getInputStream() {
            if (this.mClosed) {
                throw new IllegalStateException("Cannot access the input stream after release().");
            } else if (this.zzbsx == null) {
                return null;
            } else {
                if (this.zzbsh == null) {
                    this.zzbsh = new AutoCloseInputStream(this.zzbsx);
                }
                return this.zzbsh;
            }
        }

        public Status getStatus() {
            return this.zzUX;
        }

        public void release() {
            if (this.zzbsx != null) {
                if (this.mClosed) {
                    throw new IllegalStateException("releasing an already released result.");
                }
                try {
                    if (this.zzbsh != null) {
                        this.zzbsh.close();
                    } else {
                        this.zzbsx.close();
                    }
                    this.mClosed = true;
                    this.zzbsx = null;
                    this.zzbsh = null;
                } catch (IOException e) {
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzx.1 */
    class C11181 extends zzi<DataItemResult> {
        final /* synthetic */ PutDataRequest zzbsp;
        final /* synthetic */ zzx zzbsq;

        C11181(zzx com_google_android_gms_wearable_internal_zzx, GoogleApiClient googleApiClient, PutDataRequest putDataRequest) {
            this.zzbsq = com_google_android_gms_wearable_internal_zzx;
            this.zzbsp = putDataRequest;
            super(googleApiClient);
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) this, this.zzbsp);
        }

        public DataItemResult zzbv(Status status) {
            return new zza(status, null);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbv(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzx.2 */
    class C11192 extends zzi<DataItemResult> {
        final /* synthetic */ Uri zzbds;
        final /* synthetic */ zzx zzbsq;

        C11192(zzx com_google_android_gms_wearable_internal_zzx, GoogleApiClient googleApiClient, Uri uri) {
            this.zzbsq = com_google_android_gms_wearable_internal_zzx;
            this.zzbds = uri;
            super(googleApiClient);
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) this, this.zzbds);
        }

        protected DataItemResult zzbv(Status status) {
            return new zza(status, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzbv(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzx.3 */
    class C11203 extends zzi<DataItemBuffer> {
        final /* synthetic */ zzx zzbsq;

        C11203(zzx com_google_android_gms_wearable_internal_zzx, GoogleApiClient googleApiClient) {
            this.zzbsq = com_google_android_gms_wearable_internal_zzx;
            super(googleApiClient);
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zzr(this);
        }

        protected DataItemBuffer zzbw(Status status) {
            return new DataItemBuffer(DataHolder.zzbI(status.getStatusCode()));
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzbw(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzx.4 */
    class C11214 extends zzi<DataItemBuffer> {
        final /* synthetic */ Uri zzbds;
        final /* synthetic */ zzx zzbsq;
        final /* synthetic */ int zzbsr;

        C11214(zzx com_google_android_gms_wearable_internal_zzx, GoogleApiClient googleApiClient, Uri uri, int i) {
            this.zzbsq = com_google_android_gms_wearable_internal_zzx;
            this.zzbds = uri;
            this.zzbsr = i;
            super(googleApiClient);
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) this, this.zzbds, this.zzbsr);
        }

        protected DataItemBuffer zzbw(Status status) {
            return new DataItemBuffer(DataHolder.zzbI(status.getStatusCode()));
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzbw(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzx.5 */
    class C11225 extends zzi<DeleteDataItemsResult> {
        final /* synthetic */ Uri zzbds;
        final /* synthetic */ zzx zzbsq;
        final /* synthetic */ int zzbsr;

        C11225(zzx com_google_android_gms_wearable_internal_zzx, GoogleApiClient googleApiClient, Uri uri, int i) {
            this.zzbsq = com_google_android_gms_wearable_internal_zzx;
            this.zzbds = uri;
            this.zzbsr = i;
            super(googleApiClient);
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zzb(this, this.zzbds, this.zzbsr);
        }

        protected DeleteDataItemsResult zzbx(Status status) {
            return new zzb(status, 0);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzbx(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzx.6 */
    class C11236 extends zzi<GetFdForAssetResult> {
        final /* synthetic */ zzx zzbsq;
        final /* synthetic */ Asset zzbss;

        C11236(zzx com_google_android_gms_wearable_internal_zzx, GoogleApiClient googleApiClient, Asset asset) {
            this.zzbsq = com_google_android_gms_wearable_internal_zzx;
            this.zzbss = asset;
            super(googleApiClient);
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) this, this.zzbss);
        }

        protected GetFdForAssetResult zzby(Status status) {
            return new zzc(status, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzby(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzx.7 */
    class C11247 extends zzi<GetFdForAssetResult> {
        final /* synthetic */ zzx zzbsq;
        final /* synthetic */ DataItemAsset zzbst;

        C11247(zzx com_google_android_gms_wearable_internal_zzx, GoogleApiClient googleApiClient, DataItemAsset dataItemAsset) {
            this.zzbsq = com_google_android_gms_wearable_internal_zzx;
            this.zzbst = dataItemAsset;
            super(googleApiClient);
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) this, this.zzbst);
        }

        protected GetFdForAssetResult zzby(Status status) {
            return new zzc(status, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzby(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzx.9 */
    class C11259 extends zzi<Status> {
        final /* synthetic */ zzx zzbsq;
        final /* synthetic */ DataListener zzbsu;

        C11259(zzx com_google_android_gms_wearable_internal_zzx, GoogleApiClient googleApiClient, DataListener dataListener) {
            this.zzbsq = com_google_android_gms_wearable_internal_zzx;
            this.zzbsu = dataListener;
            super(googleApiClient);
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) this, this.zzbsu);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, DataListener dataListener, IntentFilter[] intentFilterArr) {
        return zzb.zza(googleApiClient, zza(intentFilterArr), dataListener);
    }

    private static zza<DataListener> zza(IntentFilter[] intentFilterArr) {
        return new C09258(intentFilterArr);
    }

    private void zza(Asset asset) {
        if (asset == null) {
            throw new IllegalArgumentException("asset is null");
        } else if (asset.getDigest() == null) {
            throw new IllegalArgumentException("invalid asset");
        } else if (asset.getData() != null) {
            throw new IllegalArgumentException("invalid asset");
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient client, DataListener listener) {
        return zza(client, listener, new IntentFilter[]{zzbn.zzgM(DataApi.ACTION_DATA_CHANGED)});
    }

    public PendingResult<Status> addListener(GoogleApiClient client, DataListener listener, Uri uri, int filterType) {
        com.google.android.gms.common.internal.zzx.zzb(uri != null, (Object) "uri must not be null");
        boolean z = filterType == 0 || filterType == 1;
        com.google.android.gms.common.internal.zzx.zzb(z, (Object) "invalid filter type");
        return zza(client, listener, new IntentFilter[]{zzbn.zza(DataApi.ACTION_DATA_CHANGED, uri, filterType)});
    }

    public PendingResult<DeleteDataItemsResult> deleteDataItems(GoogleApiClient client, Uri uri) {
        return deleteDataItems(client, uri, 0);
    }

    public PendingResult<DeleteDataItemsResult> deleteDataItems(GoogleApiClient client, Uri uri, int filterType) {
        boolean z = false;
        com.google.android.gms.common.internal.zzx.zzb(uri != null, (Object) "uri must not be null");
        if (filterType == 0 || filterType == 1) {
            z = true;
        }
        com.google.android.gms.common.internal.zzx.zzb(z, (Object) "invalid filter type");
        return client.zza(new C11225(this, client, uri, filterType));
    }

    public PendingResult<DataItemResult> getDataItem(GoogleApiClient client, Uri uri) {
        return client.zza(new C11192(this, client, uri));
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client) {
        return client.zza(new C11203(this, client));
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client, Uri uri) {
        return getDataItems(client, uri, 0);
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client, Uri uri, int filterType) {
        boolean z = false;
        com.google.android.gms.common.internal.zzx.zzb(uri != null, (Object) "uri must not be null");
        if (filterType == 0 || filterType == 1) {
            z = true;
        }
        com.google.android.gms.common.internal.zzx.zzb(z, (Object) "invalid filter type");
        return client.zza(new C11214(this, client, uri, filterType));
    }

    public PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient client, Asset asset) {
        zza(asset);
        return client.zza(new C11236(this, client, asset));
    }

    public PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient client, DataItemAsset asset) {
        return client.zza(new C11247(this, client, asset));
    }

    public PendingResult<DataItemResult> putDataItem(GoogleApiClient client, PutDataRequest request) {
        return client.zza(new C11181(this, client, request));
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, DataListener listener) {
        return client.zza(new C11259(this, client, listener));
    }
}
