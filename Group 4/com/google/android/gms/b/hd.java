/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.ads.internal.overlay.c;
import com.google.android.gms.b.hb;
import com.google.android.gms.b.hc;

class hd
implements Runnable {
    final /* synthetic */ hc a;

    hd(hc hc2) {
        this.a = hc2;
    }

    @Override
    public void run() {
        this.a.a.v();
        c c2 = this.a.a.h();
        if (c2 != null) {
            c2.m();
        }
        if (hc.d(this.a) == null) return;
        hc.d(this.a).a();
        hc.a(this.a, null);
    }
}

