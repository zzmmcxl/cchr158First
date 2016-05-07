/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.c.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a.r;
import android.support.v4.c.a.s;
import android.support.v4.c.a.x;

class w
extends r {
    w(Drawable drawable) {
        super(drawable);
    }

    w(s s2, Resources resources) {
        super(s2, resources);
    }

    @Override
    s b() {
        return new x(this.b, null);
    }

    public void jumpToCurrentState() {
        this.c.jumpToCurrentState();
    }
}

