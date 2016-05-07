/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.ak;
import com.google.android.gms.common.api.internal.am;
import com.google.android.gms.common.api.internal.o;
import com.google.android.gms.common.api.internal.u;
import com.google.android.gms.signin.internal.SignInResponse;

class v
extends am {
    final /* synthetic */ o a;
    final /* synthetic */ SignInResponse b;
    final /* synthetic */ u c;

    v(u u2, ak ak2, o o2, SignInResponse signInResponse) {
        this.c = u2;
        this.a = o2;
        this.b = signInResponse;
        super(ak2);
    }

    @Override
    public void a() {
        o.a(this.a, this.b);
    }
}

