/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.b;

import com.google.android.gms.ads.b.a;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class c
extends Thread {
    CountDownLatch a;
    boolean b;
    private WeakReference c;
    private long d;

    public c(a a2, long l2) {
        this.c = new WeakReference<a>(a2);
        this.d = l2;
        this.a = new CountDownLatch(1);
        this.b = false;
        this.start();
    }

    private void c() {
        a a2 = (a)this.c.get();
        if (a2 == null) return;
        a2.b();
        this.b = true;
    }

    public void a() {
        this.a.countDown();
    }

    public boolean b() {
        return this.b;
    }

    @Override
    public void run() {
        try {
            if (this.a.await(this.d, TimeUnit.MILLISECONDS)) return;
            this.c();
            return;
        }
        catch (InterruptedException var1_1) {
            this.c();
            return;
        }
    }
}

