/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import java.util.Map;

public class fk {
    public final int a;
    public final byte[] b;
    public final Map c;
    public final boolean d;
    public final long e;

    public fk(int n2, byte[] arrby, Map map, boolean bl2, long l2) {
        this.a = n2;
        this.b = arrby;
        this.c = map;
        this.d = bl2;
        this.e = l2;
    }

    public fk(byte[] arrby, Map map) {
        this(200, arrby, map, false, 0);
    }
}

