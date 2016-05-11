package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmq;

public class zzab extends zzz {
    private zza zzaYD;
    private com.google.android.gms.measurement.AppMeasurement.zza zzaYE;
    private boolean zzaYF;

    /* renamed from: com.google.android.gms.measurement.internal.zzab.1 */
    class C04971 implements Runnable {
        final /* synthetic */ boolean zzaYG;
        final /* synthetic */ zzab zzaYH;

        C04971(zzab com_google_android_gms_measurement_internal_zzab, boolean z) {
            this.zzaYH = com_google_android_gms_measurement_internal_zzab;
            this.zzaYG = z;
        }

        public void run() {
            this.zzaYH.zzas(this.zzaYG);
        }
    }

    /* renamed from: com.google.android.gms.measurement.internal.zzab.2 */
    class C04982 implements Runnable {
        final /* synthetic */ String val$name;
        final /* synthetic */ String zzaHU;
        final /* synthetic */ zzab zzaYH;
        final /* synthetic */ String zzaYI;
        final /* synthetic */ long zzaYJ;
        final /* synthetic */ Bundle zzaYK;
        final /* synthetic */ boolean zzaYL;

        C04982(zzab com_google_android_gms_measurement_internal_zzab, String str, String str2, long j, Bundle bundle, boolean z, String str3) {
            this.zzaYH = com_google_android_gms_measurement_internal_zzab;
            this.zzaYI = str;
            this.val$name = str2;
            this.zzaYJ = j;
            this.zzaYK = bundle;
            this.zzaYL = z;
            this.zzaHU = str3;
        }

        public void run() {
            this.zzaYH.zzb(this.zzaYI, this.val$name, this.zzaYJ, this.zzaYK, this.zzaYL, this.zzaHU);
        }
    }

    /* renamed from: com.google.android.gms.measurement.internal.zzab.3 */
    class C04993 implements Runnable {
        final /* synthetic */ String val$name;
        final /* synthetic */ zzab zzaYH;
        final /* synthetic */ String zzaYI;
        final /* synthetic */ long zzaYJ;
        final /* synthetic */ Object zzaYM;

        C04993(zzab com_google_android_gms_measurement_internal_zzab, String str, String str2, Object obj, long j) {
            this.zzaYH = com_google_android_gms_measurement_internal_zzab;
            this.zzaYI = str;
            this.val$name = str2;
            this.zzaYM = obj;
            this.zzaYJ = j;
        }

        public void run() {
            this.zzaYH.zza(this.zzaYI, this.val$name, this.zzaYM, this.zzaYJ);
        }
    }

    @MainThread
    @TargetApi(14)
    private class zza implements ActivityLifecycleCallbacks {
        final /* synthetic */ zzab zzaYH;

        private zza(zzab com_google_android_gms_measurement_internal_zzab) {
            this.zzaYH = com_google_android_gms_measurement_internal_zzab;
        }

        private boolean zzfo(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            this.zzaYH.zza("auto", "_ldl", str);
            return true;
        }

        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            try {
                this.zzaYH.zzAo().zzCK().zzfg("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent != null) {
                    Uri data = intent.getData();
                    if (data != null && data.isHierarchical()) {
                        String queryParameter = data.getQueryParameter("referrer");
                        if (!TextUtils.isEmpty(queryParameter)) {
                            if (queryParameter.contains("gclid")) {
                                this.zzaYH.zzAo().zzCJ().zzj("Activity created with referrer", queryParameter);
                                zzfo(queryParameter);
                                return;
                            }
                            this.zzaYH.zzAo().zzCJ().zzfg("Activity created with data 'referrer' param without gclid");
                        }
                    }
                }
            } catch (Throwable th) {
                this.zzaYH.zzAo().zzCE().zzj("Throwable caught in onActivityCreated", th);
            }
        }

        public void onActivityDestroyed(Activity activity) {
        }

