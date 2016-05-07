/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.cg;
import android.support.v7.widget.ff;
import java.util.ArrayList;
import java.util.Iterator;

class cj
implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ cg b;

    cj(cg cg2, ArrayList arrayList) {
        this.b = cg2;
        this.a = arrayList;
    }

    @Override
    public void run() {
        Iterator iterator = this.a.iterator();
        do {
            if (!iterator.hasNext()) {
                this.a.clear();
                cg.c(this.b).remove(this.a);
                return;
            }
            ff ff2 = (ff)iterator.next();
            cg.a(this.b, ff2);
        } while (true);
    }
}

