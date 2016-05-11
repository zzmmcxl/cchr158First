package com.google.android.gms.cast;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.Callback;
import android.support.v7.media.MediaRouter.RouteInfo;
import android.text.TextUtils;
import android.view.Display;
import com.google.android.gms.C0230R;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplayOptions;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionCallbacks;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionResult;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(19)
public abstract class CastRemoteDisplayLocalService extends Service {
    private static final zzl zzaaf;
    private static final int zzaag;
    private static final Object zzaah;
    private static AtomicBoolean zzaai;
    private static CastRemoteDisplayLocalService zzaax;
    private Handler mHandler;
    private Notification mNotification;
    private String zzZC;
    private GoogleApiClient zzaaj;
    private CastRemoteDisplaySessionCallbacks zzaak;
    private Callbacks zzaal;
    private zzb zzaam;
    private NotificationSettings zzaan;
    private boolean zzaao;
    private PendingIntent zzaap;
    private CastDevice zzaaq;
    private Display zzaar;
    private Context zzaas;
    private ServiceConnection zzaat;
    private MediaRouter zzaau;
    private boolean zzaav;
    private final Callback zzaaw;
    private final IBinder zzaay;

    /* renamed from: com.google.android.gms.cast.CastRemoteDisplayLocalService.3 */
    class C03073 implements Runnable {
        final /* synthetic */ CastRemoteDisplayLocalService zzaaz;

        C03073(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzaaz = castRemoteDisplayLocalService;
        }

