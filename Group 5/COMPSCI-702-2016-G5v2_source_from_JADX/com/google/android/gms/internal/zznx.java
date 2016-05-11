package com.google.android.gms.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class zznx {
    private static final double zzazE;
    private static final double zzazF;
    private static final zznx zzazI;
    private final Map<String, Map<String, zza>> zzazG;
    private final Map<String, zza> zzazH;

    public static class zza {
        private final double zzazJ;
        private final double zzazK;

        private zza(double d, double d2) {
            this.zzazJ = d;
            this.zzazK = d2;
        }

        public boolean zzh(double d) {
            return d >= this.zzazJ && d <= this.zzazK;
        }
    }

    static {
        zzazE = 1000.0d / ((double) TimeUnit.SECONDS.toNanos(1));
        zzazF = 1000.0d / ((double) TimeUnit.SECONDS.toNanos(1));
        zzazI = new zznx();
    }

    private zznx() {
        Map hashMap = new HashMap();
        hashMap.put(zznt.zzaxF.name, new zza(90.0d, null));
        hashMap.put(zznt.zzaxG.name, new zza(180.0d, null));
        hashMap.put(zznt.zzaxH.name, new zza(10000.0d, null));
        hashMap.put(zznt.zzaxE.name, new zza(1000.0d, null));
        hashMap.put(zznt.zzaxI.name, new zza(100000.0d, null));
        hashMap.put(zznt.zzaxP.name, new zza(100.0d, null));
        hashMap.put(zznt.zzaxx.name, new zza(100.0d, null));
        hashMap.put(zznt.zzaxA.name, new zza(9.223372036854776E18d, null));
        hashMap.put(zznt.zzaxM.name, new zza(10.0d, null));
        hashMap.put(zznt.zzaxN.name, new zza(1000.0d, null));
        hashMap.put(zznt.zzaxQ.name, new zza(200000.0d, null));
        this.zzazH = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap();
        hashMap.put("com.google.step_count.delta", zzf(zznt.zzaxz.name, new zza(zzazE, null)));
        hashMap.put("com.google.calories.consumed", zzf(zznt.zzaxT.name, new zza(zzazF, null)));
        hashMap.put("com.google.calories.expended", zzf(zznt.zzaxT.name, new zza(zzazF, null)));
        this.zzazG = Collections.unmodifiableMap(hashMap);
    }

    private static <K, V> Map<K, V> zzf(K k, V v) {
        Map<K, V> hashMap = new HashMap();
        hashMap.put(k, v);
        return hashMap;
    }

    public static zznx zzuG() {
        return zzazI;
    }

    public zza zzC(String str, String str2) {
        Map map = (Map) this.zzazG.get(str);
        return map != null ? (zza) map.get(str2) : null;
    }

    public zza zzdE(String str) {
        return (zza) this.zzazH.get(str);
    }
}
