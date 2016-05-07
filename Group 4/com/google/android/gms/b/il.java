/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.b.im;
import com.google.android.gms.b.in;
import com.google.android.gms.common.api.q;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.internal.y;

public class il
extends y {
    public il(Context context, Looper looper, t t2, q q2, r r2) {
        super(context, looper, 92, t2, q2, r2);
    }

    protected im a(IBinder iBinder) {
        return in.a(iBinder);
    }

    @Override
    protected String a() {
        return "com.google.android.gms.auth.api.consent.START";
    }

    @Override
    protected /* synthetic */ IInterface b(IBinder iBinder) {
        return this.a(iBinder);
    }

    @Override
    protected String b() {
        return "com.google.android.gms.auth.api.consent.internal.IConsentService";
    }
}

