/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.os.Build;
import android.support.v4.h.ah;
import android.support.v4.h.ai;
import android.support.v4.h.aj;
import android.view.ViewGroup;

public final class ag {
    static final ah a;

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            a = new aj();
            return;
        }
        a = new ai();
    }

    public static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return a.a(marginLayoutParams);
    }

    public static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return a.b(marginLayoutParams);
    }
}

