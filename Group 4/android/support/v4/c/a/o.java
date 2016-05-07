/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.c.a;

import android.graphics.drawable.Drawable;
import android.support.v4.c.a.y;

class o {
    public static void a(Drawable drawable, boolean bl2) {
        drawable.setAutoMirrored(bl2);
    }

    public static boolean a(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static Drawable b(Drawable drawable) {
        if (drawable instanceof y) return drawable;
        return new y(drawable);
    }

    public static int c(Drawable drawable) {
        return drawable.getAlpha();
    }
}

