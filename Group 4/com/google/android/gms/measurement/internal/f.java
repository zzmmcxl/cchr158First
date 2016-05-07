/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.d;

class f
implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ long c;
    final /* synthetic */ Bundle d;
    final /* synthetic */ boolean e;
    final /* synthetic */ String f;
    final /* synthetic */ d g;

    f(d d2, String string, String string2, long l2, Bundle bundle, boolean bl2, String string3) {
        this.g = d2;
        this.a = string;
        this.b = string2;
        this.c = l2;
        this.d = bundle;
        this.e = bl2;
        this.f = string3;
    }

    @Override
    public void run() {
        d.a(this.g, this.a, this.b, this.c, this.d, this.e, this.f);
    }
}

