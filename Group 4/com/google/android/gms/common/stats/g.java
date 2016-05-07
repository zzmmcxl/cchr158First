/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.g.q;
import android.util.Log;

public class g {
    private final long a;
    private final int b;
    private final q c;

    public g() {
        this.a = 60000;
        this.b = 10;
        this.c = new q(10);
    }

    public g(int n2, long l2) {
        this.a = l2;
        this.b = n2;
        this.c = new q();
    }

    private void a(long l2, long l3) {
        int n2 = -1 + this.c.size();
        while (n2 >= 0) {
            if (l3 - (Long)this.c.c(n2) > l2) {
                this.c.d(n2);
            }
            --n2;
        }
    }

    public Long a(String string) {
        long l2 = SystemClock.elapsedRealtime();
        long l3 = this.a;
        // MONITORENTER : this
        while (this.c.size() >= this.b) {
            this.a(l3, l2);
            Log.w((String)"ConnectionTracker", (String)("The max capacity " + this.b + " is not enough. Current durationThreshold is: " + (l3 /= 2)));
        }
        Long l4 = (Long)this.c.put(string, l2);
        // MONITOREXIT : this
        return l4;
    }

    public boolean b(String string) {
        // MONITORENTER : this
        if (this.c.remove(string) == null) return false;
        boolean bl2 = true;
        // MONITOREXIT : this
        return bl2;
    }
}

