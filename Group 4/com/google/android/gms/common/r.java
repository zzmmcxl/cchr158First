/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.b.ki;
import com.google.android.gms.b.kk;
import com.google.android.gms.b.kn;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.j;
import com.google.android.gms.common.l;
import com.google.android.gms.common.o;
import com.google.android.gms.common.s;
import com.google.android.gms.d;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class r {
    private static final Object a;
    @Deprecated
    public static final int b;
    public static boolean c;
    public static boolean d;
    static int e;
    static final AtomicBoolean f;
    private static String g;
    private static Integer h;
    private static final AtomicBoolean i;

    static {
        b = r.b();
        c = false;
        d = false;
        e = -1;
        a = new Object();
        g = null;
        h = null;
        f = new AtomicBoolean();
        i = new AtomicBoolean();
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    @Deprecated
    public static int a(Context var0) {
        if (f.a) {
            return 0;
        }
        var1_1 = var0.getPackageManager();
        try {
            var0.getResources().getString(d.common_google_play_services_unknown_issue);
        }
        catch (Throwable var2_4) {
            Log.e((String)"GooglePlayServicesUtil", (String)"The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(var0.getPackageName())) {
            r.i(var0);
        }
        try {
            var6_2 = var1_1.getPackageInfo("com.google.android.gms", 64);
        }
        catch (PackageManager.NameNotFoundException var4_5) {
            Log.w((String)"GooglePlayServicesUtil", (String)"Google Play services is missing.");
            return 1;
        }
        var7_3 = s.a();
        if (!ki.a(var0)) ** GOTO lbl22
        if (var7_3.a(var6_2, o.a) == null) {
            Log.w((String)"GooglePlayServicesUtil", (String)"Google Play services signature invalid.");
            return 9;
        }
        ** GOTO lbl34
lbl22: // 1 sources:
        try {
            var10_6 = var7_3.a(var1_1.getPackageInfo("com.android.vending", 8256), o.a);
            if (var10_6 == null) {
                Log.w((String)"GooglePlayServicesUtil", (String)"Google Play Store signature invalid.");
                return 9;
            }
            if (var7_3.a(var6_2, new l[]{var10_6}) == null) {
                Log.w((String)"GooglePlayServicesUtil", (String)"Google Play services signature invalid.");
                return 9;
            }
        }
        catch (PackageManager.NameNotFoundException var8_7) {
            Log.w((String)"GooglePlayServicesUtil", (String)"Google Play Store is neither installed nor updating.");
            return 9;
        }
lbl34: // 2 sources:
        var12_8 = kk.a(r.b);
        if (kk.a(var6_2.versionCode) < var12_8) {
            Log.w((String)"GooglePlayServicesUtil", (String)("Google Play services out of date.  Requires " + r.b + " but found " + var6_2.versionCode));
            return 2;
        }
        var13_9 = var6_2.applicationInfo;
        if (var13_9 == null) {
            var13_9 = var16_10 = var1_1.getApplicationInfo("com.google.android.gms", 0);
        }
        if (var13_9.enabled != false) return 0;
        return 3;
        catch (PackageManager.NameNotFoundException var14_11) {
            Log.wtf((String)"GooglePlayServicesUtil", (String)"Google Play services missing when getting application info.", (Throwable)var14_11);
            return 1;
        }
    }

    @Deprecated
    public static String a(int n2) {
        return ConnectionResult.a(n2);
    }

    public static boolean a() {
        if (!c) return "user".equals(Build.TYPE);
        return d;
    }

    @TargetApi(value=19)
    public static boolean a(Context context, int n2, String string) {
        if (kn.f()) {
            AppOpsManager appOpsManager = (AppOpsManager)context.getSystemService("appops");
            try {
                appOpsManager.checkPackage(n2, string);
                return true;
            }
            catch (SecurityException var8_8) {
                return false;
            }
        }
        String[] arrstring = context.getPackageManager().getPackagesForUid(n2);
        boolean bl2 = false;
        if (string == null) return bl2;
        bl2 = false;
        if (arrstring == null) return bl2;
        int n3 = 0;
        do {
            int n4 = arrstring.length;
            bl2 = false;
            if (n3 >= n4) return bl2;
            if (string.equals(arrstring[n3])) {
                return true;
            }
            ++n3;
        } while (true);
    }

    @TargetApi(value=21)
    static boolean a(Context context, String string) {
        if (kn.i()) {
            Iterator iterator = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
            while (iterator.hasNext()) {
                if (!string.equals(((PackageInstaller.SessionInfo)iterator.next()).getAppPackageName())) continue;
                return true;
            }
        }
        if (r.h(context)) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            return packageManager.getApplicationInfo((String)string, (int)8192).enabled;
        }
        catch (PackageManager.NameNotFoundException var3_5) {
            return false;
        }
    }

    public static boolean a(PackageManager packageManager) {
        boolean bl2;
        block8 : {
            bl2 = true;
            Object object = a;
            // MONITORENTER : object
            int n2 = e;
            if (n2 == -1) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
                    s s2 = s.a();
                    l[] arrl = new l[]{o.a[1]};
                    if (s2.a(packageInfo, arrl) != null) {
                        e = 1;
                        break block8;
                    }
                    e = 0;
                }
                catch (PackageManager.NameNotFoundException var5_7) {
                    e = 0;
                }
            }
        }
        if (e == 0) return false;
        // MONITOREXIT : object
        return bl2;
    }

    private static int b() {
        return 8487000;
    }

    @Deprecated
    public static void b(Context context) {
        int n2 = j.b().a(context);
        if (n2 == 0) return;
        Intent intent = j.b().a(context, n2, "e");
        Log.e((String)"GooglePlayServicesUtil", (String)("GooglePlayServices not available due to error " + n2));
        if (intent != null) throw new com.google.android.gms.common.d(n2, "Google Play Services not available", intent);
        throw new c(n2);
    }

    @Deprecated
    public static boolean b(int n2) {
        switch (n2) {
            default: {
                return false;
            }
            case 1: 
            case 2: 
            case 3: 
            case 9: 
        }
        return true;
    }

    public static boolean b(Context context, int n2) {
        PackageInfo packageInfo;
        if (!r.a(context, n2, "com.google.android.gms")) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
        }
        catch (PackageManager.NameNotFoundException var3_4) {
            if (!Log.isLoggable((String)"GooglePlayServicesUtil", (int)3)) return false;
            Log.d((String)"GooglePlayServicesUtil", (String)"Package manager can't find google play services package, defaulting to false");
            return false;
        }
        return s.a().a(context.getPackageManager(), packageInfo);
    }

    public static boolean b(PackageManager packageManager) {
        if (r.a(packageManager)) return true;
        if (r.a()) return false;
        return true;
    }

    @Deprecated
    public static void c(Context context) {
        if (f.getAndSet(true)) {
            return;
        }
        try {
            ((NotificationManager)context.getSystemService("notification")).cancel(10436);
            return;
        }
        catch (SecurityException var1_1) {
            return;
        }
    }

    @Deprecated
    public static boolean c(Context context, int n2) {
        if (n2 == 18) {
            return true;
        }
        if (n2 != 1) return false;
        return r.a(context, "com.google.android.gms");
    }

    public static Resources d(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        }
        catch (PackageManager.NameNotFoundException var1_2) {
            return null;
        }
    }

    public static Context e(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        }
        catch (PackageManager.NameNotFoundException var1_2) {
            return null;
        }
    }

    public static String f(Context context) {
        ApplicationInfo applicationInfo;
        String string = context.getApplicationInfo().name;
        if (!TextUtils.isEmpty((CharSequence)string)) return string;
        string = context.getPackageName();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            ApplicationInfo applicationInfo2;
            applicationInfo = applicationInfo2 = packageManager.getApplicationInfo(context.getPackageName(), 0);
            if (applicationInfo == null) return string;
        }
        catch (PackageManager.NameNotFoundException var3_5) {
            return string;
        }
        return packageManager.getApplicationLabel(applicationInfo).toString();
    }

    @Deprecated
    public static int g(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.google.android.gms", 0);
            return packageInfo.versionCode;
        }
        catch (PackageManager.NameNotFoundException var1_2) {
            Log.w((String)"GooglePlayServicesUtil", (String)"Google Play services is missing.");
            return 0;
        }
    }

    @TargetApi(value=18)
    public static boolean h(Context context) {
        if (!kn.e()) return false;
        Bundle bundle = ((UserManager)context.getSystemService("user")).getApplicationRestrictions(context.getPackageName());
        if (bundle == null) return false;
        if (!"true".equals(bundle.getString("restricted_profile"))) return false;
        return true;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private static void i(Context context) {
        block13 : {
            if (i.get()) {
                return;
            }
            Object object = a;
            // MONITORENTER : object
            if (g == null) {
                g = context.getPackageName();
                try {
                    Bundle bundle = context.getPackageManager().getApplicationInfo((String)context.getPackageName(), (int)128).metaData;
                    if (bundle != null) {
                        h = bundle.getInt("com.google.android.gms.version");
                        break block13;
                    }
                    h = null;
                }
                catch (PackageManager.NameNotFoundException var4_4) {
                    Log.wtf((String)"GooglePlayServicesUtil", (String)"This should never happen.", (Throwable)var4_4);
                }
            } else if (!g.equals(context.getPackageName())) {
                throw new IllegalArgumentException("isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package '" + g + "' and this call used package '" + context.getPackageName() + "'.");
            }
        }
        Integer n2 = h;
        // MONITOREXIT : object
        if (n2 == null) {
            throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
        }
        if (n2 == b) return;
        throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + b + " but" + " found " + n2 + ".  You must have the" + " following declaration within the <application> element: " + "    <meta-data android:name=\"" + "com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
    }
}

