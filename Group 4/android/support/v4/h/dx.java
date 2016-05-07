/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.support.v4.h.dw;
import android.view.WindowInsets;

class dx
extends dw {
    private final WindowInsets a;

    dx(WindowInsets windowInsets) {
        this.a = windowInsets;
    }

    @Override
    public int a() {
        return this.a.getSystemWindowInsetLeft();
    }

    @Override
    public dw a(int n2, int n3, int n4, int n5) {
        return new dx(this.a.replaceSystemWindowInsets(n2, n3, n4, n5));
    }

    @Override
    public int b() {
        return this.a.getSystemWindowInsetTop();
    }

    @Override
    public int c() {
        return this.a.getSystemWindowInsetRight();
    }

    @Override
    public int d() {
        return this.a.getSystemWindowInsetBottom();
    }

    @Override
    public boolean e() {
        return this.a.isConsumed();
    }

    WindowInsets f() {
        return this.a;
    }
}