        @MainThread
        public void onActivityPaused(Activity activity) {
            this.zzaYH.zzCm().zzDw();
        }

        @MainThread
        public void onActivityResumed(Activity activity) {
            this.zzaYH.zzCm().zzDu();
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    protected zzab(zzw com_google_android_gms_measurement_internal_zzw) {
        super(com_google_android_gms_measurement_internal_zzw);
    }

    @WorkerThread
    private void zzDm() {
        try {
            zzh(Class.forName(zzDn()));
        } catch (ClassNotFoundException e) {
            zzAo().zzCI().zzfg("Tag Manager is not found and thus will not be used");
        }
    }

    private String zzDn() {
        return "com.google.android.gms.tagmanager.TagManagerService";
    }

    private void zza(String str, String str2, Bundle bundle, boolean z, String str3) {
        zza(str, str2, bundle, z, str3, zzjl().currentTimeMillis());
    }

    private void zza(String str, String str2, Bundle bundle, boolean z, String str3, long j) {
        zzx.zzcM(str);
        zzCk().zzfr(str2);
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            int zzBA = zzCp().zzBA();
            int i = 0;
            for (String str4 : bundle.keySet()) {
                zzCk().zzft(str4);
                if (zzaj.zzfq(str4)) {
                    int i2 = i + 1;
                    zzx.zzb(i2 <= zzBA, "Event can't contain more then " + zzBA + " params");
                    i = i2;
                }
                Object zzk = zzCk().zzk(str4, bundle.get(str4));
                if (zzk != null) {
                    zzCk().zza(bundle2, str4, zzk);
                }
            }
        }
        int zzBD = zzCp().zzBD();
        bundle2.putString("_o", str.length() <= zzBD ? str : str.substring(0, zzBD));
        zza(str, str2, j, bundle2, z, str3);
    }

    @WorkerThread
    private void zza(String str, String str2, Object obj, long j) {
        zzx.zzcM(str);
        zzx.zzcM(str2);
        zzjk();
        zzjj();
        zzjv();
        if (!zzCo().zzAr()) {
            zzAo().zzCJ().zzfg("User property not set since app measurement is disabled");
        } else if (this.zzaTV.zzCS()) {
            zzAo().zzCJ().zze("Setting user property (FE)", str2, obj);
            zzCi().zza(new UserAttributeParcel(str2, j, obj, str));
        }
    }

