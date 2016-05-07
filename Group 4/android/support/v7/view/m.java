/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view;

import android.support.v4.h.du;
import android.support.v7.view.l;
import android.view.View;

class m
extends du {
    final /* synthetic */ l a;
    private boolean b;
    private int c;

    m(l l2) {
        this.a = l2;
        this.b = false;
        this.c = 0;
    }

    void a() {
        this.c = 0;
        this.b = false;
        l.b(this.a);
    }

    @Override
    public void a(View view) {
        if (this.b) {
            return;
        }
        this.b = true;
        if (l.a(this.a) == null) return;
        l.a(this.a).a(null);
    }

    @Override
    public void b(View view) {
        int n2;
        this.c = n2 = 1 + this.c;
        if (n2 != l.c(this.a).size()) return;
        if (l.a(this.a) != null) {
            l.a(this.a).b(null);
        }
        this.a();
    }
}

