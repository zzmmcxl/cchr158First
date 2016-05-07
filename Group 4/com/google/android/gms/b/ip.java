/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.i;
import com.google.android.gms.b.iv;
import com.google.android.gms.b.iw;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.q;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.internal.y;
import java.util.Set;

public final class ip
extends y {
    private final Bundle d;

    public ip(Context context, Looper looper, t t2, i i2, q q2, r r2) {
        super(context, looper, 16, t2, q2, r2);
        Bundle bundle = i2 == null ? new Bundle() : i2.a();
        this.d = bundle;
    }

    protected iv a(IBinder iBinder) {
        return iw.a(iBinder);
    }

    @Override
    protected String a() {
        return "com.google.android.gms.auth.service.START";
    }

    @Override
    protected /* synthetic */ IInterface b(IBinder iBinder) {
        return this.a(iBinder);
    }

    @Override
    protected String b() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    @Override
    protected Bundle c() {
        return this.d;
    }

    @Override
    public boolean i() {
        t t2 = this.p();
        if (TextUtils.isEmpty((CharSequence)t2.a())) return false;
        if (t2.a(com.google.android.gms.auth.api.a.g).isEmpty()) return false;
        return true;
    }
}

