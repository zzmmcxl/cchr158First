/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.mh;
import com.google.android.gms.b.mi;
import com.google.android.gms.b.mn;

public abstract class mm {
    protected volatile int B = -1;

    public void a(mi mi2) {
    }

    public abstract mm b(mh var1);

    protected int c() {
        return 0;
    }

    public /* synthetic */ Object clone() {
        return this.f();
    }

    public int d() {
        if (this.B >= 0) return this.B;
        this.e();
        return this.B;
    }

    public int e() {
        int n2;
        this.B = n2 = this.c();
        return n2;
    }

    public mm f() {
        return (mm)super.clone();
    }

    public String toString() {
        return mn.a(this);
    }
}

