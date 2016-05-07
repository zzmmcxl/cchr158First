/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin.internal;

import android.os.IInterface;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.e;
import com.google.android.gms.auth.api.signin.internal.g;
import com.google.android.gms.auth.api.signin.internal.h;
import com.google.android.gms.auth.api.signin.internal.i;
import com.google.android.gms.auth.api.signin.internal.m;
import com.google.android.gms.auth.api.signin.internal.p;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.n;
import com.google.android.gms.common.api.w;

class f
extends h {
    final /* synthetic */ e a;

    f(e e2, n n2) {
        this.a = e2;
        super(e2, n2);
    }

    protected Status a(Status status) {
        return status;
    }

    protected void a(i i2) {
        ((p)i2.r()).c(new g(this), i2.f());
    }

    @Override
    protected /* synthetic */ w b(Status status) {
        return this.a(status);
    }
}

