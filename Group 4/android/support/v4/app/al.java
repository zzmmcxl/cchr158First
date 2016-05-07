/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.os.Handler;
import android.support.v4.app.ag;
import android.support.v4.app.aj;

class al
implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ aj c;

    al(aj aj2, int n2, int n3) {
        this.c = aj2;
        this.a = n2;
        this.b = n3;
    }

    @Override
    public void run() {
        this.c.a(this.c.o.h(), null, this.a, this.b);
    }
}

