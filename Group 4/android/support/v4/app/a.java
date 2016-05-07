/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.b;
import android.support.v4.app.c;
import android.support.v4.app.d;
import android.support.v4.app.e;
import android.support.v4.app.h;

public class a
extends android.support.v4.b.c {
    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            h.a(activity);
            return;
        }
        activity.finish();
    }

    public static void a(Activity activity, Intent intent, int n2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            h.a(activity, intent, n2, bundle);
            return;
        }
        activity.startActivityForResult(intent, n2);
    }

    public static void a(Activity activity, String[] arrstring, int n2) {
        if (Build.VERSION.SDK_INT >= 23) {
            e.a(activity, arrstring, n2);
            return;
        }
        if (!(activity instanceof c)) return;
        new Handler(Looper.getMainLooper()).post((Runnable)new b(arrstring, activity, n2));
    }

    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            d.a(activity);
            return;
        }
        activity.finish();
    }
}

