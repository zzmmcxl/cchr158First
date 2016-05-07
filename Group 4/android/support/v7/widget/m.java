/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.b.b;
import android.support.v7.view.menu.ad;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.v;
import android.support.v7.view.menu.y;
import android.support.v7.widget.k;
import android.support.v7.widget.p;
import android.support.v7.widget.s;
import android.view.MenuItem;
import android.view.View;

class m
extends v {
    final /* synthetic */ k c;
    private ad d;

    /*
     * Unable to fully structure code
     */
    public m(k var1_1, Context var2_2, ad var3_3) {
        this.c = var1_1;
        super(var2_2, var3_3, null, false, b.actionOverflowMenuStyle);
        this.d = var3_3;
        if (!((android.support.v7.view.menu.m)var3_3.getItem()).j()) {
            var8_4 = k.e(var1_1) == null ? (View)k.f(var1_1) : k.e(var1_1);
            this.a((View)var8_4);
        }
        this.a(var1_1.g);
        var4_5 = var3_3.size();
        var5_6 = 0;
        do {
            var6_7 = false;
            if (var5_6 >= var4_5) ** GOTO lbl16
            var7_8 = var3_3.getItem(var5_6);
            if (var7_8.isVisible() && var7_8.getIcon() != null) {
                var6_7 = true;
lbl16: // 2 sources:
                this.a(var6_7);
                return;
            }
            ++var5_6;
        } while (true);
    }

    @Override
    public void onDismiss() {
        super.onDismiss();
        k.a(this.c, null);
        this.c.h = 0;
    }
}