    @WorkerThread
    private void zzas(boolean z) {
        zzjk();
        zzjj();
        zzjv();
        zzAo().zzCJ().zzj("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzCo().setMeasurementEnabled(z);
        zzCi().zzDo();
    }

    @WorkerThread
    private void zzb(String str, String str2, long j, Bundle bundle, boolean z, String str3) {
        zzx.zzcM(str);
        zzx.zzcM(str2);
        zzx.zzz(bundle);
        zzjk();
        zzjv();
        if (zzCo().zzAr()) {
            if (!this.zzaYF) {
                this.zzaYF = true;
                zzDm();
            }
            if (z && this.zzaYE != null && !zzaj.zzfv(str2)) {
                zzAo().zzCJ().zze("Passing event to registered event handler (FE)", str2, bundle);
                this.zzaYE.zza(str, str2, bundle, j);
                return;
            } else if (this.zzaTV.zzCS()) {
                zzAo().zzCJ().zze("Logging event (FE)", str2, bundle);
                zzCi().zzb(new EventParcel(str2, new EventParams(bundle), str, j), str3);
                return;
            } else {
                return;
            }
        }
        zzAo().zzCJ().zzfg("Event not sent since app measurement is disabled");
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public void setMeasurementEnabled(boolean enabled) {
        zzjv();
        zzjj();
        zzCn().zzg(new C04971(this, enabled));
    }

    public /* bridge */ /* synthetic */ zzp zzAo() {
        return super.zzAo();
    }

    public /* bridge */ /* synthetic */ void zzCd() {
        super.zzCd();
    }

    public /* bridge */ /* synthetic */ zzc zzCe() {
        return super.zzCe();
    }

    public /* bridge */ /* synthetic */ zzab zzCf() {
        return super.zzCf();
    }

    public /* bridge */ /* synthetic */ zzn zzCg() {
        return super.zzCg();
    }

    public /* bridge */ /* synthetic */ zzg zzCh() {
        return super.zzCh();
    }

    public /* bridge */ /* synthetic */ zzac zzCi() {
        return super.zzCi();
    }

    public /* bridge */ /* synthetic */ zze zzCj() {
        return super.zzCj();
    }

    public /* bridge */ /* synthetic */ zzaj zzCk() {
        return super.zzCk();
    }

    public /* bridge */ /* synthetic */ zzu zzCl() {
        return super.zzCl();
    }

    public /* bridge */ /* synthetic */ zzad zzCm() {
        return super.zzCm();
    }

    public /* bridge */ /* synthetic */ zzv zzCn() {
        return super.zzCn();
    }

    public /* bridge */ /* synthetic */ zzt zzCo() {
        return super.zzCo();
    }

    public /* bridge */ /* synthetic */ zzd zzCp() {
        return super.zzCp();
    }

    @TargetApi(14)
    public void zzDk() {
        if (getContext().getApplicationContext() instanceof Application) {
            Application application = (Application) getContext().getApplicationContext();
            if (this.zzaYD == null) {
                this.zzaYD = new zza();
            }
            application.unregisterActivityLifecycleCallbacks(this.zzaYD);
            application.registerActivityLifecycleCallbacks(this.zzaYD);
            zzAo().zzCK().zzfg("Registered activity lifecycle callback");
        }
    }

    @WorkerThread
    public void zzDl() {
        zzjk();
        zzjj();
        zzjv();
        if (this.zzaTV.zzCS()) {
            zzCi().zzDl();
            String zzCQ = zzCo().zzCQ();
            if (!TextUtils.isEmpty(zzCQ) && !zzCQ.equals(zzCh().zzCy())) {
                Bundle bundle = new Bundle();
                bundle.putString("_po", zzCQ);
                zze("auto", "_ou", bundle);
            }
        }
    }

    protected void zza(String str, String str2, long j, Bundle bundle, boolean z, String str3) {
        zzx.zzz(bundle);
        zzCn().zzg(new C04982(this, str, str2, j, bundle, z, str3));
    }

    void zza(String str, String str2, long j, Object obj) {
        zzCn().zzg(new C04993(this, str, str2, obj, j));
    }

    public void zza(String str, String str2, Object obj) {
        zzx.zzcM(str);
        long currentTimeMillis = zzjl().currentTimeMillis();
        zzCk().zzfs(str2);
        if (obj != null) {
            zzCk().zzl(str2, obj);
            Object zzm = zzCk().zzm(str2, obj);
            if (zzm != null) {
                zza(str, str2, currentTimeMillis, zzm);
                return;
            }
            return;
        }
        zza(str, str2, currentTimeMillis, null);
    }

    public void zze(String str, String str2, Bundle bundle) {
        zzjj();
        zza(str, str2, bundle, true, null);
    }

    @WorkerThread
    public void zzh(Class<?> cls) {
        try {
            cls.getDeclaredMethod("initialize", new Class[]{Context.class}).invoke(null, new Object[]{getContext()});
        } catch (Exception e) {
            zzAo().zzCF().zzj("Failed to invoke Tag Manager's initialize() method", e);
        }
    }

    protected void zziJ() {
    }

    public /* bridge */ /* synthetic */ void zzjj() {
        super.zzjj();
    }

    public /* bridge */ /* synthetic */ void zzjk() {
        super.zzjk();
    }

    public /* bridge */ /* synthetic */ zzmq zzjl() {
        return super.zzjl();
    }
}
