/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.b.kf;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.measurement.internal.ag;
import com.google.android.gms.measurement.internal.ai;
import com.google.android.gms.measurement.internal.aj;
import com.google.android.gms.measurement.internal.ak;
import com.google.android.gms.measurement.internal.aq;
import com.google.android.gms.measurement.internal.ba;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.bn;
import com.google.android.gms.measurement.internal.bs;
import com.google.android.gms.measurement.internal.bu;
import com.google.android.gms.measurement.internal.bv;
import com.google.android.gms.measurement.internal.bw;
import com.google.android.gms.measurement.internal.bx;
import com.google.android.gms.measurement.internal.cl;
import com.google.android.gms.measurement.internal.d;
import com.google.android.gms.measurement.internal.i;
import com.google.android.gms.measurement.internal.u;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class bt
extends cl {
    private bw a;
    private bw b;
    private final BlockingQueue c = new LinkedBlockingQueue();
    private final BlockingQueue d = new LinkedBlockingQueue();
    private final Thread.UncaughtExceptionHandler e;
    private final Thread.UncaughtExceptionHandler f;
    private final Object g = new Object();
    private final Semaphore h = new Semaphore(2);
    private volatile boolean i;

    bt(bx bx2) {
        super(bx2);
        this.e = new bv(this, "Thread death: Uncaught exception on worker thread");
        this.f = new bv(this, "Thread death: Uncaught exception on network thread");
    }

    static /* synthetic */ bw a(bt bt2, bw bw2) {
        bt2.a = bw2;
        return bw2;
    }

    static /* synthetic */ Semaphore a(bt bt2) {
        return bt2.h;
    }

    private void a(FutureTask futureTask) {
        Object object = this.g;
        // MONITORENTER : object
        this.c.add(futureTask);
        if (this.a == null) {
            this.a = new bw(this, "Measurement Worker", this.c);
            this.a.setUncaughtExceptionHandler(this.e);
            this.a.start();
            // MONITOREXIT : object
            return;
        }
        this.a.a();
        return;
    }

    static /* synthetic */ bw b(bt bt2, bw bw2) {
        bt2.b = bw2;
        return bw2;
    }

    private void b(FutureTask futureTask) {
        Object object = this.g;
        // MONITORENTER : object
        this.d.add(futureTask);
        if (this.b == null) {
            this.b = new bw(this, "Measurement Network", this.d);
            this.b.setUncaughtExceptionHandler(this.f);
            this.b.start();
            // MONITOREXIT : object
            return;
        }
        this.b.a();
        return;
    }

    static /* synthetic */ boolean b(bt bt2) {
        return bt2.i;
    }

    static /* synthetic */ Object c(bt bt2) {
        return bt2.g;
    }

    static /* synthetic */ bw d(bt bt2) {
        return bt2.a;
    }

    static /* synthetic */ bw e(bt bt2) {
        return bt2.b;
    }

    public Future a(Callable callable) {
        this.G();
        bf.a(callable);
        bu bu2 = new bu(this, callable, "Task exception on worker thread");
        if (Thread.currentThread() == this.a) {
            bu2.run();
            return bu2;
        }
        this.a(bu2);
        return bu2;
    }

    @Override
    protected void a() {
    }

    public void a(Runnable runnable) {
        this.G();
        bf.a(runnable);
        this.a(new bu(this, runnable, "Task exception on worker thread"));
    }

    public void b(Runnable runnable) {
        this.G();
        bf.a(runnable);
        this.b(new bu(this, runnable, "Task exception on network thread"));
    }

    @Override
    public void e() {
        if (Thread.currentThread() == this.b) return;
        throw new IllegalStateException("Call expected from network thread");
    }

    @Override
    public void f() {
        if (Thread.currentThread() == this.a) return;
        throw new IllegalStateException("Call expected from worker thread");
    }
}

