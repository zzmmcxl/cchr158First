/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.util.Log;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.ae;
import com.google.android.gms.b.an;
import com.google.android.gms.b.fi;

@fi
public final class fp
extends b {
    public static boolean a() {
        return (Boolean)an.ak.c();
    }

    private static boolean b() {
        if (!fp.a(2)) return false;
        if (!fp.a()) return false;
        return true;
    }

    public static void e(String string) {
        if (!fp.b()) return;
        Log.v((String)"Ads", (String)string);
    }
}

