/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.t;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;

@fi
public class a {
    public boolean a(Context context, Intent intent, t t2) {
        try {
            fp.e("Launching an intent: " + intent.toURI());
            g.c().a(context, intent);
            if (t2 == null) return true;
            t2.a();
            return true;
        }
        catch (ActivityNotFoundException var4_4) {
            fp.d(var4_4.getMessage());
            return false;
        }
    }

    public boolean a(Context context, AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, t t2) {
        String string;
        int n2;
        if (adLauncherIntentInfoParcel == null) {
            fp.d("No intent data for launcher overlay.");
            return false;
        }
        if (adLauncherIntentInfoParcel.i != null) {
            return this.a(context, adLauncherIntentInfoParcel.i, t2);
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty((CharSequence)adLauncherIntentInfoParcel.c)) {
            fp.d("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty((CharSequence)adLauncherIntentInfoParcel.d)) {
            intent.setDataAndType(Uri.parse((String)adLauncherIntentInfoParcel.c), adLauncherIntentInfoParcel.d);
        } else {
            intent.setData(Uri.parse((String)adLauncherIntentInfoParcel.c));
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty((CharSequence)adLauncherIntentInfoParcel.e)) {
            intent.setPackage(adLauncherIntentInfoParcel.e);
        }
        if (!TextUtils.isEmpty((CharSequence)adLauncherIntentInfoParcel.f)) {
            String[] arrstring = adLauncherIntentInfoParcel.f.split("/", 2);
            if (arrstring.length < 2) {
                fp.d("Could not parse component name from open GMSG: " + adLauncherIntentInfoParcel.f);
                return false;
            }
            intent.setClassName(arrstring[0], arrstring[1]);
        }
        if (TextUtils.isEmpty((CharSequence)(string = adLauncherIntentInfoParcel.g))) return this.a(context, intent, t2);
        try {
            int n3;
            n2 = n3 = Integer.parseInt(string);
        }
        catch (NumberFormatException var8_9) {
            fp.d("Could not parse intent flags.");
            n2 = 0;
        }
        intent.addFlags(n2);
        return this.a(context, intent, t2);
    }
}

