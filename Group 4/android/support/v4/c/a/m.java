/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.c.a;

import android.graphics.drawable.Drawable;
import android.support.v4.c.a.w;

class m {
    public static void a(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static Drawable b(Drawable drawable) {
        if (drawable instanceof w) return drawable;
        return new w(drawable);
    }
}

