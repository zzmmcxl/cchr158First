/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.bd;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.common.api.n;
import com.google.android.gms.common.api.t;
import com.google.android.gms.common.api.u;
import com.google.android.gms.common.api.v;
import com.google.android.gms.common.api.w;
import com.google.android.gms.common.api.x;
import com.google.android.gms.common.internal.as;
import com.google.android.gms.common.internal.bf;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

public abstract class e
extends t {
    private final Object a = new Object();
    private final WeakReference b;
    protected final f c;
    private final CountDownLatch d = new CountDownLatch(1);
    private final ArrayList e = new ArrayList();
    private x f;
    private volatile w g;
    private volatile boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private as l;
    private Integer m;
    private volatile bd n;

    protected e(n n2) {
        Looper looper = n2 != null ? n2.c() : Looper.getMainLooper();
        this.c = new f(looper);
        this.b = new WeakReference<n>(n2);
    }

    public static void b(w w2) {
        if (!(w2 instanceof v)) return;
        try {
            ((v)((Object)w2)).a();
            return;
        }
        catch (RuntimeException var1_1) {
            Log.w((String)"BasePendingResult", (String)("Unable to release " + w2), (Throwable)var1_1);
            return;
        }
    }

    private void c(w w2) {
        this.g = w2;
        this.l = null;
        this.d.countDown();
        Status status = this.g.a();
        if (this.f != null) {
            this.c.a();
            if (!this.i) {
                this.c.a(this.f, this.i());
            }
        }
        Iterator iterator = this.e.iterator();
        do {
            if (!iterator.hasNext()) {
                this.e.clear();
                return;
            }
            ((u)iterator.next()).a(status);
        } while (true);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private w i() {
        boolean bl2 = true;
        Object object = this.a;
        // MONITORENTER : object
        if (this.h) {
            bl2 = false;
        }
        bf.a(bl2, (Object)"Result has already been consumed.");
        bf.a(this.e(), (Object)"Result is not ready.");
        w w2 = this.g;
        this.g = null;
        this.f = null;
        this.h = true;
        // MONITOREXIT : object
        this.d();
        return w2;
    }

    @Override
    public Integer a() {
        return this.m;
    }

    public final void a(w w2) {
        boolean bl2;
        block5 : {
            block4 : {
                bl2 = true;
                Object object = this.a;
                // MONITORENTER : object
                if (this.j || this.i) {
                    e.b(w2);
                    // MONITOREXIT : object
                    return;
                }
                boolean bl3 = !this.e() ? bl2 : false;
                bf.a(bl3, (Object)"Results have already been set");
                if (this.h) break block4;
                break block5;
            }
            bl2 = false;
        }
        bf.a(bl2, (Object)"Result has already been consumed");
        this.c(w2);
        // MONITOREXIT : object
    }

    @Override
    public final void a(x x2) {
        boolean bl2 = true;
        boolean bl3 = !this.h ? bl2 : false;
        bf.a(bl3, (Object)"Result has already been consumed.");
        Object object = this.a;
        // MONITORENTER : object
        if (this.n != null) {
            bl2 = false;
        }
        bf.a(bl2, (Object)"Cannot set callbacks if then() has been called.");
        if (this.h()) {
            // MONITOREXIT : object
            return;
        }
        if (this.k && ((n)this.b.get() == null || !(x2 instanceof bd))) {
            this.f();
            // MONITOREXIT : object
            return;
        }
        if (this.e()) {
            this.c.a(x2, this.i());
            // MONITOREXIT : object
            return;
        }
        this.f = x2;
    }

    protected abstract w b(Status var1);

    protected void d() {
    }

    public final void d(Status status) {
        Object object = this.a;
        // MONITORENTER : object
        if (!this.e()) {
            this.a(this.b(status));
            this.j = true;
        }
        // MONITOREXIT : object
        return;
    }

    public final boolean e() {
        if (this.d.getCount() != 0) return false;
        return true;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void f() {
        Object object = this.a;
        // MONITORENTER : object
        if (this.i || this.h) {
            // MONITOREXIT : object
            return;
        }
        as as2 = this.l;
        if (as2 != null) {
            try {
                this.l.a();
            }
            catch (RemoteException var4_3) {}
        }
        e.b(this.g);
        this.f = null;
        this.i = true;
        this.c(this.b(Status.e));
        // MONITOREXIT : object
    }

    public void g() {
        Object object = this.a;
        // MONITORENTER : object
        if ((n)this.b.get() == null) {
            this.f();
            // MONITOREXIT : object
            return;
        }
        if (this.f == null || this.f instanceof bd) {
            this.k = true;
            // MONITOREXIT : object
            return;
        }
        this.f();
        return;
    }

    public boolean h() {
        Object object = this.a;
        // MONITORENTER : object
        boolean bl2 = this.i;
        // MONITOREXIT : object
        return bl2;
    }
}

