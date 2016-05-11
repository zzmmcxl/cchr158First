package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpn;

public final class Address {
    public static final Api<AddressOptions> API;
    static final zzc<zzpn> zzUI;
    private static final com.google.android.gms.common.api.Api.zza<zzpn, AddressOptions> zzUJ;

    /* renamed from: com.google.android.gms.identity.intents.Address.1 */
    static class C07771 extends com.google.android.gms.common.api.Api.zza<zzpn, AddressOptions> {
        C07771() {
        }

        public zzpn zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, AddressOptions addressOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            zzx.zzb(context instanceof Activity, (Object) "An Activity must be used for Address APIs");
            if (addressOptions == null) {
                addressOptions = new AddressOptions();
            }
            return new zzpn((Activity) context, looper, com_google_android_gms_common_internal_zzf, addressOptions.theme, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public static final class AddressOptions implements HasOptions {
        public final int theme;

        public AddressOptions() {
            this.theme = 0;
        }

        public AddressOptions(int theme) {
            this.theme = theme;
        }
    }

    private static abstract class zza extends com.google.android.gms.common.api.internal.zza.zza<Status, zzpn> {
        public zza(GoogleApiClient googleApiClient) {
            super(Address.zzUI, googleApiClient);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.identity.intents.Address.2 */
    static class C10782 extends zza {
        final /* synthetic */ int val$requestCode;
        final /* synthetic */ UserAddressRequest zzaMz;

        C10782(GoogleApiClient googleApiClient, UserAddressRequest userAddressRequest, int i) {
            this.zzaMz = userAddressRequest;
            this.val$requestCode = i;
            super(googleApiClient);
        }

        protected void zza(zzpn com_google_android_gms_internal_zzpn) throws RemoteException {
            com_google_android_gms_internal_zzpn.zza(this.zzaMz, this.val$requestCode);
            zza(Status.zzagC);
        }
    }

    static {
        zzUI = new zzc();
        zzUJ = new C07771();
        API = new Api("Address.API", zzUJ, zzUI);
    }

    public static void requestUserAddress(GoogleApiClient googleApiClient, UserAddressRequest request, int requestCode) {
        googleApiClient.zza(new C10782(googleApiClient, request, requestCode));
    }
}
