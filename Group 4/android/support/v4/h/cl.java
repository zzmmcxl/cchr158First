/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.support.v4.h.bg;
import android.support.v4.h.dw;
import android.support.v4.h.dx;
import android.view.View;
import android.view.WindowInsets;

final class cl
implements View.OnApplyWindowInsetsListener {
    final /* synthetic */ bg a;

    cl(bg bg2) {
        this.a = bg2;
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        dx dx2 = new dx(windowInsets);
        return ((dx)this.a.a(view, dx2)).f();
    }
}

