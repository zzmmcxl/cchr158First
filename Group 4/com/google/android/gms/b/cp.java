/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.ads.internal.g;
import com.google.android.gms.b.cn;
import com.google.android.gms.b.cq;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.hb;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@fi
public class cp
implements Iterable {
    private final List a = new LinkedList();

    private cn c(hb hb2) {
        cn cn2;
        Iterator iterator = g.k().iterator();
        do {
            if (!iterator.hasNext()) return null;
            cn2 = (cn)iterator.next();
        } while (cn2.a != hb2);
        return cn2;
    }

    public void a(cn cn2) {
        this.a.add(cn2);
    }

    public boolean a(hb hb2) {
        cn cn2 = this.c(hb2);
        if (cn2 == null) return false;
        cn2.b.b();
        return true;
    }

    public void b(cn cn2) {
        this.a.remove(cn2);
    }

    public boolean b(hb hb2) {
        if (this.c(hb2) == null) return false;
        return true;
    }

    public Iterator iterator() {
        return this.a.iterator();
    }
}

