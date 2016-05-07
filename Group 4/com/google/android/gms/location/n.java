/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.q;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.location.internal.x;

final class n
extends g {
    n() {
    }

    @Override
    public /* synthetic */ h a(Context context, Looper looper, t t2, Object object, q q2, r r2) {
        return this.a(context, looper, t2, (d)object, q2, r2);
    }

    public x a(Context context, Looper looper, t t2, d d2, q q2, r r2) {
        return new x(context, looper, q2, r2, "locationServices", t2);
    }
}

