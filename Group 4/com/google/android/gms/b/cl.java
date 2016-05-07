/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.b.hb;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class cl {
    private final hb a;

    public cl(hb hb2) {
        this.a = hb2;
    }

    public Intent a(Context context, Map map) {
        List list;
        ResolveInfo resolveInfo;
        ActivityManager activityManager = (ActivityManager)context.getSystemService("activity");
        String string = (String)map.get("u");
        boolean bl2 = TextUtils.isEmpty((CharSequence)string);
        Intent intent = null;
        if (bl2) {
            return intent;
        }
        if (this.a != null) {
            string = g.c().a(this.a, string);
        }
        Uri uri = Uri.parse((String)string);
        boolean bl3 = Boolean.parseBoolean((String)map.get("use_first_package"));
        boolean bl4 = Boolean.parseBoolean((String)map.get("use_running_process"));
        Uri uri2 = "http".equalsIgnoreCase(uri.getScheme()) ? uri.buildUpon().scheme("https").build() : ("https".equalsIgnoreCase(uri.getScheme()) ? uri.buildUpon().scheme("http").build() : null);
        ArrayList arrayList = new ArrayList();
        Intent intent2 = this.a(uri);
        Intent intent3 = this.a(uri2);
        ResolveInfo resolveInfo2 = this.a(context, intent2, arrayList);
        if (resolveInfo2 != null) {
            return this.a(intent2, resolveInfo2);
        }
        if (intent3 != null && (resolveInfo = this.a(context, intent3)) != null) {
            intent = this.a(intent2, resolveInfo);
            if (this.a(context, intent) != null) return intent;
        }
        if (arrayList.size() == 0) {
            return intent2;
        }
        if (bl4 && activityManager != null && (list = activityManager.getRunningAppProcesses()) != null) {
            for (ResolveInfo resolveInfo3 : arrayList) {
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    if (!((ActivityManager.RunningAppProcessInfo)iterator.next()).processName.equals(resolveInfo3.activityInfo.packageName)) continue;
                    return this.a(intent2, resolveInfo3);
                }
            }
        }
        if (!bl3) return intent2;
        return this.a(intent2, (ResolveInfo)arrayList.get(0));
    }

    public Intent a(Intent intent, ResolveInfo resolveInfo) {
        Intent intent2 = new Intent(intent);
        intent2.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        return intent2;
    }

    public Intent a(Uri uri) {
        if (uri == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setData(uri);
        intent.setAction("android.intent.action.VIEW");
        return intent;
    }

    public ResolveInfo a(Context context, Intent intent) {
        return this.a(context, intent, new ArrayList());
    }

    public ResolveInfo a(Context context, Intent intent, ArrayList arrayList) {
        ResolveInfo resolveInfo;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        List list = packageManager.queryIntentActivities(intent, 65536);
        ResolveInfo resolveInfo2 = packageManager.resolveActivity(intent, 65536);
        if (list != null && resolveInfo2 != null) {
            for (int i2 = 0; i2 < list.size(); ++i2) {
                ResolveInfo resolveInfo3 = (ResolveInfo)list.get(i2);
                if (resolveInfo2 == null || !resolveInfo2.activityInfo.name.equals(resolveInfo3.activityInfo.name)) continue;
                resolveInfo = resolveInfo2;
                break;
            }
        } else {
            resolveInfo = null;
        }
        arrayList.addAll(list);
        return resolveInfo;
    }
}

