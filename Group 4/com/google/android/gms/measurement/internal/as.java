/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.bf;

class as {
    final String a;
    final String b;
    final long c;
    final long d;
    final long e;

    as(String string, String string2, long l2, long l3, long l4) {
        boolean bl2 = true;
        bf.a(string);
        bf.a(string2);
        boolean bl3 = l2 >= 0 ? bl2 : false;
        bf.b(bl3);
        if (l3 < 0) {
            bl2 = false;
        }
        bf.b(bl2);
        this.a = string;
        this.b = string2;
        this.c = l2;
        this.d = l3;
        this.e = l4;
    }

    as a() {
        return new as(this.a, this.b, 1 + this.c, 1 + this.d, this.e);
    }

    as a(long l2) {
        return new as(this.a, this.b, this.c, this.d, l2);
    }
}

