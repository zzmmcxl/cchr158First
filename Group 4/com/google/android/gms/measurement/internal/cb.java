/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.b.ln;
import com.google.android.gms.b.lq;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.measurement.internal.aj;
import com.google.android.gms.measurement.internal.am;
import com.google.android.gms.measurement.internal.bx;
import com.google.android.gms.measurement.internal.by;
import java.util.ArrayList;
import java.util.List;

class cb
implements am {
    lq a;
    List b;
    List c;
    long d;
    final /* synthetic */ bx e;

    private cb(bx bx2) {
        this.e = bx2;
    }

    /* synthetic */ cb(bx bx2, by by2) {
        this(bx2);
    }

    private long a(ln ln2) {
        return ln2.c / 1000 / 60 / 60;
    }

    @Override
    public void a(lq lq2) {
        bf.a(lq2);
        this.a = lq2;
    }

    boolean a() {
        if (this.c == null) return true;
        if (!this.c.isEmpty()) return false;
        return true;
    }

    @Override
    public boolean a(long l2, ln ln2) {
        bf.a(ln2);
        if (this.c == null) {
            this.c = new ArrayList();
        }
        if (this.b == null) {
            this.b = new ArrayList();
        }
        if (this.c.size() > 0 && this.a((ln)this.c.get(0)) != this.a(ln2)) {
            return false;
        }
        long l3 = this.d + (long)ln2.e();
        if (l3 >= (long)this.e.d().T()) {
            return false;
        }
        this.d = l3;
        this.c.add(ln2);
        this.b.add(l2);
        if (this.c.size() < this.e.d().U()) return true;
        return false;
    }
}

