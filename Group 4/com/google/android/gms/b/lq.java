/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.lm;
import com.google.android.gms.b.ln;
import com.google.android.gms.b.ls;
import com.google.android.gms.b.mh;
import com.google.android.gms.b.mi;
import com.google.android.gms.b.mk;
import com.google.android.gms.b.mm;
import com.google.android.gms.b.mo;

public final class lq
extends mm {
    private static volatile lq[] C;
    public lm[] A;
    public Integer a;
    public ln[] b;
    public ls[] c;
    public Long d;
    public Long e;
    public Long f;
    public Long g;
    public Long h;
    public String i;
    public String j;
    public String k;
    public String l;
    public Integer m;
    public String n;
    public String o;
    public String p;
    public Long q;
    public Long r;
    public String s;
    public Boolean t;
    public String u;
    public Long v;
    public Integer w;
    public String x;
    public String y;
    public Boolean z;

    public lq() {
        this.b();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static lq[] a() {
        if (C != null) return C;
        Object object = mk.a;
        // MONITORENTER : object
        if (C == null) {
            C = new lq[0];
        }
        // MONITOREXIT : object
        return C;
    }

    public lq a(mh mh2) {
        block30 : do {
            int n2 = mh2.a();
            switch (n2) {
                default: {
                    if (mo.a(mh2, n2)) continue block30;
                    return this;
                }
                case 8: {
                    this.a = mh2.f();
                    continue block30;
                }
                case 18: {
                    int n3 = mo.b(mh2, 18);
                    int n4 = this.b == null ? 0 : this.b.length;
                    ln[] arrln = new ln[n3 + n4];
                    if (n4 != 0) {
                        System.arraycopy(this.b, 0, arrln, 0, n4);
                    }
                    while (n4 < -1 + arrln.length) {
                        arrln[n4] = new ln();
                        mh2.a(arrln[n4]);
                        mh2.a();
                        ++n4;
                    }
                    arrln[n4] = new ln();
                    mh2.a(arrln[n4]);
                    this.b = arrln;
                    continue block30;
                }
                case 26: {
                    int n5 = mo.b(mh2, 26);
                    int n6 = this.c == null ? 0 : this.c.length;
                    ls[] arrls = new ls[n5 + n6];
                    if (n6 != 0) {
                        System.arraycopy(this.c, 0, arrls, 0, n6);
                    }
                    while (n6 < -1 + arrls.length) {
                        arrls[n6] = new ls();
                        mh2.a(arrls[n6]);
                        mh2.a();
                        ++n6;
                    }
                    arrls[n6] = new ls();
                    mh2.a(arrls[n6]);
                    this.c = arrls;
                    continue block30;
                }
                case 32: {
                    this.d = mh2.e();
                    continue block30;
                }
                case 40: {
                    this.e = mh2.e();
                    continue block30;
                }
                case 48: {
                    this.f = mh2.e();
                    continue block30;
                }
                case 56: {
                    this.h = mh2.e();
                    continue block30;
                }
                case 66: {
                    this.i = mh2.h();
                    continue block30;
                }
                case 74: {
                    this.j = mh2.h();
                    continue block30;
                }
                case 82: {
                    this.k = mh2.h();
                    continue block30;
                }
                case 90: {
                    this.l = mh2.h();
                    continue block30;
                }
                case 96: {
                    this.m = mh2.f();
                    continue block30;
                }
                case 106: {
                    this.n = mh2.h();
                    continue block30;
                }
                case 114: {
                    this.o = mh2.h();
                    continue block30;
                }
                case 130: {
                    this.p = mh2.h();
                    continue block30;
                }
                case 136: {
                    this.q = mh2.e();
                    continue block30;
                }
                case 144: {
                    this.r = mh2.e();
                    continue block30;
                }
                case 154: {
                    this.s = mh2.h();
                    continue block30;
                }
                case 160: {
                    this.t = mh2.g();
                    continue block30;
                }
                case 170: {
                    this.u = mh2.h();
                    continue block30;
                }
                case 176: {
                    this.v = mh2.e();
                    continue block30;
                }
                case 184: {
                    this.w = mh2.f();
                    continue block30;
                }
                case 194: {
                    this.x = mh2.h();
                    continue block30;
                }
                case 202: {
                    this.y = mh2.h();
                    continue block30;
                }
                case 208: {
                    this.g = mh2.e();
                    continue block30;
                }
                case 224: {
                    this.z = mh2.g();
                    continue block30;
                }
                case 234: {
                    int n7 = mo.b(mh2, 234);
                    int n8 = this.A == null ? 0 : this.A.length;
                    lm[] arrlm = new lm[n7 + n8];
                    if (n8 != 0) {
                        System.arraycopy(this.A, 0, arrlm, 0, n8);
                    }
                    while (n8 < -1 + arrlm.length) {
                        arrlm[n8] = new lm();
                        mh2.a(arrlm[n8]);
                        mh2.a();
                        ++n8;
                    }
                    arrlm[n8] = new lm();
                    mh2.a(arrlm[n8]);
                    this.A = arrlm;
                    continue block30;
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
        if (this.b != null && this.b.length > 0) {
            for (int i2 = 0; i2 < this.b.length; ++i2) {
                ln ln2 = this.b[i2];
                if (ln2 == null) continue;
                mi2.a(2, ln2);
            }
        }
        if (this.c != null && this.c.length > 0) {
            for (int i3 = 0; i3 < this.c.length; ++i3) {
                ls ls2 = this.c[i3];
                if (ls2 == null) continue;
                mi2.a(3, ls2);
            }
        }
        if (this.d != null) {
            mi2.b(4, this.d);
        }
        if (this.e != null) {
            mi2.b(5, this.e);
        }
        if (this.f != null) {
            mi2.b(6, this.f);
        }
        if (this.h != null) {
            mi2.b(7, this.h);
        }
        if (this.i != null) {
            mi2.a(8, this.i);
        }
        if (this.j != null) {
            mi2.a(9, this.j);
        }
        if (this.k != null) {
            mi2.a(10, this.k);
        }
        if (this.l != null) {
            mi2.a(11, this.l);
        }
        if (this.m != null) {
            mi2.a(12, this.m);
        }
        if (this.n != null) {
            mi2.a(13, this.n);
        }
        if (this.o != null) {
            mi2.a(14, this.o);
        }
        if (this.p != null) {
            mi2.a(16, this.p);
        }
        if (this.q != null) {
            mi2.b(17, this.q);
        }
        if (this.r != null) {
            mi2.b(18, this.r);
        }
        if (this.s != null) {
            mi2.a(19, this.s);
        }
        if (this.t != null) {
            mi2.a(20, this.t);
        }
        if (this.u != null) {
            mi2.a(21, this.u);
        }
        if (this.v != null) {
            mi2.b(22, this.v);
        }
        if (this.w != null) {
            mi2.a(23, this.w);
        }
        if (this.x != null) {
            mi2.a(24, this.x);
        }
        if (this.y != null) {
            mi2.a(25, this.y);
        }
        if (this.g != null) {
            mi2.b(26, this.g);
        }
        if (this.z != null) {
            mi2.a(28, this.z);
        }
        if (this.A != null) {
            int n2 = this.A.length;
            if (n2 > 0) {
                for (int i4 = 0; i4 < this.A.length; ++i4) {
                    lm lm2 = this.A[i4];
                    if (lm2 == null) continue;
                    mi2.a(29, lm2);
                }
            }
        }
        super.a(mi2);
    }

    public lq b() {
        this.a = null;
        this.b = ln.a();
        this.c = ls.a();
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = lm.a();
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
        if (this.b != null && this.b.length > 0) {
            int n3 = n2;
            for (int i2 = 0; i2 < this.b.length; ++i2) {
                ln ln2 = this.b[i2];
                if (ln2 == null) continue;
                n3 += mi.b(2, ln2);
            }
            n2 = n3;
        }
        if (this.c != null && this.c.length > 0) {
            int n4 = n2;
            for (int i3 = 0; i3 < this.c.length; ++i3) {
                ls ls2 = this.c[i3];
                if (ls2 == null) continue;
                n4 += mi.b(3, ls2);
            }
            n2 = n4;
        }
        if (this.d != null) {
            n2 += mi.c(4, this.d);
        }
        if (this.e != null) {
            n2 += mi.c(5, this.e);
        }
        if (this.f != null) {
            n2 += mi.c(6, this.f);
        }
        if (this.h != null) {
            n2 += mi.c(7, this.h);
        }
        if (this.i != null) {
            n2 += mi.b(8, this.i);
        }
        if (this.j != null) {
            n2 += mi.b(9, this.j);
        }
        if (this.k != null) {
            n2 += mi.b(10, this.k);
        }
        if (this.l != null) {
            n2 += mi.b(11, this.l);
        }
        if (this.m != null) {
            n2 += mi.b(12, this.m);
        }
        if (this.n != null) {
            n2 += mi.b(13, this.n);
        }
        if (this.o != null) {
            n2 += mi.b(14, this.o);
        }
        if (this.p != null) {
            n2 += mi.b(16, this.p);
        }
        if (this.q != null) {
            n2 += mi.c(17, this.q);
        }
        if (this.r != null) {
            n2 += mi.c(18, this.r);
        }
        if (this.s != null) {
            n2 += mi.b(19, this.s);
        }
        if (this.t != null) {
            n2 += mi.b(20, this.t);
        }
        if (this.u != null) {
            n2 += mi.b(21, this.u);
        }
        if (this.v != null) {
            n2 += mi.c(22, this.v);
        }
        if (this.w != null) {
            n2 += mi.b(23, this.w);
        }
        if (this.x != null) {
            n2 += mi.b(24, this.x);
        }
        if (this.y != null) {
            n2 += mi.b(25, this.y);
        }
        if (this.g != null) {
            n2 += mi.c(26, this.g);
        }
        if (this.z != null) {
            n2 += mi.b(28, this.z);
        }
        if (this.A == null) return n2;
        int n5 = this.A.length;
        int n6 = 0;
        if (n5 <= 0) return n2;
        while (n6 < this.A.length) {
            lm lm2 = this.A[n6];
            if (lm2 != null) {
                n2 += mi.b(29, lm2);
            }
            ++n6;
        }
        return n2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof lq)) {
            return false;
        }
        lq lq2 = (lq)object;
        if (this.a == null ? lq2.a != null : !this.a.equals(lq2.a)) {
            return false;
        }
        if (!mk.a(this.b, lq2.b)) {
            return false;
        }
        if (!mk.a(this.c, lq2.c)) {
            return false;
        }
        if (this.d == null ? lq2.d != null : !this.d.equals(lq2.d)) {
            return false;
        }
        if (this.e == null ? lq2.e != null : !this.e.equals(lq2.e)) {
            return false;
        }
        if (this.f == null ? lq2.f != null : !this.f.equals(lq2.f)) {
            return false;
        }
        if (this.g == null ? lq2.g != null : !this.g.equals(lq2.g)) {
            return false;
        }
        if (this.h == null ? lq2.h != null : !this.h.equals(lq2.h)) {
            return false;
        }
        if (this.i == null ? lq2.i != null : !this.i.equals(lq2.i)) {
            return false;
        }
        if (this.j == null ? lq2.j != null : !this.j.equals(lq2.j)) {
            return false;
        }
        if (this.k == null ? lq2.k != null : !this.k.equals(lq2.k)) {
            return false;
        }
        if (this.l == null ? lq2.l != null : !this.l.equals(lq2.l)) {
            return false;
        }
        if (this.m == null ? lq2.m != null : !this.m.equals(lq2.m)) {
            return false;
        }
        if (this.n == null ? lq2.n != null : !this.n.equals(lq2.n)) {
            return false;
        }
        if (this.o == null ? lq2.o != null : !this.o.equals(lq2.o)) {
            return false;
        }
        if (this.p == null ? lq2.p != null : !this.p.equals(lq2.p)) {
            return false;
        }
        if (this.q == null ? lq2.q != null : !this.q.equals(lq2.q)) {
            return false;
        }
        if (this.r == null ? lq2.r != null : !this.r.equals(lq2.r)) {
            return false;
        }
        if (this.s == null ? lq2.s != null : !this.s.equals(lq2.s)) {
            return false;
        }
        if (this.t == null ? lq2.t != null : !this.t.equals(lq2.t)) {
            return false;
        }
        if (this.u == null ? lq2.u != null : !this.u.equals(lq2.u)) {
            return false;
        }
        if (this.v == null ? lq2.v != null : !this.v.equals(lq2.v)) {
            return false;
        }
        if (this.w == null ? lq2.w != null : !this.w.equals(lq2.w)) {
            return false;
        }
        if (this.x == null ? lq2.x != null : !this.x.equals(lq2.x)) {
            return false;
        }
        if (this.y == null ? lq2.y != null : !this.y.equals(lq2.y)) {
            return false;
        }
        if (this.z == null ? lq2.z != null : !this.z.equals(lq2.z)) {
            return false;
        }
        if (mk.a(this.A, lq2.A)) return true;
        return false;
    }

    public int hashCode() {
        int n2 = 31 * (527 + this.getClass().getName().hashCode());
        int n3 = this.a == null ? 0 : this.a.hashCode();
        int n4 = 31 * (31 * (31 * (n3 + n2) + mk.a(this.b)) + mk.a(this.c));
        int n5 = this.d == null ? 0 : this.d.hashCode();
        int n6 = 31 * (n5 + n4);
        int n7 = this.e == null ? 0 : this.e.hashCode();
        int n8 = 31 * (n7 + n6);
        int n9 = this.f == null ? 0 : this.f.hashCode();
        int n10 = 31 * (n9 + n8);
        int n11 = this.g == null ? 0 : this.g.hashCode();
        int n12 = 31 * (n11 + n10);
        int n13 = this.h == null ? 0 : this.h.hashCode();
        int n14 = 31 * (n13 + n12);
        int n15 = this.i == null ? 0 : this.i.hashCode();
        int n16 = 31 * (n15 + n14);
        int n17 = this.j == null ? 0 : this.j.hashCode();
        int n18 = 31 * (n17 + n16);
        int n19 = this.k == null ? 0 : this.k.hashCode();
        int n20 = 31 * (n19 + n18);
        int n21 = this.l == null ? 0 : this.l.hashCode();
        int n22 = 31 * (n21 + n20);
        int n23 = this.m == null ? 0 : this.m.hashCode();
        int n24 = 31 * (n23 + n22);
        int n25 = this.n == null ? 0 : this.n.hashCode();
        int n26 = 31 * (n25 + n24);
        int n27 = this.o == null ? 0 : this.o.hashCode();
        int n28 = 31 * (n27 + n26);
        int n29 = this.p == null ? 0 : this.p.hashCode();
        int n30 = 31 * (n29 + n28);
        int n31 = this.q == null ? 0 : this.q.hashCode();
        int n32 = 31 * (n31 + n30);
        int n33 = this.r == null ? 0 : this.r.hashCode();
        int n34 = 31 * (n33 + n32);
        int n35 = this.s == null ? 0 : this.s.hashCode();
        int n36 = 31 * (n35 + n34);
        int n37 = this.t == null ? 0 : this.t.hashCode();
        int n38 = 31 * (n37 + n36);
        int n39 = this.u == null ? 0 : this.u.hashCode();
        int n40 = 31 * (n39 + n38);
        int n41 = this.v == null ? 0 : this.v.hashCode();
        int n42 = 31 * (n41 + n40);
        int n43 = this.w == null ? 0 : this.w.hashCode();
        int n44 = 31 * (n43 + n42);
        int n45 = this.x == null ? 0 : this.x.hashCode();
        int n46 = 31 * (n45 + n44);
        int n47 = this.y == null ? 0 : this.y.hashCode();
        int n48 = 31 * (n47 + n46);
        Boolean bl2 = this.z;
        int n49 = 0;
        if (bl2 == null) {
            return 31 * (n48 + n49) + mk.a(this.A);
        }
        n49 = this.z.hashCode();
        return 31 * (n48 + n49) + mk.a(this.A);
    }
}

