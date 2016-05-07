/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.l;
import com.google.android.gms.b.me;
import com.google.android.gms.b.ms;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

class mu {
    public long a;
    public String b;
    public String c;
    public long d;
    public long e;
    public long f;
    public long g;
    public Map h;

    private mu() {
    }

    public mu(String string, l l2) {
        this.b = string;
        this.a = l2.a.length;
        this.c = l2.b;
        this.d = l2.c;
        this.e = l2.d;
        this.f = l2.e;
        this.g = l2.f;
        this.h = l2.g;
    }

    public static mu a(InputStream inputStream) {
        mu mu2 = new mu();
        if (ms.a(inputStream) != 538247942) {
            throw new IOException();
        }
        mu2.b = ms.c(inputStream);
        mu2.c = ms.c(inputStream);
        if (mu2.c.equals("")) {
            mu2.c = null;
        }
        mu2.d = ms.b(inputStream);
        mu2.e = ms.b(inputStream);
        mu2.f = ms.b(inputStream);
        mu2.g = ms.b(inputStream);
        mu2.h = ms.d(inputStream);
        return mu2;
    }

    public l a(byte[] arrby) {
        l l2 = new l();
        l2.a = arrby;
        l2.b = this.c;
        l2.c = this.d;
        l2.d = this.e;
        l2.e = this.f;
        l2.f = this.g;
        l2.g = this.h;
        return l2;
    }

    public boolean a(OutputStream outputStream) {
        try {
            ms.a(outputStream, 538247942);
            ms.a(outputStream, this.b);
            String string = this.c == null ? "" : this.c;
            ms.a(outputStream, string);
            ms.a(outputStream, this.d);
            ms.a(outputStream, this.e);
            ms.a(outputStream, this.f);
            ms.a(outputStream, this.g);
            ms.a(this.h, outputStream);
            outputStream.flush();
            return true;
        }
        catch (IOException var2_3) {
            Object[] arrobject = new Object[]{var2_3.toString()};
            me.b("%s", arrobject);
            return false;
        }
    }
}

