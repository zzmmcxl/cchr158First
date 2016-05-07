/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.mh;
import com.google.android.gms.b.mi;
import com.google.android.gms.b.mk;
import com.google.android.gms.b.mm;
import com.google.android.gms.b.mo;

public final class lk
extends mm {
    private static volatile lk[] c;
    public String a;
    public String b;

    public lk() {
        this.b();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static lk[] a() {
        if (c != null) return c;
        Object object = mk.a;
        // MONITORENTER : object
        if (c == null) {
            c = new lk[0];
        }
        // MONITOREXIT : object
        return c;
    }

    public lk a(mh mh2) {
        block5 : do {
            int n2 = mh2.a();
            switch (n2) {
                default: {
                    if (mo.a(mh2, n2)) continue block5;
                    return this;
                }
                case 10: {
                    this.a = mh2.h();
                    continue block5;
                }
                case 18: {
                    this.b = mh2.h();
                    continue block5;
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
        super.a(mi2);
    }

    public lk b() {
        this.a = null;
        this.b = null;
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
        if (this.b == null) return n2;
        n2 += mi.b(2, this.b);
        return n2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof lk)) {
            return false;
        }
        lk lk2 = (lk)object;
        if (this.a == null ? lk2.a != null : !this.a.equals(lk2.a)) {
            return false;
        }
        if (this.b == null) {
            if (lk2.b == null) return true;
            return false;
        }
        if (this.b.equals(lk2.b)) return true;
        return false;
    }

    public int hashCode() {
        int n2 = 31 * (527 + this.getClass().getName().hashCode());
        int n3 = this.a == null ? 0 : this.a.hashCode();
        int n4 = 31 * (n3 + n2);
        String string = this.b;
        int n5 = 0;
        if (string == null) {
            return n4 + n5;
        }
        n5 = this.b.hashCode();
        return n4 + n5;
    }
}

