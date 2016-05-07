/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.cu;
import com.google.android.gms.b.hy;
import com.google.android.gms.b.jk;
import com.google.android.gms.b.lt;

class cw
implements Runnable {
    final /* synthetic */ cu a;
    private final hy b;
    private final jk c;
    private final Runnable d;

    public cw(cu cu2, hy hy2, jk jk2, Runnable runnable) {
        this.a = cu2;
        this.b = hy2;
        this.c = jk2;
        this.d = runnable;
    }

    @Override
    public void run() {
        if (this.b.g()) {
            this.b.c("canceled-at-delivery");
            return;
        }
        if (this.c.a()) {
            this.b.a(this.c.a);
        } else {
            this.b.b(this.c.c);
        }
        if (this.c.d) {
            this.b.b("intermediate-response");
        } else {
            this.b.c("done");
        }
        if (this.d == null) return;
        this.d.run();
    }
}

