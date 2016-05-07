/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.m;
import com.google.android.gms.common.api.q;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.api.s;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.aa;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.ac;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.ae;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.ai;
import com.google.android.gms.common.internal.aj;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.at;
import com.google.android.gms.common.internal.aw;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.j;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class y
implements h,
ai {
    public static final String[] c = new String[]{"service_esmobile", "service_googleme"};
    final Handler a;
    protected AtomicInteger b;
    private int d;
    private long e;
    private long f;
    private int g;
    private long h;
    private final Context i;
    private final t j;
    private final Looper k;
    private final aj l;
    private final j m;
    private final Object n = new Object();
    private final Object o = new Object();
    private aw p;
    private s q;
    private IInterface r;
    private final ArrayList s;
    private ad t;
    private int u;
    private final Set v;
    private final Account w;
    private final q x;
    private final r y;
    private final int z;

    protected y(Context context, Looper looper, int n2, t t2, q q2, r r2) {
        this(context, looper, aj.a(context), j.b(), n2, t2, (q)bf.a(q2), (r)bf.a(r2));
    }

    protected y(Context context, Looper looper, aj aj2, j j2, int n2, t t2, q q2, r r2) {
        this.q = new ae(this);
        this.s = new ArrayList();
        this.u = 1;
        this.b = new AtomicInteger(0);
        this.i = (Context)bf.a((Object)context, (Object)"Context must not be null");
        this.k = (Looper)bf.a((Object)looper, (Object)"Looper must not be null");
        this.l = (aj)bf.a(aj2, (Object)"Supervisor must not be null");
        this.m = (j)bf.a(j2, (Object)"API availability must not be null");
        this.a = new aa(this, looper);
        this.z = n2;
        this.j = (t)bf.a(t2);
        this.w = t2.b();
        this.v = this.b(t2.e());
        this.x = q2;
        this.y = r2;
    }

    static /* synthetic */ aw a(y y2, aw aw2) {
        y2.p = aw2;
        return aw2;
    }

    static /* synthetic */ Object a(y y2) {
        return y2.o;
    }

    static /* synthetic */ void a(y y2, int n2, IInterface iInterface) {
        y2.b(n2, iInterface);
    }

    private boolean a(int n2, int n3, IInterface iInterface) {
        Object object = this.n;
        // MONITORENTER : object
        if (this.u != n2) {
            // MONITOREXIT : object
            return false;
        }
        this.b(n3, iInterface);
        // MONITOREXIT : object
        return true;
    }

    static /* synthetic */ boolean a(y y2, int n2, int n3, IInterface iInterface) {
        return y2.a(n2, n3, iInterface);
    }

    static /* synthetic */ s b(y y2) {
        return y2.q;
    }

    private Set b(Set set) {
        Set set2 = this.a(set);
        if (set2 == null) {
            return set2;
        }
        Iterator iterator = set2.iterator();
        do {
            if (!iterator.hasNext()) return set2;
        } while (set.contains((Scope)iterator.next()));
        throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private void b(int var1_1, IInterface var2_2) {
        var3_3 = true;
        var4_4 = var1_1 == 3 ? var3_3 : false;
        var5_5 = var2_2 != null ? var3_3 : false;
        if (var4_4 != var5_5) {
            var3_3 = false;
        }
        bf.b(var3_3);
        var6_6 = this.n;
        // MONITORENTER : var6_6
        this.u = var1_1;
        this.r = var2_2;
        this.a(var1_1, var2_2);
        switch (var1_1) {
            case 2: {
                this.f();
                ** break;
            }
            case 3: {
                this.a(var2_2);
            }
lbl18: // 3 sources:
            default: {
                // MONITOREXIT : var6_6
                return;
            }
            case 1: 
        }
        this.t();
    }

    static /* synthetic */ q c(y y2) {
        return y2.x;
    }

    static /* synthetic */ ArrayList d(y y2) {
        return y2.s;
    }

    static /* synthetic */ Set e(y y2) {
        return y2.v;
    }

    static /* synthetic */ r f(y y2) {
        return y2.y;
    }

    private void f() {
        if (this.t != null) {
            Log.e((String)"GmsClient", (String)("Calling connect() while still connected, missing disconnect() for " + this.a()));
            this.l.b(this.a(), this.t, this.c_());
            this.b.incrementAndGet();
        }
        this.t = new ad(this, this.b.get());
        if (this.l.a(this.a(), this.t, this.c_())) return;
        Log.e((String)"GmsClient", (String)("unable to connect to service: " + this.a()));
        this.a(8, this.b.get());
    }

    private void t() {
        if (this.t == null) return;
        this.l.b(this.a(), this.t, this.c_());
        this.t = null;
    }

    protected abstract String a();

    protected Set a(Set set) {
        return set;
    }

    protected void a(int n2) {
        this.d = n2;
        this.e = System.currentTimeMillis();
    }

    protected void a(int n2, int n3) {
        this.a.sendMessage(this.a.obtainMessage(5, n3, -1, (Object)new ag(this, n2)));
    }

    protected void a(int n2, IBinder iBinder, Bundle bundle, int n3) {
        this.a.sendMessage(this.a.obtainMessage(1, n3, -1, (Object)new af(this, n2, iBinder, bundle)));
    }

    void a(int n2, IInterface iInterface) {
    }

    protected void a(IInterface iInterface) {
        this.f = System.currentTimeMillis();
    }

    protected void a(ConnectionResult connectionResult) {
        this.g = connectionResult.c();
        this.h = System.currentTimeMillis();
    }

    @Override
    public void a(s s2) {
        this.q = (s)bf.a(s2, (Object)"Connection progress callbacks cannot be null.");
        this.b(2, null);
    }

    @Override
    public void a(ap ap2, Set set) {
        Bundle bundle = this.c();
        GetServiceRequest getServiceRequest = new GetServiceRequest(this.z).a(this.i.getPackageName()).a(bundle);
        if (set != null) {
            getServiceRequest.a(set);
        }
        if (this.i()) {
            getServiceRequest.a(this.o()).a(ap2);
        } else if (this.s()) {
            getServiceRequest.a(this.w);
        }
        Object object = this.o;
        // MONITORENTER : object
        try {
            if (this.p != null) {
                this.p.a((at)new ac(this, this.b.get()), getServiceRequest);
                // MONITOREXIT : object
                return;
            }
            Log.w((String)"GmsClient", (String)"mServiceBroker is null, client disconnected");
            return;
        }
        catch (Throwable var12_7) {
            // MONITOREXIT : object
            try {
                throw var12_7;
            }
            catch (DeadObjectException var5_6) {
                Log.w((String)"GmsClient", (String)"service died");
                this.b(1);
                return;
            }
            catch (RemoteException var3_8) {
                Log.w((String)"GmsClient", (String)"Remote exception occurred", (Throwable)var3_8);
                return;
            }
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public void a(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
        Object object = this.n;
        // MONITORENTER : object
        int n2 = this.u;
        IInterface iInterface = this.r;
        // MONITOREXIT : object
        printWriter.append(string).append("mConnectState=");
        switch (n2) {
            default: {
                printWriter.print("UNKNOWN");
                break;
            }
            case 2: {
                printWriter.print("CONNECTING");
                break;
            }
            case 3: {
                printWriter.print("CONNECTED");
                break;
            }
            case 4: {
                printWriter.print("DISCONNECTING");
                break;
            }
            case 1: {
                printWriter.print("DISCONNECTED");
            }
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.println("null");
        } else {
            printWriter.append(this.b()).append("@").println(Integer.toHexString(System.identityHashCode((Object)iInterface.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.f > 0) {
            printWriter.append(string).append("lastConnectedTime=").println("" + this.f + " " + simpleDateFormat.format(new Date(this.f)));
        }
        if (this.e > 0) {
            printWriter.append(string).append("lastSuspendedCause=");
            switch (this.d) {
                default: {
                    printWriter.append(String.valueOf(this.d));
                    break;
                }
                case 1: {
                    printWriter.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                }
                case 2: {
                    printWriter.append("CAUSE_NETWORK_LOST");
                }
            }
            printWriter.append(" lastSuspendedTime=").println("" + this.e + " " + simpleDateFormat.format(new Date(this.e)));
        }
        if (this.h <= 0) return;
        printWriter.append(string).append("lastFailedStatus=").append(m.a(this.g));
        printWriter.append(" lastFailedTime=").println("" + this.h + " " + simpleDateFormat.format(new Date(this.h)));
    }

    protected abstract IInterface b(IBinder var1);

    protected abstract String b();

    public void b(int n2) {
        this.a.sendMessage(this.a.obtainMessage(4, this.b.get(), n2));
    }

    @Override
    public Bundle b_() {
        return null;
    }

    protected Bundle c() {
        return new Bundle();
    }

    protected final String c_() {
        return this.j.h();
    }

    @Override
    public boolean d() {
        return false;
    }

    @Override
    public Intent e() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public void g() {
        this.b.incrementAndGet();
        ArrayList arrayList = this.s;
        // MONITORENTER : arrayList
        int n2 = this.s.size();
        int i2 = 0;
        do {
            if (i2 >= n2) {
                this.s.clear();
                // MONITOREXIT : arrayList
                Object object = this.o;
                // MONITORENTER : object
                this.p = null;
                // MONITOREXIT : object
                this.b(1, null);
                return;
            }
            ((ab)this.s.get(i2)).e();
            ++i2;
        } while (true);
    }

    @Override
    public boolean h() {
        Object object = this.n;
        // MONITORENTER : object
        if (this.u != 3) return false;
        boolean bl2 = true;
        // MONITOREXIT : object
        return bl2;
    }

    @Override
    public boolean i() {
        return false;
    }

    @Override
    public IBinder j() {
        Object object = this.o;
        // MONITORENTER : object
        if (this.p == null) {
            // MONITOREXIT : object
            return null;
        }
        IBinder iBinder = this.p.asBinder();
        // MONITOREXIT : object
        return iBinder;
    }

    public void l() {
        int n2 = this.m.a(this.i);
        if (n2 != 0) {
            this.b(1, null);
            this.q = new ae(this);
            this.a.sendMessage(this.a.obtainMessage(3, this.b.get(), n2));
            return;
        }
        this.a(new ae(this));
    }

    public boolean m() {
        Object object = this.n;
        // MONITORENTER : object
        if (this.u != 2) return false;
        boolean bl2 = true;
        // MONITOREXIT : object
        return bl2;
    }

    public final Context n() {
        return this.i;
    }

    public final Account o() {
        if (this.w == null) return new Account("<<default account>>", "com.google");
        return this.w;
    }

    protected final t p() {
        return this.j;
    }

    protected final void q() {
        if (this.h()) return;
        throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }

    public final IInterface r() {
        Object object = this.n;
        // MONITORENTER : object
        if (this.u == 4) {
            throw new DeadObjectException();
        }
        this.q();
        boolean bl2 = this.r != null;
        bf.a(bl2, (Object)"Client is connected but service is null");
        IInterface iInterface = this.r;
        // MONITOREXIT : object
        return iInterface;
    }

    public boolean s() {
        return false;
    }
}

