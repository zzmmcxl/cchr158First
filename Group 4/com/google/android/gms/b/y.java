/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.util.Base64OutputStream;
import com.google.android.gms.b.fp;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class y {
    ByteArrayOutputStream a = new ByteArrayOutputStream(4096);
    Base64OutputStream b = new Base64OutputStream((OutputStream)this.a, 10);

    public void a(byte[] arrby) {
        this.b.write(arrby);
    }

    public String toString() {
        try {
            this.b.close();
        }
        catch (IOException var1_2) {
            fp.b("HashManager: Unable to convert to Base64.", var1_2);
        }
        try {
            this.a.close();
            String string = this.a.toString();
            return string;
        }
        catch (IOException var3_3) {
            fp.b("HashManager: Unable to convert to Base64.", var3_3);
            return "";
        }
        finally {
            this.a = null;
            this.b = null;
        }
    }
}

