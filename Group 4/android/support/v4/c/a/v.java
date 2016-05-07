/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.c.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a.s;
import android.support.v4.c.a.u;

class v
extends s {
    v(s s2, Resources resources) {
        super(s2, resources);
    }

    @Override
    public Drawable newDrawable(Resources resources) {
        return new u(this, resources);
    }
}

