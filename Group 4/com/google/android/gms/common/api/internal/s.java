/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.ak;
import com.google.android.gms.common.api.internal.am;
import com.google.android.gms.common.api.internal.o;
import com.google.android.gms.common.api.internal.r;

class s
extends am {
    final /* synthetic */ ConnectionResult a;
    final /* synthetic */ r b;

    s(r r2, ak ak2, ConnectionResult connectionResult) {
        this.b = r2;
        this.a = connectionResult;
        super(ak2);
    }

    @Override
    public void a() {
        o.a(this.b.a, this.a);
    }
}

