package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzr;
import java.util.LinkedList;
import java.util.List;

@zzhb
class zzdw {
    private final List<zza> zzpH;

    /* renamed from: com.google.android.gms.internal.zzdw.7 */
    class C03957 implements Runnable {
        final /* synthetic */ zzdw zzAc;
        final /* synthetic */ zza zzAo;
        final /* synthetic */ zzdx zzAp;

        C03957(zzdw com_google_android_gms_internal_zzdw, zza com_google_android_gms_internal_zzdw_zza, zzdx com_google_android_gms_internal_zzdx) {
            this.zzAc = com_google_android_gms_internal_zzdw;
            this.zzAo = com_google_android_gms_internal_zzdw_zza;
            this.zzAp = com_google_android_gms_internal_zzdx;
        }

        public void run() {
            try {
                this.zzAo.zzb(this.zzAp);
            } catch (Throwable e) {
                zzb.zzd("Could not propagate interstitial ad event.", e);
            }
        }
    }

    interface zza {
        void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException;
    }

    /* renamed from: com.google.android.gms.internal.zzdw.1 */
    class C10051 extends com.google.android.gms.ads.internal.client.zzq.zza {
        final /* synthetic */ zzdw zzAc;

        /* renamed from: com.google.android.gms.internal.zzdw.1.1 */
        class C08031 implements zza {
            final /* synthetic */ C10051 zzAd;

            C08031(C10051 c10051) {
                this.zzAd = c10051;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzpK != null) {
                    com_google_android_gms_internal_zzdx.zzpK.onAdClosed();
                }
                zzr.zzbN().zzee();
            }
        }

        /* renamed from: com.google.android.gms.internal.zzdw.1.2 */
        class C08042 implements zza {
            final /* synthetic */ C10051 zzAd;
            final /* synthetic */ int zzAe;

