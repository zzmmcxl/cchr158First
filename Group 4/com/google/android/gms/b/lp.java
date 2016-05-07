/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.lq;
import com.google.android.gms.b.mh;
import com.google.android.gms.b.mi;
import com.google.android.gms.b.mk;
import com.google.android.gms.b.mm;
import com.google.android.gms.b.mo;

public final class lp
extends mm {
    public lq[] a;

    public lp() {
        this.a();
    }

    public lp a() {
        this.a = lq.a();
        this.B = -1;
        return this;
    }

    public lp a(mh mh2) {
        block4 : do {
            int n2 = mh2.a();
            switch (n2) {
                default: {
                    if (mo.a(mh2, n2)) continue block4;
                    return this;
                }
                case 10: {
                    int n3 = mo.b(mh2, 10);
                    int n4 = this.a == null ? 0 : this.a.length;
                    lq[] arrlq = new lq[n3 + n4];
                    if (n4 != 0) {
                        System.arraycopy(this.a, 0, arrlq, 0, n4);
                    }
                    while (n4 < -1 + arrlq.length) {
                        arrlq[n4] = new lq();
                        mh2.a(arrlq[n4]);
                        mh2.a();
                        ++n4;
                    }
                    arrlq[n4] = new lq();
                    mh2.a(arrlq[n4]);
                    this.a = arrlq;
                    continue block4;
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
                lq lq2 = this.a[i2];
                if (lq2 == null) continue;
                mi2.a(1, lq2);
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
        if (this.a == null) return n2;
        if (this.a.length <= 0) return n2;
        int n3 = 0;
        while (n3 < this.a.length) {
            lq lq2 = this.a[n3];
            if (lq2 != null) {
                n2 += mi.b(1, lq2);
            }
            ++n3;
        }
        return n2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof lp)) {
            return false;
        }
        lp lp2 = (lp)object;
        if (mk.a(this.a, lp2.a)) return true;
        return false;
    }

    public int hashCode() {
        return 31 * (527 + this.getClass().getName().hashCode()) + mk.a(this.a);
    }
}

