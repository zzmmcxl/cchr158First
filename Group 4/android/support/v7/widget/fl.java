/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

class fl {
    private int a = 0;
    private int b = 0;
    private int c = Integer.MIN_VALUE;
    private int d = Integer.MIN_VALUE;
    private int e = 0;
    private int f = 0;
    private boolean g = false;
    private boolean h = false;

    fl() {
    }

    public int a() {
        return this.a;
    }

    public void a(int n2, int n3) {
        this.c = n2;
        this.d = n3;
        this.h = true;
        if (this.g) {
            if (n3 != Integer.MIN_VALUE) {
                this.a = n3;
            }
            if (n2 == Integer.MIN_VALUE) return;
            this.b = n2;
            return;
        }
        if (n2 != Integer.MIN_VALUE) {
            this.a = n2;
        }
        if (n3 == Integer.MIN_VALUE) return;
        this.b = n3;
    }

    public void a(boolean bl2) {
        if (bl2 == this.g) {
            return;
        }
        this.g = bl2;
        if (!this.h) {
            this.a = this.e;
            this.b = this.f;
            return;
        }
        if (bl2) {
            int n2 = this.d != Integer.MIN_VALUE ? this.d : this.e;
            this.a = n2;
            int n3 = this.c != Integer.MIN_VALUE ? this.c : this.f;
            this.b = n3;
            return;
        }
        int n4 = this.c != Integer.MIN_VALUE ? this.c : this.e;
        this.a = n4;
        int n5 = this.d != Integer.MIN_VALUE ? this.d : this.f;
        this.b = n5;
    }

    public int b() {
        return this.b;
    }

    public void b(int n2, int n3) {
        this.h = false;
        if (n2 != Integer.MIN_VALUE) {
            this.e = n2;
            this.a = n2;
        }
        if (n3 == Integer.MIN_VALUE) return;
        this.f = n3;
        this.b = n3;
    }

    public int c() {
        if (!this.g) return this.a;
        return this.b;
    }

    public int d() {
        if (!this.g) return this.b;
        return this.a;
    }
}

