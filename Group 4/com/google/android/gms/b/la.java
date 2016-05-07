/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.lb;
import com.google.android.gms.b.le;
import com.google.android.gms.b.mh;
import com.google.android.gms.b.mi;
import com.google.android.gms.b.mk;
import com.google.android.gms.b.mm;
import com.google.android.gms.b.mo;

public final class la
extends mm {
    private static volatile la[] d;
    public Integer a;
    public le[] b;
    public lb[] c;

    public la() {
        this.b();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static la[] a() {
        if (d != null) return d;
        Object object = mk.a;
        // MONITORENTER : object
        if (d == null) {
            d = new la[0];
        }
        // MONITOREXIT : object
        return d;
    }

    public la a(mh mh2) {
        block6 : do {
            int n2 = mh2.a();
            switch (n2) {
                default: {
                    if (mo.a(mh2, n2)) continue block6;
                    return this;
                }
                case 8: {
                    this.a = mh2.f();
                    continue block6;
                }
                case 18: {
                    int n3 = mo.b(mh2, 18);
                    int n4 = this.b == null ? 0 : this.b.length;
                    le[] arrle = new le[n3 + n4];
                    if (n4 != 0) {
                        System.arraycopy(this.b, 0, arrle, 0, n4);
                    }
                    while (n4 < -1 + arrle.length) {
                        arrle[n4] = new le();
                        mh2.a(arrle[n4]);
                        mh2.a();
                        ++n4;
                    }
                    arrle[n4] = new le();
                    mh2.a(arrle[n4]);
                    this.b = arrle;
                    continue block6;
                }
                case 26: {
                    int n5 = mo.b(mh2, 26);
                    int n6 = this.c == null ? 0 : this.c.length;
                    lb[] arrlb = new lb[n5 + n6];
                    if (n6 != 0) {
                        System.arraycopy(this.c, 0, arrlb, 0, n6);
                    }
                    while (n6 < -1 + arrlb.length) {
                        arrlb[n6] = new lb();
                        mh2.a(arrlb[n6]);
                        mh2.a();
                        ++n6;
                    }
                    arrlb[n6] = new lb();
                    mh2.a(arrlb[n6]);
                    this.c = arrlb;
                    continue block6;
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
                le le2 = this.b[i2];
                if (le2 == null) continue;
                mi2.a(2, le2);
            }
        }
        if (this.c != null) {
            int n2 = this.c.length;
            if (n2 > 0) {
                for (int i3 = 0; i3 < this.c.length; ++i3) {
                    lb lb2 = this.c[i3];
                    if (lb2 == null) continue;
                    mi2.a(3, lb2);
                }
            }
        }
        super.a(mi2);
    }

    public la b() {
        this.a = null;
        this.b = le.a();
        this.c = lb.a();
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
                le le2 = this.b[i2];
                if (le2 == null) continue;
                n3 += mi.b(2, le2);
            }
            n2 = n3;
        }
        if (this.c == null) return n2;
        int n4 = this.c.length;
        int n5 = 0;
        if (n4 <= 0) return n2;
        while (n5 < this.c.length) {
            lb lb2 = this.c[n5];
            if (lb2 != null) {
                n2 += mi.b(3, lb2);
            }
            ++n5;
        }
        return n2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof la)) {
            return false;
        }
        la la2 = (la)object;
        if (this.a == null ? la2.a != null : !this.a.equals(la2.a)) {
            return false;
        }
        if (!mk.a(this.b, la2.b)) {
            return false;
        }
        if (mk.a(this.c, la2.c)) return true;
        return false;
    }

    public int hashCode() {
        int n2;
        int n3 = 31 * (527 + this.getClass().getName().hashCode());
        if (this.a == null) {
            n2 = 0;
            return 31 * (31 * (n2 + n3) + mk.a(this.b)) + mk.a(this.c);
        }
        n2 = this.a.hashCode();
        return 31 * (31 * (n2 + n3) + mk.a(this.b)) + mk.a(this.c);
    }
}

