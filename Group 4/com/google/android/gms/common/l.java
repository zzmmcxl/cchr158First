/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common;

import com.google.android.gms.common.internal.bf;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class l {
    private int a;

    protected l(byte[] arrby) {
        boolean bl2 = arrby.length == 25;
        bf.b(bl2, "cert hash data has incorrect length");
        this.a = Arrays.hashCode(arrby);
    }

    protected static byte[] a(String string) {
        try {
            return string.getBytes("ISO-8859-1");
        }
        catch (UnsupportedEncodingException var1_2) {
            throw new AssertionError(var1_2);
        }
    }

    abstract byte[] a();

    public boolean equals(Object object) {
        if (object == null) return false;
        if (!(object instanceof l)) {
            return false;
        }
        l l2 = (l)object;
        return Arrays.equals(this.a(), l2.a());
    }

    public int hashCode() {
        return this.a;
    }
}

