/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.mh;
import com.google.android.gms.b.mi;
import com.google.android.gms.b.mk;
import com.google.android.gms.b.mm;
import com.google.android.gms.b.mo;

public final class lr
extends mm {
    public long[] a;
    public long[] b;

    public lr() {
        this.a();
    }

    public lr a() {
        this.a = mo.b;
        this.b = mo.b;
        this.B = -1;
        return this;
    }

    public lr a(mh mh2) {
        block7 : do {
            int n2 = mh2.a();
            switch (n2) {
                default: {
                    if (mo.a(mh2, n2)) continue block7;
                    return this;
                }
                case 8: {
                    int n3 = mo.b(mh2, 8);
                    int n4 = this.a == null ? 0 : this.a.length;
                    long[] arrl = new long[n3 + n4];
                    if (n4 != 0) {
                        System.arraycopy(this.a, 0, arrl, 0, n4);
                    }
                    while (n4 < -1 + arrl.length) {
                        arrl[n4] = mh2.d();
                        mh2.a();
                        ++n4;
                    }
                    arrl[n4] = mh2.d();
                    this.a = arrl;
                    continue block7;
                }
                case 10: {
                    int n5 = mh2.c(mh2.i());
                    int n6 = mh2.o();
                    int n7 = 0;
                    while (mh2.m() > 0) {
                        mh2.d();
                        ++n7;
                    }
                    mh2.e(n6);
                    int n8 = this.a == null ? 0 : this.a.length;
                    long[] arrl = new long[n7 + n8];
                    if (n8 != 0) {
                        System.arraycopy(this.a, 0, arrl, 0, n8);
                    }
                    while (n8 < arrl.length) {
                        arrl[n8] = mh2.d();
                        ++n8;
                    }
                    this.a = arrl;
                    mh2.d(n5);
                    continue block7;
                }
                case 16: {
                    int n9 = mo.b(mh2, 16);
                    int n10 = this.b == null ? 0 : this.b.length;
                    long[] arrl = new long[n9 + n10];
                    if (n10 != 0) {
                        System.arraycopy(this.b, 0, arrl, 0, n10);
                    }
                    while (n10 < -1 + arrl.length) {
                        arrl[n10] = mh2.d();
                        mh2.a();
                        ++n10;
                    }
                    arrl[n10] = mh2.d();
                    this.b = arrl;
                    continue block7;
                }
                case 18: {
                    int n11 = mh2.c(mh2.i());
                    int n12 = mh2.o();
                    int n13 = 0;
                    while (mh2.m() > 0) {
                        mh2.d();
                        ++n13;
                    }
                    mh2.e(n12);
                    int n14 = this.b == null ? 0 : this.b.length;
                    long[] arrl = new long[n13 + n14];
                    if (n14 != 0) {
                        System.arraycopy(this.b, 0, arrl, 0, n14);
                    }
                    while (n14 < arrl.length) {
                        arrl[n14] = mh2.d();
                        ++n14;
                    }
                    this.b = arrl;
                    mh2.d(n11);
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
        if (this.a != null && this.a.length > 0) {
            for (int i2 = 0; i2 < this.a.length; ++i2) {
                mi2.a(1, this.a[i2]);
            }
        }
        if (this.b != null) {
            int n2 = this.b.length;
            if (n2 > 0) {
                for (int i3 = 0; i3 < this.b.length; ++i3) {
                    mi2.a(2, this.b[i3]);
                }
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
        int n2;
        int n3 = 0;
        int n4 = super.c();
        if (this.a != null && this.a.length > 0) {
            int n5 = 0;
            for (int i2 = 0; i2 < this.a.length; n5 += mi.c((long)this.a[i2]), ++i2) {
            }
            n2 = n4 + n5 + 1 * this.a.length;
        } else {
            n2 = n4;
        }
        if (this.b == null) return n2;
        if (this.b.length <= 0) return n2;
        int n6 = 0;
        while (n3 < this.b.length) {
            n6 += mi.c(this.b[n3]);
            ++n3;
        }
        return n2 + n6 + 1 * this.b.length;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof lr)) {
            return false;
        }
        lr lr2 = (lr)object;
        if (!mk.a(this.a, lr2.a)) {
            return false;
        }
        if (mk.a(this.b, lr2.b)) return true;
        return false;
    }

    public int hashCode() {
        return 31 * (31 * (527 + this.getClass().getName().hashCode()) + mk.a(this.a)) + mk.a(this.b);
    }
}

