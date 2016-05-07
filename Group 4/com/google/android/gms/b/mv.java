/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.mt;
import java.io.FilterInputStream;
import java.io.InputStream;

class mv
extends FilterInputStream {
    private int a = 0;

    private mv(InputStream inputStream) {
        super(inputStream);
    }

    /* synthetic */ mv(InputStream inputStream, mt mt2) {
        this(inputStream);
    }

    static /* synthetic */ int a(mv mv2) {
        return mv2.a;
    }

    @Override
    public int read() {
        int n2 = super.read();
        if (n2 == -1) return n2;
        this.a = 1 + this.a;
        return n2;
    }

    @Override
    public int read(byte[] arrby, int n2, int n3) {
        int n4 = super.read(arrby, n2, n3);
        if (n4 == -1) return n4;
        this.a = n4 + this.a;
        return n4;
    }
}

