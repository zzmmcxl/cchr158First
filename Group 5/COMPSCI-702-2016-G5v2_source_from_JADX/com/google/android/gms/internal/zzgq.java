package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzhb
public abstract class zzgq extends zzim {
    protected final Context mContext;
    protected final com.google.android.gms.internal.zzgr.zza zzGc;
    protected final com.google.android.gms.internal.zzif.zza zzGd;
    protected AdResponseParcel zzGe;
    protected final Object zzGg;
    protected final Object zzpV;

    /* renamed from: com.google.android.gms.internal.zzgq.1 */
    class C04321 implements Runnable {
        final /* synthetic */ zzgq zzGt;

        C04321(zzgq com_google_android_gms_internal_zzgq) {
            this.zzGt = com_google_android_gms_internal_zzgq;
        }

        public void run() {
            this.zzGt.onStop();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzgq.2 */
    class C04332 implements Runnable {
        final /* synthetic */ zzgq zzGt;
        final /* synthetic */ zzif zzpF;

        C04332(zzgq com_google_android_gms_internal_zzgq, zzif com_google_android_gms_internal_zzif) {
            this.zzGt = com_google_android_gms_internal_zzgq;
            this.zzpF = com_google_android_gms_internal_zzif;
        }

        public void run() {
            synchronized (this.zzGt.zzpV) {
                this.zzGt.zzm(this.zzpF);
            }
        }
    }

    protected static final class zza extends Exception {
        private final int zzGu;

        public zza(String str, int i) {
            super(str);
            this.zzGu = i;
        }

        public int getErrorCode() {
            return this.zzGu;
        }
    }

    protected zzgq(Context context, com.google.android.gms.internal.zzif.zza com_google_android_gms_internal_zzif_zza, com.google.android.gms.internal.zzgr.zza com_google_android_gms_internal_zzgr_zza) {
        super(true);
        this.zzpV = new Object();
        this.zzGg = new Object();
        this.mContext = context;
        this.zzGd = com_google_android_gms_internal_zzif_zza;
        this.zzGe = com_google_android_gms_internal_zzif_zza.zzLe;
        this.zzGc = com_google_android_gms_internal_zzgr_zza;
    }

    public void onStop() {
    }

    protected abstract zzif zzD(int i);

    public void zzbr() {
        int errorCode;
        synchronized (this.zzpV) {
            zzb.zzaI("AdRendererBackgroundTask started.");
            int i = this.zzGd.errorCode;
            try {
                zzh(SystemClock.elapsedRealtime());
            } catch (zza e) {
                errorCode = e.getErrorCode();
                if (errorCode == 3 || errorCode == -1) {
                    zzb.zzaJ(e.getMessage());
                } else {
                    zzb.zzaK(e.getMessage());
                }
                if (this.zzGe == null) {
                    this.zzGe = new AdResponseParcel(errorCode);
                } else {
                    this.zzGe = new AdResponseParcel(errorCode, this.zzGe.zzBU);
                }
                zzir.zzMc.post(new C04321(this));
                i = errorCode;
            }
            zzir.zzMc.post(new C04332(this, zzD(i)));
        }
    }

    protected abstract void zzh(long j) throws zza;

    protected void zzm(zzif com_google_android_gms_internal_zzif) {
        this.zzGc.zzb(com_google_android_gms_internal_zzif);
    }
}
