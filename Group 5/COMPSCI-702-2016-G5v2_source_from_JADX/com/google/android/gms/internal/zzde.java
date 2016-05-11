package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public final class zzde {
    public static final zzdf zzyX;
    public static final zzdf zzyY;
    public static final zzdf zzyZ;
    public static final zzdf zzza;
    public static final zzdf zzzb;
    public static final zzdf zzzc;
    public static final zzdf zzzd;
    public static final zzdf zzze;
    public static final zzdf zzzf;
    public static final zzdf zzzg;
    public static final zzdf zzzh;
    public static final zzdf zzzi;
    public static final zzdf zzzj;
    public static final zzdf zzzk;

    /* renamed from: com.google.android.gms.internal.zzde.1 */
    static class C07941 implements zzdf {
        C07941() {
        }

        public void zza(zzjp com_google_android_gms_internal_zzjp, Map<String, String> map) {
        }
    }

    /* renamed from: com.google.android.gms.internal.zzde.2 */
    static class C07952 implements zzdf {
        C07952() {
        }

        public void zza(zzjp com_google_android_gms_internal_zzjp, Map<String, String> map) {
            String str = (String) map.get("ty");
            String str2 = (String) map.get("td");
            try {
                int parseInt = Integer.parseInt((String) map.get("tx"));
                int parseInt2 = Integer.parseInt(str);
                int parseInt3 = Integer.parseInt(str2);
                zzan zzhW = com_google_android_gms_internal_zzjp.zzhW();
                if (zzhW != null) {
                    zzhW.zzab().zza(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                zzb.zzaK("Could not parse touch parameters from gmsg.");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzde.3 */
    static class C07963 implements zzdf {
        C07963() {
        }

        public void zza(zzjp com_google_android_gms_internal_zzjp, Map<String, String> map) {
            if (((Boolean) zzbt.zzwT.get()).booleanValue()) {
                com_google_android_gms_internal_zzjp.zzF(!Boolean.parseBoolean((String) map.get("disabled")));
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzde.4 */
    static class C07974 implements zzdf {
        C07974() {
        }

        public void zza(zzjp com_google_android_gms_internal_zzjp, Map<String, String> map) {
            String str = (String) map.get("urls");
            if (TextUtils.isEmpty(str)) {
                zzb.zzaK("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            Map hashMap = new HashMap();
            PackageManager packageManager = com_google_android_gms_internal_zzjp.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), ExecutionOptions.MAX_TRACKING_TAG_STRING_LENGTH) != null));
            }
            com_google_android_gms_internal_zzjp.zza("openableURLs", hashMap);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzde.5 */
    static class C07985 implements zzdf {
        C07985() {
        }

        public void zza(zzjp com_google_android_gms_internal_zzjp, Map<String, String> map) {
            PackageManager packageManager = com_google_android_gms_internal_zzjp.getContext().getPackageManager();
            try {
                try {
                    JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                    JSONObject jSONObject = new JSONObject();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("id");
                            Object optString2 = jSONObject2.optString("u");
                            Object optString3 = jSONObject2.optString("i");
                            Object optString4 = jSONObject2.optString("m");
                            Object optString5 = jSONObject2.optString("p");
                            Object optString6 = jSONObject2.optString("c");
                            jSONObject2.optString("f");
                            jSONObject2.optString("e");
                            Intent intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                            try {
                                jSONObject.put(optString, packageManager.resolveActivity(intent, ExecutionOptions.MAX_TRACKING_TAG_STRING_LENGTH) != null);
                            } catch (Throwable e) {
                                zzb.zzb("Error constructing openable urls response.", e);
                            }
                        } catch (Throwable e2) {
                            zzb.zzb("Error parsing the intent data.", e2);
                        }
                    }
                    com_google_android_gms_internal_zzjp.zzb("openableIntents", jSONObject);
                } catch (JSONException e3) {
                    com_google_android_gms_internal_zzjp.zzb("openableIntents", new JSONObject());
                }
            } catch (JSONException e4) {
                com_google_android_gms_internal_zzjp.zzb("openableIntents", new JSONObject());
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzde.6 */
    static class C07996 implements zzdf {
        C07996() {
        }

        public void zza(zzjp com_google_android_gms_internal_zzjp, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                zzb.zzaK("URL missing from click GMSG.");
                return;
            }
            Uri zza;
            Uri parse = Uri.parse(str);
            try {
                zzan zzhW = com_google_android_gms_internal_zzjp.zzhW();
                if (zzhW != null && zzhW.zzb(parse)) {
                    zza = zzhW.zza(parse, com_google_android_gms_internal_zzjp.getContext());
                    new zziy(com_google_android_gms_internal_zzjp.getContext(), com_google_android_gms_internal_zzjp.zzhX().afmaVersion, zza.toString()).zzhn();
                }
            } catch (zzao e) {
                zzb.zzaK("Unable to append parameter to URL: " + str);
            }
            zza = parse;
            new zziy(com_google_android_gms_internal_zzjp.getContext(), com_google_android_gms_internal_zzjp.zzhX().afmaVersion, zza.toString()).zzhn();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzde.7 */
    static class C08007 implements zzdf {
        C08007() {
        }

        public void zza(zzjp com_google_android_gms_internal_zzjp, Map<String, String> map) {
            zzd zzhS = com_google_android_gms_internal_zzjp.zzhS();
            if (zzhS != null) {
                zzhS.close();
                return;
            }
            zzhS = com_google_android_gms_internal_zzjp.zzhT();
            if (zzhS != null) {
                zzhS.close();
            } else {
                zzb.zzaK("A GMSG tried to close something that wasn't an overlay.");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzde.8 */
    static class C08018 implements zzdf {
        C08018() {
        }

        private void zzc(zzjp com_google_android_gms_internal_zzjp) {
            zzb.zzaJ("Received support message, responding.");
            boolean z = false;
            com.google.android.gms.ads.internal.zzd zzhR = com_google_android_gms_internal_zzjp.zzhR();
            if (zzhR != null) {
                zzm com_google_android_gms_ads_internal_overlay_zzm = zzhR.zzpy;
                if (com_google_android_gms_ads_internal_overlay_zzm != null) {
                    z = com_google_android_gms_ads_internal_overlay_zzm.zzfM();
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(DataLayer.EVENT_KEY, "checkSupport");
                jSONObject.put("supports", z);
                com_google_android_gms_internal_zzjp.zzb("appStreaming", jSONObject);
            } catch (Throwable th) {
            }
        }

        public void zza(zzjp com_google_android_gms_internal_zzjp, Map<String, String> map) {
            if ("checkSupport".equals(map.get("action"))) {
                zzc(com_google_android_gms_internal_zzjp);
                return;
            }
            zzd zzhS = com_google_android_gms_internal_zzjp.zzhS();
            if (zzhS != null) {
                zzhS.zzg(com_google_android_gms_internal_zzjp, map);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzde.9 */
    static class C08029 implements zzdf {
        C08029() {
        }

        public void zza(zzjp com_google_android_gms_internal_zzjp, Map<String, String> map) {
            com_google_android_gms_internal_zzjp.zzE("1".equals(map.get("custom_close")));
        }
    }

    static {
        zzyX = new C07941();
        zzyY = new C07974();
        zzyZ = new C07985();
        zzza = new C07996();
        zzzb = new C08007();
        zzzc = new C08018();
        zzzd = new C08029();
        zzze = new zzdf() {
            public void zza(zzjp com_google_android_gms_internal_zzjp, Map<String, String> map) {
                String str = (String) map.get("u");
                if (str == null) {
                    zzb.zzaK("URL missing from httpTrack GMSG.");
                } else {
                    new zziy(com_google_android_gms_internal_zzjp.getContext(), com_google_android_gms_internal_zzjp.zzhX().afmaVersion, str).zzhn();
                }
            }
        };
        zzzf = new zzdf() {
            public void zza(zzjp com_google_android_gms_internal_zzjp, Map<String, String> map) {
                zzb.zzaJ("Received log message: " + ((String) map.get("string")));
            }
        };
        zzzg = new C07952();
        zzzh = new C07963();
        zzzi = new zzdo();
        zzzj = new zzds();
        zzzk = new zzdd();
    }
}
