/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.q;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.internal.y;
import com.google.android.gms.location.internal.ac;
import com.google.android.gms.location.internal.b;
import com.google.android.gms.location.internal.o;
import com.google.android.gms.location.internal.p;

public class a
extends y {
    protected final ac d;
    private final String e;

    public a(Context context, Looper looper, q q2, r r2, String string, t t2) {
        super(context, looper, 23, t2, q2, r2);
        this.d = new b(this);
        this.e = string;
    }

    static /* synthetic */ void a(a a2) {
        a2.q();
    }

    protected o a(IBinder iBinder) {
        return p.a(iBinder);
    }

    @Override
    protected String a() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    @Override
    protected /* synthetic */ IInterface b(IBinder iBinder) {
        return this.a(iBinder);
    }

    @Override
    protected String b() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override
    protected Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.e);
        return bundle;
    }
}

