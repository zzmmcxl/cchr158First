/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.bf;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.bt;

final class bv
implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ bt a;
    private final String b;

    public bv(bt bt2, String string) {
        this.a = bt2;
        bf.a((Object)string);
        this.b = string;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        // MONITORENTER : this
        this.a.s().b().a(this.b, throwable);
        // MONITOREXIT : this
        return;
    }
}

