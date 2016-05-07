/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public class ao {
    private static final Uri a = Uri.parse((String)"http://plus.google.com/");
    private static final Uri b = a.buildUpon().appendPath("circles").appendPath("find").build();

    public static Intent a() {
        Intent intent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        intent.setPackage("com.google.android.wearable.app");
        return intent;
    }

    public static Intent a(String string) {
        Uri uri = Uri.fromParts((String)"package", (String)string, (String)null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(uri);
        return intent;
    }

    public static Intent a(String string, String string2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(ao.b(string, string2));
        intent.setPackage("com.android.vending");
        intent.addFlags(524288);
        return intent;
    }

    private static Uri b(String string, String string2) {
        Uri.Builder builder = Uri.parse((String)"market://details").buildUpon().appendQueryParameter("id", string);
        if (TextUtils.isEmpty((CharSequence)string2)) return builder.build();
        builder.appendQueryParameter("pcampaignid", string2);
        return builder.build();
    }
}

