package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ChannelImpl implements SafeParcelable, Channel {
    public static final Creator<ChannelImpl> CREATOR;
    private final String mPath;
    final int mVersionCode;
    private final String zzVo;
    private final String zzbrb;

    /* renamed from: com.google.android.gms.wearable.internal.ChannelImpl.7 */
    static class C09107 implements zza<ChannelListener> {
        final /* synthetic */ String zzVj;
        final /* synthetic */ IntentFilter[] zzbrP;

        C09107(String str, IntentFilter[] intentFilterArr) {
            this.zzVj = str;
            this.zzbrP = intentFilterArr;
        }

        public void zza(zzbp com_google_android_gms_wearable_internal_zzbp, com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, ChannelListener channelListener, zzq<ChannelListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_ChannelApi_ChannelListener) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, channelListener, (zzq) com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_ChannelApi_ChannelListener, this.zzVj, this.zzbrP);
        }
    }

    static final class zza implements GetInputStreamResult {
        private final Status zzUX;
        private final InputStream zzbsh;

        zza(Status status, InputStream inputStream) {
            this.zzUX = (Status) zzx.zzz(status);
            this.zzbsh = inputStream;
        }

        public InputStream getInputStream() {
            return this.zzbsh;
        }

        public Status getStatus() {
            return this.zzUX;
        }

        public void release() {
            if (this.zzbsh != null) {
                try {
                    this.zzbsh.close();
                } catch (IOException e) {
                }
            }
        }
    }

    static final class zzb implements GetOutputStreamResult {
        private final Status zzUX;
        private final OutputStream zzbsi;

        zzb(Status status, OutputStream outputStream) {
            this.zzUX = (Status) zzx.zzz(status);
            this.zzbsi = outputStream;
        }

        public OutputStream getOutputStream() {
            return this.zzbsi;
        }

        public Status getStatus() {
            return this.zzUX;
        }

        public void release() {
            if (this.zzbsi != null) {
                try {
                    this.zzbsi.close();
                } catch (IOException e) {
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ChannelImpl.1 */
    class C11021 extends zzi<Status> {
        final /* synthetic */ ChannelImpl zzbsd;

        C11021(ChannelImpl channelImpl, GoogleApiClient googleApiClient) {
            this.zzbsd = channelImpl;
            super(googleApiClient);
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zzt(this, this.zzbsd.zzVo);
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ChannelImpl.2 */
    class C11032 extends zzi<Status> {
        final /* synthetic */ int zzAe;
        final /* synthetic */ ChannelImpl zzbsd;

        C11032(ChannelImpl channelImpl, GoogleApiClient googleApiClient, int i) {
            this.zzbsd = channelImpl;
            this.zzAe = i;
            super(googleApiClient);
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zzh(this, this.zzbsd.zzVo, this.zzAe);
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ChannelImpl.3 */
    class C11043 extends zzi<GetInputStreamResult> {
        final /* synthetic */ ChannelImpl zzbsd;

        C11043(ChannelImpl channelImpl, GoogleApiClient googleApiClient) {
            this.zzbsd = channelImpl;
            super(googleApiClient);
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zzu(this, this.zzbsd.zzVo);
        }

        public GetInputStreamResult zzbt(Status status) {
            return new zza(status, null);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbt(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ChannelImpl.4 */
    class C11054 extends zzi<GetOutputStreamResult> {
        final /* synthetic */ ChannelImpl zzbsd;

        C11054(ChannelImpl channelImpl, GoogleApiClient googleApiClient) {
            this.zzbsd = channelImpl;
            super(googleApiClient);
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zzv(this, this.zzbsd.zzVo);
        }

        public GetOutputStreamResult zzbu(Status status) {
            return new zzb(status, null);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbu(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ChannelImpl.5 */
    class C11065 extends zzi<Status> {
        final /* synthetic */ Uri zzbds;
        final /* synthetic */ ChannelImpl zzbsd;
        final /* synthetic */ boolean zzbse;

        C11065(ChannelImpl channelImpl, GoogleApiClient googleApiClient, Uri uri, boolean z) {
            this.zzbsd = channelImpl;
            this.zzbds = uri;
            this.zzbse = z;
            super(googleApiClient);
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) this, this.zzbsd.zzVo, this.zzbds, this.zzbse);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ChannelImpl.6 */
    class C11076 extends zzi<Status> {
        final /* synthetic */ Uri zzbds;
        final /* synthetic */ ChannelImpl zzbsd;
        final /* synthetic */ long zzbsf;
        final /* synthetic */ long zzbsg;

        C11076(ChannelImpl channelImpl, GoogleApiClient googleApiClient, Uri uri, long j, long j2) {
            this.zzbsd = channelImpl;
            this.zzbds = uri;
            this.zzbsf = j;
            this.zzbsg = j2;
            super(googleApiClient);
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) this, this.zzbsd.zzVo, this.zzbds, this.zzbsf, this.zzbsg);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    static {
        CREATOR = new zzo();
    }

    ChannelImpl(int versionCode, String token, String nodeId, String path) {
        this.mVersionCode = versionCode;
        this.zzVo = (String) zzx.zzz(token);
        this.zzbrb = (String) zzx.zzz(nodeId);
        this.mPath = (String) zzx.zzz(path);
    }

    private static zza<ChannelListener> zza(String str, IntentFilter[] intentFilterArr) {
        return new C09107(str, intentFilterArr);
    }

    public PendingResult<Status> addListener(GoogleApiClient client, ChannelListener listener) {
        return zzb.zza(client, zza(this.zzVo, new IntentFilter[]{zzbn.zzgM(ChannelApi.ACTION_CHANNEL_EVENT)}), listener);
    }

    public PendingResult<Status> close(GoogleApiClient client) {
        return client.zza(new C11021(this, client));
    }

    public PendingResult<Status> close(GoogleApiClient client, int errorCode) {
        return client.zza(new C11032(this, client, errorCode));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ChannelImpl)) {
            return false;
        }
        ChannelImpl channelImpl = (ChannelImpl) other;
        return this.zzVo.equals(channelImpl.zzVo) && zzw.equal(channelImpl.zzbrb, this.zzbrb) && zzw.equal(channelImpl.mPath, this.mPath) && channelImpl.mVersionCode == this.mVersionCode;
    }

    public PendingResult<GetInputStreamResult> getInputStream(GoogleApiClient client) {
        return client.zza(new C11043(this, client));
    }

    public String getNodeId() {
        return this.zzbrb;
    }

    public PendingResult<GetOutputStreamResult> getOutputStream(GoogleApiClient client) {
        return client.zza(new C11054(this, client));
    }

    public String getPath() {
        return this.mPath;
    }

    public String getToken() {
        return this.zzVo;
    }

    public int hashCode() {
        return this.zzVo.hashCode();
    }

    public PendingResult<Status> receiveFile(GoogleApiClient client, Uri uri, boolean append) {
        zzx.zzb((Object) client, (Object) "client is null");
        zzx.zzb((Object) uri, (Object) "uri is null");
        return client.zza(new C11065(this, client, uri, append));
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, ChannelListener listener) {
        zzx.zzb((Object) client, (Object) "client is null");
        zzx.zzb((Object) listener, (Object) "listener is null");
        return client.zza(new zzb(client, listener, this.zzVo));
    }

    public PendingResult<Status> sendFile(GoogleApiClient client, Uri uri) {
        return sendFile(client, uri, 0, -1);
    }

    public PendingResult<Status> sendFile(GoogleApiClient client, Uri uri, long startOffset, long length) {
        zzx.zzb((Object) client, (Object) "client is null");
        zzx.zzb(this.zzVo, (Object) "token is null");
        zzx.zzb((Object) uri, (Object) "uri is null");
        zzx.zzb(startOffset >= 0, "startOffset is negative: %s", Long.valueOf(startOffset));
        boolean z = length >= 0 || length == -1;
        zzx.zzb(z, "invalid length: %s", Long.valueOf(length));
        return client.zza(new C11076(this, client, uri, startOffset, length));
    }

    public String toString() {
        return "ChannelImpl{versionCode=" + this.mVersionCode + ", token='" + this.zzVo + '\'' + ", nodeId='" + this.zzbrb + '\'' + ", path='" + this.mPath + '\'' + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzo.zza(this, dest, flags);
    }
}
