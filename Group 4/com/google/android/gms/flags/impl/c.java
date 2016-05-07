/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class c
implements Callable {
    final /* synthetic */ SharedPreferences a;
    final /* synthetic */ String b;
    final /* synthetic */ Boolean c;

    c(SharedPreferences sharedPreferences, String string, Boolean bl2) {
        this.a = sharedPreferences;
        this.b = string;
        this.c = bl2;
    }

    public Boolean a() {
        return this.a.getBoolean(this.b, this.c.booleanValue());
    }

    public /* synthetic */ Object call() {
        return this.a();
    }
}

