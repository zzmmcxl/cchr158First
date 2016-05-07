/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.fk;

public class lt
extends Exception {
    public final fk a;
    private long b;

    public lt() {
        this.a = null;
    }

    public lt(fk fk2) {
        this.a = fk2;
    }

    public lt(Throwable throwable) {
        super(throwable);
        this.a = null;
    }

    void a(long l2) {
        this.b = l2;
    }
}

