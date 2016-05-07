/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.q;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.internal.y;

public class b
extends y {
    private final j d;

    public b(Context context, Looper looper, int n2, q q2, r r2, t t2, j j2) {
        super(context, looper, n2, t2, q2, r2);
        this.d = j2;
    }

    @Override
    protected String a() {
        return this.d.a();
    }

    @Override
    protected void a(int n2, IInterface iInterface) {
        this.d.a(n2, iInterface);
    }

    @Override
    protected IInterface b(IBinder iBinder) {
        return this.d.a(iBinder);
    }

    @Override
    protected String b() {
        return this.d.b();
    }
}

