/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.ak;
import com.google.android.gms.common.api.internal.al;

abstract class am {
    private final ak a;

    protected am(ak ak2) {
        this.a = ak2;
    }

    protected abstract void a();

    public final void a(al al2) {
        al.a(al2).lock();
        ak ak2 = al.b(al2);
        ak ak3 = this.a;
        if (ak2 != ak3) {
            al.a(al2).unlock();
            return;
        }
        this.a();
        return;
    }
}

