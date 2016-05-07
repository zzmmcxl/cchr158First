/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.api.internal.aj;
import com.google.android.gms.common.api.internal.ak;
import com.google.android.gms.common.api.internal.al;
import com.google.android.gms.common.api.internal.am;
import com.google.android.gms.common.api.internal.au;
import com.google.android.gms.common.api.internal.bd;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.api.internal.m;
import com.google.android.gms.common.api.internal.n;
import com.google.android.gms.common.api.internal.z;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class l
implements ak {
    private final al a;
    private boolean b = false;

    public l(al al2) {
        this.a = al2;
    }

    static /* synthetic */ al a(l l2) {
        return l2.a;
    }

    private void a(aj aj2) {
        this.a.g.a(aj2);
        h h2 = this.a.g.a(aj2.b());
        if (!h2.h() && this.a.b.containsKey(aj2.b())) {
            aj2.c(new Status(17));
            return;
        }
        aj2.b(h2);
    }

    @Override
    public c a(c c2) {
        try {
            this.a((aj)c2);
            return c2;
        }
        catch (DeadObjectException var2_2) {
            this.a.a(new m(this, this));
            return c2;
        }
    }

    @Override
    public void a() {
    }

    @Override
    public void a(int n2) {
        this.a.a((ConnectionResult)null);
        this.a.h.a(n2, this.b);
    }

    @Override
    public void a(Bundle bundle) {
    }

    @Override
    public void a(ConnectionResult connectionResult, a a2, int n2) {
    }

    @Override
    public boolean b() {
        if (this.b) {
            return false;
        }
        if (!this.a.g.o()) {
            this.a.a((ConnectionResult)null);
            return true;
        }
        this.b = true;
        Iterator iterator = this.a.g.i.iterator();
        while (iterator.hasNext()) {
            ((bd)iterator.next()).a();
        }
        return false;
    }

    @Override
    public void c() {
        if (!this.b) return;
        this.b = false;
        this.a.a(new n(this, this));
    }

    void d() {
        if (!this.b) return;
        this.b = false;
        this.a.g.a(false);
        this.b();
    }
}

