/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.ak;
import com.google.android.gms.common.api.internal.am;
import com.google.android.gms.common.api.internal.o;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.signin.internal.SignInResponse;
import com.google.android.gms.signin.internal.b;
import java.lang.ref.WeakReference;

class u
extends b {
    private final WeakReference a;

    u(o o2) {
        this.a = new WeakReference<o>(o2);
    }

    @Override
    public void a(SignInResponse signInResponse) {
        o o2 = (o)this.a.get();
        if (o2 == null) {
            return;
        }
        o.d(o2).a(new v(this, o2, o2, signInResponse));
    }
}

