/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

class cb {
    long a = 0;
    cb b;

    cb() {
    }

    private void b() {
        if (this.b != null) return;
        this.b = new cb();
    }

    void a() {
        this.a = 0;
        if (this.b == null) return;
        this.b.a();
    }

    void a(int n2) {
        if (n2 >= 64) {
            this.b();
            this.b.a(n2 - 64);
            return;
        }
        this.a |= 1 << n2;
    }

    void a(int n2, boolean bl2) {
        if (n2 >= 64) {
            this.b();
            this.b.a(n2 - 64, bl2);
            return;
        }
        boolean bl3 = (Long.MIN_VALUE & this.a) != 0;
        long l2 = (1 << n2) - 1;
        this.a = l2 & this.a | (this.a & (l2 ^ -1)) << 1;
        if (bl2) {
            this.a(n2);
        } else {
            this.b(n2);
        }
        if (!bl3) {
            if (this.b == null) return;
        }
        this.b();
        this.b.a(0, bl3);
    }

    void b(int n2) {
        if (n2 >= 64) {
            if (this.b == null) return;
            this.b.b(n2 - 64);
            return;
        }
        this.a &= -1 ^ 1 << n2;
    }

    boolean c(int n2) {
        if (n2 >= 64) {
            this.b();
            return this.b.c(n2 - 64);
        }
        if ((this.a & 1 << n2) == 0) return false;
        return true;
    }

    boolean d(int n2) {
        if (n2 >= 64) {
            this.b();
            return this.b.d(n2 - 64);
        }
        long l2 = 1 << n2;
        boolean bl2 = (l2 & this.a) != 0;
        this.a &= l2 ^ -1;
        long l3 = l2 - 1;
        this.a = l3 & this.a | Long.rotateRight(this.a & (l3 ^ -1), 1);
        if (this.b == null) return bl2;
        if (this.b.c(0)) {
            this.a(63);
        }
        this.b.d(0);
        return bl2;
    }

    int e(int n2) {
        if (this.b == null) {
            if (n2 < 64) return Long.bitCount(this.a & (1 << n2) - 1);
            return Long.bitCount(this.a);
        }
        if (n2 >= 64) return this.b.e(n2 - 64) + Long.bitCount(this.a);
        return Long.bitCount(this.a & (1 << n2) - 1);
    }

    public String toString() {
        if (this.b != null) return this.b.toString() + "xx" + Long.toBinaryString(this.a);
        return Long.toBinaryString(this.a);
    }
}

