/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.bf;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.bt;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.FutureTask;

final class bw
extends Thread {
    final /* synthetic */ bt a;
    private final Object b;
    private final BlockingQueue c;

    public bw(bt bt2, String string, BlockingQueue blockingQueue) {
        this.a = bt2;
        bf.a((Object)string);
        this.b = new Object();
        this.c = blockingQueue;
        this.setName(string);
    }

    private void a(InterruptedException interruptedException) {
        this.a.s().c().a(this.getName() + " was interrupted", interruptedException);
    }

    public void a() {
        Object object = this.b;
        // MONITORENTER : object
        this.b.notifyAll();
        // MONITOREXIT : object
        return;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public void run() {
        Throwable throwable;
        boolean bl2 = false;
        while (!bl2) {
            try {
                bt.a(this.a).acquire();
                bl2 = true;
            }
            catch (InterruptedException var18_2) {
                this.a(var18_2);
            }
        }
        do {
            boolean bl3;
            try {
                FutureTask futureTask;
                while ((futureTask = (FutureTask)this.c.poll()) != null) {
                    futureTask.run();
                }
                Object object = this.b;
                // MONITORENTER : object
            }
            catch (Throwable throwable) {
                Object object = bt.c(this.a);
                // MONITORENTER : object
                bt.a(this.a).release();
                bt.c(this.a).notifyAll();
                if (this != bt.d(this.a)) break;
                bt.a(this.a, null);
                // MONITOREXIT : object
                throw throwable;
            }
            if (this.c.peek() == null && !(bl3 = bt.b(this.a))) {
                try {
                    this.b.wait(30000);
                    // MONITOREXIT : object
                }
                catch (InterruptedException var17_4) {
                    this.a(var17_4);
                }
            }
            Object object = bt.c(this.a);
            // MONITORENTER : object
            if (this.c.peek() == null) {
                // MONITOREXIT : object
                Object object2 = bt.c(this.a);
                // MONITORENTER : object2
                bt.a(this.a).release();
                bt.c(this.a).notifyAll();
                if (this == bt.d(this.a)) {
                    bt.a(this.a, null);
                    // MONITOREXIT : object2
                    return;
                }
                if (this == bt.e(this.a)) {
                    bt.b(this.a, null);
                    return;
                }
                this.a.s().b().a("Current scheduler thread is neither worker nor network");
                return;
            }
            // MONITOREXIT : object
        } while (true);
        if (this == bt.e(this.a)) {
            bt.b(this.a, null);
            throw throwable;
        }
        this.a.s().b().a("Current scheduler thread is neither worker nor network");
        throw throwable;
    }
}

