/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import com.google.android.gms.b.kf;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.stats.b;
import com.google.android.gms.measurement.AppMeasurementService;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import com.google.android.gms.measurement.internal.ac;
import com.google.android.gms.measurement.internal.ag;
import com.google.android.gms.measurement.internal.ai;
import com.google.android.gms.measurement.internal.aj;
import com.google.android.gms.measurement.internal.ak;
import com.google.android.gms.measurement.internal.ao;
import com.google.android.gms.measurement.internal.aq;
import com.google.android.gms.measurement.internal.ax;
import com.google.android.gms.measurement.internal.ba;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.bn;
import com.google.android.gms.measurement.internal.bs;
import com.google.android.gms.measurement.internal.bt;
import com.google.android.gms.measurement.internal.bx;
import com.google.android.gms.measurement.internal.cc;
import com.google.android.gms.measurement.internal.cl;
import com.google.android.gms.measurement.internal.d;
import com.google.android.gms.measurement.internal.j;
import com.google.android.gms.measurement.internal.k;
import com.google.android.gms.measurement.internal.l;
import com.google.android.gms.measurement.internal.m;
import com.google.android.gms.measurement.internal.n;
import com.google.android.gms.measurement.internal.o;
import com.google.android.gms.measurement.internal.p;
import com.google.android.gms.measurement.internal.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class i
extends cl {
    private final p a;
    private ax b;
    private Boolean c;
    private final ao d;
    private final ac e;
    private final List f = new ArrayList();
    private final ao g;

    protected i(bx bx2) {
        super(bx2);
        this.e = new ac(bx2.q());
        this.a = new p(this);
        this.d = new j(this, bx2);
        this.g = new k(this, bx2);
    }

    private boolean A() {
        this.f();
        this.G();
        if (this.u().N()) {
            return true;
        }
        this.s().z().a("Checking service availability");
        switch (com.google.android.gms.common.j.b().a(this.m())) {
            default: {
                return false;
            }
            case 0: {
                this.s().z().a("Service available");
                return true;
            }
            case 1: {
                this.s().z().a("Service missing");
                return false;
            }
            case 18: {
                this.s().z().a("Service updating");
                return true;
            }
            case 2: {
                this.s().z().a("Service version update required");
                return false;
            }
            case 3: {
                this.s().z().a("Service disabled");
                return false;
            }
            case 9: 
        }
        this.s().z().a("Service invalid");
        return false;
    }

    private void B() {
        this.f();
        if (!this.b()) {
            return;
        }
        this.s().z().a("Inactivity, disconnecting from AppMeasurementService");
        this.w();
    }

    private void C() {
        this.f();
        this.y();
    }

    private void D() {
        this.f();
        this.s().z().a("Processing queued up service tasks", this.f.size());
        Iterator iterator = this.f.iterator();
        do {
            if (!iterator.hasNext()) {
                this.f.clear();
                this.g.c();
                return;
            }
            Runnable runnable = (Runnable)iterator.next();
            this.r().a(runnable);
        } while (true);
    }

    static /* synthetic */ p a(i i2) {
        return i2.a;
    }

    private void a(ComponentName componentName) {
        this.f();
        if (this.b == null) return;
        this.b = null;
        this.s().z().a("Disconnected from device MeasurementService", (Object)componentName);
        this.C();
    }

    private void a(ax ax2) {
        this.f();
        bf.a(ax2);
        this.b = ax2;
        this.x();
        this.D();
    }

    static /* synthetic */ void a(i i2, ComponentName componentName) {
        i2.a(componentName);
    }

    static /* synthetic */ void a(i i2, ax ax2) {
        i2.a(ax2);
    }

    private void a(Runnable runnable) {
        this.f();
        if (this.b()) {
            runnable.run();
            return;
        }
        if ((long)this.f.size() >= this.u().R()) {
            this.s().b().a("Discarding data. Max runnable queue size reached");
            return;
        }
        this.f.add(runnable);
        if (!this.n.y()) {
            this.g.a(60000);
        }
        this.y();
    }

    static /* synthetic */ void b(i i2) {
        i2.B();
    }

    static /* synthetic */ ax c(i i2) {
        return i2.b;
    }

    static /* synthetic */ void d(i i2) {
        i2.x();
    }

    private void x() {
        this.f();
        this.e.a();
        if (this.n.y()) return;
        this.d.a(this.u().J());
    }

    private void y() {
        this.f();
        this.G();
        if (this.b()) {
            return;
        }
        if (this.c == null) {
            this.c = this.t().v();
            if (this.c == null) {
                this.s().z().a("State of service unknown");
                this.c = this.A();
                this.t().a(this.c);
            }
        }
        if (this.c.booleanValue()) {
            this.s().z().a("Using measurement service");
            this.a.a();
            return;
        }
        if (this.z() && !this.n.y()) {
            this.s().z().a("Using local app measurement service");
            Intent intent = new Intent("com.google.android.gms.measurement.START");
            intent.setComponent(new ComponentName(this.m(), (Class)AppMeasurementService.class));
            this.a.a(intent);
            return;
        }
        if (this.u().O()) {
            this.s().z().a("Using direct local measurement implementation");
            this.a(new cc(this.n, true));
            return;
        }
        this.s().b().a("Not in main process. Unable to use local measurement implementation. Please register the AppMeasurementService service in the app manifest");
    }

    private boolean z() {
        List list = this.m().getPackageManager().queryIntentServices(new Intent(this.m(), (Class)AppMeasurementService.class), 65536);
        if (list == null) return false;
        if (list.size() <= 0) return false;
        return true;
    }

    @Override
    protected void a() {
    }

    protected void a(EventParcel eventParcel, String string) {
        bf.a(eventParcel);
        this.f();
        this.G();
        this.a(new m(this, string, eventParcel));
    }

    protected void a(UserAttributeParcel userAttributeParcel) {
        this.f();
        this.G();
        this.a(new n(this, userAttributeParcel));
    }

    public boolean b() {
        this.f();
        this.G();
        if (this.b == null) return false;
        return true;
    }

    protected void c() {
        this.f();
        this.G();
        this.a(new l(this));
    }

    protected void v() {
        this.f();
        this.G();
        this.a(new o(this));
    }

    public void w() {
        this.f();
        this.G();
        try {
            b.a().a(this.m(), this.a);
        }
        catch (IllegalStateException var2_1) {
        }
        catch (IllegalArgumentException var1_2) {}
        this.b = null;
    }
}

