/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.support.v7.a.ae;

class af
implements Runnable {
    final /* synthetic */ ae a;

    af(ae ae2) {
        this.a = ae2;
    }

    @Override
    public void run() {
        if ((1 & ae.a(this.a)) != 0) {
            ae.a(this.a, 0);
        }
        if ((4096 & ae.a(this.a)) != 0) {
            ae.a(this.a, 108);
        }
        ae.a(this.a, false);
        ae.b(this.a, 0);
    }
}

