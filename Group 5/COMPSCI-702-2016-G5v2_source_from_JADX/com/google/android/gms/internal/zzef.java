package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzjq.zza;
import org.json.JSONObject;

@zzhb
public class zzef implements zzed {
    private final zzjp zzpD;

    /* renamed from: com.google.android.gms.internal.zzef.1 */
    class C03981 implements Runnable {
        final /* synthetic */ String zzAS;
        final /* synthetic */ JSONObject zzAT;
        final /* synthetic */ zzef zzAU;

        C03981(zzef com_google_android_gms_internal_zzef, String str, JSONObject jSONObject) {
            this.zzAU = com_google_android_gms_internal_zzef;
            this.zzAS = str;
            this.zzAT = jSONObject;
        }

        public void run() {
            this.zzAU.zzpD.zza(this.zzAS, this.zzAT);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzef.2 */
    class C03992 implements Runnable {
        final /* synthetic */ String zzAS;
        final /* synthetic */ zzef zzAU;
        final /* synthetic */ String zzAV;

        C03992(zzef com_google_android_gms_internal_zzef, String str, String str2) {
            this.zzAU = com_google_android_gms_internal_zzef;
            this.zzAS = str;
            this.zzAV = str2;
        }

        public void run() {
            this.zzAU.zzpD.zze(this.zzAS, this.zzAV);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzef.3 */
    class C04003 implements Runnable {
        final /* synthetic */ zzef zzAU;
        final /* synthetic */ String zzAW;

        C04003(zzef com_google_android_gms_internal_zzef, String str) {
            this.zzAU = com_google_android_gms_internal_zzef;
            this.zzAW = str;
        }

        public void run() {
            this.zzAU.zzpD.loadData(this.zzAW, "text/html", "UTF-8");
        }
    }

    /* renamed from: com.google.android.gms.internal.zzef.4 */
    class C04014 implements Runnable {
        final /* synthetic */ zzef zzAU;
        final /* synthetic */ String zzAW;

        C04014(zzef com_google_android_gms_internal_zzef, String str) {
            this.zzAU = com_google_android_gms_internal_zzef;
            this.zzAW = str;
        }

        public void run() {
            this.zzAU.zzpD.loadData(this.zzAW, "text/html", "UTF-8");
        }
    }

    /* renamed from: com.google.android.gms.internal.zzef.5 */
    class C04025 implements Runnable {
        final /* synthetic */ String zzAP;
        final /* synthetic */ zzef zzAU;

        C04025(zzef com_google_android_gms_internal_zzef, String str) {
            this.zzAU = com_google_android_gms_internal_zzef;
            this.zzAP = str;
        }

        public void run() {
            this.zzAU.zzpD.loadUrl(this.zzAP);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzef.6 */
    class C08206 implements zza {
        final /* synthetic */ zzef zzAU;
        final /* synthetic */ zzed.zza zzAX;

        C08206(zzef com_google_android_gms_internal_zzef, zzed.zza com_google_android_gms_internal_zzed_zza) {
            this.zzAU = com_google_android_gms_internal_zzef;
            this.zzAX = com_google_android_gms_internal_zzed_zza;
        }

        public void zza(zzjp com_google_android_gms_internal_zzjp, boolean z) {
            this.zzAX.zzeo();
        }
    }

    public zzef(Context context, VersionInfoParcel versionInfoParcel, zzan com_google_android_gms_internal_zzan) {
        this.zzpD = zzr.zzbD().zza(context, new AdSizeParcel(), false, false, com_google_android_gms_internal_zzan, versionInfoParcel);
        this.zzpD.getWebView().setWillNotDraw(true);
    }

    private void runOnUiThread(Runnable runnable) {
        if (zzn.zzcS().zzhJ()) {
            runnable.run();
        } else {
            zzir.zzMc.post(runnable);
        }
    }

    public void destroy() {
        this.zzpD.destroy();
    }

    public void zzZ(String str) {
        runOnUiThread(new C04003(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str})));
    }

    public void zza(com.google.android.gms.ads.internal.client.zza com_google_android_gms_ads_internal_client_zza, zzg com_google_android_gms_ads_internal_overlay_zzg, zzdb com_google_android_gms_internal_zzdb, zzp com_google_android_gms_ads_internal_overlay_zzp, boolean z, zzdh com_google_android_gms_internal_zzdh, zzdj com_google_android_gms_internal_zzdj, zze com_google_android_gms_ads_internal_zze, zzft com_google_android_gms_internal_zzft) {
        this.zzpD.zzhU().zzb(com_google_android_gms_ads_internal_client_zza, com_google_android_gms_ads_internal_overlay_zzg, com_google_android_gms_internal_zzdb, com_google_android_gms_ads_internal_overlay_zzp, z, com_google_android_gms_internal_zzdh, com_google_android_gms_internal_zzdj, new zze(false), com_google_android_gms_internal_zzft);
    }

    public void zza(zzed.zza com_google_android_gms_internal_zzed_zza) {
        this.zzpD.zzhU().zza(new C08206(this, com_google_android_gms_internal_zzed_zza));
    }

    public void zza(String str, zzdf com_google_android_gms_internal_zzdf) {
        this.zzpD.zzhU().zza(str, com_google_android_gms_internal_zzdf);
    }

    public void zza(String str, JSONObject jSONObject) {
        runOnUiThread(new C03981(this, str, jSONObject));
    }

    public void zzaa(String str) {
        runOnUiThread(new C04025(this, str));
    }

    public void zzab(String str) {
        runOnUiThread(new C04014(this, str));
    }

    public void zzb(String str, zzdf com_google_android_gms_internal_zzdf) {
        this.zzpD.zzhU().zzb(str, com_google_android_gms_internal_zzdf);
    }

    public void zzb(String str, JSONObject jSONObject) {
        this.zzpD.zzb(str, jSONObject);
    }

    public void zze(String str, String str2) {
        runOnUiThread(new C03992(this, str, str2));
    }

    public zzei zzen() {
        return new zzej(this);
    }
}