        public void run() {
            this.zzaaz.zzbe("onCreate after delay. The local service been started: " + this.zzaaz.zzaav);
            if (!this.zzaaz.zzaav) {
                this.zzaaz.zzbh("The local service has not been been started, stopping it");
                this.zzaaz.stopSelf();
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.CastRemoteDisplayLocalService.4 */
    static class C03084 implements ServiceConnection {
        final /* synthetic */ String zzZI;
        final /* synthetic */ CastDevice zzaaA;
        final /* synthetic */ NotificationSettings zzaaB;
        final /* synthetic */ Context zzaaC;
        final /* synthetic */ Callbacks zzaaD;

        C03084(String str, CastDevice castDevice, NotificationSettings notificationSettings, Context context, Callbacks callbacks) {
            this.zzZI = str;
            this.zzaaA = castDevice;
            this.zzaaB = notificationSettings;
            this.zzaaC = context;
            this.zzaaD = callbacks;
        }

        public void onServiceConnected(ComponentName className, IBinder binder) {
            CastRemoteDisplayLocalService zznM = ((zza) binder).zznM();
            if (zznM == null || !zznM.zza(this.zzZI, this.zzaaA, this.zzaaB, this.zzaaC, this, this.zzaaD)) {
                CastRemoteDisplayLocalService.zzaaf.zzc("Connected but unable to get the service instance", new Object[0]);
                this.zzaaD.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_CREATION_FAILED));
                CastRemoteDisplayLocalService.zzaai.set(false);
                try {
                    this.zzaaC.unbindService(this);
                } catch (IllegalArgumentException e) {
                    CastRemoteDisplayLocalService.zzaaf.zzb("No need to unbind service, already unbound", new Object[0]);
                }
            }
        }

        public void onServiceDisconnected(ComponentName arg0) {
            CastRemoteDisplayLocalService.zzaaf.zzb("onServiceDisconnected", new Object[0]);
            this.zzaaD.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_DISCONNECTED, "Service Disconnected"));
            CastRemoteDisplayLocalService.zzaai.set(false);
            try {
                this.zzaaC.unbindService(this);
            } catch (IllegalArgumentException e) {
                CastRemoteDisplayLocalService.zzaaf.zzb("No need to unbind service, already unbound", new Object[0]);
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.CastRemoteDisplayLocalService.5 */
    class C03095 implements Runnable {
        final /* synthetic */ boolean zzaaE;
        final /* synthetic */ CastRemoteDisplayLocalService zzaaz;

        C03095(CastRemoteDisplayLocalService castRemoteDisplayLocalService, boolean z) {
            this.zzaaz = castRemoteDisplayLocalService;
            this.zzaaE = z;
        }

        public void run() {
            this.zzaaz.zzR(this.zzaaE);
        }
    }

    /* renamed from: com.google.android.gms.cast.CastRemoteDisplayLocalService.6 */
    class C03106 implements Runnable {
        final /* synthetic */ NotificationSettings zzaaB;
        final /* synthetic */ CastRemoteDisplayLocalService zzaaz;

        C03106(CastRemoteDisplayLocalService castRemoteDisplayLocalService, NotificationSettings notificationSettings) {
            this.zzaaz = castRemoteDisplayLocalService;
            this.zzaaB = notificationSettings;
        }

        public void run() {
            this.zzaaz.zza(this.zzaaB);
        }
    }

    public interface Callbacks {
        void onRemoteDisplaySessionError(Status status);

        void onRemoteDisplaySessionStarted(CastRemoteDisplayLocalService castRemoteDisplayLocalService);

        void onServiceCreated(CastRemoteDisplayLocalService castRemoteDisplayLocalService);
    }

    public static final class NotificationSettings {
        private Notification mNotification;
        private PendingIntent zzaaF;
        private String zzaaG;
        private String zzaaH;

        public static final class Builder {
            private NotificationSettings zzaaI;

            public Builder() {
                this.zzaaI = new NotificationSettings();
            }

            public NotificationSettings build() {
                if (this.zzaaI.mNotification != null) {
                    if (!TextUtils.isEmpty(this.zzaaI.zzaaG)) {
                        throw new IllegalArgumentException("notificationTitle requires using the default notification");
                    } else if (!TextUtils.isEmpty(this.zzaaI.zzaaH)) {
                        throw new IllegalArgumentException("notificationText requires using the default notification");
                    } else if (this.zzaaI.zzaaF != null) {
                        throw new IllegalArgumentException("notificationPendingIntent requires using the default notification");
                    }
                } else if (TextUtils.isEmpty(this.zzaaI.zzaaG) && TextUtils.isEmpty(this.zzaaI.zzaaH) && this.zzaaI.zzaaF == null) {
                    throw new IllegalArgumentException("At least an argument must be provided");
                }
                return this.zzaaI;
            }

            public Builder setNotification(Notification notification) {
                this.zzaaI.mNotification = notification;
                return this;
            }

            public Builder setNotificationPendingIntent(PendingIntent notificationPendingIntent) {
                this.zzaaI.zzaaF = notificationPendingIntent;
                return this;
            }

            public Builder setNotificationText(String notificationText) {
                this.zzaaI.zzaaH = notificationText;
                return this;
            }

            public Builder setNotificationTitle(String notificationTitle) {
                this.zzaaI.zzaaG = notificationTitle;
                return this;
            }
        }

        private NotificationSettings() {
        }

        private NotificationSettings(NotificationSettings newSettings) {
            this.mNotification = newSettings.mNotification;
            this.zzaaF = newSettings.zzaaF;
            this.zzaaG = newSettings.zzaaG;
            this.zzaaH = newSettings.zzaaH;
        }
    }

    private class zza extends Binder {
        final /* synthetic */ CastRemoteDisplayLocalService zzaaz;

        private zza(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzaaz = castRemoteDisplayLocalService;
        }

        CastRemoteDisplayLocalService zznM() {
            return this.zzaaz;
        }
    }

    private static final class zzb extends BroadcastReceiver {
        private zzb() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT")) {
                CastRemoteDisplayLocalService.zzaaf.zzb("disconnecting", new Object[0]);
                CastRemoteDisplayLocalService.stopService();
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.CastRemoteDisplayLocalService.1 */
    class C07311 extends Callback {
        final /* synthetic */ CastRemoteDisplayLocalService zzaaz;

        C07311(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzaaz = castRemoteDisplayLocalService;
        }

        public void onRouteUnselected(MediaRouter router, RouteInfo info) {
            this.zzaaz.zzbe("onRouteUnselected");
            if (this.zzaaz.zzaaq == null) {
                this.zzaaz.zzbe("onRouteUnselected, no device was selected");
            } else if (CastDevice.getFromBundle(info.getExtras()).getDeviceId().equals(this.zzaaz.zzaaq.getDeviceId())) {
                CastRemoteDisplayLocalService.stopService();
            } else {
                this.zzaaz.zzbe("onRouteUnselected, device does not match");
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.CastRemoteDisplayLocalService.2 */
    class C07322 implements OnConnectionFailedListener {
        final /* synthetic */ CastRemoteDisplayLocalService zzaaz;

        C07322(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzaaz = castRemoteDisplayLocalService;
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            this.zzaaz.zzbh("Connection failed: " + connectionResult);
            this.zzaaz.zznE();
        }
    }

    /* renamed from: com.google.android.gms.cast.CastRemoteDisplayLocalService.7 */
    class C07337 implements CastRemoteDisplaySessionCallbacks {
        final /* synthetic */ CastRemoteDisplayLocalService zzaaz;

        C07337(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzaaz = castRemoteDisplayLocalService;
        }

        public void onRemoteDisplayEnded(Status status) {
            CastRemoteDisplayLocalService.zzaaf.zzb(String.format("Cast screen has ended: %d", new Object[]{Integer.valueOf(status.getStatusCode())}), new Object[0]);
            CastRemoteDisplayLocalService.zzS(false);
        }
    }

    /* renamed from: com.google.android.gms.cast.CastRemoteDisplayLocalService.8 */
    class C07348 implements ResultCallback<CastRemoteDisplaySessionResult> {
        final /* synthetic */ CastRemoteDisplayLocalService zzaaz;

        C07348(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzaaz = castRemoteDisplayLocalService;
        }

        public /* synthetic */ void onResult(Result result) {
            zza((CastRemoteDisplaySessionResult) result);
        }

        public void zza(CastRemoteDisplaySessionResult castRemoteDisplaySessionResult) {
            if (castRemoteDisplaySessionResult.getStatus().isSuccess()) {
                CastRemoteDisplayLocalService.zzaaf.zzb("startRemoteDisplay successful", new Object[0]);
                synchronized (CastRemoteDisplayLocalService.zzaah) {
                    if (CastRemoteDisplayLocalService.zzaax == null) {
                        CastRemoteDisplayLocalService.zzaaf.zzb("Remote Display started but session already cancelled", new Object[0]);
                        this.zzaaz.zznE();
                        return;
                    }
                    Display presentationDisplay = castRemoteDisplaySessionResult.getPresentationDisplay();
                    if (presentationDisplay != null) {
                        this.zzaaz.zza(presentationDisplay);
                    } else {
                        CastRemoteDisplayLocalService.zzaaf.zzc("Cast Remote Display session created without display", new Object[0]);
                    }
                    CastRemoteDisplayLocalService.zzaai.set(false);
                    if (this.zzaaz.zzaas != null && this.zzaaz.zzaat != null) {
                        try {
                            this.zzaaz.zzaas.unbindService(this.zzaaz.zzaat);
                        } catch (IllegalArgumentException e) {
                            CastRemoteDisplayLocalService.zzaaf.zzb("No need to unbind service, already unbound", new Object[0]);
                        }
                        this.zzaaz.zzaat = null;
                        this.zzaaz.zzaas = null;
                        return;
                    }
                    return;
                }
            }
            CastRemoteDisplayLocalService.zzaaf.zzc("Connection was not successful", new Object[0]);
            this.zzaaz.zznE();
        }
    }

    /* renamed from: com.google.android.gms.cast.CastRemoteDisplayLocalService.9 */
    class C07359 implements ResultCallback<CastRemoteDisplaySessionResult> {
        final /* synthetic */ CastRemoteDisplayLocalService zzaaz;

        C07359(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzaaz = castRemoteDisplayLocalService;
        }

        public /* synthetic */ void onResult(Result result) {
            zza((CastRemoteDisplaySessionResult) result);
        }

        public void zza(CastRemoteDisplaySessionResult castRemoteDisplaySessionResult) {
            if (castRemoteDisplaySessionResult.getStatus().isSuccess()) {
                this.zzaaz.zzbe("remote display stopped");
            } else {
                this.zzaaz.zzbe("Unable to stop the remote display, result unsuccessful");
            }
            this.zzaaz.zzaar = null;
        }
    }

    static {
        zzaaf = new zzl("CastRemoteDisplayLocalService");
        zzaag = C0230R.id.cast_notification_id;
        zzaah = new Object();
        zzaai = new AtomicBoolean(false);
    }

    public CastRemoteDisplayLocalService() {
        this.zzaav = false;
        this.zzaaw = new C07311(this);
        this.zzaay = new zza();
    }

    public static CastRemoteDisplayLocalService getInstance() {
        CastRemoteDisplayLocalService castRemoteDisplayLocalService;
        synchronized (zzaah) {
            castRemoteDisplayLocalService = zzaax;
        }
        return castRemoteDisplayLocalService;
    }

    protected static void setDebugEnabled() {
        zzaaf.zzY(true);
    }

    public static void startService(Context activityContext, Class<? extends CastRemoteDisplayLocalService> serviceClass, String applicationId, CastDevice device, NotificationSettings notificationSettings, Callbacks callbacks) {
        zzaaf.zzb("Starting Service", new Object[0]);
        synchronized (zzaah) {
            if (zzaax != null) {
                zzaaf.zzf("An existing service had not been stopped before starting one", new Object[0]);
                zzS(true);
            }
        }
        zzb(activityContext, (Class) serviceClass);
        zzx.zzb((Object) activityContext, (Object) "activityContext is required.");
        zzx.zzb((Object) serviceClass, (Object) "serviceClass is required.");
        zzx.zzb((Object) applicationId, (Object) "applicationId is required.");
        zzx.zzb((Object) device, (Object) "device is required.");
        zzx.zzb((Object) notificationSettings, (Object) "notificationSettings is required.");
        zzx.zzb((Object) callbacks, (Object) "callbacks is required.");
        if (notificationSettings.mNotification == null && notificationSettings.zzaaF == null) {
            throw new IllegalArgumentException("notificationSettings: Either the notification or the notificationPendingIntent must be provided");
        } else if (zzaai.getAndSet(true)) {
            zzaaf.zzc("Service is already being started, startService has been called twice", new Object[0]);
        } else {
            Intent intent = new Intent(activityContext, serviceClass);
            activityContext.startService(intent);
            activityContext.bindService(intent, new C03084(applicationId, device, notificationSettings, activityContext, callbacks), 64);
        }
    }

    public static void stopService() {
        zzS(false);
    }

    private void zzQ(boolean z) {
        if (this.mHandler == null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mHandler.post(new C03095(this, z));
        } else {
            zzR(z);
        }
    }

    private void zzR(boolean z) {
        zzbe("Stopping Service");
        zzx.zzcD("stopServiceInstanceInternal must be called on the main thread");
        if (!(z || this.zzaau == null)) {
            zzbe("Setting default route");
            this.zzaau.selectRoute(this.zzaau.getDefaultRoute());
        }
        if (this.zzaam != null) {
            zzbe("Unregistering notification receiver");
            unregisterReceiver(this.zzaam);
        }
        zznF();
        zznG();
        zznB();
        if (this.zzaaj != null) {
            this.zzaaj.disconnect();
            this.zzaaj = null;
        }
        if (!(this.zzaas == null || this.zzaat == null)) {
            try {
                this.zzaas.unbindService(this.zzaat);
            } catch (IllegalArgumentException e) {
                zzbe("No need to unbind service, already unbound");
            }
            this.zzaat = null;
            this.zzaas = null;
        }
        this.zzZC = null;
        this.zzaaj = null;
        this.mNotification = null;
        this.zzaar = null;
    }

    private static void zzS(boolean z) {
        zzaaf.zzb("Stopping Service", new Object[0]);
        zzaai.set(false);
        synchronized (zzaah) {
            if (zzaax == null) {
                zzaaf.zzc("Service is already being stopped", new Object[0]);
                return;
            }
            CastRemoteDisplayLocalService castRemoteDisplayLocalService = zzaax;
            zzaax = null;
            castRemoteDisplayLocalService.zzQ(z);
        }
    }

    private Notification zzT(boolean z) {
        int i;
        int i2;
        CharSequence string;
        zzbe("createDefaultNotification");
        int i3 = getApplicationInfo().labelRes;
        CharSequence zzc = this.zzaan.zzaaG;
        CharSequence zzd = this.zzaan.zzaaH;
        if (z) {
            i = C0230R.string.cast_notification_connected_message;
            i2 = C0230R.drawable.cast_ic_notification_on;
        } else {
            i = C0230R.string.cast_notification_connecting_message;
            i2 = C0230R.drawable.cast_ic_notification_connecting;
        }
        if (TextUtils.isEmpty(zzc)) {
            zzc = getString(i3);
        }
        if (TextUtils.isEmpty(zzd)) {
            string = getString(i, new Object[]{this.zzaaq.getFriendlyName()});
        } else {
            string = zzd;
        }
        return new Builder(this).setContentTitle(zzc).setContentText(string).setContentIntent(this.zzaan.zzaaF).setSmallIcon(i2).setOngoing(true).addAction(17301560, getString(C0230R.string.cast_notification_disconnect), zznH()).build();
    }

    private GoogleApiClient zza(CastDevice castDevice) {
        return new GoogleApiClient.Builder(this, new ConnectionCallbacks() {
            final /* synthetic */ CastRemoteDisplayLocalService zzaaz;

            {
                this.zzaaz = r1;
            }

            public void onConnected(Bundle bundle) {
                this.zzaaz.zzbe("onConnected");
                this.zzaaz.zznC();
            }

            public void onConnectionSuspended(int cause) {
                CastRemoteDisplayLocalService.zzaaf.zzf(String.format("[Instance: %s] ConnectionSuspended %d", new Object[]{this, Integer.valueOf(cause)}), new Object[0]);
            }
        }, new C07322(this)).addApi(CastRemoteDisplay.API, new CastRemoteDisplayOptions.Builder(castDevice, this.zzaak).build()).build();
    }

    private void zza(Display display) {
        this.zzaar = display;
        if (this.zzaao) {
            this.mNotification = zzT(true);
            startForeground(zzaag, this.mNotification);
        }
        if (this.zzaal != null) {
            this.zzaal.onRemoteDisplaySessionStarted(this);
            this.zzaal = null;
        }
        onCreatePresentation(this.zzaar);
    }

    private void zza(NotificationSettings notificationSettings) {
        zzx.zzcD("updateNotificationSettingsInternal must be called on the main thread");
        if (this.zzaan == null) {
            throw new IllegalStateException("No current notification settings to update");
        }
        if (!this.zzaao) {
            zzx.zzb(notificationSettings.mNotification, (Object) "notification is required.");
            this.mNotification = notificationSettings.mNotification;
            this.zzaan.mNotification = this.mNotification;
        } else if (notificationSettings.mNotification != null) {
            throw new IllegalStateException("Current mode is default notification, notification attribute must not be provided");
        } else {
            if (notificationSettings.zzaaF != null) {
                this.zzaan.zzaaF = notificationSettings.zzaaF;
            }
            if (!TextUtils.isEmpty(notificationSettings.zzaaG)) {
                this.zzaan.zzaaG = notificationSettings.zzaaG;
            }
            if (!TextUtils.isEmpty(notificationSettings.zzaaH)) {
                this.zzaan.zzaaH = notificationSettings.zzaaH;
            }
            this.mNotification = zzT(true);
        }
        startForeground(zzaag, this.mNotification);
    }

    private boolean zza(String str, CastDevice castDevice, NotificationSettings notificationSettings, Context context, ServiceConnection serviceConnection, Callbacks callbacks) {
        zzbe("startRemoteDisplaySession");
        zzx.zzcD("Starting the Cast Remote Display must be done on the main thread");
        synchronized (zzaah) {
            if (zzaax != null) {
                zzaaf.zzf("An existing service had not been stopped before starting one", new Object[0]);
                return false;
            }
            zzaax = this;
            this.zzaal = callbacks;
            this.zzZC = str;
            this.zzaaq = castDevice;
            this.zzaas = context;
            this.zzaat = serviceConnection;
            this.zzaau = MediaRouter.getInstance(getApplicationContext());
            MediaRouteSelector build = new MediaRouteSelector.Builder().addControlCategory(CastMediaControlIntent.categoryForCast(this.zzZC)).build();
            zzbe("addMediaRouterCallback");
            this.zzaau.addCallback(build, this.zzaaw, 4);
            this.zzaak = new C07337(this);
            this.mNotification = notificationSettings.mNotification;
            this.zzaam = new zzb();
            registerReceiver(this.zzaam, new IntentFilter("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"));
            this.zzaan = new NotificationSettings(null);
            if (this.zzaan.mNotification == null) {
                this.zzaao = true;
                this.mNotification = zzT(false);
            } else {
                this.zzaao = false;
                this.mNotification = this.zzaan.mNotification;
            }
            startForeground(zzaag, this.mNotification);
            this.zzaaj = zza(castDevice);
            this.zzaaj.connect();
            if (this.zzaal != null) {
                this.zzaal.onServiceCreated(this);
            }
            return true;
        }
    }

    private static void zzb(Context context, Class cls) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, cls), Barcode.ITF);
            if (serviceInfo != null && serviceInfo.exported) {
                throw new IllegalStateException("The service must not be exported, verify the manifest configuration");
            }
        } catch (NameNotFoundException e) {
            throw new IllegalStateException("Service not found, did you forget to configure it in the manifest?");
        }
    }

    private void zzbe(String str) {
        zzaaf.zzb("[Instance: %s] %s", this, str);
    }

    private void zzbh(String str) {
        zzaaf.zzc("[Instance: %s] %s", this, str);
    }

    private void zznB() {
        if (this.zzaau != null) {
            zzx.zzcD("CastRemoteDisplayLocalService calls must be done on the main thread");
            zzbe("removeMediaRouterCallback");
            this.zzaau.removeCallback(this.zzaaw);
        }
    }

    private void zznC() {
        zzbe("startRemoteDisplay");
        if (this.zzaaj == null || !this.zzaaj.isConnected()) {
            zzaaf.zzc("Unable to start the remote display as the API client is not ready", new Object[0]);
        } else {
            CastRemoteDisplay.CastRemoteDisplayApi.startRemoteDisplay(this.zzaaj, this.zzZC).setResultCallback(new C07348(this));
        }
    }

    private void zznD() {
        zzbe("stopRemoteDisplay");
        if (this.zzaaj == null || !this.zzaaj.isConnected()) {
            zzaaf.zzc("Unable to stop the remote display as the API client is not ready", new Object[0]);
        } else {
            CastRemoteDisplay.CastRemoteDisplayApi.stopRemoteDisplay(this.zzaaj).setResultCallback(new C07359(this));
        }
    }

    private void zznE() {
        if (this.zzaal != null) {
            this.zzaal.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_CREATION_FAILED));
            this.zzaal = null;
        }
        stopService();
    }

