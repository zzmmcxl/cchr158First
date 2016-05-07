/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.mh;
import com.google.android.gms.b.mi;
import com.google.android.gms.b.mk;
import com.google.android.gms.b.mm;
import com.google.android.gms.b.mo;

public final class ls
extends mm {
    private static volatile ls[] f;
    public Long a;
    public String b;
    public String c;
    public Long d;
    public Float e;

    public ls() {
        this.b();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static ls[] a() {
        if (f != null) return f;
        Object object = mk.a;
        // MONITORENTER : object
        if (f == null) {
            f = new ls[0];
        }
        // MONITOREXIT : object
        return f;
    }

    public ls a(mh mh2) {
        block8 : do {
            int n2 = mh2.a();
            switch (n2) {
                default: {
                    if (mo.a(mh2, n2)) continue block8;
                    return this;
                }
                case 8: {
                    this.a = mh2.e();
                    continue block8;
                }
                case 18: {
                    this.b = mh2.h();
                    continue block8;
                }
                case 26: {
                    this.c = mh2.h();
                    continue block8;
                }
                case 32: {
                    this.d = mh2.e();
                    continue block8;
                }
                case 45: {
                    this.e = Float.valueOf(mh2.c());
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
            mi2.b(1, this.a);
        }
        if (this.b != null) {
            mi2.a(2, this.b);
        }
        if (this.c != null) {
            mi2.a(3, this.c);
        }
        if (this.d != null) {
            mi2.b(4, this.d);
        }
        if (this.e != null) {
            mi2.a(5, this.e.floatValue());
        }
        super.a(mi2);
    }

    public ls b() {
        this.a = null;
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
        if (this.a != null) {
            n2 += mi.c(1, this.a);
        }
        if (this.b != null) {
            n2 += mi.b(2, this.b);
        }
        if (this.c != null) {
            n2 += mi.b(3, this.c);
        }
        if (this.d != null) {
            n2 += mi.c(4, this.d);
        }
        if (this.e == null) return n2;
        n2 += mi.b(5, this.e.floatValue());
        return n2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ls)) {
            return false;
        }
        ls ls2 = (ls)object;
        if (this.a == null ? ls2.a != null : !this.a.equals(ls2.a)) {
            return false;
        }
        if (this.b == null ? ls2.b != null : !this.b.equals(ls2.b)) {
            return false;
        }
        if (this.c == null ? ls2.c != null : !this.c.equals(ls2.c)) {
            return false;
        }
        if (this.d == null ? ls2.d != null : !this.d.equals(ls2.d)) {
            return false;
        }
        if (this.e == null) {
            if (ls2.e == null) return true;
            return false;
        }
        if (this.e.equals(ls2.e)) return true;
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
        int n9 = this.d == null ? 0 : this.d.hashCode();
        int n10 = 31 * (n9 + n8);
        Float f2 = this.e;
        int n11 = 0;
        if (f2 == null) {
            return n10 + n11;
        }
        n11 = this.e.hashCode();
        return n10 + n11;
    }
}