            C08042(C10051 c10051, int i) {
                this.zzAd = c10051;
                this.zzAe = i;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzpK != null) {
                    com_google_android_gms_internal_zzdx.zzpK.onAdFailedToLoad(this.zzAe);
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzdw.1.3 */
        class C08053 implements zza {
            final /* synthetic */ C10051 zzAd;

            C08053(C10051 c10051) {
                this.zzAd = c10051;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzpK != null) {
                    com_google_android_gms_internal_zzdx.zzpK.onAdLeftApplication();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzdw.1.4 */
        class C08064 implements zza {
            final /* synthetic */ C10051 zzAd;

            C08064(C10051 c10051) {
                this.zzAd = c10051;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzpK != null) {
                    com_google_android_gms_internal_zzdx.zzpK.onAdLoaded();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzdw.1.5 */
        class C08075 implements zza {
            final /* synthetic */ C10051 zzAd;

            C08075(C10051 c10051) {
                this.zzAd = c10051;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzpK != null) {
                    com_google_android_gms_internal_zzdx.zzpK.onAdOpened();
                }
            }
        }

        C10051(zzdw com_google_android_gms_internal_zzdw) {
            this.zzAc = com_google_android_gms_internal_zzdw;
        }

        public void onAdClosed() throws RemoteException {
            this.zzAc.zzpH.add(new C08031(this));
        }

        public void onAdFailedToLoad(int errorCode) throws RemoteException {
            this.zzAc.zzpH.add(new C08042(this, errorCode));
            zzin.m27v("Pooled interstitial failed to load.");
        }

        public void onAdLeftApplication() throws RemoteException {
            this.zzAc.zzpH.add(new C08053(this));
        }

        public void onAdLoaded() throws RemoteException {
            this.zzAc.zzpH.add(new C08064(this));
            zzin.m27v("Pooled interstitial loaded.");
        }

        public void onAdOpened() throws RemoteException {
            this.zzAc.zzpH.add(new C08075(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdw.2 */
    class C10062 extends com.google.android.gms.ads.internal.client.zzw.zza {
        final /* synthetic */ zzdw zzAc;

        /* renamed from: com.google.android.gms.internal.zzdw.2.1 */
        class C08081 implements zza {
            final /* synthetic */ String val$name;
            final /* synthetic */ String zzAf;
            final /* synthetic */ C10062 zzAg;

            C08081(C10062 c10062, String str, String str2) {
                this.zzAg = c10062;
                this.val$name = str;
                this.zzAf = str2;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAq != null) {
                    com_google_android_gms_internal_zzdx.zzAq.onAppEvent(this.val$name, this.zzAf);
                }
            }
        }

        C10062(zzdw com_google_android_gms_internal_zzdw) {
            this.zzAc = com_google_android_gms_internal_zzdw;
        }

        public void onAppEvent(String name, String info) throws RemoteException {
            this.zzAc.zzpH.add(new C08081(this, name, info));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdw.3 */
    class C10073 extends com.google.android.gms.internal.zzgd.zza {
        final /* synthetic */ zzdw zzAc;

        /* renamed from: com.google.android.gms.internal.zzdw.3.1 */
        class C08091 implements zza {
            final /* synthetic */ zzgc zzAh;
            final /* synthetic */ C10073 zzAi;

            C08091(C10073 c10073, zzgc com_google_android_gms_internal_zzgc) {
                this.zzAi = c10073;
                this.zzAh = com_google_android_gms_internal_zzgc;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAr != null) {
                    com_google_android_gms_internal_zzdx.zzAr.zza(this.zzAh);
                }
            }
        }

        C10073(zzdw com_google_android_gms_internal_zzdw) {
            this.zzAc = com_google_android_gms_internal_zzdw;
        }

        public void zza(zzgc com_google_android_gms_internal_zzgc) throws RemoteException {
            this.zzAc.zzpH.add(new C08091(this, com_google_android_gms_internal_zzgc));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdw.4 */
    class C10084 extends com.google.android.gms.internal.zzcf.zza {
        final /* synthetic */ zzdw zzAc;

        /* renamed from: com.google.android.gms.internal.zzdw.4.1 */
        class C08101 implements zza {
            final /* synthetic */ zzce zzAj;
            final /* synthetic */ C10084 zzAk;

            C08101(C10084 c10084, zzce com_google_android_gms_internal_zzce) {
                this.zzAk = c10084;
                this.zzAj = com_google_android_gms_internal_zzce;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAs != null) {
                    com_google_android_gms_internal_zzdx.zzAs.zza(this.zzAj);
                }
            }
        }

        C10084(zzdw com_google_android_gms_internal_zzdw) {
            this.zzAc = com_google_android_gms_internal_zzdw;
        }

        public void zza(zzce com_google_android_gms_internal_zzce) throws RemoteException {
            this.zzAc.zzpH.add(new C08101(this, com_google_android_gms_internal_zzce));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdw.5 */
    class C10095 extends com.google.android.gms.ads.internal.client.zzp.zza {
        final /* synthetic */ zzdw zzAc;

        /* renamed from: com.google.android.gms.internal.zzdw.5.1 */
        class C08111 implements zza {
            final /* synthetic */ C10095 zzAl;

            C08111(C10095 c10095) {
                this.zzAl = c10095;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAt != null) {
                    com_google_android_gms_internal_zzdx.zzAt.onAdClicked();
                }
            }
        }

        C10095(zzdw com_google_android_gms_internal_zzdw) {
            this.zzAc = com_google_android_gms_internal_zzdw;
        }

        public void onAdClicked() throws RemoteException {
            this.zzAc.zzpH.add(new C08111(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdw.6 */
    class C10106 extends com.google.android.gms.ads.internal.reward.client.zzd.zza {
        final /* synthetic */ zzdw zzAc;

        /* renamed from: com.google.android.gms.internal.zzdw.6.1 */
        class C08121 implements zza {
            final /* synthetic */ C10106 zzAm;

            C08121(C10106 c10106) {
                this.zzAm = c10106;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAu != null) {
                    com_google_android_gms_internal_zzdx.zzAu.onRewardedVideoAdLoaded();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzdw.6.2 */
        class C08132 implements zza {
            final /* synthetic */ C10106 zzAm;

            C08132(C10106 c10106) {
                this.zzAm = c10106;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAu != null) {
                    com_google_android_gms_internal_zzdx.zzAu.onRewardedVideoAdOpened();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzdw.6.3 */
        class C08143 implements zza {
            final /* synthetic */ C10106 zzAm;

            C08143(C10106 c10106) {
                this.zzAm = c10106;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAu != null) {
                    com_google_android_gms_internal_zzdx.zzAu.onRewardedVideoStarted();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzdw.6.4 */
        class C08154 implements zza {
            final /* synthetic */ C10106 zzAm;

            C08154(C10106 c10106) {
                this.zzAm = c10106;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAu != null) {
                    com_google_android_gms_internal_zzdx.zzAu.onRewardedVideoAdClosed();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzdw.6.5 */
        class C08165 implements zza {
            final /* synthetic */ C10106 zzAm;
            final /* synthetic */ com.google.android.gms.ads.internal.reward.client.zza zzAn;

            C08165(C10106 c10106, com.google.android.gms.ads.internal.reward.client.zza com_google_android_gms_ads_internal_reward_client_zza) {
                this.zzAm = c10106;
                this.zzAn = com_google_android_gms_ads_internal_reward_client_zza;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAu != null) {
                    com_google_android_gms_internal_zzdx.zzAu.zza(this.zzAn);
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzdw.6.6 */
        class C08176 implements zza {
            final /* synthetic */ C10106 zzAm;

            C08176(C10106 c10106) {
                this.zzAm = c10106;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAu != null) {
                    com_google_android_gms_internal_zzdx.zzAu.onRewardedVideoAdLeftApplication();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzdw.6.7 */
        class C08187 implements zza {
            final /* synthetic */ int zzAe;
            final /* synthetic */ C10106 zzAm;

            C08187(C10106 c10106, int i) {
                this.zzAm = c10106;
                this.zzAe = i;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAu != null) {
                    com_google_android_gms_internal_zzdx.zzAu.onRewardedVideoAdFailedToLoad(this.zzAe);
                }
            }
        }

        C10106(zzdw com_google_android_gms_internal_zzdw) {
            this.zzAc = com_google_android_gms_internal_zzdw;
        }

        public void onRewardedVideoAdClosed() throws RemoteException {
            this.zzAc.zzpH.add(new C08154(this));
        }

        public void onRewardedVideoAdFailedToLoad(int errorCode) throws RemoteException {
            this.zzAc.zzpH.add(new C08187(this, errorCode));
        }

        public void onRewardedVideoAdLeftApplication() throws RemoteException {
            this.zzAc.zzpH.add(new C08176(this));
        }

        public void onRewardedVideoAdLoaded() throws RemoteException {
            this.zzAc.zzpH.add(new C08121(this));
        }

        public void onRewardedVideoAdOpened() throws RemoteException {
            this.zzAc.zzpH.add(new C08132(this));
        }

        public void onRewardedVideoStarted() throws RemoteException {
            this.zzAc.zzpH.add(new C08143(this));
        }

        public void zza(com.google.android.gms.ads.internal.reward.client.zza com_google_android_gms_ads_internal_reward_client_zza) throws RemoteException {
            this.zzAc.zzpH.add(new C08165(this, com_google_android_gms_ads_internal_reward_client_zza));
        }
    }

    zzdw() {
        this.zzpH = new LinkedList();
    }

    void zza(zzdx com_google_android_gms_internal_zzdx) {
        Handler handler = zzir.zzMc;
        for (zza c03957 : this.zzpH) {
            handler.post(new C03957(this, c03957, com_google_android_gms_internal_zzdx));
        }
    }

    void zzc(zzk com_google_android_gms_ads_internal_zzk) {
        com_google_android_gms_ads_internal_zzk.zza(new C10051(this));
        com_google_android_gms_ads_internal_zzk.zza(new C10062(this));
        com_google_android_gms_ads_internal_zzk.zza(new C10073(this));
        com_google_android_gms_ads_internal_zzk.zza(new C10084(this));
        com_google_android_gms_ads_internal_zzk.zza(new C10095(this));
        com_google_android_gms_ads_internal_zzk.zza(new C10106(this));
    }
}
