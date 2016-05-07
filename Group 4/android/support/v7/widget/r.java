/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.support.v7.b.b;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.v;
import android.support.v7.view.menu.y;
import android.support.v7.widget.k;
import android.support.v7.widget.s;
import android.view.View;

class r
extends v {
    final /* synthetic */ k c;

    public r(k k2, Context context, i i2, View view, boolean bl2) {
        this.c = k2;
        super(context, i2, view, bl2, b.actionOverflowMenuStyle);
        this.a(8388613);
        this.a(k2.g);
    }

    @Override
    public void onDismiss() {
        super.onDismiss();
        if (k.c(this.c) != null) {
            k.d(this.c).close();
        }
        k.a(this.c, null);
    }
}

