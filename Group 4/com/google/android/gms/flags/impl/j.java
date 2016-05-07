/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.b.ky;
import com.google.android.gms.flags.impl.k;

public class j {
    private static SharedPreferences a = null;

    public static SharedPreferences a(Context context) {
        // MONITORENTER : android.content.SharedPreferences.class
        if (a == null) {
            a = (SharedPreferences)ky.a(new k(context));
        }
        SharedPreferences sharedPreferences = a;
        // MONITOREXIT : android.content.SharedPreferences.class
        return sharedPreferences;
    }
}

