/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.SharedPreferences;
import com.google.android.gms.b.ae;
import com.google.android.gms.b.af;

final class ai
extends ae {
    ai(int n2, String string, String string2) {
        super(n2, string, string2, null);
    }

    @Override
    public /* synthetic */ Object a(SharedPreferences sharedPreferences) {
        return this.b(sharedPreferences);
    }

    public String b(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(this.a(), (String)this.b());
    }
}

