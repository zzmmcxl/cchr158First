package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.WearableStatusCodes;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

final class zzay<T> {
    private final Map<T, zzbq<T>> zzaxd;

    private static class zza<T> extends zzb<Status> {
        private WeakReference<Map<T, zzbq<T>>> zzbsM;
        private WeakReference<T> zzbsN;

        zza(Map<T, zzbq<T>> map, T t, com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status);
            this.zzbsM = new WeakReference(map);
            this.zzbsN = new WeakReference(t);
        }

        public void zza(Status status) {
            Map map = (Map) this.zzbsM.get();
            Object obj = this.zzbsN.get();
            if (!(status.getStatus().isSuccess() || map == null || obj == null)) {
                synchronized (map) {
                    zzbq com_google_android_gms_wearable_internal_zzbq = (zzbq) map.remove(obj);
                    if (com_google_android_gms_wearable_internal_zzbq != null) {
                        com_google_android_gms_wearable_internal_zzbq.clear();
                    }
                }
            }
            zzX(status);
        }
    }

    private static class zzb<T> extends zzb<Status> {
        private WeakReference<Map<T, zzbq<T>>> zzbsM;
        private WeakReference<T> zzbsN;

        zzb(Map<T, zzbq<T>> map, T t, com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status);
            this.zzbsM = new WeakReference(map);
            this.zzbsN = new WeakReference(t);
        }

        public void zza(Status status) {
            Map map = (Map) this.zzbsM.get();
            Object obj = this.zzbsN.get();
            if (!(status.getStatus().getStatusCode() != WearableStatusCodes.UNKNOWN_LISTENER || map == null || obj == null)) {
                synchronized (map) {
                    zzbq com_google_android_gms_wearable_internal_zzbq = (zzbq) map.remove(obj);
                    if (com_google_android_gms_wearable_internal_zzbq != null) {
                        com_google_android_gms_wearable_internal_zzbq.clear();
                    }
                }
            }
            zzX(status);
        }
    }

    zzay() {
        this.zzaxd = new HashMap();
    }

    public void zza(zzbp com_google_android_gms_wearable_internal_zzbp, com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, T t) throws RemoteException {
        synchronized (this.zzaxd) {
            zzbq com_google_android_gms_wearable_internal_zzbq = (zzbq) this.zzaxd.remove(t);
            if (com_google_android_gms_wearable_internal_zzbq == null) {
                com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status.zzs(new Status(WearableStatusCodes.UNKNOWN_LISTENER));
                return;
            }
            com_google_android_gms_wearable_internal_zzbq.clear();
            ((zzax) com_google_android_gms_wearable_internal_zzbp.zzqJ()).zza(new zzb(this.zzaxd, t, com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status), new RemoveListenerRequest(com_google_android_gms_wearable_internal_zzbq));
        }
    }

    public void zza(zzbp com_google_android_gms_wearable_internal_zzbp, com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, T t, zzbq<T> com_google_android_gms_wearable_internal_zzbq_T) throws RemoteException {
        synchronized (this.zzaxd) {
            if (this.zzaxd.get(t) != null) {
                com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status.zzs(new Status(WearableStatusCodes.DUPLICATE_LISTENER));
                return;
            }
            this.zzaxd.put(t, com_google_android_gms_wearable_internal_zzbq_T);
            try {
                ((zzax) com_google_android_gms_wearable_internal_zzbp.zzqJ()).zza(new zza(this.zzaxd, t, com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status), new AddListenerRequest(com_google_android_gms_wearable_internal_zzbq_T));
            } catch (RemoteException e) {
                this.zzaxd.remove(t);
                throw e;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzev(android.os.IBinder r10) {
        /*
        r9 = this;
        r2 = r9.zzaxd;
        monitor-enter(r2);
        r3 = com.google.android.gms.wearable.internal.zzax.zza.zzeu(r10);	 Catch:{ all -> 0x0088 }
        r4 = new com.google.android.gms.wearable.internal.zzbo$zzo;	 Catch:{ all -> 0x0088 }
        r4.<init>();	 Catch:{ all -> 0x0088 }
        r0 = r9.zzaxd;	 Catch:{ all -> 0x0088 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0088 }
        r5 = r0.iterator();	 Catch:{ all -> 0x0088 }
    L_0x0016:
        r0 = r5.hasNext();	 Catch:{ all -> 0x0088 }
        if (r0 == 0) goto L_0x008b;
    L_0x001c:
        r0 = r5.next();	 Catch:{ all -> 0x0088 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x0088 }
        r1 = r0.getValue();	 Catch:{ all -> 0x0088 }
        r1 = (com.google.android.gms.wearable.internal.zzbq) r1;	 Catch:{ all -> 0x0088 }
        r6 = new com.google.android.gms.wearable.internal.AddListenerRequest;	 Catch:{ RemoteException -> 0x0060 }
        r6.<init>(r1);	 Catch:{ RemoteException -> 0x0060 }
        r3.zza(r4, r6);	 Catch:{ RemoteException -> 0x0060 }
        r6 = "WearableClient";
        r7 = 2;
        r6 = android.util.Log.isLoggable(r6, r7);	 Catch:{ RemoteException -> 0x0060 }
        if (r6 == 0) goto L_0x0016;
    L_0x0039:
        r6 = "WearableClient";
        r7 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x0060 }
        r7.<init>();	 Catch:{ RemoteException -> 0x0060 }
        r8 = "onPostInitHandler: added: ";
        r7 = r7.append(r8);	 Catch:{ RemoteException -> 0x0060 }
        r8 = r0.getKey();	 Catch:{ RemoteException -> 0x0060 }
        r7 = r7.append(r8);	 Catch:{ RemoteException -> 0x0060 }
        r8 = "/";
        r7 = r7.append(r8);	 Catch:{ RemoteException -> 0x0060 }
        r7 = r7.append(r1);	 Catch:{ RemoteException -> 0x0060 }
        r7 = r7.toString();	 Catch:{ RemoteException -> 0x0060 }
        android.util.Log.d(r6, r7);	 Catch:{ RemoteException -> 0x0060 }
        goto L_0x0016;
    L_0x0060:
        r6 = move-exception;
        r6 = "WearableClient";
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0088 }
        r7.<init>();	 Catch:{ all -> 0x0088 }
        r8 = "onPostInitHandler: Didn't add: ";
        r7 = r7.append(r8);	 Catch:{ all -> 0x0088 }
        r0 = r0.getKey();	 Catch:{ all -> 0x0088 }
        r0 = r7.append(r0);	 Catch:{ all -> 0x0088 }
        r7 = "/";
        r0 = r0.append(r7);	 Catch:{ all -> 0x0088 }
        r0 = r0.append(r1);	 Catch:{ all -> 0x0088 }
        r0 = r0.toString();	 Catch:{ all -> 0x0088 }
        android.util.Log.d(r6, r0);	 Catch:{ all -> 0x0088 }
        goto L_0x0016;
    L_0x0088:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0088 }
        throw r0;
    L_0x008b:
        monitor-exit(r2);	 Catch:{ all -> 0x0088 }
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.zzay.zzev(android.os.IBinder):void");
    }
}
