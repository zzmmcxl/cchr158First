/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.b.kf;
import com.google.android.gms.b.kh;
import com.google.android.gms.common.internal.bf;

public class x {
    private final String a;
    private final long b;
    private final kf c;

    public x(String string, long l2) {
        this(string, l2, kh.c());
    }

    private x(String string, long l2, kf kf2) {
        this.a = bf.a(string);
        boolean bl2 = l2 > 0;
        bf.b(bl2);
        this.b = l2;
        this.c = (kf)bf.a(kf2);
    }

    public boolean a() {
        if (this.c.a() / 1000 < this.b - 300) return false;
        return true;
    }
}

