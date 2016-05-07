/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.ac;
import com.google.android.gms.b.v;
import java.util.Comparator;

class x
implements Comparator {
    final /* synthetic */ v a;

    x(v v2) {
        this.a = v2;
    }

    public int a(ac ac2, ac ac3) {
        int n2 = ac2.c - ac3.c;
        if (n2 == 0) return (int)(ac2.a - ac3.a);
        return n2;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((ac)object, (ac)object2);
    }
}

