/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.ld;
import com.google.android.gms.b.lf;
import com.google.android.gms.b.mh;
import com.google.android.gms.b.mi;
import com.google.android.gms.b.mk;
import com.google.android.gms.b.mm;
import com.google.android.gms.b.mo;

public final class lc
extends mm {
    private static volatile lc[] e;
    public lf a;
    public ld b;
    public Boolean c;
    public String d;

    public lc() {
        this.b();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static lc[] a() {
        if (e != null) return e;
        Object object = mk.a;
        // MONITORENTER : object
        if (e == null) {
            e = new lc[0];
        }
        // MONITOREXIT : object
        return e;
    }

    public lc a(mh mh2) {
        block7 : do {
            int n2 = mh2.a();
            switch (n2) {
                default: {
                    if (mo.a(mh2, n2)) continue block7;
                    return this;
                }
                case 10: {
                    if (this.a == null) {
                        this.a = new lf();
                    }
                    mh2.a(this.a);
                    continue block7;
                }
                case 18: {
                    if (this.b == null) {
                        this.b = new ld();
                    }
                    mh2.a(this.b);
                    continue block7;
                }
                case 24: {
                    this.c = mh2.g();
                    continue block7;
                }
                case 34: {
                    this.d = mh2.h();
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

    public lc b() {
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
        if (!(object instanceof lc)) {
            return false;
        }
        lc lc2 = (lc)object;
        if (this.a == null ? lc2.a != null : !this.a.equals(lc2.a)) {
            return false;
        }
        if (this.b == null ? lc2.b != null : !this.b.equals(lc2.b)) {
            return false;
        }
        if (this.c == null ? lc2.c != null : !this.c.equals(lc2.c)) {
            return false;
        }
        if (this.d == null) {
            if (lc2.d == null) return true;
            return false;
        }
        if (this.d.equals(lc2.d)) return true;
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
        String string = this.d;
        int n9 = 0;
        if (string == null) {
            return n8 + n9;
        }
        n9 = this.d.hashCode();
        return n8 + n9;
    }
}

