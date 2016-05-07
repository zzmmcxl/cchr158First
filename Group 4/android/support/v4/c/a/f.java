/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.c.a;

import android.graphics.drawable.Drawable;
import android.support.v4.c.a.e;
import android.support.v4.c.a.n;

class f
extends e {
    f() {
    }

    @Override
    public void b(Drawable drawable, int n2) {
        n.a(drawable, n2);
    }

    @Override
    public int d(Drawable drawable) {
        int n2 = n.a(drawable);
        if (n2 < 0) return 0;
        return n2;
    }
}

