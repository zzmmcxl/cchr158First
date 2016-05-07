/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.q;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.internal.ai;
import com.google.android.gms.common.internal.bf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class ah
implements Handler.Callback {
    final ArrayList a = new ArrayList();
    private final ai b;
    private final ArrayList c = new ArrayList();
    private final ArrayList d = new ArrayList();
    private volatile boolean e = false;
    private final AtomicInteger f = new AtomicInteger(0);
    private boolean g = false;
    private final Handler h;
    private final Object i = new Object();

    public ah(Looper looper, ai ai2) {
        this.b = ai2;
        this.h = new Handler(looper, (Handler.Callback)this);
    }

    public void a() {
        this.e = false;
        this.f.incrementAndGet();
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public void a(int var1_1) {
        var2_2 = Looper.myLooper();
        var3_3 = this.h.getLooper();
        var4_4 = false;
        if (var2_2 == var3_3) {
            var4_4 = true;
        }
        bf.a(var4_4, (Object)"onUnintentionalDisconnection must only be called on the Handler thread");
        this.h.removeMessages(1);
        var5_5 = this.i;
        // MONITORENTER : var5_5
        this.g = true;
        var7_6 = new ArrayList<E>(this.c);
        var8_7 = this.f.get();
        var9_8 = var7_6.iterator();
        do {
            if (!var9_8.hasNext()) ** GOTO lbl-1000
            var10_9 = (q)var9_8.next();
            if (!this.e || this.f.get() != var8_7) lbl-1000: // 2 sources:
            {
                this.a.clear();
                this.g = false;
                // MONITOREXIT : var5_5
                return;
            }
            if (!this.c.contains(var10_9)) continue;
            var10_9.a(var1_1);
        } while (true);
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public void a(Bundle var1_1) {
        var2_2 = true;
        var3_3 = Looper.myLooper() == this.h.getLooper() ? var2_2 : false;
        bf.a(var3_3, (Object)"onConnectionSuccess must only be called on the Handler thread");
        var4_4 = this.i;
        // MONITORENTER : var4_4
        var6_5 = this.g == false ? var2_2 : false;
        bf.a(var6_5);
        this.h.removeMessages(1);
        this.g = true;
        if (this.a.size() != 0) {
            var2_2 = false;
        }
        bf.a(var2_2);
        var7_6 = new ArrayList<E>(this.c);
        var8_7 = this.f.get();
        var9_8 = var7_6.iterator();
        do {
            if (!var9_8.hasNext()) ** GOTO lbl-1000
            var10_9 = (q)var9_8.next();
            if (!this.e || !this.b.h() || this.f.get() != var8_7) lbl-1000: // 2 sources:
            {
                this.a.clear();
                this.g = false;
                // MONITOREXIT : var4_4
                return;
            }
            if (this.a.contains(var10_9)) continue;
            var10_9.a(var1_1);
        } while (true);
    }

    public void a(ConnectionResult connectionResult) {
        boolean bl2 = Looper.myLooper() == this.h.getLooper();
        bf.a(bl2, (Object)"onConnectionFailure must only be called on the Handler thread");
        this.h.removeMessages(1);
        Object object = this.i;
        // MONITORENTER : object
        ArrayList arrayList = new ArrayList(this.d);
        int n2 = this.f.get();
        for (r r2 : arrayList) {
            if (!this.e || this.f.get() != n2) {
                // MONITOREXIT : object
                return;
            }
            if (!this.d.contains(r2)) continue;
            r2.a(connectionResult);
        }
        // MONITOREXIT : object
        return;
    }

    public void a(q q2) {
        bf.a(q2);
        Object object = this.i;
        // MONITORENTER : object
        if (this.c.contains(q2)) {
            Log.w((String)"GmsClientEvents", (String)("registerConnectionCallbacks(): listener " + q2 + " is already registered"));
            // MONITOREXIT : object
        } else {
            this.c.add(q2);
        }
        if (!this.b.h()) return;
        this.h.sendMessage(this.h.obtainMessage(1, (Object)q2));
    }

    public void a(r r2) {
        bf.a(r2);
        Object object = this.i;
        // MONITORENTER : object
        if (this.d.contains(r2)) {
            Log.w((String)"GmsClientEvents", (String)("registerConnectionFailedListener(): listener " + r2 + " is already registered"));
            // MONITOREXIT : object
            return;
        }
        this.d.add(r2);
        return;
    }

    public void b() {
        this.e = true;
    }

    public void b(r r2) {
        bf.a(r2);
        Object object = this.i;
        // MONITORENTER : object
        if (!this.d.remove(r2)) {
            Log.w((String)"GmsClientEvents", (String)("unregisterConnectionFailedListener(): listener " + r2 + " not found"));
        }
        // MONITOREXIT : object
        return;
    }

    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            Log.wtf((String)"GmsClientEvents", (String)("Don't know how to handle message: " + message.what), (Throwable)new Exception());
            return false;
        }
        q q2 = (q)message.obj;
        Object object = this.i;
        // MONITORENTER : object
        if (this.e && this.b.h() && this.c.contains(q2)) {
            q2.a(this.b.b_());
        }
        // MONITOREXIT : object
        return true;
    }
}

