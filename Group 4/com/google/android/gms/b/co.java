/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.ads.internal.g;
import com.google.android.gms.b.cn;

class co
implements Runnable {
    final /* synthetic */ cn a;

    co(cn cn2) {
        this.a = cn2;
    }

    @Override
    public void run() {
        g.k().b(this.a);
    }
}

