/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.df;
import android.support.v7.widget.dk;
import android.support.v7.widget.k;
import android.support.v7.widget.p;
import android.view.View;

class q
extends dk {
    final /* synthetic */ k a;
    final /* synthetic */ p b;

    q(p p2, View view, k k2) {
        this.b = p2;
        this.a = k2;
        super(view);
    }

    @Override
    public df a() {
        if (k.a(this.b.a) != null) return k.a(this.b.a).c();
        return null;
    }

    @Override
    public boolean b() {
        this.b.a.d();
        return true;
    }

    @Override
    public boolean c() {
        if (k.b(this.b.a) != null) {
            return false;
        }
        this.b.a.e();
        return true;
    }
}

