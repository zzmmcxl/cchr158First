/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.SharedPreferences;
import com.google.android.gms.b.ae;

final class af
extends ae {
    af(int n2, String string, Boolean bl2) {
        super(n2, string, bl2, null);
    }

    @Override
    public /* synthetic */ Object a(SharedPreferences sharedPreferences) {
        return this.b(sharedPreferences);
    }

    public Boolean b(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(this.a(), ((Boolean)this.b()).booleanValue());
    }
}

