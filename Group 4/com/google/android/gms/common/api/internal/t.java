/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.internal.al;
import com.google.android.gms.common.api.internal.o;
import com.google.android.gms.common.api.internal.p;
import com.google.android.gms.common.api.internal.x;
import com.google.android.gms.common.api.internal.z;
import com.google.android.gms.common.internal.ap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

class t
extends x {
    final /* synthetic */ o a;
    private final ArrayList c;

    public t(o o2, ArrayList arrayList) {
        this.a = o2;
        super(o2, null);
        this.c = arrayList;
    }

    @Override
    public void a() {
        o.d((o)this.a).g.d = o.g(this.a);
        Iterator iterator = this.c.iterator();
        while (iterator.hasNext()) {
            ((h)iterator.next()).a(o.h(this.a), o.d((o)this.a).g.d);
        }
    }
}

