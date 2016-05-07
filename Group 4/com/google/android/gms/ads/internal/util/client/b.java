/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.util.client;

import android.util.Log;
import com.google.android.gms.b.fi;

@fi
public class b {
    public static void a(String string) {
        if (!b.a(3)) return;
        Log.d((String)"Ads", (String)string);
    }

    public static void a(String string, Throwable throwable) {
        if (!b.a(3)) return;
        Log.d((String)"Ads", (String)string, (Throwable)throwable);
    }

    public static boolean a(int n2) {
        if (n2 >= 5) return true;
        if (!Log.isLoggable((String)"Ads", (int)n2)) return false;
        return true;
    }

    public static void b(String string) {
        if (!b.a(6)) return;
        Log.e((String)"Ads", (String)string);
    }

    public static void b(String string, Throwable throwable) {
        if (!b.a(6)) return;
        Log.e((String)"Ads", (String)string, (Throwable)throwable);
    }

    public static void c(String string) {
        if (!b.a(4)) return;
        Log.i((String)"Ads", (String)string);
    }

    public static void c(String string, Throwable throwable) {
        if (!b.a(5)) return;
        Log.w((String)"Ads", (String)string, (Throwable)throwable);
    }

    public static void d(String string) {
        if (!b.a(5)) return;
        Log.w((String)"Ads", (String)string);
    }
}

