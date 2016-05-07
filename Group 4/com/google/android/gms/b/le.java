/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.lc;
import com.google.android.gms.b.mh;
import com.google.android.gms.b.mi;
import com.google.android.gms.b.mk;
import com.google.android.gms.b.mm;
import com.google.android.gms.b.mo;

public final class le
extends mm {
    private static volatile le[] d;
    public Integer a;
    public String b;
    public lc c;

    public le() {
        this.b();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static le[] a() {
        if (d != null) return d;
        Object object = mk.a;
        // MONITORENTER : object
        if (d == null) {
            d = new le[0];
        }
        // MONITOREXIT : object
        return d;
    }

    public le a(mh mh2) {
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
                    this.b = mh2.h();
                    continue block6;
                }
                case 26: {
                    if (this.c == null) {
                        this.c = new lc();
                    }
                    mh2.a(this.c);
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
        if (this.b != null) {
            mi2.a(2, this.b);
        }
        if (this.c != null) {
            mi2.a(3, this.c);
        }
        super.a(mi2);
    }

    public le b() {
        this.a = null;
        this.b = null;
        this.c = null;
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
        if (this.c == null) return n2;
        n2 += mi.b(3, this.c);
        return n2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof le)) {
            return false;
        }
        le le2 = (le)object;
        if (this.a == null ? le2.a != null : !this.a.equals(le2.a)) {
            return false;
        }
        if (this.b == null ? le2.b != null : !this.b.equals(le2.b)) {
            return false;
        }
        if (this.c == null) {
            if (le2.c == null) return true;
            return false;
        }
        if (this.c.equals(le2.c)) return true;
        return false;
    }

    public int hashCode() {
        int n2 = 31 * (527 + this.getClass().getName().hashCode());
        int n3 = this.a == null ? 0 : this.a.hashCode();
        int n4 = 31 * (n3 + n2);
        int n5 = this.b == null ? 0 : this.b.hashCode();
        int n6 = 31 * (n5 + n4);
        lc lc2 = this.c;
        int n7 = 0;
        if (lc2 == null) {
            return n6 + n7;
        }
        n7 = this.c.hashCode();
        return n6 + n7;
    }
}

