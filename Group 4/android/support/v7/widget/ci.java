/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.cg;
import android.support.v7.widget.cp;
import java.util.ArrayList;
import java.util.Iterator;

class ci
implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ cg b;

    ci(cg cg2, ArrayList arrayList) {
        this.b = cg2;
        this.a = arrayList;
    }

    @Override
    public void run() {
        Iterator iterator = this.a.iterator();
        do {
            if (!iterator.hasNext()) {
                this.a.clear();
                cg.b(this.b).remove(this.a);
                return;
            }
            cp cp2 = (cp)iterator.next();
            cg.a(this.b, cp2);
        } while (true);
    }
}

