/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.support.v4.app.au;
import android.support.v4.app.n;
import android.support.v4.app.s;
import android.support.v4.app.x;
import android.support.v4.g.a;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;

class p
implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ View a;
    final /* synthetic */ Object b;
    final /* synthetic */ ArrayList c;
    final /* synthetic */ s d;
    final /* synthetic */ boolean e;
    final /* synthetic */ x f;
    final /* synthetic */ x g;
    final /* synthetic */ n h;

    p(n n2, View view, Object object, ArrayList arrayList, s s2, boolean bl2, x x2, x x3) {
        this.h = n2;
        this.a = view;
        this.b = object;
        this.c = arrayList;
        this.d = s2;
        this.e = bl2;
        this.f = x2;
        this.g = x3;
    }

    public boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
        if (this.b == null) return true;
        au.a(this.b, this.c);
        this.c.clear();
        a a2 = n.a(this.h, this.d, this.e, this.f);
        au.a(this.b, this.d.d, a2, this.c);
        n.a(this.h, a2, this.d);
        n.a(this.h, this.d, this.f, this.g, this.e, a2);
        return true;
    }
}

