/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.h;

class k
implements Runnable {
    final /* synthetic */ h a;

    k(h h2) {
        this.a = h2;
    }

    @Override
    public void run() {
        h.a(this.a).lock();
        try {
            h.b(this.a);
            return;
        }
        finally {
            h.a(this.a).unlock();
        }
    }
}

