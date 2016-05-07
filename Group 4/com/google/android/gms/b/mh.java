/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.ml;
import com.google.android.gms.b.mm;
import com.google.android.gms.b.mo;

public final class mh {
    private final byte[] a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g = Integer.MAX_VALUE;
    private int h;
    private int i = 64;
    private int j = 67108864;

    private mh(byte[] arrby, int n2, int n3) {
        this.a = arrby;
        this.b = n2;
        this.c = n2 + n3;
        this.e = n2;
    }

    public static mh a(byte[] arrby) {
        return mh.a(arrby, 0, arrby.length);
    }

    public static mh a(byte[] arrby, int n2, int n3) {
        return new mh(arrby, n2, n3);
    }

    private void q() {
        this.c += this.d;
        int n2 = this.c;
        if (n2 > this.g) {
            this.d = n2 - this.g;
            this.c -= this.d;
            return;
        }
        this.d = 0;
    }

    public int a() {
        if (this.n()) {
            this.f = 0;
            return 0;
        }
        this.f = this.i();
        if (this.f != 0) return this.f;
        throw ml.d();
    }

    public void a(int n2) {
        if (this.f == n2) return;
        throw ml.e();
    }

    public void a(mm mm2) {
        int n2 = this.i();
        if (this.h >= this.i) {
            throw ml.g();
        }
        int n3 = this.c(n2);
        this.h = 1 + this.h;
        mm2.b(this);
        this.a(0);
        this.h = -1 + this.h;
        this.d(n3);
    }

    public void b() {
        int n2;
        do {
            if ((n2 = this.a()) == 0) return;
        } while (this.b(n2));
    }

    public boolean b(int n2) {
        switch (mo.a(n2)) {
            default: {
                throw ml.f();
            }
            case 0: {
                this.f();
                return true;
            }
            case 1: {
                this.l();
                return true;
            }
            case 2: {
                this.g(this.i());
                return true;
            }
            case 3: {
                this.b();
                this.a(mo.a(mo.b(n2), 4));
                return true;
            }
            case 4: {
                return false;
            }
            case 5: 
        }
        this.k();
        return true;
    }

    public float c() {
        return Float.intBitsToFloat(this.k());
    }

    public int c(int n2) {
        if (n2 < 0) {
            throw ml.b();
        }
        int n3 = n2 + this.e;
        int n4 = this.g;
        if (n3 > n4) {
            throw ml.a();
        }
        this.g = n3;
        this.q();
        return n4;
    }

    public long d() {
        return this.j();
    }

    public void d(int n2) {
        this.g = n2;
        this.q();
    }

    public long e() {
        return this.j();
    }

    public void e(int n2) {
        if (n2 > this.e - this.b) {
            throw new IllegalArgumentException("Position " + n2 + " is beyond current " + (this.e - this.b));
        }
        if (n2 < 0) {
            throw new IllegalArgumentException("Bad position " + n2);
        }
        this.e = n2 + this.b;
    }

    public int f() {
        return this.i();
    }

    public byte[] f(int n2) {
        if (n2 < 0) {
            throw ml.b();
        }
        if (n2 + this.e > this.g) {
            this.g(this.g - this.e);
            throw ml.a();
        }
        if (n2 > this.c - this.e) throw ml.a();
        byte[] arrby = new byte[n2];
        System.arraycopy(this.a, this.e, arrby, 0, n2);
        this.e = n2 + this.e;
        return arrby;
    }

    public void g(int n2) {
        if (n2 < 0) {
            throw ml.b();
        }
        if (n2 + this.e > this.g) {
            this.g(this.g - this.e);
            throw ml.a();
        }
        if (n2 > this.c - this.e) throw ml.a();
        this.e = n2 + this.e;
    }

    public boolean g() {
        if (this.i() == 0) return false;
        return true;
    }

    public String h() {
        int n2 = this.i();
        if (n2 > this.c - this.e) return new String(this.f(n2), "UTF-8");
        if (n2 <= 0) return new String(this.f(n2), "UTF-8");
        String string = new String(this.a, this.e, n2, "UTF-8");
        this.e = n2 + this.e;
        return string;
    }

    public int i() {
        int n2 = this.p();
        if (n2 >= 0) {
            return n2;
        }
        int n3 = n2 & 127;
        byte by2 = this.p();
        if (by2 >= 0) {
            return n3 | by2 << 7;
        }
        int n4 = n3 | (by2 & 127) << 7;
        byte by3 = this.p();
        if (by3 >= 0) {
            return n4 | by3 << 14;
        }
        int n5 = n4 | (by3 & 127) << 14;
        byte by4 = this.p();
        if (by4 >= 0) {
            return n5 | by4 << 21;
        }
        int n6 = n5 | (by4 & 127) << 21;
        byte by5 = this.p();
        n2 = n6 | by5 << 28;
        if (by5 >= 0) return n2;
        int n7 = 0;
        while (n7 < 5) {
            if (this.p() >= 0) return n2;
            ++n7;
        }
        throw ml.c();
    }

    public long j() {
        int n2 = 0;
        long l2 = 0;
        while (n2 < 64) {
            byte by2 = this.p();
            l2 |= (long)(by2 & 127) << n2;
            if ((by2 & 128) == 0) {
                return l2;
            }
            n2 += 7;
        }
        throw ml.c();
    }

    public int k() {
        byte by2 = this.p();
        byte by3 = this.p();
        byte by4 = this.p();
        byte by5 = this.p();
        return by2 & 255 | (by3 & 255) << 8 | (by4 & 255) << 16 | (by5 & 255) << 24;
    }

    public long l() {
        byte by2 = this.p();
        byte by3 = this.p();
        byte by4 = this.p();
        byte by5 = this.p();
        byte by6 = this.p();
        byte by7 = this.p();
        byte by8 = this.p();
        byte by9 = this.p();
        return 255 & (long)by2 | (255 & (long)by3) << 8 | (255 & (long)by4) << 16 | (255 & (long)by5) << 24 | (255 & (long)by6) << 32 | (255 & (long)by7) << 40 | (255 & (long)by8) << 48 | (255 & (long)by9) << 56;
    }

    public int m() {
        if (this.g == Integer.MAX_VALUE) {
            return -1;
        }
        int n2 = this.e;
        return this.g - n2;
    }

    public boolean n() {
        if (this.e != this.c) return false;
        return true;
    }

    public int o() {
        return this.e - this.b;
    }

    public byte p() {
        if (this.e == this.c) {
            throw ml.a();
        }
        byte[] arrby = this.a;
        int n2 = this.e;
        this.e = n2 + 1;
        return arrby[n2];
    }
}

