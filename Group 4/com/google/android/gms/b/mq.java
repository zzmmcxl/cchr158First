/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.mr;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class mq {
    protected static final Comparator a = new mr();
    private List b = new LinkedList();
    private List c = new ArrayList(64);
    private int d = 0;
    private final int e;

    public mq(int n2) {
        this.e = n2;
    }

    private void a() {
        // MONITORENTER : this
        while (this.d > this.e) {
            byte[] arrby = (byte[])this.b.remove(0);
            this.c.remove(arrby);
            this.d -= arrby.length;
        }
        return;
    }

    public void a(byte[] arrby) {
        int n2;
        block7 : {
            // MONITORENTER : this
            if (arrby == null) return;
            int n3 = arrby.length;
            int n4 = this.e;
            if (n3 > n4) {
                return;
            }
            this.b.add(arrby);
            n2 = Collections.binarySearch(this.c, arrby, a);
            if (n2 >= 0) break block7;
            n2 = -1 + (- n2);
        }
        this.c.add(n2, arrby);
        this.d += arrby.length;
        this.a();
        return;
    }

    public byte[] a(int n2) {
        // MONITORENTER : this
        int n3 = 0;
        while (n3 < this.c.size()) {
            byte[] arrby = (byte[])this.c.get(n3);
            if (arrby.length >= n2) {
                this.d -= arrby.length;
                this.c.remove(n3);
                this.b.remove(arrby);
                // MONITOREXIT : this
                return arrby;
            }
            ++n3;
        }
        return new byte[n2];
    }
}

