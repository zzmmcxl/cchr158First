/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.bf;
import com.google.android.gms.measurement.internal.bg;
import com.google.android.gms.measurement.internal.bh;

class bi
implements Runnable {
    private final bh a;
    private final int b;
    private final Throwable c;
    private final byte[] d;
    private final String e;

    private bi(String string, bh bh2, int n2, Throwable throwable, byte[] arrby) {
        bf.a(bh2);
        this.a = bh2;
        this.b = n2;
        this.c = throwable;
        this.d = arrby;
        this.e = string;
    }

    /* synthetic */ bi(String string, bh bh2, int n2, Throwable throwable, byte[] arrby, bg bg2) {
        this(string, bh2, n2, throwable, arrby);
    }

    @Override
    public void run() {
        this.a.a(this.e, this.b, this.c, this.d);
    }
}

