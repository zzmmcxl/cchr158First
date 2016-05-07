/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.u;

class aa
implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ u b;

    aa(u u2, long l2) {
        this.b = u2;
        this.a = l2;
    }

    @Override
    public void run() {
        u.b(this.b, this.a);
    }
}

