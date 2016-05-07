/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.bt;
import com.google.android.gms.measurement.internal.u;
import com.google.android.gms.measurement.internal.w;

class v
implements Runnable {
    final /* synthetic */ u a;

    v(u u2) {
        this.a = u2;
    }

    @Override
    public void run() {
        this.a.r().a(new w(this));
    }
}

