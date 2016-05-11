package com.google.android.gms.internal;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzr;

@zzhb
public abstract class zzbp<T> {
    private final int zzvr;
    private final String zzvs;
    private final T zzvt;

    /* renamed from: com.google.android.gms.internal.zzbp.1 */
    static class C07871 extends zzbp<Boolean> {
        C07871(int i, String str, Boolean bool) {
            super(str, bool, null);
        }

        public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
            return zzb(sharedPreferences);
        }

        public Boolean zzb(SharedPreferences sharedPreferences) {
            return Boolean.valueOf(sharedPreferences.getBoolean(getKey(), ((Boolean) zzdq()).booleanValue()));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbp.2 */
    static class C07882 extends zzbp<Integer> {
        C07882(int i, String str, Integer num) {
            super(str, num, null);
        }

        public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
            return zzc(sharedPreferences);
        }

        public Integer zzc(SharedPreferences sharedPreferences) {
            return Integer.valueOf(sharedPreferences.getInt(getKey(), ((Integer) zzdq()).intValue()));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbp.3 */
    static class C07893 extends zzbp<Long> {
        C07893(int i, String str, Long l) {
            super(str, l, null);
        }

        public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
            return zzd(sharedPreferences);
        }

        public Long zzd(SharedPreferences sharedPreferences) {
            return Long.valueOf(sharedPreferences.getLong(getKey(), ((Long) zzdq()).longValue()));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbp.4 */
    static class C07904 extends zzbp<String> {
        C07904(int i, String str, String str2) {
            super(str, str2, null);
        }

        public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
            return zze(sharedPreferences);
        }

        public String zze(SharedPreferences sharedPreferences) {
            return sharedPreferences.getString(getKey(), (String) zzdq());
        }
    }

    private zzbp(int i, String str, T t) {
        this.zzvr = i;
        this.zzvs = str;
        this.zzvt = t;
        zzr.zzbK().zza(this);
    }

    public static zzbp<String> zza(int i, String str) {
        zzbp<String> zza = zza(i, str, (String) null);
        zzr.zzbK().zzb(zza);
        return zza;
    }

    public static zzbp<Integer> zza(int i, String str, int i2) {
        return new C07882(i, str, Integer.valueOf(i2));
    }

    public static zzbp<Long> zza(int i, String str, long j) {
        return new C07893(i, str, Long.valueOf(j));
    }

    public static zzbp<Boolean> zza(int i, String str, Boolean bool) {
        return new C07871(i, str, bool);
    }

    public static zzbp<String> zza(int i, String str, String str2) {
        return new C07904(i, str, str2);
    }

    public static zzbp<String> zzb(int i, String str) {
        zzbp<String> zza = zza(i, str, (String) null);
        zzr.zzbK().zzc(zza);
        return zza;
    }

    public T get() {
        return zzr.zzbL().zzd(this);
    }

    public String getKey() {
        return this.zzvs;
    }

    protected abstract T zza(SharedPreferences sharedPreferences);

    public T zzdq() {
        return this.zzvt;
    }
}
