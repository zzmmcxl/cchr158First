/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.support.v4.h.bo;
import android.support.v4.widget.a;
import android.support.v4.widget.b;
import android.support.v4.widget.c;

class d
implements Runnable {
    final /* synthetic */ a a;

    private d(a a2) {
        this.a = a2;
    }

    /* synthetic */ d(a a2, b b2) {
        this(a2);
    }

    @Override
    public void run() {
        c c2;
        if (!a.a(this.a)) {
            return;
        }
        if (a.b(this.a)) {
            a.a(this.a, false);
            a.c(this.a).a();
        }
        if ((c2 = a.c(this.a)).c() || !a.d(this.a)) {
            a.b(this.a, false);
            return;
        }
        if (a.e(this.a)) {
            a.c(this.a, false);
            a.f(this.a);
        }
        c2.d();
        int n2 = c2.g();
        int n3 = c2.h();
        this.a.a(n2, n3);
        bo.a(a.g(this.a), this);
    }
}

