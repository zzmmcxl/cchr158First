/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.g;

import android.support.v4.g.c;

public class r
implements Cloneable {
    private static final Object a = new Object();
    private boolean b = false;
    private int[] c;
    private Object[] d;
    private int e;

    public r() {
        this(10);
    }

    public r(int n2) {
        if (n2 == 0) {
            this.c = c.a;
            this.d = c.c;
        } else {
            int n3 = c.a(n2);
            this.c = new int[n3];
            this.d = new Object[n3];
        }
        this.e = 0;
    }

    private void d() {
        int n2 = this.e;
        int[] arrn = this.c;
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
                    arrn[n4] = arrn[n3];
                    arrobject[n4] = object;
                    arrobject[n3] = null;
                }
                ++n4;
            }
            ++n3;
        } while (true);
    }

    public r a() {
        r r2;
        try {
            r2 = (r)super.clone();
        }
        catch (CloneNotSupportedException var1_2) {
            return null;
        }
        try {
            r2.c = (int[])this.c.clone();
            r2.d = (Object[])this.d.clone();
            return r2;
        }
        catch (CloneNotSupportedException var3_3) {
            return r2;
        }
    }

    public Object a(int n2) {
        return this.a(n2, null);
    }

    public Object a(int n2, Object object) {
        int n3 = c.a(this.c, this.e, n2);
        if (n3 < 0) return object;
        if (this.d[n3] != a) return this.d[n3];
        return object;
    }

    public int b() {
        if (!this.b) return this.e;
        this.d();
        return this.e;
    }

    public void b(int n2) {
        int n3 = c.a(this.c, this.e, n2);
        if (n3 < 0) return;
        if (this.d[n3] == a) return;
        this.d[n3] = a;
        this.b = true;
    }

    public void b(int n2, Object object) {
        int n3 = c.a(this.c, this.e, n2);
        if (n3 >= 0) {
            this.d[n3] = object;
            return;
        }
        int n4 = ~ n3;
        if (n4 < this.e && this.d[n4] == a) {
            this.c[n4] = n2;
            this.d[n4] = object;
            return;
        }
        if (this.b && this.e >= this.c.length) {
            this.d();
            n4 = -1 ^ c.a(this.c, this.e, n2);
        }
        if (this.e >= this.c.length) {
            int n5 = c.a(1 + this.e);
            int[] arrn = new int[n5];
            Object[] arrobject = new Object[n5];
            System.arraycopy(this.c, 0, arrn, 0, this.c.length);
            System.arraycopy(this.d, 0, arrobject, 0, this.d.length);
            this.c = arrn;
            this.d = arrobject;
        }
        if (this.e - n4 != 0) {
            System.arraycopy(this.c, n4, this.c, n4 + 1, this.e - n4);
            System.arraycopy(this.d, n4, this.d, n4 + 1, this.e - n4);
        }
        this.c[n4] = n2;
        this.d[n4] = object;
        this.e = 1 + this.e;
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

    public void c(int n2) {
        this.b(n2);
    }

    public /* synthetic */ Object clone() {
        return this.a();
    }

    public int d(int n2) {
        if (!this.b) return this.c[n2];
        this.d();
        return this.c[n2];
    }

    public Object e(int n2) {
        if (!this.b) return this.d[n2];
        this.d();
        return this.d[n2];
    }

    public int f(int n2) {
        if (!this.b) return c.a(this.c, this.e, n2);
        this.d();
        return c.a(this.c, this.e, n2);
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
            stringBuilder.append(this.d(n2));
            stringBuilder.append('=');
            Object object = this.e(n2);
            if (object != this) {
                stringBuilder.append(object);
            } else {
                stringBuilder.append("(this Map)");
            }
            ++n2;
        } while (true);
    }
}

