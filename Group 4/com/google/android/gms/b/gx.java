/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.fi;
import com.google.android.gms.b.gy;
import com.google.android.gms.b.gz;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@fi
public class gx
implements gy {
    private final Object a = new Object();
    private Object b = null;
    private boolean c = false;
    private boolean d = false;
    private final gz e = new gz();

    public void a(Runnable runnable) {
        this.e.a(runnable);
    }

    public void b(Object object) {
        Object object2 = this.a;
        // MONITORENTER : object2
        if (this.d) {
            // MONITOREXIT : object2
            return;
        }
        if (this.c) {
            throw new IllegalStateException("Provided CallbackFuture with multiple values.");
        }
        this.c = true;
        this.b = object;
        this.a.notifyAll();
        this.e.a();
        // MONITOREXIT : object2
        return;
    }

    @Override
    public boolean cancel(boolean bl2) {
        if (!bl2) {
            return false;
        }
        Object object = this.a;
        // MONITORENTER : object
        if (this.c) {
            // MONITOREXIT : object
            return false;
        }
        this.d = true;
        this.c = true;
        this.a.notifyAll();
        this.e.a();
        // MONITOREXIT : object
        return true;
    }

    public Object get() {
        Object object = this.a;
        // MONITORENTER : object
        boolean bl2 = this.c;
        if (!bl2) {
            try {
                this.a.wait();
            }
            catch (InterruptedException var5_5) {}
        }
        if (this.d) {
            throw new CancellationException("CallbackFuture was cancelled.");
        }
        Object object = this.b;
        // MONITOREXIT : object
        return object;
    }

    public Object get(long l2, TimeUnit timeUnit) {
        Object object = this.a;
        // MONITORENTER : object
        boolean bl2 = this.c;
        if (!bl2) {
            try {
                long l3 = timeUnit.toMillis(l2);
                if (l3 != 0) {
                    this.a.wait(l3);
                }
            }
            catch (InterruptedException var8_8) {}
        }
        if (!this.c) {
            throw new TimeoutException("CallbackFuture timed out.");
        }
        if (this.d) {
            throw new CancellationException("CallbackFuture was cancelled.");
        }
        Object object = this.b;
        // MONITOREXIT : object
        return object;
    }

    @Override
    public boolean isCancelled() {
        Object object = this.a;
        // MONITORENTER : object
        boolean bl2 = this.d;
        // MONITOREXIT : object
        return bl2;
    }

    @Override
    public boolean isDone() {
        Object object = this.a;
        // MONITORENTER : object
        boolean bl2 = this.c;
        // MONITOREXIT : object
        return bl2;
    }
}

