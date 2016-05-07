/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class fw
implements ThreadFactory {
    final /* synthetic */ String a;
    private final AtomicInteger b;

    fw(String string) {
        this.a = string;
        this.b = new AtomicInteger(1);
    }

    @Override
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AdWorker(" + this.a + ") #" + this.b.getAndIncrement());
    }
}

