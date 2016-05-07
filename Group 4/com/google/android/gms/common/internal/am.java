/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.ak;
import com.google.android.gms.common.internal.al;
import com.google.android.gms.common.internal.an;
import java.util.HashSet;
import java.util.Set;

final class am {
    final /* synthetic */ ak a;
    private final an b;
    private final Set c;
    private int d;
    private boolean e;
    private IBinder f;
    private final al g;
    private ComponentName h;

    public am(ak ak2, al al2) {
        this.a = ak2;
        this.g = al2;
        this.b = new an(this);
        this.c = new HashSet();
        this.d = 2;
    }

    static /* synthetic */ int a(am am2, int n2) {
        am2.d = n2;
        return n2;
    }

    static /* synthetic */ ComponentName a(am am2, ComponentName componentName) {
        am2.h = componentName;
        return componentName;
    }

    static /* synthetic */ IBinder a(am am2, IBinder iBinder) {
        am2.f = iBinder;
        return iBinder;
    }

    static /* synthetic */ al a(am am2) {
        return am2.g;
    }

    static /* synthetic */ Set b(am am2) {
        return am2.c;
    }

    public void a(ServiceConnection serviceConnection, String string) {
        ak.c(this.a).a(ak.b(this.a), serviceConnection, string, this.g.a());
        this.c.add(serviceConnection);
    }

    @TargetApi(value=14)
    public void a(String string) {
        this.d = 3;
        this.e = ak.c(this.a).a(ak.b(this.a), string, this.g.a(), this.b, 129);
        if (this.e) return;
        this.d = 2;
        try {
            ak.c(this.a).a(ak.b(this.a), this.b);
            return;
        }
        catch (IllegalArgumentException var2_2) {
            return;
        }
    }

    public boolean a() {
        return this.e;
    }

    public boolean a(ServiceConnection serviceConnection) {
        return this.c.contains((Object)serviceConnection);
    }

    public int b() {
        return this.d;
    }

    public void b(ServiceConnection serviceConnection, String string) {
        ak.c(this.a).b(ak.b(this.a), serviceConnection);
        this.c.remove((Object)serviceConnection);
    }

    public void b(String string) {
        ak.c(this.a).a(ak.b(this.a), this.b);
        this.e = false;
        this.d = 2;
    }

    public boolean c() {
        return this.c.isEmpty();
    }

    public IBinder d() {
        return this.f;
    }

    public ComponentName e() {
        return this.h;
    }
}

