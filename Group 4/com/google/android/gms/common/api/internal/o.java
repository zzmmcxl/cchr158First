/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.b.lz;
import com.google.android.gms.b.ma;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.api.internal.ak;
import com.google.android.gms.common.api.internal.al;
import com.google.android.gms.common.api.internal.ao;
import com.google.android.gms.common.api.internal.au;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.api.internal.p;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.common.api.internal.z;
import com.google.android.gms.common.api.q;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.common.j;
import com.google.android.gms.signin.internal.SignInResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public class o
implements ak {
    private final al a;
    private final Lock b;
    private final Context c;
    private final j d;
    private ConnectionResult e;
    private int f;
    private int g = 0;
    private int h;
    private final Bundle i = new Bundle();
    private final Set j = new HashSet();
    private lz k;
    private int l;
    private boolean m;
    private boolean n;
    private ap o;
    private boolean p;
    private boolean q;
    private final com.google.android.gms.common.internal.t r;
    private final Map s;
    private final g t;
    private ArrayList u = new ArrayList();

    public o(al al2, com.google.android.gms.common.internal.t t2, Map map, j j2, g g2, Lock lock, Context context) {
        this.a = al2;
        this.r = t2;
        this.s = map;
        this.d = j2;
        this.t = g2;
        this.b = lock;
        this.c = context;
    }

    static /* synthetic */ Context a(o o2) {
        return o2.c;
    }

    static /* synthetic */ void a(o o2, ConnectionResult connectionResult) {
        o2.c(connectionResult);
    }

    static /* synthetic */ void a(o o2, ConnectionResult connectionResult, a a2, int n2) {
        o2.b(connectionResult, a2, n2);
    }

    static /* synthetic */ void a(o o2, SignInResponse signInResponse) {
        o2.a(signInResponse);
    }

    private void a(SignInResponse signInResponse) {
        if (!this.b(0)) {
            return;
        }
        ConnectionResult connectionResult = signInResponse.a();
        if (connectionResult.b()) {
            ResolveAccountResponse resolveAccountResponse = signInResponse.b();
            ConnectionResult connectionResult2 = resolveAccountResponse.b();
            if (!connectionResult2.b()) {
                Log.wtf((String)"GoogleApiClientConnecting", (String)("Sign-in succeeded with resolve account failure: " + connectionResult2), (Throwable)new Exception());
                this.c(connectionResult2);
                return;
            }
            this.n = true;
            this.o = resolveAccountResponse.a();
            this.p = resolveAccountResponse.c();
            this.q = resolveAccountResponse.d();
            this.e();
            return;
        }
        if (this.b(connectionResult)) {
            this.h();
            this.e();
            return;
        }
        this.c(connectionResult);
    }

    private void a(boolean bl2) {
        if (this.k == null) return;
        if (this.k.h() && bl2) {
            this.k.f();
        }
        this.k.g();
        this.o = null;
    }

    private boolean a(int n2, int n3, ConnectionResult connectionResult) {
        if (n3 == 1 && !this.a(connectionResult)) {
            return false;
        }
        if (this.e == null) return true;
        if (n2 >= this.f) return false;
        return true;
    }

    private boolean a(ConnectionResult connectionResult) {
        if (connectionResult.a()) {
            return true;
        }
        if (this.d.b(connectionResult.c()) != null) return true;
        return false;
    }

    static /* synthetic */ boolean a(o o2, int n2) {
        return o2.b(n2);
    }

    static /* synthetic */ j b(o o2) {
        return o2.d;
    }

    private void b(ConnectionResult connectionResult, a a2, int n2) {
        int n3;
        if (n2 != 2 && this.a(n3 = a2.a().a(), n2, connectionResult)) {
            this.e = connectionResult;
            this.f = n3;
        }
        this.a.b.put(a2.c(), connectionResult);
    }

    private boolean b(int n2) {
        if (this.g == n2) return true;
        Log.i((String)"GoogleApiClientConnecting", (String)this.a.g.p());
        Log.wtf((String)"GoogleApiClientConnecting", (String)("GoogleApiClient connecting is in step " + this.c(this.g) + " but received callback for step " + this.c(n2)), (Throwable)new Exception());
        this.c(new ConnectionResult(8, null));
        return false;
    }

    private boolean b(ConnectionResult connectionResult) {
        if (this.l == 2) return true;
        if (this.l != 1) return false;
        if (connectionResult.a()) return false;
        return true;
    }

    static /* synthetic */ boolean b(o o2, ConnectionResult connectionResult) {
        return o2.b(connectionResult);
    }

    private String c(int n2) {
        switch (n2) {
            default: {
                return "UNKNOWN";
            }
            case 0: {
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            }
            case 1: 
        }
        return "STEP_GETTING_REMOTE_SERVICE";
    }

    static /* synthetic */ Lock c(o o2) {
        return o2.b;
    }

    private void c(ConnectionResult connectionResult) {
        this.i();
        boolean bl2 = !connectionResult.a();
        this.a(bl2);
        this.a.a(connectionResult);
        this.a.h.a(connectionResult);
    }

    static /* synthetic */ al d(o o2) {
        return o2.a;
    }

    private boolean d() {
        this.h = -1 + this.h;
        if (this.h > 0) {
            return false;
        }
        if (this.h < 0) {
            Log.i((String)"GoogleApiClientConnecting", (String)this.a.g.p());
            Log.wtf((String)"GoogleApiClientConnecting", (String)"GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", (Throwable)new Exception());
            this.c(new ConnectionResult(8, null));
            return false;
        }
        if (this.e == null) return true;
        this.a.f = this.f;
        this.c(this.e);
        return false;
    }

    private void e() {
        if (this.h != 0) {
            return;
        }
        if (this.m) {
            if (!this.n) return;
        }
        this.f();
    }

    static /* synthetic */ boolean e(o o2) {
        return o2.m;
    }

    static /* synthetic */ lz f(o o2) {
        return o2.k;
    }

    private void f() {
        ArrayList arrayList = new ArrayList();
        this.g = 1;
        this.h = this.a.a.size();
        Iterator iterator = this.a.a.keySet().iterator();
        do {
            if (!iterator.hasNext()) {
                if (arrayList.isEmpty()) return;
                this.u.add(ao.a().submit(new t(this, arrayList)));
                return;
            }
            i i2 = (i)iterator.next();
            if (this.a.b.containsKey(i2)) {
                if (!this.d()) continue;
                this.g();
                continue;
            }
            arrayList.add(this.a.a.get(i2));
        } while (true);
    }

    static /* synthetic */ Set g(o o2) {
        return o2.j();
    }

    private void g() {
        this.a.h();
        ao.a().execute(new p(this));
        if (this.k != null) {
            if (this.p) {
                this.k.a(this.o, this.q);
            }
            this.a(false);
        }
        for (i i2 : this.a.b.keySet()) {
            ((h)this.a.a.get(i2)).g();
        }
        Bundle bundle = this.i.isEmpty() ? null : this.i;
        this.a.h.a(bundle);
    }

    static /* synthetic */ ap h(o o2) {
        return o2.o;
    }

    private void h() {
        this.m = false;
        this.a.g.d = Collections.emptySet();
        Iterator iterator = this.j.iterator();
        while (iterator.hasNext()) {
            i i2 = (i)iterator.next();
            if (this.a.b.containsKey(i2)) continue;
            this.a.b.put(i2, new ConnectionResult(17, null));
        }
    }

    private void i() {
        Iterator iterator = this.u.iterator();
        do {
            if (!iterator.hasNext()) {
                this.u.clear();
                return;
            }
            ((Future)iterator.next()).cancel(true);
        } while (true);
    }

    static /* synthetic */ void i(o o2) {
        o2.h();
    }

    private Set j() {
        if (this.r == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(this.r.d());
        Map map = this.r.f();
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            a a2 = (a)iterator.next();
            if (this.a.b.containsKey(a2.c())) continue;
            hashSet.addAll(((u)map.get((Object)a2)).a);
        }
        return hashSet;
    }

    static /* synthetic */ void j(o o2) {
        o2.e();
    }

    static /* synthetic */ boolean k(o o2) {
        return o2.d();
    }

    @Override
    public c a(c c2) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override
    public void a() {
        this.a.b.clear();
        this.m = false;
        this.e = null;
        this.g = 0;
        this.l = 2;
        this.n = false;
        this.p = false;
        HashMap<h, com.google.android.gms.common.api.internal.q> hashMap = new HashMap<h, com.google.android.gms.common.api.internal.q>();
        Iterator iterator = this.s.keySet().iterator();
        boolean bl2 = false;
        while (iterator.hasNext()) {
            a a2 = (a)iterator.next();
            h h2 = (h)this.a.a.get(a2.c());
            int n2 = (Integer)this.s.get(a2);
            boolean bl3 = a2.a().a() == 1;
            boolean bl4 = bl3 | bl2;
            if (h2.i()) {
                this.m = true;
                if (n2 < this.l) {
                    this.l = n2;
                }
                if (n2 != 0) {
                    this.j.add(a2.c());
                }
            }
            hashMap.put(h2, new com.google.android.gms.common.api.internal.q(this, a2, n2));
            bl2 = bl4;
        }
        if (this.m) {
            this.r.a(this.a.g.q());
            w w2 = new w(this, null);
            this.k = (lz)this.t.a(this.c, this.a.g.c(), this.r, this.r.i(), w2, w2);
        }
        this.h = this.a.a.size();
        this.u.add(ao.a().submit(new com.google.android.gms.common.api.internal.r(this, hashMap)));
    }

    @Override
    public void a(int n2) {
        this.c(new ConnectionResult(8, null));
    }

    @Override
    public void a(Bundle bundle) {
        if (!this.b(1)) {
            return;
        }
        if (bundle != null) {
            this.i.putAll(bundle);
        }
        if (!this.d()) return;
        this.g();
    }

    @Override
    public void a(ConnectionResult connectionResult, a a2, int n2) {
        if (!this.b(1)) {
            return;
        }
        this.b(connectionResult, a2, n2);
        if (!this.d()) return;
        this.g();
    }

    @Override
    public boolean b() {
        this.i();
        this.a(true);
        this.a.a((ConnectionResult)null);
        return true;
    }

    @Override
    public void c() {
    }
}

