/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.c.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a.r;
import android.support.v4.c.a.s;
import android.support.v4.c.a.v;

class u
extends r {
    u(Drawable drawable) {
        super(drawable);
    }

    u(s s2, Resources resources) {
        super(s2, resources);
    }

    @Override
    protected Drawable a(Drawable.ConstantState constantState, Resources resources) {
        return constantState.newDrawable(resources);
    }

    @Override
    s b() {
        return new v(this.b, null);
    }
}

