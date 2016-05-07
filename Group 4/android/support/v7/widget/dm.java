/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.dg;
import android.support.v7.widget.dk;

class dm
implements Runnable {
    final /* synthetic */ dk a;

    private dm(dk dk2) {
        this.a = dk2;
    }

    /* synthetic */ dm(dk dk2, dg dg2) {
        this(dk2);
    }

    @Override
    public void run() {
        dk.b(this.a);
    }
}

