package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class zzd implements FusedLocationProviderApi {

    private static class zzb extends com.google.android.gms.location.internal.zzg.zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<Status> zzamC;

        public zzb(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status) {
            this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status;
        }

        public void zza(FusedLocationProviderResult fusedLocationProviderResult) {
            this.zzamC.zzs(fusedLocationProviderResult.getStatus());
        }
    }

    private static abstract class zza extends com.google.android.gms.location.LocationServices.zza<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.10 */
    class AnonymousClass10 extends zza {
        final /* synthetic */ PendingIntent zzaOq;
        final /* synthetic */ zzd zzaOx;

        AnonymousClass10(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
            this.zzaOx = com_google_android_gms_location_internal_zzd;
            this.zzaOq = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzl com_google_android_gms_location_internal_zzl) throws RemoteException {
            com_google_android_gms_location_internal_zzl.zza(this.zzaOq, new zzb(this));
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.1 */
    class C12911 extends zza {
        final /* synthetic */ LocationRequest zzaOv;
        final /* synthetic */ LocationListener zzaOw;
        final /* synthetic */ zzd zzaOx;

        C12911(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
            this.zzaOx = com_google_android_gms_location_internal_zzd;
            this.zzaOv = locationRequest;
            this.zzaOw = locationListener;
            super(googleApiClient);
        }

        protected void zza(zzl com_google_android_gms_location_internal_zzl) throws RemoteException {
            com_google_android_gms_location_internal_zzl.zza(this.zzaOv, this.zzaOw, null, new zzb(this));
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.2 */
    class C12922 extends zza {
        final /* synthetic */ zzd zzaOx;
        final /* synthetic */ LocationCallback zzaOy;

        C12922(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, LocationCallback locationCallback) {
            this.zzaOx = com_google_android_gms_location_internal_zzd;
            this.zzaOy = locationCallback;
            super(googleApiClient);
        }

        protected void zza(zzl com_google_android_gms_location_internal_zzl) throws RemoteException {
            com_google_android_gms_location_internal_zzl.zza(this.zzaOy, new zzb(this));
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.3 */
    class C12933 extends zza {
        final /* synthetic */ zzd zzaOx;
        final /* synthetic */ boolean zzaOz;

        C12933(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, boolean z) {
            this.zzaOx = com_google_android_gms_location_internal_zzd;
            this.zzaOz = z;
            super(googleApiClient);
        }

        protected void zza(zzl com_google_android_gms_location_internal_zzl) throws RemoteException {
            com_google_android_gms_location_internal_zzl.zzam(this.zzaOz);
            zza(Status.zzagC);
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.4 */
    class C12944 extends zza {
        final /* synthetic */ Location zzaOA;
        final /* synthetic */ zzd zzaOx;

        C12944(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, Location location) {
            this.zzaOx = com_google_android_gms_location_internal_zzd;
            this.zzaOA = location;
            super(googleApiClient);
        }

        protected void zza(zzl com_google_android_gms_location_internal_zzl) throws RemoteException {
            com_google_android_gms_location_internal_zzl.zzc(this.zzaOA);
            zza(Status.zzagC);
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.5 */
    class C12955 extends zza {
        final /* synthetic */ zzd zzaOx;

        C12955(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient) {
            this.zzaOx = com_google_android_gms_location_internal_zzd;
            super(googleApiClient);
        }

        protected void zza(zzl com_google_android_gms_location_internal_zzl) throws RemoteException {
            com_google_android_gms_location_internal_zzl.zza(new zzb(this));
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.6 */
    class C12966 extends zza {
        final /* synthetic */ Looper zzaOB;
        final /* synthetic */ LocationRequest zzaOv;
        final /* synthetic */ LocationListener zzaOw;
        final /* synthetic */ zzd zzaOx;

        C12966(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener, Looper looper) {
            this.zzaOx = com_google_android_gms_location_internal_zzd;
            this.zzaOv = locationRequest;
            this.zzaOw = locationListener;
            this.zzaOB = looper;
            super(googleApiClient);
        }

        protected void zza(zzl com_google_android_gms_location_internal_zzl) throws RemoteException {
            com_google_android_gms_location_internal_zzl.zza(this.zzaOv, this.zzaOw, this.zzaOB, new zzb(this));
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.7 */
    class C12977 extends zza {
        final /* synthetic */ Looper zzaOB;
        final /* synthetic */ LocationRequest zzaOv;
        final /* synthetic */ zzd zzaOx;
        final /* synthetic */ LocationCallback zzaOy;

        C12977(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
            this.zzaOx = com_google_android_gms_location_internal_zzd;
            this.zzaOv = locationRequest;
            this.zzaOy = locationCallback;
            this.zzaOB = looper;
            super(googleApiClient);
        }

        protected void zza(zzl com_google_android_gms_location_internal_zzl) throws RemoteException {
            com_google_android_gms_location_internal_zzl.zza(LocationRequestInternal.zzb(this.zzaOv), this.zzaOy, this.zzaOB, new zzb(this));
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.8 */
    class C12988 extends zza {
        final /* synthetic */ PendingIntent zzaOq;
        final /* synthetic */ LocationRequest zzaOv;
        final /* synthetic */ zzd zzaOx;

        C12988(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
            this.zzaOx = com_google_android_gms_location_internal_zzd;
            this.zzaOv = locationRequest;
            this.zzaOq = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzl com_google_android_gms_location_internal_zzl) throws RemoteException {
            com_google_android_gms_location_internal_zzl.zza(this.zzaOv, this.zzaOq, new zzb(this));
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.9 */
    class C12999 extends zza {
        final /* synthetic */ LocationListener zzaOw;
        final /* synthetic */ zzd zzaOx;

        C12999(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, LocationListener locationListener) {
            this.zzaOx = com_google_android_gms_location_internal_zzd;
            this.zzaOw = locationListener;
            super(googleApiClient);
        }

        protected void zza(zzl com_google_android_gms_location_internal_zzl) throws RemoteException {
            com_google_android_gms_location_internal_zzl.zza(this.zzaOw, new zzb(this));
        }
    }

    public PendingResult<Status> flushLocations(GoogleApiClient client) {
        return client.zzb(new C12955(this, client));
    }

    public Location getLastLocation(GoogleApiClient client) {
        try {
            return LocationServices.zzi(client).getLastLocation();
        } catch (Exception e) {
            return null;
        }
    }

    public LocationAvailability getLocationAvailability(GoogleApiClient client) {
        try {
            return LocationServices.zzi(client).zzyO();
        } catch (Exception e) {
            return null;
        }
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, PendingIntent callbackIntent) {
        return client.zzb(new AnonymousClass10(this, client, callbackIntent));
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, LocationCallback callback) {
        return client.zzb(new C12922(this, client, callback));
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, LocationListener listener) {
        return client.zzb(new C12999(this, client, listener));
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, LocationRequest request, PendingIntent callbackIntent) {
        return client.zzb(new C12988(this, client, request, callbackIntent));
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, LocationRequest request, LocationCallback callback, Looper looper) {
        return client.zzb(new C12977(this, client, request, callback, looper));
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, LocationRequest request, LocationListener listener) {
        return client.zzb(new C12911(this, client, request, listener));
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, LocationRequest request, LocationListener listener, Looper looper) {
        return client.zzb(new C12966(this, client, request, listener, looper));
    }

    public PendingResult<Status> setMockLocation(GoogleApiClient client, Location mockLocation) {
        return client.zzb(new C12944(this, client, mockLocation));
    }

    public PendingResult<Status> setMockMode(GoogleApiClient client, boolean isMockMode) {
        return client.zzb(new C12933(this, client, isMockMode));
    }
}
