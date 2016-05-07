/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.google.android.gms.b.ky;
import com.google.android.gms.flags.impl.a;
import com.google.android.gms.flags.impl.c;

public class b
extends a {
    public static Boolean a(SharedPreferences sharedPreferences, String string, Boolean bl2) {
        return (Boolean)ky.a(new c(sharedPreferences, string, bl2));
    }
}

