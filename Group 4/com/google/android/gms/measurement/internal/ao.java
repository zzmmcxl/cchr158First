/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.b.kf;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.measurement.internal.ap;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.bx;

abstract class ao {
    private static volatile Handler b;
    private final bx a;
    private final Runnable c;
    private volatile long d;
    private boolean e;

    ao(bx bx2) {
        bf.a(bx2);
        this.a = bx2;
        this.e = true;
        this.c = new ap(this);
    }

    static /* synthetic */ long a(ao ao2, long l2) {
        ao2.d = l2;
        return l2;
    }

    static /* synthetic */ bx a(ao ao2) {
        return ao2.a;
    }

    static /* synthetic */ boolean b(ao ao2) {
        return ao2.e;
    }

    private Handler d() {
        if (b != null) {
            return b;
        }
        // MONITORENTER : com.google.android.gms.measurement.internal.ao.class
        if (b == null) {
            b = new Handler(this.a.p().getMainLooper());
        }
        Handler handler = b;
        // MONITOREXIT : com.google.android.gms.measurement.internal.ao.class
        return handler;
    }

    public abstract void a();

    public void a(long l2) {
        this.c();
        if (l2 < 0) return;
        this.d = this.a.q().a();
        if (this.d().postDelayed(this.c, l2)) return;
        this.a.f().b().a("Failed to schedule delayed post. time", l2);
    }

    public boolean b() {
        if (this.d == 0) return false;
        return true;
    }

    public void c() {
        this.d = 0;
        this.d().removeCallbacks(this.c);
    }
}

