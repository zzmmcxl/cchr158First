/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.az;
import com.google.android.gms.common.api.internal.z;
import com.google.android.gms.common.api.n;
import com.google.android.gms.common.api.q;
import java.util.concurrent.atomic.AtomicReference;

class ac
implements q {
    final /* synthetic */ AtomicReference a;
    final /* synthetic */ az b;
    final /* synthetic */ z c;

    ac(z z2, AtomicReference atomicReference, az az2) {
        this.c = z2;
        this.a = atomicReference;
        this.b = az2;
    }

    @Override
    public void a(int n2) {
    }

    @Override
    public void a(Bundle bundle) {
        z.a(this.c, (n)this.a.get(), this.b, true);
    }
}

