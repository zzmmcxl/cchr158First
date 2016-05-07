/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.b.kf;
import com.google.android.gms.measurement.internal.aa;
import com.google.android.gms.measurement.internal.ag;
import com.google.android.gms.measurement.internal.ai;
import com.google.android.gms.measurement.internal.aj;
import com.google.android.gms.measurement.internal.ak;
import com.google.android.gms.measurement.internal.ao;
import com.google.android.gms.measurement.internal.aq;
import com.google.android.gms.measurement.internal.ba;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.bn;
import com.google.android.gms.measurement.internal.bp;
import com.google.android.gms.measurement.internal.bq;
import com.google.android.gms.measurement.internal.bs;
import com.google.android.gms.measurement.internal.bt;
import com.google.android.gms.measurement.internal.bx;
import com.google.android.gms.measurement.internal.cl;
import com.google.android.gms.measurement.internal.d;
import com.google.android.gms.measurement.internal.i;
import com.google.android.gms.measurement.internal.v;
import com.google.android.gms.measurement.internal.x;
import com.google.android.gms.measurement.internal.y;
import com.google.android.gms.measurement.internal.z;

public class u
extends cl {
    private Handler a;
    private long b;
    private final Runnable c;
    private final ao d;
    private final ao e;

    u(bx bx2) {
        super(bx2);
        this.c = new v(this);
        this.d = new x(this, this.n);
        this.e = new y(this, this.n);
    }

    private void a(long l2) {
        this.f();
        this.w();
        this.d.c();
        this.e.c();
        this.s().z().a("Activity resumed, time", l2);
        this.b = l2;
        if (this.l().a() - this.t().i.a() > this.t().k.a()) {
            this.t().j.a(true);
            this.t().l.a(0);
        }
        if (this.t().j.a()) {
            this.d.a(Math.max(0, this.t().h.a() - this.t().l.a()));
            return;
        }
        this.e.a(Math.max(0, 3600000 - this.t().l.a()));
    }

    static /* synthetic */ void a(u u2) {
        u2.x();
    }

    static /* synthetic */ void a(u u2, long l2) {
        u2.a(l2);
    }

    private void b(long l2) {
        this.f();
        this.w();
        this.d.c();
        this.e.c();
        this.s().z().a("Activity paused, time", l2);
        if (this.b != 0) {
            this.t().l.a(this.t().l.a() + (l2 - this.b));
        }
        this.t().k.a(this.l().a());
        // MONITORENTER : this
        if (!this.t().j.a()) {
            this.a.postDelayed(this.c, 1000);
        }
        // MONITOREXIT : this
        return;
    }

    static /* synthetic */ void b(u u2) {
        u2.y();
    }

    static /* synthetic */ void b(u u2, long l2) {
        u2.b(l2);
    }

    private void w() {
        // MONITORENTER : this
        if (this.a == null) {
            this.a = new Handler(Looper.getMainLooper());
        }
        // MONITOREXIT : this
        return;
    }

    private void x() {
        this.f();
        long l2 = this.l().b();
        this.s().z().a("Session started, time", l2);
        this.t().j.a(false);
        this.h().a("auto", "_s", new Bundle());
    }

    private void y() {
        this.f();
        long l2 = this.l().b();
        if (this.b == 0) {
            this.b = l2 - 3600000;
        }
        long l3 = this.t().l.a() + (l2 - this.b);
        this.t().l.a(l3);
        this.s().z().a("Recording user engagement, ms", l3);
        Bundle bundle = new Bundle();
        bundle.putLong("_et", l3);
        this.h().a("auto", "_e", bundle);
        this.t().l.a(0);
        this.b = l2;
        this.e.a(Math.max(0, 3600000 - this.t().l.a()));
    }

    @Override
    protected void a() {
    }

    /*
     * Enabled unnecessary exception pruning
     */
    protected void b() {
        // MONITORENTER : this
        this.w();
        this.a.removeCallbacks(this.c);
        // MONITOREXIT : this
        long l2 = this.l().b();
        this.r().a(new z(this, l2));
    }

    protected void c() {
        long l2 = this.l().b();
        this.r().a(new aa(this, l2));
    }

    public void v() {
        this.f();
        this.s().y().a("Application backgrounded. Logging engagement");
        long l2 = this.t().l.a();
        if (l2 > 0) {
            Bundle bundle = new Bundle();
            bundle.putLong("_et", l2);
            this.h().a("auto", "_e", bundle);
            this.t().l.a(0);
            return;
        }
        this.s().c().a("Not logging non-positive engagement time", l2);
    }
}

