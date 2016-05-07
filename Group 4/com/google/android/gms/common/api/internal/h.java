/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.api.internal.al;
import com.google.android.gms.common.api.internal.at;
import com.google.android.gms.common.api.internal.au;
import com.google.android.gms.common.api.internal.ay;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.api.internal.z;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.t;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

public class h
implements at {
    private final Context a;
    private final z b;
    private final Looper c;
    private final al d;
    private final al e;
    private final Map f = new android.support.v4.g.a();
    private final Set g = Collections.newSetFromMap(new WeakHashMap());
    private final com.google.android.gms.common.api.h h;
    private Bundle i;
    private ConnectionResult j = null;
    private ConnectionResult k = null;
    private boolean l = false;
    private final Lock m;
    private int n = 0;

    public h(Context context, z z2, Lock lock, Looper looper, com.google.android.gms.common.j j2, Map map, t t2, Map map2, g g2, ArrayList arrayList) {
        this.a = context;
        this.b = z2;
        this.m = lock;
        this.c = looper;
        com.google.android.gms.common.api.h h2 = null;
        android.support.v4.g.a a2 = new android.support.v4.g.a();
        android.support.v4.g.a a3 = new android.support.v4.g.a();
        for (i i2 : map.keySet()) {
            com.google.android.gms.common.api.h h3 = (com.google.android.gms.common.api.h)map.get(i2);
            if (h3.d()) {
                h2 = h3;
            }
            if (h3.i()) {
                a2.put(i2, h3);
                continue;
            }
            a3.put(i2, h3);
        }
        this.h = h2;
        if (a2.isEmpty()) {
            throw new IllegalStateException("CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        }
        android.support.v4.g.a a4 = new android.support.v4.g.a();
        android.support.v4.g.a a5 = new android.support.v4.g.a();
        for (a a6 : map2.keySet()) {
            i i3 = a6.c();
            if (a2.containsKey(i3)) {
                a4.put(a6, map2.get(a6));
                continue;
            }
            if (!a3.containsKey(i3)) throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
            a5.put(a6, map2.get(a6));
        }
        ArrayList<com.google.android.gms.common.api.internal.g> arrayList2 = new ArrayList<com.google.android.gms.common.api.internal.g>();
        ArrayList<com.google.android.gms.common.api.internal.g> arrayList3 = new ArrayList<com.google.android.gms.common.api.internal.g>();
        for (com.google.android.gms.common.api.internal.g g3 : arrayList) {
            if (a4.containsKey(g3.a)) {
                arrayList2.add(g3);
                continue;
            }
            if (!a5.containsKey(g3.a)) throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
            arrayList3.add(g3);
        }
        com.google.android.gms.common.api.internal.i i4 = new com.google.android.gms.common.api.internal.i(this);
        this.d = new al(context, this.b, lock, looper, j2, a3, null, a5, null, arrayList3, i4);
        j j3 = new j(this);
        this.e = new al(context, this.b, lock, looper, j2, a2, t2, a4, g2, arrayList2, j3);
        for (i i5 : a3.keySet()) {
            this.f.put(i5, this.d);
        }
        Iterator iterator = a2.keySet().iterator();
        while (iterator.hasNext()) {
            i i6 = (i)iterator.next();
            this.f.put(i6, this.e);
        }
    }

    static /* synthetic */ ConnectionResult a(h h2, ConnectionResult connectionResult) {
        h2.j = connectionResult;
        return connectionResult;
    }

    static /* synthetic */ Lock a(h h2) {
        return h2.m;
    }

    private void a(int n2, boolean bl2) {
        this.b.a(n2, bl2);
        this.k = null;
        this.j = null;
    }

    private void a(Bundle bundle) {
        if (this.i == null) {
            this.i = bundle;
            return;
        }
        if (bundle == null) return;
        this.i.putAll(bundle);
    }

    private void a(ConnectionResult connectionResult) {
        switch (this.n) {
            default: {
                Log.wtf((String)"CompositeGAC", (String)"Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", (Throwable)new Exception());
                break;
            }
            case 2: {
                this.b.a(connectionResult);
            }
            case 1: {
                this.l();
            }
        }
        this.n = 0;
    }

    static /* synthetic */ void a(h h2, int n2, boolean bl2) {
        h2.a(n2, bl2);
    }

    static /* synthetic */ void a(h h2, Bundle bundle) {
        h2.a(bundle);
    }

    static /* synthetic */ boolean a(h h2, boolean bl2) {
        h2.l = bl2;
        return bl2;
    }

    static /* synthetic */ ConnectionResult b(h h2, ConnectionResult connectionResult) {
        h2.k = connectionResult;
        return connectionResult;
    }

    static /* synthetic */ void b(h h2) {
        h2.j();
    }

    private static boolean b(ConnectionResult connectionResult) {
        if (connectionResult == null) return false;
        if (!connectionResult.b()) return false;
        return true;
    }

    private boolean b(c c2) {
        i i2 = c2.b();
        bf.b(this.f.containsKey(i2), "GoogleApiClient is not configured to use the API required for this call.");
        return ((al)this.f.get(i2)).equals(this.e);
    }

    static /* synthetic */ boolean c(h h2) {
        return h2.l;
    }

    static /* synthetic */ ConnectionResult d(h h2) {
        return h2.k;
    }

    static /* synthetic */ al e(h h2) {
        return h2.e;
    }

    static /* synthetic */ al f(h h2) {
        return h2.d;
    }

    private void i() {
        this.k = null;
        this.j = null;
        this.d.a();
        this.e.a();
    }

    private void j() {
        if (h.b(this.j)) {
            if (h.b(this.k) || this.m()) {
                this.k();
                return;
            }
            if (this.k == null) return;
            if (this.n == 1) {
                this.l();
                return;
            }
            this.a(this.k);
            this.d.c();
            return;
        }
        if (this.j != null && h.b(this.k)) {
            this.e.c();
            this.a(this.j);
            return;
        }
        if (this.j == null) return;
        if (this.k == null) return;
        ConnectionResult connectionResult = this.j;
        if (this.e.f < this.d.f) {
            connectionResult = this.k;
        }
        this.a(connectionResult);
    }

    private void k() {
        switch (this.n) {
            default: {
                Log.wtf((String)"CompositeGAC", (String)"Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", (Throwable)new Exception());
                break;
            }
            case 2: {
                this.b.a(this.i);
            }
            case 1: {
                this.l();
            }
        }
        this.n = 0;
    }

    private void l() {
        Iterator iterator = this.g.iterator();
        do {
            if (!iterator.hasNext()) {
                this.g.clear();
                return;
            }
            ((ay)iterator.next()).t();
        } while (true);
    }

    private boolean m() {
        if (this.k == null) return false;
        if (this.k.c() != 4) return false;
        return true;
    }

    private PendingIntent n() {
        if (this.h != null) return PendingIntent.getActivity((Context)this.a, (int)this.b.q(), (Intent)this.h.e(), (int)134217728);
        return null;
    }

    @Override
    public c a(c c2) {
        if (!this.b(c2)) return this.d.a(c2);
        if (!this.m()) return this.e.a(c2);
        c2.c(new Status(4, null, this.n()));
        return c2;
    }

    @Override
    public void a() {
        this.n = 2;
        this.l = false;
        this.i();
    }

    @Override
    public void a(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
        printWriter.append(string).append("authClient").println(":");
        this.e.a(string + "  ", fileDescriptor, printWriter, arrstring);
        printWriter.append(string).append("anonClient").println(":");
        this.d.a(string + "  ", fileDescriptor, printWriter, arrstring);
    }

    @Override
    public boolean a(ay ay2) {
        this.m.lock();
        try {
            if (!this.e()) {
                if (!this.d()) return false;
            }
            if (this.h()) return false;
            this.g.add(ay2);
            if (this.n == 0) {
                this.n = 1;
            }
            this.k = null;
            this.e.a();
            return true;
        }
        finally {
            this.m.unlock();
        }
    }

    @Override
    public ConnectionResult b() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean c() {
        this.k = null;
        this.j = null;
        this.n = 0;
        boolean bl2 = this.d.c();
        boolean bl3 = this.e.c();
        this.l();
        boolean bl4 = false;
        if (!bl2) return bl4;
        bl4 = false;
        if (!bl3) return bl4;
        return true;
    }

    @Override
    public boolean d() {
        int n2 = 1;
        this.m.lock();
        try {
            if (this.d.d()) {
                if (this.h()) return (boolean)n2;
                if (this.m()) return (boolean)n2;
                int n3 = this.n;
                if (n3 == n2) return (boolean)n2;
            }
            n2 = 0;
            return (boolean)n2;
        }
        finally {
            this.m.unlock();
        }
    }

    public boolean e() {
        this.m.lock();
        try {
            int n2 = this.n;
            boolean bl2 = n2 == 2;
            return bl2;
        }
        finally {
            this.m.unlock();
        }
    }

    @Override
    public void f() {
        this.d.f();
        this.e.f();
    }

    @Override
    public void g() {
        this.m.lock();
        try {
            boolean bl2 = this.e();
            this.e.c();
            this.k = new ConnectionResult(4);
            if (bl2) {
                new Handler(this.c).post((Runnable)new k(this));
                return;
            }
            this.l();
            return;
        }
        finally {
            this.m.unlock();
        }
    }

    public boolean h() {
        return this.e.d();
    }
}

