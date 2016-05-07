/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.b.ka;
import com.google.android.gms.b.kb;
import com.google.android.gms.common.api.q;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.internal.y;

public class jw
extends y {
    public jw(Context context, Looper looper, t t2, q q2, r r2) {
        super(context, looper, 39, t2, q2, r2);
    }

    protected ka a(IBinder iBinder) {
        return kb.a(iBinder);
    }

    @Override
    public String a() {
        return "com.google.android.gms.common.service.START";
    }

    @Override
    protected /* synthetic */ IInterface b(IBinder iBinder) {
        return this.a(iBinder);
    }

    @Override
    protected String b() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }
}

