/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.bx;
import com.google.android.gms.measurement.internal.ck;

abstract class cl
extends ck {
    private boolean a;
    private boolean b;
    private boolean c;

    cl(bx bx2) {
        super(bx2);
        this.n.a(this);
    }

    boolean E() {
        if (!this.a) return false;
        if (this.b) return false;
        return true;
    }

    boolean F() {
        return this.c;
    }

    protected void G() {
        if (this.E()) return;
        throw new IllegalStateException("Not initialized");
    }

    public final void H() {
        if (this.a) {
            throw new IllegalStateException("Can't initialize twice");
        }
        this.a();
        this.n.C();
        this.a = true;
    }

    protected abstract void a();
}

