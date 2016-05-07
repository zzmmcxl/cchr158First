/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.b.kn;
import com.google.android.gms.b.kp;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class kq {
    private static final Method a = kq.a();
    private static final Method b = kq.b();
    private static final Method c = kq.c();
    private static final Method d = kq.d();
    private static final Method e = kq.e();

    public static int a(WorkSource workSource) {
        if (c == null) return 0;
        try {
            return (Integer)c.invoke((Object)workSource, new Object[0]);
        }
        catch (Exception var1_2) {
            Log.wtf((String)"WorkSourceUtil", (String)"Unable to assign blame through WorkSource", (Throwable)var1_2);
        }
        return 0;
    }

    public static WorkSource a(int n2, String string) {
        WorkSource workSource = new WorkSource();
        kq.a(workSource, n2, string);
        return workSource;
    }

    public static WorkSource a(Context context, String string) {
        if (context == null) return null;
        if (context.getPackageManager() == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(string, 0);
            if (applicationInfo != null) return kq.a(applicationInfo.uid, string);
        }
        catch (PackageManager.NameNotFoundException var2_3) {
            Log.e((String)"WorkSourceUtil", (String)("Could not find package: " + string));
            return null;
        }
        Log.e((String)"WorkSourceUtil", (String)("Could not get applicationInfo from package: " + string));
        return null;
    }

    public static String a(WorkSource workSource, int n2) {
        if (e == null) return null;
        try {
            Method method = e;
            Object[] arrobject = new Object[]{n2};
            return (String)method.invoke((Object)workSource, arrobject);
        }
        catch (Exception var2_5) {
            Log.wtf((String)"WorkSourceUtil", (String)"Unable to assign blame through WorkSource", (Throwable)var2_5);
        }
        return null;
    }

    private static Method a() {
        try {
            Class[] arrclass = new Class[]{Integer.TYPE};
            return WorkSource.class.getMethod("add", arrclass);
        }
        catch (Exception var0_2) {
            return null;
        }
    }

    public static void a(WorkSource workSource, int n2, String string) {
        if (b != null) {
            if (string == null) {
                string = "";
            }
            try {
                Method method = b;
                Object[] arrobject = new Object[]{n2, string};
                method.invoke((Object)workSource, arrobject);
                return;
            }
            catch (Exception var8_5) {
                Log.wtf((String)"WorkSourceUtil", (String)"Unable to assign blame through WorkSource", (Throwable)var8_5);
                return;
            }
        }
        if (a == null) return;
        try {
            Method method = a;
            Object[] arrobject = new Object[]{n2};
            method.invoke((Object)workSource, arrobject);
            return;
        }
        catch (Exception var3_8) {
            Log.wtf((String)"WorkSourceUtil", (String)"Unable to assign blame through WorkSource", (Throwable)var3_8);
            return;
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) return false;
        if (packageManager.checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) return false;
        return true;
    }

    private static Method b() {
        boolean bl2 = kn.e();
        Method method = null;
        if (!bl2) return method;
        try {
            Class[] arrclass = new Class[]{Integer.TYPE, String.class};
            Method method2 = WorkSource.class.getMethod("add", arrclass);
            return method2;
        }
        catch (Exception var2_4) {
            return null;
        }
    }

    public static List b(WorkSource workSource) {
        int n2 = 0;
        int n3 = workSource == null ? 0 : kq.a(workSource);
        if (n3 == 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        while (n2 < n3) {
            String string = kq.a(workSource, n2);
            if (!kp.a(string)) {
                arrayList.add(string);
            }
            ++n2;
        }
        return arrayList;
    }

    private static Method c() {
        try {
            return WorkSource.class.getMethod("size", new Class[0]);
        }
        catch (Exception var0_1) {
            return null;
        }
    }

    private static Method d() {
        try {
            Class[] arrclass = new Class[]{Integer.TYPE};
            return WorkSource.class.getMethod("get", arrclass);
        }
        catch (Exception var0_2) {
            return null;
        }
    }

    private static Method e() {
        boolean bl2 = kn.e();
        Method method = null;
        if (!bl2) return method;
        try {
            Class[] arrclass = new Class[]{Integer.TYPE};
            Method method2 = WorkSource.class.getMethod("getName", arrclass);
            return method2;
        }
        catch (Exception var2_4) {
            return null;
        }
    }
}

