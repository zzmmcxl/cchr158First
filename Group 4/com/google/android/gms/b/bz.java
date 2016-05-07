/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.b.ce;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.hb;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class bz
implements ce {
    bz() {
    }

    @Override
    public void a(hb hb2, Map map) {
        JSONObject jSONObject;
        PackageManager packageManager = hb2.getContext().getPackageManager();
        String string = (String)map.get("data");
        try {
            jSONObject = new JSONObject(string);
        }
        catch (JSONException var30_21) {
            hb2.a("openableIntents", new JSONObject());
            return;
        }
        try {}
        catch (JSONException var6_22) {
            hb2.a("openableIntents", new JSONObject());
            return;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("intents");
        JSONObject jSONObject2 = new JSONObject();
        int n2 = 0;
        do {
            block15 : {
                JSONObject jSONObject3;
                String[] arrstring;
                if (n2 >= jSONArray.length()) {
                    hb2.a("openableIntents", jSONObject2);
                    return;
                }
                try {
                    jSONObject3 = jSONArray.getJSONObject(n2);
                }
                catch (JSONException var10_9) {
                    fp.b("Error parsing the intent data.", (Throwable)var10_9);
                    break block15;
                }
                String string2 = jSONObject3.optString("id");
                String string3 = jSONObject3.optString("u");
                String string4 = jSONObject3.optString("i");
                String string5 = jSONObject3.optString("m");
                String string6 = jSONObject3.optString("p");
                String string7 = jSONObject3.optString("c");
                jSONObject3.optString("f");
                jSONObject3.optString("e");
                Intent intent = new Intent();
                if (!TextUtils.isEmpty((CharSequence)string3)) {
                    intent.setData(Uri.parse((String)string3));
                }
                if (!TextUtils.isEmpty((CharSequence)string4)) {
                    intent.setAction(string4);
                }
                if (!TextUtils.isEmpty((CharSequence)string5)) {
                    intent.setType(string5);
                }
                if (!TextUtils.isEmpty((CharSequence)string6)) {
                    intent.setPackage(string6);
                }
                if (!TextUtils.isEmpty((CharSequence)string7) && (arrstring = string7.split("/", 2)).length == 2) {
                    intent.setComponent(new ComponentName(arrstring[0], arrstring[1]));
                }
                boolean bl2 = packageManager.resolveActivity(intent, 65536) != null;
                try {
                    jSONObject2.put(string2, bl2);
                }
                catch (JSONException var22_19) {
                    fp.b("Error constructing openable urls response.", (Throwable)var22_19);
                }
            }
            ++n2;
        } while (true);
    }
}

