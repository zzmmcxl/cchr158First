/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.al;
import com.google.android.gms.common.api.internal.o;
import com.google.android.gms.common.api.internal.z;
import com.google.android.gms.common.api.s;
import com.google.android.gms.common.internal.bf;
import java.lang.ref.WeakReference;

class q
implements s {
    private final WeakReference a;
    private final a b;
    private final int c;

    public q(o o2, a a2, int n2) {
        this.a = new WeakReference<o>(o2);
        this.b = a2;
        this.c = n2;
    }

    @Override
    public void a(ConnectionResult connectionResult) {
        o o2 = (o)this.a.get();
        if (o2 == null) {
            return;
        }
        Looper looper = Looper.myLooper();
        Looper looper2 = o.d((o)o2).g.c();
        boolean bl2 = false;
        if (looper == looper2) {
            bl2 = true;
        }
        bf.a(bl2, (Object)"onReportServiceBinding must be called on the GoogleApiClient handler thread");
        o.c(o2).lock();
        boolean bl3 = o.a(o2, 0);
        if (!bl3) {
            o.c(o2).unlock();
            return;
        }
        if (!connectionResult.b()) {
            o.a(o2, connectionResult, this.b, this.c);
        }
        if (!o.k(o2)) return;
        o.j(o2);
        return;
    }
}

