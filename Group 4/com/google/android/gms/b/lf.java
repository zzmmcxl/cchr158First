/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.mh;
import com.google.android.gms.b.mi;
import com.google.android.gms.b.mk;
import com.google.android.gms.b.mm;
import com.google.android.gms.b.mo;

public final class lf
extends mm {
    public Integer a;
    public String b;
    public Boolean c;
    public String[] d;

    public lf() {
        this.a();
    }

    public lf a() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = mo.f;
        this.B = -1;
        return this;
    }

    public lf a(mh mh2) {
        block10 : do {
            int n2 = mh2.a();
            switch (n2) {
                default: {
                    if (mo.a(mh2, n2)) continue block10;
                    return this;
                }
                case 8: {
                    int n3 = mh2.f();
                    switch (n3) {
                        default: {
                            continue block10;
                        }
                        case 0: 
                        case 1: 
                        case 2: 
                        case 3: 
                        case 4: 
                        case 5: 
                        case 6: 
                    }
                    this.a = n3;
                    continue block10;
                }
                case 18: {
                    this.b = mh2.h();
                    continue block10;
                }
                case 24: {
                    this.c = mh2.g();
                    continue block10;
                }
                case 34: {
                    int n4 = mo.b(mh2, 34);
                    int n5 = this.d == null ? 0 : this.d.length;
                    String[] arrstring = new String[n4 + n5];
                    if (n5 != 0) {
                        System.arraycopy(this.d, 0, arrstring, 0, n5);
                    }
                    while (n5 < -1 + arrstring.length) {
                        arrstring[n5] = mh2.h();
                        mh2.a();
                        ++n5;
                    }
                    arrstring[n5] = mh2.h();
                    this.d = arrstring;
                    continue block10;
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
        if (this.d != null && this.d.length > 0) {
            for (int i2 = 0; i2 < this.d.length; ++i2) {
                String string = this.d[i2];
                if (string == null) continue;
                mi2.a(4, string);
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
        int n2 = 0;
        int n3 = super.c();
        if (this.a != null) {
            n3 += mi.b(1, this.a);
        }
        if (this.b != null) {
            n3 += mi.b(2, this.b);
        }
        if (this.c != null) {
            n3 += mi.b(3, this.c);
        }
        if (this.d == null) return n3;
        if (this.d.length <= 0) return n3;
        int n4 = 0;
        int n5 = 0;
        while (n2 < this.d.length) {
            String string = this.d[n2];
            if (string != null) {
                ++n5;
                n4 += mi.b(string);
            }
            ++n2;
        }
        return n3 + n4 + n5 * 1;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof lf)) {
            return false;
        }
        lf lf2 = (lf)object;
        if (this.a == null ? lf2.a != null : !this.a.equals(lf2.a)) {
            return false;
        }
        if (this.b == null ? lf2.b != null : !this.b.equals(lf2.b)) {
            return false;
        }
        if (this.c == null ? lf2.c != null : !this.c.equals(lf2.c)) {
            return false;
        }
        if (mk.a(this.d, lf2.d)) return true;
        return false;
    }

    public int hashCode() {
        int n2 = 31 * (527 + this.getClass().getName().hashCode());
        int n3 = this.a == null ? 0 : this.a;
        int n4 = 31 * (n3 + n2);
        int n5 = this.b == null ? 0 : this.b.hashCode();
        int n6 = 31 * (n5 + n4);
        Boolean bl2 = this.c;
        int n7 = 0;
        if (bl2 == null) {
            return 31 * (n6 + n7) + mk.a(this.d);
        }
        n7 = this.c.hashCode();
        return 31 * (n6 + n7) + mk.a(this.d);
    }
}

