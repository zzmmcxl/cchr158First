/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.b.jo;
import com.google.android.gms.b.jq;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.ab;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.api.internal.aa;
import com.google.android.gms.common.api.internal.ac;
import com.google.android.gms.common.api.internal.ad;
import com.google.android.gms.common.api.internal.ae;
import com.google.android.gms.common.api.internal.af;
import com.google.android.gms.common.api.internal.ag;
import com.google.android.gms.common.api.internal.ah;
import com.google.android.gms.common.api.internal.ai;
import com.google.android.gms.common.api.internal.aj;
import com.google.android.gms.common.api.internal.al;
import com.google.android.gms.common.api.internal.ap;
import com.google.android.gms.common.api.internal.at;
import com.google.android.gms.common.api.internal.au;
import com.google.android.gms.common.api.internal.av;
import com.google.android.gms.common.api.internal.ay;
import com.google.android.gms.common.api.internal.az;
import com.google.android.gms.common.api.internal.bd;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.api.n;
import com.google.android.gms.common.api.o;
import com.google.android.gms.common.api.q;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.api.t;
import com.google.android.gms.common.api.x;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.j;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class z
extends n
implements au {
    final Queue a = new LinkedList();
    ah b;
    final Map c;
    Set d = new HashSet();
    final com.google.android.gms.common.internal.t e;
    final Map f;
    final g g;
    final Set h = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75f, 2));
    Set i = null;
    private final Lock j;
    private final com.google.android.gms.common.internal.ah k;
    private at l = null;
    private final int m;
    private final Context n;
    private final Looper o;
    private volatile boolean p;
    private long q = 120000;
    private long r = 5000;
    private final af s;
    private final j t;
    private final Set u = Collections.newSetFromMap(new WeakHashMap());
    private ab v;
    private final ArrayList w;
    private Integer x = null;
    private final ai y;
    private final com.google.android.gms.common.internal.ai z;

    public z(Context context, Lock lock, Looper looper, com.google.android.gms.common.internal.t t2, j j2, g g2, Map map, List list, List list2, Map map2, int n2, int n3, ArrayList arrayList) {
        this.y = new aa(this);
        this.z = new com.google.android.gms.common.api.internal.ab(this);
        this.n = context;
        this.j = lock;
        this.k = new com.google.android.gms.common.internal.ah(looper, this.z);
        this.o = looper;
        this.s = new af(this, looper);
        this.t = j2;
        this.m = n2;
        if (this.m >= 0) {
            this.x = n3;
        }
        this.f = map;
        this.c = map2;
        this.w = arrayList;
        for (q q2 : list) {
            this.k.a(q2);
        }
        Iterator iterator = list2.iterator();
        do {
            if (!iterator.hasNext()) {
                this.e = t2;
                this.g = g2;
                return;
            }
            r r2 = (r)iterator.next();
            this.k.a(r2);
        } while (true);
    }

    public static int a(Iterable iterable, boolean bl2) {
        int n2 = 1;
        Iterator iterator = iterable.iterator();
        int n3 = 0;
        int n4 = 0;
        while (iterator.hasNext()) {
            h h2 = (h)iterator.next();
            if (h2.i()) {
                n4 = n2;
            }
            int n5 = h2.d() ? n2 : n3;
            n3 = n5;
        }
        return 3;
    }

    static /* synthetic */ ab a(z z2) {
        return z2.v;
    }

    private static void a(aj aj2, ab ab2, IBinder iBinder) {
        if (aj2.e()) {
            aj2.a(new ag(aj2, ab2, iBinder, null));
            return;
        }
        if (iBinder != null && iBinder.isBinderAlive()) {
            ag ag2 = new ag(aj2, ab2, iBinder, null);
            aj2.a(ag2);
            try {
                iBinder.linkToDeath((IBinder.DeathRecipient)ag2, 0);
                return;
            }
            catch (RemoteException var4_4) {
                aj2.f();
                ab2.a(aj2.a());
                return;
            }
        }
        aj2.a(null);
        aj2.f();
        ab2.a(aj2.a());
    }

    static /* synthetic */ void a(z z2, n n2, az az2, boolean bl2) {
        z2.a(n2, az2, bl2);
    }

    private void a(n n2, az az2, boolean bl2) {
        jo.c.a(n2).a(new ae(this, az2, bl2, n2));
    }

    static String b(int n2) {
        switch (n2) {
            default: {
                return "UNKNOWN";
            }
            case 3: {
                return "SIGN_IN_MODE_NONE";
            }
            case 1: {
                return "SIGN_IN_MODE_REQUIRED";
            }
            case 2: 
        }
        return "SIGN_IN_MODE_OPTIONAL";
    }

    static /* synthetic */ void b(z z2) {
        z2.s();
    }

    /*
     * Unable to fully structure code
     */
    private void c(int var1_1) {
        if (this.x == null) {
            this.x = var1_1;
        } else if (this.x != var1_1) {
            throw new IllegalStateException("Cannot use sign-in mode: " + z.b(var1_1) + ". Mode was already set to " + z.b(this.x));
        }
        if (this.l != null) {
            return;
        }
        var2_2 = this.c.values().iterator();
        var3_3 = false;
        var4_4 = false;
        while (var2_2.hasNext()) {
            var5_5 = (h)var2_2.next();
            if (var5_5.i()) {
                var4_4 = true;
            }
            var6_6 = var5_5.d() != false ? true : var3_3;
            var3_3 = var6_6;
        }
        switch (this.x) {
            case 1: {
                if (!var4_4) {
                    throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                }
                if (var3_3) {
                    throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            default: {
                ** GOTO lbl30
            }
            case 2: 
        }
        if (var4_4) {
            this.l = new com.google.android.gms.common.api.internal.h(this.n, this, this.j, this.o, this.t, this.c, this.e, this.f, this.g, this.w);
            return;
        }
lbl30: // 3 sources:
        this.l = new al(this.n, this, this.j, this.o, this.t, this.c, this.e, this.f, this.g, this.w, this);
    }

    static /* synthetic */ void c(z z2) {
        z2.t();
    }

    static /* synthetic */ Context d(z z2) {
        return z2.n;
    }

    private void r() {
        this.k.b();
        this.l.a();
    }

    private void s() {
        this.j.lock();
        try {
            if (!this.l()) return;
            this.r();
            return;
        }
        finally {
            this.j.unlock();
        }
    }

    private void t() {
        this.j.lock();
        try {
            if (!this.n()) return;
            this.r();
            return;
        }
        finally {
            this.j.unlock();
        }
    }

    @Override
    public h a(i i2) {
        h h2 = (h)this.c.get(i2);
        bf.a(h2, (Object)"Appropriate Api was not requested.");
        return h2;
    }

    @Override
    public c a(c c2) {
        boolean bl2 = c2.b() != null;
        bf.b(bl2, "This task can not be executed (it's probably a Batch or malformed)");
        this.j.lock();
        try {
            if (this.l == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (this.l()) {
                this.a.add(c2);
                while (!this.a.isEmpty()) {
                    aj aj2 = (aj)this.a.remove();
                    this.a(aj2);
                    aj2.c(Status.c);
                }
                return c2;
            }
            c c3 = this.l.a(c2);
            return c3;
        }
        finally {
            this.j.unlock();
        }
    }

    @Override
    public void a(int n2) {
        int n3 = 1;
        this.j.lock();
        if (n2 != 3 && n2 != n3 && n2 != 2) {
            n3 = 0;
        }
        try {
            bf.b((boolean)n3, "Illegal sign-in mode: " + n2);
            this.c(n2);
            this.r();
            return;
        }
        finally {
            this.j.unlock();
        }
    }

    @Override
    public void a(int n2, boolean bl2) {
        if (n2 == 1 && !bl2) {
            this.m();
        }
        Iterator iterator = this.h.iterator();
        do {
            if (!iterator.hasNext()) {
                this.h.clear();
                this.k.a(n2);
                this.k.a();
                if (n2 != 2) return;
                this.r();
                return;
            }
            aj aj2 = (aj)iterator.next();
            if (bl2) {
                aj2.c();
            }
            aj2.d(new Status(8, "The connection to Google Play services was lost"));
        } while (true);
    }

    @Override
    public void a(Bundle bundle) {
        do {
            if (this.a.isEmpty()) {
                this.k.a(bundle);
                return;
            }
            this.a((c)this.a.remove());
        } while (true);
    }

    @Override
    public void a(ConnectionResult connectionResult) {
        if (!this.t.a(this.n, connectionResult.c())) {
            this.n();
        }
        if (this.l()) return;
        this.k.a(connectionResult);
        this.k.a();
    }

    void a(aj aj2) {
        this.h.add(aj2);
        aj2.a(this.y);
    }

    @Override
    public void a(bd bd2) {
        this.j.lock();
        try {
            if (this.i == null) {
                this.i = new HashSet();
            }
            this.i.add(bd2);
            return;
        }
        finally {
            this.j.unlock();
        }
    }

    @Override
    public void a(r r2) {
        this.k.a(r2);
    }

    @Override
    public void a(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
        printWriter.append(string).append("mContext=").println((Object)this.n);
        printWriter.append(string).append("mResuming=").print(this.p);
        printWriter.append(" mWorkQueue.size()=").print(this.a.size());
        printWriter.append(" mUnconsumedRunners.size()=").println(this.h.size());
        if (this.l == null) return;
        this.l.a(string, fileDescriptor, printWriter, arrstring);
    }

    void a(boolean bl2) {
        Iterator iterator = this.h.iterator();
        while (iterator.hasNext()) {
            aj aj2 = (aj)iterator.next();
            if (aj2.a() == null) {
                if (bl2) {
                    aj2.g();
                    continue;
                }
                aj2.f();
                this.h.remove(aj2);
                continue;
            }
            aj2.c();
            IBinder iBinder = this.a(aj2.b()).j();
            z.a(aj2, this.v, iBinder);
            this.h.remove(aj2);
        }
    }

    @Override
    public boolean a(ay ay2) {
        if (this.l == null) return false;
        if (!this.l.a(ay2)) return false;
        return true;
    }

    @Override
    public Context b() {
        return this.n;
    }

    @Override
    public void b(bd bd2) {
        this.j.lock();
        try {
            if (this.i == null) {
                Log.wtf((String)"GoogleApiClientImpl", (String)"Attempted to remove pending transform when no transforms are registered.", (Throwable)new Exception());
                return;
            }
            if (!this.i.remove(bd2)) {
                Log.wtf((String)"GoogleApiClientImpl", (String)"Failed to remove pending transform - this may lead to memory leaks!", (Throwable)new Exception());
                return;
            }
            if (this.o()) return;
            this.l.f();
            return;
        }
        finally {
            this.j.unlock();
        }
    }

    @Override
    public void b(r r2) {
        this.k.b(r2);
    }

    @Override
    public Looper c() {
        return this.o;
    }

    @Override
    public void d() {
        if (this.l == null) return;
        this.l.g();
    }

    @Override
    public void e() {
        this.j.lock();
        try {
            if (this.m >= 0) {
                Integer n2 = this.x;
                boolean bl2 = false;
                if (n2 != null) {
                    bl2 = true;
                }
                bf.a(bl2, (Object)"Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.x == null) {
                this.x = z.a(this.c.values(), false);
            } else if (this.x == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            this.a(this.x);
            return;
        }
        finally {
            this.j.unlock();
        }
    }

    @Override
    public ConnectionResult f() {
        boolean bl2 = true;
        boolean bl3 = Looper.myLooper() != Looper.getMainLooper() ? bl2 : false;
        bf.a(bl3, (Object)"blockingConnect must not be called on the UI thread");
        this.j.lock();
        try {
            block9 : {
                if (this.m >= 0) {
                    if (this.x == null) {
                        bl2 = false;
                    }
                    bf.a(bl2, (Object)"Sign-in mode should have been set explicitly by auto-manage.");
                } else if (this.x == null) {
                    this.x = z.a(this.c.values(), false);
                } else {
                    if (this.x != 2) break block9;
                    throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            this.c(this.x);
            this.k.b();
            ConnectionResult connectionResult = this.l.b();
            this.j.unlock();
            return connectionResult;
        }
        catch (Throwable var3_4) {
            this.j.unlock();
            throw var3_4;
        }
    }

    @Override
    public void g() {
        this.j.lock();
        try {
            boolean bl2 = this.l != null && !this.l.c();
            this.a(bl2);
            Iterator iterator = this.u.iterator();
            while (iterator.hasNext()) {
                ((av)iterator.next()).a();
            }
            this.u.clear();
            for (aj aj2 : this.a) {
                aj2.a(null);
                aj2.f();
            }
            this.a.clear();
            at at2 = this.l;
            if (at2 == null) {
                this.j.unlock();
                return;
            }
            this.n();
            this.k.a();
            this.j.unlock();
            return;
        }
        catch (Throwable var1_3) {
            this.j.unlock();
            throw var1_3;
        }
    }

    @Override
    public t h() {
        bf.a(this.i(), (Object)"GoogleApiClient is not connected yet.");
        boolean bl2 = this.x != 2;
        bf.a(bl2, (Object)"Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        az az2 = new az(this);
        if (this.c.containsKey(jo.a)) {
            this.a(this, az2, false);
            return az2;
        }
        AtomicReference<n> atomicReference = new AtomicReference<n>();
        ac ac2 = new ac(this, atomicReference, az2);
        ad ad2 = new ad(this, az2);
        n n2 = new o(this.n).a(jo.b).a(ac2).a(ad2).a(this.s).b();
        atomicReference.set(n2);
        n2.e();
        return az2;
    }

    @Override
    public boolean i() {
        if (this.l == null) return false;
        if (!this.l.d()) return false;
        return true;
    }

    public void k() {
        this.g();
        this.e();
    }

    boolean l() {
        return this.p;
    }

    void m() {
        if (this.l()) {
            return;
        }
        this.p = true;
        if (this.b == null) {
            this.b = (ah)ap.a(this.n.getApplicationContext(), new ah(this), this.t);
        }
        this.s.sendMessageDelayed(this.s.obtainMessage(1), this.q);
        this.s.sendMessageDelayed(this.s.obtainMessage(2), this.r);
    }

    boolean n() {
        if (!this.l()) {
            return false;
        }
        this.p = false;
        this.s.removeMessages(2);
        this.s.removeMessages(1);
        if (this.b == null) return true;
        this.b.b();
        this.b = null;
        return true;
    }

    boolean o() {
        this.j.lock();
        try {
            Set set = this.i;
            if (set == null) {
                this.j.unlock();
                return false;
            }
            boolean bl2 = this.i.isEmpty();
            boolean bl3 = false;
            if (!bl2) {
                bl3 = true;
            }
            this.j.unlock();
            return bl3;
        }
        catch (Throwable var1_4) {
            this.j.unlock();
            throw var1_4;
        }
    }

    String p() {
        StringWriter stringWriter = new StringWriter();
        this.a("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    public int q() {
        return System.identityHashCode(this);
    }
}

