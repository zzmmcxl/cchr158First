/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.c.a;

import android.graphics.drawable.Drawable;
import android.support.v4.c.a.u;

class l {
    public static Drawable a(Drawable drawable) {
        if (drawable instanceof u) return drawable;
        return new u(drawable);
    }
}

