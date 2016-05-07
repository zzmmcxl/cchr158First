/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.o;
import com.google.android.gms.common.api.internal.p;
import com.google.android.gms.common.api.internal.u;
import com.google.android.gms.common.api.q;
import com.google.android.gms.common.api.r;
import com.google.android.gms.signin.internal.d;

class w
implements q,
r {
    final /* synthetic */ o a;

    private w(o o2) {
        this.a = o2;
    }

    /* synthetic */ w(o o2, p p2) {
        this(o2);
    }

    @Override
    public void a(int n2) {
    }

    @Override
    public void a(Bundle bundle) {
        o.f(this.a).a(new u(this.a));
    }

    @Override
    public void a(ConnectionResult connectionResult) {
        o.c(this.a).lock();
        try {
            if (o.b(this.a, connectionResult)) {
                o.i(this.a);
                o.j(this.a);
                return;
            }
            o.a(this.a, connectionResult);
            return;
        }
        finally {
            o.c(this.a).unlock();
        }
    }
}

