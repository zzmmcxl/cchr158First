package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.woop.tryreverseengineerthis.BuildConfig;
import java.util.concurrent.Future;

@zzhb
public final class zzip {

    public interface zzb {
        void zze(Bundle bundle);
    }

    private static abstract class zza extends zzim {
        private zza() {
        }

        public void onStop() {
        }
    }

    /* renamed from: com.google.android.gms.internal.zzip.1 */
    static class C10471 extends zza {
        final /* synthetic */ boolean zzLP;
        final /* synthetic */ Context zzxh;

        C10471(Context context, boolean z) {
            this.zzxh = context;
            this.zzLP = z;
            super();
        }

        public void zzbr() {
            Editor edit = zzip.zzw(this.zzxh).edit();
            edit.putBoolean("use_https", this.zzLP);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzip.2 */
    static class C10482 extends zza {
        final /* synthetic */ zzb zzLQ;
        final /* synthetic */ Context zzxh;

        C10482(Context context, zzb com_google_android_gms_internal_zzip_zzb) {
            this.zzxh = context;
            this.zzLQ = com_google_android_gms_internal_zzip_zzb;
            super();
        }

        public void zzbr() {
            SharedPreferences zzw = zzip.zzw(this.zzxh);
            Bundle bundle = new Bundle();
            bundle.putBoolean("use_https", zzw.getBoolean("use_https", true));
            if (this.zzLQ != null) {
                this.zzLQ.zze(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzip.3 */
    static class C10493 extends zza {
        final /* synthetic */ int zzLR;
        final /* synthetic */ Context zzxh;

        C10493(Context context, int i) {
            this.zzxh = context;
            this.zzLR = i;
            super();
        }

        public void zzbr() {
            Editor edit = zzip.zzw(this.zzxh).edit();
            edit.putInt("webview_cache_version", this.zzLR);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzip.4 */
    static class C10504 extends zza {
        final /* synthetic */ zzb zzLQ;
        final /* synthetic */ Context zzxh;

        C10504(Context context, zzb com_google_android_gms_internal_zzip_zzb) {
            this.zzxh = context;
            this.zzLQ = com_google_android_gms_internal_zzip_zzb;
            super();
        }

        public void zzbr() {
            SharedPreferences zzw = zzip.zzw(this.zzxh);
            Bundle bundle = new Bundle();
            bundle.putInt("webview_cache_version", zzw.getInt("webview_cache_version", 0));
            if (this.zzLQ != null) {
                this.zzLQ.zze(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzip.5 */
    static class C10515 extends zza {
        final /* synthetic */ boolean zzLS;
        final /* synthetic */ Context zzxh;

        C10515(Context context, boolean z) {
            this.zzxh = context;
            this.zzLS = z;
            super();
        }

        public void zzbr() {
            Editor edit = zzip.zzw(this.zzxh).edit();
            edit.putBoolean("content_url_opted_out", this.zzLS);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzip.6 */
    static class C10526 extends zza {
        final /* synthetic */ zzb zzLQ;
        final /* synthetic */ Context zzxh;

        C10526(Context context, zzb com_google_android_gms_internal_zzip_zzb) {
            this.zzxh = context;
            this.zzLQ = com_google_android_gms_internal_zzip_zzb;
            super();
        }

        public void zzbr() {
            SharedPreferences zzw = zzip.zzw(this.zzxh);
            Bundle bundle = new Bundle();
            bundle.putBoolean("content_url_opted_out", zzw.getBoolean("content_url_opted_out", true));
            if (this.zzLQ != null) {
                this.zzLQ.zze(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzip.7 */
    static class C10537 extends zza {
        final /* synthetic */ String zzLT;
        final /* synthetic */ Context zzxh;

        C10537(Context context, String str) {
            this.zzxh = context;
            this.zzLT = str;
            super();
        }

        public void zzbr() {
            Editor edit = zzip.zzw(this.zzxh).edit();
            edit.putString("content_url_hashes", this.zzLT);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzip.8 */
    static class C10548 extends zza {
        final /* synthetic */ zzb zzLQ;
        final /* synthetic */ Context zzxh;

        C10548(Context context, zzb com_google_android_gms_internal_zzip_zzb) {
            this.zzxh = context;
            this.zzLQ = com_google_android_gms_internal_zzip_zzb;
            super();
        }

        public void zzbr() {
            SharedPreferences zzw = zzip.zzw(this.zzxh);
            Bundle bundle = new Bundle();
            bundle.putString("content_url_hashes", zzw.getString("content_url_hashes", BuildConfig.FLAVOR));
            if (this.zzLQ != null) {
                this.zzLQ.zze(bundle);
            }
        }
    }

    public static Future zza(Context context, int i) {
        return new C10493(context, i).zzhn();
    }

    public static Future zza(Context context, zzb com_google_android_gms_internal_zzip_zzb) {
        return new C10482(context, com_google_android_gms_internal_zzip_zzb).zzhn();
    }

    public static Future zza(Context context, boolean z) {
        return new C10471(context, z).zzhn();
    }

    public static Future zzb(Context context, zzb com_google_android_gms_internal_zzip_zzb) {
        return new C10504(context, com_google_android_gms_internal_zzip_zzb).zzhn();
    }

    public static Future zzb(Context context, boolean z) {
        return new C10515(context, z).zzhn();
    }

    public static Future zzc(Context context, zzb com_google_android_gms_internal_zzip_zzb) {
        return new C10526(context, com_google_android_gms_internal_zzip_zzb).zzhn();
    }

    public static Future zzd(Context context, zzb com_google_android_gms_internal_zzip_zzb) {
        return new C10548(context, com_google_android_gms_internal_zzip_zzb).zzhn();
    }

    public static Future zzd(Context context, String str) {
        return new C10537(context, str).zzhn();
    }

    public static SharedPreferences zzw(Context context) {
        return context.getSharedPreferences("admob", 0);
    }
}
