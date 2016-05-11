package com.google.android.gms.nearby.sharing.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.nearby.sharing.internal.zzd.zza;

class zze extends zzj<zzd> {
    public zze(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzf com_google_android_gms_common_internal_zzf) {
        super(context, looper, 49, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzdJ(iBinder);
    }

    protected zzd zzdJ(IBinder iBinder) {
        return zza.zzdI(iBinder);
    }

    protected String zzgu() {
        return "com.google.android.gms.nearby.sharing.service.NearbySharingService.START";
    }

    protected String zzgv() {
        return "com.google.android.gms.nearby.sharing.internal.INearbySharingService";
    }
}
