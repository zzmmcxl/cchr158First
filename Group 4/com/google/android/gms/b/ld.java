/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.mh;
import com.google.android.gms.b.mi;
import com.google.android.gms.b.mm;
import com.google.android.gms.b.mo;

public final class ld
extends mm {
    public Integer a;
    public Boolean b;
    public String c;
    public String d;
    public String e;

    public ld() {
        this.a();
    }

    public ld a() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.B = -1;
        return this;
    }

    public ld a(mh mh2) {
        block11 : do {
            int n2 = mh2.a();
            switch (n2) {
                default: {
                    if (mo.a(mh2, n2)) continue block11;
                    return this;
                }
                case 8: {
                    int n3 = mh2.f();
                    switch (n3) {
                        default: {
                            continue block11;
                        }
                        case 0: 
                        case 1: 
                        case 2: 
                        case 3: 
                        case 4: 
                    }
                    this.a = n3;
                    continue block11;
                }
                case 16: {
                    this.b = mh2.g();
                    continue block11;
                }
                case 26: {
                    this.c = mh2.h();
                    continue block11;
                }
                case 34: {
                    this.d = mh2.h();
                    continue block11;
                }
                case 42: {
                    this.e = mh2.h();
                    continue block11;
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
        if (this.e != null) {
            mi2.a(5, this.e);
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
            n2 += mi.b(1, this.a);
        }
        if (this.b != null) {
            n2 += mi.b(2, this.b);
        }
        if (this.c != null) {
            n2 += mi.b(3, this.c);
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
        if (!(object instanceof ld)) {
            return false;
        }
        ld ld2 = (ld)object;
        if (this.a == null ? ld2.a != null : !this.a.equals(ld2.a)) {
            return false;
        }
        if (this.b == null ? ld2.b != null : !this.b.equals(ld2.b)) {
            return false;
        }
        if (this.c == null ? ld2.c != null : !this.c.equals(ld2.c)) {
            return false;
        }
        if (this.d == null ? ld2.d != null : !this.d.equals(ld2.d)) {
            return false;
        }
        if (this.e == null) {
            if (ld2.e == null) return true;
            return false;
        }
        if (this.e.equals(ld2.e)) return true;
        return false;
    }

    public int hashCode() {
        int n2 = 31 * (527 + this.getClass().getName().hashCode());
        int n3 = this.a == null ? 0 : this.a;
        int n4 = 31 * (n3 + n2);
        int n5 = this.b == null ? 0 : this.b.hashCode();
        int n6 = 31 * (n5 + n4);
        int n7 = this.c == null ? 0 : this.c.hashCode();
        int n8 = 31 * (n7 + n6);
        int n9 = this.d == null ? 0 : this.d.hashCode();
        int n10 = 31 * (n9 + n8);
        String string = this.e;
        int n11 = 0;
        if (string == null) {
            return n10 + n11;
        }
        n11 = this.e.hashCode();
        return n10 + n11;
    }
}

