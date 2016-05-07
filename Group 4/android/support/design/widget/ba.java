/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.Snackbar;
import android.support.design.widget.az;

class ba
implements Runnable {
    final /* synthetic */ az a;

    ba(az az2) {
        this.a = az2;
    }

    @Override
    public void run() {
        Snackbar.b(this.a.a, 3);
    }
}

