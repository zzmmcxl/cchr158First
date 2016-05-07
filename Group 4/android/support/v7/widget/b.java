/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v4.h.dc;
import android.support.v4.h.dt;
import android.support.v7.widget.a;
import android.view.View;

public class b
implements dt {
    int a;
    final /* synthetic */ a b;
    private boolean c;

    protected b(a a2) {
        this.b = a2;
        this.c = false;
    }

    public b a(dc dc2, int n2) {
        this.b.f = dc2;
        this.a = n2;
        return this;
    }

    @Override
    public void a(View view) {
        a.a(this.b, 0);
        this.c = false;
    }

    @Override
    public void b(View view) {
        if (this.c) {
            return;
        }
        this.b.f = null;
        a.b(this.b, this.a);
    }

    @Override
    public void c(View view) {
        this.c = true;
    }
}

