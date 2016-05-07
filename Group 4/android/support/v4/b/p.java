/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.b;

import android.os.Handler;
import android.os.Message;
import android.support.v4.b.q;
import android.support.v4.b.r;
import android.support.v4.b.s;
import android.support.v4.b.t;
import android.support.v4.b.u;
import android.support.v4.b.v;
import android.support.v4.b.w;
import android.support.v4.b.x;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class p {
    private static final ThreadFactory a = new q();
    private static final BlockingQueue b = new LinkedBlockingQueue(10);
    public static final Executor c;
    private static v d;
    private static volatile Executor e;
    private final x f;
    private final FutureTask g;
    private volatile w h = w.a;
    private final AtomicBoolean i = new AtomicBoolean();

    static {
        e = p.c = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, b, a);
    }

    public p() {
        this.f = new r(this);
        this.g = new s(this, this.f);
    }

    static /* synthetic */ Object a(p p2, Object object) {
        return p2.d(object);
    }

    static /* synthetic */ AtomicBoolean a(p p2) {
        return p2.i;
    }

    static /* synthetic */ void b(p p2, Object object) {
        p2.c(object);
    }

    static /* synthetic */ void c(p p2, Object object) {
        p2.e(object);
    }

    private void c(Object object) {
        if (this.i.get()) return;
        this.d(object);
    }

    private static Handler d() {
        // MONITORENTER : android.support.v4.b.p.class
        if (d == null) {
            d = new v();
        }
        v v2 = d;
        // MONITOREXIT : android.support.v4.b.p.class
        return v2;
    }

    private Object d(Object object) {
        p.d().obtainMessage(1, (Object)new u(this, object)).sendToTarget();
        return object;
    }

    private void e(Object object) {
        if (this.c()) {
            this.b(object);
        } else {
            this.a(object);
        }
        this.h = w.c;
    }

    /*
     * Unable to fully structure code
     */
    public final /* varargs */ p a(Executor var1_1, Object ... var2_2) {
        if (this.h == w.a) ** GOTO lbl-1000
        switch (t.a[this.h.ordinal()]) {
            default: lbl-1000: // 2 sources:
            {
                this.h = w.b;
                this.a();
                this.f.b = var2_2;
                var1_1.execute(this.g);
                return this;
            }
            case 1: {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            }
            case 2: 
        }
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    }

    protected /* varargs */ abstract Object a(Object ... var1);

    protected void a() {
    }

    protected void a(Object object) {
    }

    public final boolean a(boolean bl2) {
        return this.g.cancel(bl2);
    }

    protected void b() {
    }

    protected void b(Object object) {
        this.b();
    }

    protected /* varargs */ void b(Object ... arrobject) {
    }

    public final boolean c() {
        return this.g.isCancelled();
    }
}

