/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.c.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a.s;
import android.support.v4.c.a.w;
import android.support.v4.c.a.z;

class y
extends w {
    y(Drawable drawable) {
        super(drawable);
    }

    y(s s2, Resources resources) {
        super(s2, resources);
    }

    @Override
    s b() {
        return new z(this.b, null);
    }

    public boolean isAutoMirrored() {
        return this.c.isAutoMirrored();
    }

    public void setAutoMirrored(boolean bl2) {
        this.c.setAutoMirrored(bl2);
    }
}

