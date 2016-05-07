/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.fi;
import com.google.android.gms.b.u;
import com.google.android.gms.b.z;
import java.security.MessageDigest;

@fi
public class aa
extends u {
    private MessageDigest b;

    byte a(int n2) {
        return (byte)(n2 & 255 ^ (65280 & n2) >> 8 ^ (16711680 & n2) >> 16 ^ (-16777216 & n2) >> 24);
    }

    @Override
    public byte[] a(String string) {
        byte[] arrby = this.a(string.split(" "));
        this.b = this.a();
        Object object = this.a;
        // MONITORENTER : object
        if (this.b == null) {
            byte[] arrby2 = new byte[]{};
            // MONITOREXIT : object
            return arrby2;
        }
        this.b.reset();
        this.b.update(arrby);
        byte[] arrby3 = this.b.digest();
        int n2 = 4;
        if (arrby3.length <= n2) {
            n2 = arrby3.length;
        }
        byte[] arrby4 = new byte[n2];
        System.arraycopy(arrby3, 0, arrby4, 0, arrby4.length);
        // MONITOREXIT : object
        return arrby4;
    }

    byte[] a(String[] arrstring) {
        byte[] arrby = new byte[arrstring.length];
        int n2 = 0;
        while (n2 < arrstring.length) {
            arrby[n2] = this.a(z.a(arrstring[n2]));
            ++n2;
        }
        return arrby;
    }
}

