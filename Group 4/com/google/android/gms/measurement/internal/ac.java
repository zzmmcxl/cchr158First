/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.b.kf;
import com.google.android.gms.common.internal.bf;

class ac {
    private final kf a;
    private long b;

    public ac(kf kf2) {
        bf.a(kf2);
        this.a = kf2;
    }

    public void a() {
        this.b = this.a.b();
    }

    public boolean a(long l2) {
        if (this.b == 0) {
            return true;
        }
        if (this.a.b() - this.b >= l2) return true;
        return false;
    }

    public void b() {
        this.b = 0;
    }
}

