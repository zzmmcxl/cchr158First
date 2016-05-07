/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.q;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.internal.y;
import com.google.android.gms.measurement.internal.ax;
import com.google.android.gms.measurement.internal.ay;

public class bb
extends y {
    public bb(Context context, Looper looper, t t2, q q2, r r2) {
        super(context, looper, 93, t2, q2, r2);
    }

    public ax a(IBinder iBinder) {
        return ay.a(iBinder);
    }

    @Override
    protected String a() {
        return "com.google.android.gms.measurement.START";
    }

    @Override
    public /* synthetic */ IInterface b(IBinder iBinder) {
        return this.a(iBinder);
    }

    @Override
    protected String b() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }
}

