/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.aa;
import android.view.View;
import com.google.android.gms.b.lu;
import com.google.android.gms.b.ma;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.api.internal.ba;
import com.google.android.gms.common.api.internal.z;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.api.n;
import com.google.android.gms.common.api.p;
import com.google.android.gms.common.api.q;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.internal.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class o {
    private Account a;
    private final Set b = new HashSet();
    private final Set c = new HashSet();
    private int d;
    private View e;
    private String f;
    private String g;
    private final Map h = new android.support.v4.g.a();
    private final Context i;
    private final Map j = new android.support.v4.g.a();
    private aa k;
    private int l = -1;
    private r m;
    private Looper n;
    private com.google.android.gms.common.j o = com.google.android.gms.common.j.b();
    private g p = lu.c;
    private final ArrayList q = new ArrayList();
    private final ArrayList r = new ArrayList();

    public o(Context context) {
        this.i = context;
        this.n = context.getMainLooper();
        this.f = context.getPackageName();
        this.g = context.getClass().getName();
    }

    static /* synthetic */ aa a(o o2) {
        return o2.k;
    }

    private static h a(g g2, Object object, Context context, Looper looper, t t2, q q2, r r2) {
        return g2.a(context, looper, t2, object, q2, r2);
    }

    private static b a(k k2, Object object, Context context, Looper looper, t t2, q q2, r r2) {
        return new b(context, looper, k2.b(), q2, r2, t2, k2.a(object));
    }

    private void a(ba ba2, n n2) {
        ba2.a(this.l, n2, this.m);
    }

    private void a(n n2) {
        ba ba2 = ba.a(this.k);
        if (ba2 == null) {
            new Handler(this.i.getMainLooper()).post((Runnable)new p(this, n2));
            return;
        }
        this.a(ba2, n2);
    }

    static /* synthetic */ void a(o o2, ba ba2, n n2) {
        o2.a(ba2, n2);
    }

    private n c() {
        t t2 = this.a();
        a a2 = null;
        Map map = t2.f();
        android.support.v4.g.a a3 = new android.support.v4.g.a();
        android.support.v4.g.a a4 = new android.support.v4.g.a();
        ArrayList<com.google.android.gms.common.api.internal.g> arrayList = new ArrayList<com.google.android.gms.common.api.internal.g>();
        Iterator iterator = this.j.keySet().iterator();
        a a5 = null;
        while (iterator.hasNext()) {
            a a6;
            h h2;
            a a7 = (a)iterator.next();
            Object v2 = this.j.get(a7);
            Object v3 = map.get(a7);
            int n2 = 0;
            if (v3 != null) {
                n2 = ((u)map.get((Object)a7)).b ? 1 : 2;
            }
            a3.put(a7, n2);
            com.google.android.gms.common.api.internal.g g2 = new com.google.android.gms.common.api.internal.g(a7, n2);
            arrayList.add(g2);
            if (a7.d()) {
                k k2 = a7.b();
                a a8 = k2.a() == 1 ? a7 : a5;
                h2 = o.a(k2, v2, this.i, this.n, t2, (q)g2, (r)g2);
                a6 = a8;
            } else {
                g g3 = a7.a();
                a a9 = g3.a() == 1 ? a7 : a5;
                h2 = o.a(g3, v2, this.i, this.n, t2, (q)g2, (r)g2);
                a6 = a9;
            }
            a4.put(a7.c(), h2);
            if (h2.d()) {
                if (a2 != null) {
                    throw new IllegalStateException(a7.e() + " cannot be used with " + a2.e());
                }
            } else {
                a7 = a2;
            }
            a5 = a6;
            a2 = a7;
        }
        if (a2 != null) {
            if (a5 != null) {
                throw new IllegalStateException(a2.e() + " cannot be used with " + a5.e());
            }
            boolean bl2 = this.a == null;
            Object[] arrobject = new Object[]{a2.e()};
            bf.a(bl2, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", arrobject);
            boolean bl3 = this.b.equals(this.c);
            Object[] arrobject2 = new Object[]{a2.e()};
            bf.a(bl3, "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", arrobject2);
        }
        int n3 = z.a(a4.values(), true);
        return new z(this.i, new ReentrantLock(), this.n, t2, this.o, this.p, a3, this.q, this.r, a4, this.l, n3, arrayList);
    }

    public o a(Handler handler) {
        bf.a((Object)handler, (Object)"Handler must not be null");
        this.n = handler.getLooper();
        return this;
    }

    public o a(a a2) {
        bf.a(a2, (Object)"Api must not be null");
        this.j.put(a2, null);
        List list = a2.a().a(null);
        this.c.addAll(list);
        this.b.addAll(list);
        return this;
    }

    public o a(a a2, c c2) {
        bf.a(a2, (Object)"Api must not be null");
        bf.a(c2, (Object)"Null options are not permitted for this Api");
        this.j.put(a2, c2);
        List list = a2.a().a(c2);
        this.c.addAll(list);
        this.b.addAll(list);
        return this;
    }

    public o a(q q2) {
        bf.a(q2, (Object)"Listener must not be null");
        this.q.add(q2);
        return this;
    }

    public o a(r r2) {
        bf.a(r2, (Object)"Listener must not be null");
        this.r.add(r2);
        return this;
    }

    public t a() {
        ma ma2 = ma.a;
        if (!this.j.containsKey(lu.g)) return new t(this.a, this.b, this.h, this.d, this.e, this.f, this.g, ma2);
        ma2 = (ma)this.j.get(lu.g);
        return new t(this.a, this.b, this.h, this.d, this.e, this.f, this.g, ma2);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public n b() {
        boolean bl2 = !this.j.isEmpty();
        bf.b(bl2, "must call addApi() to add at least one API");
        n n2 = this.c();
        Set set = n.j();
        // MONITORENTER : set
        n.j().add(n2);
        // MONITOREXIT : set
        if (this.l < 0) return n2;
        this.a(n2);
        return n2;
    }
}

