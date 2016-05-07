/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.SharedPreferences;
import com.google.android.gms.b.ae;
import com.google.android.gms.b.af;

final class ag
extends ae {
    ag(int n2, String string, Integer n3) {
        super(n2, string, n3, null);
    }

    @Override
    public /* synthetic */ Object a(SharedPreferences sharedPreferences) {
        return this.b(sharedPreferences);
    }

    public Integer b(SharedPreferences sharedPreferences) {
        return sharedPreferences.getInt(this.a(), ((Integer)this.b()).intValue());
    }
}

