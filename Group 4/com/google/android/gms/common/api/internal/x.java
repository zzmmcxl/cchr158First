/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.o;
import com.google.android.gms.common.api.internal.p;

abstract class x
implements Runnable {
    final /* synthetic */ o b;

    private x(o o2) {
        this.b = o2;
    }

    /* synthetic */ x(o o2, p p2) {
        this(o2);
    }

    protected abstract void a();

    @Override
    public void run() {
        block6 : {
            o.c(this.b).lock();
            boolean bl2 = Thread.interrupted();
            if (!bl2) break block6;
            o.c(this.b).unlock();
            return;
        }
        try {
            this.a();
        }
        catch (RuntimeException var2_2) {
            o.d(this.b).a(var2_2);
            return;
        }
        finally {
            o.c(this.b).unlock();
        }
        o.c(this.b).unlock();
        return;
    }
}

