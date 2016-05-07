/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.support.v4.b.a;
import android.util.Log;
import com.google.android.gms.common.api.internal.ay;
import com.google.android.gms.common.api.n;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class d
extends a
implements ay {
    private Semaphore o = new Semaphore(0);
    private Set p;

    public d(Context context, Set set) {
        super(context);
        this.p = set;
    }

    @Override
    public /* synthetic */ Object d() {
        return this.s();
    }

    @Override
    protected void j() {
        this.o.drainPermits();
        this.l();
    }

    public Void s() {
        Iterator iterator = this.p.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            int n3 = ((n)iterator.next()).a(this) ? n2 + 1 : n2;
            n2 = n3;
        }
        try {
            this.o.tryAcquire(n2, 5, TimeUnit.SECONDS);
            return null;
        }
        catch (InterruptedException var3_4) {
            Log.i((String)"GACSignInLoader", (String)"Unexpected InterruptedException", (Throwable)var3_4);
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override
    public void t() {
        this.o.release();
    }
}

