package com.google.android.gms.internal;

import android.content.Context;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.internal.zzif.zza;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@zzhb
public class zzgu extends zzgq {
    private zzeo zzCf;
    private boolean zzGA;
    private zzem zzGy;
    protected zzes zzGz;
    private final zzjp zzpD;
    private final zzcb zzpe;
    private zzex zzpn;

    /* renamed from: com.google.android.gms.internal.zzgu.1 */
    class C04341 implements Runnable {
        final /* synthetic */ zzgu zzGB;
        final /* synthetic */ CountDownLatch zzqu;

        C04341(zzgu com_google_android_gms_internal_zzgu, CountDownLatch countDownLatch) {
            this.zzGB = com_google_android_gms_internal_zzgu;
            this.zzqu = countDownLatch;
        }

        public void run() {
            synchronized (this.zzGB.zzGg) {
                this.zzGB.zzGA = zzm.zza(this.zzGB.zzpD, this.zzGB.zzGz, this.zzqu);
            }
        }
    }

    zzgu(Context context, zza com_google_android_gms_internal_zzif_zza, zzex com_google_android_gms_internal_zzex, zzgr.zza com_google_android_gms_internal_zzgr_zza, zzcb com_google_android_gms_internal_zzcb, zzjp com_google_android_gms_internal_zzjp) {
        super(context, com_google_android_gms_internal_zzif_zza, com_google_android_gms_internal_zzgr_zza);
        this.zzpn = com_google_android_gms_internal_zzex;
        this.zzCf = com_google_android_gms_internal_zzif_zza.zzKV;
        this.zzpe = com_google_android_gms_internal_zzcb;
        this.zzpD = com_google_android_gms_internal_zzjp;
    }

    private void zzgk() throws zza {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        zzir.zzMc.post(new C04341(this, countDownLatch));
        try {
            countDownLatch.await(10, TimeUnit.SECONDS);
            synchronized (this.zzGg) {
                if (!this.zzGA) {
                    throw new zza("View could not be prepared", 0);
                } else if (this.zzpD.isDestroyed()) {
                    throw new zza("Assets not loaded, web view is destroyed", 0);
                }
            }
        } catch (InterruptedException e) {
            throw new zza("Interrupted while waiting for latch : " + e, 0);
        }
    }

    public void onStop() {
        synchronized (this.zzGg) {
            super.onStop();
            if (this.zzGy != null) {
                this.zzGy.cancel();
            }
        }
    }

    protected zzif zzD(int i) {
        AdRequestInfoParcel adRequestInfoParcel = this.zzGd.zzLd;
        return new zzif(adRequestInfoParcel.zzHt, this.zzpD, this.zzGe.zzBQ, i, this.zzGe.zzBR, this.zzGe.zzHV, this.zzGe.orientation, this.zzGe.zzBU, adRequestInfoParcel.zzHw, this.zzGe.zzHT, this.zzGz != null ? this.zzGz.zzCp : null, this.zzGz != null ? this.zzGz.zzCq : null, this.zzGz != null ? this.zzGz.zzCr : AdMobAdapter.class.getName(), this.zzCf, this.zzGz != null ? this.zzGz.zzCs : null, this.zzGe.zzHU, this.zzGd.zzrp, this.zzGe.zzHS, this.zzGd.zzKY, this.zzGe.zzHX, this.zzGe.zzHY, this.zzGd.zzKT, null, this.zzGe.zzIj, this.zzGe.zzIk, this.zzGe.zzIl, this.zzGe.zzIm);
    }

    protected void zzh(long j) throws zza {
        synchronized (this.zzGg) {
            this.zzGy = zzi(j);
        }
        this.zzGz = this.zzGy.zzc(this.zzCf.zzBO);
        switch (this.zzGz.zzCo) {
            case Barcode.ALL_FORMATS /*0*/:
                if (this.zzGz.zzCp != null && this.zzGz.zzCp.zzBJ != null) {
                    zzgk();
                }
            case CompletionEvent.STATUS_FAILURE /*1*/:
                throw new zza("No fill from any mediation ad networks.", 3);
            default:
                throw new zza("Unexpected mediation result: " + this.zzGz.zzCo, 0);
        }
    }

    zzem zzi(long j) {
        if (this.zzCf.zzBX != -1) {
            return new zzeu(this.mContext, this.zzGd.zzLd, this.zzpn, this.zzCf, this.zzGe.zzuk, this.zzGe.zzum, j, ((Long) zzbt.zzwY.get()).longValue(), 2);
        }
        return new zzev(this.mContext, this.zzGd.zzLd, this.zzpn, this.zzCf, this.zzGe.zzuk, this.zzGe.zzum, j, ((Long) zzbt.zzwY.get()).longValue(), this.zzpe);
    }
}
