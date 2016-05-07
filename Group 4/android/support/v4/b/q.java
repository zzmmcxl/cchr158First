/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.b;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class q
implements ThreadFactory {
    private final AtomicInteger a = new AtomicInteger(1);

    q() {
    }

    @Override
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "ModernAsyncTask #" + this.a.getAndIncrement());
    }
}

