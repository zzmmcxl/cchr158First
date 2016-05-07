/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.m;
import java.util.Iterator;
import java.util.List;

@fi
public class n {
    private final Object a;
    private int b;
    private List c;

    public boolean a(m m2) {
        Object object = this.a;
        // MONITORENTER : object
        if (this.c.contains(m2)) {
            // MONITOREXIT : object
            return true;
        }
        // MONITOREXIT : object
        return false;
    }

    public boolean b(m m2) {
        Object object = this.a;
        // MONITORENTER : object
        Iterator iterator = this.c.iterator();
        while (iterator.hasNext()) {
            m m3 = (m)iterator.next();
            if (m2 == m3 || !m3.b().equals(m2.b())) continue;
            iterator.remove();
            // MONITOREXIT : object
            return true;
        }
        // MONITOREXIT : object
        return false;
    }

    public void c(m m2) {
        Object object = this.a;
        // MONITORENTER : object
        if (this.c.size() >= 10) {
            fp.a("Queue is full, current size = " + this.c.size());
            this.c.remove(0);
        }
        int n2 = this.b;
        this.b = n2 + 1;
        m2.a(n2);
        this.c.add(m2);
        // MONITOREXIT : object
        return;
    }
}

