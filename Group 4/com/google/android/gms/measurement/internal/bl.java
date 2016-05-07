/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.bk;

class bl
implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ bk b;

    bl(bk bk2, boolean bl2) {
        this.b = bk2;
        this.a = bl2;
    }

    @Override
    public void run() {
        bk.a(this.b).a(this.a);
    }
}

