/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.g;

import android.support.v4.g.c;

public class f
implements Cloneable {
    private static final Object a = new Object();
    private boolean b = false;
    private long[] c;
    private Object[] d;
    private int e;

    public f() {
        this(10);
    }

    public f(int n2) {
        if (n2 == 0) {
            this.c = c.b;
            this.d = c.c;
        } else {
            int n3 = c.b(n2);
            this.c = new long[n3];
            this.d = new Object[n3];
        }
        this.e = 0;
    }

    private void d() {
        int n2 = this.e;
        long[] arrl = this.c;
        Object[] arrobject = this.d;
        int n3 = 0;
        int n4 = 0;
        do {
            if (n3 >= n2) {
                this.b = false;
                this.e = n4;
                return;
            }
            Object object = arrobject[n3];
            if (object != a) {
                if (n3 != n4) {
                    arrl[n4] = arrl[n3];
                    arrobject[n4] = object;
                    arrobject[n3] = null;
                }
                ++n4;
            }
            ++n3;
        } while (true);
    }

    public f a() {
        f f2;
        try {
            f2 = (f)super.clone();
        }
        catch (CloneNotSupportedException var1_2) {
            return null;
        }
        try {
            f2.c = (long[])this.c.clone();
            f2.d = (Object[])this.d.clone();
            return f2;
        }
        catch (CloneNotSupportedException var3_3) {
            return f2;
        }
    }

    public Object a(long l2) {
        return this.a(l2, null);
    }

    public Object a(long l2, Object object) {
        int n2 = c.a(this.c, this.e, l2);
        if (n2 < 0) return object;
        if (this.d[n2] != a) return this.d[n2];
        return object;
    }

    public void a(int n2) {
        if (this.d[n2] == a) return;
        this.d[n2] = a;
        this.b = true;
    }

    public int b() {
        if (!this.b) return this.e;
        this.d();
        return this.e;
    }

    public long b(int n2) {
        if (!this.b) return this.c[n2];
        this.d();
        return this.c[n2];
    }

    public void b(long l2) {
        int n2 = c.a(this.c, this.e, l2);
        if (n2 < 0) return;
        if (this.d[n2] == a) return;
        this.d[n2] = a;
        this.b = true;
    }

    public void b(long l2, Object object) {
        int n2 = c.a(this.c, this.e, l2);
        if (n2 >= 0) {
            this.d[n2] = object;
            return;
        }
        int n3 = ~ n2;
        if (n3 < this.e && this.d[n3] == a) {
            this.c[n3] = l2;
            this.d[n3] = object;
            return;
        }
        if (this.b && this.e >= this.c.length) {
            this.d();
            n3 = -1 ^ c.a(this.c, this.e, l2);
        }
        if (this.e >= this.c.length) {
            int n4 = c.b(1 + this.e);
            long[] arrl = new long[n4];
            Object[] arrobject = new Object[n4];
            System.arraycopy(this.c, 0, arrl, 0, this.c.length);
            System.arraycopy(this.d, 0, arrobject, 0, this.d.length);
            this.c = arrl;
            this.d = arrobject;
        }
        if (this.e - n3 != 0) {
            System.arraycopy(this.c, n3, this.c, n3 + 1, this.e - n3);
            System.arraycopy(this.d, n3, this.d, n3 + 1, this.e - n3);
        }
        this.c[n3] = l2;
        this.d[n3] = object;
        this.e = 1 + this.e;
    }

    public Object c(int n2) {
        if (!this.b) return this.d[n2];
        this.d();
        return this.d[n2];
    }

    public void c() {
        int n2 = this.e;
        Object[] arrobject = this.d;
        int n3 = 0;
        do {
            if (n3 >= n2) {
                this.e = 0;
                this.b = false;
                return;
            }
            arrobject[n3] = null;
            ++n3;
        } while (true);
    }

    public /* synthetic */ Object clone() {
        return this.a();
    }

    public String toString() {
        if (this.b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(28 * this.e);
        stringBuilder.append('{');
        int n2 = 0;
        do {
            if (n2 >= this.e) {
                stringBuilder.append('}');
                return stringBuilder.toString();
            }
            if (n2 > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(this.b(n2));
            stringBuilder.append('=');
            Object object = this.c(n2);
            if (object != this) {
                stringBuilder.append(object);
            } else {
                stringBuilder.append("(this Map)");
            }
            ++n2;
        } while (true);
    }
}

