/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.b.je;
import com.google.android.gms.b.ke;
import com.google.android.gms.b.kj;
import com.google.android.gms.common.stats.WakeLockEvent;
import com.google.android.gms.common.stats.e;
import com.google.android.gms.common.stats.f;
import java.util.List;

public class k {
    private static String a = "WakeLockTracker";
    private static k b = new k();
    private static Integer c;

    public static k a() {
        return b;
    }

    private static boolean a(Context context) {
        if (c == null) {
            c = k.b();
        }
        if (c == f.b) return false;
        return true;
    }

    private static int b() {
        try {
            if (!ke.a()) return f.b;
            return (Integer)e.a.c();
        }
        catch (SecurityException var0_1) {
            return f.b;
        }
    }

    public void a(Context context, String string, int n2, String string2, String string3, int n3, List list) {
        this.a(context, string, n2, string2, string3, n3, list, 0);
    }

    public void a(Context context, String string, int n2, String string2, String string3, int n3, List list, long l2) {
        if (!k.a(context)) {
            return;
        }
        if (TextUtils.isEmpty((CharSequence)string)) {
            Log.e((String)a, (String)("missing wakeLock key. " + string));
            return;
        }
        long l3 = System.currentTimeMillis();
        if (7 != n2 && 8 != n2 && 10 != n2) {
            if (11 != n2) return;
        }
        WakeLockEvent wakeLockEvent = new WakeLockEvent(l3, n2, string2, n3, list, string, SystemClock.elapsedRealtime(), kj.a(context), string3, context.getPackageName(), kj.b(context), l2);
        try {
            context.startService(new Intent().setComponent(f.a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", (Parcelable)wakeLockEvent));
            return;
        }
        catch (Exception var13_11) {
            Log.wtf((String)a, (Throwable)var13_11);
            return;
        }
    }
}

