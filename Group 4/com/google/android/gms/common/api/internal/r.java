/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.internal.ak;
import com.google.android.gms.common.api.internal.am;
import com.google.android.gms.common.api.internal.o;
import com.google.android.gms.common.api.internal.p;
import com.google.android.gms.common.api.internal.s;
import com.google.android.gms.common.api.internal.x;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class r
extends x {
    final /* synthetic */ o a;
    private final Map c;

    public r(o o2, Map map) {
        this.a = o2;
        super(o2, null);
        this.c = map;
    }

    @Override
    public void a() {
        int n2 = o.b(this.a).a(o.a(this.a));
        if (n2 != 0) {
            ConnectionResult connectionResult = new ConnectionResult(n2, null);
            o.d(this.a).a(new s(this, this.a, connectionResult));
            return;
        }
        if (o.e(this.a)) {
            o.f(this.a).k();
        }
        Iterator iterator = this.c.keySet().iterator();
        while (iterator.hasNext()) {
            h h2 = (h)iterator.next();
            h2.a((com.google.android.gms.common.api.s)this.c.get(h2));
        }
    }
}

