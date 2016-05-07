/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.la;
import com.google.android.gms.b.li;
import com.google.android.gms.b.lk;
import com.google.android.gms.b.mh;
import com.google.android.gms.b.mi;
import com.google.android.gms.b.mk;
import com.google.android.gms.b.mm;
import com.google.android.gms.b.mo;

public final class lj
extends mm {
    public Long a;
    public String b;
    public Integer c;
    public lk[] d;
    public li[] e;
    public la[] f;

    public lj() {
        this.a();
    }

    public lj a() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = lk.a();
        this.e = li.a();
        this.f = la.a();
        this.B = -1;
        return this;
    }

    public lj a(mh mh2) {
        block9 : do {
            int n2 = mh2.a();
            switch (n2) {
                default: {
                    if (mo.a(mh2, n2)) continue block9;
                    return this;
                }
                case 8: {
                    this.a = mh2.e();
                    continue block9;
                }
                case 18: {
                    this.b = mh2.h();
                    continue block9;
                }
                case 24: {
                    this.c = mh2.f();
                    continue block9;
                }
                case 34: {
                    int n3 = mo.b(mh2, 34);
                    int n4 = this.d == null ? 0 : this.d.length;
                    lk[] arrlk = new lk[n3 + n4];
                    if (n4 != 0) {
                        System.arraycopy(this.d, 0, arrlk, 0, n4);
                    }
                    while (n4 < -1 + arrlk.length) {
                        arrlk[n4] = new lk();
                        mh2.a(arrlk[n4]);
                        mh2.a();
                        ++n4;
                    }
                    arrlk[n4] = new lk();
                    mh2.a(arrlk[n4]);
                    this.d = arrlk;
                    continue block9;
                }
                case 42: {
                    int n5 = mo.b(mh2, 42);
                    int n6 = this.e == null ? 0 : this.e.length;
                    li[] arrli = new li[n5 + n6];
                    if (n6 != 0) {
                        System.arraycopy(this.e, 0, arrli, 0, n6);
                    }
                    while (n6 < -1 + arrli.length) {
                        arrli[n6] = new li();
                        mh2.a(arrli[n6]);
                        mh2.a();
                        ++n6;
                    }
                    arrli[n6] = new li();
                    mh2.a(arrli[n6]);
                    this.e = arrli;
                    continue block9;
                }
                case 50: {
                    int n7 = mo.b(mh2, 50);
                    int n8 = this.f == null ? 0 : this.f.length;
                    la[] arrla = new la[n7 + n8];
                    if (n8 != 0) {
                        System.arraycopy(this.f, 0, arrla, 0, n8);
                    }
                    while (n8 < -1 + arrla.length) {
                        arrla[n8] = new la();
                        mh2.a(arrla[n8]);
                        mh2.a();
                        ++n8;
                    }
                    arrla[n8] = new la();
                    mh2.a(arrla[n8]);
                    this.f = arrla;
                    continue block9;
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
            mi2.b(1, this.a);
        }
        if (this.b != null) {
            mi2.a(2, this.b);
        }
        if (this.c != null) {
            mi2.a(3, this.c);
        }
        if (this.d != null && this.d.length > 0) {
            for (int i2 = 0; i2 < this.d.length; ++i2) {
                lk lk2 = this.d[i2];
                if (lk2 == null) continue;
                mi2.a(4, lk2);
            }
        }
        if (this.e != null && this.e.length > 0) {
            for (int i3 = 0; i3 < this.e.length; ++i3) {
                li li2 = this.e[i3];
                if (li2 == null) continue;
                mi2.a(5, li2);
            }
        }
        if (this.f != null) {
            int n2 = this.f.length;
            if (n2 > 0) {
                for (int i4 = 0; i4 < this.f.length; ++i4) {
                    la la2 = this.f[i4];
                    if (la2 == null) continue;
                    mi2.a(6, la2);
                }
            }
        }
        super.a(mi2);
    }

    @Override
    public /* synthetic */ mm b(mh mh2) {
        return this.a(mh2);
    }

    @Override
    protected int c() {
        int n2 = super.c();
        if (this.a != null) {
            n2 += mi.c(1, this.a);
        }
        if (this.b != null) {
            n2 += mi.b(2, this.b);
        }
        if (this.c != null) {
            n2 += mi.b(3, this.c);
        }
        if (this.d != null && this.d.length > 0) {
            int n3 = n2;
            for (int i2 = 0; i2 < this.d.length; ++i2) {
                lk lk2 = this.d[i2];
                if (lk2 == null) continue;
                n3 += mi.b(4, lk2);
            }
            n2 = n3;
        }
        if (this.e != null && this.e.length > 0) {
            int n4 = n2;
            for (int i3 = 0; i3 < this.e.length; ++i3) {
                li li2 = this.e[i3];
                if (li2 == null) continue;
                n4 += mi.b(5, li2);
            }
            n2 = n4;
        }
        if (this.f == null) return n2;
        int n5 = this.f.length;
        int n6 = 0;
        if (n5 <= 0) return n2;
        while (n6 < this.f.length) {
            la la2 = this.f[n6];
            if (la2 != null) {
                n2 += mi.b(6, la2);
            }
            ++n6;
        }
        return n2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof lj)) {
            return false;
        }
        lj lj2 = (lj)object;
        if (this.a == null ? lj2.a != null : !this.a.equals(lj2.a)) {
            return false;
        }
        if (this.b == null ? lj2.b != null : !this.b.equals(lj2.b)) {
            return false;
        }
        if (this.c == null ? lj2.c != null : !this.c.equals(lj2.c)) {
            return false;
        }
        if (!mk.a(this.d, lj2.d)) {
            return false;
        }
        if (!mk.a(this.e, lj2.e)) {
            return false;
        }
        if (mk.a(this.f, lj2.f)) return true;
        return false;
    }

    public int hashCode() {
        int n2 = 31 * (527 + this.getClass().getName().hashCode());
        int n3 = this.a == null ? 0 : this.a.hashCode();
        int n4 = 31 * (n3 + n2);
        int n5 = this.b == null ? 0 : this.b.hashCode();
        int n6 = 31 * (n5 + n4);
        Integer n7 = this.c;
        int n8 = 0;
        if (n7 == null) {
            return 31 * (31 * (31 * (n6 + n8) + mk.a(this.d)) + mk.a(this.e)) + mk.a(this.f);
        }
        n8 = this.c.hashCode();
        return 31 * (31 * (31 * (n6 + n8) + mk.a(this.d)) + mk.a(this.e)) + mk.a(this.f);
    }
}

