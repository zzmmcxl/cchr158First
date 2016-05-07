/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.ks;
import com.google.android.gms.common.internal.bf;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class kr
implements ThreadFactory {
    private final String a;
    private final int b;
    private final AtomicInteger c = new AtomicInteger();
    private final ThreadFactory d = Executors.defaultThreadFactory();

    public kr(String string) {
        this(string, 0);
    }

    public kr(String string, int n2) {
        this.a = (String)bf.a((Object)string, (Object)"Name must not be null");
        this.b = n2;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread = this.d.newThread(new ks(runnable, this.b));
        thread.setName(this.a + "[" + this.c.getAndIncrement() + "]");
        return thread;
    }
}

