/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api;

import android.support.v4.app.ah;
import com.google.android.gms.common.api.internal.ba;
import com.google.android.gms.common.api.n;
import com.google.android.gms.common.api.o;

class p
implements Runnable {
    final /* synthetic */ n a;
    final /* synthetic */ o b;

    p(o o2, n n2) {
        this.b = o2;
        this.a = n2;
    }

    @Override
    public void run() {
        if (o.a(this.b).isFinishing()) return;
        if (o.a(this.b).f().e()) {
            return;
        }
        o.a(this.b, ba.b(o.a(this.b)), this.a);
    }
}

