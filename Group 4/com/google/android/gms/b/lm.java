/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.lr;
import com.google.android.gms.b.mh;
import com.google.android.gms.b.mi;
import com.google.android.gms.b.mk;
import com.google.android.gms.b.mm;
import com.google.android.gms.b.mo;

public final class lm
extends mm {
    private static volatile lm[] e;
    public Integer a;
    public lr b;
    public lr c;
    public Boolean d;

    public lm() {
        this.b();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static lm[] a() {
        if (e != null) return e;
        Object object = mk.a;
        // MONITORENTER : object
        if (e == null) {
            e = new lm[0];
        }
        // MONITOREXIT : object
        return e;
    }

    public lm a(mh mh2) {
        block7 : do {
            int n2 = mh2.a();
            switch (n2) {
                default: {
                    if (mo.a(mh2, n2)) continue block7;
                    return this;
                }
                case 8: {
                    this.a = mh2.f();
                    continue block7;
                }
                case 18: {
                    if (this.b == null) {
                        this.b = new lr();
                    }
                    mh2.a(this.b);
                    continue block7;
                }
                case 26: {
                    if (this.c == null) {
                        this.c = new lr();
                    }
                    mh2.a(this.c);
                    continue block7;
                }
                case 32: {
                    this.d = mh2.g();
                    continue block7;
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
        if (this.c != null) {
            mi2.a(3, this.c);
        }
        if (this.d != null) {
            mi2.a(4, this.d);
        }
        super.a(mi2);
    }

    public lm b() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
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
        if (this.c != null) {
            n2 += mi.b(3, this.c);
        }
        if (this.d == null) return n2;
        n2 += mi.b(4, this.d);
        return n2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof lm)) {
            return false;
        }
        lm lm2 = (lm)object;
        if (this.a == null ? lm2.a != null : !this.a.equals(lm2.a)) {
            return false;
        }
        if (this.b == null ? lm2.b != null : !this.b.equals(lm2.b)) {
            return false;
        }
        if (this.c == null ? lm2.c != null : !this.c.equals(lm2.c)) {
            return false;
        }
        if (this.d == null) {
            if (lm2.d == null) return true;
            return false;
        }
        if (this.d.equals(lm2.d)) return true;
        return false;
    }

    public int hashCode() {
        int n2 = 31 * (527 + this.getClass().getName().hashCode());
        int n3 = this.a == null ? 0 : this.a.hashCode();
        int n4 = 31 * (n3 + n2);
        int n5 = this.b == null ? 0 : this.b.hashCode();
        int n6 = 31 * (n5 + n4);
        int n7 = this.c == null ? 0 : this.c.hashCode();
        int n8 = 31 * (n7 + n6);
        Boolean bl2 = this.d;
        int n9 = 0;
        if (bl2 == null) {
            return n8 + n9;
        }
        n9 = this.d.hashCode();
        return n8 + n9;
    }
}

