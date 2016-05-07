/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.google.android.gms.b.ky;
import com.google.android.gms.flags.impl.a;
import com.google.android.gms.flags.impl.g;

public class f
extends a {
    public static Long a(SharedPreferences sharedPreferences, String string, Long l2) {
        return (Long)ky.a(new g(sharedPreferences, string, l2));
    }
}

