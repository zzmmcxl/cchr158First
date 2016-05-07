/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.EventParams;
import java.util.Iterator;
import java.util.Set;

class a
implements Iterator {
    Iterator a;
    final /* synthetic */ EventParams b;

    a(EventParams eventParams) {
        this.b = eventParams;
        this.a = EventParams.a(this.b).keySet().iterator();
    }

    public String a() {
        return (String)this.a.next();
    }

    @Override
    public boolean hasNext() {
        return this.a.hasNext();
    }

    public /* synthetic */ Object next() {
        return this.a();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}

