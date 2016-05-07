/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class e
implements Callable {
    final /* synthetic */ SharedPreferences a;
    final /* synthetic */ String b;
    final /* synthetic */ Integer c;

    e(SharedPreferences sharedPreferences, String string, Integer n2) {
        this.a = sharedPreferences;
        this.b = string;
        this.c = n2;
    }

    public Integer a() {
        return this.a.getInt(this.b, this.c.intValue());
    }

    public /* synthetic */ Object call() {
        return this.a();
    }
}

