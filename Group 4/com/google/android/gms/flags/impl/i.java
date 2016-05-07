/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class i
implements Callable {
    final /* synthetic */ SharedPreferences a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    i(SharedPreferences sharedPreferences, String string, String string2) {
        this.a = sharedPreferences;
        this.b = string;
        this.c = string2;
    }

    public String a() {
        return this.a.getString(this.b, this.c);
    }

    public /* synthetic */ Object call() {
        return this.a();
    }
}

