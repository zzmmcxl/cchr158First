/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.bf;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.bt;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

final class bu
extends FutureTask {
    final /* synthetic */ bt a;
    private final String b;

    bu(bt bt2, Runnable runnable, String string) {
        this.a = bt2;
        super(runnable, null);
        bf.a((Object)string);
        this.b = string;
    }

    bu(bt bt2, Callable callable, String string) {
        this.a = bt2;
        super(callable);
        bf.a((Object)string);
        this.b = string;
    }

    @Override
    protected void setException(Throwable throwable) {
        this.a.s().b().a(this.b, throwable);
        super.setException(throwable);
    }
}

