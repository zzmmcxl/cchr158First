/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.lo;
import com.google.android.gms.b.mh;
import com.google.android.gms.b.mi;
import com.google.android.gms.b.mk;
import com.google.android.gms.b.mm;
import com.google.android.gms.b.mo;

public final class ln
extends mm {
    private static volatile ln[] f;
    public lo[] a;
    public String b;
    public Long c;
    public Long d;
    public Integer e;

    public ln() {
        this.b();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static ln[] a() {
        if (f != null) return f;
        Object object = mk.a;
        // MONITORENTER : object
        if (f == null) {
            f = new ln[0];
        }
        // MONITOREXIT : object
        return f;
    }

    public ln a(mh mh2) {
        block8 : do {
            int n2 = mh2.a();
            switch (n2) {
                default: {
                    if (mo.a(mh2, n2)) continue block8;
                    return this;
                }
                case 10: {
                    int n3 = mo.b(mh2, 10);
                    int n4 = this.a == null ? 0 : this.a.length;
                    lo[] arrlo = new lo[n3 + n4];
                    if (n4 != 0) {
                        System.arraycopy(this.a, 0, arrlo, 0, n4);
                    }
                    while (n4 < -1 + arrlo.length) {
                        arrlo[n4] = new lo();
                        mh2.a(arrlo[n4]);
                        mh2.a();
                        ++n4;
                    }
                    arrlo[n4] = new lo();
                    mh2.a(arrlo[n4]);
                    this.a = arrlo;
                    continue block8;
                }
                case 18: {
                    this.b = mh2.h();
                    continue block8;
                }
                case 24: {
                    this.c = mh2.e();
                    continue block8;
                }
                case 32: {
                    this.d = mh2.e();
                    continue block8;
                }
                case 40: {
                    this.e = mh2.f();
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
        if (this.a != null && this.a.length > 0) {
            for (int i2 = 0; i2 < this.a.length; ++i2) {
                lo lo2 = this.a[i2];
                if (lo2 == null) continue;
                mi2.a(1, lo2);
            }
        }
        if (this.b != null) {
            mi2.a(2, this.b);
        }
        if (this.c != null) {
            mi2.b(3, this.c);
        }
        if (this.d != null) {
            mi2.b(4, this.d);
        }
        if (this.e != null) {
            mi2.a(5, this.e);
        }
        super.a(mi2);
    }

    public ln b() {
        this.a = lo.a();
        this.b = null;
        this.c = null;
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
        if (this.a != null && this.a.length > 0) {
            for (int i2 = 0; i2 < this.a.length; ++i2) {
                lo lo2 = this.a[i2];
                if (lo2 == null) continue;
                n2 += mi.b(1, lo2);
            }
        }
        if (this.b != null) {
            n2 += mi.b(2, this.b);
        }
        if (this.c != null) {
            n2 += mi.c(3, this.c);
        }
        if (this.d != null) {
            n2 += mi.c(4, this.d);
        }
        if (this.e == null) return n2;
        n2 += mi.b(5, this.e);
        return n2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ln)) {
            return false;
        }
        ln ln2 = (ln)object;
        if (!mk.a(this.a, ln2.a)) {
            return false;
        }
        if (this.b == null ? ln2.b != null : !this.b.equals(ln2.b)) {
            return false;
        }
        if (this.c == null ? ln2.c != null : !this.c.equals(ln2.c)) {
            return false;
        }
        if (this.d == null ? ln2.d != null : !this.d.equals(ln2.d)) {
            return false;
        }
        if (this.e == null) {
            if (ln2.e == null) return true;
            return false;
        }
        if (this.e.equals(ln2.e)) return true;
        return false;
    }

    public int hashCode() {
        int n2 = 31 * (31 * (527 + this.getClass().getName().hashCode()) + mk.a(this.a));
        int n3 = this.b == null ? 0 : this.b.hashCode();
        int n4 = 31 * (n3 + n2);
        int n5 = this.c == null ? 0 : this.c.hashCode();
        int n6 = 31 * (n5 + n4);
        int n7 = this.d == null ? 0 : this.d.hashCode();
        int n8 = 31 * (n7 + n6);
        Integer n9 = this.e;
        int n10 = 0;
        if (n9 == null) {
            return n8 + n10;
        }
        n10 = this.e.hashCode();
        return n8 + n10;
    }
}

