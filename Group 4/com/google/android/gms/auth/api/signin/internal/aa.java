/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.internal.p;
import com.google.android.gms.auth.api.signin.internal.q;
import com.google.android.gms.auth.api.signin.k;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.internal.y;

public class aa
extends y {
    private final k d;

    public aa(Context context, Looper looper, t t2, k k2, com.google.android.gms.common.api.q q2, r r2) {
        super(context, looper, 87, t2, q2, r2);
        this.d = (k)bf.a(k2);
    }

    protected p a(IBinder iBinder) {
        return q.a(iBinder);
    }

    @Override
    protected String a() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    @Override
    protected /* synthetic */ IInterface b(IBinder iBinder) {
        return this.a(iBinder);
    }

    @Override
    protected String b() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }
}

