/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.c;

class bt {
    private static final int[] a;

    static {
        int[] arrn = new int[]{c.colorPrimary};
        a = arrn;
    }

    static void a(Context context) {
        TypedArray typedArray = context.obtainStyledAttributes(a);
        boolean bl2 = typedArray.hasValue(0);
        boolean bl3 = false;
        if (!bl2) {
            bl3 = true;
        }
        if (typedArray != null) {
            typedArray.recycle();
        }
        if (!bl3) return;
        throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
    }
}

