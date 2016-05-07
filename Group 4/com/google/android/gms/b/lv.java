/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.b.ma;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.q;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.signin.internal.l;

final class lv
extends g {
    lv() {
    }

    public l a(Context context, Looper looper, t t2, ma ma2, q q2, r r2) {
        ma ma3;
        if (ma2 == null) {
            ma3 = ma.a;
            return new l(context, looper, true, t2, ma3, q2, r2);
        }
        ma3 = ma2;
        return new l(context, looper, true, t2, ma3, q2, r2);
    }
}

