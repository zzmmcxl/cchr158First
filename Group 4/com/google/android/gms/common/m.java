/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common;

import com.google.android.gms.common.l;
import java.util.Arrays;

class m
extends l {
    private final byte[] a;

    m(byte[] arrby) {
        super(Arrays.copyOfRange(arrby, 0, 25));
        this.a = arrby;
    }

    @Override
    byte[] a() {
        return this.a;
    }
}

