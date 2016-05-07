/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.cg;
import android.support.v7.widget.cq;
import android.support.v7.widget.ff;
import java.util.ArrayList;
import java.util.Iterator;

class ch
implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ cg b;

    ch(cg cg2, ArrayList arrayList) {
        this.b = cg2;
        this.a = arrayList;
    }

    @Override
    public void run() {
        Iterator iterator = this.a.iterator();
        do {
            if (!iterator.hasNext()) {
                this.a.clear();
                cg.a(this.b).remove(this.a);
                return;
            }
            cq cq2 = (cq)iterator.next();
            cg.a(this.b, cq2.a, cq2.b, cq2.c, cq2.d, cq2.e);
        } while (true);
    }
}

