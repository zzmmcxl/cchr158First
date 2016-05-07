/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.b.ih;
import com.google.android.gms.b.ii;
import com.google.android.gms.common.api.q;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.internal.y;

public class id
extends y {
    public id(Context context, Looper looper, t t2, q q2, r r2) {
        super(context, looper, 74, t2, q2, r2);
    }

    protected ih a(IBinder iBinder) {
        return ii.a(iBinder);
    }

    @Override
    protected String a() {
        return "com.google.android.gms.auth.api.accountstatus.START";
    }

    @Override
    protected /* synthetic */ IInterface b(IBinder iBinder) {
        return this.a(iBinder);
    }

    @Override
    protected String b() {
        return "com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService";
    }
}

