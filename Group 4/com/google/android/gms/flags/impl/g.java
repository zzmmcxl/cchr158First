/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class g
implements Callable {
    final /* synthetic */ SharedPreferences a;
    final /* synthetic */ String b;
    final /* synthetic */ Long c;

    g(SharedPreferences sharedPreferences, String string, Long l2) {
        this.a = sharedPreferences;
        this.b = string;
        this.c = l2;
    }

    public Long a() {
        return this.a.getLong(this.b, this.c.longValue());
    }

    public /* synthetic */ Object call() {
        return this.a();
    }
}

