/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.support.v4.app.n;
import android.support.v4.app.s;
import android.view.View;
import android.view.ViewTreeObserver;

class q
implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ View a;
    final /* synthetic */ s b;
    final /* synthetic */ int c;
    final /* synthetic */ Object d;
    final /* synthetic */ n e;

    q(n n2, View view, s s2, int n3, Object object) {
        this.e = n2;
        this.a = view;
        this.b = s2;
        this.c = n3;
        this.d = object;
    }

    public boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
        n.a(this.e, this.b, this.c, this.d);
        return true;
    }
}

