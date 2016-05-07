/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import com.google.android.gms.b.di;
import com.google.android.gms.b.iq;
import com.google.android.gms.b.k;
import com.google.android.gms.b.mp;
import com.google.android.gms.b.ms;
import com.google.android.gms.b.mw;
import com.google.android.gms.b.mz;
import com.google.android.gms.b.na;
import java.io.File;
import org.apache.http.client.HttpClient;

public class d {
    public static iq a(Context context) {
        return d.a(context, null);
    }

    public static iq a(Context context, mz mz2) {
        String string;
        File file;
        file = new File(context.getCacheDir(), "volley");
        string = "volley/0";
        try {
            String string2;
            String string3 = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(string3, 0);
            string = string2 = string3 + "/" + packageInfo.versionCode;
        }
        catch (PackageManager.NameNotFoundException var4_9) {}
        if (mz2 == null) {
            mz2 = Build.VERSION.SDK_INT >= 9 ? new na() : new mw((HttpClient)AndroidHttpClient.newInstance((String)string));
        }
        mp mp2 = new mp(mz2);
        iq iq2 = new iq(new ms(file), mp2);
        iq2.a();
        return iq2;
    }
}