    private void zznF() {
        zzbe("stopRemoteDisplaySession");
        zznD();
        onDismissPresentation();
    }

    private void zznG() {
        zzbe("Stopping the remote display Service");
        stopForeground(true);
        stopSelf();
    }

    private PendingIntent zznH() {
        if (this.zzaap == null) {
            this.zzaap = PendingIntent.getBroadcast(this, 0, new Intent("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"), DriveFile.MODE_READ_ONLY);
        }
        return this.zzaap;
    }

    protected Display getDisplay() {
        return this.zzaar;
    }

    public IBinder onBind(Intent intent) {
        zzbe("onBind");
        return this.zzaay;
    }

    public void onCreate() {
        zzbe("onCreate");
        super.onCreate();
        this.mHandler = new Handler(getMainLooper());
        this.mHandler.postDelayed(new C03073(this), 100);
    }

    public abstract void onCreatePresentation(Display display);

    public abstract void onDismissPresentation();

    public int onStartCommand(Intent intent, int flags, int startId) {
        zzbe("onStartCommand");
        this.zzaav = true;
        return 2;
    }

    public void updateNotificationSettings(NotificationSettings notificationSettings) {
        zzx.zzb((Object) notificationSettings, (Object) "notificationSettings is required.");
        zzx.zzb(this.mHandler, (Object) "Service is not ready yet.");
        this.mHandler.post(new C03106(this, notificationSettings));
    }
}
