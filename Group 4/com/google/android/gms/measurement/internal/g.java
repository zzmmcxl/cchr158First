/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.d;

class g
implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ Object c;
    final /* synthetic */ long d;
    final /* synthetic */ d e;

    g(d d2, String string, String string2, Object object, long l2) {
        this.e = d2;
        this.a = string;
        this.b = string2;
        this.c = object;
        this.d = l2;
    }

    @Override
    public void run() {
        d.a(this.e, this.a, this.b, this.c, this.d);
    }
}

