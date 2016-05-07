/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.b.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.b.a.b;

public final class a {
    public static Drawable a(Resources resources, int n2, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT < 21) return resources.getDrawable(n2);
        return b.a(resources, n2, theme);
    }
}

