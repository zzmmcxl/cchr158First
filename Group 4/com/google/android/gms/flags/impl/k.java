/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class k
implements Callable {
    final /* synthetic */ Context a;

    k(Context context) {
        this.a = context;
    }

    public SharedPreferences a() {
        return this.a.getSharedPreferences("google_sdk_flags", 1);
    }

    public /* synthetic */ Object call() {
        return this.a();
    }
}

