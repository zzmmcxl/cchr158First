/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.lc;
import com.google.android.gms.b.ld;
import com.google.android.gms.b.mh;
import com.google.android.gms.b.mi;
import com.google.android.gms.b.mk;
import com.google.android.gms.b.mm;
import com.google.android.gms.b.mo;

public final class lb
extends mm {
    private static volatile lb[] f;
    public Integer a;
    public String b;
    public lc[] c;
    public Boolean d;
    public ld e;

    public lb() {
        this.b();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static lb[] a() {
        if (f != null) return f;
        Object object = mk.a;
        // MONITORENTER : object
        if (f == null) {
            f = new lb[0];
        }
        // MONITOREXIT : object
        return f;
    }

    public lb a(mh mh2) {
        block8 : do {
            int n2 = mh2.a();
            switch (n2) {
                default: {
                    if (mo.a(mh2, n2)) continue block8;
                    return this;
                }
                case 8: {
                    this.a = mh2.f();
                    continue block8;
                }
                case 18: {
                    this.b = mh2.h();
                    continue block8;
                }
                case 26: {
                    int n3 = mo.b(mh2, 26);
                    int n4 = this.c == null ? 0 : this.c.length;
                    lc[] arrlc = new lc[n3 + n4];
                    if (n4 != 0) {
                        System.arraycopy(this.c, 0, arrlc, 0, n4);
                    }
                    while (n4 < -1 + arrlc.length) {
                        arrlc[n4] = new lc();
                        mh2.a(arrlc[n4]);
                        mh2.a();
                        ++n4;
                    }
                    arrlc[n4] = new lc();
                    mh2.a(arrlc[n4]);
                    this.c = arrlc;
                    continue block8;
                }
                case 32: {
                    this.d = mh2.g();
                    continue block8;
                }
                case 42: {
                    if (this.e == null) {
                        this.e = new ld();
                    }
                    mh2.a(this.e);
                    continue block8;
                }
                case 0: 
            }
            break;
        } while (true);
        return this;
    }

    @Override
    public void a(mi mi2) {
        if (this.a != null) {
            mi2.a(1, this.a);
        }
        if (this.b != null) {
            mi2.a(2, this.b);
        }
        if (this.c != null && this.c.length > 0) {
            for (int i2 = 0; i2 < this.c.length; ++i2) {
                lc lc2 = this.c[i2];
                if (lc2 == null) continue;
                mi2.a(3, lc2);
            }
        }
        if (this.d != null) {
            mi2.a(4, this.d);
        }
        if (this.e != null) {
            mi2.a(5, this.e);
        }
        super.a(mi2);
    }

    public lb b() {
        this.a = null;
        this.b = null;
        this.c = lc.a();
        this.d = null;
        this.e = null;
        this.B = -1;
        return this;
    }

    @Override
    public /* synthetic */ mm b(mh mh2) {
        return this.a(mh2);
    }

    @Override
    protected int c() {
        int n2 = super.c();
        if (this.a != null) {
            n2 += mi.b(1, this.a);
        }
        if (this.b != null) {
            n2 += mi.b(2, this.b);
        }
        if (this.c != null && this.c.length > 0) {
            int n3 = n2;
            for (int i2 = 0; i2 < this.c.length; ++i2) {
                lc lc2 = this.c[i2];
                if (lc2 == null) continue;
                n3 += mi.b(3, lc2);
            }
            n2 = n3;
        }
        if (this.d != null) {
            n2 += mi.b(4, this.d);
        }
        if (this.e == null) return n2;
        n2 += mi.b(5, this.e);
        return n2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof lb)) {
            return false;
        }
        lb lb2 = (lb)object;
        if (this.a == null ? lb2.a != null : !this.a.equals(lb2.a)) {
            return false;
        }
        if (this.b == null ? lb2.b != null : !this.b.equals(lb2.b)) {
            return false;
        }
        if (!mk.a(this.c, lb2.c)) {
            return false;
        }
        if (this.d == null ? lb2.d != null : !this.d.equals(lb2.d)) {
            return false;
        }
        if (this.e == null) {
            if (lb2.e == null) return true;
            return false;
        }
        if (this.e.equals(lb2.e)) return true;
        return false;
    }

    public int hashCode() {
        int n2 = 31 * (527 + this.getClass().getName().hashCode());
        int n3 = this.a == null ? 0 : this.a.hashCode();
        int n4 = 31 * (n3 + n2);
        int n5 = this.b == null ? 0 : this.b.hashCode();
        int n6 = 31 * (31 * (n5 + n4) + mk.a(this.c));
        int n7 = this.d == null ? 0 : this.d.hashCode();
        int n8 = 31 * (n7 + n6);
        ld ld2 = this.e;
        int n9 = 0;
        if (ld2 == null) {
            return n8 + n9;
        }
        n9 = this.e.hashCode();
        return n8 + n9;
    }
}

