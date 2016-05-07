/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.api.internal.ak;
import com.google.android.gms.common.api.internal.am;
import com.google.android.gms.common.api.internal.an;
import com.google.android.gms.common.api.internal.at;
import com.google.android.gms.common.api.internal.au;
import com.google.android.gms.common.api.internal.ay;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.common.api.internal.o;
import com.google.android.gms.common.api.internal.y;
import com.google.android.gms.common.api.internal.z;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.j;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class al
implements at {
    final Map a;
    final Map b = new HashMap();
    final t c;
    final Map d;
    final g e;
    int f;
    final z g;
    final au h;
    private final Lock i;
    private final Condition j;
    private final Context k;
    private final j l;
    private final an m;
    private volatile ak n;
    private ConnectionResult o = null;

    public al(Context context, z z2, Lock lock, Looper looper, j j2, Map map, t t2, Map map2, g g2, ArrayList arrayList, au au2) {
        this.k = context;
        this.i = lock;
        this.l = j2;
        this.a = map;
        this.c = t2;
        this.d = map2;
        this.e = g2;
        this.g = z2;
        this.h = au2;
        Iterator iterator = arrayList.iterator();
        do {
            if (!iterator.hasNext()) {
                this.m = new an(this, looper);
                this.j = lock.newCondition();
                this.n = new y(this);
                return;
            }
            ((com.google.android.gms.common.api.internal.g)iterator.next()).a(this);
        } while (true);
    }

    static /* synthetic */ Lock a(al al2) {
        return al2.i;
    }

    static /* synthetic */ ak b(al al2) {
        return al2.n;
    }

    @Override
    public c a(c c2) {
        return this.n.a(c2);
    }

    @Override
    public void a() {
        this.n.c();
    }

    public void a(int n2) {
        this.i.lock();
        try {
            this.n.a(n2);
            return;
        }
        finally {
            this.i.unlock();
        }
    }

    public void a(Bundle bundle) {
        this.i.lock();
        try {
            this.n.a(bundle);
            return;
        }
        finally {
            this.i.unlock();
        }
    }

    void a(ConnectionResult connectionResult) {
        this.i.lock();
        try {
            this.o = connectionResult;
            this.n = new y(this);
            this.n.a();
            this.j.signalAll();
            return;
        }
        finally {
            this.i.unlock();
        }
    }

    public void a(ConnectionResult connectionResult, a a2, int n2) {
        this.i.lock();
        try {
            this.n.a(connectionResult, a2, n2);
            return;
        }
        finally {
            this.i.unlock();
        }
    }

    void a(am am2) {
        Message message = this.m.obtainMessage(1, (Object)am2);
        this.m.sendMessage(message);
    }

    void a(RuntimeException runtimeException) {
        Message message = this.m.obtainMessage(2, (Object)runtimeException);
        this.m.sendMessage(message);
    }

    @Override
    public void a(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
        String string2 = string + "  ";
        Iterator iterator = this.d.keySet().iterator();
        while (iterator.hasNext()) {
            a a2 = (a)iterator.next();
            printWriter.append(string).append(a2.e()).println(":");
            ((h)this.a.get(a2.c())).a(string2, fileDescriptor, printWriter, arrstring);
        }
    }

    @Override
    public boolean a(ay ay2) {
        return false;
    }

    @Override
    public ConnectionResult b() {
        this.a();
        while (this.j()) {
            try {
                this.j.await();
                continue;
            }
            catch (InterruptedException var1_1) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (this.d()) {
            return ConnectionResult.a;
        }
        if (this.o == null) return new ConnectionResult(13, null);
        return this.o;
    }

    @Override
    public boolean c() {
        boolean bl2 = this.n.b();
        if (!bl2) return bl2;
        this.b.clear();
        return bl2;
    }

    @Override
    public boolean d() {
        return this.n instanceof l;
    }

    void e() {
        this.i.lock();
        try {
            this.n = new o(this, this.c, this.d, this.l, this.e, this.i, this.k);
            this.n.a();
            this.j.signalAll();
            return;
        }
        finally {
            this.i.unlock();
        }
    }

    @Override
    public void f() {
        if (!this.d()) return;
        ((l)this.n).d();
    }

    @Override
    public void g() {
    }

    void h() {
        this.i.lock();
        try {
            this.g.n();
            this.n = new l(this);
            this.n.a();
            this.j.signalAll();
            return;
        }
        finally {
            this.i.unlock();
        }
    }

    void i() {
        Iterator iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            ((h)iterator.next()).g();
        }
    }

    public boolean j() {
        return this.n instanceof o;
    }
}

