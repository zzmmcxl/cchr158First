package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzr;

@zzhb
public class zzdp extends zzim {
    final zzjp zzpD;
    final zzdr zzzJ;
    private final String zzzK;

    /* renamed from: com.google.android.gms.internal.zzdp.1 */
    class C03911 implements Runnable {
        final /* synthetic */ zzdp zzzL;

        C03911(zzdp com_google_android_gms_internal_zzdp) {
            this.zzzL = com_google_android_gms_internal_zzdp;
        }

        public void run() {
            zzr.zzbR().zzb(this.zzzL);
        }
    }

    zzdp(zzjp com_google_android_gms_internal_zzjp, zzdr com_google_android_gms_internal_zzdr, String str) {
        this.zzpD = com_google_android_gms_internal_zzjp;
        this.zzzJ = com_google_android_gms_internal_zzdr;
        this.zzzK = str;
        zzr.zzbR().zza(this);
    }

    public void onStop() {
        this.zzzJ.abort();
    }

    public void zzbr() {
        try {
            this.zzzJ.zzU(this.zzzK);
        } finally {
            zzir.zzMc.post(new C03911(this));
        }
    }
}
