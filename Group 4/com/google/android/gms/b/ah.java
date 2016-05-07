/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.SharedPreferences;
import com.google.android.gms.b.ae;
import com.google.android.gms.b.af;

final class ah
extends ae {
    ah(int n2, String string, Long l2) {
        super(n2, string, l2, null);
    }

    @Override
    public /* synthetic */ Object a(SharedPreferences sharedPreferences) {
        return this.b(sharedPreferences);
    }

    public Long b(SharedPreferences sharedPreferences) {
        return sharedPreferences.getLong(this.a(), ((Long)this.b()).longValue());
    }
}

