/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.bg;
import android.support.v4.app.bh;
import android.support.v4.app.bi;
import android.support.v4.b.g;

public final class bf {
    private static final bg a;

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            a = new bi();
            return;
        }
        a = new bh();
    }

    public static Intent a(Activity activity) {
        return a.a(activity);
    }

    public static Intent a(Context context, ComponentName componentName) {
        String string = bf.b(context, componentName);
        if (string == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), string);
        if (bf.b(context, componentName2) != null) return new Intent().setComponent(componentName2);
        return g.a(componentName2);
    }

    public static boolean a(Activity activity, Intent intent) {
        return a.a(activity, intent);
    }

    public static String b(Activity activity) {
        try {
            return bf.b((Context)activity, activity.getComponentName());
        }
        catch (PackageManager.NameNotFoundException var1_2) {
            throw new IllegalArgumentException((Throwable)var1_2);
        }
    }

    public static String b(Context context, ComponentName componentName) {
        ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(componentName, 128);
        return a.a(context, activityInfo);
    }

    public static void b(Activity activity, Intent intent) {
        a.b(activity, intent);
    }
}

