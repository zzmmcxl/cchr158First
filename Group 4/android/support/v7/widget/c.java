/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.ActionBarContainer;

class c
extends Drawable {
    final ActionBarContainer a;

    public c(ActionBarContainer actionBarContainer) {
        this.a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (this.a.d) {
            if (this.a.c == null) return;
            this.a.c.draw(canvas);
            return;
        }
        if (this.a.a != null) {
            this.a.a.draw(canvas);
        }
        if (this.a.b == null) return;
        if (!this.a.e) return;
        this.a.b.draw(canvas);
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int n2) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}

