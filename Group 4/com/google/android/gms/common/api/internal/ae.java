/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.auth.api.signin.internal.ac;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.az;
import com.google.android.gms.common.api.internal.z;
import com.google.android.gms.common.api.n;
import com.google.android.gms.common.api.w;
import com.google.android.gms.common.api.x;

class ae
implements x {
    final /* synthetic */ az a;
    final /* synthetic */ boolean b;
    final /* synthetic */ n c;
    final /* synthetic */ z d;

    ae(z z2, az az2, boolean bl2, n n2) {
        this.d = z2;
        this.a = az2;
        this.b = bl2;
        this.c = n2;
    }

    public void a(Status status) {
        ac.a(z.d(this.d)).d();
        if (status.e() && this.d.i()) {
            this.d.k();
        }
        this.a.a(status);
        if (!this.b) return;
        this.c.g();
    }

    @Override
    public /* synthetic */ void a(w w2) {
        this.a((Status)w2);
    }
}

