package com.google.android.gms.iid;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.MotionEventCompat;
import android.util.Base64;
import android.util.Log;
import com.woop.tryreverseengineerthis.BuildConfig;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class InstanceID {
    public static final String ERROR_BACKOFF = "RETRY_LATER";
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_MISSING_INSTANCEID_SERVICE = "MISSING_INSTANCEID_SERVICE";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String ERROR_TIMEOUT = "TIMEOUT";
    static Map<String, InstanceID> zzaMP;
    private static zzd zzaMQ;
    private static zzc zzaMR;
    static String zzaMV;
    Context mContext;
    KeyPair zzaMS;
    String zzaMT;
    long zzaMU;

    static {
        zzaMP = new HashMap();
    }

    protected InstanceID(Context context, String subtype, Bundle options) {
        this.zzaMT = BuildConfig.FLAVOR;
        this.mContext = context.getApplicationContext();
        this.zzaMT = subtype;
    }

    public static InstanceID getInstance(Context context) {
        return zza(context, null);
    }

    public static synchronized InstanceID zza(Context context, Bundle bundle) {
        InstanceID instanceID;
        synchronized (InstanceID.class) {
            String string = bundle == null ? BuildConfig.FLAVOR : bundle.getString("subtype");
            String str = string == null ? BuildConfig.FLAVOR : string;
            Context applicationContext = context.getApplicationContext();
            if (zzaMQ == null) {
                zzaMQ = new zzd(applicationContext);
                zzaMR = new zzc(applicationContext);
            }
            zzaMV = Integer.toString(zzaL(applicationContext));
            instanceID = (InstanceID) zzaMP.get(str);
            if (instanceID == null) {
                instanceID = new InstanceID(applicationContext, str, bundle);
                zzaMP.put(str, instanceID);
            }
        }
        return instanceID;
    }

    static String zza(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & MotionEventCompat.ACTION_MASK);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("InstanceID", "Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    static int zzaL(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("InstanceID", "Never happens: can't find own package " + e);
            return i;
        }
    }

    static String zzn(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    public void deleteInstanceID() throws IOException {
        zzb("*", "*", null);
        zzyA();
    }

    public void deleteToken(String authorizedEntity, String scope) throws IOException {
        zzb(authorizedEntity, scope, null);
    }

    public long getCreationTime() {
        if (this.zzaMU == 0) {
            String str = zzaMQ.get(this.zzaMT, "cre");
            if (str != null) {
                this.zzaMU = Long.parseLong(str);
            }
        }
        return this.zzaMU;
    }

    public String getId() {
        return zza(zzyz());
    }

    public String getToken(String authorizedEntity, String scope) throws IOException {
        return getToken(authorizedEntity, scope, null);
    }

    public String getToken(String authorizedEntity, String scope, Bundle extras) throws IOException {
        Object obj = null;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException(ERROR_MAIN_THREAD);
        }
        Object obj2 = 1;
        String zzi = zzyD() ? null : zzaMQ.zzi(this.zzaMT, authorizedEntity, scope);
        if (zzi == null) {
            if (extras == null) {
                extras = new Bundle();
            }
            if (extras.getString("ttl") != null) {
                obj2 = null;
            }
            if (!"jwt".equals(extras.getString("type"))) {
                obj = obj2;
            }
            zzi = zzc(authorizedEntity, scope, extras);
            Log.w("InstanceID", "token: " + zzi);
            if (!(zzi == null || r1 == null)) {
                zzaMQ.zza(this.zzaMT, authorizedEntity, scope, zzi, zzaMV);
            }
        }
        return zzi;
    }

    public void zzb(String str, String str2, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException(ERROR_MAIN_THREAD);
        }
        zzaMQ.zzj(this.zzaMT, str, str2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("sender", str);
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("subscription", str);
        bundle.putString("delete", "1");
        bundle.putString("X-delete", "1");
        bundle.putString("subtype", BuildConfig.FLAVOR.equals(this.zzaMT) ? str : this.zzaMT);
        String str3 = "X-subtype";
        if (!BuildConfig.FLAVOR.equals(this.zzaMT)) {
            str = this.zzaMT;
        }
        bundle.putString(str3, str);
        zzaMR.zzu(zzaMR.zza(bundle, zzyz()));
    }

    public String zzc(String str, String str2, Bundle bundle) throws IOException {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        String str3 = BuildConfig.FLAVOR.equals(this.zzaMT) ? str : this.zzaMT;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        return zzaMR.zzu(zzaMR.zza(bundle, zzyz()));
    }

    void zzyA() {
        this.zzaMU = 0;
        zzaMQ.zzee(this.zzaMT);
        this.zzaMS = null;
    }

    public zzd zzyB() {
        return zzaMQ;
    }

    zzc zzyC() {
        return zzaMR;
    }

    boolean zzyD() {
        String str = zzaMQ.get("appVersion");
        if (str == null || !str.equals(zzaMV)) {
            return true;
        }
        str = zzaMQ.get("lastToken");
        if (str == null) {
            return true;
        }
        return (System.currentTimeMillis() / 1000) - Long.valueOf(Long.parseLong(str)).longValue() > 604800;
    }

    KeyPair zzyz() {
        if (this.zzaMS == null) {
            this.zzaMS = zzaMQ.zzed(this.zzaMT);
        }
        if (this.zzaMS == null) {
            this.zzaMU = System.currentTimeMillis();
            this.zzaMS = zzaMQ.zzd(this.zzaMT, this.zzaMU);
        }
        return this.zzaMS;
    }
}
