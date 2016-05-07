/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.b.kf;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.measurement.b;
import com.google.android.gms.measurement.internal.EventParams;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import com.google.android.gms.measurement.internal.ag;
import com.google.android.gms.measurement.internal.ai;
import com.google.android.gms.measurement.internal.aj;
import com.google.android.gms.measurement.internal.ak;
import com.google.android.gms.measurement.internal.aq;
import com.google.android.gms.measurement.internal.ba;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.bn;
import com.google.android.gms.measurement.internal.bs;
import com.google.android.gms.measurement.internal.bt;
import com.google.android.gms.measurement.internal.bx;
import com.google.android.gms.measurement.internal.cl;
import com.google.android.gms.measurement.internal.e;
import com.google.android.gms.measurement.internal.f;
import com.google.android.gms.measurement.internal.g;
import com.google.android.gms.measurement.internal.h;
import com.google.android.gms.measurement.internal.i;
import com.google.android.gms.measurement.internal.u;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

public class d
extends cl {
    private h a;
    private b b;
    private boolean c;

    protected d(bx bx2) {
        super(bx2);
    }

    static /* synthetic */ void a(d d2, String string, String string2, long l2, Bundle bundle, boolean bl2, String string3) {
        d2.b(string, string2, l2, bundle, bl2, string3);
    }

    static /* synthetic */ void a(d d2, String string, String string2, Object object, long l2) {
        d2.a(string, string2, object, l2);
    }

    static /* synthetic */ void a(d d2, boolean bl2) {
        d2.a(bl2);
    }

    private void a(String string, String string2, Bundle bundle, boolean bl2, String string3) {
        this.a(string, string2, bundle, bl2, string3, this.l().a());
    }

    private void a(String string, String string2, Bundle bundle, boolean bl2, String string3, long l2) {
        bf.a(string);
        this.o().b(string2);
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            int n2 = this.u().b();
            Iterator iterator = bundle.keySet().iterator();
            int n3 = 0;
            while (iterator.hasNext()) {
                Object object;
                String string4 = (String)iterator.next();
                this.o().d(string4);
                if (ag.a(string4)) {
                    int n4 = n3 + 1;
                    boolean bl3 = n4 <= n2;
                    bf.b(bl3, "Event can't contain more then " + n2 + " params");
                    n3 = n4;
                }
                if ((object = this.o().a(string4, bundle.get(string4))) == null) continue;
                this.o().a(bundle2, string4, object);
            }
        }
        int n5 = this.u().w();
        String string5 = string.length() <= n5 ? string : string.substring(0, n5);
        bundle2.putString("_o", string5);
        this.a(string, string2, l2, bundle2, bl2, string3);
    }

    private void a(String string, String string2, Object object, long l2) {
        bf.a(string);
        bf.a(string2);
        this.f();
        this.d();
        this.G();
        if (!this.t().w()) {
            this.s().y().a("User property not set since app measurement is disabled");
            return;
        }
        if (!this.n.b()) return;
        this.s().y().a("Setting user property (FE)", string2, object);
        UserAttributeParcel userAttributeParcel = new UserAttributeParcel(string2, l2, object, string);
        this.k().a(userAttributeParcel);
    }

    private void a(boolean bl2) {
        this.f();
        this.d();
        this.G();
        this.s().y().a("Setting app measurement enabled (FE)", bl2);
        this.t().b(bl2);
        this.k().c();
    }

    private void b(String string, String string2, long l2, Bundle bundle, boolean bl2, String string3) {
        bf.a(string);
        bf.a(string2);
        bf.a((Object)bundle);
        this.f();
        this.G();
        if (!this.t().w()) {
            this.s().y().a("Event not sent since app measurement is disabled");
            return;
        }
        if (!this.c) {
            this.c = true;
            this.v();
        }
        if (bl2 && this.b != null && !ag.g(string2)) {
            this.s().y().a("Passing event to registered event handler (FE)", string2, (Object)bundle);
            this.b.a(string, string2, bundle, l2);
            return;
        }
        if (!this.n.b()) return;
        this.s().y().a("Logging event (FE)", string2, (Object)bundle);
        EventParcel eventParcel = new EventParcel(string2, new EventParams(bundle), string, l2);
        this.k().a(eventParcel, string3);
    }

    private void v() {
        try {
            this.a(Class.forName(this.w()));
            return;
        }
        catch (ClassNotFoundException var1_1) {
            this.s().x().a("Tag Manager is not found and thus will not be used");
            return;
        }
    }

    private String w() {
        return "com.google.android.gms.tagmanager.TagManagerService";
    }

    @Override
    protected void a() {
    }

    public void a(Class class_) {
        try {
            Method method = class_.getDeclaredMethod("initialize", Context.class);
            Object[] arrobject = new Object[]{this.m()};
            method.invoke(null, arrobject);
            return;
        }
        catch (Exception var2_4) {
            this.s().c().a("Failed to invoke Tag Manager's initialize() method", var2_4);
            return;
        }
    }

    protected void a(String string, String string2, long l2, Bundle bundle, boolean bl2, String string3) {
        bf.a((Object)bundle);
        this.r().a(new f(this, string, string2, l2, bundle, bl2, string3));
    }

    void a(String string, String string2, long l2, Object object) {
        this.r().a(new g(this, string, string2, object, l2));
    }

    public void a(String string, String string2, Bundle bundle) {
        this.d();
        this.a(string, string2, bundle, true, null);
    }

    public void a(String string, String string2, Object object) {
        bf.a(string);
        long l2 = this.l().a();
        this.o().c(string2);
        if (object != null) {
            this.o().b(string2, object);
            Object object2 = this.o().c(string2, object);
            if (object2 == null) return;
            this.a(string, string2, l2, object2);
            return;
        }
        this.a(string, string2, l2, null);
    }

    @TargetApi(value=14)
    public void b() {
        if (!(this.m().getApplicationContext() instanceof Application)) return;
        Application application = (Application)this.m().getApplicationContext();
        if (this.a == null) {
            this.a = new h(this, null);
        }
        application.unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this.a);
        application.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this.a);
        this.s().z().a("Registered activity lifecycle callback");
    }

    public void c() {
        this.f();
        this.d();
        this.G();
        if (!this.n.b()) {
            return;
        }
        this.k().v();
        String string = this.t().x();
        if (TextUtils.isEmpty((CharSequence)string)) return;
        if (string.equals(this.j().c())) return;
        Bundle bundle = new Bundle();
        bundle.putString("_po", string);
        this.a("auto", "_ou", bundle);
    }
}

