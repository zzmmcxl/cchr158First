/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.SystemClock;
import com.google.android.gms.b.me;
import com.google.android.gms.b.mg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class mf {
    public static final boolean a = me.b;
    private final List b = new ArrayList();
    private boolean c = false;

    mf() {
    }

    private long a() {
        if (this.b.size() == 0) {
            return 0;
        }
        long l2 = ((mg)this.b.get((int)0)).c;
        return ((mg)this.b.get((int)(-1 + this.b.size()))).c - l2;
    }

    public void a(String string) {
        // MONITORENTER : this
        this.c = true;
        long l2 = this.a();
        if (l2 <= 0) return;
        long l3 = ((mg)this.b.get((int)0)).c;
        Object[] arrobject = new Object[]{l2, string};
        me.b("(%-4d ms) %s", arrobject);
        Iterator iterator = this.b.iterator();
        long l4 = l3;
        while (iterator.hasNext()) {
            mg mg2 = (mg)iterator.next();
            long l5 = mg2.c;
            Object[] arrobject2 = new Object[]{l5 - l4, mg2.b, mg2.a};
            me.b("(+%-4d) [%2d] %s", arrobject2);
            l4 = l5;
        }
        return;
    }

    public void a(String string, long l2) {
        // MONITORENTER : this
        if (this.c) {
            throw new IllegalStateException("Marker added to finished log");
        }
        this.b.add(new mg(string, l2, SystemClock.elapsedRealtime()));
        // MONITOREXIT : this
        return;
    }

    protected void finalize() {
        if (this.c) return;
        this.a("Request on the loose");
        me.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
    }
}

