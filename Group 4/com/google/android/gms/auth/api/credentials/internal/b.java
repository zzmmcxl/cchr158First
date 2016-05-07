/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.credentials.internal.i;
import com.google.android.gms.auth.api.h;
import com.google.android.gms.common.api.q;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.internal.y;

public final class b
extends y {
    private final h d;

    public b(Context context, Looper looper, t t2, h h2, q q2, r r2) {
        super(context, looper, 68, t2, q2, r2);
        this.d = h2;
    }

    protected com.google.android.gms.auth.api.credentials.internal.h a(IBinder iBinder) {
        return i.a(iBinder);
    }

    @Override
    protected String a() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    @Override
    protected /* synthetic */ IInterface b(IBinder iBinder) {
        return this.a(iBinder);
    }

    @Override
    protected String b() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    @Override
    protected Bundle c() {
        if (this.d != null) return this.d.a();
        return new Bundle();
    }
}

