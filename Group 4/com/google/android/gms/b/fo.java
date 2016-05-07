/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.fn;

class fo
implements Runnable {
    final /* synthetic */ fn a;

    fo(fn fn2) {
        this.a = fn2;
    }

    @Override
    public final void run() {
        fn.a(this.a, Thread.currentThread());
        this.a.a();
    }
}

