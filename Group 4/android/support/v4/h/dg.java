/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.support.v4.h.dc;
import android.support.v4.h.de;
import android.support.v4.h.dh;
import android.support.v4.h.dn;
import android.support.v4.h.dt;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

class dg
extends de {
    WeakHashMap b = null;

    dg() {
    }

    @Override
    public long a(dc dc2, View view) {
        return dn.a(view);
    }

    @Override
    public void a(dc dc2, View view, float f2) {
        dn.a(view, f2);
    }

    @Override
    public void a(dc dc2, View view, long l2) {
        dn.a(view, l2);
    }

    @Override
    public void a(dc dc2, View view, dt dt2) {
        view.setTag(2113929216, (Object)dt2);
        dn.a(view, new dh(dc2));
    }

    @Override
    public void a(dc dc2, View view, Interpolator interpolator) {
        dn.a(view, interpolator);
    }

    @Override
    public void b(dc dc2, View view) {
        dn.b(view);
    }

    @Override
    public void b(dc dc2, View view, float f2) {
        dn.b(view, f2);
    }

    @Override
    public void b(dc dc2, View view, long l2) {
        dn.b(view, l2);
    }

    @Override
    public void c(dc dc2, View view) {
        dn.c(view);
    }

    @Override
    public void c(dc dc2, View view, float f2) {
        dn.c(view, f2);
    }
}

